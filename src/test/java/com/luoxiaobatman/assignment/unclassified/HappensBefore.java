package com.luoxiaobatman.assignment.unclassified;

import com.luoxiaobatman.assignment.blackbox.reorder.*;
import com.luoxiaobatman.assignment.support.Factory;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.DisabledIfSystemProperty;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class HappensBefore {
    @DisplayName("指令重排验证")
    @Test
    public void reorderTest() {
        assertReorder(NormalReorder.class);
    }

    @DisplayName("添加 synchronized 关键字不影响指令重排")
    @Test
    public void reorderTestSynchronized() {
        assertReorder(SynchronizedReorder.class);
    }

    @DisplayName("添加 lower synchronized 关键字不影响指令重排")
    @Test
    public void reorderTestLowerSynchronized() {
        assertReorder(LowerHalfSynchronizedReorder.class);
    }

    @DisplayName("添加 upper synchronized 关键字不影响指令重排")
    @Test
    public void reorderTestUpperSynchronized() {
        assertReorder(UpperHalfSynchronizedReorder.class);
    }

    @DisabledIfSystemProperty(named = "sun.arch.data.model", matches = "64")
    @DisplayName("32位虚拟机long型写入不是原子的")
    @Test
    public void longIsNotAtomic() {
        Assertions.assertThrows(ExpectedException.class, () -> {
            int size = 10;
            BlockingQueue<Runnable> bq = new ArrayBlockingQueue<>(size);
            ThreadPoolExecutor executor = new ThreadPoolExecutor(size, size, 1000, TimeUnit.MILLISECONDS, bq);
            for (; ; ) {
                List<Future<?>> futuresSet = new ArrayList<>(size / 2);
                List<Future<?>> futuresGet = new ArrayList<>(size / 2);
                for (int i = 0; i < size / 2; i++) {
                    LongIsNotAtomic longIsNotAtomic = new LongIsNotAtomic();
                    futuresSet.add(executor.submit(longIsNotAtomic::set));
                    Future<?> futureGet = executor.submit(() -> {
                        long r = longIsNotAtomic.get();
                        if (r != LongIsNotAtomic.MAX && r != 0L) {
                            throw new ExpectedException(ExpectedException.LONG_IS_NOT_ATOMIC);
                        }
                    });
                    futuresGet.add(futureGet);
                }
                try {
                    for (Future<?> future : futuresSet) {
                        future.get();
                    }
                    for (Future<?> future : futuresGet) {
                        future.get();
                    }
                } catch (InterruptedException e) {
                    // noop
                } catch (ExecutionException e) {
                    throw e.getCause();
                }
            }
        }, ExpectedException.LONG_IS_NOT_ATOMIC);
    }

    private void assertReorder(Class<? extends IReorder> clazz) {
        Assertions.assertThrows(ExpectedException.class, () -> {
            reorderTestInner(clazz);
        }, ExpectedException.REORDER);
    }

    private void reorderTestInner(Class<? extends IReorder> clazz) throws Throwable {
        Factory<IReorder> reorderFactory = Factory.of(IReorder.class);
        int size = 20;
        BlockingQueue<Runnable> bq = new ArrayBlockingQueue<>(size);
        ThreadPoolExecutor executor = new ThreadPoolExecutor(size, size, 1000, TimeUnit.MILLISECONDS, bq);
        for (; ; ) {
            List<Future<?>> futuresSet = new ArrayList<>(size / 2);
            List<Future<?>> futuresReorder = new ArrayList<>(size / 2);
            for (int i = 0; i < size / 2; i++) {
                IReorder reorder = reorderFactory.newInstance(clazz);
                futuresSet.add(executor.submit(reorder::set));
                Future<?> futureReorder = executor.submit(() -> {
                    if (reorder.reordering() == Reorder.REORDERING_HIT) {
                        throw new ExpectedException(ExpectedException.REORDER);
                    }
                });
                futuresReorder.add(futureReorder);
            }
            try {
                for (Future<?> future : futuresSet) {
                    future.get();
                }
                for (Future<?> future : futuresReorder) {
                    future.get();
                }
            } catch (InterruptedException e) {
                // noop
            } catch (ExecutionException e) {
                throw e.getCause();
            }
        }
    }
}
