package com.example.myapplication

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.absoluteOffset
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Checkbox
import androidx.compose.material3.ExtendedFloatingActionButton
import androidx.compose.material3.FabPosition
import androidx.compose.material3.FloatingActionButtonDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.myapplication.ui.theme.PR_PURPLE
import com.example.myapplication.ui.theme.PR_TEXT_GRAY
import com.example.myapplication.ui.theme.PR_TEXT_GRAY20

@Composable

fun LoginView(navController: NavController) {
    var mobile: String by remember {
        mutableStateOf("")
    }

    Scaffold(
        floatingActionButtonPosition = FabPosition.Center,
        floatingActionButton = {
            ExtendedFloatingActionButton(

                content = { Text(text = "ورود") },
                onClick = { navController.navigate("home") },
                elevation = FloatingActionButtonDefaults.elevation(defaultElevation = 0.dp),
                containerColor = PR_PURPLE,
                contentColor = Color.White,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 20.dp)
            )
        }) { paddingValues ->
        Box(
            modifier = Modifier
                .padding(paddingValues)
                .background(PR_PURPLE)
                .fillMaxWidth()
                .fillMaxHeight()
        ) {
            Image(
                painter = painterResource(id = R.drawable.splash),
                contentDescription = "",
                Modifier
                    .fillMaxWidth()
                    .fillMaxHeight()
                    .absoluteOffset(0.dp, -230.dp)
            )
            Column(
                verticalArrangement = Arrangement.spacedBy(2.dp),
                modifier = Modifier
                    .clip(RoundedCornerShape(topStart = 24.dp, topEnd = 24.dp))
                    .background(Color.White)
                    .fillMaxWidth()
                    .fillMaxHeight(0.55f)
                    .align(Alignment.BottomCenter)
                    .padding(30.dp)
            ) {
                Text(
                    text = "خوش آمدید",
                    fontSize = 20.sp,
                    color = PR_TEXT_GRAY,
                    fontWeight = FontWeight.Black
                )
                Text(
                    text = "لورم ایپسوم متن ساختگی با تولید سادگی نامفهوم از صنعت چاپ و با استفاده از طراحان گرافیک است",
                    fontSize = 15.sp,
                    color = PR_TEXT_GRAY,
                    fontWeight = FontWeight.Light
                )
                Spacer(modifier = Modifier.height(20.dp))
                TextField(
                    value = mobile,
                    onValueChange = { mobile = it },
                    modifier = Modifier.fillMaxWidth(),
                    colors = TextFieldDefaults.colors(),

                    label = {
                        Text(
                            text = "تلفن همراه"
                        )
                    },
                    placeholder = {
                        Text(
                            text = "+98"
                        )
                    },
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Phone)
                )
                Row(
                    horizontalArrangement = Arrangement.Center,
                    verticalAlignment = Alignment.CenterVertically
                ) {

                    Checkbox(checked = true, onCheckedChange = { res -> {} })
                    Text(text = "قوانین و شرایط را خوانده و قبول دارم", color = PR_TEXT_GRAY20)
                }

            }
        }

    }
}