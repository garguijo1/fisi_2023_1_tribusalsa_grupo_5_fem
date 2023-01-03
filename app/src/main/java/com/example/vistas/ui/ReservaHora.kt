package com.example.vistas.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import android.widget.TextView
import com.example.vistas.R

class ReservaHora : AppCompatActivity() {

    private var horaReserva : String = "";

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.fr_reserva_mesa_hora)
        val btn4 = findViewById<Button>(R.id.buttonHora1)
        val btn5 = findViewById<Button>(R.id.buttonHora2)
        val btn6 = findViewById<Button>(R.id.buttonHora3)
        val btn7 = findViewById<Button>(R.id.buttonHora4)
        val btn8 = findViewById<Button>(R.id.buttonHora5)
        val btn9 = findViewById<Button>(R.id.buttonHora6)

        val buttonResMesaHora = findViewById<Button>(R.id.buttonResMesaHora)

        val btnMenos = findViewById<ImageButton>(R.id.imageView5)
        val btnMas = findViewById<ImageButton>(R.id.imageView4)
        val tvCantidad = findViewById<TextView>(R.id.textView2)


        btn4.setOnClickListener { this.horaReserva = "16:00:00" }
        btn5.setOnClickListener { this.horaReserva = "17:00:00" }
        btn6.setOnClickListener { this.horaReserva = "18:00:00" }
        btn7.setOnClickListener { this.horaReserva = "19:00:00" }
        btn8.setOnClickListener { this.horaReserva = "20:00:00" }
        btn9.setOnClickListener { this.horaReserva = "21:00:00" }

        buttonResMesaHora.setOnClickListener {
            println(this.horaReserva)
        }

    }


}