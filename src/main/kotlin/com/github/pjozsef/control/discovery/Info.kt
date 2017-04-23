package com.github.pjozsef.control.discovery

data class Info(
        val name: String,
        val os: String,
        val port: Int,
        val timestamp: Long = System.currentTimeMillis()) {

    companion object {
        fun of(input: String): Info? {
            val split = input.split(",")
            if(split.size==3) {
                val name = split[0]
                val os = split[1]
                val port = split[2].toIntOrNull()
                if(!name.isNullOrBlank() && !os.isNullOrBlank() && port != null){
                    return Info(name, os, port)
                }
            }
            return null
        }
    }
}