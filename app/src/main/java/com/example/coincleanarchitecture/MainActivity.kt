package com.example.coincleanarchitecture

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.ui.graphics.Color
import com.example.coincleanarchitecture.presentation.compose.CoinListScreen
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            setContent {
                Scaffold(topBar = {
                    TopAppBar(
                        title = { Text("CoinsList") },
                        colors = TopAppBarDefaults.mediumTopAppBarColors(
                            containerColor = Color.Gray
                        )
                    )
                }, content = { padding ->
                    // Your content goes here
                    CoinListScreen(paddingValues = padding)
                })

            }
        }
    }
}