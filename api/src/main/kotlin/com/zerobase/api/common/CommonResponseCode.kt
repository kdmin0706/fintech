package com.zerobase.api.common

import org.springframework.http.HttpStatus

enum class CommonResponseCode(
    val httpStatus: HttpStatus,
    val code: String,
    val message: String
) {
    SUCCESS(HttpStatus.OK, "00", "success");
}