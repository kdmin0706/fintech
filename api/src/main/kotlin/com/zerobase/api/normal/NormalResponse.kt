package com.zerobase.api.normal

class NormalResponse(
    private val normalResponseCode: NormalResponseCode
) {
    data class NormalResponseDto(
        val responseCode: String,
        val responseMessage: String
    )

    fun toResponseDto() = NormalResponseDto(
        normalResponseCode.code,
        normalResponseCode.message
    )
}