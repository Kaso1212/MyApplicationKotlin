package com.example.myapplicationkotlin

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import com.exponea.sdk.Exponea

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Sdk initization
        Exponea.init(this)

        setContentView(R.layout.activity_main)
        val button =
            findViewById<View>(R.id.button) as Button
        button.setOnClickListener { openActivity2() }
    }

    fun openActivity2() {
        val editText1 = findViewById<View>(R.id.UserID) as EditText
        val text = editText1.text.toString()
        val editText2 = findViewById<View>(R.id.userPhone) as EditText
        val phoneNumber = editText2.text.toString()
        val intent = Intent(this, Activity2::class.java)
        intent.putExtra(EXTRA_TEXT, text)
        intent.putExtra(EXTRA_NUMBER, phoneNumber)
        startActivity(intent)
    }

    companion object {
        const val EXTRA_TEXT = "com.example.application.example.EXTRA_TEXT"
        const val EXTRA_NUMBER = "com.example.application.example.EXTRA_NUMBER"
    }
}