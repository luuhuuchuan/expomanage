/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package expomanagement;

/**
 *
 * @author Hse7en
 */
public class Main {
        public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Login().setVisible(true);
            }
        });
    }
}
