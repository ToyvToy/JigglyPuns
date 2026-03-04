package com.example.jigglypuns

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatEditText
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        enableEdgeToEdge()

        setContentView(R.layout.activity_main)

        val buttonStart: Button = findViewById(R.id.btn_start)
        val etName: AppCompatEditText = findViewById(R.id.et_name)

        buttonStart.setOnClickListener {
            if (etName.text.toString().isEmpty()) {
                Toast.makeText(this, "Please Enter Your Name", Toast.LENGTH_SHORT).show()
            } else {
                val intent = Intent(this@MainActivity, QuizQuestionsActivity::class.java)
                startActivity(intent)
                finish()
            }
        }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}