package com.educacionit.myfirstapp.screens.integrator_project

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.educacionit.myfirstapp.R
import com.educacionit.myfirstapp.screens.integrator_project.model.Book

class AddBookActivity : AppCompatActivity() {
    private lateinit var bookTitleEditText: EditText
    private lateinit var bookAuthorEditText: EditText
    private lateinit var saveBookButton: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_book)
        bookTitleEditText = findViewById(R.id.title_edittext)
        bookAuthorEditText = findViewById(R.id.author_edittext)
        saveBookButton = findViewById(R.id.save_book_button)

        configureViews()
    }

    private fun configureViews() {
        saveBookButton.setOnClickListener {
            saveBook()
        }
    }

    private fun saveBook() {
        val inputTitle = bookTitleEditText.text.toString()
        val inputAuthor = bookAuthorEditText.text.toString()
        if (inputTitle.isEmpty()) {
            Toast.makeText(this, "Ingrese el titulo", Toast.LENGTH_SHORT).show()
            return
        }

        if (inputAuthor.isEmpty()) {
            Toast.makeText(this, "Ingrese el autor", Toast.LENGTH_SHORT).show()
            return
        }

        val newBook = Book(title = inputTitle, author = inputAuthor)

        setResult(Activity.RESULT_OK, Intent().putExtra(NEW_BOOK_EXTRA, newBook))
        finish()
    }


    companion object {
        const val NEW_BOOK_EXTRA = "NEW_BOOK_EXTRA"
    }
}