package com.ntdat.hibernateproject.ui.fragment;

import com.ntdat.hibernateproject.dao.StudentDAO;
import com.ntdat.hibernateproject.dao.SubjectDAO;
import com.ntdat.hibernateproject.dao.SubjectDetailDAO;
import com.ntdat.hibernateproject.entities.ChiTietMonHocEntity;
import com.ntdat.hibernateproject.entities.SinhVienEntity;
import com.ntdat.hibernateproject.entities.compound.ClassSubject;
import com.ntdat.hibernateproject.ui.customcomponent.FlatButton;
import com.ntdat.hibernateproject.ui.customcomponent.FlatTextInput;
import com.ntdat.hibernateproject.ui.customcomponent.HeaderRenderer;
import com.ntdat.hibernateproject.ui.customcomponent.MyScrollbarUI;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Vector;

public class ScoresPanel extends JPanel {
    private JScrollPane scrpnlTable;
    private JTable tblScores;
    private FlatTextInput edtSearch;
    private FlatButton btnSearch;
    private FlatButton btnImportCSV;
    private FlatButton btnConfirm;
    private FlatButton btnCancel;

    private Vector<String> tableHeader = new Vector<String>(Arrays.asList("STT", "MSSV", "Họ và tên", "Điểm GK", "Điểm CK", "Điểm khác", "Điểm tổng"));
    private String classIDMain = "";
    private List<ChiTietMonHocEntity> subjectDetailList = new ArrayList<>();

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

        btnImportCSV.setVisible(false);
        btnConfirm.setVisible(false);
        btnCancel.setVisible(false);
        tblScores.setModel(new javax.swing.table.DefaultTableModel(new Vector(), tableHeader));
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment( JLabel.CENTER );
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

        btnSearch.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                String classID = edtSearch.getText();
                List<ChiTietMonHocEntity> subjectDetailList = SubjectDetailDAO.getSubjectDetails(classID);
                Vector table = new Vector();
                for (int i = 0; i < subjectDetailList.size(); i++) {
                    Vector record = new Vector();
                    record.add(String.valueOf(i+1));
                    record.add(subjectDetailList.get(i).getMssv());
                    SinhVienEntity s = StudentDAO.getStudent(subjectDetailList.get(i).getMssv());
                    record.add(s.getHoVaTen());
                    record.add(subjectDetailList.get(i).getDiemGk());
                    record.add(subjectDetailList.get(i).getDiemCk());
                    record.add(subjectDetailList.get(i).getDiemKhac());
                    record.add(subjectDetailList.get(i).getDiemTong());
                    table.add(record);
                }
                tblScores.setModel(new javax.swing.table.DefaultTableModel(table, tableHeader));
                DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
                centerRenderer.setHorizontalAlignment( JLabel.CENTER );
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
            }
        });
    }
}
