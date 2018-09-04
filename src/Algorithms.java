import com.sun.jmx.remote.internal.ArrayQueue;
import data_structures.AVLTree;
import data_structures.Queue;

import java.io.*;
import java.util.*;


public class Algorithms {

    //Helpers
    public static String[] expandCapacity(String[] arr){
        String[] arr2 = new String[arr.length*2];
        for (int i = 0; i < arr.length; i++){
            arr2[i] = arr[i];
        }
        return arr2;
    }

    public static int[] expandCapacity(int[] arr){
        int[] arr2 = new int[arr.length*2];
        for (int i = 0; i < arr.length; i++){
            arr2[i] = arr[i];
        }
        return arr2;
    }

    public static String[] shiftArray(String[] arr, int bottom) {
        String[] arr2 = new String[arr.length];
        int j = 0;
        for (int i = bottom; i < arr.length; i++){
            arr2[j] = arr[i];
            j++;
        }
        return arr2;
    }

    public static int[] shiftArray(int[] arr, int bottom) {
        int[] arr2 = new int[arr.length];
        int j = 0;
        for (int i = bottom; i < arr.length; i++){
            arr2[j] = arr[i];
            j++;
        }
        return arr2;
    }

    public static int[] heapify(int[] array, int i) {
        int len = array.length;
        int li = 2 * i + 1;
        int ri = 2 * i + 2;

        if (li < len && array[li] > array[i]) {
            swap(array, i, li);
        }
        if (ri < len && array[ri] > array[i]) {
            swap(array, i, ri);
        }

        return array;
    }

    public static void swap(int arr[], int i, int j) {
        int t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }

    public static int partition(int array[], int l, int h) {
        int pivot = array[l];
        int currIndex = l;

        for (int j = l + 1; j < h; j++) {
            if (array[j] <= pivot) {
                swap(array, currIndex, j);
                currIndex++;
            }
        }
        return currIndex;
    }

