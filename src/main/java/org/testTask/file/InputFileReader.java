package org.testTask.file;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

/*
Класс для считывания данных из входных файлов.
 */
public class InputFileReader {
    private static ArrayList<List<String>> allFiles = new ArrayList<>();
    private static List<String> allLines;
    private AbsolutePathFormer absolutePathFormer;

    //Конструктор класса.
    public InputFileReader (AbsolutePathFormer absolutePathFormer){
            this.absolutePathFormer = absolutePathFormer;
    }

    /*
    Метод для считывания всех строк каждого из входных файлов (allLines) и добавления их в двумерный список allFiles.
    Этот список содержит несколько    списков, соответствующих входным файлам, в каждом из которых лежат строки данного
    входного файла.
    */
    public ArrayList<List<String>> readFiles(){
        for (Path filePath : absolutePathFormer.formAbsoluteInputPath()){
            try {
                allLines = Files.readAllLines(filePath);
                allFiles.add(allLines);
            } catch (IOException e) {
                System.out.println("Invalid file name: " + filePath);
            }
        }
        return allFiles;
    }
}
