package uk.co.telegraph.heapsort;

import org.junit.Test;
import uc.co.telegraph.heapsort.Heap;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class HeapTest {

    private static final int NUMBER_RANDOM_TESTS = 1000;
    private static final int DATA_SIZE = 1000;

    private Integer[] randomArray(int size) {

        Random r = new Random();
        Integer[] res = new Integer[size];
        for (int i = 0; i < size; i++){
            res[i] = r.nextInt();
        }
        return res;

    }

    private static void assertOrdered(Integer[] values) {
        for (int i = 0; i < values.length - 2; i++){
            assertTrue(values[i] <= values[i + 1]);
        }
    }

    @Test
    public void emptyDataTest(){
        List<Integer> sorted = Heap.heapSort(new Integer[]{});
        assertEquals(0, sorted.size());
    }

    @Test
    public void singletonDataTest(){
        List<Integer> sorted = Heap.heapSort(new Integer[]{new Random().nextInt()});
        assertEquals(1, sorted.size());
    }

    @Test
    public void coupleDataTest(){
        List<Integer> sorted = Heap.heapSort(new Integer[]{new Random().nextInt(), new Random().nextInt()});
        assertOrdered(sorted.toArray(new Integer[sorted.size()]));
    }

    @Test
    public void heapSortTest(){
        for (int i = 0; i < NUMBER_RANDOM_TESTS; i++){
            System.out.println("test > " + i);
            Integer[] values = randomArray(DATA_SIZE);
            System.out.println(Arrays.toString(values));
            List<Integer> sorted = Heap.heapSort(values);
            values = sorted.toArray(new Integer[sorted.size()]);
            System.out.println(Arrays.toString(values));
            assertOrdered(values);
            System.out.println("test > " + i + " ok");
        }

    }

}
