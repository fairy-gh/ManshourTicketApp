package com.fereshte_gholami.manshourticketapp.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color.Companion.Black
import com.fereshte_gholami.manshourticketapp.ui.composables.HomeScreenHeader
import com.fereshte_gholami.manshourticketapp.ui.theme.ManshourTicketAppTheme

@Composable
fun HomeScreen(
) {
    ManshourTicketAppTheme {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
            HomeScreenContent(
              onCloseClicked = {}
            )
        }
    }
}

@Composable
fun HomeScreenContent(onCloseClicked: () -> Unit){
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Black)
    ) {
        HomeScreenHeader(
            modifier = Modifier.align(Alignment.TopCenter),
            onCloseClicked = onCloseClicked
        )
 }
}

