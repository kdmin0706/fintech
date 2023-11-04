package com.zerobase.api.product

import com.zerobase.domain.domain.ProductInfo
import com.zerobase.domain.enum.findOrganizationCode
import com.zerobase.domain.enum.findProductCode

data class ProductInformationDto(
    val organizationCode : String,
    val productCode: String,
    val productName: String,
    val productMinInterest: Double,
    val productMaxInterest: Double
) {
    data class RequestDto(
        val productInformationDto: ProductInformationDto
    ) {
        fun toEntity(): ProductInfo =
            ProductInfo(
                findOrganizationCode(productInformationDto.organizationCode),
                findProductCode(productInformationDto.productCode),
                productInformationDto.productName,
                productInformationDto.productMinInterest,
                productInformationDto.productMaxInterest
            )
    }

    data class ResponseDto(
        val data: List<ProductInformationDto>,
        val responseCode: String,
        val responseMessage: String
    )
}

