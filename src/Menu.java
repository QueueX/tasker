public class Menu{

    Data data = new Data();


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

    int menu() {
        switch (choose) {
            case "1" -> tool.printTask();
            case "2" -> tool.addTask();
            case "3" -> tool.completeTask();
            case "4" -> tool.missTask();
            case "5" -> tool.export();
            case "6" -> clearMenu();
            case "0" -> {
                tool.printTask();
                System.out.print("Shutting down...\n\n");
                System.out.print("Press any button to exit program...");
                data.input.nextLine();
                return 1;
            }
            default -> System.out.print("Menu hasn't that item!!!\n\n");
        }
        return 0;
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

    int listMenu() {
        switch (chooseList) {
            case "1" -> {tool.clearList(0); return 1;}
            case "2" -> {tool.clearList(1); return 1;}
            case "3" -> {tool.clearList(2); return 1;}
            case "4" -> {tool.clearList(3); return 1;}
            case "0" -> {System.out.print("Back to menu... \n\n"); return 1;}
            default -> System.out.print("Menu hasn't that item!!!\n\n");
        }
        return 0;
    }

    void clearMenu() {
        while (true) {
            printListMenu();
            chooseList = data.input.nextLine();
            System.out.println();
            int x = listMenu();
            if (x == 1){
                return;
            }
        }
    }

    void start() {
        while (true) {
            printMenu();
            choose = data.input.nextLine();
            System.out.println();
            int x = menu();
            if (x == 1){
                return;
            }
        }
    }

}
