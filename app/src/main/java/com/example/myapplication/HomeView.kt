package com.example.myapplication

import android.annotation.SuppressLint
import android.widget.Toast
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Call
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Send
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.filled.Warning
import androidx.compose.material.icons.outlined.Info
import androidx.compose.material.icons.outlined.Settings
import androidx.compose.material.icons.outlined.ShoppingCart
import androidx.compose.material3.DrawerState
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.NavigationDrawerItem
import androidx.compose.material3.OutlinedIconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarDuration
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.myapplication.ui.theme.PR_BLUE
import com.example.myapplication.ui.theme.PR_Green
import com.example.myapplication.ui.theme.PR_LIGHT_BLUE
import com.example.myapplication.ui.theme.PR_LIGHT_Green
import com.example.myapplication.ui.theme.PR_LIGHT_ORANGE
import com.example.myapplication.ui.theme.PR_LIGHT_PURPLE
import com.example.myapplication.ui.theme.PR_ORANGE
import com.example.myapplication.ui.theme.PR_PURPLE
import com.example.myapplication.ui.theme.PR_TEXT_GRAY
import com.example.myapplication.ui.theme.PR_TEXT_GRAY20
import kotlinx.coroutines.launch

@SuppressLint("SuspiciousIndentation")
@Composable

fun HomeView(navController: NavController) {

    val context = LocalContext.current
    val scope = rememberCoroutineScope()
    val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
    val snackbarHostState = remember { SnackbarHostState() }

    ModalNavigationDrawer(

        drawerState = drawerState,
        drawerContent = {
            ModalDrawerSheet {
                Text("منوی حساب کاربری", modifier = Modifier.padding(16.dp))
                NavigationDrawerItem(
                    icon = { Icon(imageVector = Icons.Filled.Settings, contentDescription = "") },
                    label = { Text(text = "تنظیمات") },
                    selected = false,
                    onClick = { /*TODO*/ }
                )
                NavigationDrawerItem(
                    icon = { Icon(imageVector = Icons.Filled.Info, contentDescription = "") },

                    label = { Text(text = "درباره ما") },
                    selected = false,
                    onClick = { /*TODO*/ }
                )
                NavigationDrawerItem(
                    icon = { Icon(imageVector = Icons.Filled.Call, contentDescription = "") },

                    label = { Text(text = "پشتیبانی") },
                    selected = false,
                    onClick = { /*TODO*/ }
                )


                // ...other drawer items
            }
        }
    ) {
        Scaffold(
           snackbarHost = {
                SnackbarHost(hostState = snackbarHostState)
            },
        ) { paddingValues ->
            Column(Modifier.padding(paddingValues)) {

                NavBarSection(drawerState = drawerState)

                Box(
                    Modifier
                        .fillMaxWidth()
                        .fillMaxHeight(0.19f)
                ) {
                    Image(
                        painterResource(id = R.drawable.slider),
                        contentDescription = "",
                        contentScale = ContentScale.Crop
                    )
                }
                Spacer(modifier = Modifier.height(20.dp))
                PopularServiceSection()
                Column(Modifier.padding(20.dp), verticalArrangement = Arrangement.spacedBy(10.dp)) {


                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.SpaceBetween,
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(100.dp)
                            .background(PR_LIGHT_Green, shape = RoundedCornerShape(20.dp))
                            .clickable { navController.navigate("price") }
                            .padding(10.dp)
                    ) {

                        Row(
                            horizontalArrangement = Arrangement.spacedBy(10.dp),
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Icon(
                                imageVector = Icons.Outlined.ShoppingCart,
                                contentDescription = "",
                                tint = PR_Green,
                                modifier = Modifier.size(30.dp)
                            )
                            Column {
                                Text(text = "خرید", fontWeight = FontWeight.Bold, color = PR_Green)
                                Text(text = "برای خرید کالا کلیک کنید")
                            }
                        }

                        Icon(
                            imageVector = Icons.Filled.KeyboardArrowLeft,
                            contentDescription = "",
                            tint = PR_TEXT_GRAY20
                        )

                    }
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.SpaceBetween,
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(100.dp)
                            .background(PR_LIGHT_ORANGE, shape = RoundedCornerShape(20.dp))
                            .clickable {

                            }
                            .padding(10.dp)
                    ) {


                        Row(
                            horizontalArrangement = Arrangement.spacedBy(10.dp),
                            verticalAlignment = Alignment.CenterVertically,

                            ) {
                            Icon(
                                imageVector = Icons.Outlined.Settings,
                                contentDescription = "",
                                tint = PR_ORANGE,
                                modifier = Modifier
                                    .size(30.dp)

                            )
                            Column {
                                Text(
                                    text = "تنظیمات",
                                    fontWeight = FontWeight.Bold,
                                    color = PR_ORANGE
                                )
                                Text(text = "برای تنظیمات حساب خود کلیک کنید")
                            }
                        }

                        Icon(
                            imageVector = Icons.Filled.KeyboardArrowLeft,
                            contentDescription = "",
                            tint = PR_TEXT_GRAY20
                        )

                    }

                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.SpaceBetween,
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(100.dp)
                            .background(PR_LIGHT_BLUE, shape = RoundedCornerShape(20.dp))
                            .clickable {
                              scope.launch {
                                  snackbarHostState.showSnackbar("نسخه شما بروز میباشد", actionLabel = "بستن" , duration = SnackbarDuration.Short)
                              }
                            }
                            .padding(10.dp)
                    ) {


                        Row(
                            horizontalArrangement = Arrangement.spacedBy(10.dp),
                            verticalAlignment = Alignment.CenterVertically,

                            ) {
                            Icon(
                                imageVector = Icons.Outlined.Info,
                                contentDescription = "",
                                tint = PR_BLUE,
                                modifier = Modifier.size(30.dp)
                            )
                            Column {
                                Text(
                                    text = "بروزرسانی",
                                    fontWeight = FontWeight.Bold,
                                    color = PR_BLUE
                                )
                                Text(text = "برای به روزرسانی اپلیکیشن خود کلیک کنید")
                            }
                        }

                        Icon(
                            imageVector = Icons.Filled.KeyboardArrowLeft,
                            contentDescription = "",
                            tint = PR_TEXT_GRAY20
                        )

                    }
                }


            }
        }    // Screen content
    }


}

