package com.luoxiaobatman.assignment.interview.coding.moka;

import com.luoxiaobatman.assignment.support.solution.AbstractSolution;
import com.luoxiaobatman.assignment.support.solution.GenericSolution;
import lombok.AllArgsConstructor;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

@AllArgsConstructor
public class LatestCommonDep extends AbstractSolution<Integer>
        implements GenericSolution<Integer> {
    private final String[] source;
    /**
     * length=2
     */
    private final int[] departmentIds;

    @Override
    public Integer doSolve() {
        // key是部门的id, value是部门对象
        Map<Integer, Department> departmentMap = Arrays.stream(source).map(s -> {
            String[] wrapper = s.split(" ");
            int id = Integer.parseInt(wrapper[0]);
            int pid = Integer.parseInt(wrapper[1]);
            String name = wrapper[2];
            return new Department(id, pid, name);
        }).collect(Collectors.toMap(department -> department.id, Function.identity()));

//        return brutalForce(departmentMap, departmentIds);
        return optimized(departmentMap, departmentIds);
    }

    private int brutalForce(Map<Integer, Department> departmentMap, int[] ids) {
        List<Department> firstAncestors = ancestors(departmentMap, ids[0]);
        List<Department> secondAncestors = ancestors(departmentMap, ids[1]);
        for (Department firstAncestor : firstAncestors) {
            if (secondAncestors.contains(firstAncestor)) {
                return firstAncestor.id;
            }
        }
        return -1;
    }

    private List<Department> ancestors(Map<Integer, Department> departmentMap, int id) {
        List<Department> ancestors = new ArrayList<>();
        for (; ; ) {
            Department department = departmentMap.get(id);
            if (department == null) break;
            ancestors.add(department);
            id = department.pid;
        }
        ancestors.remove(0);
        return ancestors;
    }

    private int optimized(Map<Integer, Department> departmentMap, int[] ids) {
        List<Department> firstAncestors = ancestors(departmentMap, ids[0]);
        Set<Department> secondAncestors = ancestorsSet(departmentMap, ids[1]);
        for (Department firstAncestor : firstAncestors) {
            if (secondAncestors.contains(firstAncestor)) {
                return firstAncestor.id;
            }
        }
        return -1;
    }

    private Set<Department> ancestorsSet(Map<Integer, Department> departmentMap, int id) {
        Set<Department> ancestors = new HashSet<>();
        int nodeId = id;
        for (; ; ) {
            Department department = departmentMap.get(nodeId);
            if (department == null) break;
            ancestors.add(department);
            nodeId = department.pid;
        }
        ancestors.remove(departmentMap.get(id));
//        ancestors.remove(0);
        return ancestors;
    }

    /**
     * 根据a,b 返回最近的父部门
     * 要求：不能新增参数，不能增加static变量
     *
     * @return
     */
//    public static int getCommonParent(int a, int b, List<Department> allDepartment) {
//        return 0;
//    }
    private static class Department {
        /**
         * id
         */
        private int id;
        /**
         * parent id
         */
        private int pid;
        /**
         * 名称
         */
        private String name;

        public Department(int id, int pid, String name) {
            this.id = id;
            this.pid = pid;
            this.name = name;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public int getPid() {
            return pid;
        }

        public void setPid(int pid) {
            this.pid = pid;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        @Override
        public boolean equals(Object obj) {
            if (obj instanceof Department) {
                return id == ((Department) obj).id;
            }
            return false;
        }

        @Override
        public int hashCode() {
            return id;
        }

        @Override
        public String toString() {
            return "Department{" +
                    "id=" + id +
                    ", pid=" + pid +
                    ", name='" + name + '\'' +
                    '}';
        }
    }
}
