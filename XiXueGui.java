package xiaoban;

import java.util.Arrays;
//吸血鬼数字是指位数为偶数的数字，可以由一对数字相乘而得到，而这对数字各包含乘积的一半位数的数字，其中从最初的数字中选取的数字可以任意排序。
public class XiXueGui {
    public static void main(String[] args) {
        for (int i = 10; i < 99; i++) {
            for (int j = 10; j < 99; j++) {
                if (i <= j) {
                    int ij = i * j;
                    //拼接后，转成字符串数组并排序
                    String[] plusSplit = (i + String.valueOf(j)).split("");
                    Arrays.sort(plusSplit);

                    //对乘积转成字符串数组后排序
                    String[] rideSplit = String.valueOf(ij).split("");
                    Arrays.sort(rideSplit);

                    //比较两个排序后的数组是否一样,如果数字一样则为吸血鬼数
                    if (Arrays.equals(plusSplit, rideSplit)) {
                        System.out.println(ij);
                    }
                }
            }
        }
    }
}
