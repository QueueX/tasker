public class ListTools{

    String task;
    Data data = new Data();

    void printActiveTasks() {
        System.out.print("Active Tasks: \n");
        for (var i = 0; i < data.activeTasks.size(); i++) {
            System.out.print((i + 1) + ". " + data.activeTasks.get(i) + "\n");
        }
    }

    void printCompleteTasks() {
        System.out.print("\nCompleted Tasks: \n");
        for (var i = 0; i < data.completeTasks.size(); i++) {
            System.out.print((i + 1) + ". " + data.completeTasks.get(i) + "\n");
        }
    }

    void printMissedTasks() {
        System.out.print("\nMissed Tasks: \n");
        for (var i = 0; i < data.missedTasks.size(); i++) {
            System.out.print((i + 1) + ". " + data.missedTasks.get(i) + "\n");
        }
    }

    void printTask() {
        printActiveTasks();
        printCompleteTasks();
        printMissedTasks();
        System.out.print("\n");
    }

    void addTask() {
        System.out.print("Input new task: ");
        task = data.input.nextLine();
        data.activeTasks.add(task);
        System.out.print("Task " + task + " added!\n\n");
    }

    void toAnotherList(int index) {
        String taskNumber;
        int taskNum = 0;
        printActiveTasks();
        System.out.print("Input number of " + ((index == 1) ? "completed" : "missed") + " task (0 - cancel operation): ");
        try {
            taskNumber = data.input.nextLine();
            taskNum = Integer.parseInt(taskNumber);
        } catch (Exception exception) {
            System.out.println("\nFor input element used only numbers! Operation canceled\n");
        }
        if (0 < taskNum && taskNum <= data.activeTasks.size()) {
            taskNum--;
            task = data.activeTasks.get(taskNum);
            if (index == 1) {
                data.completeTasks.add(task);
            } else {
                data.missedTasks.add(task);
            }
            data.activeTasks.remove(taskNum);
            System.out.print("\nTask " + task + " remove to " + ((index == 1) ? "completed" : "missed") + " tasks!\n\n");
        } else if (taskNum == 0) {
            System.out.print("Back to menu...\n\n");
        } else {
            System.out.print("This task is not in Active Tasks\n Back to menu...\n\n");
        }
    }

    void completeTask() {
        toAnotherList(1);
    }

    void missTask() {
        toAnotherList(0);
    }

    void clearList(int index) {
        switch (index) {
            case 0 -> {
                data.activeTasks.clear();
                data.completeTasks.clear();
                data.missedTasks.clear();
            }
            case 1 -> data.activeTasks.clear();
            case 2 -> data.completeTasks.clear();
            case 3 -> data.missedTasks.clear();
        }
        System.out.print("List cleared!!!\n\n");
    }

}
