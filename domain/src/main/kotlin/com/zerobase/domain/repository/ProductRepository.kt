package com.zerobase.domain.repository

import com.zerobase.domain.domain.ProductInfo
import com.zerobase.domain.enum.Organization
import org.springframework.data.jpa.repository.JpaRepository

interface ProductRepository: JpaRepository<ProductInfo, Long>{
    fun findByOrganizationCode(organizationCode: Organization): List<ProductInfo>
}