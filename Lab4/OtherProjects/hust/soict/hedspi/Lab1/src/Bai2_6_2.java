package hust.soict.hedspi.Lab1.src;

import javax.swing.*;

public class Bai2_6_2 {
    public static void main(String[] args) {
        String strA11, strA12, strA21, strA22, strB1, strB2;
        double a11, a12, a21, a22, b1, b2, x1, x2;

        strA11 = JOptionPane.showInputDialog(null, "Please input a11: ");
        strA12 = JOptionPane.showInputDialog(null, "Please input a12: ");
        strB1 =  JOptionPane.showInputDialog(null, "Please input b1: ");
        strA21 = JOptionPane.showInputDialog(null, "Please input a21: ");
        strA22 = JOptionPane.showInputDialog(null, "Please input a22: ");
        strB2 =  JOptionPane.showInputDialog(null, "Please input b2: ");

        a11 = Double.parseDouble(strA11);
        a12 = Double.parseDouble(strA12);
        b1  = Double.parseDouble(strB1);
        a21 = Double.parseDouble(strA21);
        a22 = Double.parseDouble(strA22);
        b2  = Double.parseDouble(strB2);

        double D  = a11 * a22 - a21 * a12;
        double D1 = b1 * a22 - b2 * a12;
        double D2 = a11 * b2 - a21 * b1;

        if (D != 0) {
            x1 = D1 / D;
            x2 = D2 / D;
            JOptionPane.showMessageDialog(null, "System has a unique solution: x1 = " + x1 + " and x2 = " + x2);
        } else {
            if (D1 == 0 && D2 == 0) {
                JOptionPane.showMessageDialog(null, "System has infinitely many solutions.");
            } else {
                JOptionPane.showMessageDialog(null, "System has no solution.");
            }
        }
    }
}