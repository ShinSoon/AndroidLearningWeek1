package com.example.helloworldapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.helloworldapp.databinding.ActivitySecondBinding

class SecondActivity : ComponentActivity() {

    private lateinit var binding: ActivitySecondBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //setup view binding
        binding = ActivitySecondBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val intent = intent

        if (intent != null && intent.hasExtra("USER_NAME_EXTRA")) {
            // Retrieve the name from the intent
            val name = intent.getStringExtra("USER_NAME_EXTRA")

            // Update the welcome message TextView
            binding.textViewWelcomeMessage.text = "Welcome, $name!"
        } else {
            // Fallback message if no name was passed
            binding.textViewWelcomeMessage.text = "Welcome, Guest!"
        }


    }
}