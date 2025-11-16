package com.example.login

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.tooling.preview.Preview
import com.example.login.navigation.NavigationWrapper
import com.example.login.ui.theme.RetoLoginTheme


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        setContent {
            var isDarkTheme by rememberSaveable { mutableStateOf(false) }
            RetoLoginTheme(darkTheme = isDarkTheme) {
                NavigationWrapper(onToggleTheme = { isDarkTheme = !isDarkTheme })
            }
        }
    }
}

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Preview(showBackground = true)
@Composable
fun PreviewMain() {
    var isDarkTheme by rememberSaveable { mutableStateOf(false) }
    RetoLoginTheme(darkTheme = isDarkTheme) {
        NavigationWrapper(onToggleTheme = { isDarkTheme = !isDarkTheme })
    }
}