package ru.job4j.ood.dip.foul;

/* Нарушает принцип DIP, так как класс содержит жесткую зависимость от конкретной реализации
SmtpClient для отправки электронных писем, вместо зависимости от абстракции почтового клиента. */
public class EmailService {

    private final SmtpClient smtpClient;

    public EmailService() {
        this.smtpClient = new SmtpClient();
    }

    public void sendEmail(Email email) {
        smtpClient.connect();
        smtpClient.send(email);
        smtpClient.disconnect();
    }
}
