/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import java.util.ArrayList;
import java.util.Iterator;

/**
 *
 * @author Ultron
 */
public interface IGraph<V, E> {
    
    public void addVertice(V data);
    
    public void addEdge(V v, V u, E weight);
    
    public int numVertices();
    
    public int numEdges();
    
    public boolean isEmpty();
    
    public E getEgde(V v, V u);
    
    public V opposite(V vertex, E e);
    
    public ArrayList<V> getEndpoints(E e);
    
    public void removeEdge(E e);
    
    public void removeVertex(V v);
    
    public int getDegree(V vertex);
    
    public Iterator<V> vertices();
    
    public Iterator<E> edges();
        
}
