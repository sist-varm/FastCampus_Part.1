package org.example;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;

//• 비밀번호는 최소 8자 이상 12자 이하여야 한다.
//• 비밀번호가 8자 미만 또는 12자 초과인 경우 IllegalArgumentException 예외를 발생 시킨다.
//• 경계조건에 대해 테스트 코드를 작성해야 한다. => 8자 이상 12자 이하인 경우 7자와 13자 테스트 필요
public class PasswordValidatorTest {

//    DisplayName은 문서의 역할도 함
    @DisplayName("비밀번호가 최소 8자 이상, 12자 이하면 예외가 발생하지 않는다.")
    @Test
    void validatePasswordTest() {
        assertThatCode(() -> PasswordValidator.validate("examplepwd"))
                .doesNotThrowAnyException();;
//                examplepwd는 8자 이상 12자 이하이기 때문에 예외 발생하지 않는다.
    }

    @DisplayName("비밀번호가 8자 미만 또는 12자 초과하는 경우 IllegalArgumentException 예외가 발생한다.")
    @ParameterizedTest
    @ValueSource(strings = {"aabbccd", "aabbccddeeffg"})
    // ValueSource 사용하면 String password로 사용 가능
    void validatePasswordTest2(String password){
        assertThatCode(() -> PasswordValidator.validate(password))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("비밀번호는 최소 8자 이상 12자 이하여야 합니다.");
//  비밀번호가 8자 이하이기 때문에 예외 발생
    }

}
