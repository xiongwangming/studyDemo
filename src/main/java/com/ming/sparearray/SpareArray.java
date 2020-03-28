package com.ming.sparearray;

/**
 * @ClassName com.ming.sparearray
 * @Author 24206
 * @Date 2020/3/21 15:51
 **/
public class SpareArray {
    public static void main(String[] args) {
        //创建原始二维数组11*11并赋值
        int chessArr1[][] = new int[11][11];
        chessArr1[1][2] = 1;
        chessArr1[2][3] = 2;
        chessArr1[4][6] = 3;
        chessArr1[2][8] = 4;
        chessArr1[5][7] = 5;
        for (int[] ints : chessArr1) {
            for (int anInt : ints) {
                System.out.printf("%d\t",anInt);
            }
            System.out.println();
        }

        //将二维数组转换为稀疏数组
        int sum = 0;
        for (int[] ints : chessArr1) {
            for (int anInt : ints) {
                if (anInt != 0){
                    sum++;
                }
            }
        }
        System.out.println("有效数据："+sum);

        int spareArr[][] = new int[sum+1][3];
        spareArr[0][0] = 11;
        spareArr[0][1] = 11;
        spareArr[0][2] = sum;
        int count = 0;
        for (int i = 0; i <chessArr1.length ; i++) {
            for (int j = 0; j < chessArr1[i].length; j++) {
                if (chessArr1[i][j] != 0){
                    count++;
                    spareArr[count][0] = i;
                    spareArr[count][1] = j;
                    spareArr[count][2] = chessArr1[i][j];
                }
            }
        }
        System.out.println("稀疏数组：");
        for (int[] ints : spareArr) {
            for (int anInt : ints) {
                System.out.printf("%d\t",anInt);
            }
            System.out.println();
        }

        //还原二维数组
        int chessArr2[][] = new int[spareArr[0][0]][spareArr[0][1]];
        for (int i = 1; i < spareArr.length; i++) {
            chessArr2[spareArr[i][0]][spareArr[i][1]] = spareArr[i][2];
        }

        System.out.println("还原后的二维数组：");
        for (int[] ints : chessArr2) {
            for (int anInt : ints) {
                System.out.printf("%d\t",anInt);
            }
            System.out.println();
        }


    }
}
