import java.util.ArrayList;
import java.util.Scanner;

class Main {
    public static String task, choose;
    public static ArrayList<String> activeTasks = new ArrayList<>(), completeTasks = new ArrayList<>(),
            missedTasks = new ArrayList<>();
    public static boolean on = true;

    public static void printTask() {
        System.out.println("Активные задачи:");
        for (var i = 0; i < activeTasks.size(); i++){
            System.out.println((i + 1) + ". " + activeTasks.get(i));
        }
        System.out.println("\nВыполненные задачи: \n");
        for (var i = 0; i < completeTasks.size(); i++){
            System.out.println((i + 1) + ". " + completeTasks.get(i));
        }
        System.out.println("\nПроваленные задачи: \n");
        for (var i = 0; i < missedTasks.size(); i++){
            System.out.println((i + 1) + ". " + missedTasks.get(i));
        }
    }

    public static void addTask() {
        System.out.print("Введите новую задачу: ");
        task = input();
        activeTasks.add(task);
        System.out.print("Задача " + task + " добавлена!\n\n");

    }

    public static void completeTask() {

    }

    public static void missTask() {

    }

    public static void printMenu() {
        System.out.print("1. Вывести список задач\n" +
                "2. Добавить задачу\n" +
                "3. Отметить задачу как выполненную\n" +
                "4. Отметить задачу как проваленную\n" +
                "0. Очистить список и выйти из программы \nПоле для ответа: ");
    }

    public static String input() {
        Scanner input = new Scanner(System.in);
        String a = input.nextLine();
        return a;
    }

    public static void menu() {
        switch (choose) {
            case "1":
                printTask();
                break;
            case "2":
                addTask();
                break;
            case "3":
                completeTask();
                break;
            case "4":
                missTask();
                break;
            case "0":
                printTask();
                on = false;
                System.out.print("Завершение работы...");
                break;
            default:
                System.out.print("В меню нет такого варианта ответа!!!\nПопробуй ещё раз: \n\n");
        }
    }


    public static void main(String[] args) {
        System.out.print("Выбери действие:\n\n");
        while (on == true) {
            printMenu();
            choose = input();
            System.out.println();
            menu();
        }
    }
}
