package com.luoxiaobatman.assignment.leetcode;

import com.luoxiaobatman.assignment.support.solution.GenericAnswer;

import java.util.*;
import java.util.function.Consumer;
import java.util.stream.Collectors;

public class Template {
    public interface Visitor {
        /**
         * 访问者
         *
         * @param consumer ...
         */
        void visit(Consumer<Visitor> consumer);
    }

    public interface GenericSolution<T> {
        GenericAnswer<T> solve();
    }

    public interface GenericAnswer<T> {
        T getAnswer();

        void setAnswer(T answer);
    }

    public interface Identifier {
        String id();

        boolean equals(Object obj);

        int hashCode();

        String toString();

        Object mark();

        void mark(Object mark);
    }

    public interface Node {
        /**
         * 与节点断开连接
         *
         * @param identifier 节点索引
         */
        void disconnect(Identifier identifier);

        /**
         * 与节点建立连接
         *
         * @param identifier ...
         */
        void connect(Identifier identifier);

        /**
         * 与节点建立带权重的连接
         *
         * @param identifier ...
         * @param weight     权重
         */
        void connect(Identifier identifier, int weight);

        Identifier getIdentifier();

        /**
         * @return 图中的节点标识
         */
        Set<Identifier> adjacent();
    }

    public static class StandardAnswer<T> implements GenericAnswer<T> {
        private T answer;

        @Override
        public T getAnswer() {
            return answer;
        }

        @Override
        public void setAnswer(T answer) {
            this.answer = answer;
        }
    }

    public static abstract class AbstractSolution<T> implements GenericSolution<T> {
        @Override
        public GenericAnswer<T> solve() {
            StandardAnswer<T> answer = new StandardAnswer<>();
            answer.setAnswer(doSolve());
            return answer;
        }

        public abstract T doSolve();
    }

    /**
     * 练习画图
     */
    public interface Graph {
        /**
         * 幂等 替换节点包括删除节点所有的edge
         *
         * @param nodeIdentifier ...
         */
        void put(Identifier nodeIdentifier);

        /**
         * @param nodeIdentifier ...
         * @return null if absent, otherwise identifier previously contained in this graph
         */
        Identifier putIfAbsent(Identifier nodeIdentifier);

        void remove(Identifier nodeIdentifier);

        boolean exists(Identifier identifier);

        void connect(OrderedPair<Identifier> identifierOrderedPair);

        void connect(OrderedPair<Identifier> identifierOrderedPair, int weight);

        /**
         * 删除pair之间的连接 如果有
         *
         * @param identifierOrderedPair ...
         */
        void disconnect(OrderedPair<Identifier> identifierOrderedPair);

        Map<Identifier, Node> getNodes();

        void dfs(Consumer<Identifier> consumer);

        void bfs(Consumer<Identifier> consumer);

        void dfs(Consumer<Identifier> consumer, Identifier start);

        void bfs(Consumer<Identifier> consumer, Identifier start);
    }

    public static abstract class GraphVisitor<R> extends AbstractSolution<R> implements Visitor, GenericSolution<R> {
        final protected Graph graph;

        public GraphVisitor(Graph g) {
            this.graph = g;
        }

        @Override
        public void visit(Consumer<Visitor> consumer) {
            Graph graph = (Graph) consumer;
            visit(graph);
        }

        ;

        abstract protected void visit(Graph graph);
    }

    public interface Edge {
        int SMALLEST_WEIGHT = 1;

        Identifier partner(Identifier identifier);

        OrderedPair<Identifier> pair();

        int getWeight();
    }

    public static final class OrderedPair<E> {
        public static <E> OrderedPair<E> of(E white, E black) {
            return new OrderedPair<>(white, black);
        }

        OrderedPair(E white, E black) {
            this.black = black;
            this.white = white;
        }

        public final E white;
        public final E black;

