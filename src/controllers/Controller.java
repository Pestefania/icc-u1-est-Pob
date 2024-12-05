package controllers;

import java.util.ArrayList;
import java.util.List;
import models.Person;
import views.View;

public class Controller {
    private View view;
    private List<Person> persons;
    private SortingMethods sortingMethods;
    private SearchMethods searchMethods;

    
    public Controller(View view, SortingMethods sortingMethods, SearchMethods searchMethods) {
        this.view = view;
        this.persons = new ArrayList<>();
        this.sortingMethods = sortingMethods;
        this.searchMethods = searchMethods;
    }

    
    public void start() {
        boolean running = true;
        while (running) {
            int choice = view.showMenu();
            switch (choice) {
                case 1 -> inputPersons();
                case 2 -> sortPersons();
                case 3 -> searchPerson();
                case 4 -> {
                    System.out.println("Saliendo del programa...");
                    running = false;
                }
                default -> System.out.println("Opción no válida. Intentar otra vez.");
            }
        }
    }

    // Método para agregar personas
    public void inputPersons() {
        Person person = view.inputPerson();
        persons.add(person);
        System.out.println("Persona añadida con éxito.");
    }

    // Método para ordenar personas
    public void sortPersons() {
        if (persons.isEmpty()) {
            System.out.println("No hay personas para ordenar.");
            return;
        }
        int method = view.selectSortingMethod();
        Person[] personArray = persons.toArray(new Person[0]);
        switch (method) {
            case 1 -> sortingMethods.sortByNameWithBubble(personArray);
            case 2 -> sortingMethods.sortByNameWithSelectionDes(personArray);
            case 3 -> sortingMethods.sortByAgeWithInsertion(personArray);
            case 4 -> sortingMethods.sortByNameWithInsertion(personArray);
            default -> {
                System.out.println("Método de clasificación no válido.");
                return;
            }
        }
        persons.clear();
        for (Person person : personArray) {
            persons.add(person);
        }
        System.out.println("Personas ordenadas con éxito:");
        view.displayPersons(personArray);
    }

    // Método para buscar una persona
    public void searchPerson() {
        if (persons.isEmpty()) {
            System.out.println("No hay personas para buscar.");
            return;
        }
        int criterion = view.selectSearchCriterion();
        Person[] personArray = persons.toArray(new Person[0]);
        Person result = null;
        switch (criterion) {
            case 1 -> {
                if (!searchMethods.isSortedByAge(personArray)) {
                    System.out.println("El arreglo no está ordenado por edad. Ordenando...");
                    sortingMethods.sortByAgeWithInsertion(personArray);
                }
                int age = view.inputAge();
                result = searchMethods.binarySearchByAge(personArray, age);
            }
            case 2 -> {
                if (!searchMethods.isSortedByName(personArray)) {
                    System.out.println("El arreglo no está ordenado por nombre. Ordenando...");
                    sortingMethods.sortByNameWithBubble(personArray);
                }
                String name = view.inputName();
                result = searchMethods.binarySearchByName(personArray, name);
            }
            default -> {
                System.out.println("Criterio de búsqueda no válido.");
                return;
            }
        }
        if (result != null) {
            System.out.println("Persona encontrada:");
            System.out.println(result);
        } else {
            System.out.println("Persona no encontrada.");
        }
    }
}
