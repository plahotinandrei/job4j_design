package ru.job4j.ood.ocp.foul;

/* В данном примере мы имеем жесткую привязку к конкретным типам уведомлений (email, sms, app)
внутри метода sendNotification. Это нарушает принцип OCP, так как при добавлении нового типа
уведомления нам придется модифицировать этот метод. */
public class NotificationService {

    public void sendNotification(String message, String type) {
        if (type.equals("email")) {
            System.out.println("отправка уведомления по электронной почте");
        } else if (type.equals("sms")) {
            System.out.println("отправка уведомления по SMS");
        } else if (type.equals("app")) {
            System.out.println("отправка уведомления в приложении");
        } else {
            throw new IllegalArgumentException("Invalid notification type");
        }
    }
}
