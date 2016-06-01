/*
 * Created by JFormDesigner on Wed Jun 01 22:27:26 CST 2016
 */

package com.jing.jframe;

import java.awt.*;
import javax.swing.*;

/**
 * @author administrator
 */
public class TimePanel extends JPanel {
    public TimePanel() {
        initComponents();
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        timeTreeSplitPane = new JSplitPane();
        timeTreeScrollPane = new JScrollPane();
        timeTree = new JTree();

        //======== this ========
        setLayout(new CardLayout());

        //======== timeTreeSplitPane ========
        {
            timeTreeSplitPane.setDividerLocation(120);
            timeTreeSplitPane.setDividerSize(6);

            //======== timeTreeScrollPane ========
            {
                timeTreeScrollPane.setMinimumSize(new Dimension(100, 100));

                //---- timeTree ----
                timeTree.setMinimumSize(new Dimension(150, 150));
                timeTree.setMaximumSize(new Dimension(200, 200));
                timeTreeScrollPane.setViewportView(timeTree);
            }
            timeTreeSplitPane.setLeftComponent(timeTreeScrollPane);
        }
        add(timeTreeSplitPane, "card1");
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    private JSplitPane timeTreeSplitPane;
    private JScrollPane timeTreeScrollPane;
    private JTree timeTree;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
