package incrypt;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class Icrypt {

    public static void main(String[] args) throws IOException {
        encryptFiles("text160.txt", "text160Incrypt.txt");
        encryptFiles("text500.txt", "text500Incrypt.txt");
        encryptFiles("text20.txt", "text20Incrypt.txt");
    }

    public static void encryptFiles(String from, String to) throws IOException {
        String text = "";
        char[] textChars;
        String stringAlphabet = "абвгґдеєжзиіїйклмнопрстуфхцчшщ ьюяа";
        char[] alphabet = stringAlphabet.toLowerCase().toCharArray();


        Path path = Paths.get(from);
        Scanner scanner = new Scanner(path);

        scanner.useDelimiter(System.getProperty("line.separator"));
        while (scanner.hasNext()) {
            text += scanner.next();
        }
        scanner.close();
        textChars = text.toLowerCase().toCharArray();

        //System.out.println(textChars);

        for (int i = 0; i<textChars.length;i++){
            for (int j = 0 ; j<alphabet.length-1; j++){
                if (textChars[i] == alphabet[j]){
                    textChars[i] = alphabet[j+1];
                    break;
                }
            }

        }
        //System.out.println(textChars);

        File output = new File(to);
        FileWriter writer = new FileWriter(output);

        writer.write(textChars);
        writer.flush();
        writer.close();
    }
}
