package com.zerobase.domain.converter

import com.zerobase.domain.enum.Product
import com.zerobase.domain.enum.findProductCode
import javax.persistence.AttributeConverter

class ProductConverter: AttributeConverter<Product, String> {
    override fun convertToDatabaseColumn(product: Product?)
        = product?.productCode ?: throw RuntimeException("no such code")

    override fun convertToEntityAttribute(name: String)
        = findProductCode(name)
}