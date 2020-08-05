package sparse_array;

public class SparseArray {
    public SparseArray() {
    }

    public static void main(String[] args) {
        // 原始的二维数组
        int chessArr1[][] = new int[5][5]; // 初始化，默认值是0
        chessArr1[1][1] = 1;
        chessArr1[2][2] = 2;
        chessArr1[4][2] = 3;
        // 输出
        for (int[] row:chessArr1){// 循环增强
            for (int data:row)
                System.out.printf("%d\t",data);
            System.out.println();
        }

        // 转化为稀疏数组
        //1、遍历原数组，得到差异数据的个数
        int row = chessArr1.length;
        int columns = chessArr1[0].length;
        int sum = 0;
        for (int i=0;i<row;i++) {
            for (int j = 0; j < columns; j++)
                if (chessArr1[i][j] != 0)
                    sum++;
        }
        //2、创建稀疏数组
        // 第一行，保存原始数组信息
        int sparseArr[][] = new int[sum+1][3];
        sparseArr[0][0] = row;
        sparseArr[0][1] = columns;
        sparseArr[0][2] = sum;
        //3、具体差异点信息
        int count = 0;
        for (int i=0;i<row;i++) {
            for (int j = 0; j < columns; j++)
                if (chessArr1[i][j] != 0) {
                    count++;
                    sparseArr[count][0] =i;
                    sparseArr[count][1] =j;
                    sparseArr[count][2] =chessArr1[i][j];
                }
        }
        //输出
        System.out.println();
        System.out.println("稀疏数组为：");
        for (int[] row1:sparseArr) {
            for (int data1 : row1)
                System.out.printf("%d\t", data1);
            System.out.println();
        }


        // 稀疏数组 恢复到 二维数组
        int row2 = sparseArr[0][0];
        int columns2 = sparseArr[0][1];
        int sum2 = sparseArr[0][2];
        int chessArr2[][] = new int[row2][columns2];
        for (int i =1;i<sparseArr.length;i++){
            int row_tep = sparseArr[i][0];
            int col_tep = sparseArr[i][1];
            int val = sparseArr[i][2];
            chessArr2[row_tep][col_tep]=val;
        }
        System.out.println("恢复到二维数组：");
        for (int[] row1:chessArr2) {
            for (int data1 : row1)
                System.out.printf("%d\t", data1);
            System.out.println();
        }


    }
}
