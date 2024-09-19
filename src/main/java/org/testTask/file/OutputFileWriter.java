package org.testTask.file;

import org.testTask.ArgumentManager;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;

/*
Класс для записи данных в файлы результатов.
 */
public class OutputFileWriter {

    private ArgumentManager argumentManager;

    //Конструктор класса.
    public OutputFileWriter(ArgumentManager argumentManager){
        this.argumentManager = argumentManager;

    }

    //Метод для преобразования списка Integer, Float или String к типу данных String.
    //Это необходимо, непосредственно, для записи обработанных данных в файлы результатов.
    private List<String> convertToStringList (List<?> inputList){
        return inputList.stream().map(Object::toString).toList();
    }

/*
    Метод для записи данных в файл результатов в зависимости от наличия аргумента "-a" (Добавление в существующий файл).
    В качестве аргумента в метод передается путь к файлу результатов и список, содержащий результат обработки методом
    manage экземпляра класса DataManager.
 */
    public void writeFiles (Path path, ArrayList <?> arrayList){
        try {
            if (argumentManager.getAppendOption() && !arrayList.isEmpty()) {
                Files.write(path, convertToStringList(arrayList), StandardOpenOption.CREATE, StandardOpenOption.APPEND);
            } else if (!arrayList.isEmpty()){
                Files.write(path, convertToStringList(arrayList), StandardOpenOption.CREATE);
            }
        } catch (IOException e) {
            throw new RuntimeException();
        }
    }
}

