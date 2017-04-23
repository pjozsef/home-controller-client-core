package com.github.pjozsef.control.controller

import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

class ServiceFactory {
    companion object{
        fun create(host: String, port: Int): ControllerService {
            val retrofit = Retrofit.Builder()
                    .baseUrl("http://$host:$port/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .build()
            return retrofit.create(ControllerService::class.java)
        }
    }
}