        public E viceVersa(E vice) {
            if (white.equals(vice)) {
                return black;
            } else if (black.equals(white)) {
                return white;
            }
            return null;
        }
    }

    public static class TopologySort extends GraphVisitor<List<Identifier>> {
        static private final Integer MARK_PERMANENT = 1;
        static private final Integer MARK_TEMPORARY = 2;
        private List<Identifier> sorted;

        public TopologySort(Graph g) {
            super(g);
        }

        @Override
        public List<Identifier> doSolve() {
            try {
                visit(graph);
            } catch (CyclicException e) {
                return null;
            }
            return sorted;
        }

        @Override
        protected void visit(Graph graph) throws CyclicException {
            sorted = new ArrayList<>();
            if (!(graph instanceof DirectedGraph)) {
                return;
            }
            for (Identifier identifier : graph.getNodes().keySet()) {
                if (!MARK_PERMANENT.equals(identifier.mark())) {
                    visit(graph, identifier);
                }
            }
            System.out.println(sorted);
        }


        /**
         * node 有两个标识, permanent, temporary
         *
         * @param graph      有向图
         * @param identifier 节点标识
         * @throws CyclicException visit identifier 有 temporary标记
         */
        private void visit(Graph graph, Identifier identifier) throws CyclicException {
            if (MARK_TEMPORARY.equals(identifier.mark())) {
                throw new CyclicException();
            }
            if (MARK_PERMANENT.equals(identifier.mark())) {
                return;
            }
            identifier.mark(MARK_TEMPORARY);
            Node node = graph.getNodes().get(identifier);

            for (Identifier adjacent : node.adjacent()) {
                visit(graph, adjacent);
            }
            identifier.mark(MARK_PERMANENT);
            sorted.add(0, identifier);
        }

        private static class CyclicException extends RuntimeException {
        }
    }

    public static abstract class AbstractGraph implements Graph, Consumer<Visitor> {
        protected final Map<Identifier, Node> nodes = new HashMap<>();

        @Override
        public void put(Identifier nodeIdentifier) {
            remove(nodeIdentifier);
            nodes.put(nodeIdentifier, new StandardNode(nodeIdentifier));
        }

        @Override
        public Identifier putIfAbsent(Identifier nodeIdentifier) {
            Node existedNode = nodes.putIfAbsent(nodeIdentifier, new StandardNode(nodeIdentifier));
            if (existedNode == null) {
                return null;
            }
            return existedNode.getIdentifier();
        }

        @Override
        public void remove(Identifier nodeIdentifier) {
            Node existedNode = nodes.get(nodeIdentifier);
            if (existedNode != null) {
                remove(existedNode);
            }
        }

        private void remove(Node node) {
            nodes.remove(node.getIdentifier());
            for (Identifier identifier : node.adjacent()) {
                nodes.get(identifier).disconnect(node.getIdentifier());
            }
        }

        @Override
        public boolean exists(Identifier identifier) {
            return nodes.containsKey(identifier);
        }

        @Override
        public void connect(OrderedPair<Identifier> identifierOrderedPair) {
            connect(identifierOrderedPair, Edge.SMALLEST_WEIGHT);
        }

        @Override
        public void disconnect(OrderedPair<Identifier> identifierOrderedPair) {
            nodes.get(identifierOrderedPair.white).disconnect(identifierOrderedPair.black);
            nodes.get(identifierOrderedPair.black).disconnect(identifierOrderedPair.white);
        }

        @Override
        public void accept(Visitor visitor) {
            if (visitor instanceof GraphVisitor) {
                visitor.visit(this);
            }
        }

        @Override
        public Map<Identifier, Node> getNodes() {
            return nodes;
        }

        @Override
        public void dfs(Consumer<Identifier> consumer) {
        }

