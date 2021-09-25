package Sort;

/**
 * 八大排序
 */
public class LeetCode_Sort{
    /**
     * 冒泡排序
     * 时间复杂度O（n*n）
     * 空间复杂度O（1）
     * @param array
     */
    public static void bubbleSort(int[] array){
        int length = array.length;
        for (int i = 0; i < length; i++){
            for (int j = 0; j < length - 1 - i; j++){
                if (array[j] > array[j+1]){
                    int temp = array[j];
                    array[j] = array[j+1];
                    array[j+1] = temp;
                }
            }
        }
    }

    /**
     * 冒泡排序--优化版
     * 时间复杂度O（n*n）
     * 空间复杂度O（1）
     * @param array
     */
    public static void bubbleSort1(int[] array){
        int length = array.length;
        for (int i = 0; i < length; i++){
            boolean isOk = true;
            for (int j = 0; j < length - 1 - i; j++){
                if (array[j] > array[j+1]){
                    int temp = array[j];
                    array[j] = array[j+1];
                    array[j+1] = temp;
                    isOk = false;
                }
            }
            if (isOk){
                break;
            }
        }
    }

    /**
     * 快速排序
     *
     * @param array
     * @return
     */
    public static void quickSort(int[] array){
        quickSort(array,0,array.length-1);
    }

    private static void quickSort(int[] array, int left, int right){
        if (left < right){
            int mid = partition(array, left, right);
            quickSort(array, left, mid - 1);
            quickSort(array, mid + 1, right);
        }
    }

    /**
     *
     * @param array
     * @param left
     * @param right
     * @return
     */
    private static int partition(int[] array, int left, int right){
        int pivot = left;
        int index = pivot + 1;
        for (int i = index; i <= right; i++){
            if (array[i] < array[pivot]){
                swap(array, i, index);
                index++;
            }
        }
        swap(array, pivot,index-1);
        return index - 1;
    }

    /**
     * 交换数组的i和j位置的元素
     * @param array
     * @param i
     * @param j
     */
    private static void swap(int[] array, int i, int j){
        if (array == null){
            return;
        }
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }


    /**
     * 插入排序
     * @param array
     */
    public static void insertSort(int[] array){
        if (array == null){
            return;
        }
        for (int i = 1; i < array.length; i++){
            int temp = array[i];
            int j = i;
            while (j > 0 && temp < array[j-1]){
                array[j] = array[j-1];
                j--;
            }
            if (j != i){
                array[j] = temp;
            }
        }
    }



    public static void main(String[] args) {
        int[] S = {2,1};
//        insertSort(S);
//        for (int i : S){
//            System.out.println(i);
//        }
        int i = 10;
        System.out.println(((i>>2)&1) == 1);
    }
}
