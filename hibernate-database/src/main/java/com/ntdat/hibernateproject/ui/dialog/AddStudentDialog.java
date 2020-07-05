/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ntdat.hibernateproject.ui.dialog;

import com.ntdat.hibernateproject.dao.StudentDAO;
import com.ntdat.hibernateproject.dao.SubjectDAO;
import com.ntdat.hibernateproject.dao.SubjectDetailDAO;
import com.ntdat.hibernateproject.entities.ChiTietMonHocEntity;
import com.ntdat.hibernateproject.entities.SinhVienEntity;
import com.ntdat.hibernateproject.ui.customcomponent.FlatButton;
import com.ntdat.hibernateproject.ui.customcomponent.FlatTextInput;
import com.ntdat.hibernateproject.ui.customcomponent.RoundedPanel;

import javax.swing.*;
import java.awt.*;

public class AddStudentDialog extends RoundedPanel {
    private static final Color MOUSE_HOVER_BUTTON = new Color(51, 74, 137);
    private static final Color MOUSE_PRESS_BUTTON = new Color(36,55,114);
    private static final Color DEFAULT_BUTTON = new Color(88,102,146);

    public AddStudentDialog(int radius, String classID) {
        super(radius);
        this.classIDMain = classID;
        initComponents();
    }

    private String classIDMain;
    private String sex = "Nam";
    private boolean addToDefaultClass = true;

