package com.example.myapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable

import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.myapplication.ui.theme.MyApplicationTheme

import java.util.Locale

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val locale = Locale("fa")
        Locale.setDefault(locale)
        val config = resources.configuration
        config.setLocale(locale)
        config.setLayoutDirection(locale)


        setContent {
            AppNavigation()
        }
    }
}

@Composable
fun AppNavigation() {


    val navController = rememberNavController()
    MyApplicationTheme() {
        NavHost(navController = navController, startDestination = "splash") {

            composable("splash") { SplashView(navController) }
            composable("login") { LoginView(navController) }
            composable("home") { HomeView(navController) }
            composable("price") { PriceView(navController) }
            composable ("payment") { PaymentView(navController) }
            // Add more destinations similarly.
        }
    }

}
