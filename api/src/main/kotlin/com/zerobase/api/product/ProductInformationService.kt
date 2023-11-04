package com.zerobase.api.product

import com.zerobase.api.http.HttpResponse
import com.zerobase.domain.enum.Organization

interface ProductInformationService {
    fun saveProduct(productInformationDto: ProductInformationDto.RequestDto)
        : HttpResponse.HttpResponseDto

    fun findProduct(organization: Organization)
        : ProductInformationDto.ResponseDto
}