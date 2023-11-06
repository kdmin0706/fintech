import com.zerobase.domain.domain.UserInfo

class UserInformationDto {
    data class UserInfoDto(
        val userKey: String,
        val userName: String,
        var userRegistrationNumber: String,
        val userIncomeAmount: Long
    ) {
        fun toEntity() =
            UserInfo(
                userKey, userRegistrationNumber, userName, userIncomeAmount
            )
    }

    //요청 DTO
    data class UserInfoRequestDto(
        val userName: String,
        val userIncomeAmount: Long,
        var userRegistrationNumber: String
    ) {
        fun toUserInfoDto(userKey: String) =
            UserInfoDto(
                userKey, userName, userRegistrationNumber, userIncomeAmount
            )
    }

    data class UserKey(
        val userKey: String
    )
    //응답 DTO
    data class UserInfoResponseDto(
        val userKey: UserKey,
        val responseCode: String,
        val responseMessage: String
    )
}