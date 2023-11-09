package com.fereshte_gholami.manshourticketapp

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.fereshte_gholami.manshourticketapp.ui.theme.ManshourTicketAppTheme

@Composable
fun HomeScreen() {
    ManshourTicketAppTheme {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
        }
    }
}
