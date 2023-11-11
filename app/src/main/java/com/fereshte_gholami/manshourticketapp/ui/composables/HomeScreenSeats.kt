package com.fereshte_gholami.manshourticketapp.ui.composables

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.fereshte_gholami.manshourticketapp.data.model.SeatState

@Composable
fun HomeScreenSeats(modifier: Modifier,
                    seatsPairs: List<Pair<SeatState, SeatState>>,
                    onSeatClicked: (id: Int) -> Unit){
    SeatLayout(seatPair = seatsPairs, onSeatClicked = onSeatClicked)
    HomeScreenSeatAvailabilitySection()
}