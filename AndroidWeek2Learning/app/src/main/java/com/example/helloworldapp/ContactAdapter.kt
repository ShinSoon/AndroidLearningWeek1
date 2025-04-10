package com.example.helloworldapp // Use your package name

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.helloworldapp.databinding.ListItemContactBinding // Import generated binding class for list_item_contact.xml

// 1. Define the Adapter class:
//    - Takes the data list (List<String>) in its constructor.
//    - Extends RecyclerView.Adapter, specifying the custom ViewHolder type.
class ContactAdapter(private val contactList: List<String>) :
    RecyclerView.Adapter<ContactAdapter.ContactViewHolder>() {

    companion object { // Optional: For logging within the adapter
        private val TAG = ContactAdapter::class.java.simpleName
    }

    // 2. Define the Inner ViewHolder class:
    //    - Extends RecyclerView.ViewHolder.
    //    - Constructor takes the ViewBinding object for the item layout.
    //    - Holds references to the views within the item layout (via binding).
    //    - Includes a 'bind' method to update views with data.
    class ContactViewHolder(private val binding: ListItemContactBinding) : RecyclerView.ViewHolder(binding.root) {

        init {
            // Optional: Add listeners here if items need to be clickable
            // itemView.setOnClickListener { /* Handle item click */ }
        }

        // Helper function to bind data to the views held by this ViewHolder
        fun bind(contactName: String) {
            binding.textViewItemName.text = contactName
            // If you had more views (e.g., an ImageView), you'd set them here too
            // binding.imageViewContactIcon.setImageResource(...)
        }
    }

    // --- Implement RecyclerView.Adapter methods ---

    // 3. onCreateViewHolder: Called when RecyclerView needs a new ViewHolder.
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ContactViewHolder {
        // This is where you inflate the XML layout for EACH list item
        Log.d(TAG, "onCreateViewHolder called")
        val inflater = LayoutInflater.from(parent.context)
        // Inflate using the generated ViewBinding class
        val binding = ListItemContactBinding.inflate(inflater, parent, false)
        // Create and return a new ViewHolder instance with the binding
        return ContactViewHolder(binding)
    }

    // 4. onBindViewHolder: Called when RecyclerView wants to display/update an item
    //    at a specific position using an existing (possibly recycled) ViewHolder.
    override fun onBindViewHolder(holder: ContactViewHolder, position: Int) {
        // Get the data item for this position
        val contactName = contactList[position]
        Log.d(TAG, "onBindViewHolder called for position $position: $contactName")
        // Bind the data to the views in the ViewHolder
        holder.bind(contactName)
    }

    // 5. getItemCount: Called by RecyclerView to get the total number of items.
    override fun getItemCount(): Int {
        // Return the size of your data list
        return contactList.size
    }

    /* // --- Alternative ViewHolder using findViewById (Less Recommended) ---
    class ContactViewHolderFindViewById(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val nameTextView: TextView = itemView.findViewById(R.id.textViewItemName)

        fun bind(contactName: String) {
            nameTextView.text = contactName
        }
    }

    // --- Alternative onCreateViewHolder using findViewById ---
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ContactViewHolder {
         Log.d(TAG, "onCreateViewHolder called (findViewById)")
         val inflater = LayoutInflater.from(parent.context)
         val view = inflater.inflate(R.layout.list_item_contact, parent, false)
         return ContactViewHolder(view) // Assuming ContactViewHolder uses findViewById
    }
    */
}