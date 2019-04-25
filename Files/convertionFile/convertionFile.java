
package Chapter4.convertionFile;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.Formatter;
import javax.swing.JOptionPane;

public class convertionFile extends javax.swing.JFrame {
    File textFile = new File("C:\\Users\\hp\\Documents\\NetBeansProjects\\Programming3\\src\\Chapter4\\convertionFile\\text.txt");

    File binaryFile = new File("C:\\Users\\hp\\Documents\\NetBeansProjects\\Programming3\\src\\Chapter4\\convertionFile\\binary.dat");

    public convertionFile() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        toBinary = new javax.swing.JButton();
        toText = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        exit = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("convertion file");
        setBackground(new java.awt.Color(0, 153, 255));
        setForeground(new java.awt.Color(51, 153, 255));

        toBinary.setText("convert to binary");
        toBinary.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                actionToBinary(evt);
            }
        });

        toText.setText("convert to text");
        toText.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                actionToText(evt);
            }
        });

        jTextArea1.setEditable(false);
        jTextArea1.setColumns(20);
        jTextArea1.setLineWrap(true);
        jTextArea1.setRows(5);
        jTextArea1.setAutoscrolls(false);
        jScrollPane1.setViewportView(jTextArea1);

        exit.setBackground(new java.awt.Color(255, 51, 51));
        exit.setForeground(new java.awt.Color(51, 0, 51));
        exit.setText("Exit");
        exit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(exit)
                    .addComponent(toText, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(toBinary, javax.swing.GroupLayout.DEFAULT_SIZE, 128, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 48, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(56, 56, 56))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(toBinary)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(toText)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(exit)))
                .addContainerGap(26, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void actionToBinary(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_actionToBinary
        try {
            FileReader fileReader = new FileReader(textFile);
            BufferedReader bufferReder = new BufferedReader(fileReader);
            String result = "";
            for (String line = bufferReder.readLine(); line != null; line = bufferReder.readLine()) {
                result += line + "\n";
            }
            FileOutputStream fileOutStream = new FileOutputStream(binaryFile);
            DataOutputStream dataOutStream = new DataOutputStream(fileOutStream);
            dataOutStream.writeChars(result);
            dataOutStream.close();
            fileOutStream.close();
            jTextArea1.setText(result);
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        }

    }//GEN-LAST:event_actionToBinary

    private void actionToText(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_actionToText

        try {
            FileInputStream fileInputStream = new FileInputStream(binaryFile);
            DataInputStream dataInputStream = new DataInputStream(fileInputStream);
            String result = "";
            String tmp = "";
            for (int i = dataInputStream.read(); i != -1; i = dataInputStream.read()) {
                tmp += i;
                result += (char) i;
            }
            jTextArea1.setText(result);
            FileOutputStream fos = new FileOutputStream(textFile);

            Formatter formatter = new Formatter(fos);
            formatter.format("%s\n", result);
            formatter.close();
            fos.close();

            fos.close();
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        }

    }//GEN-LAST:event_actionToText

    private void exitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitActionPerformed
        int x = JOptionPane.showConfirmDialog(
                null, 
                "Are you sure to Exit?",
                "Confirm", 
                JOptionPane.YES_NO_OPTION, 
                JOptionPane.WARNING_MESSAGE 
        );
        if (x == 0) {
            System.exit(0);
        }
    }//GEN-LAST:event_exitActionPerformed

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new convertionFile().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton exit;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JButton toBinary;
    private javax.swing.JButton toText;
    // End of variables declaration//GEN-END:variables
}
