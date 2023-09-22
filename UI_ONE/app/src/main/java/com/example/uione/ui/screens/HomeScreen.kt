package com.example.uione.ui.screens

import androidx.annotation.DrawableRes
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension
import com.example.uione.R
import com.example.uione.data.CustomSharedValues

@Composable
@Preview(showBackground = true, widthDp = 360, heightDp = 600)
fun HomeScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(ScrollState(0)),
        content = {
            TopSection(modifier = Modifier.fillMaxWidth())
            Testimonials(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 16.dp)
            )
            OurServices()
        }
    )
}


@Composable
fun TopSection(modifier: Modifier = Modifier) {
    ConstraintLayout(
        modifier = modifier.wrapContentHeight(),
        content = {
            val (topBar, findATenantText, searchBar, backgroundCard, guide) = createRefs()
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .constrainAs(backgroundCard) {
                        top.linkTo(parent.top)
                        bottom.linkTo(guide.top)
                        bottom.linkTo(guide.top)
                        height = Dimension.fillToConstraints
                    },
                shape = RoundedCornerShape(
                    topStart = 0.dp,
                    topEnd = 0.dp,
                    bottomStart = 6.dp,
                    bottomEnd = 6.dp
                ),
                colors = CardDefaults.cardColors(
                    containerColor = Color(0xFF495DE2)
                ),
                content = {},
            )

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 16.dp)
                    .padding(horizontal = 16.dp)
                    .constrainAs(topBar) {
                        top.linkTo(parent.top)
                        start.linkTo(parent.start)
                        end.linkTo(parent.end)
                    },
                verticalAlignment = Alignment.CenterVertically,
                content = {
                    Card(
                        modifier = Modifier.size(44.dp),
                        colors = CardDefaults.cardColors(
                            containerColor = Color(0xFF4B5EAE)
                        ),
                        content = {
                            Image(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .fillMaxHeight(),
                                painter = painterResource(id = (R.drawable.home_home_icon)),
                                contentDescription = null,
                                contentScale = ContentScale.None
                            )
                        }
                    )
                    Text(
                        modifier = Modifier
                            .weight(1f)
                            .padding(horizontal = 12.dp),
                        fontSize = 18.sp,
                        fontFamily = FontFamily(Font(R.font.work_sans_variable_font_weight)),
                        fontWeight = FontWeight(600),
                        color = Color(0xFFFFFFFF),
                        text = "Hello Ashutosh"
                    )
                    Icon(
                        painter = painterResource(id = R.drawable.home_language_icon),
                        contentDescription = null,
                        tint = Color(0xFFFFFFFF)
                    )
                    Icon(
                        modifier = Modifier.padding(start = 12.dp),
                        painter = painterResource(id = R.drawable.home_notification_bell),
                        contentDescription = null,
                        tint = Color(0xFFFFFFFF)
                    )
                }
            )
            Text(
                modifier = Modifier
                    .padding(top = 8.dp, bottom = 12.dp)
                    .padding(horizontal = 16.dp)
                    .fillMaxWidth()
                    .constrainAs(findATenantText) {
                        top.linkTo(topBar.bottom)
                        start.linkTo(parent.start)
                        end.linkTo(parent.end)
                    },
                fontSize = 14.sp,
                fontFamily = FontFamily(Font(R.font.work_sans_variable_font_weight)),
                text = "\"Find a tenant, share the adventure.\"",
                fontWeight = FontWeight(500),
                color = Color.White
            )
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp)
                    .height(CustomSharedValues.Dim.minTouchSize)
                    .constrainAs(searchBar) {
                        top.linkTo(findATenantText.bottom)
                        start.linkTo(parent.start)
                        end.linkTo(parent.end)
                    }
                    .shadow(
                        elevation = 4.dp,
                        shape = RoundedCornerShape(8.dp)
                    ),
                shape = RoundedCornerShape(8.dp),
                colors = CardDefaults.outlinedCardColors(containerColor = Color.White),
                content = {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .fillMaxHeight(),
                        content = {
                            BasicTextField(
                                modifier = Modifier.weight(1f),
                                value = "",
                                onValueChange = {})
                        }
                    )
                },
            )
            Box(
                modifier = Modifier
                    .size(0.dp)
                    .constrainAs(guide) {
                        top.linkTo(searchBar.top)
                        bottom.linkTo(searchBar.bottom)
                    }
            )
        }
    )
}

@Composable
fun Testimonials(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier,
        content = {
            Text(
                text = "Testimonials",
                style = TextStyle(
                    fontSize = 16.sp,
                    fontFamily = FontFamily(Font(R.font.work_sans_variable_font_weight)),
                    fontWeight = FontWeight(600),
                    color = Color(0xFF181441),
                ),
                modifier = Modifier.padding(horizontal = 16.dp)
            )
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 8.dp)
                    .horizontalScroll(ScrollState(0))
                    .padding(horizontal = 10.dp),
                content = {
                    TestimonialCard()
                    TestimonialCard()
                    TestimonialCard()
                }
            )
        }
    )
}

