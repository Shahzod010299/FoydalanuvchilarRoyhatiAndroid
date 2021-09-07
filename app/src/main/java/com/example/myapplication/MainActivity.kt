package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.core.view.isVisible
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.adapter.UserAdpater
import com.example.myapplication.models.UserData
import kotlinx.android.synthetic.main.activity_main.*
import java.util.ArrayList

class MainActivity : AppCompatActivity() {
    val data = ArrayList<UserData>()
    private lateinit var adapter: UserAdpater

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val listUser = listOf<String>(
            "Shehroz",
            "Ozodbek",
            "Rukhsora",
            "Shahzoda",
            "Shehroz",
            "Ozodbek",
            "Rukhsora",
            "Shahzoda",
        )
        val listAvatar = listOf<Int>(
            R.drawable.photo_1,
            R.drawable.photo_2,
            R.drawable.photo_3,
            R.drawable.photo_4,
            R.drawable.photo_1,
            R.drawable.photo_2,
            R.drawable.photo_3,
            R.drawable.photo_4
        )
        val listPhoneNumbers = listOf<String>(
            "+998 99 670 03 25",
            "+998 90 322 24 34",
            "+998 94 433 54 65",
            "+998 88 843 33 83",
            "+998 99 670 03 25",
            "+998 90 322 24 34",
            "+998 94 433 54 65",
            "+998 88 843 33 83"
        )

        (0..listUser.size-1).forEach { i ->
            data.add(UserData(listAvatar[i],listUser[i],listPhoneNumbers[i]))
        }

        val recyclerVIew: RecyclerView = findViewById(R.id.my_recycler_view)
        recyclerVIew.layoutManager = LinearLayoutManager(this)
        adapter = UserAdpater(data)
        recyclerVIew.adapter = adapter

        adapter.setOnItemClickListiner { positon ->
            Log.d("MainAcMyTAG",positon.toString())
            data.removeAt(positon)
            recyclerVIew.scheduleLayoutAnimation()
            adapter.notifyDataSetChanged()

            Toast.makeText(this, "user deleted", Toast.LENGTH_SHORT).show()
        }

    }
}