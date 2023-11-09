//Name: Manoj Budathoki
//Assignment: Program6
import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class Program6 {
    public static void main(String[] args) {

        int arraySize = 20000;
        int[] bubbleSortArray = new int[arraySize];
        int[] selectionSortArray = new int[arraySize];
        ArrayList<Integer> arrayList = new ArrayList<>();

        readIntegersFromFile("NumbersInFile.txt", bubbleSortArray, selectionSortArray, arrayList);

        long startTimeBubbleSortInt = System.nanoTime();
        bubbleSort(bubbleSortArray);
        long endTimeBubbleSortInt = System.nanoTime();
        long bubbleSortTimeInt = endTimeBubbleSortInt - startTimeBubbleSortInt;

        long startTimeSelectionSortInt = System.nanoTime();
        selectionSort(selectionSortArray);
        long endTimeSelectionSortInt = System.nanoTime();
        long selectionSortTimeInt = endTimeSelectionSortInt - startTimeSelectionSortInt;

        //Strings
        int arraySizeString = 10000;


        String[] bubbleSortArrayString = new String[arraySizeString]; //change the arraysize to arraySizeString
        String[] selectionSortArrayString = new String[arraySizeString]; //change the arraysize to arraySizeString
        ArrayList<String> arrayListString = new ArrayList<>();

        readStringsFromFile("StringsInFile.txt", bubbleSortArrayString, selectionSortArrayString, arrayListString);

        long startTimeBubbleSortStr = System.nanoTime();
        bubbleSort(bubbleSortArrayString);
        long endTimeBubbleSortStr = System.nanoTime();
        long bubbleSortTimeStr = endTimeBubbleSortStr - startTimeBubbleSortStr;

        long startTimeArraysSortStr = System.nanoTime();
        Arrays.sort(selectionSortArrayString, new StringComparator());
        long endTimeArraysSortStr = System.nanoTime();
        long arraysSortTimeStr = endTimeArraysSortStr - startTimeArraysSortStr;

        try (PrintWriter writer = new PrintWriter(new FileWriter("results.txt"))) {
            writer.println("Number of Integers: " + arraySize);
            writer.println("Bubble Sort Integers Time: " + bubbleSortTimeInt + " nanoseconds");
            writer.println("Selection Sort Integers Time: " + selectionSortTimeInt + " nanoseconds");
            writer.println();
            writer.println("Number of Strings: " + arraySizeString); //change the arraysize to arraySizeString
            writer.println("Bubble Sort Strings Time: " + bubbleSortTimeStr + " nanoseconds");
            writer.println("Arrays Sort Strings Time: " + arraysSortTimeStr + " nanoseconds");
        } catch (IOException e) {
            System.out.println("Error");
        }
    }

    public static void readIntegersFromFile(String filename, int[] bubbleSortArray, int[] selectionSortArray, ArrayList<Integer> arrayList) {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(filename));
            String line;
            int index = 0;
            while ((line = reader.readLine()) != null && index < bubbleSortArray.length) {
                int number = Integer.parseInt(line);
                bubbleSortArray[index] = number;
                selectionSortArray[index] = number;
                arrayList.add(number);
                index++;
            }
            reader.close();
        } catch (IOException e) {
            System.out.println(e);
           // throw new IOException ("Error");
        }
    }

    public static void readStringsFromFile(String filename, String[] bubbleSortArray, String[] selectionSortArray, ArrayList<String> arrayList) {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(filename));
            String line;
            int index = 0;
            while ((line = reader.readLine()) != null && index < bubbleSortArray.length) {
                bubbleSortArray[index] = line;
                selectionSortArray[index] = line;
                arrayList.add(line);
                index++;
            }
            reader.close();
        } catch (IOException e) {
            System.out.println("Error");
        }
    }

    public static void bubbleSort(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }

    public static void selectionSort(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < n; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }
            int temp = arr[minIndex];
            arr[minIndex] = arr[i];
            arr[i] = temp;
        }
    }

    public static void bubbleSort(String[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] != null && (arr[j + 1] == null || arr[j].compareTo(arr[j + 1]) > 0)) {
                    String temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }
}

class StringComparator implements Comparator<String> {

    public int compare(String str1, String str2) {
        if (str1 == null && str2 == null) {
            return 0;
        }
        if (str1 == null) {
            return -1;
        }
        if (str2 == null) {
            return 1;
        }
        return str1.compareTo(str2);
    }
}
