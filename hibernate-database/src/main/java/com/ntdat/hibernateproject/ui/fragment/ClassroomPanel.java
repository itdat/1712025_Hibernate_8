package com.ntdat.hibernateproject.ui.fragment;

import com.ntdat.hibernateproject.dao.StudentDAO;
import com.ntdat.hibernateproject.entities.SinhVienEntity;
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

public class ClassroomPanel extends JPanel {
    private JScrollPane scrpnlTable;
    private JTable tblClassroom;
    private FlatTextInput edtSearch;
    private FlatButton btnSearch;
    private FlatButton btnImportCSV;
    private FlatButton btnAddStudent;
    private FlatButton btnConfirm;
    private FlatButton btnCancel;

    private List<SinhVienEntity> studentList = new ArrayList<>();
    private Vector<String> tableHeader = new Vector<String>(Arrays.asList("STT", "MSSV", "Họ và tên", "Giới tính", "CMND"));
    private Vector<Vector<String>> tableData;
    private String classIDMain = "";

    public ClassroomPanel() {
        initComponents();
    }

    public ClassroomPanel(String classID) {
        this.classIDMain = classID; initComponents();
    }

    private void initComponents() {
        setBackground(new Color(88, 102, 146));
        setSize(1280,768);
        setVisible(true);
        scrpnlTable = new javax.swing.JScrollPane();
        scrpnlTable.getVerticalScrollBar().setUI(new MyScrollbarUI());
        tblClassroom = new javax.swing.JTable();
        edtSearch = new FlatTextInput("Mã lớp - VD: 17CTT1");
        btnSearch = new FlatButton(new Color(58,66,129), new Color(30,34,82), new Color(36,55,114));
        btnImportCSV = new FlatButton(new Color(58,66,129), new Color(30,34,82), new Color(36,55,114));
        btnAddStudent = new FlatButton(new Color(58,66,129), new Color(30,34,82), new Color(36,55,114));
        btnConfirm = new FlatButton(new Color(58,66,129), new Color(30,34,82), new Color(36,55,114));
        btnCancel = new FlatButton(new Color(58,66,129), new Color(30,34,82), new Color(71,83,114));
        edtSearch.setFont(new Font("Roboto", 0, 18)); // NOI18N
        edtSearch.setToolTipText("");
        btnSearch.setFont(new Font("Roboto", 0, 18)); // NOI18N
        btnSearch.setText("Tìm kiếm");
        btnImportCSV.setFont(new Font("Roboto", 0, 18)); // NOI18N
        btnImportCSV.setText("Nhập từ CSV");
        btnAddStudent.setFont(new Font("Roboto", 0, 18)); // NOI18N
        btnAddStudent.setText("Bổ sung SV");
        btnConfirm.setFont(new Font("Roboto", 0, 18)); // NOI18N
        btnConfirm.setText("Xác nhận");
        btnCancel.setFont(new Font("Roboto", 0, 18)); // NOI18N
        btnCancel.setText("Hủy bỏ");

        btnAddStudent.setVisible(false);
        btnConfirm.setVisible(false);
        btnCancel.setVisible(false);

        tblClassroom.getTableHeader().setDefaultRenderer(new HeaderRenderer());
        tblClassroom.setFont(new Font("Roboto", 0, 18)); // NOI18N

        tblClassroom.setModel(new javax.swing.table.DefaultTableModel(new Vector(), this.tableHeader));
        tblClassroom.getColumnModel().getColumn(0).setPreferredWidth(120);
        tblClassroom.getColumnModel().getColumn(1).setPreferredWidth(210);
        tblClassroom.getColumnModel().getColumn(2).setPreferredWidth(300);
        tblClassroom.getColumnModel().getColumn(3).setPreferredWidth(165);
        tblClassroom.getColumnModel().getColumn(4).setPreferredWidth(260);
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment( JLabel.CENTER );
        tblClassroom.getColumnModel().getColumn(0).setCellRenderer(centerRenderer);
        tblClassroom.getColumnModel().getColumn(1).setCellRenderer(centerRenderer);
        tblClassroom.getColumnModel().getColumn(2).setCellRenderer(centerRenderer);
        tblClassroom.getColumnModel().getColumn(3).setCellRenderer(centerRenderer);
        tblClassroom.getColumnModel().getColumn(4).setCellRenderer(centerRenderer);
        tblClassroom.setDragEnabled(true);
        tblClassroom.setFocusable(false);
        tblClassroom.setRowHeight(40);
        tblClassroom.setSelectionBackground(new Color(129, 150, 204));
        tblClassroom.setSelectionForeground(new Color(0, 0, 0));
        tblClassroom.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        scrpnlTable.setViewportView(tblClassroom);

        btnSearch.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                String classID = edtSearch.getText();
                List<SinhVienEntity> sinhVienEntityList = StudentDAO.getStudents(classID);
                DefaultTableModel model = new DefaultTableModel();

                Vector table = new Vector();
                for (int i = 0; i < sinhVienEntityList.size(); i++) {
                    Vector record = new Vector();
                    record.add(String.valueOf(i+1));
                    record.add(sinhVienEntityList.get(i).getMssv());
                    record.add(sinhVienEntityList.get(i).getHoVaTen());
                    record.add(sinhVienEntityList.get(i).getGioiTinh());
                    record.add(sinhVienEntityList.get(i).getCmnd());
                    table.add(record);
                }
                btnAddStudent.setVisible(true);
                tblClassroom.setModel(new javax.swing.table.DefaultTableModel(table, tableHeader));
                tblClassroom.getColumnModel().getColumn(0).setPreferredWidth(120);
                tblClassroom.getColumnModel().getColumn(1).setPreferredWidth(210);
                tblClassroom.getColumnModel().getColumn(2).setPreferredWidth(300);
                tblClassroom.getColumnModel().getColumn(3).setPreferredWidth(165);
                tblClassroom.getColumnModel().getColumn(4).setPreferredWidth(260);
                DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
                centerRenderer.setHorizontalAlignment( JLabel.CENTER );
                tblClassroom.getColumnModel().getColumn(0).setCellRenderer(centerRenderer);
                tblClassroom.getColumnModel().getColumn(1).setCellRenderer(centerRenderer);
                tblClassroom.getColumnModel().getColumn(2).setCellRenderer(centerRenderer);
                tblClassroom.getColumnModel().getColumn(3).setCellRenderer(centerRenderer);
                tblClassroom.getColumnModel().getColumn(4).setCellRenderer(centerRenderer);
                tblClassroom.setDragEnabled(true);
                tblClassroom.setFocusable(false);
                tblClassroom.setRowHeight(40);
                tblClassroom.setSelectionBackground(new Color(129, 150, 204));
                tblClassroom.setSelectionForeground(new Color(0, 0, 0));
                tblClassroom.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
            }
        });

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
                        SinhVienEntity student = new SinhVienEntity(record.get(1).toString(), record.get(2).toString(), record.get(3).toString(), record.get(4).toString(), classIDMain);
                        studentList.add(student);
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
                    tblClassroom.setModel(new javax.swing.table.DefaultTableModel(table, tableHeader));
                    tblClassroom.getColumnModel().getColumn(0).setPreferredWidth(120);
                    tblClassroom.getColumnModel().getColumn(1).setPreferredWidth(210);
                    tblClassroom.getColumnModel().getColumn(2).setPreferredWidth(300);
                    tblClassroom.getColumnModel().getColumn(3).setPreferredWidth(165);
                    tblClassroom.getColumnModel().getColumn(4).setPreferredWidth(260);
                    DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
                    centerRenderer.setHorizontalAlignment( JLabel.CENTER );
                    tblClassroom.getColumnModel().getColumn(0).setCellRenderer(centerRenderer);
                    tblClassroom.getColumnModel().getColumn(1).setCellRenderer(centerRenderer);
                    tblClassroom.getColumnModel().getColumn(2).setCellRenderer(centerRenderer);
                    tblClassroom.getColumnModel().getColumn(3).setCellRenderer(centerRenderer);
                    tblClassroom.getColumnModel().getColumn(4).setCellRenderer(centerRenderer);
                    tblClassroom.setDragEnabled(true);
                    tblClassroom.setFocusable(false);
                    tblClassroom.setRowHeight(40);
                    tblClassroom.setSelectionBackground(new Color(129, 150, 204));
                    tblClassroom.setSelectionForeground(new Color(0, 0, 0));
                    tblClassroom.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
                }
            }
        });

        btnConfirm.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                for (SinhVienEntity student : studentList) {
                    StudentDAO.addStudent(student);
                }
                tblClassroom.setModel(new javax.swing.table.DefaultTableModel(new Vector(), tableHeader));
                edtSearch.setText("");
                edtSearch.setEditable(true);
                btnSearch.setVisible(true);
                btnConfirm.setVisible(false);
                btnCancel.setVisible(false);
            }
        });

        btnCancel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblClassroom.setModel(new javax.swing.table.DefaultTableModel(new Vector(), tableHeader));
                edtSearch.setText("");
                edtSearch.setEditable(true);
                btnSearch.setVisible(true);
                btnConfirm.setVisible(false);
                btnCancel.setVisible(false);
            }
        });

        javax.swing.GroupLayout pnlMainLayout = new javax.swing.GroupLayout(this);
        this.setLayout(pnlMainLayout);
        pnlMainLayout.setHorizontalGroup(
                pnlMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(pnlMainLayout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(pnlMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(scrpnlTable)
                                        .addGroup(pnlMainLayout.createSequentialGroup()
                                                .addComponent(btnImportCSV)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(btnAddStudent)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(edtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 272, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(btnSearch)
                                                .addGap(9, 9, 9))
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlMainLayout.createSequentialGroup()
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 868, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(btnCancel)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(btnConfirm)
                                                .addGap(10, 10, 10)))
                                .addContainerGap())
        );
        pnlMainLayout.setVerticalGroup(
                pnlMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(pnlMainLayout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(pnlMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(edtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(btnSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(btnImportCSV, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(btnAddStudent, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(scrpnlTable, javax.swing.GroupLayout.DEFAULT_SIZE, 609, Short.MAX_VALUE)
                                .addGap(9, 9, 9)
                                .addGroup(pnlMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(btnConfirm)
                                        .addComponent(btnCancel))
                                .addContainerGap())
        );
    }
}
