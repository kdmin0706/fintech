package com.zerobase.api.product

import com.zerobase.api.common.CommonResponse
import com.zerobase.domain.enum.Organization

interface ProductInformationService {
    fun saveProduct(productInformationDto: ProductInformationDto.RequestDto)
        : CommonResponse.HttpResponseDto

    fun findProduct(organization: Organization)
        : ProductInformationDto.ResponseDto
}