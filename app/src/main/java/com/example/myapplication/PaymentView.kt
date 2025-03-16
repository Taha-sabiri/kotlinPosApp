package com.example.myapplication

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Info
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.myapplication.ui.theme.PR_LIGHT_ORANGE
import com.example.myapplication.ui.theme.PR_ORANGE
import com.example.myapplication.ui.theme.PR_PURPLE

@Composable
fun PaymentView(navController: NavController) {

    Scaffold(topBar = { CustomAppBar(true, navController) }) { paddingValues ->
        Column(Modifier.padding(paddingValues)) {
            Column(
                Modifier
                    .fillMaxWidth()
                    .padding(20.dp), verticalArrangement = Arrangement.spacedBy(10.dp)
            ) {
                Text(
                    text = "لطفا کارت خود را بکشید",
                    fontSize = 20.sp,
                    color = PR_PURPLE,
                    fontWeight = FontWeight.Black
                )
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(PR_LIGHT_ORANGE, shape = RoundedCornerShape(20.dp))
                        .border(1.dp, PR_ORANGE, shape = RoundedCornerShape(20.dp))
                        .height(60.dp)
                        .padding(20.dp),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(5.dp)
                ) {
                    Icon(
                        imageVector = Icons.Outlined.Info,
                        contentDescription = "",
                        tint = PR_ORANGE
                    )
                    Text(text = "مبلغ خرید شما 150،000،000 میباشد" )
                }

                Image(painterResource(id =  R.drawable.card), contentDescription = "")
            }

        }
    }
}