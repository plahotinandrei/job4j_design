package ru.job4j.ood.isp.menu;

import java.util.Arrays;

public class MenuPrinterConsole implements MenuPrinter {

    private static final String INDENT = "---";

    @Override
    public void print(Menu menu) {
        for (var item:menu) {
            printItem(item);
        }
    }

    private void printItem(Menu.MenuItemInfo itemInfo) {
        StringBuilder rsl = new StringBuilder();
        String[] nums = itemInfo.getNumber().split("\\.");
        Arrays.stream(nums)
                .forEach((e) -> rsl.append(INDENT));
        rsl.append(String.format(" %s%s", itemInfo.getNumber(), itemInfo.getName()));
        System.out.println(rsl);
    }
}
