package br.com.schmidt.estudocompose1

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import br.com.schmidt.estudocompose1.ui.theme.EstudoCompose1Theme

val nameList = arrayListOf("John", "Michael", "Andrew", "Danna")

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MainScreen()
        }
    }
}

@Composable
fun MainScreen() {
    val greetingListState = remember {
        mutableStateListOf("John")
    }

    Column(modifier = Modifier.fillMaxSize(),
    verticalArrangement = Arrangement.SpaceEvenly,
    horizontalAlignment = Alignment.CenterHorizontally) {
        GreetingList(greetingListState) {
            greetingListState.add("New Name")
        }
    }
}

@Composable
fun GreetingList(greetingListState: SnapshotStateList<String>, buttonClick: () -> Unit) {
    greetingListState.forEachIndexed { index, name ->
        Greeting(name = "$name $index")
    }
    Button(onClick = buttonClick) {
        Text(text = "Add New Name")
    }
}

@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!",
    style = MaterialTheme.typography.h5)
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    EstudoCompose1Theme {
        MainScreen()
    }
}