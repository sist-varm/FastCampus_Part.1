package org.example;

public class User {
    private String password;

//    RandomPasswordGenerator 사용하면 매번 랜덤으로 발생하는 비밀번호에 조건에 맞지 않으면 유효성 통과가 되지 않을수도 있으니 PasswordGenerator 인터페이스로 작성하여 중간에서 한번 거쳐서 사용
    // PasswordGenerator 인터페이스로 받음
    public void initPassword(PasswordGenerator passwordGenerator) {
//        RandomPasswordGenerator randomPasswordGenerator = new RandomPasswordGenerator();
        String password = passwordGenerator.generatePassword();

        // 비밀번호가 8자 이상 12자 이하
        if(password.length() >= 8 && password.length() <= 12) {
            this.password = password;
        }
    }

    public String getPassword() {
        return password;
    }
}
