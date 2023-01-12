package br.com.schmidt.estudocompose1

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import br.com.schmidt.estudocompose1.ui.theme.EstudoCompose1Theme

val nameList = listOf("John", "Michael", "Andrew", "Danna")

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MainScreen(names = nameList)
        }
    }
}

@Composable
fun MainScreen(names: List<String>) {
    Column {
        names.forEach { name ->
            Greeting(name = name)
        }
    }
}

@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    EstudoCompose1Theme {
        MainScreen(names = nameList)
    }
}