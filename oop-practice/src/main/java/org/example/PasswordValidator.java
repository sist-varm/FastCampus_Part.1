package org.example;

public class PasswordValidator {
    private static final String WRONG_PASSWORD_LENGTH_EXCEPTION_MESSAGE = "비밀번호는 최소 8자 이상 12자 이하여야 합니다.";

    public static void validate(String password){
//  if(password.length() < 8 || password.length()>12) password.length()를 지역함수로 빼는것이 리팩토링
//      테스트코드는 리팩토링 하기가 용이
        int length = password.length();
        if(length < 8 || length >12){
        throw new IllegalArgumentException(WRONG_PASSWORD_LENGTH_EXCEPTION_MESSAGE);
    }

    }
}
