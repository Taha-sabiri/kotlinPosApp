package com.example.myapplication

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.KeyboardArrowLeft
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalLayoutDirection
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.LayoutDirection
import androidx.navigation.NavController
import com.example.myapplication.ui.theme.PR_PURPLE


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CustomAppBar(hasNavigation: Boolean = true ,navController: NavController) {
    CompositionLocalProvider(LocalLayoutDirection provides LayoutDirection.Ltr) {

    TopAppBar(title = {
       Row (Modifier.fillMaxWidth(),horizontalArrangement = Arrangement.End ){
           Image(
               painter = painterResource(id = R.drawable.logo),
               contentDescription = ""
           )
       }
    }, colors = TopAppBarDefaults.topAppBarColors(
        containerColor = PR_PURPLE, // Background color
        titleContentColor = Color.White, // Title text color
        navigationIconContentColor = Color.White, // Navigation icon color
        actionIconContentColor = Color.White // Action icons color
    ),
        navigationIcon = {
            if (hasNavigation) {
                IconButton(
                    onClick = { navController.popBackStack()},
                    colors = IconButtonDefaults.iconButtonColors(contentColor = Color.White)
                ) {
                    Icon(imageVector = Icons.Rounded.KeyboardArrowLeft, contentDescription = "Back")
                }
            }
        })
}}