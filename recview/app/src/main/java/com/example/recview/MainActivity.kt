package com.example.recview

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.recview.adapters.MessageAdapter
import com.example.recview.models.MessageModel


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_message)

        val messages = mutableListOf<MessageModel>()
        messages.add(MessageModel("me", R.drawable.thumb1, "Hello"))
        messages.add(MessageModel("friend", R.drawable.thumb2, "Hello. How are you?"))
        messages.add(MessageModel("me", R.drawable.thumb1, "I'm fine. Thanks."))
        messages.add(MessageModel("me", R.drawable.thumb1, "And you?"))
        messages.add(MessageModel("friend", R.drawable.thumb2, "I'm fine too."))

        val adapter = MessageAdapter(messages)
        val listMessages = findViewById<ListView>(R.id.list_messages)
        listMessages.adapter = adapter
        }
    }class MessageActivity