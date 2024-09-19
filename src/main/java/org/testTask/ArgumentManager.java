package org.testTask;


import java.io.File;
import java.util.ArrayList;

/*
Класс для обработки аргументов командной строки.
 */
public class ArgumentManager {
    private String[] args;
    private Boolean appendOption = false;
    private Boolean fullStatistic = false;
    private Boolean shortStatistic = false;
    private Boolean prefixOption = false;
    private Boolean outputOption = false;
    private ArrayList<String> inputFiles = new ArrayList<>();
    private String outputFilePrefix = "";
    private String outputFilePath;

    //Конструктор класса.
    public ArgumentManager(String[] args) {
        this.args = args;
    }

    //Геттеры и сеттеры.
    public void setAppendOption(Boolean appendOption) {
        this.appendOption = appendOption;
    }

    public void setFullStatistic(Boolean fullStatistic) {
        this.fullStatistic = fullStatistic;
    }

    public void setShortStatistic(Boolean shortStatistic) {
        this.shortStatistic = shortStatistic;
    }

    public void setPrefixOption(Boolean prefixOption) {
        this.prefixOption = prefixOption;
    }

    public void setOutputOption(Boolean outputOption) {
        this.outputOption = outputOption;
    }

    public void setOutputFilePath(String outputFilePath) {
        this.outputFilePath = outputFilePath;
    }
    public void setOutputFilePrefix(String outputFilePrefix) {
        this.outputFilePrefix = outputFilePrefix;
    }

    public Boolean getAppendOption() {
        return appendOption;
    }

    public Boolean getFullStatistic() {
        return fullStatistic;
    }

    public Boolean getShortStatistic() {
        return shortStatistic;
    }

    public Boolean getPrefixOption() {
        return prefixOption;
    }

    public Boolean getOutputOption() {
        return outputOption;
    }

    public ArrayList<String> getInputFiles(){ return inputFiles; }

    public String getOutputFilePrefix() {
        return outputFilePrefix;
    }
    public String getOutputFilePath() {
        return outputFilePath;
    }

    /*
    Метод для обработки аргументов командной строки.
    Сообщение о присутствии недопустимого аргумента выводится в командную строку.
     */
    public void parseArgs() {
        for (int i = 0; i < args.length; i++){

            if (args[i].equals("-a")) {
                setAppendOption(true);

            } else if (args[i].equals("-p")) {
                setPrefixOption(true);
                setOutputFilePrefix(args[i + 1]);

            } else if (args[i].equals("-o")) {
                setOutputOption(true);
                setOutputFilePath(args[i + 1] + File.separator);

            } else if (args[i].equals("-f")) {
                setFullStatistic(true);

            } else if (args[i].equals("-s")) {
                setShortStatistic(true);

            } else if (args[i].endsWith(".txt")) {
                inputFiles.add(args[i]);
            }
            else if (!args[i - 1].equals("-o") && !args[i - 1].equals("-p")){
                System.out.println("Argument \"" + args[i] + "\" is not valid");
            }
        }
    }
}
