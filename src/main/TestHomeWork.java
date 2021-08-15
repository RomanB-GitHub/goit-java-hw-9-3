package main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.FileReader;
import java.io.File;

public class TestHomeWork {

    private static final String ABSOLUTE_PATH_TASK_ONE=
            "C:\\Users\\Roman\\IdeaProjects\\Home_Work_GoIt\\Home_task_09\\src\\Task1\\File.txt";

    private static final String ABSOLUTE_PATH_FILE_TASK_SECOND =
            "C:\\Users\\Roman\\IdeaProjects\\Home_Work_GoIt\\Home_task_09\\src\\Task2\\File.txt";
    private static final String ABSOLUTE_PATH_JSON_TASK_SECOND =
            "C:\\Users\\Roman\\IdeaProjects\\Home_Work_GoIt\\Home_task_09\\src\\Task2\\user.json";


    private static final String ABSOLUTE_PATH_TASK_THIRD = "" +
            "C:\\Users\\Roman\\IdeaProjects\\Home_Work_GoIt\\Home_task_09\\src\\Task3\\words.txt" ;

    public static void main(String[] args) {
        System.out.println("Let's test first task!");
        TaskFirst.validatePhoneNumber(ABSOLUTE_PATH_TASK_ONE);

        System.out.println("\nLet's test second task!");
        TaskSecond.workWithFile(ABSOLUTE_PATH_FILE_TASK_SECOND, ABSOLUTE_PATH_JSON_TASK_SECOND);
        try(BufferedReader bufferedReader = new BufferedReader(new FileReader(new File(ABSOLUTE_PATH_JSON_TASK_SECOND)))){
            String line = null;
            while ((line = bufferedReader.readLine()) != null){
                System.out.println(line);
            }
        }catch(IOException ex){
            System.err.println(ex.getMessage());
        }


        System.out.println("\nLet's test third task!");
        TaskThird.wordFrequencyInText(ABSOLUTE_PATH_TASK_THIRD);



    }
}