@Composable
fun TestimonialCard(
    modifier: Modifier = Modifier
        .wrapContentHeight()
        .width(266.dp)
        .padding(horizontal = 6.dp)
) {
    Card(
        modifier = modifier,
        shape = RoundedCornerShape(8.dp),
        colors = CardDefaults.cardColors(containerColor = Color(0xFFF5F5F5)),
        content = {
            ConstraintLayout(
                modifier = Modifier.fillMaxWidth(),
                content = {
                    val (ranking, image, title, subtitle) = createRefs()
                    Card(
                        shape = RoundedCornerShape(bottomStart = 8.dp),
                        modifier = Modifier
                            .constrainAs(ranking) {
                                top.linkTo(parent.top)
                                end.linkTo(parent.end)
                            },
                        content = {
                            Text(
                                text = "1/5",
                                style = TextStyle(
                                    fontSize = 12.sp,
                                    fontFamily = FontFamily(Font(R.font.work_sans_variable_font_weight)),
                                    fontWeight = FontWeight(500),
                                    color = Color(0xFFFFFFFF),
                                ),
                                modifier = Modifier.padding(4.dp)
                            )
                        },
                        colors = CardDefaults.cardColors(containerColor = Color(0xFFE9A847))
                    )
                    Image(
                        painter = painterResource(id = R.drawable.ic_launcher_background),
                        contentDescription = null,
                        contentScale = ContentScale.Crop,
                        modifier = Modifier
                            .width(CustomSharedValues.Dim.minTouchSize)
                            .height(CustomSharedValues.Dim.minTouchSize)
                            .constrainAs(image) {
                                top.linkTo(parent.top)
                                start.linkTo(parent.start)
                                end.linkTo(parent.end)
                            }
                            .padding(top = 8.dp)
                            .clip(CircleShape)
                    )
                    Text(
                        text = "Aksheel Adresha",
                        style = TextStyle(
                            fontSize = 14.sp,
                            fontFamily = FontFamily(Font(R.font.work_sans_variable_font_weight)),
                            fontWeight = FontWeight(500),
                            color = Color(0xBF181441),
                        ),
                        modifier = Modifier
                            .constrainAs(title) {
                                top.linkTo(image.bottom)
                                start.linkTo(parent.start)
                                end.linkTo(parent.end)
                            }
                            .padding(top = 4.dp)
                    )
                    Text(
                        text = "The premium plan helped me to get a flat with a tenant in less than a week",
                        style = TextStyle(
                            fontSize = 12.sp,
                            fontFamily = FontFamily(Font(R.font.work_sans_variable_font_weight)),
                            fontWeight = FontWeight(400),
                            color = Color(0xBF181441),
                            textAlign = TextAlign.Center
                        ),
                        modifier = Modifier
                            .constrainAs(subtitle) {
                                top.linkTo(title.bottom)
                                start.linkTo(parent.start)
                                end.linkTo(parent.end)
                                bottom.linkTo(parent.bottom)
                            }
                            .padding(horizontal = 8.dp)
                            .padding(bottom = 12.dp)
                    )
                }
            )
        }
    )
}


@Composable
fun OurServices(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier,
        content = {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.fillMaxWidth(),
                content = {
                    Text(
                        modifier = Modifier
                            .padding(horizontal = 16.dp)
                            .weight(1f),
                        text = "Our services for you",
                        style = TextStyle(
                            fontSize = 16.sp,
                            fontFamily = FontFamily(Font(R.font.work_sans_variable_font_weight)),
                            fontWeight = FontWeight(600),
                            color = Color(0xFF181441),
                            textAlign = TextAlign.Center,
                        )
                    )
                    Text(
                        text = "See all",
                        style = TextStyle(
                            fontSize = 14.sp,
                            fontFamily = FontFamily(Font(R.font.work_sans_variable_font_weight)),
                            fontWeight = FontWeight(500),
                            color = Color(0xFF495DE2),
                        ),
                    )
                    Image(
                        painter = painterResource(id = R.drawable.see_all_right_arrow),
                        contentDescription = "image description",
                        contentScale = ContentScale.None,
                        modifier = Modifier.padding(end = 16.dp)
                    )
                }
            )
            Divider(
                modifier = Modifier.fillMaxWidth(),
                thickness = 1.dp,
                color = Color(0x26000000)
            )

//            LazyVerticalGrid(
//                columns = GridCells.Fixed(3),
//                content = {
//                    class Sample(
//                        @DrawableRes val id: Int,
//                        val text: String
//                    )
//
//                    val list = mutableListOf(
//                        Sample(R.drawable.home_language_icon, "Legal Papers"),
//                        Sample(R.drawable.home_language_icon, "Legal Papers"),
//                        Sample(R.drawable.home_language_icon, "Mess Services"),
//                        Sample(R.drawable.home_language_icon, "Home cleaning"),
//                        Sample(R.drawable.home_language_icon, "Laundry services"),
//                        Sample(R.drawable.home_language_icon, "Home Painting"),
//                        Sample(R.drawable.home_language_icon, "Electrician services"),
//                    )
////                    items(
////                        items = list
////                    ) {
////                        ServiceCard(painter = painterResource(id = it.id), text = it.text)
////                    }
//                }
//            )
        }
    )
}


@Composable
@Preview(showBackground = true)
fun ServiceCardPrev(
) {
    ServiceCard(
        painter = painterResource(id = R.drawable.home_service_electrician_services),
        text = "sample"
    )
}

@Composable
fun ServiceCard(
    modifier: Modifier = Modifier,
    painter: Painter,
    text: String
) {
    Card(
        modifier = modifier,
        shape = RoundedCornerShape(8.dp),
        border = BorderStroke(width = 1.dp, color = Color(0xFFDEDEDE)),
        colors = CardDefaults.cardColors(containerColor = Color(0x40F2F2F2)),
        content = {
            Column(
                modifier = Modifier.padding(6.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                content = {
                    Image(
                        modifier = Modifier.height(28.dp),
                        painter = painter,
                        contentDescription = null
                    )
                    Text(
                        modifier = Modifier.padding(top = 8.dp),
                        text = text,
                        style = TextStyle(
                            fontSize = 13.sp,
                            fontFamily = FontFamily(Font(R.font.work_sans_variable_font_weight)),
                            fontWeight = FontWeight(500),
                            color = Color(0xBF181441),
                            textAlign = TextAlign.Center,
                        )
                    )
                }
            )
        }
    )
}