    static int partition2(int arr[], int low, int high) {
        int pivot = arr[low];

        // index of smaller element
        int i = (low - 1);
        for (int j = low; j <= high - 1; j++) {
            // If current element is smaller than or
            // equal to pivot
            if (arr[j] <= pivot) {
                i++;

                // swap arr[i] and arr[j]
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        // swap arr[i+1] and arr[high] (or pivot)
        int temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;

        return i;
    }

    public static int[] placeIn(int elem, int[] array, int lr, int hr) {
        return array;
    }

    public static int max(int... a) {
        int min = a[0];
        for (int value : a){
            if (value > min){
                min = value;
            }
        }
        return min;
    }

    public static int min(int... a) {
        int min = a[0];
        for (int value : a){
            if (value < min){
                min = value;
            }
        }
        return min;
    }

    public static String getLast(String str){
        return str.substring(str.length()-1,str.length());
    }

    public static String getFirst(String str){
        return str.substring(0,1);
    }

    //Mathematical Algorithms
    int gcd(int a, int b) {
        if (a == 0)
            return b;
        return gcd(b%a, a);
    }

    //Search Algorithms
    public static int binarySearch(int[] array, int value) {
        int length = array.length;
        int middle = (array.length - 1) / 2;
        int high = array.length;
        int low = 0;
        for (int i = 0; i <= length / 2; i++) {
            if (array[middle] == value) {
                return middle;
            } else if (array[middle] < value) {
                low = middle;
                middle = (high + low) / 2;
            } else {
                high = middle;
                middle = (high + low) / 2;
            }
        }
        return -1;
    }

    static int interpolationSearch(int[] array, int x) {
        int low = 0;
        int high = array.length - 1;

        while (low <= high && x >= array[low] && x <= array[high]) {
            int pos = low + ((high - low) / (array[high] - array[low])) * (x - array[low]);

            if (array[pos] == x) {
                return pos;
            } else if (array[pos] < x) {
                low = pos + 1;
            } else {
                high = pos - 1;
            }
        }

        return -1;
    }

    //Sorting Algorithms
    public static int[] quickSort(int array[], int low, int high) {
        int[] stack = new int[high - low + 1];
        int top = -1;
        stack[++top] = low;
        stack[++top] = high;

        while (top >= 0) {
            high = stack[top--];
            low = stack[top--];

            int p = partition(array, low, high);
            // If there are elements on left side of pivot,
            // then push left side to stack
            if (p - 1 > low) {
                stack[++top] = low;
                stack[++top] = p - 1;
            }
            // If there are elements on right side of pivot,
            // then push right side to stack
            if (p + 1 < high) {
                stack[++top] = p + 1;
                stack[++top] = high;
            }
        }
        return array;
    }

    public static int[] bubbleSort(int[] array) {
        for (int i = 0; i < array.length; i++) {
            for (int k = 0; k < array.length - 1; k++) {
                if (array[k] > array[k + 1]) {
                    swap(array, k, k + 1);
                }
            }
        }
        return array;
    }

    public static int[] insertionSort(int[] array) {
        int n = array.length;
        for (int i = 1; i < n; ++i) {
            int key = array[i];
            int j = i - 1;

            while (j >= 0 && array[j] > key) {
                array[j + 1] = array[j];
                j = j - 1;
            }
            array[j + 1] = key;
        }
        return array;
    }

    static void DFS(int[][] graph) {
        int numVertices = graph[0].length;
        boolean[] visited = new boolean[numVertices];
        int[] memory = new int[visited.length];
        int top = -1;
        int curVertex = 0;
        visited[curVertex] = true;
        memory[++top] = curVertex;
        System.out.println("Visited: " + (curVertex + 1));
        while (top >= 0) {
            for (int j = 0; j < numVertices; j++) {
                if (!visited[j] && graph[curVertex][j] == 1) {
                    visited[j] = true;
                    memory[++top] = j;
                    System.out.println("Discovered: " + (j + 1) + " through " + (curVertex + 1));
                }
            }
            curVertex = memory[top--];
        }
    }

    static void BFS(int[][] graph) {
        int numVertices = graph[0].length;
        boolean[] visited = new boolean[numVertices];
        int[] memory = new int[visited.length];
        int top = -1;
        int bottom = 0;
        int curVertex = 0;
        visited[curVertex] = true;
        memory[++top] = curVertex;
        while (top >= 0 && bottom <= top) {
            for (int j = 0; j < numVertices; j++) {
                if (!visited[j] && graph[curVertex][j] == 1) {
                    visited[j] = true;
                    memory[++top] = j;
                }
            }
            curVertex = memory[bottom++];
        }
    }

    //Dynammic Programming
    static int longestSubSeq(char[] a, char[] b) {
        int m = a.length;
        int n = b.length;
        int[][] array = new int[m + 1][n + 1];
        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                if (i == 0 || j == 0) {
                    array[i][j] = 0;
                } else if (a[i - 1] == b[j - 1]) {
                    array[i][j] = 1 + array[i - 1][j - 1];
                } else {
                    array[i][j] = max(array[i - 1][j], array[i][j - 1]);
                }
            }
        }
        return array[m][n];
    }

    static int longestIncreasingSubSeq(int[] array) {
        int n = array.length;
        int[] l = new int[n];

        for (int i = 0; i < n; i++) {
            l[i] = 1;
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (array[i] > array[j] && l[i] < l[j] + 1) {
                    l[i] = l[j] + 1;
                }
            }
        }

