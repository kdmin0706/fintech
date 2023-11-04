package com.zerobase.domain.converter

import com.zerobase.domain.enum.Organization
import com.zerobase.domain.enum.findOrganizationCode
import java.lang.RuntimeException
import javax.persistence.AttributeConverter

class OrganizationConverter: AttributeConverter<Organization, String> {
    override fun convertToDatabaseColumn(organization: Organization?)
        = organization?.organizationCode ?: throw RuntimeException("code not exist")

    override fun convertToEntityAttribute(name: String)
        = findOrganizationCode(name);
}