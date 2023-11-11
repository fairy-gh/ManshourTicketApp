package com.fereshte_gholami.manshourticketapp.data.local

import com.fereshte_gholami.manshourticketapp.data.model.SeatState

interface HomeRepository {

    fun getSeatsReservationState(): List<SeatState>
}