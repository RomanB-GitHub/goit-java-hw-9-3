package main;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

/*

Напишите метод, который будет подсчитывать частоту каждого слова в файле words.txt.

Предпалагаем, что:

1) words.txt содержит только слова в нижнем регистре, разделенные пробелом
2) Каждое слово содержит только символы-буквы в нижнем регистре.
3) Слова разделены одим или несколькими пробелами, либо переносом строки.
Пример:

Для файла words.txt со следующим содержанием:

the day is sunny the the
the sunny is is

Метод должен вернуть частоту:

the 4
is 3
sunny 2
day 1
 */
public class TaskThird {

    public static void wordFrequencyInText(String path) {
        File file = new File(path);
        StringBuilder stb = new StringBuilder();
        if ((file.exists()) && (file.isFile())) {
            String[] parts = readTextFileToArrayOfStrings(file, stb);
            List<Map.Entry<String, Integer>> entryList = getSortedFrequencyOfWordsInArrayOfStrings(parts);
            entryList.forEach(entry -> System.out.println(entry.getKey() + " " + entry.getValue()));
        } else {
            System.out.println("Not correct path to file");
        }
    }

    private static List<Map.Entry<String, Integer>> getSortedFrequencyOfWordsInArrayOfStrings(String[] parts){
        Map<String,Integer> wordsCount = new HashMap<>();
        Set<String> wordsSet = new HashSet<>();
        List<String> allWords = new ArrayList<>(Arrays.asList(parts));
        for(String part:parts){
            if(!wordsSet.contains(part)){
                wordsSet.add(part);
                wordsCount.put(part, Collections.frequency(allWords,part));
            }
        }
        List<Map.Entry<String,Integer>> entryList = new ArrayList<>(wordsCount.entrySet());
        entryList.sort(((o1, o2) -> o2.getValue().compareTo(o1.getValue())));
        return entryList;
    }

    private static String[]readTextFileToArrayOfStrings(File file, StringBuilder stb){
        try(BufferedReader bufferedReader = new BufferedReader(new FileReader(file))){
            String line = null;
            while((line = bufferedReader.readLine()) !=null){
                stb.append(line.strip());
                stb.append(" ");
            }
        }catch (IOException ex){
            System.err.println(ex.getMessage());
        }
        String text = stb.toString();
        text = text.replaceAll("\\,"," ");
        text = text.replaceAll("\\."," ");
        text = text.replaceAll("\\s+"," ");
        String[] parts = text.split(" ");
        return parts;
    }

}