@Composable
private fun PopularServiceSection() {
    Column(
        Modifier
            .padding(start = 20.dp),
        verticalArrangement = Arrangement.spacedBy(10.dp)
    ) {
        Text(text = "سرویس های پرکاربرد", fontWeight = FontWeight.Bold, color = PR_TEXT_GRAY)
        Row(
            Modifier
                .horizontalScroll(rememberScrollState()),
            horizontalArrangement = Arrangement.spacedBy(20.dp)
        ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.spacedBy(5.dp),

                ) {
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center,
                    modifier = Modifier
                        .size(70.dp)
                        .background(PR_LIGHT_ORANGE, shape = RoundedCornerShape(20.dp))
                ) {
                    Icon(
                        imageVector = Icons.Filled.Send,
                        contentDescription = "",
                        tint = PR_ORANGE
                    )
                }
                Text(text = "خرید شارژ")

            }

            //---------------


            //-------------------------------------------

            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.spacedBy(5.dp),

                ) {
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center,
                    modifier = Modifier
                        .size(70.dp)
                        .background(PR_LIGHT_PURPLE, shape = RoundedCornerShape(20.dp))
                ) {
                    Icon(
                        imageVector = Icons.Filled.Warning,
                        contentDescription = "",
                        tint = PR_PURPLE
                    )
                }
                Text(text = "خلافی خودرو")

            }


            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.spacedBy(5.dp),

                ) {
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center,
                    modifier = Modifier
                        .size(70.dp)
                        .background(PR_LIGHT_Green, shape = RoundedCornerShape(20.dp))
                ) {
                    Icon(
                        imageVector = Icons.Filled.DateRange,
                        contentDescription = "",
                        tint = PR_Green
                    )
                }
                Text(text = " موجودی")

            }

            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.spacedBy(5.dp),

                ) {
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center,
                    modifier = Modifier
                        .size(70.dp)
                        .background(PR_LIGHT_BLUE, shape = RoundedCornerShape(20.dp))
                ) {
                    Icon(
                        imageVector = Icons.Filled.Home,
                        contentDescription = "",
                        tint = PR_BLUE
                    )
                }
                Text(text = "خرید بیمه")

            }
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.spacedBy(5.dp),

                ) {
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center,
                    modifier = Modifier
                        .size(70.dp)
                        .background(PR_LIGHT_Green, shape = RoundedCornerShape(20.dp))
                ) {
                    Icon(
                        imageVector = Icons.Filled.DateRange,
                        contentDescription = "",
                        tint = PR_Green
                    )
                }
                Text(text = " موجودی")

            }
        }
    }
}


@Composable
private fun NavBarSection(drawerState:DrawerState) {
    val scope = rememberCoroutineScope()

    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight(0.1f)
            .padding(horizontal = 20.dp)
    ) {
        Row(
            horizontalArrangement = Arrangement.spacedBy(10.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                imageVector = Icons.Filled.AccountCircle,
                contentDescription = "",
                tint = PR_PURPLE
            )
            Text(
                text = "فروشگاه زنجیره ای کروش",
                fontWeight = FontWeight.Black,
                color = PR_PURPLE
            )
        }

        OutlinedIconButton(
            onClick = { scope.launch { drawerState.open() }},
            // Ensures sharp corners (perfect square)
            modifier = Modifier.size(41.dp),
            shape = RoundedCornerShape(10.dp),
            colors = IconButtonDefaults.outlinedIconButtonColors(contentColor = PR_PURPLE),
            border = BorderStroke(1.dp, PR_PURPLE)
        ) {
            Icon(imageVector = Icons.Filled.Menu, contentDescription = "")
        }
    }
}
