package com.ntdat.hibernateproject.ui.fragment;

import com.ntdat.hibernateproject.dao.AccountDAO;
import com.ntdat.hibernateproject.dao.StudentDAO;
import com.ntdat.hibernateproject.entities.SinhVienEntity;
import com.ntdat.hibernateproject.entities.TaiKhoanEntity;
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
    // DEFINE VALUES
    private static final Font DEFAULT_FONT = new Font("Roboto", 0, 18);
    private static final Color PANEL_BACKGROUND_COLOR = new Color(88, 102, 146);
    private static final Vector<String> TABLE_HEADER = new Vector<String>(Arrays.asList("STT", "MSSV", "Họ và tên", "Giới tính", "CMND"));

    private JTable tblClassroom;
    private FlatTextInput edtSearch;
    private FlatButton btnSearch;
    private FlatButton btnAddStudent;
    private FlatButton btnConfirm;
    private FlatButton btnCancel;

    private List<SinhVienEntity> studentList = new ArrayList<>();
    private String classIDMain = "";

    public ClassroomPanel() {
        initComponents();
    }

    public ClassroomPanel(String classID) {
        this.classIDMain = classID; initComponents();
    }

    private void initTable() {
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
    }

    private void initComponents() {
        setBackground(PANEL_BACKGROUND_COLOR);
        setSize(1280,768);
        setVisible(true);

        edtSearch = new FlatTextInput("Nhập mã lớp");
        edtSearch.setFont(DEFAULT_FONT);
        edtSearch.setToolTipText("<html><b>Xem danh sách sinh viên theo lớp.</b><br/>Mã lớp có 2 loại:<br/>- Mã lớp mặc định - vd: 17CTT1<br/>- Mã lớp theo môn học - vd: 17CTT1-WDS1</html>");

        btnSearch = new FlatButton();
        btnSearch.setText("Tìm kiếm");

        FlatButton btnImportCSV = new FlatButton();
        btnImportCSV.setText("Nhập từ CSV");

        btnAddStudent = new FlatButton();
        btnAddStudent.setText("Bổ sung SV");

        btnConfirm = new FlatButton();
        btnConfirm.setText("Xác nhận");

        btnCancel = new FlatButton();
        btnCancel.setText("Hủy bỏ");

        // HIDE BUTTONS
        btnAddStudent.setVisible(false);
        btnConfirm.setVisible(false);
        btnCancel.setVisible(false);

        tblClassroom = new javax.swing.JTable();
        tblClassroom.getTableHeader().setDefaultRenderer(new HeaderRenderer());
        tblClassroom.setFont(DEFAULT_FONT);
        tblClassroom.setDragEnabled(true);
        tblClassroom.setFocusable(false);
        tblClassroom.setRowHeight(40);
        tblClassroom.setSelectionBackground(new Color(129, 150, 204));
        tblClassroom.setSelectionForeground(Color.BLACK);
        tblClassroom.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        tblClassroom.setModel(new javax.swing.table.DefaultTableModel(new Vector(), TABLE_HEADER));
        initTable();

        JScrollPane scrpnlTable = new JScrollPane();
        scrpnlTable.getVerticalScrollBar().setUI(new MyScrollbarUI());
        scrpnlTable.setViewportView(tblClassroom);

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


        // EVENT LISTENERS

        btnSearch.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                String classID = edtSearch.getText();
                List<SinhVienEntity> sinhVienEntityList = StudentDAO.getStudents(classID);

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
                tblClassroom.setModel(new javax.swing.table.DefaultTableModel(table, TABLE_HEADER));
                initTable();
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
                    tblClassroom.setModel(new javax.swing.table.DefaultTableModel(table, TABLE_HEADER));
                    initTable();
                }
            }
        });

        btnConfirm.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                for (SinhVienEntity student : studentList) {
                    StudentDAO.addStudent(student);
                    AccountDAO.addAccount(new TaiKhoanEntity(student.getMssv(), student.getCmnd()));
                }
                tblClassroom.setModel(new javax.swing.table.DefaultTableModel(new Vector(), TABLE_HEADER));
                edtSearch.setText("");
                edtSearch.setEditable(true);
                btnSearch.setVisible(true);
                btnConfirm.setVisible(false);
                btnCancel.setVisible(false);
            }
        });

        btnCancel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblClassroom.setModel(new javax.swing.table.DefaultTableModel(new Vector(), TABLE_HEADER));
                edtSearch.setText("");
                edtSearch.setEditable(true);
                btnSearch.setVisible(true);
                btnConfirm.setVisible(false);
                btnCancel.setVisible(false);
            }
        });
    }
}
