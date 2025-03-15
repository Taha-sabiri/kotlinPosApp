package com.example.myapplication

import android.content.ContentValues.TAG
import android.content.Context
import android.net.NetworkCapabilities
import android.net.NetworkRequest
import android.util.Log
import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.myapplication.ui.theme.PR_PURPLE
import com.example.myapplication.utiles.isOnline
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow

@Composable

fun SplashView(navController:NavController) {
    val context = LocalContext.current
    var _isOnline:Boolean by remember { mutableStateOf(false) }

    LaunchedEffect(Unit) {
        delay(5000)
        _isOnline= isOnline(context)
        if (_isOnline){
            navController.navigate("login")
        }else{
            Toast.makeText(context, "No internet connection!", Toast.LENGTH_SHORT).show()
        }
    }

    Scaffold { padding ->
        Column(
            modifier = Modifier
                .padding(padding)
                .fillMaxHeight()
                .fillMaxWidth()
                .background(
                    PR_PURPLE
                ),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Box(contentAlignment= Alignment.Center ,) {
                Image(
                    painter = painterResource(id = R.drawable.splash),
                    contentDescription = "",
                    modifier = Modifier
                        .fillMaxHeight()
                        .fillMaxWidth()
                )
                Image(
                    painter = painterResource(id = R.drawable.logo),
                    contentDescription = "",
                    modifier = Modifier
                        .align(Alignment.BottomCenter)
                        .padding(15.dp)

                )
            }
        }

    }
}