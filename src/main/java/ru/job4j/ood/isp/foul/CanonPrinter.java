package ru.job4j.ood.isp.foul;

/* Нарушает принцип ISP, так как не все принтеры поддерживают сканирование,
и метод scan() становится пустым или бросает исключение */
public class CanonPrinter implements Printer {

    @Override
    public void print() {
        System.out.println("Print...");
    }

    @Override
    public void scan() {
        throw new UnsupportedOperationException("Scanner is not supported by this device");
    }
}
