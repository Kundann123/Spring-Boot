package com.example.exception

class BadRequestException(override val message: String?) :Exception(message)