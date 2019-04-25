
package GUIPart1;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.AbstractButton;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class calculator extends JFrame {

    private JTextField field;
    private JPanel panel;
    private JButton[] Buttons;

    calculator() {
        panel = new JPanel(new GridLayout(4, 4,5,5));
        Buttons = new JButton[16];
        for (int i = 0; i <= 9; i++) {
            Buttons[i] = new JButton(String.valueOf(i));
        }
        Buttons[10] = new JButton("/");
        Buttons[11] = new JButton("*");
        Buttons[12] = new JButton("-");
        Buttons[13] = new JButton("+");
        Buttons[14] = new JButton("=");
        Buttons[15] = new JButton(".");
        
        EventHandler eventHandler = new EventHandler();
        for (JButton button : Buttons) {
            button.addActionListener(eventHandler);
            button.setFont(new Font("Serif", Font.BOLD, 14));
            panel.add(button);
        }
        field = new JTextField();
        field.setFont(new Font("Arial", Font.BOLD, 18));
        field.setForeground(Color.black);
        setLayout(new BorderLayout());
        add(field, BorderLayout.NORTH);
        add(panel, BorderLayout.CENTER);
        setTitle("Calculator");
        Dimension d = new Dimension(250, 250);
        setSize(d);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    private class EventHandler implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            field.setText(
                    ((AbstractButton) e.getSource()).getText());

        }
    }
    public static void main(String[] args) {
        new calculator();
    }
}
