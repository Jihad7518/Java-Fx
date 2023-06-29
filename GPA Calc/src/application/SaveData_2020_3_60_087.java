package application;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class SaveData_2020_3_60_087 {
	public static void main(String args) {
        File myObj = new File("ID.txt");

        try {
            Files.write(Paths.get("ID.txt"), args.getBytes(), StandardOpenOption.APPEND);
        } catch (IOException e) {
            //exception handling left as an exercise for the reader
        }
    }

}
