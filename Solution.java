import java.util.Arrays;
import java.util.Scanner;

public class Solution {

    public int countSwap = 0;

    public int recursiveTernarySearch(int start, int end, int key, int[] array) {
        if (end == 0) {
            start = 0;
            end = array.length - 1;
        }

        if (end >= start) {
            int firstMid = start + (end - start) / 3;
            int secondMid = end - (end - start) / 3;
            if (array[secondMid] == key) {
                return secondMid;
            }
            if (array[firstMid] == key) {
                return firstMid;
            }
            if (key < array[firstMid]) {
                return recursiveTernarySearch(start, firstMid - 1, key, array);
            } else if (key > array[secondMid]) {
                return recursiveTernarySearch(secondMid + 1, end, key, array);
            } else {
                return recursiveTernarySearch(firstMid + 1, secondMid - 1, key, array);
            }
        }

        return -1;
    }

    public int iterativeTernarySearch(int start, int end, int[] array, int key) {
        // TODO: Implement this function
        if (end == 0) {
            start = 0;
            end = array.length - 1;
        }

        while (end >= start) {
            int firstMid = start + (end - start) / 3;
            int secondMid = end - (end - start) / 3;

            if (array[secondMid] == key) {
                return secondMid;
            }
            if (array[firstMid] == key) {
                return firstMid;
            }
            if (key < array[firstMid]) {
                end = firstMid - 1;
            } else if (key > array[secondMid])
                start = secondMid + 1;
            else {
                start = firstMid + 1;
                end = secondMid - 1;
            }
        }
        return -1;

    }

    public boolean anagramCheck(String str1, String str2) {
        // TODO: Implement this function

        char[] charStr1 = (str1).toCharArray();
        char[] charStr2 = (str2).toCharArray();

        Arrays.sort(charStr1);
        Arrays.sort(charStr2);

        if (charStr1.length != charStr2.length) {
            return false;
        }


        for (int i = 0; i < charStr1.length; i++) {
            if (charStr1[i] != charStr1[i]) {
                return false;
            }
        }

        return true;
    }


    public int[] countSwapsInInsertionSort(int[] array, int start, int end) {
        if (start < end) {
            int mid = (start + end) / 2;
            int[] secondMerge = countSwapsInInsertionSort(array, mid + 1, end);
            int[] firstMerge = countSwapsInInsertionSort(array, start, mid);

            return merge(firstMerge, secondMerge);
        }

        return new int[]{array[start]};
    }

    private int[] merge(int[] firstArr, int[] secondArr) {

        int firstIndex = 0;
        int secondIndex = 0;
        int firstEndIndex = firstArr.length - 1;
        int secondEndIndex = secondArr.length - 1;
        int[] result = new int[firstArr.length + secondArr.length];
        int i = 0;

        while (secondIndex <= secondEndIndex && firstIndex <= firstEndIndex) {
            int element = firstArr[firstIndex];
            while (secondIndex <= secondEndIndex && element > secondArr[secondIndex]) {
                result[i++] = secondArr[secondIndex++];
                countSwap += ((firstEndIndex - firstIndex) + 1);
            }
            result[i++] = element;
            firstIndex++;
        }

        while (firstIndex <= firstEndIndex && secondIndex > secondEndIndex) {
            result[i++] = firstArr[firstIndex++];
        }
        while (secondIndex <= secondEndIndex && firstIndex > firstEndIndex) {
            result[i++] = secondArr[secondIndex++];
        }

        return result;
    }

}
