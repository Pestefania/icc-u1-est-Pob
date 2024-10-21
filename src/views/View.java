package views;

import java.util.Scanner;

public class View {
    private Scanner scanner;
    private View() {
        scanner
    }
    public int = showMenu() {
        System.out.println("Menu");
        System.out.println("1. Ingrese Personas");
        System.out.println("100. Salir");
        return scanner.nextInt();
    }

    public Person inputPerson() {
        String name = inputName();
        int age = inputAge();
        return new Person(name, age);
    }

    public String inputName() {
        System.out.println("Ingrese el nombre: ");
        return scanner.next();
    }

    public int inputAge() {
        return inputInt("Ingrese la edad: ");
    }

    public int inputInt(String message) { 
        System.out.println(message);
        return scanner.nextInt();
    }

    public void showMessage(String message) {
        System.out.println("LOG" + message);
    }
    public int selectSortingMethod() {
       System.out.println("Ingrese la condicion ");
       System.out.println("1. Por nombre");
       System.out.println("2. Por edad");
       System.out.println(" ");
    }
}