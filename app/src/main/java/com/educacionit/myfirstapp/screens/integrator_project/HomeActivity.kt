package com.educacionit.myfirstapp.screens.integrator_project

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.ProgressBar
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.RecyclerView
import com.educacionit.myfirstapp.R
import com.educacionit.myfirstapp.screens.integrator_project.adapters.BooksAdapter
import com.educacionit.myfirstapp.screens.integrator_project.model.Book
import com.educacionit.myfirstapp.screens.integrator_project.model.BooksRepository
import kotlinx.coroutines.launch

class HomeActivity : AppCompatActivity() {
    private lateinit var booksToolbar: Toolbar
    private lateinit var booksRecyclerView: RecyclerView
    private lateinit var booksAdapter: BooksAdapter
    private lateinit var loadingView: ProgressBar
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        booksToolbar = findViewById(R.id.books_toolbar)
        booksRecyclerView = findViewById(R.id.books_recyclerview)
        loadingView = findViewById(R.id.loading_view)

        configureViews()
        getParamsFromIntent()
    }

    private fun configureViews() {
        configureActionBar()
        booksAdapter = BooksAdapter()
        booksRecyclerView.adapter = booksAdapter
        booksAdapter.setOnBookClickListener(object : BooksAdapter.OnBookClickListener {
            override fun onBookClicked(book: Book) {
                Toast.makeText(this@HomeActivity, book.title, Toast.LENGTH_LONG).show()
            }
        })
    }

    override fun onResume() {
        super.onResume()
        lifecycleScope.launch {
            loadingView.visibility = View.VISIBLE
            booksAdapter.setBooks(BooksRepository.geBooks())
            loadingView.visibility = View.GONE
        }
    }

    private fun configureActionBar() {
        setSupportActionBar(booksToolbar)
        actionBar?.setHomeButtonEnabled(true)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.my_books_menu_options, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.add_book_action -> {
                goToAddBookActivity()
            }
        }
        return super.onOptionsItemSelected(item)
    }

    private fun goToAddBookActivity() {
        val addBookActivityIntent = Intent(this@HomeActivity, AddBookActivity::class.java)
        startActivity(addBookActivityIntent)
    }

    private fun getParamsFromIntent() {
        val userObject: User? = intent.extras?.getSerializable(USER_OBJECT_PARAM_KEY) as? User
        userObject?.let {
            showUserMessage("Bienvenido ${it.username} desde un objeto serializable!")
        }
    }

    private fun showUserMessage(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }

    companion object {
        const val USER_PARAM_KEY = "USER_PARAM_KEY"
        const val PASSWORD_PARAM_KEY = "PASSWORD_PARAM_KEY"
        const val USER_OBJECT_PARAM_KEY = "PASSWORD_PARAM_KEY"
    }
}