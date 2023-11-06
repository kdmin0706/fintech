package com.zerobase.api.user

import UserInformationDto
import io.swagger.annotations.ApiOperation
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/fintech/v1/user")
class UserInformationController(
    private val userInformationServiceImpl: UserInformationServiceImpl
) {
    @PostMapping("/information")
    @ApiOperation(value = "유저 정보 수신 API", notes = "유저 정보를 받는 API")
    fun postUserInfo(
        @RequestBody userInfoRequestDto: UserInformationDto.UserInfoRequestDto
    ): ResponseEntity<UserInformationDto.UserInfoResponseDto> {
        return ResponseEntity.ok(
            this.userInformationServiceImpl.findUserInfo(userInfoRequestDto)
        )
    }

    @GetMapping("/private-info/{userkey}")
    @ApiOperation(value = "유저 정보 조회 API", notes = "유저 정보 조회하는 API")
    fun getPrivateInfoUserKey(
        @PathVariable userkey: String
    ): ResponseEntity<UserPrivateInformationDto.ResponseDto>{
        return ResponseEntity.ok(
            this.userInformationServiceImpl.getPrivateInfo(userkey)
        )
    }
}