package com.example.bookshelf

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FabPosition
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.rememberNavController
import com.example.bookshelf.components.BottomNavigation
import com.example.bookshelf.graphs.RootNavigatorGraph
import com.example.bookshelf.ui.theme.BookshelfTheme

class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BookshelfTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val navController = rememberNavController() // main navigation controller
                    Scaffold(
                        bottomBar = {
                                    BottomNavigation(navController = navController)
                        },
                        floatingActionButton = {
                            FloatingActionButton(onClick = { /*TODO*/ }) {
                                Icon(
                                    painter = painterResource(id = R.drawable.barcode_scanner),
                                    contentDescription = "Barcode Scanner Fab Icon"
                                )
                            }
                        },
                        floatingActionButtonPosition = FabPosition.End,
                        content = { paddingValues -> 
                            Column(modifier = Modifier.padding(paddingValues)) {
                                RootNavigatorGraph(navController)
                            }
                        }
                    )
                }
            }
        }
    }
}
