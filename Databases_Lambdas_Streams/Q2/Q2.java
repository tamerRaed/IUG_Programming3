/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Databases_Lambdas_Streams.Q2;

/**
 *
 * @author hp
 */
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class Q2 {

    public static void main(String[] args) throws IOException {
        
        File file = new File("C:\\Users\\hp\\Documents\\NetBeansProjects\\Programming3\\src\\Databases_Lambdas_Streams\\Q2\\text.txt");
        FileInputStream fileInputStream = new FileInputStream(file);
        InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream);
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

        StringBuilder stringBuilder = new StringBuilder();
        while (bufferedReader.ready()) {
            stringBuilder.append(bufferedReader.readLine()).append("\n");
        }
        System.out.println(stringBuilder);

        operation count = (string) -> {

            HashMap<String, Integer> hashMap = new HashMap();

            for (int i = 0; i < string.length(); i++) {
                Character character = string.charAt(i);
                Integer j = hashMap.get(character.toString());
                if (j == null) {
                    hashMap.put(character.toString(), 1);
                } else {
                    hashMap.put(character.toString(), j + 1);
                }
            }
            return hashMap;
        };

        System.out.println(count.operation(stringBuilder.toString()));
        
    }

    interface operation {

        Object operation(String text);
    }
}
