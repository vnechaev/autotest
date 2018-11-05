package task2;

import org.junit.Test;

import java.util.Arrays;

import static org.hamcrest.Matchers.not;
import static org.hamcrest.Matchers.sameInstance;
import static org.junit.Assert.assertThat;

public class NegativeUnitTests {

    @Test
    public void firstElementTest() {
        int[][] arrayBefore = {{1, 1, 1}, {3, 3, 3}, {2, 2, 2}};
        int[][] actual = new TwoDArraySorting(arrayBefore).getSortedArray();

        assertThat("Первая строка не равна исходной первой строке", actual, not(Arrays.equals(actual[0], arrayBefore[0])));
    }

    @Test
    public void notTheSameObjectTest() {
        int[][] arrayBefore = {{1, 1, 1}, {3, 3, 3}, {2, 2, 2}};
        int[][] actual = new TwoDArraySorting(arrayBefore).getSortedArray();

        assertThat("Результат ссылается на другую ячейку памяти", actual, not(sameInstance(arrayBefore)));
    }
}
