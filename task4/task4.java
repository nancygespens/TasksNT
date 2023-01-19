package com.company.task4;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;


public class Task4 {
    public static void main(String[] args) {

        try{
            String path = args[0];
            BufferedReader readerOne = new BufferedReader(new FileReader(path));

            ArrayList<Integer> array = new ArrayList<>();

            String line;
            while((line = readerOne.readLine()) != null){
                array.add(Integer.parseInt(line));
            }

            int arithmeticMean = 0;
            int count = 0;
            for (int i = 0; i < array.size(); i++) {
                arithmeticMean += array.get(i);
            }
            arithmeticMean = arithmeticMean / array.size();

            for (int i = 0; i < array.size(); i++) {
                while(array.get(i) != arithmeticMean) {
                    if (array.get(i) < arithmeticMean) {
                        array.set(i, array.get(i) + 1);
                    } else if (array.get(i) > arithmeticMean) {
                        array.set(i, array.get(i) - 1);
                    }
                    count++;
                }
            }

        System.out.println(count);

        } catch (ArrayIndexOutOfBoundsException e ){
            System.out.println("Array is empty " + e);
        } catch (Exception e){
            System.out.println("Exception" + e);
        }
        
        
    }
}
