package com.github.pjozsef.control.controller

class HomeController(
        host: String,
        port: Int,
        client: ControllerService = ServiceFactory.create(host, port)): ControllerService by client