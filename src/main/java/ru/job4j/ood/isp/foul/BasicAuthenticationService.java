package ru.job4j.ood.isp.foul;

/* Нарушает принцип ISP, так как некоторые классы сервисов аутентификации могут
не поддерживать операции выхода из системы и метод logout() становится пустым или бросает исключение */
public class BasicAuthenticationService implements AuthenticationService {
    @Override
    public void login(String username, String password) {
        System.out.println("Logic for user login");
    }

    @Override
    public void logout() {
        throw new UnsupportedOperationException("Logout not supported");
    }

    @Override
    public void registerUser(User user) {
        System.out.println("Logic for user register");
    }
}
