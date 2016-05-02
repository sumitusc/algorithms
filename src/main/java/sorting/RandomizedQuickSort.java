package sorting;

import java.util.Arrays;
import java.util.Random;

public class RandomizedQuickSort {

    private static Random rand = new Random();

    /**
     * QuickSort method
     *
     * @param arr input array
     * @param l   left index
     * @param r   right index
     */
    public static void quicksort(int[] arr, int l, int r) {
        if (l < r) {
            int q = partition(arr, l, r);
            quicksort(arr, l, q - 1);
            quicksort(arr, q + 1, r);
        }
    }

    /**
     * Partition the array such that first half < pivot < right half
     *
     * @param arr input array
     * @param l   left index
     * @param r   right index
     * @return pivot point index
     */
    private static int partition(int[] arr, int l, int r) {
        int p = random(l, r);
        int x = arr[p];
        swap(arr, p, r);
        int i = l - 1;
        for (int j = l; j < r; j++) {
            if (arr[j] <= x) {
                i++;
                swap(arr, i, j);
            }
        }
        swap(arr, ++i, r);
        return i;
    }

    private static int random(int l, int r) {
        return (rand.nextInt((r - l) + 1) + l);
    }

    /**
     * Swap elements in array
     *
     * @param arr input array
     * @param x   left index
     * @param y   right index
     */
    private static void swap(int[] arr, int x, int y) {
        int t = arr[y];
        arr[y] = arr[x];
        arr[x] = t;
    }

    /**
     * Prints the array
     *
     * @param arr
     */
    private static void print(int[] arr) {
        System.out.println(Arrays.toString(arr));
    }

    public static void main(String[] args) {
        int[] arr = {5, 10, 2, 1, 11, 3, 9, 4, 7, 6, 13, 12, 8};
        print(arr);
        quicksort(arr, 0, arr.length - 1);
        print(arr);
    }
}
