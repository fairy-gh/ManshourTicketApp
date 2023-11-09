package com.fereshte_gholami.manshourticketapp.data.model

import com.google.gson.annotations.SerializedName

data class ResponseModel(
    val status: String
)

data class RequestModel(
    @SerializedName("seat_id") val seatId: String,
    val hour: String,
    val day: String
)