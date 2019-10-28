package sort;

/**
 * @Author: yongye(xiang.yongye @ hand - china.com)
 * @Date:2019/10/25 14:33
 * @Version:1.0
 * @deseription: 希尔排序【本质都是插入排序】
 **/
public class ShellSort {

    public static void shellSort(Integer[] sortList) {
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
                        int k = j - step; //i
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


    public static void shellSort2(Integer[] arrays) {


        //增量每次都/2
        for (int step = arrays.length / 2; step > 0; step /= 2) {

            //从增量那组开始进行插入排序，直至完毕
            for (int i = step; i < arrays.length; i++) {

                int j = i;
                Integer temp = arrays[j];

                // j - step 就是代表与它同组隔壁的元素
                while (j - step >= 0 && arrays[j - step] > temp) {
                    arrays[j] = arrays[j - step];
                    j = j - step;
                }
                arrays[j] = temp;
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(5 / 2);

        Integer[] testArray2 = {67, 34, 54, 12};
        ShellSort.shellSort2(testArray2);

        Integer[] testArray = {67, 34, 54, 12, 87, 43, 76, 98, 21, 60};
        ShellSort.shellSort(testArray);
        System.out.println("The result is:");
        for (Integer item : testArray) {
            System.out.print(item);
            System.out.print(' ');
        }
    }
}
