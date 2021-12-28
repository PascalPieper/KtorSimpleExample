package com.TeamLukas.Portfolio.database.daos

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.TeamLukas.Portfolio.database.entities.User

import kotlinx.coroutines.flow.Flow

    @Dao
    interface UserDao {

        @Query("SELECT * FROM user")
        fun getUser(): Flow<List<User>>

        @Insert()
        suspend fun insertUser(user: User)

        @Delete
        suspend fun deleteNote(user: User)


    }


