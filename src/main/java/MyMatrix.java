/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author klol4
 */
public class MyMatrix {
    // column count
    public final int n;
    // row count
    public final int m;
    
    int[] data;
    
    public MyMatrix(int m, int n){
        this.m = m;
        this.n = n;
        this.data = new int[n*m];
    }
    
    public MyMatrix(int[][] values){
        for (int i = 0; i < values.length - 1; i++){
            if(values[i].length != values[i + 1].length){
                throw new UnsupportedOperationException("Input was not matrix");
            }
        }
        
            
        this.m = values.length;
        this.n = values[0].length;
        this.data = new int[n*m];
        for (int i = 0; i < this.m; i++){
            for(int j = 0; j < this.n; j++){
                this.set(i, j, values[i][j]);
            }
        }
    }
    
    public int get(int index){
        return this.data[index];
    }
    
    public int get(int i, int j){
        return this.data[this.n * i + j];
    }
    
    public void set(int index, int value){
        this.data[index] = value;
    }
    
    public void set(int i, int j, int value){
        //System.out.format("[%d,%d] -> %d * %d + %d = %d\r\n", i, j, this.n , i , j, this.n * i + j);
        // i-rows * size of row + j-comun
        this.data[this.n * i + j] = value;
    }
    
    public static MyMatrix sum(MyMatrix a, MyMatrix b)
    {
        if(a.m != b.m || a.n != b.n)
            throw new UnsupportedOperationException("Matrixes does not have same width or langht");      
        
        MyMatrix total = new MyMatrix(a.m, a.n);
        for (int i = 0; i < a.data.length; i++){
            total.data[i] = a.data[i] + b.data[i];
        }
        return total;
    }
    
    public static MyMatrix GaussElimination(MyMatrix a){
        MyMatrix gauss = new MyMatrix(a.m, a.n);
        System.arraycopy(a.data, 0, gauss.data, 0, gauss.m * gauss.n);
        
        
        
        return gauss;
    }
    
    
    public static MyMatrix multiplication(MyMatrix a, MyMatrix b){
        if(a.n != b.m)
            throw new UnsupportedOperationException("Matrixes are not multipliable"); 
        MyMatrix total = new MyMatrix(a.m, b.n);
        for(int i = 0; i < total.m; i++){
            for(int j = 0; j < total.n; j++){
                int tmp = 0;
                for(int k = 0; k < a.n; k++){
                    tmp += a.get(i, k) * b.get(k, j);
                    total.set(i, j, tmp);
                }
            }
        }
        return total;
    }
    
    public static MyMatrix multiplicationByConstant(MyMatrix a, int constant){
        MyMatrix total = new MyMatrix(a.m, a.n);
        for(int i = 0; i < a.m * a.n; i++){
            total.data[i] = a.data[i] * constant;
        }
        return total;
    }
    
    public static void GetRandom()
    {
        MyMatrix m = new MyMatrix(2,2);
        m.get(150);
    }
}
