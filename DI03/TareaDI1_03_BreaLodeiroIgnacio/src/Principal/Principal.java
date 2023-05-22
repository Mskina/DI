package Principal;

import Vista.Dreams;
import static javax.swing.WindowConstants.EXIT_ON_CLOSE;

/**
 *
 * @author Ignacio Brea Lodeiro
 */
public class Principal {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Dreams form = new Dreams();
        form.setSize(1200, 1024);
        form.setVisible(true);
        form.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

}
