package com.github.pjozsef.control.controller

import com.github.pjozsef.control.controller.model.request.Volume
import com.github.pjozsef.control.controller.model.response.SupportedCommands
import io.reactivex.Single
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface ControllerService {
    @GET("healthcheck")
    fun healthCheck(): Single<Response<Void>>

    @GET("command/supported")
    fun supportedCommands(): Single<Response<SupportedCommands>>

    @POST("command/shutdown")
    fun shutdown(): Single<Response<Void>>

    @POST("command/restart")
    fun restart(): Single<Response<Void>>

    @POST("command/suspend")
    fun suspend(): Single<Response<Void>>

    @POST("command/playpause")
    fun playPause(): Single<Response<Void>>

    @POST("command/next")
    fun next(): Single<Response<Void>>

    @POST("command/prev")
    fun previous(): Single<Response<Void>>

    @POST("command/mute")
    fun mute(): Single<Response<Void>>

    @POST("command/volup")
    fun volUp(): Single<Response<Void>>

    @POST("command/voldown")
    fun volDown(): Single<Response<Void>>

    @POST("command/volume")
    fun setVolume(@Body volume: Volume): Single<Response<Void>>
}