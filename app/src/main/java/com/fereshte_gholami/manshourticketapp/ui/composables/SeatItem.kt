package com.fereshte_gholami.manshourticketapp.ui.composables

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color.Companion.DarkGray
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.fereshte_gholami.manshourticketapp.R
import com.fereshte_gholami.manshourticketapp.data.model.SeatState
import com.fereshte_gholami.manshourticketapp.ui.theme.Orange

@Composable
fun SeatItem(
    seatState: SeatState,
    onSeatClicked: (id: Int) -> Unit
){
    Icon(painter = painterResource(id = R.drawable.ic_cinema_seat),
        contentDescription = null,
        tint = when{
            seatState.isReserved -> DarkGray
            seatState.isSelected -> Orange
            else -> White
        },
        modifier = Modifier
            .size(30.dp)
            .clickable(enabled = !seatState.isReserved){
                onSeatClicked(seatState.id)
            }
    )
}