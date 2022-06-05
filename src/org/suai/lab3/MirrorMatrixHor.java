package org.suai.lab3;

import org.suai.lab3.Matrix;

public class MirrorMatrixHor extends Matrix {

    public MirrorMatrixHor(int row, int col){
        super(row, col);
        this.row = row * 2;
    }
}
