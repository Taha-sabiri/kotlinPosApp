package com.example.myapplication

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.twotone.ShoppingCart
import androidx.compose.material3.ExtendedFloatingActionButton
import androidx.compose.material3.FabPosition
import androidx.compose.material3.FloatingActionButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.myapplication.ui.theme.PR_PURPLE

@Composable
fun PriceView(navController: NavController) {
    Scaffold(floatingActionButtonPosition = FabPosition.Center,
        floatingActionButton = @androidx.compose.runtime.Composable {
            ExtendedFloatingActionButton(

                content = { Text(text = "خرید") },
                onClick = { navController.navigate("payment") },
                elevation = FloatingActionButtonDefaults.elevation(defaultElevation = 0.dp),
                containerColor = PR_PURPLE,
                contentColor = Color.White,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 20.dp)
            )
        },
        topBar = { CustomAppBar(true, navController) }) { paddingValues ->
        Column(Modifier.padding(paddingValues)) {

            Row(
                horizontalArrangement = Arrangement.spacedBy(10.dp),
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.padding(horizontal = 20.dp, vertical = 20.dp)
            ) {
                Icon(
                    imageVector = Icons.TwoTone.ShoppingCart,
                    contentDescription = "",
                    tint = PR_PURPLE
                )
                Column(
                    Modifier
                        .fillMaxWidth()
                ) {
                    Text(
                        text = "خرید کالا",
                        fontWeight = FontWeight.Bold,
                        fontSize = 20.sp,
                        color = PR_PURPLE
                    )
                    Text(text = "لطفا مبلغ کالا را وارد کنید")
                }
            }

            TextField(
                value = TextFieldValue(),
                onValueChange = {},
                modifier = Modifier.fillMaxWidth().padding(horizontal = 20.dp, vertical = 0.dp),
                colors = TextFieldDefaults.colors(),

                label = {
                    Text(
                        text = "مبلغ(ریال)"
                    )
                },
                placeholder = {
                    Text(
                        text = "لطفا مبلغ را وارد کنید ..."
                    )
                },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
            )
        }
    }
}