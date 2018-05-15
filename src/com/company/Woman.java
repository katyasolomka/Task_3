package com.company;

import java.util.Random;
import java.util.Scanner;

public class Woman extends Human {
            Woman(boolean gender, String name, String surname, float height, float weight) {
            super(false, name, surname, height, weight);
        }

        Human GiveABirth(Man man) {
            boolean i = new Random().nextBoolean();
            if (i) {
                System.out.println("Мальчик.\nВведите имя: ");
                String name = new Scanner(System.in).nextLine();
                String surname = man.getSurname();
                float height = (float) (man.getHeight() + (0.1 * man.getHeight()-this.getHeight()));
                float weight = (float) (man.getWeight() + (0.1 * man.getWeight() - this.getWeight()));
                return new Man(true, name, surname, height, weight);
            } else {
                System.out.println("Девочка.\nВведите имя: ");
                String name = new Scanner(System.in).nextLine();
                String surname = man.getSurname();
                float height = (float) (man.getHeight() + (0.1 * man.getHeight()-this.getHeight()));
                float weight = (float) (man.getWeight() + (0.1 * man.getWeight() - this.getWeight()));
                return new Man(true, name, surname, height, weight);
            }
        }
}
