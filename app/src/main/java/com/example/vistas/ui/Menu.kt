package com.example.vistas.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.vistas.R
import com.example.vistas.io.ApiService
import com.example.vistas.io.response.PlatillosResponse
import com.example.vistas.model.PlatilloAdapter
import com.example.vistas.ui.MainActivity.Companion.prefs
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class Menu : AppCompatActivity() {

    private val apiService : ApiService by lazy{
        ApiService.create()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.fr_reserva_carta)

        cargarPlatillos()
    }




    fun cargarPlatillos(){
        val call = apiService.getPlatillos(5,"Bearer ${prefs.getToken()}")
        call.enqueue(object: Callback<PlatillosResponse>{
            override fun onResponse(
                call: Call<PlatillosResponse>,
                response: Response<PlatillosResponse>
            ) {
                println(response)
                if (response.isSuccessful){
                    val recyclerView = findViewById<RecyclerView>(R.id.listDetReserva)
                    recyclerView.layoutManager = LinearLayoutManager(applicationContext)
                    val datos = response.body()
                    if (datos != null) {
                       val data = datos.platillos
                        recyclerView.adapter = PlatilloAdapter(data)
                    }

                    println(datos)
                }
            }

            override fun onFailure(call: Call<PlatillosResponse>, t: Throwable) {
                println("error en la peticion de platillos")
            }

        } )
    }


}