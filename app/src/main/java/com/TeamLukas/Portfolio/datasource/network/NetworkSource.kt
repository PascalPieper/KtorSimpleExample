package com.TeamLukas.Portfolio.datasource.network

import com.TeamLukas.Portfolio.models.dto.UserResultDTO

interface NetworkSource {
     suspend fun getUsers(resultCount :Int ) : UserResultDTO
}