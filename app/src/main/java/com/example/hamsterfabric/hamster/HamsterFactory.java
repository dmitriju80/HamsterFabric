package com.example.hamsterfabric.hamster;



import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class HamsterFactory {

    static final Scanner scanner = new Scanner(System.in);
List <Hamster> hamsterband = new ArrayList<>();

    public void start() {
        try {
            while (true) {
                System.out.println("Введите команду...");

                //String commandName = scanner.nextLine();

                //не знаю как ввести данные со scaner
                hamsterband.add(new Hamster("Василий"));
                hamsterband.add(new Hamster("Никита,на"));

                String commandName = "Размер";


                if ("Завершить" == commandName){
                    System.out.println("Программа завершена! Спасибо за то, что пользуетесь нашей сетью хомячих фабрик");
                    break;}

                Command command=new Command();
                command.execute(commandName, this);

               for (Hamster hamster : hamsterband){
                   System.out.println(hamster.toString());
               }

                break;//удалить!
            }
        } catch (Exception e) {
            System.out.println("Ошибка выполнения: " + e.getMessage());
        }
    }




}
