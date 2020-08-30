package com.example.first

import android.content.Context
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        loadData()
        save_button.setOnClickListener(View.OnClickListener {
            saveData()
        })
    }
    // function to save the data in shared preferences
    private fun saveData(){
        val username : String = username.text.toString()
        val password : String = password.text.toString()
        // shared preferences to save the data
        val sharedPref : SharedPreferences = getSharedPreferences("sharedPref",Context.MODE_PRIVATE)
        val editor : SharedPreferences.Editor = sharedPref.edit()
        editor.apply(){
            putString("USERNAME",username)
            putString("PASSWORD",password)

        }.apply()
        Toast.makeText(this,"Data Saved",Toast.LENGTH_SHORT).show()
    }
    // function to echo the data on opening the activity
    private fun loadData(){
        val sharedPref : SharedPreferences = getSharedPreferences("sharedPref",Context.MODE_PRIVATE)
        val savedString : String? = sharedPref.getString("USERNAME",null)
        Toast.makeText(this,"Welcome $savedString",Toast.LENGTH_SHORT).show()

    }
}