        return l[n];
    }

    static int minSubset(int[] a, int i, int sum, int totalSum) {
        if (i == 0) {
            return Math.abs(totalSum - sum - sum);
        }
        return Math.min(minSubset(a, i - 1, sum + a[i - 1], totalSum),
                minSubset(a, i - 1, sum, totalSum)
        );
    }

    static int knapsack(int i, int va, int wa, int[] v, int[] w, int W) {
        if (i == v.length) {
            return va;
        }
        if (wa + w[i] <= W) {
            return max(knapsack(i + 1, va + v[i], wa + w[i], v, w, W),
                    knapsack(i + 1, va, wa, v, w, W));
        } else {
            return knapsack(i + 1, va, wa, v, w, W);
        }
    }

    static int knapsack2(int n, int[] v, int[] w, int W) {
        int[][] K = new int[n + 1][W + 1];

        for (int j = 0; j <= n; j++) {
            for (int k = 0; k <= W; k++) {
                if (j == 0 || k == 0) {
                    K[j][k] = 0;
                } else if (w[j - 1] <= k) {
                    K[j][k] = max(K[j - 1][k - w[j - 1]] + v[j - 1], K[j - 1][k]);
                }
            }
        }
        System.out.println(Arrays.deepToString(K).replace("], ", "]\n").replace("[[", "[").replace("]]", "]"));
        return K[n][W];
    }

    static void doPostorder (int i, int[] rights, int[] lefts, int n, int[] order, int count) {
        if (count >= n)
            return;
        doPostorder(lefts[i], rights, lefts, n, order, count+1);
        doPostorder(rights[i], rights, lefts, n, order,count+1);
        order[i] = i;
    }

    static int minCost(int cost[][], int m, int n) {
        if (n < 0 || m < 0)
            return Integer.MAX_VALUE;
        else if (m == 0 && n == 0)
            return cost[m][n];
        else
            return cost[m][n] +
                    min( minCost(cost, m-1, n-1),
                            minCost(cost, m-1, n),
                            minCost(cost, m, n-1) );
    }

    static int[][] minCostMemo (int[][] cost, int m, int n){
        int[][] table = new int[m][n];
        for (int i = 0; i < m; i ++){
            for (int j = 0; j < n; j++){
                if (j == 0 && i == 0){
                    table[i][j] =  cost[i][j];
                } else if (j==0 && i != 0) {
                    table[i][j] =  cost[i][j] + table[i-1][j];
                } else if (i == 0 && j != 0){
                    table[i][j] =  cost[i][j] + table[i][j-1];
                }
                else {
                    table[i][j] =  cost[i][j] + min(table[i-1][j], table[i][j-1],
                            table[i-1][j-1]);
                }
            }
        }
        return table;
    }

    static int mazeShortestpath(int[][] arr, int m, int n, int x, int y){
        Queue.ArrayQueue<String> queue = new Queue.ArrayQueue();
        queue.toQueue().add(Integer.toString(m)+Integer.toString(n));
        boolean[][] visit = new boolean[arr.length][arr[0].length];
        while (!queue.toQueue().isEmpty()){
            String curr = queue.poll();
            if (curr.equals(Integer.toString(x)+Integer.toString(y))){
                System.out.println("Reached");
                return 1;
            }
            int a = Integer.parseInt(getFirst(curr));
            int b = Integer.parseInt(getLast(curr));
            if ((b+1) < arr[0].length && !visit[a][b+1] && arr[a][b+1] != 0) {
                queue.toQueue().add(Integer.toString(a) + Integer.toString(b+1));
                visit[a][b+1] = true;
            }
            if ((a+1) < arr.length && !visit[a+1][b] && arr[a+1][b] != 0 ){
                queue.toQueue().add(Integer.toString(a+1) + Integer.toString(b));
                visit[a+1][b] = true;
            }
            if ((a-1) > 0 && !visit[a-1][b] && arr[a-1][b] != 0){
                queue.toQueue().add(Integer.toString(a-1) + Integer.toString(b));
                visit[a-1][b] = true;
            }
            if ((b-1) > 0 && !visit[a][b-1] && arr[a][b-1] != 0) {
                queue.toQueue().add(Integer.toString(a) + Integer.toString(b-1));
                visit[a][b-1] = true;
            }
        }
        return 0;
    }

    public static void main(String args[]) {
      System.out.println(mazeShortestpath(new int[][] {
                {1,1,0,0},
                {1,0,0,1},
                {1,0,0,1},
                {1,1,1,1},
        },0,0,1,2));
    }

}









