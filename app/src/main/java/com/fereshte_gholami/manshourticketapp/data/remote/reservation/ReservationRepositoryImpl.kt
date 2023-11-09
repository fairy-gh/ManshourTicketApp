package com.fereshte_gholami.manshourticketapp.data.remote.reservation

import com.fereshte_gholami.manshourticketapp.data.model.RequestModel
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class ReservationRepositoryImpl @Inject constructor(
    private val reservationApi: ReservationApiService
) : ReservationRepository {

    override suspend fun postReservationRequest(request: RequestModel) =
        flow { emit(reservationApi.postReservationRequest(request)) }

}