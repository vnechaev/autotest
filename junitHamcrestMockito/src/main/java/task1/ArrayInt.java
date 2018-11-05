package task1;

public class ArrayInt {

    private int[] array;

    public ArrayInt(int arraySize) {
        array = new int[arraySize];
    }

    public int[] getArray(){
        for (int i =0; i<array.length; i++){
            array[i] = i;
        }
        System.out.printf(String.valueOf(array));
        return array;
    }
}
