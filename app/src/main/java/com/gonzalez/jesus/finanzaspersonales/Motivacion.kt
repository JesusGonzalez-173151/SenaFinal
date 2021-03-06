package com.gonzalez.jesus.finanzaspersonales

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.android.synthetic.main.activity_motivacion.*

class Motivacion : AppCompatActivity() {

    private lateinit var storage: FirebaseFirestore
    private lateinit var usuario: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_motivacion)

        btn_back_c.setOnClickListener{
            val intent = Intent(this, BienvenidaC::class.java)
            startActivity(intent)
            this.finish()
        }

        btn_ahorremos2.setOnClickListener {
            val intent = Intent(this, Pincipal::class.java)
            startActivity(intent)
            this.finish()
        }

        btn_viajar.setOnClickListener{
            val motivo = "viajar"
            guardarMotivo(motivo)
        }

        btn_emprender.setOnClickListener{
            val motivo = "emprender"
            guardarMotivo(motivo)
        }

        btn_otro.setOnClickListener{
            val intent = Intent(this, Motivacion2::class.java)
            startActivity(intent)
            this.finish()
        }

        btn_ropa.setOnClickListener{
            val motivo = "ropa"
            guardarMotivo(motivo)
        }

    }

    private fun guardarMotivo(motivo: String){

        val motivacion = hashMapOf(
            "meta" to motivo,
            "email" to usuario.currentUser?.email
        )


        storage.collection("metas").add(motivacion).addOnSuccessListener {
            Toast.makeText(this,"Motivacion agregada", Toast.LENGTH_SHORT).show()
            val intent: Intent = Intent(this, Pincipal::class.java)
            startActivity(intent)
            //this.finish()
        }.addOnFailureListener {
            Toast.makeText(this,"Error: Intente de Nuevo", Toast.LENGTH_SHORT).show()
        }
    }
}