package ru.job4j.ood.isp.menu;

import java.util.Optional;
import java.util.Scanner;

public class TodoApp {
    private static final ActionDelegate DEFAULT_ACTION = () -> System.out.println("Some action");
    private final Scanner scanner = new Scanner(System.in);
    private boolean run = true;

    public void init(Menu menu, MenuPrinter printer) {
        while (run) {
            printer.print(menu);
            Optional<Menu.MenuItemInfo> item = menu.select(scanner.nextLine());
            item.ifPresentOrElse(
                    itemInfo -> itemInfo.getActionDelegate().delegate(),
                    () -> System.out.println("Error. Item menu not found!")
            );
        }
    }

    private void addToRoot(Menu menu) {
        String name = askStr("Enter item menu name: ");
        String rsl = menu.add(Menu.ROOT, name, DEFAULT_ACTION)
                ? "Item menu added successfully" : "Error. Item menu was not added";
        System.out.println(rsl);
    }

    private void addToChildren(Menu menu) {
        String parentName = askStr("Enter item menu parent name: ");
        String childName = askStr("Enter item menu child name: ");
        String rsl = menu.add(parentName, childName, DEFAULT_ACTION)
                ? "Item menu added successfully" : "Error. Item menu was not added";
        System.out.println(rsl);
    }

    public String askStr(String question) {
        System.out.print(question);
        return scanner.nextLine();
    }

    private void exit() {
        this.run = false;
    }

    public static void main(String[] args) {
        TodoApp app = new TodoApp();
        Menu menu = new SimpleMenu();
        menu.add(Menu.ROOT, "Добавить в корень меню", () -> app.addToRoot(menu));
        menu.add(Menu.ROOT, "Добавить к родительскому элементу", () -> app.addToChildren(menu));
        menu.add(Menu.ROOT, "Выход", app::exit);
        MenuPrinter printer = new MenuPrinterConsole();
        app.init(menu, printer);
    }
}
