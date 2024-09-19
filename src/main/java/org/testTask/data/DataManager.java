package org.testTask.data;

import java.util.ArrayList;
import java.util.List;

/*
    Класс для обработки данных из входных файлов. Все значения из входных файлов распределяются в списки
   в соответствие с типом данных. Отдельно стоит отметить: в рамках данной реализации, к String относится
   любое значение, не являющееся Long или Float, в том числе символы, знаки пробела и перевода строки т.к. это может
   быть необходимо в определенных обстоятельствах.
*/
public class DataManager {
    private ArrayList<String> stringResultList = new ArrayList<>();
    private ArrayList<Float> floatsResultList = new ArrayList<>();
    private ArrayList<Long> intResultList = new ArrayList<>();
    private int maxLines = 0;

    public ArrayList<String> getStringResultList() {
        return stringResultList;
    }

    public ArrayList<Float> getFloatsResultList() {
        return floatsResultList;
    }

    public ArrayList<Long> getIntResultList() {
        return intResultList;
    }

/*
Данный метод (manage) считывет по очереди первую строку из каждого файла, проверяет значение на соответствие
типам данных Long и Float и добавляет его в соответствующий список результатов (intResultList и floatResultList).
Если значение не соответствует Long и Float, оно считается строкой и добавляется в список результатов stringResultList.
Затем, аналогичным образом считываются последующие строки. Вплоть до последней из файла с наибольшим количеством строк.
В качестве аргумента передается двумерный список, где i соответствует входному файлу, а j - номеру строки.
*/
    public void manageData(ArrayList<List<String>> arrayList){

        //Определяем максимальное количество строк среди входных файлов
        for (List<String> currentFile : arrayList){
            if (currentFile.size()> maxLines) {
                maxLines = currentFile.size();
            }
        }
        for (int j = 0; j < maxLines; j++){
            for(int i = 0; i < arrayList.size(); i++){
                if (arrayList.get(i).size() > j){
                    if (isNumericInt(arrayList.get(i).get(j))){
                        intResultList.add(Long.parseLong(arrayList.get(i).get(j)));
                    } else if (isNumericFloat(arrayList.get(i).get(j))) {
                        floatsResultList.add(Float.parseFloat(arrayList.get(i).get(j)));
                    } else {
                        stringResultList.add(arrayList.get(i).get(j));
                    }
                }
            }
        }
    }

    //Метод для проверки значения на соответсвие типу данных Long.
    public static boolean isNumericInt(String str) {
        try {
            Long.parseLong(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    //Метод для проверки значения на соответсвие типу данных Float.
    public static boolean isNumericFloat(String str) {
        try {
            Float.parseFloat(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
