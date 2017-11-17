package com.fredericboisguerin.insa;
import com.opencsv.*;

import java.io.FileReader;
import java.io.FileWriter;

public class FileManager {

    public FileManager(ContactsManager manager, String path) {
        try {
            CSVReader reader = new CSVReader(new FileReader(path));
            String[] nextLine;
            while ((nextLine = reader.readNext()) != null) {
                manager.addContact(nextLine[0],nextLine[1],nextLine[2]);
            }
        } catch (Exception e) {
            System.out.println("Fichier csv introuvable, vous allez en créer un nouveau si vous continuez");
        }
    }

    public void writeFile(String[] contact,String path){
        try (CSVWriter writer = new CSVWriter(new FileWriter(path,true))) {
            writer.writeNext(contact);
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
