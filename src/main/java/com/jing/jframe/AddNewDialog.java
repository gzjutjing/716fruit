/*
 * Created by JFormDesigner on Sun Jun 05 16:20:56 CST 2016
 */

package com.jing.jframe;

import com.jing.commons.CacheMapUtils;
import com.jing.jframe.pojo.City;
import com.jing.jframe.pojo.County;
import com.jing.jframe.pojo.Province;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.List;

/**
 * @author administrator
 */
public class AddNewDialog extends JDialog {
    public AddNewDialog(Frame owner) {
        super(owner);
        initComponents();
        //商品名称下拉框
        java.util.List<String> list = CacheMapUtils.getGoodsUnitCache();
        list.forEach(e -> {
            comboBoxUnit.addItem(e);
        });
        comboBoxUnit.validate();
        //省
        java.util.List<Province> provinceList = CacheMapUtils.getProvinceCache();
        comboBoxProvince.addItem("请选择");
        provinceList.forEach(e -> {
            comboBoxProvince.addItem(e.getName());
        });
        comboBoxProvince.validate();
    }

    public AddNewDialog(Dialog owner) {
        super(owner);
        initComponents();
    }

    private void comboBoxProvinceActionPerformed(ActionEvent e) {
        comboBoxCity.removeAllItems();
        if (comboBoxProvince.getSelectedItem().equals("请选择")) {
            comboBoxCity.addItem("请选择");
        } else {
            java.util.List<City> cityList = CacheMapUtils.getCitiesByProvince(comboBoxProvince.getSelectedItem().toString());
            if (cityList != null)
                cityList.forEach(c -> {
                    comboBoxCity.addItem(c.getName());
                });
        }
    }

    private void comboBoxCityActionPerformed(ActionEvent e) {
        comboBoxCounty.removeAllItems();
        if (comboBoxCity.getSelectedItem() != null)
            if ("请选择".equals(comboBoxCity.getSelectedItem())) {
                comboBoxCounty.addItem("请选择");
            } else {
                List<County> countyList = CacheMapUtils.getCountiesByCityName(comboBoxCity.getSelectedItem().toString());
                if (countyList != null)
                    countyList.forEach(c -> {
                        comboBoxCounty.addItem(c.getName());
                    });
            }

    }

