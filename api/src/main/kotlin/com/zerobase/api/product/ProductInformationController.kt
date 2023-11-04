package com.zerobase.api.product

import com.zerobase.api.http.HttpResponse
import com.zerobase.domain.enum.Organization
import io.swagger.annotations.ApiOperation
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/fintech/v1/product")
class ProductInformationController(
    private val productInformationService: ProductInformationService
) {
    @GetMapping("{organizationCode}")
    @ApiOperation(value = "상품 정보 API", notes = "상품 정보를 조회하는 API")
    fun getProduct(
        @PathVariable organizationCode: Organization
    ): ResponseEntity<ProductInformationDto.ResponseDto> {
        return ResponseEntity.ok(productInformationService.findProduct(organizationCode))
    }

    @PostMapping("/information")
    @ApiOperation(value = "상품 정보 수신 API", notes = "금융사로부터 상품 정보를 받는 API")

    fun postProduct(
        @RequestBody productInformationDto: ProductInformationDto.RequestDto
    ): ResponseEntity<HttpResponse.HttpResponseDto> {
        return ResponseEntity.ok(productInformationService.saveProduct(productInformationDto))
    }
}