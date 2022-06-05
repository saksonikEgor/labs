package org.suai.lab8;

import java.util.ArrayList;

public class ParallelMatrixProduct {
    private final ArrayList<MultiplyMatrix> threads;
    private final int numOfThreads;

    public ParallelMatrixProduct(int numOfThreads) {
        this.numOfThreads = numOfThreads;
        this.threads = new ArrayList<>();
    }

    public UsualMatrix product(UsualMatrix m1, UsualMatrix m2) throws InterruptedException {
        var res = new UsualMatrix(m1.getRow(), m2.getCol());

        int begin = 0;
        int part = Math.round((float) res.getRow() / numOfThreads);
        int end = part;

        for (int i = 1; i < numOfThreads; i++) {
            MultiplyMatrix th = new MultiplyMatrix(m1, m2, res, begin, end);
            th.start();
            this.threads.add(th);

            begin = end;
            end += part;
        }

        end = res.getRow();

        if (begin != end) {
            var remainder = new MultiplyMatrix(m1, m2, res, begin, end);
            remainder.start();
            this.threads.add(remainder);
        }

        for (var th : this.threads) {
            th.join();
        }

        return res;
    }
}
