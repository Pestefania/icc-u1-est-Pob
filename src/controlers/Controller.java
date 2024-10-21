package controllers;

import models.Person;
import views.View;

public class Controller {
    private View view; 
    private SortingMethods sortingMethods;
    private SearchMethods searchMethods;

    private Person[] personas; 

    public Controller(View view, SortingMethods sortingMethods, SearchMethods searchMethods){
        this.view = view;
        this.sortingMethods = sortingMethods;
        this.searchMethods = searchMethods;
        System.out.println("Contoller created");
    }

    public void start(){
        int option = 0;
        do{
            option = view.showMenu();
            switch (option) {
                case 1:
                    inputPersonas();
                    break;
                    case 2:
                    addPerson();
                    break;
                    case 3:
                    sortPersons();
                case 100:
                    System.out.println("Adios");
                    break;
            
                default:
                    System.out.println("Opcion no valida");
            }
        }while(option != 0);
    }

    prublic void sortPersons() {
        int sortingOption = view.selectSortingMethod();
        if(sortingOption == 1) {
            sortingMethods.sortByNameWithBuble(personas);
        }else if (sortingOption == 2) {
            sortingMethods.sortBy
        }else {
            view.showMessage("Opcion invalida");
        }
    }

    public void inputPersons(){
        int numeroPersonas = view.inputInt("Ingrese el numero de personas: ");
        personas = new Person[numeroPersonas];
        for (int i=0; i < numeroPersonas; i++){
            personas[i] = view.inputPerson();
        }
    }

    public void addPerson() {

        if (personas == null) {
            view.showMenu();;
        }else {
            int numeroPersonas = view.inputInt("Ingrese el numero de personas: ");

            Person[] personasTotales = new Person[personas.length + numeroPersonas];
    
            for (int i = 0; i < personas.length; i++) {
                personasTotales[i] = personas[i];
            }
    
            for (int i = personas.length; i < personasTotales.length; i++) {
                personas[i] = view.inputPerson();
            }
    
            personas = personasTotales;
        }
    }
}