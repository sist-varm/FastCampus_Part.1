package org.example;

public class User {
    private String password;

//    RandomPasswordGenerator 사용하면 매번 랜덤으로 발생하는 비밀번호에 조건에 맞지 않으면 유효성 통과가 되지 않을수도 있으니 PasswordGenerator 인터페이스로 작성하여 중간에서 한번 거쳐서 사용(의존도 높음)
    // PasswordGenerator 인터페이스로 받음
    public void initPassword(PasswordGenerator passwordGenerator) {
        // as-is (내부에서 생성하기 때문에 높은 결합도), 내부의 RandomPasswordGenerator에 의존하기 때문에 결합도가 높고 테스트하기 힘듬
//        RandomPasswordGenerator randomPasswordGenerator = new RandomPasswordGenerator();

        // to-be (더 낮은 결합도)
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
