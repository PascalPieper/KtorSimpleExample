package com.TeamLukas.Portfolio.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.flowWithLifecycle
import androidx.lifecycle.lifecycleScope
import org.koin.androidx.viewmodel.ext.android.viewModel
import androidx.recyclerview.widget.LinearLayoutManager
import com.TeamLukas.Portfolio.databinding.ActivityMainBinding
import com.TeamLukas.Portfolio.viewModel.DetailViewModel
import com.TeamLukas.Portfolio.viewModel.SettingsViewModel
import kotlinx.coroutines.launch
import kotlinx.coroutines.flow.collect


class MainActivity : AppCompatActivity() {

    private lateinit var peopleListAdapter: PeopleListAdapter
    private val mainViewModel: MainViewModel by viewModel()

    //private val mainViewModel: MainViewModel by viewModels()
    //private val detailViewModel: DetailViewModel by viewModels()
    //private val cameraViewModel: CameraViewModel by viewModels()
    //private val settingsViewModel: SettingsViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initViews(binding)
        subscribeObservers()
    }

    private fun initViews(binding: ActivityMainBinding) {

        peopleListAdapter = PeopleListAdapter()

        binding.peopleListRv.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = peopleListAdapter
        }
    }

    private fun subscribeObservers() {
        mainViewModel.getRandomUsers(25)
        lifecycleScope.launch {
            mainViewModel
                .peopleListFlow
                .flowWithLifecycle(lifecycle, Lifecycle.State.STARTED)
                .collect {
                    peopleListAdapter.submitList(it)
                }

        }

    }
}