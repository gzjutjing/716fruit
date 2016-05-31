/*
 * Created by JFormDesigner on Tue May 31 23:38:02 CST 2016
 */

package com.jing.jframe;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * @author unknown
 */
public class MainJFrame extends JFrame {
    public MainJFrame() {
        initComponents();
    }

    public static void main(String[] args) {
        JFrame jFrame = new MainJFrame();
        jFrame.setLocationRelativeTo(null);
        jFrame.setVisible(true);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private void menuItem1MouseClicked(MouseEvent e) {
        JOptionPane.showMessageDialog(null, "创建于2016年！");
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        menuBar1 = new JMenuBar();
        menuBegin = new JMenu();
        menuHelp = new JMenu();
        menuAbout = new JMenuItem();

        //======== this ========
        setMinimumSize(new Dimension(320, 320));
        Container contentPane = getContentPane();
        contentPane.setLayout(new BorderLayout());

        //======== menuBar1 ========
        {

            //======== menuBegin ========
            {
                menuBegin.setText("\u5f00\u59cb");
            }
            menuBar1.add(menuBegin);

            //======== menuHelp ========
            {
                menuHelp.setText("\u5e2e\u52a9");

                //---- menuAbout ----
                menuAbout.setText("\u5173\u4e8e\u6211\u4eec");
                menuAbout.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        menuItem1MouseClicked(e);
                    }
                });
                menuHelp.add(menuAbout);
            }
            menuBar1.add(menuHelp);
        }
        contentPane.add(menuBar1, BorderLayout.NORTH);
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    private JMenuBar menuBar1;
    private JMenu menuBegin;
    private JMenu menuHelp;
    private JMenuItem menuAbout;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
