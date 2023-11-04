package com.zerobase.api.http

class HttpResponse(
    private val httpResponse: HttpResponseCode
) {
    data class HttpResponseDto(
        val responseCode: String,
        val responseMessage: String
    )

    fun toResponseDto() = HttpResponseDto(
        httpResponse.code,
        httpResponse.message
    )
}