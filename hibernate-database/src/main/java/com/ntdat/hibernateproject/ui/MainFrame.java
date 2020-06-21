/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ntdat.hibernateproject.ui;

import com.ntdat.hibernateproject.ui.customcomponent.*;
import com.ntdat.hibernateproject.ui.fragment.*;

import javax.swing.*;
import java.awt.*;

public class MainFrame extends RoundedJFrame {
    private String username;
    private String password;

    public MainFrame() {}

    public void initComponents(JPanel mainPanel) {
        pnlMain = mainPanel;

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new Dimension(1280, 768));
        background = new javax.swing.JPanel();
        background.setBackground(new Color(88, 102, 146));
        titleBar = new javax.swing.JPanel();
        btnClose = new RoundedPanel(10);
        txtClose = new JLabel();
        btnMinimize = new RoundedPanel(10);
        txtMinimize = new JLabel();
        txtProgramName = new JLabel();
        txtProgramName.setFont(new Font("Roboto", 0, 18)); // NOI18N
        txtProgramName.setForeground(new Color(255, 255, 255));
        txtProgramName.setText("Hibernate Project v1.0");

        sidePanel = new javax.swing.JPanel();

        txtPermission = new JLabel();
        txtPermission.setFont(new Font("Roboto", 0, 36)); // NOI18N
        txtPermission.setForeground(new Color(255, 255, 255));
        txtPermission.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtPermission.setText("GIÁO VỤ");

        spr1 = new javax.swing.JSeparator();
        btnClassroom = new FlatButton(new Color(36,55,114), new Color(36,55,114), new Color(88,102,146));
        btnSchedule = new FlatButton(new Color(36,55,114), new Color(36,55,114), new Color(88,102,146));
        btnScores = new FlatButton(new Color(36,55,114), new Color(36,55,114), new Color(88,102,146));
        btnReExamination = new FlatButton(new Color(36,55,114), new Color(36,55,114), new Color(88,102,146));
        btnChangePassword = new FlatButton(new Color(36,55,114), new Color(36,55,114), new Color(88,102,146));
        btnLogOut = new FlatButton(new Color(36,55,114), new Color(36,55,114), new Color(88,102,146));

