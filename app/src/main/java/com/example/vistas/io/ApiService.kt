package com.example.vistas.io

import com.example.vistas.io.response.LoginResponse
import com.example.vistas.io.response.MensajeResponse
import com.example.vistas.io.response.PlatillosResponse
import com.example.vistas.io.response.SedesResponse
import com.example.vistas.model.UserModel
import com.example.vistas.model.userDTO
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.*


interface ApiService {
    @POST( value = "clientes/login")
    fun postLogin(@Body userDTO : userDTO):
            Call<LoginResponse>

    @POST( value = "clientes/crear")
    fun postCliente(@Body userModel: UserModel ):
            Call<MensajeResponse>

    @Headers("Content-Type: application/json")
    @GET( value = "platillos")
    fun getPlatillos(
        @Query( value = "accion") accion : Int,
        @Header("Authorization") token: String?
    ):  Call<PlatillosResponse>

    @Headers("Content-Type: application/json")
    @GET( value = "sedes")
    fun getSedes(
        @Query( value = "accion") accion : Int,
        @Header("Authorization") token: String?
    ):  Call<SedesResponse>



    companion object Factory{
        private const val BASE_URL = "http://10.0.2.2:9000/api/v1/"
        fun create(): ApiService{
            val retrofit = Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
            return retrofit.create(ApiService::class.java)
        }
    }
}

