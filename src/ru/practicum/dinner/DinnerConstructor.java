package ru.practicum.dinner;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

public class DinnerConstructor {
    HashMap<String, ArrayList<String>> availableDishes = new HashMap<>();
    Random                             samplerOfCombos = new Random();


    void addDish(String dishType, String dishName) {
        if (availableDishes.containsKey(dishType)) {
            availableDishes.get(dishType).add(dishName);
        } else {
            ArrayList<String> dishList = new ArrayList<>();
            dishList.add(dishName);
            availableDishes.put(dishType, dishList);
        }
    }

    void generateDishCombo(
            int numberOfCombos,
            ArrayList<String> typeDishesForCombos
    ) {
        ArrayList<String> combo = new ArrayList<>();

        for (int i = 0; i < numberOfCombos; i++) {
            for (String typeOfDish : typeDishesForCombos) {
                if (!availableDishes.containsKey(typeOfDish)) {
                    throw new RuntimeException("Тип " +
                                               typeOfDish +
                                               " Отсутствует в меню. " +
                                               "Повторите генерацию комбо");
                }

                ArrayList<String> dishesInType =
                        availableDishes.get(typeOfDish);
                combo.add(dishesInType.get(samplerOfCombos.nextInt(dishesInType.size())));
            }
            System.out.println("Комбо " + (i + 1));
            System.out.println(combo);
            combo.clear();
        }

    }
}
