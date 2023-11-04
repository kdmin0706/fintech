package com.zerobase.domain.enum

enum class Organization(
    val organizationCode: String
) {
    NONE("00001"),
    ORGANIZATION_ONE("00002"),
    ORGANIZATION_TWO("00003")
}

fun findOrganizationCode(organizationCode: String): Organization {
    return Organization.values()
        .find { o -> o.organizationCode == organizationCode
        } ?: throw RuntimeException("no such type");
}