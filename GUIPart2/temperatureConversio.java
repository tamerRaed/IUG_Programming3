package GUIPart2;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class temperatureConversio extends JFrame {

    public temperatureConversio() {
        JLabel lapel1 = new JLabel("Enter Celsius temperature:");
        JTextField textField = new JTextField();
        textField.setColumns(25);
        JRadioButton radio1 = new JRadioButton("Fahrenheit");
        JRadioButton radio2 = new JRadioButton("Kelvin");
        ButtonGroup group = new ButtonGroup();
        group.add(radio1);
        group.add(radio2);
        JPanel panel2 = new JPanel();
        panel2.setLayout(new FlowLayout());
        panel2.add(radio1);
        panel2.add(radio2);
        JLabel lapel2 = new JLabel("New temperature in is:");
        JPanel panel = new JPanel();
        JPanel panel3 = new JPanel();
        panel3.add(textField);
        panel3.setLayout(new FlowLayout(FlowLayout.CENTER));
        panel.setLayout(new GridLayout(4, 1));
        JPanel panel4 = new JPanel(new FlowLayout(FlowLayout.CENTER));
        panel4.add(lapel1);
        JPanel panel5 = new JPanel(new FlowLayout(FlowLayout.CENTER));
        panel5.add(lapel2);
        panel.add(panel4);
        panel.add(panel3);
        panel.add(panel2);
        panel.add(panel5);
        radio1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                float Celsius = 0;
                try {
                    Celsius = Integer.parseInt(textField.getText());
                    float Fahrenheit = 0;
                    Fahrenheit = Celsius * 9 / 5 + 32;
                    lapel2.setText("New temperature in is:" + String.valueOf(Fahrenheit));
                } catch (NumberFormatException e) {
                    System.out.println(e.getMessage());
                }
            }
        });
        radio2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                try {
                    float Celsius = Integer.parseInt(textField.getText());
                    float Kelvin = 0;
                    Kelvin = (float) (Celsius + 273.15);
                    lapel2.setText("New temperature in is: " + String.valueOf(Kelvin));
                } catch (NumberFormatException e) {
                    System.out.println(e.getMessage());
                }
            }
        });
        add(panel);

    }

    public static void main(String[] args) {
        temperatureConversio temperatureconversio = new temperatureConversio();
        temperatureconversio.setLayout(new FlowLayout());
        temperatureconversio.setTitle("Temperature-Conversio");
        Dimension d = new Dimension(450, 200);
        temperatureconversio.setSize(d);
        temperatureconversio.setLocationRelativeTo(null);
        temperatureconversio.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        temperatureconversio.setVisible(true);
    }

}
