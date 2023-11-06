package com.zerobase.api.product

import com.zerobase.api.normal.NormalResponse
import com.zerobase.domain.enum.Organization

interface ProductInformationService {
    fun saveProduct(productInformationDto: ProductInformationDto.RequestDto)
        : NormalResponse.NormalResponseDto

    fun findProduct(organization: Organization)
        : ProductInformationDto.ResponseDto
}