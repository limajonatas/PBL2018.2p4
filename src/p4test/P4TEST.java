/**
 * INÍCIO DO PACOTE: 13:50 - 9.12.18
 */
package p4test;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;

/**
 *
 * @author John
 */
public class P4TEST {

    /**
     * @param args the command line arguments
     * @throws java.io.FileNotFoundException , position); string =
     * string.substring(position + 1
     */
    public static void main(String[] args) throws FileNotFoundException, IOException {
        ReadFile rf = new ReadFile();
        rf.read();
        System.out.println(rf.numVertices());
        System.out.println(rf.numArestas());
        /////////////////////////////////////////////////////
        /*
        Iterator it = rf.read();
        while(it.hasNext() == true){
            City c = (City) it.next();
            System.out.printf("%s ", c.getName());
            System.out.printf("%d;", c.getPositionX());
            System.out.println(c.getPositionY());
        }*/
        
        /*BufferedReader br = new BufferedReader(new FileReader("./file.txt"));
        
                String c = br.readLine();
                System.out.println(c);

                int position = c.indexOf("|");
                String city = c.substring(0, position);
                System.out.println(city);

                c = c.substring(position + 1, c.length());

                position = c.indexOf(";");
                int x = Integer.parseInt(c.substring(0, position));
                System.out.println(x);

                int y = Integer.parseInt(c.substring(position + 1, c.length()));
                System.out.println(y);
         */

          
    }

}
