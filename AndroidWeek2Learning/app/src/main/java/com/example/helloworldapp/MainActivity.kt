package com.example.helloworldapp

import android.content.Intent
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
import com.example.helloworldapp.databinding.ActivityMainTwoBinding
import android.util.Log

class MainActivity : ComponentActivity() { // Or AppCompatActivity() if you need support for older Android versions

    companion object {
        private val LOG_TAG = MainActivity::class.java.simpleName

        private const val KEY_INFO_TEXT = "MainActivity.InfoText"
    }

    private lateinit var binding: ActivityMainTwoBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // REMOVE: setContentView(R.layout.activity_main_two)

        // ---- View Binding Setup ----
        // 1. Inflate the layout using the static inflate method of the binding class
        binding = ActivityMainTwoBinding.inflate(layoutInflater)

        // 2. Get a reference to the root view of the inflated layout
        val view = binding.root

        // 3. Set the content view of the Activity to be the root view of the binding
        setContentView(view)
        // ---- End View Binding Setup ----

        Log.d(LOG_TAG, "onCreate called")

        // --- STATE RESTORATION ---
        if (savedInstanceState != null) {
            // This block executes ONLY if the Activity is being RECREATED
            Log.d(LOG_TAG, "onCreate: Restoring saved state")

            // Retrieve the saved text using the SAME key used in onSaveInstanceState
            // Use '.getString?' for null safety or check containsKey first
            val savedInfoText = savedInstanceState.getString(KEY_INFO_TEXT)

            // Check if the key actually existed in the bundle
            if (savedInfoText != null) {
                // Restore the retrieved text to the TextView
                binding.textViewItemId2.text = savedInfoText
                Log.d(LOG_TAG, "Restored info text: $savedInfoText")
            } else {
                Log.d(LOG_TAG, "onCreate: Key '$KEY_INFO_TEXT' not found in saved state.")
            }

        } else {
            // This block executes ONLY on the FIRST creation of the Activity
            Log.d(LOG_TAG, "onCreate: No saved state (first creation)")
            // Usually, no action needed here if default state comes from XML/strings.xml
        }
        // --- END STATE RESTORATION

        // --- Now you can access views via 'binding' ---
        // Example: Set initial text (optional)
        // binding.textViewItemId2.text = "Enter your details below"
        // binding.editTextName.hint = "e.g., John Doe"

        // --- Set up listeners (see next step) ---
        setupButtonClick() // Call a function to set up listeners
    }

    override fun onSaveInstanceState(outState: Bundle)
    {
        // 1. Always call the superclass implementation first!
        super.onSaveInstanceState(outState)

        //2. Log that the method was called
        Log.d(LOG_TAG, "onSaveInstanceState called")

        //3. Save the data you need into the 'outState' Bundle
        // Get the current text from the target TextView

        val currentInfoText = binding.textViewItemId2.text.toString()
        //Put the text into the Bundle using your defined key
        outState.putString(KEY_INFO_TEXT, currentInfoText)

        // Optional: Log what you saved for debugging
        Log.d(LOG_TAG, "SAved infor text: $currentInfoText")
    }

    private fun setupButtonClick() {
        binding.buttonSubmit.setOnClickListener { viewClicked ->
            Log.d(LOG_TAG, "Submit Button Clicked!")

            val enteredName = binding.editTextName.text.toString()

            if (enteredName.trim().isEmpty()) { // Check if the entered name IS empty
                Log.d(LOG_TAG, "The text inside the editText is empty")
                binding.editTextName.error = "Please enter your name" // Set error when empty
            } else {
                Log.d(LOG_TAG, "Name entered: $enteredName")

                binding.textViewItemId2.text = "Hello, $enteredName!"
                binding.editTextName.setText("") // Clear the EditText after successful submission (optional)

                Log.d(LOG_TAG, "Starting SecondActivity...")

                // 1. Create an explicit intent
                // Context: this@MainActivity( the current Acitivity instance)
                // Target: SecondActivity:: class.java(the class of the Activity)
                try {
                    //val intent = Intent(this@MainActivity, SecondActivity::class.java)
                    Log.d(LOG_TAG, "About to start SecondActivity")
                    //intent.putExtra("USER_NAME_EXTRA", enteredName)
                    //startActivity(intent)
                    Log.d(LOG_TAG, "SecondActivity started successfully")
                } catch (e: Exception) {
                    Log.e(LOG_TAG, "Error starting SecondActivity", e)
                }
            }
        }
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