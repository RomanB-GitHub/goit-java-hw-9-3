package main;

/*
Дан текстовый файл file.txt, необходимо считать файл в список объектов User и создать новый файл user.json.

Предполагаем, что каждая строка содержит одинаковое количество "колонок", разделенный пробелом.

Пример:

Для файла file.txt со следующим содержанием:

name age
alice 21
ryan 30

Новый файл должен иметь следующий вид:

[

 {

 "name": "alice",

 "age":21

 },

 {

 "name": "ryan",

 "age":30

 }

]

 */

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class TaskSecond {

    public static void workWithFile(String pathToFile, String pathToJSon) {

        File file = new File(pathToFile);
        List<User> users = new ArrayList<>();

        if (!getFromFileToList(file, users)) {
            return;
        }

        if (users.size() != 0) {
            convertUsersListToJson(pathToJSon, file, users);
        }
    }

    private static void convertUsersListToJson(String pathToJSon, File file, List<User> users) {
        File jsonFile = new File(pathToJSon);
        if (!file.exists()) {
            file.getParentFile().mkdirs();
        }
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(jsonFile))) {
            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            String json = gson.toJson(users);
            bufferedWriter.write(json);
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
    }

    private static boolean getFromFileToList(File file, List<User> users) {
        if (file.exists() && file.isFile()) {
            try (BufferedReader bufferedReader = new BufferedReader(new FileReader(file))) {
                String line = bufferedReader.readLine();
                while ((line = bufferedReader.readLine()) != null) {
                    String[] parts = line.strip().split(" ");
                    users.add(new User(parts[0], Integer.parseInt(parts[1])));
                }
            } catch (IOException e) {
                System.err.println(e.getMessage());
            }
        } else {
            System.out.println("Not correct path to file");
            return false;
        }
        return true;
    }
}

class User {
    private String name;
    private int age;

    public User(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}

