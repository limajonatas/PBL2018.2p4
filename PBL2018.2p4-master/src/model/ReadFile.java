package model;

import exceptions.FileDoNotExistException;
import com.sun.javafx.scene.control.skin.VirtualFlow.ArrayLinkedList;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;
import util.Graph;

/**
 *
 * @author John
 */
public class ReadFile {

    private String path;
    private Graph<City, Integer> graph;

    public ReadFile() {
        this.path = "./Entrada de Dados-PBL4(1).txt";
        this.graph = new Graph<>();
    }

    public Iterator read() throws FileNotFoundException, IOException {
        try {
            BufferedReader br = new BufferedReader(new FileReader(path));
            ArrayLinkedList a = new ArrayLinkedList();
            
            String cityName, string;
            int x, y;

            if (br.ready() == true) {
                br.readLine(); //pula o nome do mapa

                while (br.ready() == true) {
                    string = br.readLine();
                    if (string.equals("Distancia entre cidades")) {
                        break;
                    }
                    City city = new City();
                    int position = string.indexOf("|");
                    city.setName(string.substring(0, position - 1));
                    string = string.substring(position + 2, string.length());
                    position = string.indexOf("|");
                    city.setPositionX(Integer.parseInt((string.substring(0, position))));
                    city.setPositionY(Integer.parseInt((string.substring(position + 1, string.length()))));
                    a.addLast(city); 
                    this.graph.addVertice(city);
                }

                while (br.ready() == true) {
                    string = br.readLine();
                    City c1 = new City();
                    City c2 = new City();
                    int position = string.indexOf("|");
                    c1.setName(string.substring(0, position - 1));
                    
                    Iterator it = a.iterator();
                    while(it.hasNext() == true){
                        City c = (City) it.next();
                        if(c1.getName().equals(c.getName())){
                            c.setPositionX(c1.getPositionX());
                            c.setPositionY(c1.getPositionY());
                            break;
                        }
                    }
                    
                    string = string.substring(position + 2, string.length());
                    position = string.indexOf("|");
                    c2.setName(string.substring(0, position - 1));
                    
                    it = a.iterator();
                    while(it.hasNext() == true){
                        City c = (City) it.next();
                        if(c1.getName().equals(c.getName())){
                            c.setPositionX(c1.getPositionX());
                            c.setPositionY(c1.getPositionY());
                            break;
                        }
                    }
                    
                    int w = Integer.parseInt(string.substring(position + 2, string.length()));
                    this.graph.addEdge(c1, c2, w);
                }
            }

            return a.iterator();
        } catch (FileNotFoundException e) {
            throw new FileDoNotExistException();
        }
    }

    public int numVertices() {
        return this.graph.numVertices();
    }

    public int numArestas() {
        return this.graph.numEdges();
    }
}
