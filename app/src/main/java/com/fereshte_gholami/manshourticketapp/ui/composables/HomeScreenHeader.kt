package com.fereshte_gholami.manshourticketapp.ui.composables

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.drawWithContent
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.drawscope.clipPath
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.fereshte_gholami.manshourticketapp.R

@Composable
fun HomeScreenHeader(modifier: Modifier, onCloseClicked: () -> Unit) {
    Column (
        modifier = modifier.padding(vertical = 12.dp, horizontal = 12.dp),
        ){
        Box(
            modifier = Modifier
                .clip(CircleShape)
                .background(White.copy(alpha = 0.4f))
                .clickable { onCloseClicked() }
        ){
            Icon(
                painter = painterResource(id = R.drawable.ic_close),
                contentDescription = null,
                modifier = Modifier
                    .padding(8.dp)
                    .size(30.dp),
                tint = White,
            )
        }
        Image(painter = painterResource(R.drawable.projector),
            contentDescription = null,
            modifier = Modifier
                .fillMaxWidth()
                .drawWithContent {
                    val path = Path().apply{
                        val yRatio = 0.35f
                        moveTo(0f, size.height * yRatio)
                        lineTo(0f, size.height)
                        quadraticBezierTo(
                            size.width / 2,
                            size.height * 0.6f,
                            size.width,
                            size.height
                        )
                        lineTo(size.width, size.height * yRatio)
                        quadraticBezierTo(
                            size.width / 2,
                            0f,
                            0f,
                            size.height * yRatio)
                    }
                    clipPath(path = path){
                        this@drawWithContent.drawContent()
                    }
                }
                .graphicsLayer { this.rotationX = rotationX },
            contentScale = ContentScale.Fit
        )
    }
}
