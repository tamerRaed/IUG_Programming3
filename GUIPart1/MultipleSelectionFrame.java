
package GUIPart1;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;

public class MultipleSelectionFrame extends JFrame {

    private final JList<String> colorJList;
    private final JList<String> copyJList;
    private JButton copyJButton;
    private static final String[] colorNames = {"Black", "Blue", "Cyan",
        "Dark Gray", "Gray", "Green", "Light Gray", "Magenta", "Orange",
        "Pink", "Red", "White", "Yellow"};

    public MultipleSelectionFrame() {
        
        super("Multiple Selection Lists");
        setLayout(new FlowLayout());
        colorJList = new JList<String>(colorNames);
        colorJList.setVisibleRowCount(5);
        colorJList.setSelectionMode(
                ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
        add(new JScrollPane(colorJList));
        copyJButton = new JButton("Copy >>>");
        copyJButton.addActionListener(
                new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {
                copyJList.setListData(
                        colorJList.getSelectedValuesList().toArray(
                                new String[0]));
            }});
        
        add(copyJButton);
        copyJList = new JList<String>();
        copyJList.setVisibleRowCount(5);
        copyJList.setFixedCellWidth(100);
        copyJList.setFixedCellHeight(15); 
        copyJList.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        add(new JScrollPane(copyJList));
        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);      
        setSize(350, 150);
        setLocationRelativeTo(null);
        setVisible(true);

    }

    public static void main(String[] args) {
        new MultipleSelectionFrame();
    }
}
