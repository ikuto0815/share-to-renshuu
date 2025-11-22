package com.example.sharetorenshuu

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import java.net.URLEncoder
import androidx.core.net.toUri

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val text = intent.getCharSequenceExtra(Intent.EXTRA_PROCESS_TEXT)

        if(text != null){
            val text = URLEncoder.encode(text.toString(), "utf-8")
            val intent = Intent(Intent.ACTION_VIEW)
            intent.data = "https://www.renshuu.org/lookup/vocab/$text#".toUri()
            intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK

            try {
                startActivity(intent)
            } catch (e: android.content.ActivityNotFoundException) {
                Log.d("main", "no activity found :shrug:")
            }

        }

        finish()
    }
}
