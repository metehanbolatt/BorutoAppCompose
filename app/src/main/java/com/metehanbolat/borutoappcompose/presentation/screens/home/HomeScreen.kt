package com.metehanbolat.borutoappcompose.presentation.screens.home

import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.paging.compose.collectAsLazyPagingItems
import com.metehanbolat.borutoappcompose.presentation.components.RatingWidget
import com.metehanbolat.borutoappcompose.ui.theme.LARGE_PADDING

@Composable
fun HomeScreen(
    homeViewModel: HomeViewModel = hiltViewModel()
) {
    val allHeroes = homeViewModel.getAllHeroes.collectAsLazyPagingItems()

    Scaffold(
        topBar = {
            HomeTopBar(onSearchClicked = {

            })
        }
    ) {
        RatingWidget(modifier = Modifier.padding(all = LARGE_PADDING), rating = 4.0)
    }
}