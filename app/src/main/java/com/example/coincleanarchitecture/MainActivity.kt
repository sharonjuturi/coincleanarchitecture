package com.example.coincleanarchitecture

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.example.coincleanarchitecture.ui.theme.CoinCleanArchitectureTheme
import com.example.coinscleanarchiture.presentation.CoinListScreen
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint()
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
                }, content = { pading ->
                    // Your content goes here
                    CoinListScreen(paddingValues = pading)
                })

            }
        }
    }
}