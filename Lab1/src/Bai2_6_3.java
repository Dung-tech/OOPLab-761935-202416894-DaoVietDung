import javax.swing.*;

public class Bai2_6_3 {
    public static void main(String[] args) {
        String strA, strB, strC;
        double a, b, c, delta, x, x1, x2;

        strA = JOptionPane.showInputDialog(null, "Please input a: ");
        strB = JOptionPane.showInputDialog(null, "Please input b: ");
        strC = JOptionPane.showInputDialog(null, "Please input c: ");

        a = Double.parseDouble(strA);
        b = Double.parseDouble(strB);
        c = Double.parseDouble(strC);

        if (a == 0) {
            if (b == 0) {
                if (c == 0) {
                    JOptionPane.showMessageDialog(null, "Infinite solutions.");
                } else {
                    JOptionPane.showMessageDialog(null, "No solution.");
                }
            } else {
                x = -c / b;
                JOptionPane.showMessageDialog(null, "Linear equation result: x = " + x);
            }
        } else {
            delta = b * b - 4 * a * c;

            if (delta > 0) {
                x1 = (-b + Math.sqrt(delta)) / (2 * a);
                x2 = (-b - Math.sqrt(delta)) / (2 * a);
                JOptionPane.showMessageDialog(null, "Two distinct roots: x1 = " + x1 + " and x2 = " + x2);
            } else if (delta == 0) {
                x = -b / (2 * a);
                JOptionPane.showMessageDialog(null, "Double root: x = " + x);
            } else {
                JOptionPane.showMessageDialog(null, "No real solution (Delta < 0).");
            }
        }
    }
}
