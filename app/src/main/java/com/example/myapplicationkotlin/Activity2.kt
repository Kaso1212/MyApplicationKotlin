package com.example.myapplicationkotlin

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.exponea.sdk.Exponea
import com.exponea.sdk.models.CustomerIds
import com.exponea.sdk.models.PropertiesList

class Activity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_2)
        val intent = intent
        val text = intent.getStringExtra(MainActivity.EXTRA_TEXT)
        val phoneNumber = intent.getStringExtra(MainActivity.EXTRA_NUMBER)
        val textView1 = findViewById<View>(R.id.textview1) as TextView
        val textView2 = findViewById<View>(R.id.textview2) as TextView
        textView1.text = text
        textView2.text = phoneNumber

        // Preparing the data.

        val button =
            findViewById<View>(R.id.button) as Button
        button.setOnClickListener { Exponea.anonymize() }

        val button2 =
            findViewById<View>(R.id.button2) as Button
        button2.setOnClickListener {Exponea.identifyCustomer(
            customerIds = CustomerIds().withId("ippid",text),
            properties = PropertiesList(
                hashMapOf(
                    Pair("phone", phoneNumber),
                    Pair("email", text),
                    Pair("consent", true)
                )
            )
        )
        }

        val button3 =
            findViewById<View>(R.id.button3) as Button
        button3.setOnClickListener { Exponea.identifyCustomer(
            customerIds = CustomerIds().withId("ippid",text),
            properties = PropertiesList(hashMapOf(Pair("consent", false)))
        )
        }
    }

}