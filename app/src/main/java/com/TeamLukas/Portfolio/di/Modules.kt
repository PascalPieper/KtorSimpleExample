package com.TeamLukas.Portfolio.di

import org.koin.core.module.Module

fun getApplicationModules() : List<Module> = listOf(networkModule, viewModelModule)