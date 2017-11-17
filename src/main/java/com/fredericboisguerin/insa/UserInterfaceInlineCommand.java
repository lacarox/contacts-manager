package com.fredericboisguerin.insa;

import java.util.Scanner;

public class UserInterfaceInlineCommand {
    public static void main(String args[]) throws InvalidContactNameException,InvalidEmailException{
        ContactsManager manager = new ContactsManager();
        FileManager File = new FileManager(manager,"src/main/java/com/fredericboisguerin/insa/db.csv");


        Scanner sc = new Scanner(System.in);
        String str;
        do{
            System.out.println("-------------------------------------------- \n" +
                    "Liste des commandes disponible : \n" +
                    " - Show -> pour visualiser les contacts\n" +
                    " - Add -> pour ajouter un contact\n" +
                    " - Search -> pour rechercher un contact\n" +
                    " - Exit -> pour quitter\n" +
                    "--------------------------------------------\n");
            str = sc.nextLine().toLowerCase();
            str.replaceAll(" ","");
            switch(str){
                case "show":
                    manager.printAllContacts();
                    break;
                case "add":
                    System.out.println("Nom :");
                    String name = sc.nextLine();

                    System.out.println("Email :");
                    String email = sc.nextLine();

                    System.out.println("Telephone :");
                    String phone = sc.nextLine();
                    try {
                        manager.addContact(name, email, phone);
                        String[] contactToWrite = {name,email,phone};
                        File.writeFile(contactToWrite,"src/main/java/com/fredericboisguerin/insa/db.csv");
                        System.out.println("Contact ajouté");
                    }catch(InvalidEmailException e){
                        System.out.println("Email non valide !");
                    }catch (Exception e){
                        e.printStackTrace();
                    }

                    break;
                case "search":
                    System.out.println("Nom :");
                    String nameSearch = sc.nextLine();

                    System.out.println("Résultat de la recherche :");
                    manager.searchContactByName(nameSearch);
                    break;
                case "exit":
                    break;
                default:
                    System.out.println("Unknown Command");
                    break;
            }
        }while(!str.equals("exit"));
        sc.close();
    }
}
