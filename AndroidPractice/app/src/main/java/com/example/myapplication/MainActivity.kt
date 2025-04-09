package com.example.myapplication

import android.os.Bundle
import android.util.Log // Import Log for Button click
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
// Import necessary components and modifiers
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp // Import dp for specifying size units
import com.example.myapplication.ui.theme.MyApplicationTheme
import androidx.compose.material3.Surface

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MyApplicationTheme {
                // Scaffold still provides the basic app structure (like handling padding for system bars)
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ){
                    ShoppingListApp()
                }
            }
        }
    }
}

// Greeting composable remains the same
@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier // Pass modifier through
    )
}

// Preview might need updating if you want it to reflect the Column layout
@Preview(showBackground = true)
@Composable
fun DefaultPreview() { // Renamed preview function for clarity
    MyApplicationTheme {
        // To preview the Column layout, replicate parts of it here
        // Or create a new dedicated composable function for the main screen content
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Greeting(
                name = "Preview User",
                modifier = Modifier.padding(bottom = 8.dp)
            )
            Spacer(modifier = Modifier.height(24.dp))
            Button(onClick = { /* No action in preview */ }) {
                Text("Click Me!")
            }
            Spacer(modifier = Modifier.height(16.dp))
            Text(
                "Modifiers are powerful!",
                modifier = Modifier.padding(4.dp)
            )
        }
    }
}