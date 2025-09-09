package com.example.appcascaapi.data.remote

import retrofit2.Response
import retrofit2.http.GET

interface ApiService {
    // Endpoint atualizado para a API de gênero musical
    @GET("genre/")
    suspend fun getGenre(): Response<String> // A API retorna uma String diretamente
}
