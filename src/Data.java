import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class Data {

    Date date = new Date();

    Scanner input = new Scanner(System.in, "Cp866");
    ArrayList<String> activeTasks = new ArrayList<>(), completedTasks = new ArrayList<>(),
            missedTasks = new ArrayList<>();

    String activeTasksList(){
        StringBuilder list = new StringBuilder("Active Tasks: \n");
        for (var i = 0; i < activeTasks.size(); i++) {
            list.append(i + 1).append(". ").append(activeTasks.get(i)).append("\n");
        }
        return list.toString();
    }

    String completedTasksList(){
        StringBuilder list = new StringBuilder("Completed Tasks: \n");
        for (var i = 0; i < completedTasks.size(); i++) {
            list.append(i + 1).append(". ").append(completedTasks.get(i)).append("\n");
        }
        return list.toString();
    }

    String missedTasksList(){
        StringBuilder list = new StringBuilder("Missed Tasks: \n");
        for (var i = 0; i < missedTasks.size(); i++) {
            list.append(i + 1).append(". ").append(missedTasks.get(i)).append("\n");
        }
        return list.toString();
    }

    String fullTasksList(){
        String list = activeTasksList() + "\n" + completedTasksList() + "\n" + missedTasksList() + "\n";
        return list;
    }

    String fileName(){
        SimpleDateFormat formatter = new SimpleDateFormat("HHmmss-ddMMyy");
        String name = "TaskExport" + formatter.format(date) + ".txt";
        return name;
    }

    String date(){
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
        return formatter.format(date);
    }

}
