package com.example.myapplicationkotlin

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.util.Log
import androidx.core.content.ContextCompat.startActivity
import com.exponea.sdk.models.NotificationData
import com.exponea.sdk.services.ExponeaPushReceiver

class MyReceiver : BroadcastReceiver() {
    override fun onReceive(context: Context, intent: Intent) {
        // Extract payload data
        val data = intent.getParcelableExtra<NotificationData>(ExponeaPushReceiver.EXTRA_DATA)
        Log.i("Receiver", "Payload: $data")

        // Act upon push receiving
        val launchIntent = Intent(context, MainActivity::class.java)
        launchIntent.flags = Intent.FLAG_ACTIVITY_NEW_TASK
        startActivity(context, launchIntent, null)
    }
}

