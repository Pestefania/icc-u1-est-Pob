package views;

import java.util.Scanner;
import models.Person;

public class View {
    private Scanner scanner = new Scanner(System.in);

    public int showMenu() {
        System.out.println("\n1. Agregar Persona");
        System.out.println("2. Ordenar Personas");
        System.out.println("3. Buscar Persona");
        System.out.println("4. Salir");
        System.out.print("Seleccione una opción: ");
        return scanner.nextInt();
    }

    public Person inputPerson() {
        System.out.print("Ingrese el nombre: ");
        String name = scanner.next();
        System.out.print("Ingrese la edad: ");
        int age = scanner.nextInt();
        return new Person(name, age);
    }

    public int selectSortingMethod() {
        System.out.println("\n1. Ordenar por nombre");
        System.out.println("2. Ordenar por edad");
        System.out.print("Seleccione un método de ordenamiento: ");
        return scanner.nextInt();
    }

    public int selectSearchCriterion() {
        System.out.println("\n1. Buscar por nombre");
        System.out.println("2. Buscar por edad");
        System.out.print("Seleccione un criterio de búsqueda: ");
        return scanner.nextInt();
    }

    public String inputName() {
        System.out.print("Ingrese el nombre a buscar: ");
        return scanner.next();
    }

    public int inputAge() {
        System.out.print("Ingrese la edad a buscar: ");
        return scanner.nextInt();
    }

    public void displayPersons(Person[] persons) {
        System.out.println("\nPersonas:");
        for (Person person : persons) {
            System.out.println(person);
        }
    }

    public void displaySearchResult(Person person) {
        if (person == null) {
            System.out.println("No se encontró ninguna persona.");
        } else {
            System.out.println("Resultado encontrado: " + person);
        }
    }
}
