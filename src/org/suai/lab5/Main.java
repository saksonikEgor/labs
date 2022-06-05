package org.suai.lab5;

public class Main {
    public static void main(String []args){
        UsualMatrix uM = new UsualMatrix(1000, 1000);
        SparseMatrix spM = new SparseMatrix(1000,1000);

        for (int i = 0; i < 1000; i++){
            uM.setElement( i, i, i % 10);
            spM.setElement( i, i, i % 10);
        }
        System.out.println(uM.sum(uM).equals(spM.sum(spM)));
        System.out.println(uM.sum(spM).equals(spM.sum(uM)));
        System.out.println(uM.product(uM).equals(spM.product(spM)));
        System.out.println(uM.product(spM).equals(spM.product(uM)));
    }
}
