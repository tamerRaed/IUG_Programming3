package GUIPart2;

import java.awt.Color;
import java.awt.FlowLayout;
import javax.swing.JFrame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class GuessingGame extends JFrame {

    private int number;

    public GuessingGame() {

        number = (int) (Math.random() * 100);

        JLabel JLable1 = new JLabel("I have a number between 1 and 100.");
        JLabel JLable2 = new JLabel("Can you guess my number ?");
        JLabel massege = new JLabel("Enter your guess in here : ");
        JTextField input = new JTextField(4);
        massege.setLabelFor(input);
        JButton reset = new JButton("New Game");

        reset.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == reset) {
                    number = (int) (Math.random() * 100);
                    massege.setText("Enter your guess in here : ");
                    input.setText("");
                    input.setEditable(true);
                    getContentPane().setBackground(Color.white);
                }
            }
        });

        input.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    int inputNum = Integer.parseInt(input.getText());
                    if (inputNum == number) {
                        massege.setText("Correct !! You Guessed It");
                        getContentPane().setBackground(Color.GREEN);
                        input.setEditable(false);
                    } else if (inputNum > number) {
                        massege.setText("Too High.Try a lower number");
                        getContentPane().setBackground(Color.RED);
                    } else if (inputNum < number) {
                        massege.setText("Too Low.Try a higher number");
                        getContentPane().setBackground(Color.BLUE);
                    }

                } catch (NumberFormatException numExc) {
                    JOptionPane.showMessageDialog(null, numExc.getMessage(), "Erorr", JOptionPane.ERROR_MESSAGE);
                }

            }
        });

        add(JLable1);
        add(JLable2);
        add(massege);
        add(input);
        add(reset);
        setSize(300, 150);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Guessing Game");
        setLayout(new FlowLayout(FlowLayout.CENTER));
        setVisible(true);

    }

    public static void main(String[] args) {
        new GuessingGame();
    }
}
