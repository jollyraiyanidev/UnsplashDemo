package com.app.demoexample.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.app.demoexample.ui.ui.UnsplashImages
import com.app.demoexample.ui.ui.theme.MyApplicationTheme
import com.app.demoexample.ui.util.User
import com.app.demoexample.ui.util.dummyData
import dagger.hilt.android.AndroidEntryPoint
import dagger.hilt.android.HiltAndroidApp

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyApplicationTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {

                    UnsplashImages()
                }
            }
        }
    }

    @Composable
    fun EachRow(user: User) {
        Card(
            modifier = Modifier
                .padding(
                    horizontal = 8.dp,
                    vertical = 8.dp
                )
                .fillMaxWidth(),
            shape = RoundedCornerShape(CornerSize(10.dp)),

            ) {
            Row(modifier = Modifier.padding(5.dp)) {
                /*  Image(
                          //painter = painterResource(id = R.drawable.dummy_girl),
                          contentDescription = "",
                          modifier = Modifier
                              .padding(8.dp)
                              .size(124.dp)
                              .align(Alignment.CenterVertically)
                              .clip(RoundedCornerShape(10.dp))
                  )*/

                Text(text = user.description, modifier = Modifier.padding(8.dp))
            }
        }
    }

    @Composable
    fun Recyclerview(users: List<User>) {
        LazyColumn {
            items(users) { user ->
                EachRow(user = user)
            }
        }
    }
}

