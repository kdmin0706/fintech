package com.zerobase.domain.domain

import com.zerobase.domain.converter.OrganizationConverter
import com.zerobase.domain.converter.ProductConverter
import com.zerobase.domain.enum.Organization
import com.zerobase.domain.enum.Product
import javax.persistence.*

@Entity
@Table(name = "PRODUCT_INFO")
class ProductInfo(

    @Convert(converter = OrganizationConverter::class)
    @Column(name = "org_cd")
    val organizationCode: Organization,

    @Convert(converter = ProductConverter::class)
    @Column(name = "prod_cd")
    val productCode: Product,

    @Column(name = "prod_nm")
    val productName: String,

    @Column(name = "prod_min_intr")
    val productMinInterest: Double,

    @Column(name = "prod_max_intr")
    val productMaxInterest: Double

) {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null
}