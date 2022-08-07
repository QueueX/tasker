import java.util.ArrayList;
import java.util.Scanner;


class Main {
    public static Scanner input = new Scanner(System.in, "Cp866");
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
        System.out.print("\nПроваленные задачи: \n");
        for (var i = 0; i < missedTasks.size(); i++){
            System.out.print((i + 1) + ". " + missedTasks.get(i) + "\n");
        }
        System.out.print("\n");
    }

    public static void addTask() {
        System.out.print("Введите новую задачу: ");
        task = input.nextLine();
        activeTasks.add(task);
        System.out.print("Задача " + task + " добавлена!\n\n");
    }

    public static void toAnotherList(int index){
        String taskNumber;
        int taskNum = 0;
        System.out.print("Активные задачи: \n");
        for (var i = 0; i < activeTasks.size(); i++){
            System.out.print((i + 1) + ". " + activeTasks.get(i) + "\n");
        }
        System.out.print("Введите номер " + ((index == 1) ? "выполенной" : "проваленной") + " задачи (0 - отмена действия): ");

        try {
            taskNumber = input.nextLine();
            taskNum = Integer.parseInt(taskNumber);
        } catch (Exception exception) {
            System.out.println("\nДля ввода элемента используются только цифры! Операция отменена\n");
        }
        if (0 < taskNum && taskNum <= activeTasks.size()){
            taskNum--;
            task = activeTasks.get(taskNum);
            if (index == 1){
                completeTasks.add(task);
            } else {
                missedTasks.add(task);
            }
            activeTasks.remove(taskNum);
            System.out.print("\nЗадача " + task + " перемещена в " + ((index == 1) ? "выполенные" : "проваленные") + " задачи!\n\n");
        } else if (taskNum == 0) {
            System.out.print("Возврат в меню...\n\n");
        } else {
            System.out.print("Данной задачи нет в списке активных задач\n Возврат в меню...\n\n");
        }
    }

    public static void completeTask() {
        toAnotherList(1);
    }

    public static void missTask() {
        toAnotherList(0);
    }

    public static void printMenu() {
        System.out.print("""              
                Выбери действие:
                1. Вывести список задач
                2. Добавить задачу
                3. Отметить задачу как выполненную
                4. Отметить задачу как проваленную
                0. Очистить список и выйти из программы
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
            default -> System.out.print("В меню нет такого варианта ответа!!!\n\n");
        }
    }


    public static void main(String[] args) {
        while (on) {
            printMenu();
            choose = input.nextLine();
            System.out.println();
            menu();
        }
    }
}
