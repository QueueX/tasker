public class Menu{

    Data data = new Data();

    boolean on = false, on1 = false;

    String choose, chooseList;

    ListTools tool = new ListTools();

    void printMenu() {
        System.out.print("""              
                Choose operation:
                                
                1. Print Tasks List
                2. Add Task
                3. Remove Task to Completed
                4. Remove Task to Missed
                5. Export current List
                6. Clear Lists
                                
                0. Clear list and exit program
                Answer:\s""");
    }

    void menu() {
        switch (choose) {
            case "1" -> tool.printTask();
            case "2" -> tool.addTask();
            case "3" -> tool.completeTask();
            case "4" -> tool.missTask();
            case "5" -> tool.export();
            case "6" -> {
                clearMenu();
                on1 = false;
            }
            case "0" -> {
                tool.printTask();
                on = false;
                System.out.print("Shutting down...\n\n");
                System.out.print("Press any button to exit program...");
                data.input.nextLine();
            }
            default -> System.out.print("Menu hasn't that item!!!\n\n");
        }
    }

    void printListMenu() {
        System.out.print("""
                Choose list:
                                
                1. All lists
                2. Active Tasks list
                3. Complete Tasks list
                4. Missed Tasks list
                                
                0. Back to menu
                Answer:\s""");
    }

    void listMenu() {
        switch (chooseList) {
            case "1" -> {on1 = false; tool.clearList(0);}
            case "2" -> {on1 = false; tool.clearList(1);}
            case "3" -> {on1 = false; tool.clearList(2);}
            case "4" -> {on1 = false; tool.clearList(3);}
            case "0" -> {on1 = false; System.out.print("Back to menu... \n\n");}
            default -> System.out.print("Menu hasn't that item!!!\n\n");
        }
    }

    void start() {
        on = true;
        while (on) {
            printMenu();
            choose = data.input.nextLine();
            System.out.println();
            menu();
        }
    }

    void clearMenu() {
        on1 = true;
        while (on1) {
            printListMenu();
            chooseList = data.input.nextLine();
            System.out.println();
            listMenu();
        }
    }

}
