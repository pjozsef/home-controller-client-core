package com.github.pjozsef.control.controller

class HomeController(
        host: String,
        port: Int,
        secret: String,
        client: ControllerService = ServiceFactory.create(host, port, secret)): ControllerService by client