/*
 * Created by JFormDesigner on Sun Jun 05 16:20:56 CST 2016
 */

package com.jing.jframe;

import com.jing.commons.CacheMapUtils;
import com.jing.commons.GlobalUtils;
import com.jing.commons.GlobalsConstants;
import com.jing.jframe.pojo.*;
import org.apache.commons.lang3.StringUtils;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.File;
import java.time.LocalDate;
import java.util.ArrayList;
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

    private void textFieldPhoneKeyReleased(KeyEvent e) {
        labelHintPhone.setText("");
        String phone = textFieldPhone.getText();
        if (StringUtils.isNotBlank(phone) && phone.length() == 11) {
            User user = CacheMapUtils.getUser(phone);
            if (user != null) {
                textFieldName.setText(user.getName());
                comboBoxProvince.setSelectedItem(user.getProvince());
                textFieldAddress.setText(user.getAddress());
            }
        }
    }

    private void okButtonActionPerformed(ActionEvent e) {
        //保存到文件
        String phone = textFieldPhone.getText();
        if (!GlobalUtils.isMobilePhone(phone)) {
            labelHintPhone.setText("请输入正确的手机号码");
            return;
        }
        String name = textFieldName.getText();
        if (StringUtils.isBlank(name)) {
            labelHintName.setText("请输入姓名");
            return;
        }
        String province = comboBoxProvince.getSelectedItem().toString();
        String city = comboBoxCity.getSelectedItem().toString();
        String county = comboBoxCounty.getSelectedItem().toString();
        String address = textFieldAddress.getText();
        if ("请选择".equals(province) || "请选择".equals(city) || "请选择".equals(county) || StringUtils.isBlank(address)) {
            labelHintAddress.setText("请输入正确地址");
            return;
        }
        String goodsName = textFieldGoodsName.getText();
        if (StringUtils.isBlank(goodsName)) {
            labelHintGoodsName.setText("请输入商品名");
            return;
        }
        String unit = comboBoxUnit.getSelectedItem().toString();
        String num = textFieldNum.getText();
        if (StringUtils.isBlank(num) || !StringUtils.isNumeric(num)) {
            labelHintNum.setText("请输入正确的数量");
            return;
        }
        String price = textFieldPrice.getText();
        if (StringUtils.isBlank(price) || !(StringUtils.isNumeric(price) || GlobalUtils.isFloat(price))) {
            labelHintPrice.setText("请输入正确的数量");
            return;
        }
        //读取已经存在的数据
        List<BuyList> existBuyList = new ArrayList<>();
        LocalDate d = LocalDate.now();
        String filePath = GlobalsConstants.SYSTEM_FOLDER_DIR + d.getYear() + "-" + d.getMonth();
        File dir = new File(filePath);
        if (!dir.exists()) {
            dir.mkdirs();
        }
        File file = new File(filePath + "/" + d.toString());
        if (file.exists()) {

        }

        //保存
        User existUser = CacheMapUtils.getUser(phone);
        if (existUser != null) {
            BuyList buyList = new BuyList();
            buyList.setUser(existUser);
            buyList.setDate(LocalDate.now().toString());
            //
        }
    }

    private void textFieldNameKeyPressed(KeyEvent e) {
        labelHintName.setText("");
    }

    private void textFieldAddressKeyPressed(KeyEvent e) {
        labelHintAddress.setText("");
    }

    private void textFieldGoodsNameKeyPressed(KeyEvent e) {
        labelHintGoodsName.setText("");
    }

    private void textFieldNumKeyPressed(KeyEvent e) {
        labelHintNum.setText("");
    }

    private void textFieldPriceKeyPressed(KeyEvent e) {
        labelHintPrice.setText("");
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        dialogPane = new JPanel();
        contentPanel = new JPanel();
        label1 = new JLabel();
        textFieldPhone = new JTextField();
        labelHintPhone = new JLabel();
        label2 = new JLabel();
        textFieldName = new JTextField();
        labelHintName = new JLabel();
        label3 = new JLabel();
        comboBoxProvince = new JComboBox();
        comboBoxCity = new JComboBox();
        comboBoxCounty = new JComboBox();
        textFieldAddress = new JTextField();
        labelHintAddress = new JLabel();
        label4 = new JLabel();
        textFieldGoodsName = new JTextField();
        labelHintGoodsName = new JLabel();
        label5 = new JLabel();
        comboBoxUnit = new JComboBox();
        label6 = new JLabel();
        textFieldNum = new JTextField();
        labelHintNum = new JLabel();
        label7 = new JLabel();
        textFieldPrice = new JTextField();
        labelHintPrice = new JLabel();
        label8 = new JLabel();
        scrollPane1 = new JScrollPane();
        textAreaMemo = new JTextArea();
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
                ((GridBagLayout) contentPanel.getLayout()).columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
                ((GridBagLayout) contentPanel.getLayout()).rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
                ((GridBagLayout) contentPanel.getLayout()).columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0E-4};
                ((GridBagLayout) contentPanel.getLayout()).rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0E-4};

                //---- label1 ----
                label1.setText("\u624b\u673a\uff1a");
                label1.setHorizontalTextPosition(SwingConstants.RIGHT);
                contentPanel.add(label1, new GridBagConstraints(1, 1, 2, 1, 0.0, 0.0,
                        GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                        new Insets(0, 0, 4, 5), 0, 0));

                //---- textFieldPhone ----
                textFieldPhone.setMinimumSize(new Dimension(50, 25));
                textFieldPhone.setPreferredSize(new Dimension(80, 25));
                textFieldPhone.addKeyListener(new KeyAdapter() {
                    @Override
                    public void keyReleased(KeyEvent e) {
                        textFieldPhoneKeyReleased(e);
                    }
                });
                contentPanel.add(textFieldPhone, new GridBagConstraints(3, 1, 5, 1, 0.0, 0.0,
                        GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                        new Insets(0, 0, 4, 5), 0, 0));
                contentPanel.add(labelHintPhone, new GridBagConstraints(8, 1, 1, 1, 0.0, 0.0,
                        GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                        new Insets(0, 0, 4, 5), 0, 0));

                //---- label2 ----
                label2.setText("\u59d3\u540d\uff1a");
                label2.setHorizontalTextPosition(SwingConstants.RIGHT);
                contentPanel.add(label2, new GridBagConstraints(1, 2, 2, 1, 0.0, 0.0,
                        GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                        new Insets(0, 0, 4, 5), 0, 0));

                //---- textFieldName ----
                textFieldName.setPreferredSize(new Dimension(80, 25));
                textFieldName.addKeyListener(new KeyAdapter() {
                    @Override
                    public void keyPressed(KeyEvent e) {
                        textFieldNameKeyPressed(e);
                    }
                });
                contentPanel.add(textFieldName, new GridBagConstraints(3, 2, 5, 1, 0.0, 0.0,
                        GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                        new Insets(0, 0, 4, 5), 0, 0));
                contentPanel.add(labelHintName, new GridBagConstraints(8, 2, 1, 1, 0.0, 0.0,
                        GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                        new Insets(0, 0, 4, 5), 0, 0));

                //---- label3 ----
                label3.setText("\u6536\u8d27\u5730\u5740\uff1a");
                contentPanel.add(label3, new GridBagConstraints(1, 3, 2, 1, 0.0, 0.0,
                        GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                        new Insets(0, 0, 4, 5), 0, 0));

                //---- comboBoxProvince ----
                comboBoxProvince.addActionListener(e -> comboBoxProvinceActionPerformed(e));
                contentPanel.add(comboBoxProvince, new GridBagConstraints(3, 3, 1, 1, 0.0, 0.0,
                        GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                        new Insets(0, 0, 4, 5), 0, 0));

                //---- comboBoxCity ----
                comboBoxCity.addActionListener(e -> comboBoxCityActionPerformed(e));
                contentPanel.add(comboBoxCity, new GridBagConstraints(4, 3, 1, 1, 0.0, 0.0,
                        GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                        new Insets(0, 0, 4, 5), 0, 0));
                contentPanel.add(comboBoxCounty, new GridBagConstraints(5, 3, 1, 1, 0.0, 0.0,
                        GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                        new Insets(0, 0, 4, 5), 0, 0));

                //---- textFieldAddress ----
                textFieldAddress.setMinimumSize(new Dimension(100, 25));
                textFieldAddress.setPreferredSize(new Dimension(200, 25));
                textFieldAddress.addKeyListener(new KeyAdapter() {
                    @Override
                    public void keyPressed(KeyEvent e) {
                        textFieldAddressKeyPressed(e);
                    }
                });
                contentPanel.add(textFieldAddress, new GridBagConstraints(3, 4, 5, 1, 0.0, 0.0,
                        GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                        new Insets(0, 0, 4, 5), 0, 0));
                contentPanel.add(labelHintAddress, new GridBagConstraints(8, 4, 1, 1, 0.0, 0.0,
                        GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                        new Insets(0, 0, 4, 5), 0, 0));

                //---- label4 ----
                label4.setText("\u5546\u54c1\u540d\uff1a");
                contentPanel.add(label4, new GridBagConstraints(1, 5, 2, 1, 0.0, 0.0,
                        GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                        new Insets(0, 0, 4, 5), 0, 0));

                //---- textFieldGoodsName ----
                textFieldGoodsName.setPreferredSize(new Dimension(80, 25));
                textFieldGoodsName.addKeyListener(new KeyAdapter() {
                    @Override
                    public void keyPressed(KeyEvent e) {
                        textFieldGoodsNameKeyPressed(e);
                    }
                });
                contentPanel.add(textFieldGoodsName, new GridBagConstraints(3, 5, 5, 1, 0.0, 0.0,
                        GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                        new Insets(0, 0, 4, 5), 0, 0));
                contentPanel.add(labelHintGoodsName, new GridBagConstraints(8, 5, 1, 1, 0.0, 0.0,
                        GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                        new Insets(0, 0, 4, 5), 0, 0));

                //---- label5 ----
                label5.setText("\u5546\u54c1\u5355\u4f4d\uff1a");
                contentPanel.add(label5, new GridBagConstraints(1, 6, 2, 1, 0.0, 0.0,
                        GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                        new Insets(0, 0, 4, 5), 0, 0));

                //---- comboBoxUnit ----
                comboBoxUnit.setPreferredSize(new Dimension(80, 27));
                comboBoxUnit.setMinimumSize(new Dimension(80, 27));
                contentPanel.add(comboBoxUnit, new GridBagConstraints(3, 6, 5, 1, 0.0, 0.0,
                        GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                        new Insets(0, 0, 4, 5), 0, 0));

                //---- label6 ----
                label6.setText("\u6570\u91cf\uff1a");
                contentPanel.add(label6, new GridBagConstraints(1, 7, 2, 1, 0.0, 0.0,
                        GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                        new Insets(0, 0, 4, 5), 0, 0));

                //---- textFieldNum ----
                textFieldNum.setPreferredSize(new Dimension(80, 25));
                textFieldNum.addKeyListener(new KeyAdapter() {
                    @Override
                    public void keyPressed(KeyEvent e) {
                        textFieldNumKeyPressed(e);
                    }
                });
                contentPanel.add(textFieldNum, new GridBagConstraints(3, 7, 5, 1, 0.0, 0.0,
                        GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                        new Insets(0, 0, 4, 5), 0, 0));
                contentPanel.add(labelHintNum, new GridBagConstraints(8, 7, 1, 1, 0.0, 0.0,
                        GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                        new Insets(0, 0, 4, 5), 0, 0));

                //---- label7 ----
                label7.setText("\u4ef7\u683c\uff1a");
                contentPanel.add(label7, new GridBagConstraints(1, 8, 2, 1, 0.0, 0.0,
                        GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                        new Insets(0, 0, 4, 5), 0, 0));

                //---- textFieldPrice ----
                textFieldPrice.setPreferredSize(new Dimension(80, 25));
                textFieldPrice.addKeyListener(new KeyAdapter() {
                    @Override
                    public void keyPressed(KeyEvent e) {
                        textFieldPriceKeyPressed(e);
                    }
                });
                contentPanel.add(textFieldPrice, new GridBagConstraints(3, 8, 5, 1, 0.0, 0.0,
                        GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                        new Insets(0, 0, 4, 5), 0, 0));
                contentPanel.add(labelHintPrice, new GridBagConstraints(8, 8, 1, 1, 0.0, 0.0,
                        GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                        new Insets(0, 0, 4, 5), 0, 0));

                //---- label8 ----
                label8.setText("\u5907\u6ce8\uff1a");
                contentPanel.add(label8, new GridBagConstraints(1, 9, 2, 1, 0.0, 0.0,
                        GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                        new Insets(0, 0, 4, 5), 0, 0));

                //======== scrollPane1 ========
                {

                    //---- textAreaMemo ----
                    textAreaMemo.setMinimumSize(new Dimension(0, 40));
                    textAreaMemo.setPreferredSize(new Dimension(0, 40));
                    scrollPane1.setViewportView(textAreaMemo);
                }
                contentPanel.add(scrollPane1, new GridBagConstraints(3, 9, 5, 1, 0.0, 0.0,
                        GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                        new Insets(0, 0, 4, 5), 0, 0));
            }
            dialogPane.add(contentPanel, BorderLayout.WEST);

            //======== buttonBar ========
            {
                buttonBar.setBorder(new EmptyBorder(12, 0, 0, 0));
                buttonBar.setLayout(new GridBagLayout());
                ((GridBagLayout) buttonBar.getLayout()).columnWidths = new int[]{0, 85, 80};
                ((GridBagLayout) buttonBar.getLayout()).columnWeights = new double[]{1.0, 0.0, 0.0};

                //---- okButton ----
                okButton.setText("\u6dfb\u52a0");
                okButton.addActionListener(e -> okButtonActionPerformed(e));
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
    private JLabel labelHintPhone;
    private JLabel label2;
    private JTextField textFieldName;
    private JLabel labelHintName;
    private JLabel label3;
    private JComboBox comboBoxProvince;
    private JComboBox comboBoxCity;
    private JComboBox comboBoxCounty;
    private JTextField textFieldAddress;
    private JLabel labelHintAddress;
    private JLabel label4;
    private JTextField textFieldGoodsName;
    private JLabel labelHintGoodsName;
    private JLabel label5;
    private JComboBox comboBoxUnit;
    private JLabel label6;
    private JTextField textFieldNum;
    private JLabel labelHintNum;
    private JLabel label7;
    private JTextField textFieldPrice;
    private JLabel labelHintPrice;
    private JLabel label8;
    private JScrollPane scrollPane1;
    private JTextArea textAreaMemo;
    private JPanel buttonBar;
    private JButton okButton;
    private JButton cancelButton;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
