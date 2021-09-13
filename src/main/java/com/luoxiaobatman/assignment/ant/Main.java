package com.luoxiaobatman.assignment.ant;


import com.luoxiaobatman.assignment.solution.Solution;
import com.luoxiaobatman.assignment.support.Factory;

import java.util.*;

/**
 * TODO test
 *
 * deadline
 * 直接用main函数演示
 */
@SuppressWarnings("rawtypes")
public class Main {
    public static void main(String[] args) {
        Factory<Solution> solutionFactory = Factory.of(Solution.class);
        // 问题1 START
        List<String> strings = Arrays.asList("foo", "bar", "baz", "oof", "", "dasfadsfa", "sadfad", null);
        Solution solution = solutionFactory.newInstance(AggUnorderedString.class, strings);
        System.out.println(solution.solve());
        System.out.println("---------------------");
        // 问题1 END

//        // 问题2 START
//        int[] array = {1, 2, 3, 4};
//        int m = 2;
//        LocationFinder locationFinderSolution = SolutionFactory.get(LocationFinder.class, array, m);
//        int locationFinderSolutionResult = locationFinderSolution.solve();
//        System.out.println(locationFinderSolutionResult);
//        System.out.println("---------------------");
//        // 问题2 END
//
//        // 问题3 START
//        int nThread = 5;
//        int maxN = 1000;
//        int nFile = 4;
//        Collection<String> paths = new ArrayList<>();
//        // 修改到文件所在文件夹
//        String pathTemplate = "/Users/xiaoluo/ant_homework_data/%d.txt";
//        for (int i = 0; i < nFile; i++) {
//            paths.add(String.format(pathTemplate, i));
//        }
//        Max1000Numbers max1000NumbersSolution = SolutionFactory.get(Max1000Numbers.class, paths, nThread, maxN);
//        SortedSet<Long> max1000NumbersSolutionResult = max1000NumbersSolution.solve();
//        System.out.println(max1000NumbersSolutionResult);
//        // 问题3 END
    }
}
