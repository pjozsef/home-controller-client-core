package com.github.pjozsef.control.controller

import okhttp3.Interceptor
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

class ServiceFactory {
    companion object {
        fun create(host: String, port: Int, secret: String): ControllerService =
                Retrofit.Builder()
                        .baseUrl("http://$host:$port/")
                        .client(okhttp(secret))
                        .addConverterFactory(GsonConverterFactory.create())
                        .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                        .build()
                        .create(ControllerService::class.java)

        private fun okhttp(secret: String): OkHttpClient =
                OkHttpClient.Builder()
                        .addInterceptor(authInterceptor(secret))
                        .build()

        private fun authInterceptor(secret: String) = Interceptor { chain ->
            val newRequest = chain
                    .request()
                    .newBuilder()
                    .addHeader("token", secret)
                    .build()
            chain.proceed(newRequest)
        }
    }
}