        @Override
        public void bfs(Consumer<Identifier> consumer) {
            Collection<Node> values = nodes.values();
            if (values.isEmpty()) return;

            Queue<Identifier> waiting = new LinkedList<>();
            Set<Identifier> seen = new HashSet<>();

            for (Node node : values) {
                waiting.offer(node.getIdentifier());
                while (!waiting.isEmpty()) {
                    Identifier hit = waiting.poll();
                    if (seen.contains(hit)) continue;
                    consumer.accept(hit);
                    for (Identifier next : nodes.get(hit).adjacent()) {
                        waiting.offer(next);
                    }
                    seen.add(hit);
                }
            }
        }

        @Override
        public void dfs(Consumer<Identifier> consumer, Identifier start) {

        }

        @Override
        public void bfs(Consumer<Identifier> consumer, Identifier start) {

        }
    }

    public static class StandardNode implements Node {
        /**
         * node 的全局唯一标识
         */
        private final Identifier identifier;

        public Identifier getIdentifier() {
            return identifier;
        }

        @Override
        public Set<Identifier> adjacent() {
            return edges.values().stream()
                    .map(edge -> edge.partner(this.identifier)).collect(Collectors.toSet());
        }

        private final Map<Identifier, Edge> edges = new HashMap<>();

        StandardNode(Identifier identifier) {
            this.identifier = identifier;
        }

        @Override
        public void disconnect(Identifier identifier) {
            edges.remove(this.identifier);
        }

        @Override
        public void connect(Identifier identifier) {
            connect(identifier, Edge.SMALLEST_WEIGHT);
        }

        @Override
        public void connect(Identifier identifier, int weight) {
            edges.put(identifier, new EdgeImpl(OrderedPair.of(this.identifier, identifier), weight));
        }

        @Override
        public int hashCode() {
            return identifier.id().hashCode();
        }

        @Override
        public boolean equals(Object obj) {
            if (obj == null) return false;
            if (!(obj instanceof StandardNode another)) return false;
            return this.identifier.equals(another.identifier);
        }
    }

    public static class EdgeImpl implements Edge {
        private final int weight;
        private final OrderedPair<Identifier> identifierOrderedPair;

        public EdgeImpl(OrderedPair<Identifier> identifierOrderedPair, int weight) {
            this.weight = Math.max(Edge.SMALLEST_WEIGHT, weight);
            this.identifierOrderedPair = identifierOrderedPair;
        }

        @Override
        public Identifier partner(Identifier identifier) {
            if (identifier == identifierOrderedPair.white) return identifierOrderedPair.black;
            if (identifier == identifierOrderedPair.black) return identifierOrderedPair.white;
            return null;
        }

        @Override
        public OrderedPair<Identifier> pair() {
            return identifierOrderedPair;
        }

        @Override
        public int getWeight() {
            return weight;
        }
    }

    public static class DirectedGraph extends AbstractGraph implements Graph {
        @Override
        public void connect(OrderedPair<Identifier> identifierOrderedPair, int weight) {
            Identifier white = putIfAbsent(identifierOrderedPair.white);
            if (white == null) {
                white = identifierOrderedPair.white;
            }
            Identifier black = putIfAbsent(identifierOrderedPair.black);
            if (black == null) {
                black = identifierOrderedPair.black;
                ;
            }
            nodes.get(white).connect(black, weight);
        }
    }

    public static class CharacterIdentifier extends AbstractIdentifier implements Identifier {
        private char c;

        public CharacterIdentifier(char id) {
            c = id;
        }

        @Override
        public String id() {
            return String.valueOf(c);
        }
    }

    public static abstract class AbstractIdentifier implements Identifier {
        private Object mark;

        public Object mark() {
            return mark;
        }

        public void mark(Object m) {
            this.mark = m;
        }

        @Override
        public boolean equals(Object obj) {
            if (obj == null) return false;
            if (!(obj instanceof Identifier other)) {
                return false;
            }
            return id().equals(other.id());
        }

        @Override
        public int hashCode() {
            return id().hashCode();
        }

        @Override
        public String toString() {
            return id();
        }
    }
}
