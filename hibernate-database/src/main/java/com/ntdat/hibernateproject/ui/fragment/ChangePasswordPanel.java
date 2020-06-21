package com.ntdat.hibernateproject.ui.fragment;

import com.ntdat.hibernateproject.ui.customcomponent.FlatButton;
import com.ntdat.hibernateproject.ui.customcomponent.FlatPasswordInput;
import com.ntdat.hibernateproject.ui.customcomponent.FlatTextInput;
import com.ntdat.hibernateproject.ui.customcomponent.RoundedPanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ChangePasswordPanel extends JPanel {
    private RoundedPanel pnlLForm;
    private JLabel txtFormTitle;
    private FlatPasswordInput edtPassword;
    private JLabel txtPassword;
    private JPanel mainPanel;
    private RoundedPanel pnlForm;
    private JLabel pnlFormTitle;
    private FlatButton btnChangePassword;
    private JLabel btnError;
    private JLabel txtForgotPassword;
    private JLabel txtNewPassword;
    private FlatPasswordInput edtNewPassword;
    private JLabel txtConfirmPassword;
    private FlatPasswordInput edtConfirmPassword;

    public ChangePasswordPanel() {
        initComponents();
    }

    private void initComponents() {
        setBackground(new Color(88, 102, 146));
        mainPanel = new javax.swing.JPanel();
        pnlForm = new RoundedPanel(20);
        pnlFormTitle = new JLabel();
        edtPassword = new FlatPasswordInput();
        txtPassword = new JLabel();
        btnChangePassword = new FlatButton();
        btnError = new JLabel();
        txtForgotPassword = new JLabel();
        txtNewPassword = new JLabel();
        edtNewPassword = new FlatPasswordInput();
        edtConfirmPassword = new FlatPasswordInput();
        txtConfirmPassword = new JLabel();
        pnlForm.setBackground(new Color(255, 255, 255));

        pnlFormTitle.setFont(new Font("Roboto", 0, 36)); // NOI18N
        pnlFormTitle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        pnlFormTitle.setText("Đổi mật khẩu");

        edtPassword.setBackground(new Color(240, 240, 240));
        edtPassword.setFont(new Font("Roboto", 0, 18)); // NOI18N
        edtPassword.setToolTipText("");

        txtPassword.setFont(new Font("Roboto", 0, 18)); // NOI18N
        txtPassword.setText("Mật khẩu hiện tại");

        btnChangePassword.setBackground(new Color(0, 102, 153));
        btnChangePassword.setFont(new Font("Roboto", 1, 18)); // NOI18N
        btnChangePassword.setForeground(new Color(255, 255, 255));
        btnChangePassword.setText("Đổi mật khẩu");
        btnChangePassword.setBorder(null);
        btnChangePassword.addMouseListener(new java.awt.event.MouseAdapter() {
        });

        btnError.setFont(new Font("Roboto", 2, 18)); // NOI18N
        btnError.setForeground(new Color(204, 0, 0));
        btnError.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnError.setText("Sai mật khẩu #???");

        txtForgotPassword.setFont(new Font("Roboto", 2, 14)); // NOI18N
        txtForgotPassword.setForeground(new Color(102, 102, 102));
        txtForgotPassword.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtForgotPassword.setText("Quên mật khẩu?");

        txtNewPassword.setFont(new Font("Roboto", 0, 18)); // NOI18N
        txtNewPassword.setText("Mật khẩu mới");

        edtNewPassword.setBackground(new Color(240, 240, 240));
        edtNewPassword.setFont(new Font("Roboto", 0, 18)); // NOI18N
        edtNewPassword.setToolTipText("");

        edtConfirmPassword.setBackground(new Color(240, 240, 240));
        edtConfirmPassword.setFont(new Font("Roboto", 0, 18)); // NOI18N
        edtConfirmPassword.setToolTipText("");

        txtConfirmPassword.setFont(new Font("Roboto", 0, 18)); // NOI18N
        txtConfirmPassword.setText("Xác nhận mật khẩu");

        javax.swing.GroupLayout loginFormLayout = new javax.swing.GroupLayout(pnlForm);
        pnlForm.setLayout(loginFormLayout);
        loginFormLayout.setHorizontalGroup(
                loginFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(loginFormLayout.createSequentialGroup()
                                .addGap(30, 30, 30)
                                .addGroup(loginFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(loginFormLayout.createSequentialGroup()
                                                .addComponent(txtPassword)
                                                .addGap(0, 0, Short.MAX_VALUE))
                                        .addGroup(loginFormLayout.createSequentialGroup()
                                                .addGroup(loginFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(txtConfirmPassword)
                                                        .addComponent(txtNewPassword))
                                                .addContainerGap())
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, loginFormLayout.createSequentialGroup()
                                                .addGroup(loginFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                        .addComponent(edtConfirmPassword, javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(edtNewPassword, javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(btnChangePassword, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(pnlFormTitle, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 561, Short.MAX_VALUE)
                                                        .addComponent(edtPassword)
                                                        .addComponent(btnError, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(txtForgotPassword, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                                .addGap(30, 30, 30))))
        );
        loginFormLayout.setVerticalGroup(
                loginFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(loginFormLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(pnlFormTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtPassword)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(edtPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtNewPassword)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(edtNewPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtConfirmPassword)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(edtConfirmPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnError)
                                .addGap(18, 18, 18)
                                .addComponent(btnChangePassword, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(152, 152, 152)
                                .addComponent(txtForgotPassword)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout mainPanelLayout = new javax.swing.GroupLayout(this);
        this.setLayout(mainPanelLayout);
        mainPanelLayout.setHorizontalGroup(
                mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(mainPanelLayout.createSequentialGroup()
                                .addGap(245, 245, 245)
                                .addComponent(pnlForm, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(245, 245, 245))
        );
        mainPanelLayout.setVerticalGroup(
                mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(mainPanelLayout.createSequentialGroup()
                                .addGap(75, 75, 75)
                                .addComponent(pnlForm, javax.swing.GroupLayout.PREFERRED_SIZE, 557, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(80, 80, 80))
        );
    }
}
