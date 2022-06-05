package org.suai.lab10.dop;

import java.util.*;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class IterativeParallelism {

    public <R, T> R parallelize(int numberOfThreads,
                                List<? extends T> list,
                                Function<List<? extends T>, R> operation,
                                Function<? super List<R>, R> finalOperation) throws InterruptedException {
        List<R> res = new ArrayList<>();
        List<Thread> threads = new ArrayList<>();

        int size = list.size();
        int start = 0;
        int part = Math.round((float) size / numberOfThreads);
        int finish = part;

        for (int i = 0; i < numberOfThreads - 1; i++) {
            int finalStart = start;
            int finalFinish = finish;

            Thread thread = new Thread(() -> {
                R cur = operation.apply(list.subList(finalStart, finalFinish));
                res.add(cur);
            });

            threads.add(thread);
            start = finish;
            finish += part;
        }

        int finalStart = start;

        Thread thread = new Thread(() -> {
            R cur = operation.apply(list.subList(finalStart, size));
            res.add(cur);
        });

        threads.add(thread);

        for (var curThread : threads)
            curThread.start();

        for (var curThread : threads)
            curThread.join();

        return finalOperation.apply(res);
    }

    public <R, T> List<R> parallelize(int numberOfThreads,
                                      List<? extends T> list,
                                      Function<List<? extends T>, List<R>> operation) throws InterruptedException {
        List<List<R>> res = new ArrayList<>();
        List<Thread> threads = new ArrayList<>();

        int size = list.size();
        int start = 0;
        int part = Math.round((float) size / numberOfThreads);
        int finish = part;

        for (int i = 0; i < numberOfThreads - 1; i++) {
            int finalStart = start;
            int finalFinish = finish;

            Thread thread = new Thread(() -> {
                var cur = operation.apply(list.subList(finalStart + 1, finalFinish));
                res.add(cur);
            });

            threads.add(thread);
            start = finish;
            finish += part;
        }

        int finalStart = start;

        Thread thread = new Thread(() -> {
            var cur = operation.apply(list.subList(finalStart, size));
            res.add(cur);
        });

        threads.add(thread);

        for (var curThread : threads)
            curThread.start();

        for (var curThread : threads)
            curThread.join();

        List<R> result = new ArrayList<>();

        for (var cur : res) {
            result.addAll(cur);
        }

        return result;
    }

    public <T> T minimum(int numberOfThreads, List<? extends T> list, Comparator<? super T> comparator)
            throws InterruptedException {
        Function<List<? extends T>, T> function = part -> Collections.min(part, comparator);
        return parallelize(numberOfThreads, list, function, function);
    }

    public <T> T maximum(int numberOfThreads, List<? extends T> list, Comparator<? super T> comparator)
            throws InterruptedException {
        Function<List<? extends T>, T> function = part -> Collections.max(part, comparator);
        return parallelize(numberOfThreads, list, function, function);
    }

    public <T> boolean all(int numberOfThreads, List<? extends T> list, Predicate<? super T> predicate)
            throws InterruptedException {
        return parallelize(numberOfThreads, list,
                part -> part.stream().allMatch(predicate),
                part -> part.stream().allMatch(Boolean::booleanValue));
    }

    public <T> boolean any(int numberOfThreads, List<? extends T> list, Predicate<? super T> predicate)
            throws InterruptedException {
        return parallelize(numberOfThreads, list,
                part -> part.stream().anyMatch(predicate),
                part -> part.stream().anyMatch(Boolean::booleanValue));
    }

    public <T> List<T> filter(int numberOfThreads, List<? extends T> list, Predicate<? super T> predicate)
            throws InterruptedException {
        return parallelize(numberOfThreads, list,
                part -> part.stream().filter(predicate).collect(Collectors.toList()));
    }

    public <U, T> List<U> map(int numberOfThreads, List<? extends T> list, Function<? super T, ? extends U> function)
            throws InterruptedException {
        return parallelize(numberOfThreads, list,
                part -> part.stream().map(function).collect(Collectors.toList()));
    }

    public String join(int numberOfThreads, List<?> list) throws InterruptedException {
        return parallelize(numberOfThreads, list,
                Objects::toString,
                Objects::toString);
    }
}
