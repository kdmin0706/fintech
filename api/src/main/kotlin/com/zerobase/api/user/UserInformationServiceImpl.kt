package com.zerobase.api.user

import UserInformationDto
import com.zerobase.api.loan.GenerateKey
import com.zerobase.api.loan.encrypt.EncryptComponent
import com.zerobase.api.normal.NormalResponse
import com.zerobase.api.normal.NormalResponseCode
import com.zerobase.domain.repository.UserInfoRepository
import org.springframework.stereotype.Service

@Service
class UserInformationServiceImpl(
    private val userInfoRepository: UserInfoRepository,
    private val generateKey: GenerateKey,
    private val encryptComponent: EncryptComponent
): UserInformationService {
    override fun findUserInfo(
        userInfoRequestDto: UserInformationDto.UserInfoRequestDto
    ): UserInformationDto.UserInfoResponseDto {

        val userKey = generateKey.generateUserKey()

        userInfoRequestDto.userRegistrationNumber =
            encryptComponent.encryptString(userInfoRequestDto.userRegistrationNumber)

        val userInfoDto = userInfoRequestDto.toUserInfoDto(userKey)

        this.userInfoRepository.save(userInfoDto.toEntity())

        val okResponse = NormalResponse(NormalResponseCode.SUCCESS).toResponseDto()

        return UserInformationDto.UserInfoResponseDto(
            UserInformationDto.UserKey(userKey),
            okResponse.responseCode,
            okResponse.responseMessage
        )
    }

    override fun getPrivateInfo(userKey: String)
        : UserPrivateInformationDto.ResponseDto {
        val userInfo = this.userInfoRepository.findByUserKey(userKey)
        val decryptString =
            this.encryptComponent.decryptString(userInfo.userRegistrationNumber)

        val responseDto =
            NormalResponse(NormalResponseCode.SUCCESS).toResponseDto()

        return UserPrivateInformationDto.ResponseDto(
            UserPrivateInformationDto.PrivateData(userKey, decryptString),
            responseDto.responseCode,
            responseDto.responseMessage
        )
    }

}
