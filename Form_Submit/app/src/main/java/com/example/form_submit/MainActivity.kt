package com.example.number_select

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.ListView
import android.widget.RadioGroup
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.form_submit.R

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        val listError= arrayListOf("Error")

        var number: Int=0

        var state: Int=0

        val editText = findViewById<EditText>(R.id.editTextNumberSigned)

        editText.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
                TODO()
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                TODO()
            }

            override fun afterTextChanged(s: Editable?) {
                // Thực hiện điều gì đó sau khi văn bản đã thay đổi
                number=editText.text.toString().toInt()
            }
        })

        val radioGroup = findViewById<RadioGroup>(R.id.radioGroup)

        radioGroup.setOnCheckedChangeListener { group, checkedId ->
            when (checkedId) {
                R.id.Even -> {
                    state=1
                }
                R.id.Odd -> {
                    state=2
                }
                R.id.Square-> {
                    state=3
                }
            }
        }
        val myButton: Button = findViewById(R.id.Show)

        // Thiết lập sự kiện click
        myButton.setOnClickListener {
            if (state == 1) {
                // Tạo ArrayAdapter
                var array = generateEvenNumbers(number)
                if (array.size == 0) {
                    val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, listError)
                    val listView: ListView = findViewById(R.id.listview)
                    listView.adapter = adapter
                } else {
                    val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, array)
                    val listView: ListView = findViewById(R.id.listview)
                    listView.adapter = adapter
                }
            } else if (state == 2) {
                // Tạo ArrayAdapter
                var array = generateOddNumbers(number)
                if (array.size == 0) {
                    val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, listError)
                    val listView: ListView = findViewById(R.id.listview)
                    listView.adapter = adapter
                } else {
                    val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, array)
                    val listView: ListView = findViewById(R.id.listview)
                    listView.adapter = adapter
                }

            } else if (state == 3) {
                // Tạo ArrayAdapter
                var array = generateSpuareNumbers(number)
                if (array.size == 0) {
                    val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, listError)
                    val listView: ListView = findViewById(R.id.listview)
                    listView.adapter = adapter
                } else {
                    val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, array)
                    val listView: ListView = findViewById(R.id.listview)
                    listView.adapter = adapter
                }
            }
        }
    }






    fun generateEvenNumbers(n: Int): Array<Int> {
        return (0..n).filter { it % 2 == 0 }.toTypedArray()
    }

    fun generateOddNumbers(n: Int): Array<Int> {
        return (0..n).filter { it % 2 == 1 }.toTypedArray()
    }

    fun generateSpuareNumbers(n: Int): Array<Int> {
        val perfectSquares = mutableListOf<Int>()
        var i = 1
        while (i * i <= n) {
            perfectSquares.add(i * i)
            i++
        }
        return perfectSquares.toTypedArray()
    }
}