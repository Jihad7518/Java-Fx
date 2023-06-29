package application;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

public class SaveDataToFile_2020_3_60_087 {
private static final String filepath="F:\\";
 
    public static void WriteObjectToFile(Object serObj) {
 
        try {
 
            FileOutputStream fileOut = new FileOutputStream(filepath);
            ObjectOutputStream objectOut = new ObjectOutputStream(fileOut);
            objectOut.writeObject(serObj);
            objectOut.close();
            System.out.println("The Object  was succesfully written to a file");
 
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}

