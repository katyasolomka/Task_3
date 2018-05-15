package com.company;

import  java.util.Random;

public abstract class Human {
    private boolean Gender;
    private String Name;
    private String Surname;
    private float Height;
    private float Weight;

    public boolean isGender() {
        return Gender;
    }

    public String getName() {
        return Name;
    }

    public String getSurname() {
        return Surname;
    }

    public float getHeight() {
        return Height;
    }

    public float getWeight() {
        return Weight;
    }

    public Human(boolean gender, String name, String surname, float height, float weight) {

        Gender = gender;
        Name = name;
        Surname = surname;
        Height = height;
        Weight = weight;
    }

    public boolean Speak(Human human) {
        if (!this.Gender && !human.Gender)
            return true;
        if (!this.Gender && human.Gender)
            return true;
        if (this.Gender && !human.Gender)
            return true;
        if (this.Gender && human.Gender)
            return new Random().nextBoolean();
        return false;
    }

    public boolean BeInSociety(Human human) {
        if (!this.Gender && !human.Gender) {
            int random = new Random().nextInt(20);
            if (random == 1)
                return true;
        }
        if (!this.Gender && human.Gender) {
            int i = new Random().nextInt(10);
            if (i > 0 && i <= 7)
                return true;
        }
        if (this.Gender && !human.Gender) {
            int i = new Random().nextInt(10);
            if (i > 0 && i <= 7)
                return true;
        }
        if (this.Gender && human.Gender) {
            return new Random().nextInt(18) == 1;
        }
        return false;
    }

    public void setGender(boolean gender) {
        Gender = gender;
    }

    public void setName(String name) {
        Name = name;
    }

    public void setSurname(String surname) {
        Surname = surname;
    }

    public void setHeight(float height) {
        Height = height;
    }

    public void setWeight(float weight) {
        Weight = weight;
    }

    @Override
    public String toString() {
        if (this.Gender)
            return "Man{" +
                    "Name='" + Name + '\'' +
                    ", Surname='" + Surname + '\'' +
                    ", Height=" + Height +
                    ", Weight=" + Weight +
                    '}';
        else
            return "Woman{" +
                    "Name='" + Name + '\'' +
                    ", Surname='" + Surname + '\'' +
                    ", Height=" + Height +
                    ", Weight=" + Weight +
                    '}';
    }
    public boolean Togetherwith(Human human) {
        float percent = (100 * human.Height) / this.Height - 100;
        int i = new Random().nextInt(100);
        if (percent > 10) {
            return i < 85;
        } else
            return i < 95;
    }
    public Human Relationships(Human human) {
        Woman woman;
        Human human1;
        if (this.Speak(human) && this.BeInSociety(human) && this.Togetherwith(human)) {
            if (this.Gender == human.Gender) {
                System.out.println(this.getName() + " и " + human.getName() + " одного и того же пола.");
                return null;
            } else {
                if (this.Gender) {
                    woman = (Woman) human;
                    human1 = woman.GiveABirth((Man) this);
                    return human1;
                } else {
                    woman = (Woman) this;
                    human1 = woman.GiveABirth((Man) human);
                    return human1;
                }
            }
        }
        System.out.println("Разошлись");
        return null;
    }
}
