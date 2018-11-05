package task1;

import org.junit.Assert;
import org.junit.Test;

public class ArrayIntNegativeTest {


    @Test
    public void checkSizeArray() {
        int arraySize = 10;
        int[] arrayActual = new ArrayInt(arraySize).getArray();
        Assert.assertEquals("Размер массива не верен", arrayActual.length, arraySize);
    }

    @Test
    public void checkFirstElement(){
        int[] arrayActual = new ArrayInt(4).getArray();
        Assert.assertEquals("Первый элемент не верный", arrayActual[0], 0);
    }

}
