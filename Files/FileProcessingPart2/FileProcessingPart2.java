package Chapter4.FileProcessingPart2;

import java.awt.Color;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.Scanner;
import javax.swing.JColorChooser;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

public class FileProcessingPart2 extends JFrame {

    public FileProcessingPart2() {

        JTextArea area = new JTextArea();
        JScrollPane scrollPane = new JScrollPane(area);
        area.setEditable(true);
        area.setLineWrap(true);
        area.setFont(new Font("Arial", Font.PLAIN, 16));
        scrollPane.setPreferredSize(new Dimension(400, 450));
        JMenuBar JMenuBar = new JMenuBar();

        JMenu file = new JMenu("File");
        JMenuItem open = new JMenuItem("open", 'o');
        file.add(open);
        JMenuItem save = new JMenuItem("save", 's');
        file.add(save);
        JMenuItem close = new JMenuItem("close", 'c');
        file.add(close);
        JMenuItem exit = new JMenuItem("Exit", 'x');
        file.add(exit);

        JMenu edit = new JMenu("Edit");
        JMenuItem font = new JMenuItem("font", 'f');
        edit.add(font);
        JMenuItem color = new JMenuItem("color", 'l');
        edit.add(color);
        JMenuBar.add(file);
        JMenuBar.add(edit);

        String[] fonts = {"plain", "italic", "bold"};
        JComboBox<String> JComboBox = new JComboBox<>(fonts);

        JColorChooser colorChooser = new JColorChooser();
        colorChooser.setColor(Color.BLACK);

        JFileChooser fileChooser = new JFileChooser();
        open.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                fileChooser.showOpenDialog(rootPane);

                if (fileChooser.getSelectedFile() != null) {
                    File file = fileChooser.getSelectedFile();

                    Scanner scanner = null;
                    try {
                        scanner = new Scanner(file);
                    } catch (FileNotFoundException ee) {
                        ee.printStackTrace();
                    }
                    if (scanner == null) {
                        throw new AssertionError();
                    }
                    while (scanner.hasNextLine()) {
                        area.setText(area.getText()
                                + "\n" + scanner.nextLine());

                    }
                }
            }
        });

        save.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                File file1 = fileChooser.getSelectedFile();

                if (file1 != null) {
                    String textHolder = "";
                    String newLine = System.getProperty("line.separator");
                    Scanner scanner = new Scanner(area.getText());
                    while (scanner.hasNext()) {
                        textHolder = textHolder.concat(scanner.nextLine() + newLine);
                    }
                    String path = file1.getPath();
                    FileOutputStream fos = null;
                    try {
                        fos = new FileOutputStream(path);
                    } catch (FileNotFoundException ee) {
                        ee.printStackTrace();
                    }
                    PrintWriter pw = new PrintWriter(fos);
                    pw.write(textHolder);
                    pw.flush();
                    pw.close();
                }
            }
        });

        close.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                area.setText("");
            }
        });

        exit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        font.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, JComboBox, "font",
                        JOptionPane.INFORMATION_MESSAGE);
                if (JComboBox.getSelectedIndex() == 0) {
                    area.setFont(new Font("Arial", Font.PLAIN, 16));
                } else if (JComboBox.getSelectedIndex() == 1) {
                    area.setFont(new Font("Arial", Font.ITALIC, 16));
                } else {
                    area.setFont(new Font("Arial", Font.BOLD, 16));
                }
            }
        });

        color.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                area.setForeground(JColorChooser.showDialog(null,
                        "Colors", Color.black));

            }
        });
        setSize(620, 570);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("File Processing");
        setResizable(true);
        setJMenuBar(JMenuBar);
        add(scrollPane);
        setVisible(true);

    }

    public static void main(String[] args) {
        new FileProcessingPart2();
    }
}
