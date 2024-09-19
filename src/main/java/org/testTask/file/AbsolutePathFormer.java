package org.testTask.file;

import org.testTask.ArgumentManager;
import org.testTask.Main;

import java.io.File;
import java.net.URISyntaxException;
import java.nio.file.Path;
import java.util.ArrayList;

/*
Класс для формирования абсолютного пути к исполняемому jar-файлу, а также к входным и выходным файлам.
 */
public class AbsolutePathFormer {
    private ArgumentManager argumentManager;
    private ArrayList<Path> inputFilePath = new ArrayList<>();
    private String jarDir;
    private Path outputStringPath;
    private Path outputIntPath;
    private Path outputFloatPath;

    //Геттеры и сеттеры.
    public Path getOutputFloatPath() {
        return outputFloatPath;
    }

    public void setOutputFloatPath(Path outputFloatPath) {
        this.outputFloatPath = outputFloatPath;
    }

    public Path getOutputIntPath() {
        return outputIntPath;
    }

    public void setOutputIntPath(Path outputIntPath) {
        this.outputIntPath = outputIntPath;
    }

    public Path getOutputStringPath() {
        return outputStringPath;
    }

    public void setOutputStringPath(Path outputStringPath) {
        this.outputStringPath = outputStringPath;
    }

    //Констркуктор класса.
    public AbsolutePathFormer(ArgumentManager argumentManager) {
        this.argumentManager = argumentManager;
    }

    //Метод для определения пути к исполняемому файлу.
    public String findJarDir(){
        try {
            jarDir = Main
                    .class
                    .getProtectionDomain()
                    .getCodeSource()
                    .getLocation()
                    .toURI()
                    .getPath();
        } catch (
                URISyntaxException e){
            System.out.println("Invalid directory or file name");
        }
        jarDir = jarDir.substring(jarDir.indexOf(File.separator)+1);
        return jarDir.substring(0, jarDir.lastIndexOf(File.separator) + 1);
    }

    //Метод для формирования списка, содержащего пути к входным файлам.
    public ArrayList <Path> formAbsoluteInputPath(){
        for (String fileName : argumentManager.getInputFiles()){
            inputFilePath.add(Path.of(findJarDir() + fileName));
        }
        return inputFilePath;
    }

    //Метод для формирования пути к файлами результатов, в зависимости от наличия аргумента командной строки "-o".
    public void formAbsoluteOutputPath(){
       if(argumentManager.getOutputOption()){
           setOutputFloatPath(Path.of(argumentManager.getOutputFilePath() + argumentManager.getOutputFilePrefix() + "floats.txt"));
           setOutputIntPath(Path.of(argumentManager.getOutputFilePath() + argumentManager.getOutputFilePrefix() + "integers.txt"));
           setOutputStringPath(Path.of(argumentManager.getOutputFilePath() + argumentManager.getOutputFilePrefix() + "strings.txt"));
            } else {
           setOutputFloatPath(Path.of(findJarDir() + argumentManager.getOutputFilePrefix() + "floats.txt"));
           setOutputIntPath(Path.of(findJarDir() + argumentManager.getOutputFilePrefix() + "integers.txt"));
           setOutputStringPath(Path.of(findJarDir() + argumentManager.getOutputFilePrefix() + "strings.txt"));
            }
    }
}
