package com.fereshte_gholami.manshourticketapp.data.remote.reservation

import com.fereshte_gholami.manshourticketapp.data.model.RequestModel
import com.fereshte_gholami.manshourticketapp.data.model.ResponseModel
import kotlinx.coroutines.flow.Flow

interface ReservationRepository {
    suspend fun postReservationRequest(request: RequestModel): Flow<ResponseModel>
}