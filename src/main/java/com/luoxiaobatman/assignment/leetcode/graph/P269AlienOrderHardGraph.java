package com.luoxiaobatman.assignment.leetcode.graph;

import com.luoxiaobatman.assignment.datastructure.graph.GraphVisitor;
import com.luoxiaobatman.assignment.datastructure.graph.TopologySort;
import com.luoxiaobatman.assignment.datastructure.graph.adjacentlist.DirectedGraph;
import com.luoxiaobatman.assignment.datastructure.graph.Graph;
import com.luoxiaobatman.assignment.datastructure.graph.adjacentlist.Node;
import com.luoxiaobatman.assignment.datastructure.support.CharacterIdentifier;
import com.luoxiaobatman.assignment.datastructure.support.Identifier;
import com.luoxiaobatman.assignment.datastructure.support.OrderedPair;
import com.luoxiaobatman.assignment.designpattern.behavior.vistor.Visitor;
import com.luoxiaobatman.assignment.support.solution.AbstractSolution;
import com.luoxiaobatman.assignment.support.solution.GenericSolution;
import com.luoxiaobatman.assignment.support.solution.Solver;
import lombok.AllArgsConstructor;

import java.util.*;
import java.util.function.Consumer;
import java.util.stream.Collectors;

/**
 * 图 拓扑排序
 * <p>
 * 现有一种使用英语字母的火星语言，这门语言的字母顺序与英语顺序不同。
 * <p>
 * 给你一个字符串列表 words ，作为这门语言的词典，words 中的字符串已经 按这门新语言的字母顺序进行了排序 。
 * <p>
 * 请你根据该词典还原出此语言中已知的字母顺序，并 按字母递增顺序 排列。若不存在合法字母顺序，返回 "" 。若存在多种可能的合法字母顺序，返回其中 任意一种 顺序即可。
 * <p>
 * 字符串 s 字典顺序小于 字符串 t 有两种情况：
 * <p>
 * 在第一个不同字母处，如果 s 中的字母在这门外星语言的字母顺序中位于 t 中字母之前，那么 s 的字典顺序小于 t 。
 * 如果前面 min(s.length, t.length) 字母都相同，那么 s.length < t.length 时，s 的字典顺序也小于 t 。
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：words = ["wrt","wrf","er","ett","rftt"]
 * 输出："wertf"
 * 示例 2：
 * <p>
 * 输入：words = ["z","x"]
 * 输出："zx"
 * 示例 3：
 * <p>
 * 输入：words = ["z","x","z"]
 * 输出：""
 * 解释：不存在合法字母顺序，因此返回 "" 。
 *  
 * <p>
 * 提示：
 * <p>
 * 1 <= words.length <= 100
 * 1 <= words[i].length <= 100
 * words[i] 仅由小写英文字母组成
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/alien-dictionary
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
@AllArgsConstructor
public class P269AlienOrderHardGraph
        extends AbstractSolution<String> implements GenericSolution<String> {
    private final String[] alienWords;

    @Override
    public String doSolve() {
        return alienOrder(alienWords);
    }

    public String alienOrder(String[] words) {
        Graph graph = new DirectedGraph();
        for (int i = 0; i < words.length - 1; i++) {
            String frontWord = words[i];
            String endWord = words[i + 1];
            for (char c: frontWord.toCharArray()) {
                graph.putIfAbsent(new CharacterIdentifier(c));
            }
            for (char c: endWord.toCharArray()) {
                graph.putIfAbsent(new CharacterIdentifier(c));
            }
            OrderedPair<Identifier> characterOrder = evaluate(frontWord, endWord);
            if (characterOrder != null) {
                graph.connect(characterOrder);
            }
        }
        List<Identifier> solve = new TopologySort(graph).doSolve();
        if (solve == null) return "";
        StringBuilder sb = new StringBuilder();
        solve.forEach(sb::append);
        return sb.toString();

    }

    static protected OrderedPair<Identifier> evaluate(String frontWord, String endWord) {
        int minLengthOfWords = Math.min(frontWord.length(), endWord.length());

        for (int i = 0; i < minLengthOfWords; i++) {
            char frontChar = frontWord.charAt(i);
            char endChar = endWord.charAt(i);
            if (frontChar != endChar) {
                return OrderedPair.of(new CharacterIdentifier(frontChar), new CharacterIdentifier(endChar));
            }
        }
        return null;
    }


    // ====================== leetcode ===================
//
//    public interface Visitor {
//        /**
//         * 访问者
//         *
//         * @param consumer ...
//         */
//        void visit(Consumer<Visitor> consumer);
//    }
//
//    public interface GenericSolution<T> {
//        GenericAnswer<T> solve();
//    }
//
//    public interface GenericAnswer<T> {
//        T getAnswer();
//
//        void setAnswer(T answer);
//    }
//
//    public interface Identifier {
//        String id();
//
//        boolean equals(Object obj);
//
//        int hashCode();
//
//        String toString();
//
//        Object mark();
//
//        void mark(Object mark);
//    }
//
//    public interface Node {
//        /**
//         * 与节点断开连接
//         *
//         * @param identifier 节点索引
//         */
//        void disconnect(Identifier identifier);
//
//        /**
//         * 与节点建立连接
//         *
//         * @param identifier ...
//         */
//        void connect(Identifier identifier);
//
//        /**
//         * 与节点建立带权重的连接
//         *
//         * @param identifier ...
//         * @param weight     权重
//         */
//        void connect(Identifier identifier, int weight);
//
//        Identifier getIdentifier();
//
//        /**
//         * @return 图中的节点标识
//         */
//        Set<Identifier> adjacent();
//    }
//
//    public static class StandardAnswer<T> implements GenericAnswer<T> {
//        private T answer;
//
//        @Override
//        public T getAnswer() {
//            return answer;
//        }
//
//        @Override
//        public void setAnswer(T answer) {
//            this.answer = answer;
//        }
//    }
//
//    public static abstract class AbstractSolution<T> implements GenericSolution<T> {
//        @Override
//        public GenericAnswer<T> solve() {
//            StandardAnswer<T> answer = new StandardAnswer<>();
//            answer.setAnswer(doSolve());
//            return answer;
//        }
//
//        public abstract T doSolve();
//    }
//
//    /**
//     * 练习画图
//     */
//    public interface Graph {
//        /**
//         * 幂等 替换节点包括删除节点所有的edge
//         *
//         * @param nodeIdentifier ...
//         */
//        void put(Identifier nodeIdentifier);
//
//        /**
//         * @param nodeIdentifier ...
//         * @return null if absent, otherwise identifier previously contained in this graph
//         */
//        Identifier putIfAbsent(Identifier nodeIdentifier);
//
//        void remove(Identifier nodeIdentifier);
//
//        boolean exists(Identifier identifier);
//
//        void connect(OrderedPair<Identifier> identifierOrderedPair);
//
//        void connect(OrderedPair<Identifier> identifierOrderedPair, int weight);
//
//        /**
//         * 删除pair之间的连接 如果有
//         *
//         * @param identifierOrderedPair ...
//         */
//        void disconnect(OrderedPair<Identifier> identifierOrderedPair);
//
//        Map<Identifier, Node> getNodes();
//
//        void dfs(Consumer<Identifier> consumer);
//
//        void bfs(Consumer<Identifier> consumer);
//
//        void dfs(Consumer<Identifier> consumer, Identifier start);
//
//        void bfs(Consumer<Identifier> consumer, Identifier start);
//    }
//
//    public static abstract class GraphVisitor<R> extends AbstractSolution<R> implements Visitor, GenericSolution<R> {
//        final protected Graph graph;
//
//        public GraphVisitor(Graph g) {
//            this.graph = g;
//        }
//
//        @Override
//        public void visit(Consumer<Visitor> consumer) {
//            Graph graph = (Graph) consumer;
//            visit(graph);
//        }
//
//        ;
//
//        abstract protected void visit(Graph graph);
//    }
//
//    public interface Edge {
//        int SMALLEST_WEIGHT = 1;
//
//        Identifier partner(Identifier identifier);
//
//        OrderedPair<Identifier> pair();
//
//        int getWeight();
//    }
//
//    public static final class OrderedPair<E> {
//        public static <E> OrderedPair<E> of(E white, E black) {
//            return new OrderedPair<>(white, black);
//        }
//
//        OrderedPair(E white, E black) {
//            this.black = black;
//            this.white = white;
//        }
//
//        public final E white;
//        public final E black;
//
//        public E viceVersa(E vice) {
//            if (white.equals(vice)) {
//                return black;
//            } else if (black.equals(white)) {
//                return white;
//            }
//            return null;
//        }
//    }
//
//    public static class TopologySort extends GraphVisitor<List<Identifier>> {
//        static private final Integer MARK_PERMANENT = 1;
//        static private final Integer MARK_TEMPORARY = 2;
//        private List<Identifier> sorted;
//
//        public TopologySort(Graph g) {
//            super(g);
//        }
//
//        @Override
//        public List<Identifier> doSolve() {
//            try {
//                visit(graph);
//            } catch (CyclicException e) {
//                return null;
//            }
//            return sorted;
//        }
//
//        @Override
//        protected void visit(Graph graph) throws CyclicException {
//            sorted = new ArrayList<>();
//            if (!(graph instanceof DirectedGraph)) {
//                return;
//            }
//            for (Identifier identifier : graph.getNodes().keySet()) {
//                if (!MARK_PERMANENT.equals(identifier.mark())) {
//                    visit(graph, identifier);
//                }
//            }
//            System.out.println(sorted);
//        }
//
//
//        /**
//         * node 有两个标识, permanent, temporary
//         *
//         * @param graph      有向图
//         * @param identifier 节点标识
//         * @throws CyclicException visit identifier 有 temporary标记
//         */
//        private void visit(Graph graph, Identifier identifier) throws CyclicException {
//            if (MARK_TEMPORARY.equals(identifier.mark())) {
//                throw new CyclicException();
//            }
//            if (MARK_PERMANENT.equals(identifier.mark())) {
//                return;
//            }
//            identifier.mark(MARK_TEMPORARY);
//            Node node = graph.getNodes().get(identifier);
//
//            for (Identifier adjacent : node.adjacent()) {
//                visit(graph, adjacent);
//            }
//            identifier.mark(MARK_PERMANENT);
//            sorted.add(0, identifier);
//        }
//
//        private static class CyclicException extends RuntimeException {
//        }
//    }
//
//    public static abstract class AbstractGraph implements Graph, Consumer<Visitor> {
//        protected final Map<Identifier, Node> nodes = new HashMap<>();
//
//        @Override
//        public void put(Identifier nodeIdentifier) {
//            remove(nodeIdentifier);
//            nodes.put(nodeIdentifier, new StandardNode(nodeIdentifier));
//        }
//
//        @Override
//        public Identifier putIfAbsent(Identifier nodeIdentifier) {
//            Node existedNode = nodes.putIfAbsent(nodeIdentifier, new StandardNode(nodeIdentifier));
//            if (existedNode == null) {
//                return null;
//            }
//            return existedNode.getIdentifier();
//        }
//
//        @Override
//        public void remove(Identifier nodeIdentifier) {
//            Node existedNode = nodes.get(nodeIdentifier);
//            if (existedNode != null) {
//                remove(existedNode);
//            }
//        }
//
//        private void remove(Node node) {
//            nodes.remove(node.getIdentifier());
//            for (Identifier identifier : node.adjacent()) {
//                nodes.get(identifier).disconnect(node.getIdentifier());
//            }
//        }
//
//        @Override
//        public boolean exists(Identifier identifier) {
//            return nodes.containsKey(identifier);
//        }
//
//        @Override
//        public void connect(OrderedPair<Identifier> identifierOrderedPair) {
//            connect(identifierOrderedPair, Edge.SMALLEST_WEIGHT);
//        }
//
//        @Override
//        public void disconnect(OrderedPair<Identifier> identifierOrderedPair) {
//            nodes.get(identifierOrderedPair.white).disconnect(identifierOrderedPair.black);
//            nodes.get(identifierOrderedPair.black).disconnect(identifierOrderedPair.white);
//        }
//
//        @Override
//        public void accept(Visitor visitor) {
//            if (visitor instanceof GraphVisitor) {
//                visitor.visit(this);
//            }
//        }
//
//        @Override
//        public Map<Identifier, Node> getNodes() {
//            return nodes;
//        }
//
//        @Override
//        public void dfs(Consumer<Identifier> consumer) {
//        }
//
//        @Override
//        public void bfs(Consumer<Identifier> consumer) {
//            Collection<Node> values = nodes.values();
//            if (values.isEmpty()) return;
//
//            Queue<Identifier> waiting = new LinkedList<>();
//            Set<Identifier> seen = new HashSet<>();
//
//            for (Node node : values) {
//                waiting.offer(node.getIdentifier());
//                while (!waiting.isEmpty()) {
//                    Identifier hit = waiting.poll();
//                    if (seen.contains(hit)) continue;
//                    consumer.accept(hit);
//                    for (Identifier next : nodes.get(hit).adjacent()) {
//                        waiting.offer(next);
//                    }
//                    seen.add(hit);
//                }
//            }
//        }
//
//        @Override
//        public void dfs(Consumer<Identifier> consumer, Identifier start) {
//
//        }
//
//        @Override
//        public void bfs(Consumer<Identifier> consumer, Identifier start) {
//
//        }
//    }
//
//    public static class StandardNode implements Node {
//        /**
//         * node 的全局唯一标识
//         */
//        private final Identifier identifier;
//
//        public Identifier getIdentifier() {
//            return identifier;
//        }
//
//        @Override
//        public Set<Identifier> adjacent() {
//            return edges.values().stream()
//                    .map(edge -> edge.partner(this.identifier)).collect(Collectors.toSet());
//        }
//
//        private final Map<Identifier, Edge> edges = new HashMap<>();
//
//        StandardNode(Identifier identifier) {
//            this.identifier = identifier;
//        }
//
//        @Override
//        public void disconnect(Identifier identifier) {
//            edges.remove(this.identifier);
//        }
//
//        @Override
//        public void connect(Identifier identifier) {
//            connect(identifier, Edge.SMALLEST_WEIGHT);
//        }
//
//        @Override
//        public void connect(Identifier identifier, int weight) {
//            edges.put(identifier, new EdgeImpl(OrderedPair.of(this.identifier, identifier), weight));
//        }
//
//        @Override
//        public int hashCode() {
//            return identifier.id().hashCode();
//        }
//
//        @Override
//        public boolean equals(Object obj) {
//            if (obj == null) return false;
//            if (!(obj instanceof StandardNode another)) return false;
//            return this.identifier.equals(another.identifier);
//        }
//    }
//
//    public static class EdgeImpl implements Edge {
//        private final int weight;
//        private final OrderedPair<Identifier> identifierOrderedPair;
//
//        public EdgeImpl(OrderedPair<Identifier> identifierOrderedPair, int weight) {
//            this.weight = Math.max(Edge.SMALLEST_WEIGHT, weight);
//            this.identifierOrderedPair = identifierOrderedPair;
//        }
//
//        @Override
//        public Identifier partner(Identifier identifier) {
//            if (identifier == identifierOrderedPair.white) return identifierOrderedPair.black;
//            if (identifier == identifierOrderedPair.black) return identifierOrderedPair.white;
//            return null;
//        }
//
//        @Override
//        public OrderedPair<Identifier> pair() {
//            return identifierOrderedPair;
//        }
//
//        @Override
//        public int getWeight() {
//            return weight;
//        }
//    }
//
//    public static class DirectedGraph extends AbstractGraph implements Graph {
//        @Override
//        public void connect(OrderedPair<Identifier> identifierOrderedPair, int weight) {
//            Identifier white = putIfAbsent(identifierOrderedPair.white);
//            if (white == null) {
//                white = identifierOrderedPair.white;
//            }
//            Identifier black = putIfAbsent(identifierOrderedPair.black);
//            if (black == null) {
//                black = identifierOrderedPair.black;
//                ;
//            }
//            nodes.get(white).connect(black, weight);
//        }
//    }
//
//    public static class CharacterIdentifier extends AbstractIdentifier implements Identifier {
//        private char c;
//
//        public CharacterIdentifier(char id) {
//            c = id;
//        }
//
//        @Override
//        public String id() {
//            return String.valueOf(c);
//        }
//    }
//
//    public static abstract class AbstractIdentifier implements Identifier {
//        private Object mark;
//
//        public Object mark() {
//            return mark;
//        }
//
//        public void mark(Object m) {
//            this.mark = m;
//        }
//
//        @Override
//        public boolean equals(Object obj) {
//            if (obj == null) return false;
//            if (!(obj instanceof Identifier other)) {
//                return false;
//            }
//            return id().equals(other.id());
//        }
//
//        @Override
//        public int hashCode() {
//            return id().hashCode();
//        }
//
//        @Override
//        public String toString() {
//            return id();
//        }
//    }
}
