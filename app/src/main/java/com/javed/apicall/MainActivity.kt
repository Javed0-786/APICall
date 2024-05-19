package com.javed.apicall

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.android.volley.Request
import com.android.volley.RequestQueue
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley

class MainActivity : AppCompatActivity() {
    lateinit var nameField: EditText
    lateinit var emailField: EditText
    lateinit var submit: Button
    lateinit var status: TextView
    lateinit var getBtn: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        nameField = findViewById(R.id.name)
        emailField = findViewById(R.id.email)
        submit = findViewById(R.id.submit)
        status = findViewById(R.id.status)
        getBtn = findViewById(R.id.getData)

        submit.setOnClickListener{
            processdata(nameField.text.toString(), emailField.text.toString())
        }

        getBtn.setOnClickListener{
            val intent = Intent(this, Display::class.java)
            startActivity(intent)
        }

    }

    private fun processdata(name: String, email: String) {
        val urlWithParams = "$URL?name=$name&email=$email"
        val stringReq = StringRequest(
            Request.Method.GET, urlWithParams,
            {
                nameField.setText("")
                emailField.setText("")
                status.text = "Data Inserted Successfully"
            },
            {
                nameField.setText("")
                emailField.setText("")
                status.text = "Error: $it"
            })

        val queue: RequestQueue = Volley.newRequestQueue(this)
        queue.add(stringReq)
    }

    companion object {
        const val URL = "http://10.0.2.2/api/setdata.php";
    }
}