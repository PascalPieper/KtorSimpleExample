package com.TeamLukas.Portfolio.datasource.repository

import com.TeamLukas.Portfolio.datasource.network.NetworkSource
import com.TeamLukas.Portfolio.models.dto.Name
import com.TeamLukas.Portfolio.models.dto.Result
import com.TeamLukas.Portfolio.models.dto.UserResultDTO
import com.TeamLukas.Portfolio.ui.Person
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class RandomPersonRepository(
    private val randomUserApi: NetworkSource
) {

    fun getUsers(resultListCount: Int ): Flow<List<Person>> = flow {
        val userResultDTO: UserResultDTO = randomUserApi.getUsers(resultListCount)
        val peopleList = mutableListOf<Person>()
        userResultDTO.results?.forEach {
            peopleList.add(
                it.toPerson()
            )
        }
        emit(peopleList)
    }

    private fun Result.toPerson(): Person {
        return Person(
            id = this.id?.value ?: "",
            phoneNumber = this.phone ?: "",
            profilePhotoUrl = this.picture?.thumbnail ?: "",
            fullName = this.name?.getFullName() ?: ""
        )
    }

    private fun Name.getFullName(): String  {
        return "$first $last"
    }

}