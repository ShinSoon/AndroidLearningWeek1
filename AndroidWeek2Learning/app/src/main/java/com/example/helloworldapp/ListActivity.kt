package com.example.helloworldapp

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.helloworldapp.databinding.ActivityListBinding

class ListActivity : ComponentActivity() {

    private lateinit var binding: ActivityListBinding
    private val TAG = ListActivity::class.java.simpleName


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityListBinding.inflate(layoutInflater)
        setContentView(binding.root)
        Log.d(TAG, "ListActivity onCreate called")

        // --- 1. Create Sample Data Source ---
        val contactNames = mutableListOf<String>()

        // Add plenty of names to test scrolling

        contactNames.add("Alice Smith")
        contactNames.add("Bob Johnson")
        contactNames.add("Charlie Brown")
        contactNames.add("Diana Prince")
        contactNames.add("Ethan Hunt")
        contactNames.add("Fiona Gallagher")
        contactNames.add("Greg House")
        contactNames.add("Hermione Granger")
        contactNames.add("Indiana Jones")
        contactNames.add("Jack Sparrow")
        contactNames.add("Kara Zor-El")
        contactNames.add("Luke Skywalker")
        contactNames.add("Michael Scott")
        contactNames.add("Nakia")
        contactNames.add("Olivia Pope")
        contactNames.add("Peter Parker")
        contactNames.add("Quentin Coldwater")
        contactNames.add("Rachel Green")
        contactNames.add("Sheldon Cooper")
        contactNames.add("Tony Stark")
        contactNames.add("Uhura")
        contactNames.add("Victor Stone")
        contactNames.add("Wanda Maximoff")
        contactNames.add("Xavier")
        contactNames.add("Yara Greyjoy")
        contactNames.add("Zelda Spellman")
        Log.d(TAG, "Created sample data with ${contactNames.size} items.")

        // --- RecyclerView Setup ---

        // --- RecyclerView Setup ---
        Log.d(TAG, "Setting up RecyclerView...")

        // 2. Get a reference to the RecyclerView using View Binding
        //    The ID 'recyclerViewContacts' comes from your activity_list.xml
        val recyclerView: RecyclerView = binding.recyclerViewContacts

        // 3. Create an instance of your ContactAdapter, passing the data list
        val contactAdapter = ContactAdapter(contactNames)

        // 4. Create an instance of LinearLayoutManager
        //    'this' refers to the Activity context
        val layoutManager = LinearLayoutManager(this)

        // --- Connect the pieces to the RecyclerView ---

        // 5. Set the LayoutManager on the RecyclerView
        //    This tells the RecyclerView HOW to arrange items (vertically in this case)
        recyclerView.layoutManager = layoutManager

        // 6. Set the Adapter on the RecyclerView
        //    This tells the RecyclerView WHERE to get item views and data from
        recyclerView.adapter = contactAdapter

        // Optional: Performance Optimization
        // If you know the size of items in the list won't change the RecyclerView's size,
        // this setting can improve performance slightly.
        // recyclerView.setHasFixedSize(true)

        Log.d(TAG, "RecyclerView setup complete.")
        // --- End RecyclerView Setup ---


    }
}