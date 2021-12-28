package com.TeamLukas.Portfolio.di

import com.TeamLukas.Portfolio.datasource.repository.RandomPersonRepository
import com.TeamLukas.Portfolio.ui.MainViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {

    factory {
        RandomPersonRepository(get())
    }

    viewModel {
        MainViewModel(get())
    }
}