package com.example.cadastrodelivros

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class BookDetailsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_book_details)

        val titleText = findViewById<TextView>(R.id.detailTitle)
        val authorText = findViewById<TextView>(R.id.detailAuthor)
        val newBookButton = findViewById<Button>(R.id.newBookButton)

        titleText.text = intent.getStringExtra(EXTRA_TITLE).orEmpty()
        authorText.text = intent.getStringExtra(EXTRA_AUTHOR).orEmpty()

        newBookButton.setOnClickListener {
            finish()
        }
    }

    companion object {
        const val EXTRA_TITLE = "book_title"
        const val EXTRA_AUTHOR = "book_author"
    }
}
