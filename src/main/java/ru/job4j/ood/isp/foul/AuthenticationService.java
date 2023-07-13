package ru.job4j.ood.isp.foul;

public interface AuthenticationService {

    void login(String username, String password);

    void logout();

    void registerUser(User user);
}
