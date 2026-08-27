package com.example.cadastrodelivros

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val titleInput = findViewById<EditText>(R.id.titleInput)
        val authorInput = findViewById<EditText>(R.id.authorInput)
        val registerButton = findViewById<Button>(R.id.registerButton)

        registerButton.setOnClickListener {
            val title = titleInput.text.toString().trim()
            val author = authorInput.text.toString().trim()

            titleInput.error = null
            authorInput.error = null

            if (title.isEmpty()) {
                titleInput.error = getString(R.string.title_required)
                return@setOnClickListener
            }

            if (author.isEmpty()) {
                authorInput.error = getString(R.string.author_required)
                return@setOnClickListener
            }

            val detailsIntent = Intent(this, BookDetailsActivity::class.java).apply {
                putExtra(BookDetailsActivity.EXTRA_TITLE, title)
                putExtra(BookDetailsActivity.EXTRA_AUTHOR, author)
            }
            startActivity(detailsIntent)
        }
    }
}
