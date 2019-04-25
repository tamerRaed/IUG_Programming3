/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUIPart1;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Align extends JFrame {

    public Align() {
        FlowLayout flow1 = new FlowLayout(FlowLayout.LEFT);
        JPanel panel1 = new JPanel();
        panel1.setLayout(new GridLayout(2, 1));

        JCheckBox b1 = new JCheckBox("Snap to Grid");
        JCheckBox b2 = new JCheckBox("Show Grid");

        panel1.add(b1);
        panel1.add(b2);

        JPanel panel2 = new JPanel();
        panel2.setLayout(new GridLayout(2, 2, 10, 10));

        JLabel label1 = new JLabel("x:");
        JTextField field1 = new JTextField(3);
        field1.setText("8");
        JLabel label2 = new JLabel("y:");
        JTextField field2 = new JTextField(3);
        field2.setText("8");

        panel2.add(label1);
        panel2.add(field1);
        panel2.add(label2);
        panel2.add(field2);

        JPanel panel3 = new JPanel();
        panel3.setLayout(new GridLayout(3, 1, 10, 10));

        JButton button1 = new JButton("Ok");
        JButton button2 = new JButton("Cancel");
        JButton button3 = new JButton("Help");

        panel3.add(button1);
        panel3.add(button2);
        panel3.add(button3);

        this.add(panel1);
        this.add(panel2);
        this.add(panel3);

        this.setLayout(flow1);
        setTitle("Align");
        Dimension d = new Dimension(350, 150);
        setSize(d);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public static void main(String[] args) {
        new Align();
    }
}
