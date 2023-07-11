package ru.job4j.ood.ocp.foul;

/* В данном примере класс PaymentProcessor имеет жесткую привязку к конкретным реализациям классов
платежей (CreditCardPayment, PayPalPayment, BankTransferPayment). При добавлении нового типа платежа, необходимо
изменять код класса PaymentProcessor и добавлять новые условные операторы. Это нарушает принцип OCP. */
public class PaymentProcessor {

    public void processPayment(Payment payment) {
        if (payment instanceof CreditCardPayment) {
            System.out.println("Логика оплаты с помощью кредитной карты");
        } else if (payment instanceof PayPalPayment) {
            System.out.println("Логика оплаты с помощью PayPal");
        } else if (payment instanceof BankTransferPayment) {
            System.out.println("Логика оплаты с помощью банковского перевода");
        }
    }
}
