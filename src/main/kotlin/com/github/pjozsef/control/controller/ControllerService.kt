package com.github.pjozsef.control.controller

import io.reactivex.Single
import retrofit2.Response
import retrofit2.http.GET

interface ControllerService {
    @GET("healthcheck")
    fun healthCheck(): Single<Response<Void>>
}