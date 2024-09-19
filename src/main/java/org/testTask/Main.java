package org.testTask;

import org.testTask.data.DataManager;
import org.testTask.file.AbsolutePathFormer;
import org.testTask.file.InputFileReader;
import org.testTask.file.OutputFileWriter;
import org.testTask.statistic.StatisticFormer;
import org.testTask.statistic.StatisticPrinter;

public class Main {

    public static void main(String[] args) {
        //Создание экземпляра класса ArgumentManager и вызов метода parseArgs() для обработки аргументов командной строки.
        ArgumentManager argumentManager = new ArgumentManager(args);
        argumentManager.parseArgs();

        //Создание экземпляра класса AbsolutePathFormer и вызов метода formAbsoluteOutputPath() для формирования
        //пути к файлам результатов
        AbsolutePathFormer absolutePathFormer = new AbsolutePathFormer(argumentManager);
        absolutePathFormer.formAbsoluteOutputPath();

        //Создание экземпляра класса InputFileReader
        InputFileReader inputFileReader = new InputFileReader(absolutePathFormer);

        //Создание экземпляра класса DataManager и вызов метода manageData для обработки данных, переденных
        //через аргумент метода.
        DataManager dataManager = new DataManager();
        dataManager.manageData(inputFileReader.readFiles());

        /*
        Создание экземпляра класса OutputFileWriter и вызов для данного экземпляра метода записи файлов результатов.
        В качестве аргументов подаются путь к файлам результатов и List, содержащий обработанные в DataManager значения
        для Float, String и int соответственно.
        */
        OutputFileWriter outputFileWriter = new OutputFileWriter(argumentManager);

        outputFileWriter.writeFiles(absolutePathFormer.getOutputFloatPath(), dataManager.getFloatsResultList());
        outputFileWriter.writeFiles(absolutePathFormer.getOutputStringPath(), dataManager.getStringResultList());
        outputFileWriter.writeFiles(absolutePathFormer.getOutputIntPath(), dataManager.getIntResultList());

        //Формирование статистики
        if (argumentManager.getFullStatistic() || argumentManager.getShortStatistic()){
            StatisticPrinter statisticPrinter = new StatisticPrinter(dataManager, new StatisticFormer(dataManager));
            if (argumentManager.getShortStatistic()){
                statisticPrinter.printShortStatistic();
            }
            if (argumentManager.getFullStatistic()){
                statisticPrinter.printFullStatistic();
            }
        }
    }
}