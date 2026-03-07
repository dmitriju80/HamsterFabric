package com.example.hamsterfabric.hamster;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class Command {

    public void execute (String commandName, HamsterFactory hamsterFactory){

/*
"Печать" — печатать на экран всех хомяков в хранилище.
"Создать [Имя]" — создать хомяка с именем [Имя].
"Удалить [Индекс]" — удалить хомяка по индексу [Индекс].
"Очистить" — очистить хранилище от хомяков.
"Заменить Индекс [Имя]" — заменить хомяка под индексом [Индекс] на нового с указанным в параметре [Имя] именем.
"Размер" — показать текущее количество хомяков в хранилище.
 */

        //посимвольная проверка команды
        //char [] commandNameSymb = commandName.toCharArray();
        String commandNameOnly="";
        String commandIndex="";
        boolean commandIndexStart=false;
        boolean commandIndexFinish=false;
        for (char symbol : commandName.toCharArray()){
            if ( (('[' != symbol)||('[' != symbol)) && (true!=commandIndexStart)&&(!commandIndexFinish)&&(' '!=symbol)){
                commandNameOnly += symbol;
            }
            else if ('['==symbol){
                commandIndexStart=true;
            }
            else if (']'==symbol){
                commandIndexFinish=true;
            }

            if ((true == commandIndexStart ) && (false == commandIndexFinish ) && ('['!=symbol)){
                commandIndex+=symbol;
            }
        }

        System.out.println(commandName);
        System.out.println("Команда:"+ commandNameOnly + ".   Индекс:" + commandIndex + ".");

        switch (commandNameOnly){
            case "Печать":
                executePrint(hamsterFactory);
            break;
            case "Создать":
                executeCreate(hamsterFactory,commandIndex);
            break;
            case "Удалить":
                executeRemoveByIndex(hamsterFactory,Integer.parseInt(commandIndex));
            break;
            case "Очистить":
                executeClear(hamsterFactory);
                break;
            case "Заменить":
                executeSet(hamsterFactory, commandIndex);
                break;
            case "Размер":
                executeSize(hamsterFactory);
                break;
        }
    }

    public void executePrint(HamsterFactory hamsterFactory) {
        System.out.println("Вывожу актуальный список хомяков в хранилище:");
        //... // вам нужно напечатать всех хомяков, которые есть в хранилище
for (Hamster hamster : hamsterFactory.hamsterband){
    System.out.println(hamster.toString());
}
    }

    public void executeCreate(HamsterFactory hamsterFactory,String name) {
        // ... // создайте хомяка с именем [name] и добавьте его в ваше хранилище
        hamsterFactory.hamsterband.add(new Hamster(name));
        // ... // выведите сообщение: "Хомяк '[name]' создан и добавлен в хранилище"
        System.out.println ("Хомяк " + name + " создан и добавлен в хранилище");
    }

    public void executeRemoveByIndex(HamsterFactory hamsterFactory,int index) {
        // ... // если хомяк существует - удалить его и вывести в лог сообщение: "Хомяк '[Имя удалённого хомяка]' удалён успешно"
        if ((hamsterFactory.hamsterband.size() > index) && (0<=index)){
    String name = hamsterFactory.hamsterband.get(index).toString();
    hamsterFactory.hamsterband.remove(index);
    System.out.println ("Хомяк " + name + " удален успешно");
}
else {
    System.out.println ("Хомяка по заданному индексу не существует");
}
        // ... // иначе вывести в лог сообщение: "Хомяка по заданному индексу не существует"
    }

    public void executeClear(HamsterFactory hamsterFactory) {
        hamsterFactory.hamsterband.clear();
        // ... // очистить хранилище и вывести в лог сообщение: "Операция очистки завершена успешно! Все хомяки были удалены из хранилища"
        System.out.println ("Операция очистки завершена успешно! Все хомяки были удалены из хранилища");
    }

    public void executeSet(HamsterFactory hamsterFactory, String IndexName) {
        String prevName = "";
        String name = "";
        String indexStr = "";
        Boolean yesIndex=false;
        for (char symb : IndexName.toCharArray()){
            if ((' '==symb)&&(!yesIndex)){yesIndex=true;}
            else if (!yesIndex){indexStr+=symb;}
            else {name+=symb;}
        }
        int index=Integer.parseInt(indexStr);


        if ((hamsterFactory.hamsterband.size() > index) && (0<=index)){
            prevName = hamsterFactory.hamsterband.get(index).toString();
            hamsterFactory.hamsterband.remove(index);
            hamsterFactory.hamsterband.add(index,new Hamster(name));
            System.out.println (prevName + " был успешно заменён на хомяка " + name);
        }
        else {
            System.out.println ("Хомяка по заданному индексу не существует");
        }

        // ... // создайте хомяка с именем [name] и замените им хомяка на позиции [index]
        // ... // выведите сообщение "Хомяк '[Имя удалённого хомяка]' был успешно заменён на хомяка '[Имя нового хомяка]'"
    }

    public void executeSize(HamsterFactory hamsterFactory) {
        if (1>hamsterFactory.hamsterband.size()){
            System.out.println ("В хранилище нет хомяков");
        }
        else {
            int countHamsters=0;
            for (Hamster hamster : hamsterFactory.hamsterband){
                countHamsters++;
            }
            System.out.println ("Количество хомяков в хранилище равно " + countHamsters);
        }
        //... // если в хранилище есть хомяки - вывести в лог: "Количество хомяков в хранилище равно [текущее количество хомяков в хранилище]"
        // ... // иначе - вывести в лог: "В хранилище нет хомяков"
    }

    public void showErrorMessage() {
        //... // вывести сообщение: "Неверная команда, попробуйте ещё раз."
    }
}
