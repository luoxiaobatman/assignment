package com.luoxiaobatman.assignment.ant;

import com.luoxiaobatman.assignment.solution.Solution;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Collection;
import java.util.SortedSet;
import java.util.concurrent.*;

/**
 * ConcurrentSkipListSet
 * 生产消费确保1000, TODO FixedSizeConcurrentSkipListSet ?
 */
public class Max1000Numbers implements Solution<SortedSet<Long>> {
    private final Collection<String> paths;
    private final int nThread;
    private final int maxN;
    public Max1000Numbers(Collection<String> paths, int nThread, int maxN) {
        this.paths = paths;
        this.nThread = nThread;
        this.maxN = maxN;
    }

    @Override
    @Cache
    public SortedSet<Long> solve() {
        ConcurrentSkipListSet<Long> set = new ConcurrentSkipListSet<>();

        // task queue相关问题了解, 这里不会出现
        ThreadPoolExecutor executor = (ThreadPoolExecutor) Executors.newFixedThreadPool(this.nThread);
        for (String pathS: this.paths) {
            executor.execute(() -> {
                Path path = Paths.get(pathS);
                try {
                    Files.lines(path).forEach(s -> {
                        try {
                            set.add(Long.parseLong(s));
                        } catch (Exception e) {
                            //
                        }
                    });
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });
        }
        while (executor.getActiveCount() > 0 || set.size() > maxN) {
            if (set.size() > maxN) {
                set.pollFirst();
            }
        }
        executor.shutdown();
        return set;
    }
}
