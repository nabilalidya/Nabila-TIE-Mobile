package com.example.nabila_tie_mobile.data.api

import com.example.nabila_tie_mobile.data.model.PhotoModel
import retrofit2.http.GET

interface PhotoApiService {
    @GET("list")
    suspend fun getPhotos(): List<PhotoModel>
}