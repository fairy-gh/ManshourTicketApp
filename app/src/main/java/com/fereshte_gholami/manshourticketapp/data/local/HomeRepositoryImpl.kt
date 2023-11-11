package com.fereshte_gholami.manshourticketapp.data.local

import com.fereshte_gholami.manshourticketapp.data.model.SeatState

class HomeRepositoryImpl() : HomeRepository {
    override fun getSeatsReservationState(): List<SeatState> = createSeatsReservationList()

    private fun createSeatsReservationList(): List<SeatState> {
        val seatsReservationStateList: MutableList<SeatState> = mutableListOf()
        val reservedSeats = listOf(4, 12, 16, 17, 20, 21, 24, 25, 26, 27)
        for(i in 0..29){
            if(i in reservedSeats)
                seatsReservationStateList.add(SeatState(i, isReserved = true))
            else seatsReservationStateList.add(SeatState(i, isReserved = false))
        }
        /*seatsReservationStateList.add(SeatState(0, isReserved = false))
        seatsReservationStateList.add(SeatState(1, isReserved = false))
        seatsReservationStateList.add(SeatState(2, isReserved = false))
        seatsReservationStateList.add(SeatState(3, isReserved = false))
        seatsReservationStateList.add(SeatState(4, isReserved = true))
        seatsReservationStateList.add(SeatState(5, isReserved = false))
        seatsReservationStateList.add(SeatState(6, isReserved = false))
        seatsReservationStateList.add(SeatState(7, isReserved = false))
        seatsReservationStateList.add(SeatState(8, isReserved = false))
        seatsReservationStateList.add(SeatState(9, isReserved = false))
        seatsReservationStateList.add(SeatState(10, isReserved = false))
        seatsReservationStateList.add(SeatState(11, isReserved = false))
        seatsReservationStateList.add(SeatState(12, isReserved = true))
        seatsReservationStateList.add(SeatState(13, isReserved = false))
        seatsReservationStateList.add(SeatState(14, isReserved = false))
        seatsReservationStateList.add(SeatState(15, isReserved = false))
        seatsReservationStateList.add(SeatState(16, isReserved = true))
        seatsReservationStateList.add(SeatState(17, isReserved = true))
        seatsReservationStateList.add(SeatState(18, isReserved = false))
        seatsReservationStateList.add(SeatState(19, isReserved = false))
        seatsReservationStateList.add(SeatState(20, isReserved = true))
        seatsReservationStateList.add(SeatState(21, isReserved = true))
        seatsReservationStateList.add(SeatState(22, isReserved = false))
        seatsReservationStateList.add(SeatState(23, isReserved = false))
        seatsReservationStateList.add(SeatState(24, isReserved = true))
        seatsReservationStateList.add(SeatState(25, isReserved = true))
        seatsReservationStateList.add(SeatState(26, isReserved = true))
        seatsReservationStateList.add(SeatState(27, isReserved = true))
        seatsReservationStateList.add(SeatState(28, isReserved = false))
        seatsReservationStateList.add(SeatState(29, isReserved = false))*/
        return seatsReservationStateList
    }
}