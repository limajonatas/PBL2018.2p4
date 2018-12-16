/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.HashMap;
import java.util.Iterator;

/**
 *
 * @author Ultron
 */
public class Graph<V, E> implements IGraph<V, E> {

    private LinkedList<Vertice<V>> verList;
    private LinkedList<Edge<E>> edgeList;
    int numVertices, numEdges;

    public Graph() {
        this.verList = new LinkedList<>();
        this.edgeList = new LinkedList<>();
        this.numEdges = 0;
        this.numVertices = 0;
    }

    @Override
    public void addVertice(V data) {
        Vertice<V> ver = new Vertice(data);
        if (!verList.contains(ver)) {
            verList.add(ver);
            this.numVertices++;
        }
    }

    @Override
    public void addEdge(V v, V u, E data) {
        Vertice<V> ver1 = getVertice(v);
        Vertice<V> ver2 = getVertice(u);
        //Verifica se os vertices pertencem ao grafo
        if (ver1 != null && ver2 != null) {
            Edge<E> edge = new Edge(ver1, ver2, data);
            edgeList.add(edge);
            ver1.addEdge(ver2, edge);
            ver2.addEdge(ver1, edge);
            this.numEdges++;
        }
    }

    private Vertice<V> getVertice(V vertex) {
        for (Vertice ver : this.verList) {
            if (ver.content.equals(vertex)) {
                return (Vertice<V>) ver;
            }
        }
        return null;
    }

    private Edge<E> getEdge(E edge) {
        for (Edge e : this.edgeList) {
            if (e.weight.equals(edge)) {
                return (Edge) e;
            }
        }
        return null;
    }

    @Override
    public int numVertices() {
        return this.numVertices;

    }

    @Override
    public int numEdges() {
        return this.numEdges;
    }

    @Override
    public boolean isEmpty() {
        return this.verList.isEmpty();

    }

    @Override
    public int getDegree(V vertex) {
        Vertice<V> ver = getVertice(vertex);
        if (ver != null) {
            return ver.getDegree();
        }
        return 0;
    }

    @Override
    public Iterator<V> vertices() {
        LinkedList<V> list = new LinkedList<>();
        this.verList.forEach((v) -> {
            list.add(v.content);
        });
        return list.iterator();
    }

    @Override
    public Iterator<E> edges() {
        LinkedList<E> list = new LinkedList<>();
        this.edgeList.forEach((edge) -> {
            list.add(edge.weight);
        });
        return list.iterator();
    }

    @Override
    public ArrayList<V> getEndpoints(E e) {
        ArrayList<V> array = new ArrayList<>(2);
        Edge content = this.getEdge(e);
        array.add(0, (V) content.incVertex.get(0));
        array.add(1, (V) content.incVertex.get(1));
        return array;
    }

    @Override
    public void removeEdge(E e) {
        Iterator it = this.edgeList.iterator();
        this.edgeList.remove(this.getEdge(e));
    }

    @Override
    public void removeVertex(V v) {
        Vertice<V> ver = this.getVertice(v);
        if (ver != null) {
            ver.incidenceList.values().forEach((e) -> {
                Vertice<V> aux = this.getVertice(this.opposite(v, (E) e));
                aux.incidenceList.remove(ver, e);
                this.edgeList.remove(e);
            });
            this.verList.remove(ver);
        }
    }

    @Override
    public E getEgde(V v, V u) {
        Vertice ver = this.getVertice(v);
        Vertice ver1 = this.getVertice(u);
        if (ver != null && ver1 != null) {
            Edge<E> e = (Edge<E>) ver.incidenceList.get(ver1);
            if (e != null) {
                return e.weight;
            }
        }
        return null;
    }

    @Override
    public V opposite(V vertex, E e) {
        Edge<E> edge = this.getEdge(e);
        Vertice<V> ver = this.getVertice(vertex);
        if (edge != null) {
            if (edge.incVertex.contains(ver)) {
                if (edge.incVertex.get(0).equals(ver)) {
                    return edge.incVertex.get(1).content;
                } else {
                    return edge.incVertex.get(0).content;
                }
            }
        }
        return null;
    }

    private class Vertice<V> {

        private HashMap<Vertice<V>, Edge<E>> incidenceList;
        private V content;
        private int degree;

        public Vertice(V content) {
            incidenceList = new HashMap<>();
            this.content = content;
            degree = 0;
        }

        public void addEdge(Vertice<V> vertice, Edge<E> edge) {
            this.incidenceList.put(vertice, edge);
            this.degree++;
        }

        public int getDegree() {
            return degree;
        }

        @Override
        public boolean equals(Object o1) {
            if (o1 instanceof Vertice) {
                Vertice obj = (Vertice) o1;
                return this.content.equals(obj.content);
            }
            return false;
        }

        @Override
        public int hashCode() {
            return this.content.hashCode();
        }

        @Override
        public String toString() {
            return "" + this.content;
        }

    }

    private class Edge<E> {

        private ArrayList<Vertice<V>> incVertex;
        private E weight;

        public E getWeight() {
            return weight;
        }

        public Edge(Vertice vertex1, Vertice vertex2, E weight) {
            incVertex = new ArrayList<>(2);
            incVertex.add(0, vertex1);
            incVertex.add(1, vertex2);
            this.weight = weight;
        }
    }
}
