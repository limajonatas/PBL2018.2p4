/**
 * INÍCIO DO PACOTE: 13:50 - 9.12.18
 */
package view;

import java.awt.BorderLayout;
import java.awt.Container;
import java.io.FileNotFoundException;
import java.io.IOException;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

/**
 *
 * @author John
 */
public class view {

    /**
     * @param args the command line arguments
     * @throws java.io.FileNotFoundException , position); string =
     * string.substring(position + 1
     */
    public static void main(String[] args) throws FileNotFoundException, IOException {
        Map map = new Map();
        Container window = new JPanel(new BorderLayout());
        JMenuBar bar = new JMenuBar();
        JMenu menu = new JMenu();
        menu.setText("Opções");
        JMenuItem item = new JMenuItem();
        item.setText("Importar arquivo...");
        menu.add(item);
        bar.add(menu);
        map.setJMenuBar(bar);
        bar.setSize(700, 100);
        
    }
 

}

