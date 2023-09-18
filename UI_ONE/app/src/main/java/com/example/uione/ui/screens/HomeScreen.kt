package com.example.uione.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.uione.R

@Composable
@Preview(showBackground = true, widthDp = 360, heightDp = 640)
fun HomeScreen(
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier,
        content = {
            Card(
                modifier = Modifier
                    .align(Alignment.TopCenter)
                    .fillMaxWidth()
                    .height(173.dp), // TODO: change
                shape = RoundedCornerShape(
                    topStart = 0.dp,
                    topEnd = 0.dp,
                    bottomStart = 6.dp,
                    bottomEnd = 6.dp
                ),
                colors = CardDefaults.cardColors(
                    containerColor = Color(0xFF495DE2)
                ),
                content = { },
            )
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight(),
                content = {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        content = {
                            Card(
                                modifier = Modifier
                                    .padding(16.dp)
                                    .size(48.dp),
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
                        }
                    )
                }
            )
        }
    )
}