package org.testTask.statistic;

import org.testTask.data.DataManager;

/*
Класс для формирования статистики.
Способ формирования полной статистики выбран исходя из соответсвия получаемой статистики требуемой в задании.
 */
public class StatisticFormer {
    private DataManager dataManager;

    //Конструктор класса.
    public StatisticFormer (DataManager dataManager){
        this.dataManager = dataManager;
    }

    //Методы для формирования полной статистики.
    public String getFullIntStatistic (){
        return dataManager.getIntResultList().stream()
                                            .mapToLong(a -> a)
                                            .summaryStatistics()
                                            .toString();
    }
    public String getFullFloatStatistic (){
        return dataManager.getFloatsResultList().stream()
                                                .mapToDouble(a -> a)
                                                .summaryStatistics()
                                                .toString();
    }
    public String getFullStringStatisticMax (){
        return dataManager.getStringResultList().stream()
                                                .map(String::length)
                                                .max(Integer::compareTo)
                                                .get()
                                                .toString();
    }
    public String getFullStringStatisticMin (){
        return dataManager.getStringResultList().stream()
                                                .map(String::length)
                                                .min(Integer::compareTo)
                                                .get()
                                                .toString();
    }

    //Методы для формирования краткой статистики.
    public int getNumberOfIntegers(){
        return dataManager.getIntResultList().size();
    }
    public int getNumberOfFloats(){
        return dataManager.getFloatsResultList().size();
    }
    public int getNumberOfStrings(){
        return dataManager.getStringResultList().size();
    }


}
