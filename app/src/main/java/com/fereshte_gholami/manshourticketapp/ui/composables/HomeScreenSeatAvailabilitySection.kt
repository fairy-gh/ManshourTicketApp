package com.fereshte_gholami.manshourticketapp.ui.composables

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.fereshte_gholami.manshourticketapp.R
import com.fereshte_gholami.manshourticketapp.ui.theme.Orange

@Composable
fun HomeScreenSeatAvailabilitySection() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(30.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
    ) {
        SeatsAvailability(circleColor = Color.White, status = stringResource(R.string.available))
        SeatsAvailability(circleColor = Color.DarkGray, status = stringResource(R.string.taken))
        SeatsAvailability(circleColor = Orange, status = stringResource(R.string.selected))
    }
}
