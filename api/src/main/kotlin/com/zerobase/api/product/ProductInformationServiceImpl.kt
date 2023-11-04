package com.zerobase.api.product

import com.zerobase.api.http.HttpResponse
import com.zerobase.api.http.HttpResponseCode
import com.zerobase.domain.enum.Organization
import com.zerobase.domain.repository.ProductRepository
import org.springframework.stereotype.Service

@Service
class ProductInformationServiceImpl(
    private val productRepository: ProductRepository

): ProductInformationService  {
    override fun saveProduct(productInformationDto: ProductInformationDto.RequestDto)
        : HttpResponse.HttpResponseDto {
        val productInfo = productInformationDto.toEntity();
        this.productRepository.save(productInfo);

        return HttpResponse(HttpResponseCode.SUCCESS).toResponseDto();
    }

    override fun findProduct(organization: Organization)
        : ProductInformationDto.ResponseDto {
        val data: ArrayList<ProductInformationDto>
            = ArrayList()

        this.productRepository
            .findByOrganizationCode(organization)
            .forEach {
                p -> data.add(
                ProductInformationDto(
                        p.organizationCode.organizationCode,
                        p.productCode.productCode,
                        p.productName,
                        p.productMinInterest,
                        p.productMaxInterest
                    )
                )
            }

        val okResponse = HttpResponse(HttpResponseCode.SUCCESS).toResponseDto()

        return ProductInformationDto.ResponseDto(
            data = data,
            responseCode = okResponse.responseCode,
            responseMessage = okResponse.responseMessage
        )
    }
}