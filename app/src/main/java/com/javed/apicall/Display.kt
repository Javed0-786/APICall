package com.javed.apicall

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.android.volley.Request
import com.android.volley.RequestQueue
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.google.gson.internal.bind.ReflectiveTypeAdapterFactory
import com.google.gson.reflect.TypeToken

class Display : AppCompatActivity() {
    lateinit var recyclerView: RecyclerView
    lateinit var modelList: List<Model>
    lateinit var adapter: MyAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_display)

        recyclerView = findViewById(R.id.recyclerView)

        fetchData()

    }

    private fun fetchData() {
        val stringReq = StringRequest(URL,
            {
                val builder = GsonBuilder()
                val gson = builder.create()
                val modelListType = object : TypeToken<List<Model>>() {}.type
                modelList = gson.fromJson(it, modelListType)

                adapter = MyAdapter(modelList)
                recyclerView.adapter = adapter
                recyclerView.layoutManager = LinearLayoutManager(this)
            },
            {
                Toast.makeText(this, "Error: $it", Toast.LENGTH_SHORT).show()
            })

        val queue: RequestQueue = Volley.newRequestQueue(this)
        queue.add(stringReq)
    }


    companion object {
        const val URL = "http://10.0.2.2/api/json_user_fetch.php";
    }
}