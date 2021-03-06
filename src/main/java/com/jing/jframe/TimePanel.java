/*
 * Created by JFormDesigner on Wed Jun 01 22:27:26 CST 2016
 */

package com.jing.jframe;

import com.jing.jframe.pojo.TreeTimeNode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.swing.*;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreeNode;
import java.awt.*;
import java.time.LocalDate;
import java.time.Month;
import java.time.temporal.TemporalAdjusters;

/**
 * @author administrator
 */
public class TimePanel extends JPanel {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    public TimePanel() {
        initComponents();
        LocalDate date2015 = LocalDate.of(2015, Month.JANUARY, 1);
        LocalDate now = LocalDate.now();
        int cha = now.getYear() - date2015.getYear();
        DefaultMutableTreeNode top = new DefaultMutableTreeNode("年月日");
        for (int i = 0; i <= cha; i++) {
            int year = now.getYear() - i;
            DefaultMutableTreeNode yNode = new DefaultMutableTreeNode(new TreeTimeNode(year + "年", TreeTimeNode.TimeTypeEnum.YEAR));
            int month = 12;
            if (year == now.getYear()) {
                month = now.getMonth().getValue();
            }
            for (int j = month; j >= 1; j--) {//每年都有12个月
                DefaultMutableTreeNode mNode = new DefaultMutableTreeNode(new TreeTimeNode(j + "月", TreeTimeNode.TimeTypeEnum.MONTH));
                LocalDate temp = LocalDate.of(year, j, 1);
                LocalDate lastDay = temp.with(TemporalAdjusters.lastDayOfMonth());
                int last = lastDay.getDayOfMonth();
                if (j == now.getMonth().getValue()) {
                    last = now.getDayOfMonth();
                }
                for (int k = last; k >= 1; k--) {
                    mNode.add(new DefaultMutableTreeNode(new TreeTimeNode(k + "号", TreeTimeNode.TimeTypeEnum.DAY)));
                }
                yNode.add(mNode);
            }
            top.add(yNode);
        }
        DefaultTreeModel treeModel = (DefaultTreeModel) timeTree.getModel();
        treeModel.setRoot(top);
        TreeNode root = (TreeNode) treeModel.getRoot();
        TreeNode first = root.getChildAt(0);
        //timeTree.expandPath(new TreePath(first));
        timeTree.expandRow(1);
    }

    private void timeTreeValueChanged(TreeSelectionEvent e) {
        DefaultMutableTreeNode node = (DefaultMutableTreeNode) timeTree.getLastSelectedPathComponent();
        TreeTimeNode t = (TreeTimeNode) node.getUserObject();
        switch (t.getType().getType()) {
            case "YEAR":
                logger.debug("---------选中年----------");
                break;
            case "MONTH":
                logger.debug("---------选中月----------");
                break;
            case "DAY":
                logger.debug("---------选中天----------");
                contentPanel.removeAll();
                contentPanel.add(new DayPanel());
                contentPanel.validate();
                break;
        }
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        timeTreeSplitPane = new JSplitPane();
        timeTreeScrollPane = new JScrollPane();
        timeTree = new JTree();
        contentPanel = new JPanel();

        //======== this ========
        setLayout(new CardLayout());

        //======== timeTreeSplitPane ========
        {
            timeTreeSplitPane.setDividerLocation(150);
            timeTreeSplitPane.setDividerSize(6);

            //======== timeTreeScrollPane ========
            {
                timeTreeScrollPane.setMinimumSize(new Dimension(100, 100));

                //---- timeTree ----
                timeTree.setMinimumSize(new Dimension(150, 150));
                timeTree.setMaximumSize(new Dimension(200, 200));
                timeTree.addTreeSelectionListener(e -> timeTreeValueChanged(e));
                timeTreeScrollPane.setViewportView(timeTree);
            }
            timeTreeSplitPane.setLeftComponent(timeTreeScrollPane);

            //======== contentPanel ========
            {
                contentPanel.setLayout(new CardLayout());
            }
            timeTreeSplitPane.setRightComponent(contentPanel);
        }
        add(timeTreeSplitPane, "card1");
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    private JSplitPane timeTreeSplitPane;
    private JScrollPane timeTreeScrollPane;
    private JTree timeTree;
    private JPanel contentPanel;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
