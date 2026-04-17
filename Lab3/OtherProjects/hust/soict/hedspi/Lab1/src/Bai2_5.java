package hust.soict.hedspi.Lab1.src;

import javax.swing.JOptionPane;

public class Bai2_5 {
    public static void main(String[] args) {
        String strNum1, strNum2;
        double sum, dif, pro, quo;

        strNum1 = JOptionPane.showInputDialog(null, "Please input the first number: ", "Input the first number", JOptionPane.INFORMATION_MESSAGE);
        strNum2 = JOptionPane.showInputDialog(null, "Please input the second number: ", "Input the second number", JOptionPane.INFORMATION_MESSAGE);

        double num1 = Double.parseDouble(strNum1);
        double num2 = Double.parseDouble(strNum2);
        sum = num1 + num2;
        dif = num1 - num2;
        pro = num1 * num2;
        if (num2 != 0) {
            quo = num1 / num2;
            JOptionPane.showMessageDialog(null, "Sum: " + sum + "\nDifference: " + dif + "\nProduct: " + pro + "\nQuotient: " + quo, "Show results ", JOptionPane.INFORMATION_MESSAGE);
        }
        else{
            JOptionPane.showMessageDialog(null, "Sum: " + sum + "\nDifference: " + dif + "\nProduct: " + pro + "\nQuotient: Undefinded", "Show results ", JOptionPane.INFORMATION_MESSAGE);
        }
    }
}
