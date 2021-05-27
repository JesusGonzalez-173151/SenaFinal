package com.gonzalez.jesus.finanzaspersonales

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_principal_saludo.*

class PrincipalSaludo : AppCompatActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_principal_saludo)


        inicio()
    }

    fun inicio(){

        val handler = Handler()
        handler.postDelayed({ // TODO: Your application init goes here.
            val intent = Intent(this, BienvenidaA::class.java)
            startActivity(intent)
            this.finish()
        }, 4000)

    }
}