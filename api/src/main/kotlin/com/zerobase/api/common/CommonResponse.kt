package com.zerobase.api.common

class CommonResponse(
    private val commonResponseCode: CommonResponseCode
) {
    data class HttpResponseDto(
        val responseCode: String,
        val responseMessage: String
    )

    fun toResponseDto() = HttpResponseDto(
        commonResponseCode.code,
        commonResponseCode.message
    )
}