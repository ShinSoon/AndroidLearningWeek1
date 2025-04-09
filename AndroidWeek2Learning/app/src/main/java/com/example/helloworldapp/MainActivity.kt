package com.example.helloworldapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.helloworldapp.ui.theme.HelloWorldAppTheme
import android.util.Log

class MainActivity : ComponentActivity() { // Or AppCompatActivity() if you need support for older Android versions

    companion object {
        private val LOG_TAG = MainActivity::class.java.simpleName
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_two) // Set your XML layout here
        Log.d(LOG_TAG, "onCreate called")
    }

    override fun onStart() {
        super.onStart() // MUST call super!
        Log.d(LOG_TAG, "onStart called")
    }

    override fun onResume() {
        super.onResume() // MUST call super!
        Log.d(LOG_TAG, "onResume called")
    }

    override fun onPause() {
        super.onPause() // MUST call super!
        Log.d(LOG_TAG, "onPause called")
    }

    override fun onStop() {
        super.onStop() // MUST call super!
        Log.d(LOG_TAG, "onStop called")
    }

    override fun onRestart() {
        super.onRestart() // MUST call super!
        Log.d(LOG_TAG, "onRestart called")
    }

    override fun onDestroy() {
        super.onDestroy() // MUST call super!
        Log.d(LOG_TAG, "onDestroy called")
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    HelloWorldAppTheme {
        Greeting("Android")
    }
}