package com.fjr619.loginregiscomposenav

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation
import androidx.navigation.compose.rememberNavController
import com.fjr619.loginregiscomposenav.ui.theme.LoginRegisComposeNavTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LoginRegisComposeNavTheme {
                val navController = rememberNavController()
                NavHost(
                    navController = navController,
                    startDestination = "auth") {

                    navigation(route = "auth", startDestination = "register") {
                        composable(route = "register") {
                            Column(modifier = Modifier.fillMaxSize()) {
                                TextField(
                                    label = { Text(text = "email register") },
                                    value = "", onValueChange = {}
                                )
                                
                                Button(onClick = {
                                    //register sukses maka navigate ke home, clear backstack navigation "auth"
                                    navController.navigate("home") {
                                        popUpTo("auth") {
                                            inclusive = true
                                        }
                                    }
                                }) {
                                    Text(text = "register")
                                }
                                
                                Button(onClick = {
                                    //navigate ke login, dengan dismis register, sehingga di stack hanya ada 1 yaitu login
                                    navController.navigate("login") {
                                        popUpTo("register") {
                                            inclusive = true
                                        }
                                    }
                                }) {
                                    Text(text = "login")
                                }
                            }
                        }

                        composable(route = "login") {
                            Column(modifier = Modifier.fillMaxSize()) {
                                TextField(
                                    label = { Text(text = "email login") },
                                    value = "", onValueChange = {}
                                )

                                Button(onClick = {
                                    //login sukses maka navigate ke home, clear backstack navigation "auth"
                                    navController.navigate("home") {
                                        popUpTo("auth") {
                                            inclusive = true
                                        }
                                    }
                                }) {
                                    Text(text = "login")
                                }

                                Button(onClick = {
                                    //navigate ke register, dengan dismis login, sehingga di stack hanya ada 1 yaitu register
                                    navController.navigate("register") {
                                        popUpTo("login") {
                                            inclusive = true
                                        }
                                    }
                                }) {
                                    Text(text = "register")
                                }


                            }
                        }
                    }

                    composable(route = "Home"){
                        Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                            Text(text = "Home")
                        }
                    }
                }
            }
        }
    }
}
