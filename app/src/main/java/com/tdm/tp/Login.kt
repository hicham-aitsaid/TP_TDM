package com.tdm.tp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import java.lang.Exception

class Login : AppCompatActivity() {

    val user = findViewById<EditText>(R.id.user)
    val pass = findViewById<EditText>(R.id.pass)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
    }

    fun logIn(view:View){
    }

    fun signin(user : String, pass : String){

    }
}