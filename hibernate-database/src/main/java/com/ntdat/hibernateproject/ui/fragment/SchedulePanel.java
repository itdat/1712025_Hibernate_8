package com.ntdat.hibernateproject.ui.fragment;

import com.ntdat.hibernateproject.dao.StudentDAO;
import com.ntdat.hibernateproject.dao.SubjectDAO;
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
import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Vector;

public class SchedulePanel extends JPanel {
    private JScrollPane scrpnlTable ;
    private JTable tblSchedule;
    private FlatTextInput edtSearch;
    private FlatButton btnSearch;
    private FlatButton btnImportCSV;
    private FlatButton btnConfirm;
    private FlatButton btnCancel;
    private Vector<String> tableHeader = new Vector<String>(Arrays.asList("STT", "Mã môn", "Tên môn", "Phòng học"));
    private String classIDMain = "";

    private List<ClassSubject> subjectList = new ArrayList<>();

    public SchedulePanel() {
        initComponents();
    }

    private void initComponents() {
        setBackground(new Color(88, 102, 146));
        scrpnlTable = new javax.swing.JScrollPane();
        tblSchedule = new javax.swing.JTable();
        edtSearch = new FlatTextInput("Mã lớp - VD: 17CTT1");
        btnSearch = new FlatButton(new Color(58,66,129), new Color(30,34,82), new Color(36,55,114));
        btnImportCSV = new FlatButton(new Color(58,66,129), new Color(30,34,82), new Color(36,55,114));
        btnConfirm = new FlatButton(new Color(58,66,129), new Color(30,34,82), new Color(36,55,114));
        btnCancel = new FlatButton(new Color(58,66,129), new Color(30,34,82), new Color(71,83,114));
        scrpnlTable.getVerticalScrollBar().setUI(new MyScrollbarUI());

        tblSchedule.getTableHeader().setDefaultRenderer(new HeaderRenderer());
        tblSchedule.setFont(new Font("Roboto", 0, 18)); // NOI18N
        btnConfirm.setVisible(false);
        btnCancel.setVisible(false);
        
        tblSchedule.setModel(new javax.swing.table.DefaultTableModel(new Vector(), tableHeader));
        tblSchedule.getColumnModel().getColumn(0).setPreferredWidth(120);
        tblSchedule.getColumnModel().getColumn(1).setPreferredWidth(210);
        tblSchedule.getColumnModel().getColumn(2).setPreferredWidth(470);
        tblSchedule.getColumnModel().getColumn(3).setPreferredWidth(260);
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment( JLabel.CENTER );
        tblSchedule.getColumnModel().getColumn(0).setCellRenderer(centerRenderer);
        tblSchedule.getColumnModel().getColumn(1).setCellRenderer(centerRenderer);
        tblSchedule.getColumnModel().getColumn(2).setCellRenderer(centerRenderer);
        tblSchedule.getColumnModel().getColumn(3).setCellRenderer(centerRenderer);
        tblSchedule.setDragEnabled(true);
        tblSchedule.setFocusable(false);
        tblSchedule.setRowHeight(40);
        tblSchedule.setSelectionBackground(new Color(129, 150, 204));
        tblSchedule.setSelectionForeground(new Color(0, 0, 0));
        tblSchedule.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        scrpnlTable.setViewportView(tblSchedule);

        btnImportCSV.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                JFileChooser jFileChooser = new JFileChooser();
                jFileChooser.showDialog(getParent(), "Chọn");
                File selectedFile = jFileChooser.getSelectedFile();
                String[] fileComponents = selectedFile.getAbsolutePath().split("\\\\");
                classIDMain = fileComponents[fileComponents.length - 1].replace(".csv", "");
                edtSearch.setText(classIDMain);
                Vector table = new Vector();
                try {
                    BufferedReader bufferedReader = new BufferedReader(new FileReader(selectedFile));
                    table = new Vector();
                    String line;
                    while (true) {
                        line = bufferedReader.readLine();
                        String[] tokens = line.split(",");
                        Vector record = new Vector();
                        for (String token : tokens) {
                            record.add(token);
                        }
                        table.add(record);
                        ClassSubject classSubject = new ClassSubject(record.get(1).toString(), record.get(2).toString(), record.get(3).toString(), classIDMain);
                        subjectList.add(classSubject);
                    }
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                } finally {
                    edtSearch.setEditable(false);
                    btnSearch.setVisible(false);
                    btnConfirm.setVisible(true);
                    btnCancel.setVisible(true);
                    tblSchedule.setModel(new javax.swing.table.DefaultTableModel(table, tableHeader));
                    tblSchedule.getColumnModel().getColumn(0).setPreferredWidth(120);
                    tblSchedule.getColumnModel().getColumn(1).setPreferredWidth(210);
                    tblSchedule.getColumnModel().getColumn(2).setPreferredWidth(470);
                    tblSchedule.getColumnModel().getColumn(3).setPreferredWidth(260);
                    DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
                    centerRenderer.setHorizontalAlignment( JLabel.CENTER );
                    tblSchedule.getColumnModel().getColumn(0).setCellRenderer(centerRenderer);
                    tblSchedule.getColumnModel().getColumn(1).setCellRenderer(centerRenderer);
                    tblSchedule.getColumnModel().getColumn(2).setCellRenderer(centerRenderer);
                    tblSchedule.getColumnModel().getColumn(3).setCellRenderer(centerRenderer);
                    tblSchedule.setDragEnabled(true);
                    tblSchedule.setFocusable(false);
                    tblSchedule.setRowHeight(40);
                    tblSchedule.setSelectionBackground(new Color(129, 150, 204));
                    tblSchedule.setSelectionForeground(new Color(0, 0, 0));
                    tblSchedule.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
                    scrpnlTable.setViewportView(tblSchedule);
                }
            }
        });

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
                List<ClassSubject> classSubjectList = SubjectDAO.getClassSubjects(classID);
                DefaultTableModel model = new DefaultTableModel();

                Vector table = new Vector();
                for (int i = 0; i < classSubjectList.size(); i++) {
                    Vector record = new Vector();
                    record.add(String.valueOf(i+1));
                    record.add(classSubjectList.get(i).getId());
                    record.add(classSubjectList.get(i).getName());
                    record.add(classSubjectList.get(i).getRoom());
                    table.add(record);
                }
                tblSchedule.setModel(new javax.swing.table.DefaultTableModel(table, tableHeader));
                tblSchedule.getColumnModel().getColumn(0).setPreferredWidth(120);
                tblSchedule.getColumnModel().getColumn(1).setPreferredWidth(210);
                tblSchedule.getColumnModel().getColumn(2).setPreferredWidth(470);
                tblSchedule.getColumnModel().getColumn(3).setPreferredWidth(260);
                DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
                centerRenderer.setHorizontalAlignment( JLabel.CENTER );
                tblSchedule.getColumnModel().getColumn(0).setCellRenderer(centerRenderer);
                tblSchedule.getColumnModel().getColumn(1).setCellRenderer(centerRenderer);
                tblSchedule.getColumnModel().getColumn(2).setCellRenderer(centerRenderer);
                tblSchedule.getColumnModel().getColumn(3).setCellRenderer(centerRenderer);
                tblSchedule.setDragEnabled(true);
                tblSchedule.setFocusable(false);
                tblSchedule.setRowHeight(40);
                tblSchedule.setSelectionBackground(new Color(129, 150, 204));
                tblSchedule.setSelectionForeground(new Color(0, 0, 0));
                tblSchedule.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
                scrpnlTable.setViewportView(tblSchedule);
            }
        });

        btnConfirm.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                for (ClassSubject subject : subjectList) {
                    SubjectDAO.addClassSubject(subject);
                }
                tblSchedule.setModel(new javax.swing.table.DefaultTableModel(new Vector(), tableHeader));
                edtSearch.setText("");
                edtSearch.setEditable(true);
                btnSearch.setVisible(true);
                btnConfirm.setVisible(false);
                btnCancel.setVisible(false);
            }
        });

        btnCancel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblSchedule.setModel(new javax.swing.table.DefaultTableModel(new Vector(), tableHeader));
                edtSearch.setText("");
                edtSearch.setEditable(true);
                btnSearch.setVisible(true);
                btnConfirm.setVisible(false);
                btnCancel.setVisible(false);
            }
        });
    }
}
