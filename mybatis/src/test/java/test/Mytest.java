package test;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @Author: yongye(xiang.yongye @ hand - china.com)
 * @Date:2019/11/9 11:08
 * @Version:1.0
 * @deseription:
 **/
public class Mytest {

    public static void main(String[] args) {
        String[] players = {"zhansgan", "lisi", "wangwu", "zhaoliu",  "wangmazi"};

        System.out.println("排序前：");
        for (String item:players){
            System.out.println(item);
        }


        // 1.1 使用匿名内部类根据 surname 排序 players
//        Arrays.sort(players, new Comparator<String>() {
//            @Override
//            public int compare(String s1, String s2) {
//                return (s1.compareTo(s2));
//            }
//        });

        // 1.2 使用 lambda 排序,根据 surname
        Arrays.sort(players, (String s1, String s2) ->  s1.compareTo(s2));
        System.out.println("使用 lambda 排序,根据 surname：");
        for (String item:players){
            System.out.println(item);
        }
//================================================================================================

        // 2.1 使用匿名内部类根据 name lenght 排序 players
        Arrays.sort(players, new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                return (s1.length() - s2.length());
            }
        });

        // 2.2使用Lambda,根据name length
        Arrays.sort(players, (String s1, String s2) -> (s1.length() - s2.length()));

//==================================================================================================

        // 3.1 使用匿名内部类排序 players, 根据最后一个字母
        Arrays.sort(players, new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                return (s1.charAt(s1.length() - 1) - s2.charAt(s2.length() - 1));
            }
        });

        // 3.2 使用Lambda,根据最后一个字母
        Arrays.sort(players, (String s1, String s2) -> (s1.charAt(s1.length() - 1) - s2.charAt(s2.length() - 1)));
    }
}
