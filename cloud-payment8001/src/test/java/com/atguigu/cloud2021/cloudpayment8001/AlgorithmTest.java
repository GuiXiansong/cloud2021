package com.atguigu.cloud2021.cloudpayment8001;

import org.junit.Test;

import java.util.Arrays;

/**
 * @author 桂贤松
 * @project_name：cloud2021
 * @product_name：IntelliJ IDEA
 * @date：2021/1/14 10:02 周四
 */
public class AlgorithmTest {

    @Test
    public void SelectionSort() {
        int[] arr = new int[]{343, 22, 545, 1, 5363, 656, 34, 163, 456, 987, 67, 542, 7675, 3635};
        System.out.println(arr.length);
        int min = 0;
        int temp = 0;
        for (int i = 0; i < arr.length - 1; i++) {
            min = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[min] > arr[j]) {
                    min = j;
                }
            }
            if (min != i) {
                temp = arr[i];
                arr[i] = arr[min];
                arr[min] = temp;
            }
        }

        for (int a : arr) {
            System.out.println(a);
        }
    }

    @Test
    public void InsertionSort() {
        int[] arr = new int[]{343, 22, 545, 1, 5363, 656, 34, 163, 456, 987, 67, 542, 7675, 3635};
        int cur = 0;
        int temp = 0;
        for (int i = 1; i < arr.length; i++) {
            cur = i;
            while (cur > 0 && arr[cur] < arr[cur - 1]) {
                temp = arr[cur];
                arr[cur] = arr[cur - 1];
                arr[cur - 1] = temp;
                cur--;
            }
        }

        for (int a : arr) {
            System.out.println(a);
        }
    }

    @Test
    public void mergeSort() {
        int[] arr = new int[]{33, 1, 634, 74312, 753, 4, 636, 786, 13, 7456, 23, 783, 5543, 743};
        sort(arr, 0, arr.length - 1);
    }

    public void sort(int[] arr, int L, int R) {
        if (L == R) {
            return;
        }
        int mid = L + ((R - L) >> 1);
        sort(arr, L, mid);
        sort(arr, mid + 1, R);
        merge(arr, L, mid, R);
    }

    public void merge(int[] arr, int L, int mid, int R) {
        int[] temp = new int[R - L + 1];
        int i = 0;
        int p1 = L;
        int p2 = mid + 1;
        // 比较左右两部分的元素，哪个小，把那个元素填入temp中
        while (p1 <= mid && p2 <= R) {
            temp[i++] = arr[p1] < arr[p2] ? arr[p1++] : arr[p2++];
        }
        // 上面的循环退出后，把剩余的元素依次填入到temp中
        // 以下两个while只有一个会执行
        while (p1 <= mid) {
            temp[i++] = arr[p1++];
        }
        while (p2 <= R) {
            temp[i++] = arr[p2++];
        }
        // 把最终的排序的结果复制给原数组
        for (i = 0; i < temp.length; i++) {
            arr[L + i] = temp[i];
        }
    }

    @Test
    public void mergeSort2() throws Exception {
        int[] arr = new int[]{33, 1, 634, 74312, 753, 4, 636, 786, 13, 7456, 23, 783, 5543, 743};
        int[] sort = sort(arr);
        for (int a:sort) {
            System.out.println(a);
        }
    }

    public int[] sort(int[] sourceArray) throws Exception {
        // 对 arr 进行拷贝，不改变参数内容
        int[] arr = Arrays.copyOf(sourceArray, sourceArray.length);

        if (arr.length < 2) {
            return arr;
        }
        int middle = (int) Math.floor(arr.length / 2);

        int[] left = Arrays.copyOfRange(arr, 0, middle);
        int[] right = Arrays.copyOfRange(arr, middle, arr.length);

        return merge(sort(left), sort(right));
    }

    protected int[] merge(int[] left, int[] right) {
        int[] result = new int[left.length + right.length];
        int i = 0;
        while (left.length > 0 && right.length > 0) {
            if (left[0] <= right[0]) {
                result[i++] = left[0];
                left = Arrays.copyOfRange(left, 1, left.length);
            } else {
                result[i++] = right[0];
                right = Arrays.copyOfRange(right, 1, right.length);
            }
        }

        while (left.length > 0) {
            result[i++] = left[0];
            left = Arrays.copyOfRange(left, 1, left.length);
        }

        while (right.length > 0) {
            result[i++] = right[0];
            right = Arrays.copyOfRange(right, 1, right.length);
        }

        return result;
    }

}
