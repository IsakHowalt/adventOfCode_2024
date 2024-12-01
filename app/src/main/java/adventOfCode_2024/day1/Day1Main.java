package adventOfCode_2024.day1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.ArrayList;

public class Day1Main {
    private static ArrayList<Integer> leftArray;
    private static ArrayList<Integer> rightArray;
    private static ArrayList<Integer> distanceArray;
    private static ArrayList<Integer> similarityArray;
    public static void main(String[] args) throws FileNotFoundException {    
        Scanner scn = new Scanner(new File("app/src/main/java/adventOfCode_2024/day1/input/input.txt"));
            
        leftArray = new ArrayList<Integer>();
        rightArray = new ArrayList<Integer>();
        distanceArray = new ArrayList<Integer>();
        similarityArray = new ArrayList<Integer>();

        while(scn.hasNext()){
            String[] temp = scn.nextLine().split("   ");
            leftArray.add(Integer.parseInt(temp[0]));
            rightArray.add(Integer.parseInt(temp[1]));    

        }  

        leftArray.sort(null);
        rightArray.sort(null);

        for (int i = 0; i < leftArray.size(); i++) {
            int left = leftArray.get(i);
            int right = rightArray.get(i);
 
            if(left <= right){
                distanceArray.add(right-left);
            }else{
                distanceArray.add(left-right);
            }
      
        }
        int result = 0;
        for (int i = 0; i < distanceArray.size(); i++) {
            result += distanceArray.get(i);

        }
        System.out.println("Distance between lists: " + result);

        for (int i = 0; i < leftArray.size(); i++) {
            int left = leftArray.get(i);
            int counter = 0;
            for (int j = 0; j < rightArray.size(); j++) {
                int right = rightArray.get(j);
                if(left == right){
                    counter++;

                }

            }
            similarityArray.add(left*counter);
        }

        result = 0;
        for (int i = 0; i < distanceArray.size(); i++) {
            result += similarityArray.get(i);

        }
        System.out.println("Similarity Score: " + result);
        
    }

}
