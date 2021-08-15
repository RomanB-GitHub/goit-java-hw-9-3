package main;

/*
Дан текстовый файл file.txt, который содержит список номеров телефоном (один на линии).
Необъодимо написать метод, который будет считывать файл и выводить в консоль все валидные номера телефонов.
Предполагаем, что "валидный" номер телефона - это
строка в одном из двух форматов: (xxx) xxx-xxxx или xxx-xxx-xxxx (х обозначает цифру).

Пример:

Для файла file.txt со следующим содержанием:
987-123-4567
123 456 7890
(123) 456-7890

Метод должен вывести на экран
987-123-4567
(123) 456-7890

 */



import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.regex.Pattern;

public class TaskFirst {


    public static void validatePhoneNumber(String path) {

        File file = new File(path);
        String telefoneRegex1 = "^\\d{3}-\\d{3}-\\d{4}$";
        String telefoneRegex2 = "^\\(\\d{3}\\)\\s\\d{3}-\\d{4}$";


        if (file.exists() && file.isFile()) {
            try (FileReader reader = new FileReader(file);
                 BufferedReader bufferedReader = new BufferedReader(reader)) {
                String line ;
                while ((line = bufferedReader.readLine())  != null) {
                    if((Pattern.matches(telefoneRegex1,line)) || (Pattern.matches(telefoneRegex2,line))){
                        System.out.println(line);
                    }
                }
            } catch (IOException ex) {
                System.out.println(ex.getMessage());
            }
        }else{
            System.out.println("Please check the file path!");
        }


    }
}
//"^(\\+\\d{1,3}( )?)?((\\(\\d{1,3}\\))|\\d{1,3})[- .]?\\d{3,4}[- .]?\\d{4}$";