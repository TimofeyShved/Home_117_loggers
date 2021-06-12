package com.AWT;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.LogManager;
import java.util.logging.Logger;

public class Main {
    static Logger LOGGER; // создание логов
    private static final java.util.logging.LogManager LogManager = null; // лог менеджер

    static {
        try(FileInputStream ins = new FileInputStream("log.config")){ //полный путь до файла с конфигами
            LogManager.getLogManager().readConfiguration(ins);  // считывание конфигурации
            LOGGER = Logger.getLogger(Main.class.getName()); // имя иследуемого класса
        }catch (Exception ignore){
            ignore.printStackTrace(); // ошибка
        }
    }

    public static void main(String[] args) { // начало программы
        try {
            LOGGER.log(Level.INFO,"Начало main, создаем лист с типизацией Integers"); // логи
            List<Integer> ints = new ArrayList<Integer>();
            ints.add(5);
            LOGGER.log(Level.INFO,"присваиваем лист Integers листу без типипзации");// логи
            List empty = ints;
            LOGGER.log(Level.INFO,"присваиваем лист без типипзации листу строк");// логи
            List<String> string = empty;
            LOGGER.log(Level.WARNING,"добавляем строку \"бла бла\" в наш переприсвоенный лист, возможна ошибка");// логи
            string.add("бла бла");
            LOGGER.log(Level.WARNING,"добавляем строку \"бла 23\" в наш переприсвоенный лист, возможна ошибка");// логи
            string.add("бла 23");
            LOGGER.log(Level.WARNING,"добавляем строку \"бла 34\" в наш переприсвоенный лист, возможна ошибка");// логи
            string.add("бла 34");


            LOGGER.log(Level.INFO,"выводим все элементы листа с типизацией Integers в консоль");// логи
            for (Object anInt : ints) {
                System.out.println(anInt);
            }

            LOGGER.log(Level.INFO,"Размер равен " + ints.size());// логи
            LOGGER.log(Level.INFO,"Получим первый элемент");// логи
            Integer integer = ints.get(0);
            LOGGER.log(Level.INFO,"выведем его в консоль");// логи
            System.out.println(integer);

        }catch (Exception e){
            LOGGER.log(Level.WARNING,"что-то пошло не так" , e);// логи
        }
    }
}
