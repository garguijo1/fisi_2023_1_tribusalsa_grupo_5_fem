package com.example.vistas.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import com.example.vistas.R
import com.example.vistas.ui.MainActivity.Companion.prefs

class Inicio : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.fr_reserva_mesa_fecha)
        cargarNombre()

        val botonMenu: Button = findViewById(R.id.buttonMenu)

        botonMenu.setOnClickListener {
            gotoMenu()
        }


    }

    fun cargarNombre(){
        val userName = findViewById<TextView>(R.id.nombreCliente)
        val nombre = prefs.getName()
        userName.setText(nombre)
    }

    fun gotoMenu(){
        val intent = Intent(applicationContext, Menu::class.java)
        startActivity(intent)
    }
}