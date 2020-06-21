package com.ntdat.hibernateproject.ui.fragment;

import com.ntdat.hibernateproject.ui.customcomponent.FlatButton;
import com.ntdat.hibernateproject.ui.customcomponent.FlatTextInput;
import com.ntdat.hibernateproject.ui.customcomponent.HeaderRenderer;
import com.ntdat.hibernateproject.ui.customcomponent.MyScrollbarUI;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import java.awt.*;

public class ScoresPanel extends JPanel {
    private JScrollPane scrpnlTable;
    private JTable tblScores;
    private FlatTextInput edtSearch;
    private FlatButton btnSearch;
    private FlatButton btnImportCSV;
    private FlatButton btnConfirm;
    private FlatButton btnCancel;

    public ScoresPanel() {
        initComponents();
    }

    private void initComponents() {
        setBackground(new Color(88, 102, 146));
        scrpnlTable = new javax.swing.JScrollPane();
        tblScores = new javax.swing.JTable();
        edtSearch = new FlatTextInput();
        btnSearch = new FlatButton(new Color(58,66,129), new Color(30,34,82), new Color(36,55,114));
        btnImportCSV = new FlatButton(new Color(58,66,129), new Color(30,34,82), new Color(36,55,114));
        btnConfirm = new FlatButton(new Color(58,66,129), new Color(30,34,82), new Color(36,55,114));
        btnCancel = new FlatButton(new Color(58,66,129), new Color(30,34,82), new Color(71,83,114));
        scrpnlTable.getVerticalScrollBar().setUI(new MyScrollbarUI());
        tblScores.getTableHeader().setDefaultRenderer(new HeaderRenderer());
        tblScores.setFont(new Font("Roboto", 0, 18)); // NOI18N
        tblScores.setModel(new javax.swing.table.DefaultTableModel(
                new Object [][] {
                        {"1", "1712025", "Nguyễn Tuấn Đạt", "9.0", "9.0", "2.0", "9.5"},
                        {"2", "1712000", "Nguyễn Văn B", "8.5", "8.5", "0.0", "8.5"},
                        {null, null, null, null, null, null, null},
                        {null, null, null, null, null, null, null},
                        {null, null, null, null, null, null, null},
                        {null, null, null, null, null, null, null},
                        {null, null, null, null, null, null, null},
                        {null, null, null, null, null, null, null},
                        {null, null, null, null, null, null, null},
                        {null, null, null, null, null, null, null},
                        {null, null, null, null, null, null, null},
                        {null, null, null, null, null, null, null},
                        {null, null, null, null, null, null, null},
                        {null, null, null, null, null, null, null},
                        {null, null, null, null, null, null, null},
                        {null, null, null, null, null, null, null},
                        {null, null, null, null, null, null, null},
                        {null, null, null, null, null, null, null},
                        {null, null, null, null, null, null, null},
                        {null, null, null, null, null, null, null},
                        {null, null, null, null, null, null, null},
                        {null, null, null, null, null, null, null},
                        {null, null, null, null, null, null, null},
                        {null, null, null, null, null, null, null},
                        {null, null, null, null, null, null, null},
                        {null, null, null, null, null, null, null},
                        {null, null, null, null, null, null, null},
                        {null, null, null, null, null, null, null},
                        {null, null, null, null, null, null, null},
                        {null, null, null, null, null, null, null},
                        {null, null, null, null, null, null, null},
                        {null, null, null, null, null, null, null},
                        {null, null, null, null, null, null, null},
                        {null, null, null, null, null, null, null},
                        {null, null, null, null, null, null, null},
                        {null, null, null, null, null, null, null},
                        {null, null, null, null, null, null, null},
                        {null, null, null, null, null, null, null},
                        {null, null, null, null, null, null, null},
                        {null, null, null, null, null, null, null},
                        {null, null, null, null, null, null, null},
                        {null, null, null, null, null, null, null},
                        {null, null, null, null, null, null, null},
                        {null, null, null, null, null, null, null},
                        {null, null, null, null, null, null, null},
                        {null, null, null, null, null, null, null},
                        {null, null, null, null, null, null, null},
                        {null, null, null, null, null, null, null},
                        {null, null, null, null, null, null, null},
                        {null, null, null, null, null, null, null}
                },
                new String [] {
                        "STT", "MSSV", "Họ và tên", "Điểm GK", "Điểm CK", "Điểm khác", "Điểm tổng"
                }
        ));
        //tblScores.getColumnModel().getColumn(0).setPreferredWidth(120);
        //tblScores.getColumnModel().getColumn(1).setPreferredWidth(210);
        //tblScores.getColumnModel().getColumn(2).setPreferredWidth(470);
        //tblScores.getColumnModel().getColumn(3).setPreferredWidth(260);

        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment( JLabel.CENTER );
        //tblScores.setDefaultRenderer(String.class, centerRenderer);
        tblScores.getColumnModel().getColumn(0).setCellRenderer(centerRenderer);
        tblScores.getColumnModel().getColumn(1).setCellRenderer(centerRenderer);
        tblScores.getColumnModel().getColumn(2).setCellRenderer(centerRenderer);
        tblScores.getColumnModel().getColumn(3).setCellRenderer(centerRenderer);
        tblScores.getColumnModel().getColumn(4).setCellRenderer(centerRenderer);
        tblScores.getColumnModel().getColumn(5).setCellRenderer(centerRenderer);
        tblScores.getColumnModel().getColumn(6).setCellRenderer(centerRenderer);
        tblScores.setDragEnabled(true);
        tblScores.setFocusable(false);
        tblScores.setRowHeight(40);
        tblScores.setSelectionBackground(new Color(129, 150, 204));
        tblScores.setSelectionForeground(new Color(0, 0, 0));
        tblScores.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        scrpnlTable.setViewportView(tblScores);
        if (tblScores.getColumnModel().getColumnCount() > 0) {
            tblScores.getColumnModel().getColumn(0).setPreferredWidth(85);
            tblScores.getColumnModel().getColumn(1).setPreferredWidth(170);
            tblScores.getColumnModel().getColumn(2).setPreferredWidth(290);
            tblScores.getColumnModel().getColumn(3).setPreferredWidth(128);
            tblScores.getColumnModel().getColumn(4).setPreferredWidth(128);
            tblScores.getColumnModel().getColumn(5).setPreferredWidth(128);
            tblScores.getColumnModel().getColumn(6).setPreferredWidth(128);
        }

        edtSearch.setFont(new Font("Roboto", 0, 18)); // NOI18N
        edtSearch.setToolTipText("");

        btnSearch.setFont(new Font("Roboto", 0, 18)); // NOI18N
        btnSearch.setText("Tìm kiếm");

        btnImportCSV.setFont(new Font("Roboto", 0, 18)); // NOI18N
        btnImportCSV.setText("Nhập từ CSV");

        btnConfirm.setFont(new Font("Roboto", 0, 18)); // NOI18N
        btnConfirm.setText("Xác nhận");

        btnCancel.setFont(new Font("Roboto", 0, 18)); // NOI18N
        btnCancel.setText("Hủy bỏ");

        javax.swing.GroupLayout mainPanelLayout = new javax.swing.GroupLayout(this);
        this.setLayout(mainPanelLayout);
        mainPanelLayout.setHorizontalGroup(
                mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(mainPanelLayout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(scrpnlTable)
                                        .addGroup(mainPanelLayout.createSequentialGroup()
                                                .addComponent(btnImportCSV)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(edtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 272, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(btnSearch)
                                                .addGap(9, 9, 9))
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, mainPanelLayout.createSequentialGroup()
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 868, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(btnCancel)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(btnConfirm)
                                                .addGap(10, 10, 10)))
                                .addContainerGap())
        );
        mainPanelLayout.setVerticalGroup(
                mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(mainPanelLayout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(edtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(btnSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(btnImportCSV, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(scrpnlTable, javax.swing.GroupLayout.DEFAULT_SIZE, 609, Short.MAX_VALUE)
                                .addGap(9, 9, 9)
                                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(btnConfirm)
                                        .addComponent(btnCancel))
                                .addContainerGap())
        );
    }
}
