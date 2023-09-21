package com.example.uione.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
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
@Preview(showBackground = true, widthDp = 360, heightDp = 400)
fun m() {
    Column {
        TopSection(modifier = Modifier.fillMaxWidth())
        Testimonials()
    }
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
                )
            )
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .horizontalScroll(ScrollState(0)),
                content = {
                    TODO()
                }
            )
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