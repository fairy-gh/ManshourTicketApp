package com.fereshte_gholami.manshourticketapp.ui.composables

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.unit.dp
import com.fereshte_gholami.manshourticketapp.data.model.SeatState

@Composable
fun SeatLayout(
    seatPair: List<Pair<SeatState, SeatState>>,
    onSeatClicked: (id: Int) -> Unit
){

    val leftSeatPairList = listOf(0, 3, 6, 9, 12)
    val rightSeatPairIndex = listOf(2, 5, 8, 11, 14)

    LazyVerticalGrid(
        columns = GridCells.Fixed(3),
        contentPadding = PaddingValues(0.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp),
        modifier = Modifier.padding(start = 8.dp, end = 8.dp)
    ){
        items(seatPair.size){ index ->
            when (index){
                in leftSeatPairList -> SeatPairItem(
                    modifier = Modifier.rotate(8f),
                    seatPair = seatPair[index],
                    onSeatClicked = onSeatClicked
                )
                in rightSeatPairIndex -> SeatPairItem(
                    modifier = Modifier.rotate(-8f),
                    seatPair = seatPair[index],
                    onSeatClicked = onSeatClicked
                )
                else -> SeatPairItem(
                    modifier = Modifier.padding(8.dp),
                    seatPair = seatPair[index],
                    onSeatClicked = onSeatClicked
                )
            }
        }
    }

}