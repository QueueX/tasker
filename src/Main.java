import java.util.ArrayList;
import java.util.Scanner;

class Main {
    public static Scanner input = new Scanner(System.in);
    public static String task, choose;
    public static ArrayList<String> activeTasks = new ArrayList<>(), completeTasks = new ArrayList<>(),
            missedTasks = new ArrayList<>();
    public static boolean on = true;

    public static void printTask() {
        System.out.print("Активные задачи: \n");
        for (var i = 0; i < activeTasks.size(); i++){
            System.out.print((i + 1) + ". " + activeTasks.get(i) + "\n");
        }
        System.out.print("\nВыполненные задачи: \n");
        for (var i = 0; i < completeTasks.size(); i++){
            System.out.print((i + 1) + ". " + completeTasks.get(i) + "\n");
        }
        System.out.print("\nПроваленные задачи: \n\n");
        for (var i = 0; i < missedTasks.size(); i++){
            System.out.print((i + 1) + ". " + missedTasks.get(i) + "\n");
        }
    }

    public static void addTask() {
        System.out.print("Введите новую задачу: ");
        task = input.nextLine();
        activeTasks.add(task);
        System.out.print("Задача " + task + " добавлена!\n\n");

    }

    public static void completeTask() {

    }

    public static void missTask() {

    }

    public static void printMenu() {
        System.out.print("""
                1. Вывести список задач
                2. Добавить задачу
                3. Отметить задачу как выполненную
                4. Отметить задачу как проваленную
                0. Очистить список и выйти из программы\s
                Поле для ответа:\s""");
    }

    public static void menu() {
        switch (choose) {
            case "1" -> printTask();
            case "2" -> addTask();
            case "3" -> completeTask();
            case "4" -> missTask();
            case "0" -> {
                printTask();
                on = false;
                System.out.print("Завершение работы...");
            }
            default -> System.out.print("В меню нет такого варианта ответа!!!\nПопробуй ещё раз: \n\n");
        }
    }


    public static void main(String[] args) {
        System.out.print("Выбери действие:\n\n");
        while (on) {
            printMenu();
            choose = input.nextLine();
            System.out.println();
            menu();
        }
    }
}
