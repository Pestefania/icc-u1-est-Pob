package controllers;

import models.Person;

public class SearchMethods {
    // Verificar si el arreglo está ordenado por edad
    public boolean isSortedByAge(Person[] persons) {
        for (int i = 1; i < persons.length; i++) {
            if (persons[i - 1].getAge() > persons[i].getAge()) {
                return false;
            }
        }
        return true;
    }

    // Verificar si el arreglo está ordenado por nombre
    public boolean isSortedByName(Person[] persons) {
        for (int i = 1; i < persons.length; i++) {
            if (persons[i - 1].getName().compareTo(persons[i].getName()) > 0) {
                return false;
            }
        }
        return true;
    }

    // Búsqueda binaria por edad
    public Person binarySearchByAge(Person[] persons, int age) {
        int left = 0;
        int right = persons.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (persons[mid].getAge() == age) {
                return persons[mid];
            } else if (persons[mid].getAge() < age) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return null;
    }

    
    public Person binarySearchByName(Person[] persons, String name) {
        int left = 0;
        int right = persons.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            int comparison = persons[mid].getName().compareTo(name);
            if (comparison == 0) {
                return persons[mid];
            } else if (comparison < 0) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return null; 
    }
}
