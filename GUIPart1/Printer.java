
package GUIPart1;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class Printer extends JFrame {

    Printer() {
        JLabel printer = new JLabel("Printer : MyPrinter");
        this.add(printer);
       
        JTextArea area1 = new JTextArea(3,3);
        area1.setLineWrap(true);
        JScrollPane scroll = new JScrollPane(area1);
        scroll.setPreferredSize(new Dimension(50, 50));
        
        JTextArea area2 = new JTextArea(3,3);
        area2.setLineWrap(true);
        JScrollPane scroll2 = new JScrollPane(area2);
        scroll2.setPreferredSize(new Dimension(50, 50));
        
        JTextArea area3 = new JTextArea(3, 1);
        area3.setLineWrap(true);
        JScrollPane scroll3 = new JScrollPane(area3);
        scroll2.setPreferredSize(new Dimension(50, 50));
        
        JLabel label2 = new JLabel("Print Quality:");

        JCheckBox box1 = new JCheckBox("Image");
        JCheckBox box2 = new JCheckBox("Text");
        JCheckBox box3 = new JCheckBox("Code");

        JPanel boxContainar = new JPanel();
        GridLayout gridLayout = new GridLayout(3, 1);
        boxContainar.setLayout(gridLayout);
        boxContainar.add(box1);
        boxContainar.add(box2);
        boxContainar.add(box3);

        JRadioButton radio1 = new JRadioButton("Selection");
        JRadioButton radio2 = new JRadioButton("All");
        JRadioButton radio3 = new JRadioButton("Applet");

        ButtonGroup group = new ButtonGroup();
        group.add(radio1);
        group.add(radio2);
        group.add(radio3);

        JPanel radioContainar = new JPanel();
        radioContainar.setLayout(gridLayout);
        radioContainar.add(radio1);
        radioContainar.add(radio2);
        radioContainar.add(radio3);

        JPanel buttonContainar = new JPanel();
        GridLayout grid3 = new GridLayout(4, 1);
        buttonContainar.setLayout(grid3);
        JButton button1 = new JButton("OK");
        JButton button2 = new JButton("Cancel");
        JButton button3 = new JButton("Setup...");
        JButton button4 = new JButton("Help");
        buttonContainar.add(button1);
        buttonContainar.add(button2);
        buttonContainar.add(button3);
        buttonContainar.add(button4);
        grid3.setVgap(10);

        JComboBox<String> boxs = new JComboBox<>();
        boxs.addItem("High");
        boxs.addItem("Medium");
        boxs.addItem("Low");

        JCheckBox box_print_file = new JCheckBox("Print to File");
        
        JPanel containar = new JPanel();
        containar.setLayout(new GridLayout(1, 1));

        containar.add(scroll);
        containar.add(boxContainar);
        containar.add(scroll2);
        containar.add(radioContainar);
        containar.add(scroll3);

        JPanel bottom = new JPanel();
        GridLayout singleRow = new GridLayout(1, 1);
        bottom.setLayout(singleRow);
        bottom.add(label2);
        bottom.add(boxs);
        bottom.add(box_print_file);

        this.add(containar);
        this.add(buttonContainar);
        this.add(bottom);

        setSize(500, 220);
        setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        FlowLayout flowLayout = new FlowLayout(FlowLayout.LEFT);
        flowLayout.setVgap(0);
        this.setLayout(flowLayout);
        this.setResizable(false);
        this.setTitle("Printer");
        setVisible(true);
    }

    public static void main(String[] args) {
        new Printer();
    }
}
