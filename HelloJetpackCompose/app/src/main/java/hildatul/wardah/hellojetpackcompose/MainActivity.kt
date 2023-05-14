package hildatul.wardah.hellojetpackcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import hildatul.wardah.hellojetpackcompose.ui.theme.HelloJetpackComposeTheme

private val sampleName = listOf(
    "Hilda",
    "Bintang",
    "Arya",
    "Denis",
    "Vincent",
    "Rafi",
    "Desta"
)

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            HelloJetpackComposeTheme {
                // A surface container using the 'background' color from the theme
                HelloJetpackComposeApp()
            }
        }
    }
}

@Composable
fun Greeting(name: String) {
    Row(
        modifier = Modifier.padding(8.dp),
        verticalAlignment = Alignment.CenterVertically
    ){
        Image(
            painter = painterResource(R.drawable.img),
            contentDescription = "Logo Jetpack Compose",
            modifier = Modifier.size(80.dp)
        )
        Column {
            Text(
                text = "Hello $name!",
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold,
            )
            Text(text = "Welcome to Dicoding!")
        }
    }

}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    HelloJetpackComposeTheme {
        Greeting("Jetpack Compose")
    }
}

@Composable
fun HelloJetpackComposeApp() = Surface(
    modifier = Modifier.fillMaxSize(),
    color = MaterialTheme.colors.background
) {

GreetingList(sampleName)
}

@Preview(showBackground = true, device = Devices.PIXEL_4)
@Composable
fun HelloJetpackComposeAppPreview() {
    HelloJetpackComposeTheme {
        HelloJetpackComposeApp()
    }
}

@Composable
fun GreetingList(names: List<String>) {
    if (names.isNotEmpty()) {
        Column {
            for (name in names) {
                Greeting(name)
            }
        }

    } else {
        Text("No people to great:(")
    }
}
