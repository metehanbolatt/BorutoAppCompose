package com.metehanbolat.borutoappcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import coil.annotation.ExperimentalCoilApi
import com.google.accompanist.pager.ExperimentalPagerApi
import com.metehanbolat.borutoappcompose.navigation.SetupNavGraph
import com.metehanbolat.borutoappcompose.ui.theme.BorutoAppComposeTheme
import dagger.hilt.android.AndroidEntryPoint

@ExperimentalCoilApi
@ExperimentalAnimationApi
@ExperimentalPagerApi
@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    private lateinit var navController: NavHostController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BorutoAppComposeTheme {
                navController = rememberNavController()
                SetupNavGraph(navController = navController)
            }
        }
    }
}