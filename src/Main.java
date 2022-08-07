import java.util.ArrayList;
import java.util.Scanner;


class Main {
    static Scanner input = new Scanner(System.in, "Cp866");
    static String task, choose, chooseList;

    static ArrayList<String> activeTasks = new ArrayList<>(), completeTasks = new ArrayList<>(),
            missedTasks = new ArrayList<>();
    static boolean on = true, on1 = false;

    static void printActiveTasks(){
        System.out.print("Active Tasks: \n");
        for (var i = 0; i < activeTasks.size(); i++){
            System.out.print((i + 1) + ". " + activeTasks.get(i) + "\n");
        }
    }

    static void printCompleteTasks(){
        System.out.print("\nCompleted Tasks: \n");
        for (var i = 0; i < completeTasks.size(); i++){
            System.out.print((i + 1) + ". " + completeTasks.get(i) + "\n");
        }
    }

    static void printMissedTasks(){
        System.out.print("\nMissed Tasks: \n");
        for (var i = 0; i < missedTasks.size(); i++){
            System.out.print((i + 1) + ". " + missedTasks.get(i) + "\n");
        }
    }

    static void printTask() {
        printActiveTasks();
        printCompleteTasks();
        printMissedTasks();
        System.out.print("\n");
    }

    static void addTask() {
        System.out.print("Input new task: ");
        task = input.nextLine();
        activeTasks.add(task);
        System.out.print("Task " + task + " added!\n\n");
    }

    static void toAnotherList(int index){
        String taskNumber;
        int taskNum = 0;
        printActiveTasks();
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

    static void completeTask() {
        toAnotherList(1);
    }

    static void missTask() {
        toAnotherList(0);
    }

    static void printMenu() {
        System.out.print("""              
                Choose operation:
                
                1. Print Tasks List
                2. Add Task
                3. Remove Task to Completed
                4. Remove Task to Missed
                5. Clear Lists
                
                0. Clear list and exit program
                Answer:\s""");
    }

    static void menu() {
        switch (choose) {
            case "1" -> printTask();
            case "2" -> addTask();
            case "3" -> completeTask();
            case "4" -> missTask();
            case "5" -> listClear();
            case "0" -> {
                printTask();
                on = false;
                System.out.print("Shutting down...\n\n");
                System.out.print("Press any button to exit program...");
                input.nextLine();
            }
            default -> System.out.print("Menu hasn't that item!!!\n\n");
        }
    }

    static void printListMenu(){
        System.out.print("""
                Choose list:
                
                1. All lists
                2. Active Tasks list
                3. Complete Tasks list
                4. Missed Tasks list
                
                0. Back to menu
                Answer:\s""");
    }

    static void listMenu(){
        switch (chooseList) {
            case "1" -> clearList(0);
            case "2" -> clearList(1);
            case "3" -> clearList(2);
            case "4" -> clearList(3);
            case "0" -> {on1 = false;
                System.out.print("Back to menu... \n\n");}
            default -> System.out.print("Menu hasn't that item!!!\n\n");
        }
    }

    static void clearList(int index){
        switch (index) {
            case 0 -> {activeTasks.clear();
            completeTasks.clear();
            missedTasks.clear();}
            case 1 -> activeTasks.clear();
            case 2 -> completeTasks.clear();
            case 3 -> missedTasks.clear();
        }
        System.out.print("List cleared!!!\n\n");
        on1 = false;
    }

    static void listClear(){
        on1 = true;
        while (on1){
            printListMenu();
            chooseList = input.nextLine();
            System.out.println();
            listMenu();
        }
    }

    public static void main(String[] args){
        while (on) {
            printMenu();
            choose = input.nextLine();
            System.out.println();
            menu();
        }
    }
}
