public class Menu extends ListTools {

    static boolean on = false, on1 = false;

    static String choose, chooseList;

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
            case "5" -> {
                clearMenu();
                on1 = false;
            }
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

    static void printListMenu() {
        System.out.print("""
                Choose list:
                                
                1. All lists
                2. Active Tasks list
                3. Complete Tasks list
                4. Missed Tasks list
                                
                0. Back to menu
                Answer:\s""");
    }

    static void listMenu() {
        switch (chooseList) {
            case "1" -> clearList(0);
            case "2" -> clearList(1);
            case "3" -> clearList(2);
            case "4" -> clearList(3);
            case "0" -> {
                on1 = false;
                System.out.print("Back to menu... \n\n");
            }
            default -> System.out.print("Menu hasn't that item!!!\n\n");
        }
    }

    static void start() {
        on = true;
        while (on) {
            printMenu();
            choose = input.nextLine();
            System.out.println();
            menu();
        }
    }

    static void clearMenu() {
        on1 = true;
        while (on1) {
            printListMenu();
            chooseList = input.nextLine();
            System.out.println();
            listMenu();
        }
    }

}