        // SWITCH TABS
        btnClassroom.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                getContentPane().removeAll();
                initComponents(new ClassroomPanel());
            }
        });
        btnSchedule.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                getContentPane().removeAll();
                initComponents(new SchedulePanel());
            }
        });
        btnScores.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                getContentPane().removeAll();
                initComponents(new ScoresPanel());
            }
        });
        btnReExamination.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                getContentPane().removeAll();
                initComponents(new ReExaminationPanel());
            }
        });
        btnChangePassword.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                getContentPane().removeAll();
                initComponents(new ChangePasswordPanel());
            }
        });
        btnLogOut.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Login login = new Login();
                login.setVisible(true);
                dispose();
            }
        });

        titleBar.setBackground(new Color(58, 66, 129));
        titleBar.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                moveFrame(evt);
            }
        });
        titleBar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                getPosition(evt);
            }
        });

        btnClose.setBackground(new Color(77, 89, 159));
        btnClose.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                close(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                mouseEnterHandle(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                mouseExitHandle(evt);
            }
        });

        txtClose.setFont(new Font("Roboto", 1, 28)); // NOI18N
        txtClose.setForeground(new Color(255, 255, 255));
        txtClose.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtClose.setText("×");
        txtClose.setAlignmentY(0.0F);

        javax.swing.GroupLayout btnCloseLayout = new javax.swing.GroupLayout(btnClose);
        btnClose.setLayout(btnCloseLayout);
        btnCloseLayout.setHorizontalGroup(
            btnCloseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btnCloseLayout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(txtClose, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
        );
        btnCloseLayout.setVerticalGroup(
            btnCloseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, btnCloseLayout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(txtClose, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
        );

        btnMinimize.setBackground(new Color(77, 89, 159));
        btnMinimize.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                minimize(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                mouseEnterHandle(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                mouseExitHandle(evt);
            }
        });

        txtMinimize.setFont(new Font("Roboto", 1, 28)); // NOI18N
        txtMinimize.setForeground(new Color(255, 255, 255));
        txtMinimize.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtMinimize.setText("-");
        txtMinimize.setAlignmentY(0.0F);

        javax.swing.GroupLayout btnMinimizeLayout = new javax.swing.GroupLayout(btnMinimize);
        btnMinimize.setLayout(btnMinimizeLayout);
        btnMinimizeLayout.setHorizontalGroup(
            btnMinimizeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btnMinimizeLayout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(txtMinimize, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
        );
        btnMinimizeLayout.setVerticalGroup(
            btnMinimizeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, btnMinimizeLayout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(txtMinimize, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
        );

        ///////////////////////////////////

        javax.swing.GroupLayout titleBarLayout = new javax.swing.GroupLayout(titleBar);
        titleBar.setLayout(titleBarLayout);
        titleBarLayout.setHorizontalGroup(
            titleBarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, titleBarLayout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(txtProgramName)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnMinimize, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnClose, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(16, 16, 16))
        );
        titleBarLayout.setVerticalGroup(
            titleBarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(titleBarLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(titleBarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnMinimize, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnClose, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtProgramName, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        sidePanel.setBackground(new Color(30, 34, 82));



        spr1.setBackground(new Color(88, 102, 146));
        spr1.setForeground(new Color(88, 102, 146));

        btnClassroom.setFont(new Font("Roboto", 0, 18)); // NOI18N
        btnClassroom.setText("Danh sách lớp");

        btnSchedule.setFont(new Font("Roboto", 0, 18)); // NOI18N
        btnSchedule.setText("Thời khóa biểu");

        btnScores.setFont(new Font("Roboto", 0, 18)); // NOI18N
        btnScores.setText("Tra cứu điểm");

        btnReExamination.setFont(new Font("Roboto", 0, 18)); // NOI18N
        btnReExamination.setText("QL phúc khảo");

        btnChangePassword.setFont(new Font("Roboto", 0, 18)); // NOI18N
        btnChangePassword.setText("Đổi mật khẩu");

        btnLogOut.setFont(new Font("Roboto", 0, 18)); // NOI18N
        btnLogOut.setText("Đăng xuất");



        javax.swing.GroupLayout sidePanelLayout = new javax.swing.GroupLayout(sidePanel);
        sidePanel.setLayout(sidePanelLayout);
        sidePanelLayout.setHorizontalGroup(
            sidePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(txtPermission, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, sidePanelLayout.createSequentialGroup()
                .addGap(2, 2, 2)
                .addGroup(sidePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnClassroom, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(spr1)
                    .addComponent(btnSchedule, javax.swing.GroupLayout.DEFAULT_SIZE, 166, Short.MAX_VALUE)
                    .addComponent(btnScores, javax.swing.GroupLayout.DEFAULT_SIZE, 166, Short.MAX_VALUE)
                    .addComponent(btnReExamination, javax.swing.GroupLayout.DEFAULT_SIZE, 166, Short.MAX_VALUE)
                    .addComponent(btnChangePassword, javax.swing.GroupLayout.DEFAULT_SIZE, 166, Short.MAX_VALUE)
                    .addComponent(btnLogOut, javax.swing.GroupLayout.DEFAULT_SIZE, 166, Short.MAX_VALUE))
                .addGap(2, 2, 2))
        );
        sidePanelLayout.setVerticalGroup(
            sidePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(sidePanelLayout.createSequentialGroup()
                .addGap(44, 44, 44)
                .addComponent(txtPermission)
                .addGap(37, 37, 37)
                .addComponent(spr1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(2, 2, 2)
                .addComponent(btnClassroom, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(2, 2, 2)
                .addComponent(btnSchedule, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(2, 2, 2)
                .addComponent(btnScores, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(2, 2, 2)
                .addComponent(btnReExamination, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(2, 2, 2)
                .addComponent(btnChangePassword, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(2, 2, 2)
                .addComponent(btnLogOut, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(262, Short.MAX_VALUE))
        );


        javax.swing.GroupLayout backgroundLayout = new javax.swing.GroupLayout(background);
        background.setLayout(backgroundLayout);
        backgroundLayout.setHorizontalGroup(
            backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(titleBar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(backgroundLayout.createSequentialGroup()
                .addComponent(sidePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(pnlMain, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );



        backgroundLayout.setVerticalGroup(
            backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(backgroundLayout.createSequentialGroup()
                .addComponent(titleBar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(sidePanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(backgroundLayout.createSequentialGroup()
                        .addGap(0, 0, 0)
                        .addComponent(pnlMain, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(0, 0, 0))))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(background, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(background, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        setSize(new Dimension(1280, 768));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void close(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_close
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_close

    private void moveFrame(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_moveFrame
        // TODO add your handling code here:
        setLocation(getLocation().x + evt.getX() - this.pX, getLocation().y + evt.getY() - this.pY);
    }//GEN-LAST:event_moveFrame

    private void getPosition(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_getPosition
        // TODO add your handling code here:
        this.pX = evt.getX();
        this.pY = evt.getY();
    }//GEN-LAST:event_getPosition

    private void mouseEnterHandle(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_mouseEnterHandle
        // TODO add your handling code here:
        if (evt.getSource() == this.btnClose) {
            this.txtClose.setForeground(Color.red);
        };
        if (evt.getSource() == this.btnMinimize) {
            this.txtMinimize.setForeground(Color.red);
        };
    }//GEN-LAST:event_mouseEnterHandle

    private void mouseExitHandle(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_mouseExitHandle
        // TODO add your handling code here:
        if (evt.getSource() == this.btnClose) {
            this.txtClose.setForeground(Color.white);
        };
        if (evt.getSource() == this.btnMinimize) {
            this.txtMinimize.setForeground(Color.white);
        };
    }//GEN-LAST:event_mouseExitHandle

    private void minimize(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_minimize
        // TODO add your handling code here:
        this.setExtendedState(JFrame.ICONIFIED);
    }//GEN-LAST:event_minimize

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel background;
    private javax.swing.JButton btnAddStudent;
    private javax.swing.JButton btnCancel;
    private javax.swing.JButton btnClassroom;
    private javax.swing.JButton btnSchedule;
    private javax.swing.JButton btnScores;
    private javax.swing.JButton btnReExamination;
    private javax.swing.JButton btnChangePassword;
    private javax.swing.JButton btnLogOut;
    private javax.swing.JPanel btnClose;
    private javax.swing.JButton btnConfirm;
    private javax.swing.JButton btnImportCSV;
    private javax.swing.JPanel btnMinimize;
    private javax.swing.JButton btnSearch;
    private javax.swing.JTextField edtSearch;
    private JLabel txtPermission;
    private JLabel txtProgramName;
    private javax.swing.JScrollPane scrpnlTable;
    private javax.swing.JSeparator spr1;
    private javax.swing.JTable tblClassroom;
    private javax.swing.JPanel pnlMain;
    private javax.swing.JPanel sidePanel;
    private javax.swing.JPanel titleBar;
    private JLabel txtClose;
    private JLabel txtMinimize;
    // End of variables declaration//GEN-END:variables
    private int pX;
    private int pY;
}
