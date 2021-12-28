package com.TeamLukas.Portfolio.models.dto


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import androidx.annotation.Keep

@Keep
@Serializable
data class Timezone(
    @SerialName("description")
    val description: String? = null,
    @SerialName("offset")
    val offset: String? = null
)