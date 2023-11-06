package com.zerobase.api.normal

import org.springframework.http.HttpStatus

enum class NormalResponseCode(
    val status: HttpStatus,
    val code: String,
    val message: String
) {
    SUCCESS(HttpStatus.OK,"00", "success");
}