package com.fredericboisguerin.insa;
import java.util.Scanner;

public class UserInterfaceInlineCommand {
    public static void main(String args[]){
        ContactsManager manager = new ContactsManager();

        Scanner sc = new Scanner(System.in);
        int i;
        do{
            System.out.println("1- List des contacts \n2- Ajouter un contact \n3- Rechercher un contacts par son nom \n5- Quitter\n");
            i = sc.nextInt();

            switch(i){
                case 1:

                    break;
                case 2:
                    break;
                case 5:
                    sc.close();
                    break;
            }
        }while(i!=5);

    }
}