    private void cancelButtonActionPerformed(ActionEvent e) {
        this.dispose();
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        dialogPane = new JPanel();
        contentPanel = new JPanel();
        label1 = new JLabel();
        textFieldPhone = new JTextField();
        label2 = new JLabel();
        textFieldName = new JTextField();
        label3 = new JLabel();
        comboBoxProvince = new JComboBox();
        comboBoxCity = new JComboBox();
        comboBoxCounty = new JComboBox();
        textField2 = new JTextField();
        label4 = new JLabel();
        textField3 = new JTextField();
        label5 = new JLabel();
        comboBoxUnit = new JComboBox();
        label6 = new JLabel();
        textField5 = new JTextField();
        label7 = new JLabel();
        textField6 = new JTextField();
        buttonBar = new JPanel();
        okButton = new JButton();
        cancelButton = new JButton();

        //======== this ========
        Container contentPane = getContentPane();
        contentPane.setLayout(new BorderLayout());

        //======== dialogPane ========
        {
            dialogPane.setBorder(new EmptyBorder(12, 12, 12, 12));
            dialogPane.setLayout(new BorderLayout());

            //======== contentPanel ========
            {
                contentPanel.setLayout(new GridBagLayout());
                ((GridBagLayout)contentPanel.getLayout()).columnWidths = new int[] {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
                ((GridBagLayout)contentPanel.getLayout()).rowHeights = new int[] {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
                ((GridBagLayout)contentPanel.getLayout()).columnWeights = new double[] {0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0E-4};
                ((GridBagLayout)contentPanel.getLayout()).rowWeights = new double[] {0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0E-4};

                //---- label1 ----
                label1.setText("\u624b\u673a\uff1a");
                label1.setHorizontalTextPosition(SwingConstants.RIGHT);
                contentPanel.add(label1, new GridBagConstraints(1, 1, 2, 1, 0.0, 0.0,
                    GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                    new Insets(0, 0, 5, 5), 0, 0));

                //---- textFieldPhone ----
                textFieldPhone.setMinimumSize(new Dimension(50, 25));
                textFieldPhone.setPreferredSize(new Dimension(80, 25));
                contentPanel.add(textFieldPhone, new GridBagConstraints(3, 1, 4, 1, 0.0, 0.0,
                    GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                    new Insets(0, 0, 5, 5), 0, 0));

                //---- label2 ----
                label2.setText("\u59d3\u540d\uff1a");
                label2.setHorizontalTextPosition(SwingConstants.RIGHT);
                contentPanel.add(label2, new GridBagConstraints(1, 2, 2, 1, 0.0, 0.0,
                    GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                    new Insets(0, 0, 5, 5), 0, 0));

                //---- textFieldName ----
                textFieldName.setPreferredSize(new Dimension(80, 25));
                contentPanel.add(textFieldName, new GridBagConstraints(3, 2, 4, 1, 0.0, 0.0,
                    GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                    new Insets(0, 0, 5, 5), 0, 0));

                //---- label3 ----
                label3.setText("\u6536\u8d27\u5730\u5740\uff1a");
                contentPanel.add(label3, new GridBagConstraints(1, 3, 2, 1, 0.0, 0.0,
                    GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                    new Insets(0, 0, 5, 5), 0, 0));

                //---- comboBoxProvince ----
                comboBoxProvince.addActionListener(e -> comboBoxProvinceActionPerformed(e));
                contentPanel.add(comboBoxProvince, new GridBagConstraints(3, 3, 1, 1, 0.0, 0.0,
                    GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                    new Insets(0, 0, 5, 5), 0, 0));

                //---- comboBoxCity ----
                comboBoxCity.addActionListener(e -> comboBoxCityActionPerformed(e));
                contentPanel.add(comboBoxCity, new GridBagConstraints(4, 3, 1, 1, 0.0, 0.0,
                    GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                    new Insets(0, 0, 5, 5), 0, 0));
                contentPanel.add(comboBoxCounty, new GridBagConstraints(5, 3, 1, 1, 0.0, 0.0,
                    GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                    new Insets(0, 0, 5, 5), 0, 0));

                //---- textField2 ----
                textField2.setMinimumSize(new Dimension(100, 25));
                textField2.setPreferredSize(new Dimension(200, 25));
                contentPanel.add(textField2, new GridBagConstraints(3, 4, 6, 1, 0.0, 0.0,
                    GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                    new Insets(0, 0, 5, 5), 0, 0));

                //---- label4 ----
                label4.setText("\u5546\u54c1\u540d\uff1a");
                contentPanel.add(label4, new GridBagConstraints(1, 5, 2, 1, 0.0, 0.0,
                    GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                    new Insets(0, 0, 5, 5), 0, 0));

                //---- textField3 ----
                textField3.setPreferredSize(new Dimension(80, 25));
                contentPanel.add(textField3, new GridBagConstraints(3, 5, 5, 1, 0.0, 0.0,
                    GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                    new Insets(0, 0, 5, 5), 0, 0));

                //---- label5 ----
                label5.setText("\u5546\u54c1\u5355\u4f4d\uff1a");
                contentPanel.add(label5, new GridBagConstraints(1, 6, 2, 1, 0.0, 0.0,
                    GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                    new Insets(0, 0, 5, 5), 0, 0));

                //---- comboBoxUnit ----
                comboBoxUnit.setPreferredSize(new Dimension(80, 27));
                comboBoxUnit.setMinimumSize(new Dimension(80, 27));
                contentPanel.add(comboBoxUnit, new GridBagConstraints(3, 6, 5, 1, 0.0, 0.0,
                    GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                    new Insets(0, 0, 5, 5), 0, 0));

                //---- label6 ----
                label6.setText("\u6570\u91cf\uff1a");
                contentPanel.add(label6, new GridBagConstraints(1, 7, 2, 1, 0.0, 0.0,
                    GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                    new Insets(0, 0, 5, 5), 0, 0));

                //---- textField5 ----
                textField5.setPreferredSize(new Dimension(80, 25));
                contentPanel.add(textField5, new GridBagConstraints(3, 7, 5, 1, 0.0, 0.0,
                    GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                    new Insets(0, 0, 5, 5), 0, 0));

                //---- label7 ----
                label7.setText("\u4ef7\u683c\uff1a");
                contentPanel.add(label7, new GridBagConstraints(1, 8, 2, 1, 0.0, 0.0,
                    GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                    new Insets(0, 0, 5, 5), 0, 0));

                //---- textField6 ----
                textField6.setPreferredSize(new Dimension(80, 25));
                contentPanel.add(textField6, new GridBagConstraints(3, 8, 5, 1, 0.0, 0.0,
                    GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                    new Insets(0, 0, 5, 5), 0, 0));
            }
            dialogPane.add(contentPanel, BorderLayout.WEST);

            //======== buttonBar ========
            {
                buttonBar.setBorder(new EmptyBorder(12, 0, 0, 0));
                buttonBar.setLayout(new GridBagLayout());
                ((GridBagLayout)buttonBar.getLayout()).columnWidths = new int[] {0, 85, 80};
                ((GridBagLayout)buttonBar.getLayout()).columnWeights = new double[] {1.0, 0.0, 0.0};

                //---- okButton ----
                okButton.setText("\u6dfb\u52a0");
                buttonBar.add(okButton, new GridBagConstraints(1, 0, 1, 1, 0.0, 0.0,
                    GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                    new Insets(0, 0, 0, 5), 0, 0));

                //---- cancelButton ----
                cancelButton.setText("\u53d6\u6d88");
                cancelButton.addActionListener(e -> cancelButtonActionPerformed(e));
                buttonBar.add(cancelButton, new GridBagConstraints(2, 0, 1, 1, 0.0, 0.0,
                    GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                    new Insets(0, 0, 0, 0), 0, 0));
            }
            dialogPane.add(buttonBar, BorderLayout.SOUTH);
        }
        contentPane.add(dialogPane, BorderLayout.CENTER);
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    private JPanel dialogPane;
    private JPanel contentPanel;
    private JLabel label1;
    private JTextField textFieldPhone;
    private JLabel label2;
    private JTextField textFieldName;
    private JLabel label3;
    private JComboBox comboBoxProvince;
    private JComboBox comboBoxCity;
    private JComboBox comboBoxCounty;
    private JTextField textField2;
    private JLabel label4;
    private JTextField textField3;
    private JLabel label5;
    private JComboBox comboBoxUnit;
    private JLabel label6;
    private JTextField textField5;
    private JLabel label7;
    private JTextField textField6;
    private JPanel buttonBar;
    private JButton okButton;
    private JButton cancelButton;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
