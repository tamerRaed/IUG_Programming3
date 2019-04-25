package collections.Q2;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Scanner;

public class Q2 {

    public static void main(String[] args) throws FileNotFoundException, IOException {

        HashMap<String, Integer> hashMap = new HashMap();

        File file = new File("D:\\files\\file.txt");
        Scanner s = new Scanner(file);

        while (s.hasNext()) {
            String word = s.next();
            System.out.println(word);

            Integer j1 = hashMap.get(word);
            if (j1 == null) {
                hashMap.put(word, 1);
            } else {
                hashMap.put(word, j1 + 1);
            }
            for (int i = 0; i < word.length(); i++) {

                Character chr = word.charAt(i);
                System.out.print(chr + "   ");

                Integer j2 = hashMap.get(chr.toString());
                if (j2 == null) {
                    hashMap.put(chr.toString(), 1);
                } else {
                    hashMap.put(chr.toString(), j2 + 1);
                }
            }

            System.out.println("\n" + hashMap);

        }
    }
}
