package com.example.nabila_tie_mobile.data.api

import com.example.nabila_tie_mobile.data.model.CatFactModel
import retrofit2.http.GET

interface CatFactApiService {
    @GET("fact")
    suspend fun getCatFact(): CatFactModel
}