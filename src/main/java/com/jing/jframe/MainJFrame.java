/*
 * Created by JFormDesigner on Tue May 31 23:38:02 CST 2016
 */

package com.jing.jframe;

import com.jing.commons.GlobalUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * @author unknown
 */
public class MainJFrame extends JFrame {
    private static Logger logger = LoggerFactory.getLogger(MainJFrame.class);

    public MainJFrame() {
        initComponents();
        //
        //mainPanel.add(new TimePanel());
        //mainPanel.validate();
    }

    public static void main(String[] args) {
        JFrame jFrame = new MainJFrame();
        jFrame.setLocationRelativeTo(null);
        jFrame.setVisible(true);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private void menuAboutMouseClicked(MouseEvent e) {
        logger.debug(GlobalUtils.toLineInfo("点击帮助中心开始"));
        JOptionPane.showMessageDialog(null, "创建于2016年！");
        logger.debug(GlobalUtils.toLineInfo("点击帮助中心结束"));
    }

    private void menuSelledListMouseClicked(MouseEvent e) {
        logger.debug(GlobalUtils.toLineInfo("点击销售列表开始"));
        mainPanel.removeAll();
        mainPanel.add(new TimePanel());
        mainPanel.validate();
        logger.debug(GlobalUtils.toLineInfo("点击销售列表结束"));
    }

    private void menuXlsMouseClicked(MouseEvent e) {
        logger.debug(GlobalUtils.toLineInfo("点击xls开始"));
        mainPanel.removeAll();
        mainPanel.add(new XlsPanel());
        mainPanel.validate();
        logger.debug(GlobalUtils.toLineInfo("点击xls结束"));
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        menuBar1 = new JMenuBar();
        menuBegin = new JMenu();
        menuSelledList = new JMenuItem();
        menuXls = new JMenuItem();
        menuHelp = new JMenu();
        menuAbout = new JMenuItem();
        mainPanel = new JPanel();

        //======== this ========
        setMinimumSize(new Dimension(800, 600));
        Container contentPane = getContentPane();
        contentPane.setLayout(new BorderLayout());

        //======== menuBar1 ========
        {

            //======== menuBegin ========
            {
                menuBegin.setText("\u5f00\u59cb");

                //---- menuSelledList ----
                menuSelledList.setText("\u9500\u552e\u5217\u8868");
                menuSelledList.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        menuSelledListMouseClicked(e);
                    }
                });
                menuBegin.add(menuSelledList);

                //---- menuXls ----
                menuXls.setText("\u62a5\u8868\u4e2d\u5fc3");
                menuXls.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        menuXlsMouseClicked(e);
                    }
                });
                menuBegin.add(menuXls);
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
                        menuAboutMouseClicked(e);
                    }
                });
                menuHelp.add(menuAbout);
            }
            menuBar1.add(menuHelp);
        }
        contentPane.add(menuBar1, BorderLayout.NORTH);

        //======== mainPanel ========
        {
            mainPanel.setLayout(new CardLayout());
        }
        contentPane.add(mainPanel, BorderLayout.CENTER);
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    private JMenuBar menuBar1;
    private JMenu menuBegin;
    private JMenuItem menuSelledList;
    private JMenuItem menuXls;
    private JMenu menuHelp;
    private JMenuItem menuAbout;
    private JPanel mainPanel;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
