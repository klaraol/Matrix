/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author klol4
 */
public class Matrix {
    public static void main(String[] args){
        int[][] array1 = {{1, 2},{3, 4}, {5, 6}};
        int[][] array2 = {{7,8,9,10},{11,12,13,14}};
        MyMatrix x = new MyMatrix(array1);
        MyMatrix m = new MyMatrix(array2);
        //System.out.println("Num: " + m.get(1,0));
        MyMatrix sumOfMatrices = MyMatrix.multiplication(x, m);
        sumOfMatrices.set(0, 1, 222);
        //m.get(1500);
        for(int i = 0; i < sumOfMatrices.m * sumOfMatrices.n; i++){
            if(i % sumOfMatrices.m == 0)
                System.out.println();
            System.out.print(sumOfMatrices.data[i] + " ");
            
        }
        //System.out.print("123");
    }
    
}
