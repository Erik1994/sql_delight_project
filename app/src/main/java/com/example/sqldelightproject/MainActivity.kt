package com.example.sqldelightproject

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.sqldelightproject.ui.PersonListScreen
import com.example.sqldelightproject.ui.theme.SQLDelightTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SQLDelightTheme {
                PersonListScreen()
            }
        }
    }
}
