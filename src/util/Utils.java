package util;

import java.util.Random;
/**
 * 
 * 得到随机生成的验证码 
 *
 */

public abstract class Utils {
	 /**
     * 获取指定随机数字符串
     * 
     * @return
     */
    public static String getRandomString(int size) {
        int[] randomArray = getRandomNumber(size);
        StringBuilder stringBuilder = new StringBuilder();
        for (int item : randomArray) {
            stringBuilder.append(item);
        }
        return stringBuilder.toString();
    }

    /**
     * 获得指定随机数
     *
     * @param size 需要获得随机数的个数
     * @return 随机数组
     */
    public static int[] getRandomNumber(int size) {
        if (size <= 0) {
            throw new IllegalArgumentException("Error Random Size");
        }
        Random random = new Random();
        int[] randomArray = new int[size];
        // 产生0~9的随机数
        for (int i = 0; i < size; i++) {
            randomArray[i] = random.nextInt(9);
        }
        return randomArray;
    }
}