package com.zerobase.api.user

import UserInformationDto

interface UserInformationService {
    fun findUserInfo(
        userInfoRequestDto: UserInformationDto.UserInfoRequestDto
    ): UserInformationDto.UserInfoResponseDto

    fun getPrivateInfo(userKey: String)
        : UserPrivateInformationDto.ResponseDto
}