    private void initComponents() {
        txtStudentId = new javax.swing.JLabel();
        txtStudentId.setText("MSSV");
        edtStudentId = new FlatTextInput();

        txtFullName = new javax.swing.JLabel();
        txtFullName.setText("Họ và tên");
        edtFullName = new FlatTextInput();

        txtSex = new javax.swing.JLabel();
        txtSex.setText("Giới tính");
        btnMale = new FlatButton(MOUSE_HOVER_BUTTON, MOUSE_PRESS_BUTTON, MOUSE_PRESS_BUTTON);

        btnMale.setText("Nam");
        btnFemale = new FlatButton(MOUSE_HOVER_BUTTON, MOUSE_PRESS_BUTTON, DEFAULT_BUTTON);
        btnFemale.setText("Nữ");

        txtId = new javax.swing.JLabel();
        txtId.setText("CMND");
        edtId = new FlatTextInput();

        btnAdd = new FlatButton();
        btnAdd.setText("Thêm");

        btnCancel = new FlatButton();
        btnCancel.setText("Hủy");

        if (classIDMain.contains("-")) {
            edtFullName.setEditable(false);
            edtId.setEditable(false);
            addToDefaultClass = false;
        }

        edtStudentId.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                SinhVienEntity sv = StudentDAO.getStudent(edtStudentId.getText());
                if (sv != null) {
                    edtFullName.setText(sv.getHoVaTen());
                    edtId.setText(sv.getCmnd());
                    if (sv.getGioiTinh().equals("Nam")) {
                        btnMale.setColors(MOUSE_HOVER_BUTTON, MOUSE_PRESS_BUTTON, MOUSE_PRESS_BUTTON);
                        btnMale.repaint();
                        btnFemale.setColors(MOUSE_HOVER_BUTTON, MOUSE_PRESS_BUTTON, DEFAULT_BUTTON);
                        btnFemale.repaint();
                    } else {
                        btnMale.setColors(MOUSE_HOVER_BUTTON, MOUSE_PRESS_BUTTON, DEFAULT_BUTTON);
                        btnMale.repaint();
                        btnFemale.setColors(MOUSE_HOVER_BUTTON, MOUSE_PRESS_BUTTON, MOUSE_PRESS_BUTTON);
                        btnFemale.repaint();
                    }
                }
            }
        });

        btnMale.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                if (addToDefaultClass) {
                    sex = "Nam";
                    btnMale.setColors(MOUSE_HOVER_BUTTON, MOUSE_PRESS_BUTTON, MOUSE_PRESS_BUTTON);
                    btnMale.repaint();
                    btnFemale.setColors(MOUSE_HOVER_BUTTON, MOUSE_PRESS_BUTTON, DEFAULT_BUTTON);
                    btnFemale.repaint();
                }
            }
        });
        btnFemale.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                if (addToDefaultClass) {
                    sex = "Nu";
                    btnMale.setColors(MOUSE_HOVER_BUTTON, MOUSE_PRESS_BUTTON, DEFAULT_BUTTON);
                    btnMale.repaint();
                    btnFemale.setColors(MOUSE_HOVER_BUTTON, MOUSE_PRESS_BUTTON, MOUSE_PRESS_BUTTON);
                    btnFemale.repaint();
                }
            }
        });

        btnAdd.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                if (classIDMain.contains("-")) {
                    String classID = "", subjectID = "";
                    String[] token = classIDMain.split("-");
                    classID = token[0];
                    subjectID = token[1];

                    if (SubjectDetailDAO.addSubjectDetail(new ChiTietMonHocEntity(classID, subjectID, edtStudentId.getText(), null, null, null, null))) {
                        JOptionPane.showMessageDialog(getParent(), "Thêm thành công sinh viên " + edtFullName.getText(), "Thêm sinh viên thành công", JOptionPane.INFORMATION_MESSAGE);
                        JOptionPane.getRootFrame().dispose();
                    } else {
                        JOptionPane.showMessageDialog(getParent(), "Thông tin sinh viên không chính xác. Vui lòng nhập lại", "Thêm sinh viên thất bại", JOptionPane.INFORMATION_MESSAGE);
                    }
                } else {
                    if (StudentDAO.addStudent(new SinhVienEntity(edtStudentId.getText(), edtFullName.getText(), sex, edtId.getText(), classIDMain))) {
                        JOptionPane.showMessageDialog(getParent(), "Thêm thành công sinh viên " + edtFullName.getText(), "Thêm sinh viên thành công", JOptionPane.INFORMATION_MESSAGE);
                        JOptionPane.getRootFrame().dispose();
                    } else {
                        JOptionPane.showMessageDialog(getParent(), "Thông tin sinh viên không chính xác. Vui lòng nhập lại", "Thêm sinh viên thất bại", JOptionPane.INFORMATION_MESSAGE);
                    }
                }
            }
        });

        btnCancel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                JOptionPane.getRootFrame().dispose();
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(edtStudentId)
                                        .addComponent(edtFullName)
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                .addGap(0, 246, Short.MAX_VALUE)
                                                .addComponent(btnCancel)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(btnAdd))
                                        .addComponent(edtId)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(txtStudentId)
                                                        .addComponent(txtFullName)
                                                        .addComponent(txtSex)
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addComponent(btnMale)
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(btnFemale))
                                                        .addComponent(txtId))
                                                .addGap(0, 0, Short.MAX_VALUE)))
                                .addContainerGap())
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(25, 25, 25)
                                .addComponent(txtStudentId)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(edtStudentId, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtFullName)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(edtFullName, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtSex)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(btnMale)
                                        .addComponent(btnFemale))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtId)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(edtId, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 51, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(btnAdd)
                                        .addComponent(btnCancel))
                                .addContainerGap())
        );
    }                      

    private void edtStudentIdActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }

    private void edtFullNameActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }

    private void edtIdActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }
    
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnCancel;
    private javax.swing.JComboBox<String> cbbSex;
    private javax.swing.JLabel txtStudentId;
    private javax.swing.JLabel txtFullName;
    private javax.swing.JLabel txtSex;
    private javax.swing.JLabel txtId;
    private javax.swing.JTextField edtStudentId;
    private javax.swing.JTextField edtFullName;
    private javax.swing.JTextField edtId;
    private FlatButton btnMale;
    private FlatButton btnFemale;
}
