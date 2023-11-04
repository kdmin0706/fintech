package com.zerobase.api.http

import org.springframework.http.HttpStatus

enum class HttpResponseCode(
    val httpStatus: HttpStatus,
    val code: String,
    val message: String
) {
    SUCCESS(HttpStatus.OK, "00", "success");
}