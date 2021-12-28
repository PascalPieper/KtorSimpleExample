package com.TeamLukas.Portfolio.di

import com.TeamLukas.Portfolio.datasource.network.NetworkSource
import com.TeamLukas.Portfolio.datasource.network.RandomUserApi
import org.koin.dsl.module

val networkModule = module {
    single<NetworkSource>{
        RandomUserApi()
    }
}