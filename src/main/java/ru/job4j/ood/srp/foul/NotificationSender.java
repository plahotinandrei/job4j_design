package ru.job4j.ood.srp.foul;

/* Нарушает принцип SRP, так как он объединяет две ответственности:
отправку уведомления по электронной почте и формирование содержания уведомления */
public class NotificationSender {

    public void sendNotification(String recipient, String message) {
        /* Логика отправки уведомления по электронной почте */

        /* Формирование содержания уведомления */
        String notificationContent = generateNotificationContent();

        /* Отправка уведомления */
        sendEmail(recipient, notificationContent);
    }

    private String generateNotificationContent() {
        /* Логика генерации содержания уведомления */
        return "Содержание уведомления";
    }

    private void sendEmail(String recipient, String content) {
        /* Логика отправки электронного письма */
    }
}
