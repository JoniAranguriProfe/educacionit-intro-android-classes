package com.educacionit.myfirstapp.screens.integrator_project.model

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.withContext

object BooksRepository {
    suspend fun geBooks() = withContext(Dispatchers.IO) {
        delay(3000)
        return@withContext listOf(
            Book(title = "Cien años de soledad", author = "Gabriel García Márquez"),
            Book(title = "El señor de los anillos ", author = "J. R. R. Tolkien"),
            Book(title = "1984", author = "George Orwell"),
            Book(title = "Un mundo feliz", author = "Aldous Huxley."),
            Book(title = "Orgullo y prejuicio", author = "Jane Austen"),
            Book(title = "Crimen y castigo  ", author = "Fiódor Dostoyevski"),
            Book(title = "Don Quijote de La Mancha", author = "Miguel de Cervantes"),
            Book(title = "El principito", author = "Antoine de Saint-Exupéry"),
            Book(title = "Hamlet", author = "William Shakespeare"),
            Book(title = "La Odisea", author = "Homero"),
            Book(title = "Rebelión en la granja", author = "George Orwell")
        )
    }
}