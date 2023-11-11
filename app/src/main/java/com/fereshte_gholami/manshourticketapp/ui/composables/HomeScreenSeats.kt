package com.fereshte_gholami.manshourticketapp.ui.composables

import androidx.compose.runtime.Composable
import com.fereshte_gholami.manshourticketapp.data.model.SeatState

@Composable
fun HomeScreenSeats(
    seatsPairs: List<Pair<SeatState, SeatState>>,
    onSeatClicked: (id: Int) -> Unit
) {
    SeatLayout(seatPair = seatsPairs, onSeatClicked = onSeatClicked)
    HomeScreenSeatAvailabilitySection()
}