public class ListTools extends Data {

    static String task;

    static void printActiveTasks() {
        System.out.print("Active Tasks: \n");
        for (var i = 0; i < activeTasks.size(); i++) {
            System.out.print((i + 1) + ". " + activeTasks.get(i) + "\n");
        }
    }

    static void printCompleteTasks() {
        System.out.print("\nCompleted Tasks: \n");
        for (var i = 0; i < completeTasks.size(); i++) {
            System.out.print((i + 1) + ". " + completeTasks.get(i) + "\n");
        }
    }

    static void printMissedTasks() {
        System.out.print("\nMissed Tasks: \n");
        for (var i = 0; i < missedTasks.size(); i++) {
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

    static void toAnotherList(int index) {
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
        if (0 < taskNum && taskNum <= activeTasks.size()) {
            taskNum--;
            task = activeTasks.get(taskNum);
            if (index == 1) {
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

    static void clearList(int index) {
        switch (index) {
            case 0 -> {
                activeTasks.clear();
                completeTasks.clear();
                missedTasks.clear();
            }
            case 1 -> activeTasks.clear();
            case 2 -> completeTasks.clear();
            case 3 -> missedTasks.clear();
        }
        System.out.print("List cleared!!!\n\n");
    }

}
