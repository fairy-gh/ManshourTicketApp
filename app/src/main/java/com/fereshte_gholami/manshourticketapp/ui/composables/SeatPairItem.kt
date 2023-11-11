package com.fereshte_gholami.manshourticketapp.ui.composables

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.fereshte_gholami.manshourticketapp.R
import com.fereshte_gholami.manshourticketapp.data.model.SeatState
import com.fereshte_gholami.manshourticketapp.ui.theme.DarkGrey
import com.fereshte_gholami.manshourticketapp.ui.theme.LightOrange

@Composable
fun SeatPairItem(
    modifier: Modifier,
    seatPair: Pair<SeatState, SeatState>,
    onSeatClicked: (id: Int) -> Unit
) {
    Box(
        modifier = modifier,
        contentAlignment = Alignment.Center
    ) {
        Icon(
            painter = painterResource(id = R.drawable.ic_seat_combination),
            contentDescription = null,
            tint =
            if (seatPair.first.isSelected && seatPair.second.isSelected)
                LightOrange
            else
                DarkGrey
        )
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center
        ) {
            SeatItem(seatState = seatPair.first, onSeatClicked = onSeatClicked)
            Spacer(modifier = Modifier.width(6.dp))
            SeatItem(seatState = seatPair.second, onSeatClicked = onSeatClicked)
        }
    }
}
