import com.zerobase.domain.domain.UserInfo
import com.zerobase.domain.repository.UserInfoRepository
import org.aspectj.lang.annotation.Aspect
import org.aspectj.lang.annotation.Before
import org.springframework.stereotype.Component

@Aspect
@Component
class EncryptAspect {
    @Before("execution(* com.zerobase.domain.repository.UserInfoRepository.save(..)) " +
            "&& args(userInfo) && target(userInfoRepository)")
    fun encryptOnSave(userInfo: UserInfo, userInfoRepository: UserInfoRepository) {
        // MyEntity에 @Encrypt 어노테이션이 붙은 필드를 찾아서 암호화 작업 수행
    }

    @Before("execution(* com.zerobase.domain.repository.UserInfoRepository.find*(..)) " +
            "&& target(userInfoRepository)")
    fun decryptOnFind(userInfoRepository: UserInfoRepository) {
        // 조회 시 암호화된 필드를 복호화
    }
}
