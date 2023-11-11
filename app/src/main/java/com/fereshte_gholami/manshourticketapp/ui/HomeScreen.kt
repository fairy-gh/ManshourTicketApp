package com.fereshte_gholami.manshourticketapp.ui

import android.app.Activity
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color.Companion.Black
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import com.fereshte_gholami.manshourticketapp.data.model.HomeUI
import com.fereshte_gholami.manshourticketapp.ui.composables.HomeScreenHeader
import com.fereshte_gholami.manshourticketapp.ui.composables.HomeScreenSeats
import com.fereshte_gholami.manshourticketapp.ui.theme.ManshourTicketAppTheme

@Composable
fun HomeScreen(
    homeViewModel: HomeViewModel
) {
    val activity = (LocalContext.current as? Activity)
    val homeUI by homeViewModel.seatStateList.collectAsState()
    ManshourTicketAppTheme {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
            HomeScreenContent(
                homeUI,
                onCloseClicked = { activity?.finish() },
                onSeatClicked = homeViewModel::selectSeat
            )
        }
    }
}

@Composable
fun HomeScreenContent(
    homeUI: HomeUI,
    onCloseClicked: () -> Unit,
    onSeatClicked: (id: Int) -> Unit
) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Black)
    ) {
           Column{
               HomeScreenHeader(
                   modifier = Modifier.fillMaxWidth(),
                   onCloseClicked = onCloseClicked
               )
               HomeScreenSeats(
                   modifier = Modifier
                       .fillMaxWidth()
                       .padding(top = 250.dp),
                   seatsPairs = homeUI.seatStateList
                       .chunked(2)
                       .map {
                           it.first() to it.last()
                       },
                   onSeatClicked = onSeatClicked
               )
           }
    }
}

