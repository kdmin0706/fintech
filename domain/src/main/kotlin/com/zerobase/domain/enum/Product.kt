package com.zerobase.domain.enum

enum class Product (
    val productCode: String
){
    PRODUCT_A("001"),
    PRODUCT_B("002"),
    PRODUCT_C("003")
}

fun findProductCode(productCode: String): Product {
    return Product.values()
        .find { o -> o.productCode == productCode
        } ?: throw RuntimeException("no such type");
}