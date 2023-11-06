package com.zerobase.api.normal

import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.ResponseStatus

class NormalResponse(
    private val normalResponseCode: NormalResponseCode
) {
    data class NormalResponseDto(
        val responseStatus: HttpStatus,
        val responseCode: String,
        val responseMessage: String
    )

    fun toResponseDto() = NormalResponseDto(
        normalResponseCode.status,
        normalResponseCode.code,
        normalResponseCode.message
    )
}