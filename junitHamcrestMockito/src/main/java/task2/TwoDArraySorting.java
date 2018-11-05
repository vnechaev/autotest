package task2;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class TwoDArraySorting {
    private int[][] arrayBeforeSorting;

    public TwoDArraySorting(int[][] array) {
        arrayBeforeSorting = array;
    }

    public int[][] getSortedArray() {
        Map<Integer, Integer> numRowSumRowMap = new HashMap<>();
        for (int i =0; i < arrayBeforeSorting.length; i++){
            int sumRow = 0;
            for (int j =0; j<arrayBeforeSorting.length; j++){
                sumRow = sumRow + arrayBeforeSorting[i][j];
            }
            numRowSumRowMap.put(i, sumRow);
        }
        List<Integer> rowOrder = numRowSumRowMap.entrySet().stream()
                .sorted(Map.Entry.comparingByValue())
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());

        Collections.reverse(rowOrder);
        int[][]sortedArray = new int[arrayBeforeSorting.length][arrayBeforeSorting.length];
        for (int i =0; i< arrayBeforeSorting.length; i++){
            sortedArray[i] = arrayBeforeSorting[rowOrder.get(i)];
        }
        return sortedArray;
    }





    public static void main(String[] args) {
        int[][] arrayBefore = {{1,1,1},{3,3,3}, {2,2,2}};
        System.out.println(Arrays.deepToString(arrayBefore));
        System.out.println(Arrays.deepToString(new TwoDArraySorting(arrayBefore).getSortedArray()));
    }
}
