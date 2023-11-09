package com.fereshte_gholami.manshourticketapp.data.remote.reservation

import com.fereshte_gholami.manshourticketapp.data.model.RequestModel
import com.fereshte_gholami.manshourticketapp.data.model.ResponseModel
import retrofit2.http.Body
import retrofit2.http.POST

interface ReservationApiService {

    @POST("d80d097b-9d1f-4d30-8041-fa98e8eeae70")
    suspend fun postReservationRequest(
        @Body request: RequestModel
    ): ResponseModel

}