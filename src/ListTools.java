import java.io.*;


public class ListTools{

    String task;
    Data data = new Data();

    void printActiveTasks() {
        System.out.print(data.activeTasksList());
    }

    void printCompleteTasks() {
        System.out.print(data.completedTasksList());
    }

    void printMissedTasks() {
        System.out.print(data.missedTasksList());
    }

    void printTask()  {
        System.out.print(data.fullTasksList());
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
                data.completedTasks.add(task);
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
                data.completedTasks.clear();
                data.missedTasks.clear();
            }
            case 1 -> data.activeTasks.clear();
            case 2 -> data.completedTasks.clear();
            case 3 -> data.missedTasks.clear();
        }
        System.out.print("List cleared!!!\n\n");
    }

    void export(){
        try {
            OutputStream f = new FileOutputStream(data.fileName());
            OutputStreamWriter writer = new OutputStreamWriter(f);
            BufferedWriter out = new BufferedWriter(writer);

            out.write(data.date() + "\n\n");
            out.write(data.fullTasksList());
            out.flush();
            System.out.print("File export successfully\n\n");

        } catch (IOException exception){
            System.out.print(exception);
        }
    }

}
