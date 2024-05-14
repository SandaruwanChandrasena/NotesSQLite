package com.example.notessqlite

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.notessqlite.databinding.ActivityAddNoteBinding
import com.example.notessqlite.databinding.ActivityMainBinding

class AddNoteActivity : AppCompatActivity() {

    private lateinit var binding: ActivityAddNoteBinding
    private lateinit var db : NotesDatabaseHelper

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAddNoteBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Initialize database helper
        db = NotesDatabaseHelper(this)

        // Set up click listener for the save button
        binding.saveButton.setOnClickListener {
            val title = binding.titleEdittext.text.toString()
            val content = binding.contentEditText.text.toString()

            // Create a Note object with the entered title and content
            val note = Note(0,title,content)

            // Insert the note into the database
            db.insertNote(note)

            // Finish the activity (close the AddNoteActivity)
            finish()

            // Show a toast message indicating that the note is saved
            Toast.makeText(this,"Your Task Saved",Toast.LENGTH_SHORT).show()
        }

    }
}