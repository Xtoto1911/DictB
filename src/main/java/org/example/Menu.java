package org.example;

import java.io.IOException;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Menu {
    private final LatinDictionary latinDictionary;
    private final NumDictionary numDictionary;

    private final Scanner scanner;

    private final List<String> mainMenu = Arrays.asList(
            "1. Словарь с цифрами", "2. Словарь с латинскими буквами","3. Показать содержимое обоих словарей","4. Выход"
    );

    private final List<String> operMenu = Arrays.asList(
            ""
    );

     public Menu() throws IOException {
         latinDictionary = new LatinDictionary("latinFile.txt");
         numDictionary = new NumDictionary("numFile.txt");
         scanner = new Scanner(System.in);
     }

     private void operMenu(AbsDictionary dictionary){

     }

     public void start(){
        boolean flag = true;
        while (flag){
            try {
            mainMenu.forEach(System.out::println);
            switch (scanner.nextLine()){
                case ("1"):
                    break;
                case ("2"):
                    break;
                case("3"):
                    break;
                case ("4"):
                    flag = false;
                    break;
                default:
                    System.out.println("Такого действия нет!");
            }
            }catch (Exception e){
                System.out.println(e.getMessage());
            }
        }
     }
}
