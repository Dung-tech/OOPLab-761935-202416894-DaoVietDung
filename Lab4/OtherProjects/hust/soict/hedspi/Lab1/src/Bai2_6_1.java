package hust.soict.hedspi.Lab1.src;

import javax.swing.*;

public class Bai2_6_1 {
    public static void main(String[] args) {
        String strA, strB;
        double a, b, x;

        strA = JOptionPane.showInputDialog(null, "Please input the a: ", JOptionPane.INFORMATION_MESSAGE);
        strB = JOptionPane.showInputDialog(null, "Please input the b: ", JOptionPane.INFORMATION_MESSAGE);

        a = Double.parseDouble(strA);
        b = Double.parseDouble(strB);
        if (a == 0 && b == 0) {
            JOptionPane.showMessageDialog(null,"Infinite Solutions."  , "Show results", JOptionPane.INFORMATION_MESSAGE);
        }
        else if(a != 0){
            x = -b/a;
            JOptionPane.showMessageDialog(null,"x = " + x , "Show results", JOptionPane.INFORMATION_MESSAGE);
        }
        else{
            JOptionPane.showMessageDialog(null, "No Solution.", "Show results ", JOptionPane.INFORMATION_MESSAGE);
        }
    }
}
