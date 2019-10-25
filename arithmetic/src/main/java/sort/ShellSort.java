package sort;

/**
 * @Author: yongye(xiang.yongye @ hand - china.com)
 * @Date:2019/10/25 14:33
 * @Version:1.0
 * @deseription: 希尔排序
 **/
public class ShellSort {

    static void shellSort(Integer[] sortList) {
        int i, j, step;
        int len = sortList.length;
        // 设置增量step
        for (step = len / 2; step > 0; step /= 2) {
            /**
             *  分别对每个分组进行直接插入排序
             *  分step个组
             */
            for (i = 0; i < step; i++) {
                /*
                * 每个组进行分别进行排序
                 */
                for (j = i + step; j < len; j += step) {

                    /*
                    * 间隔为增量step 的两个元素比较
                     */
                    if (sortList[j] < sortList[j - step]) {
                        int temp = sortList[j];
                        int k = j - step;
                        while (k >= 0 && sortList[k] > temp) {
                            sortList[k + step] = sortList[k];
                            k -= step;
                        }
                        sortList[k + step] = temp;
                    }
                }

            }
        }


    }

    public static void main(String[] args) {
        Integer[] testArray = {67, 34, 54, 12, 87, 43, 76, 98, 21, 60};
        ShellSort.shellSort(testArray);
        System.out.println("The result is:");
        for (Integer item : testArray) {
            System.out.print(item);
            System.out.print(' ');
        }
    }

}
