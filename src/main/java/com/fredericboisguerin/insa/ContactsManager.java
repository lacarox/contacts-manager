package com.fredericboisguerin.insa;

import java.util.ArrayList;

public class ContactsManager {

    ArrayList<Contact> listContact = new ArrayList<Contact>();

    public void addContact(String name, String email, String phoneNumber) throws InvalidContactNameException,InvalidEmailException{
        if(name == null || name.isEmpty()){
            throw new InvalidContactNameException();
        }else if (email != null && (!(email.matches("\\w+[@]\\w+[.]\\w+")))) {
            throw new InvalidEmailException();
        }else{
            Contact newContact = new Contact(name, email, phoneNumber);
            listContact.add(newContact);
        }
    }

    public void printAllContacts() {
        for (int i=0; i<listContact.size(); i++){
            System.out.println(listContact.get(i).toString());
        }
    }

    public void searchContactByName(String name) {
        for (int i=0; i<listContact.size(); i++){
            if(listContact.get(i).name.toLowerCase().contains(name)){
                System.out.println(listContact.get(i).toString());
            }
        }
    }
}
