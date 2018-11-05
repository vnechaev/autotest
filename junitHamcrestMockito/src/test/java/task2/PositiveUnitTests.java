package task2;

import org.junit.Test;

import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.Matchers.hasItemInArray;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

public class PositiveUnitTests {

    @Test
    public void lengthArraysTest() {
        int[][] arrayBefore = {{1, 1, 1}, {3, 3, 3}, {2, 2, 2}};
        int[][] actual = new TwoDArraySorting(arrayBefore).getSortedArray();

        assertEquals("Размеры массивов разные", arrayBefore.length, actual.length
        );
    }

    @Test
    public void allOldElementsPresentTest() {
        int[][] arrayBefore = {{1, 1, 1}, {3, 3, 3}, {2, 2, 2}};
        int[][] actual = new TwoDArraySorting(arrayBefore).getSortedArray();

        assertThat(actual, allOf(
                hasItemInArray(arrayBefore[0]),
                hasItemInArray(arrayBefore[1]),
                hasItemInArray(arrayBefore[2])
        ));
    }
}