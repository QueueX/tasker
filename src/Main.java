import java.util.ArrayList;
import java.util.Scanner;


class Main {
    public static Scanner input = new Scanner(System.in, "Cp866");
    public static String task, choose;
    public static ArrayList<String> activeTasks = new ArrayList<>(), completeTasks = new ArrayList<>(),
            missedTasks = new ArrayList<>();
    public static boolean on = true;

    public static void printTask() {
        System.out.print("Active Tasks: \n");
        for (var i = 0; i < activeTasks.size(); i++){
            System.out.print((i + 1) + ". " + activeTasks.get(i) + "\n");
        }
        System.out.print("\nCompleted Tasks: \n");
        for (var i = 0; i < completeTasks.size(); i++){
            System.out.print((i + 1) + ". " + completeTasks.get(i) + "\n");
        }
        System.out.print("\nMissed Tasks: \n");
        for (var i = 0; i < missedTasks.size(); i++){
            System.out.print((i + 1) + ". " + missedTasks.get(i) + "\n");
        }
        System.out.print("\n");
    }

    public static void addTask() {
        System.out.print("Input new task: ");
        task = input.nextLine();
        activeTasks.add(task);
        System.out.print("Task " + task + " added!\n\n");
    }

    public static void toAnotherList(int index){
        String taskNumber;
        int taskNum = 0;
        System.out.print("Active Tasks: \n");
        for (var i = 0; i < activeTasks.size(); i++){
            System.out.print((i + 1) + ". " + activeTasks.get(i) + "\n");
        }
        System.out.print("Input number of " + ((index == 1) ? "completed" : "missed") + " task (0 - cancel operation): ");

        try {
            taskNumber = input.nextLine();
            taskNum = Integer.parseInt(taskNumber);
        } catch (Exception exception) {
            System.out.println("\nFor input element used only numbers! Operation canceled\n");
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
            System.out.print("\nTask " + task + " remove to " + ((index == 1) ? "completed" : "missed") + " tasks!\n\n");
        } else if (taskNum == 0) {
            System.out.print("Back to menu...\n\n");
        } else {
            System.out.print("This task is not in Active Tasks\n Back to menu...\n\n");
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
                Choose operation:
                1. Print Tasks List
                2. Add Task
                3. Remove Task to Completed
                4. Remove Task to Missed
                0. Clear list and exit program
                Answer:\s""");
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
                System.out.print("Shutting down...");
            }
            default -> System.out.print("Menu hasn't that item!!!\n\n");
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
