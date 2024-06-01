package com.educacionit.myfirstapp.screens.integrator_project.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.educacionit.myfirstapp.R
import com.educacionit.myfirstapp.screens.integrator_project.model.Book

class BooksAdapter(private var bookList: List<Book> = emptyList()) :
    RecyclerView.Adapter<BooksAdapter.BooksViewHolder>() {

        private var onBookClickListener: OnBookClickListener? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BooksViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.book_item, parent, false)
        return BooksViewHolder(itemView)
    }

    fun setOnBookClickListener(onBookClickListener: OnBookClickListener){
        this.onBookClickListener = onBookClickListener
    }
    fun setBooks(updatedBooks: List<Book>){
        this.bookList = updatedBooks
        notifyDataSetChanged()
    }

    override fun getItemCount() = bookList.size

    override fun onBindViewHolder(holder: BooksViewHolder, position: Int) {
        val currentBook = bookList[position]
        holder.bookTitle.text = currentBook.title
        holder.bookAuthor.text = currentBook.author

        holder.itemView.setOnClickListener {
            onBookClickListener?.onBookClicked(currentBook)
        }
    }

    class BooksViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
         var bookTitle: TextView
         var bookAuthor: TextView
        init {
            bookTitle = itemView.findViewById(R.id.book_title)
            bookAuthor = itemView.findViewById(R.id.book_author)
        }
    }

    interface OnBookClickListener{
        fun onBookClicked(book: Book)
    }
}