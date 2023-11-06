package com.zerobase.api.product

import com.zerobase.api.normal.NormalResponse
import com.zerobase.api.normal.NormalResponseCode
import com.zerobase.domain.enum.Organization
import com.zerobase.domain.repository.ProductRepository
import org.springframework.stereotype.Service

@Service
class ProductInformationServiceImpl(
    private val productRepository: ProductRepository

): ProductInformationService  {
    override fun saveProduct(productInformationDto: ProductInformationDto.RequestDto)
        : NormalResponse.NormalResponseDto {
        val productInfo = productInformationDto.toEntity()
        this.productRepository.save(productInfo)

        return NormalResponse(NormalResponseCode.SUCCESS).toResponseDto()
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

        val okResponse = NormalResponse(NormalResponseCode.SUCCESS).toResponseDto()

        return ProductInformationDto.ResponseDto(
            data = data,
            responseCode = okResponse.responseCode,
            responseMessage = okResponse.responseMessage
        )
    }
}