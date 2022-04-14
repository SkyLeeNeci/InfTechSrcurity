package com.company;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {

        String text = "";
        char[] textChars;
        String allSymbols = " оаинірвесдмтукплзьячгжбюєшйхщїцфґ"; // рвкпітдзужофхсмнйюбщеигєалчїшцьяґ оаинірвесдмтукплзьячгжбюєшйхщїцфґ ОНАИВТІРЕСКМУДЛПЗЯЬБГЧХЇЦШЙЖЮЄЩФҐ
        char[] ideal = allSymbols.toLowerCase().toCharArray();
        System.out.println(ideal);

        String fileName = "text20Incrypt.txt"; //text160Incrypt.txt
        Path path = Paths.get(fileName);
        Scanner scanner = new Scanner(path);

        scanner.useDelimiter(System.getProperty("line.separator"));
        while (scanner.hasNext()) {
            text += scanner.next();
        }
        scanner.close();
        textChars = text.toLowerCase().toCharArray();

        System.out.println(textChars);

        int counter = 0;
        ArrayList<Integer> popularInText = new ArrayList<>();

        for (int i = 0; i < ideal.length; i++) {
            for (int j = 0; j < textChars.length; j++) {
                if (ideal[i] == textChars[j]) {
                    counter++;
                }
            }
            popularInText.add(counter);
            counter = 0;
        }
        for (Integer integer : popularInText) {
            System.out.print(integer + "\t");
        }

        System.out.println(" ");

        for (int i = 0; i < ideal.length; i++) {
            System.out.print(ideal[i] + "\t");
        }


        System.out.println(" ");

        HashMap<Character, Integer> popular = new HashMap<>();
        ArrayList<Character> popularChar = new ArrayList<>();
        ArrayList<Character> popularInt = new ArrayList<>();

        for (int i = 0; i < ideal.length; i++) {
            popular.put(ideal[i], popularInText.get(i));
        }
        popular.entrySet().stream()
                .sorted(Map.Entry.<Character, Integer>comparingByValue().reversed())
                .forEach((k) -> popularChar.add(k.getKey()));

        for (Character charr : popularChar
        ) {
            System.out.print(charr + "\t");
        }

        System.out.println("=====================================================");
        List<Character> chars = new ArrayList<>();
        for (char c : textChars) {
            chars.add(c);
        }

            for (int j = 0; j < textChars.length; j++) {
                for (int i = 0; i < popularChar.size(); i++) {
                if (textChars[j] == popularChar.get(i)) {
                    textChars[j] = ideal[i];
                    break;
                }
            }
                popularInt.add(chars.get(j));
                System.out.print(textChars[j]);
        }
    }
}
