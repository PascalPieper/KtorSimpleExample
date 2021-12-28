package com.TeamLukas.Portfolio.models.dto


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import androidx.annotation.Keep

@Keep
@Serializable
data class Registered(
    @SerialName("age")
    val age: Int? = null,
    @SerialName("date")
    val date: String? = null
)