package com.TeamLukas.Portfolio.viewModel

import android.app.Application
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.TeamLukas.Portfolio.database.entities.Welcome
import com.TeamLukas.Portfolio.webAPI.ktorHttpClient
import com.TeamLukas.Portfolio.webAPI.randomUserAPI
import kotlinx.coroutines.launch
import kotlinx.serialization.json.Json

class MainViewModel (application: Application) : AndroidViewModel(application)
{

    private val internalUser = MutableLiveData("")
    val allUser: LiveData<String> = internalUser
    private val api = randomUserAPI(ktorHttpClient)

   fun loadAllUser(count: Int) {

       viewModelScope.launch {
           internalUser.postValue("")
           val user = api.get(count)
           internalUser.postValue(Json.encodeToString(Welcome.serializer(), user))
       }
   }

   fun resetAllUser() {
       internalUser.postValue("")
   }




}
