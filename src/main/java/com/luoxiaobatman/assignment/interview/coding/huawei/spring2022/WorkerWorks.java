package com.luoxiaobatman.assignment.interview.coding.huawei.spring2022;

import com.luoxiaobatman.assignment.support.solution.AbstractSolution;
import com.luoxiaobatman.assignment.support.solution.GenericSolution;
import lombok.AllArgsConstructor;
import org.jetbrains.annotations.NotNull;

import java.util.*;

/**
 *
 */
@AllArgsConstructor
public class WorkerWorks extends AbstractSolution<Integer> implements GenericSolution<Integer> {
    private final int arg;

    @Override
    public Integer doSolve() {
        return arg;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 工人数量
        int workerCount = in.nextInt();
        List<Workload> workloads = new ArrayList<>();
        Map<String, Integer> fruitOrderMap = new HashMap<>();
        int order = 0;
        while (in.hasNext()) {
            String fruit = in.next();
            if (!fruitOrderMap.containsKey(fruit)) {
                fruitOrderMap.put(fruit, order);
                order++;
            }
            workloads.add(new Workload(fruit, in.nextLong(), in.nextLong()));
        }

        workloads.sort((first, second) -> {
            int fruitDelta = fruitOrderMap.get(first.fruit) - fruitOrderMap.get(second.fruit);
            if (fruitDelta != 0) {
                return fruitDelta;
            }
            long loadDelta = first.load - second.load;
            if (loadDelta != 0) {
                if (loadDelta > 0) return 1;
                return -1;
            }

            long idDelta = first.workerId - second.workerId;
            if (idDelta > 0) return 1;
            if (idDelta < 0) return -1;
            return 0;
        });
        for (Workload workload : workloads) {
            StringBuilder sb = new StringBuilder();
            sb.append(workload.fruit);
            sb.append(" ");
            sb.append(workload.workerId);
            sb.append(" ");
            sb.append(workload.load);
            System.out.println(sb);
        }
    }

    private static class Workload {
        private String fruit;
        private long workerId;
        private long load;

        private Workload(String fruit, long workerId, long load ) {
            this.fruit = fruit;
            this.workerId = workerId;
            this.load = load;
        }
    }
}
