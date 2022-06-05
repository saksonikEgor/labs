package org.suai.lab8;

public class MultiplyMatrix extends Thread{
    private final UsualMatrix m1;
    private final UsualMatrix m2;
    private final UsualMatrix res;
    private final int begin;
    private final int end;

    public MultiplyMatrix(UsualMatrix m1, UsualMatrix m2, UsualMatrix res, int begin, int end) {
        this.m1 = m1;
        this.m2 = m2;
        this.res = res;
        this.begin = begin;
        this.end = end;
    }

    @Override
    public void run() {
        for (int i = begin; i < end; i++)
            for (int k = 0; k < m1.getCol(); k++)
                for (int j = 0; j < res.getCol(); j++)
                    res.setElement(i, j, res.getElement(i, j) + m1.getElement(i, k) * m2.getElement(k, j));
    }
}
