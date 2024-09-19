package org.testTask.statistic;

import org.testTask.data.DataManager;

//Класс для формирования и вывода статистики в командную строку.
public class StatisticPrinter {

    private DataManager dataManager;
    private StatisticFormer statisticFormer;


    //Конструктор класса.
    public StatisticPrinter(DataManager dataManager, StatisticFormer statisticFormer) {
        this.dataManager = dataManager;
        this.statisticFormer = statisticFormer;
        }

    //Метод для формирования и вывода краткой статистики.
    public void printShortStatistic(){
        System.out.println("--- Short statistic ---");
        System.out.println("Number of strings: " + statisticFormer.getNumberOfStrings());
        System.out.println("Number of integers: " + statisticFormer.getNumberOfIntegers());
        System.out.println("Number of floats: " + statisticFormer.getNumberOfFloats());
    }

    //Метод для вывода полной статистики.
    //В случае, если данные какого-либо типа отсутствуют выводится соответствующее оповещение.
    public void printFullStatistic(){
        System.out.println("--- Full Statistic ---");
        if (!dataManager.getStringResultList().isEmpty()){
            System.out.println("Number of strings: " + statisticFormer.getNumberOfStrings());
            System.out.println("Max length of string: " + statisticFormer.getFullStringStatisticMax());
            System.out.println("Min length of string: " + statisticFormer.getFullStringStatisticMin());
        } else {
            System.out.println("Strings missing");
        }

        if (!dataManager.getIntResultList().isEmpty()){
            System.out.println("Integers statistic: " + statisticFormer.getFullIntStatistic());
        } else {
            System.out.println("Integers missing");
        }

        if (!dataManager.getFloatsResultList().isEmpty()){
            System.out.println("Floats statistic: " + statisticFormer.getFullFloatStatistic());
        } else {
            System.out.println("Floats missing");
        }
    }
}
