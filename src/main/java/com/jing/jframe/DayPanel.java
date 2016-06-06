/*
 * Created by JFormDesigner on Fri Jun 03 13:49:38 CST 2016
 */

package com.jing.jframe;

import java.awt.event.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

/**
 * @author administrator
 */
public class DayPanel extends JPanel {
    public DayPanel() {
        initComponents();
        Object[][] cellData = {{"row1-col1", "row1-col2"}, {"row2-col1", "row2-col2"}};
        String[] columnNames = {"", "姓名", "电话", "地址", "水果", "支付宝", "微信"};

        DefaultTableModel tableModel = (DefaultTableModel) table1.getModel();
        tableModel.setColumnIdentifiers(columnNames);
        tableModel.addColumn("col1", columnNames);
        table1.validate();
    }

    private void buttonAddNewActionPerformed(ActionEvent e) {
        JDialog addNewDialog=new AddNewDialog(new MainJFrame());
        addNewDialog.setModal(true);
        addNewDialog.pack();
        java.awt.Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
        addNewDialog.setBounds((screenSize.width-400)/2, (screenSize.height-400)/2, 400, 400);
        addNewDialog.setResizable(false);
        addNewDialog.setVisible(true);
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        panel1 = new JPanel();
        buttonAddNew = new JButton();
        scrollPane1 = new JScrollPane();
        table1 = new JTable();

        //======== this ========
        setLayout(new CardLayout());

        //======== panel1 ========
        {
            panel1.setMinimumSize(new Dimension(54, 47));
            panel1.setPreferredSize(new Dimension(153, 453));
            panel1.setLayout(new BoxLayout(panel1, BoxLayout.Y_AXIS));

            //---- buttonAddNew ----
            buttonAddNew.setText("\u65b0\u589e");
            buttonAddNew.addActionListener(e -> buttonAddNewActionPerformed(e));
            panel1.add(buttonAddNew);

            //======== scrollPane1 ========
            {
                scrollPane1.setViewportView(table1);
            }
            panel1.add(scrollPane1);
        }
        add(panel1, "card2");
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    private JPanel panel1;
    private JButton buttonAddNew;
    private JScrollPane scrollPane1;
    private JTable table1;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
