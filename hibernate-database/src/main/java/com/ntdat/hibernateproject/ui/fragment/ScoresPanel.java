package com.ntdat.hibernateproject.ui.fragment;

import com.ntdat.hibernateproject.dao.ClassroomDAO;
import com.ntdat.hibernateproject.dao.StudentDAO;
import com.ntdat.hibernateproject.dao.SubjectDAO;
import com.ntdat.hibernateproject.dao.SubjectDetailDAO;
import com.ntdat.hibernateproject.entities.ChiTietLopHocEntity;
import com.ntdat.hibernateproject.entities.ChiTietMonHocEntity;
import com.ntdat.hibernateproject.entities.SinhVienEntity;
import com.ntdat.hibernateproject.entities.compound.ClassSubject;
import com.ntdat.hibernateproject.ui.customcomponent.FlatButton;
import com.ntdat.hibernateproject.ui.customcomponent.FlatTextInput;
import com.ntdat.hibernateproject.ui.customcomponent.HeaderRenderer;
import com.ntdat.hibernateproject.ui.customcomponent.MyScrollbarUI;
import com.ntdat.hibernateproject.utilities.CSVImporter;

import javax.security.auth.Subject;
import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Vector;

public class ScoresPanel extends JPanel {
    private static ScoresPanel instance;
    // DEFINE VALUES
    private static final Font DEFAULT_FONT = new Font("Roboto", 0, 18);
    private static final Color PANEL_BACKGROUND_COLOR = new Color(88, 102, 146);
    private static final Vector<String> TABLE_HEADER = new Vector<String>(Arrays.asList("STT", "MSSV", "Họ và tên", "Điểm GK", "Điểm CK", "Điểm khác", "Điểm tổng"));
    private static final Vector<String> TABLE_HEADER_STUDENT = new Vector<String>(Arrays.asList("STT", "Mã môn", "Tên môn", "Điểm GK", "Điểm CK", "Điểm khác", "Điểm tổng"));

    private JScrollPane scrpnlTable;
    private DefaultTableModel dataModel = new DefaultTableModel();
    private JTable tblScores = new JTable(dataModel);
    private FlatTextInput edtSearch;
    private FlatButton btnSearch;
    private FlatButton btnImportCSV;
    private FlatButton btnConfirm;
    private FlatButton btnCancel;

    private boolean adminPermission = true;
    private String username;

    private String classIDMain = "";
    private List<ChiTietMonHocEntity> subjectDetailList = new ArrayList<>();

    private ScoresPanel(String username) {
        this.username = username;
        if (username.equals("giaovu")) {
            this.adminPermission = true;
        } else {
            this.adminPermission = false;
        }
        initComponents();
    }

    public static ScoresPanel getInstance(String username) {
        if (instance == null) {
            instance = new ScoresPanel(username);
        }
        return instance;
    }

    public static void releaseInstance() {
        instance = null;
    }

    private void initTable() {
        tblScores.getColumnModel().getColumn(0).setPreferredWidth(85);
        tblScores.getColumnModel().getColumn(1).setPreferredWidth(170);
        tblScores.getColumnModel().getColumn(2).setPreferredWidth(290);
        tblScores.getColumnModel().getColumn(3).setPreferredWidth(128);
        tblScores.getColumnModel().getColumn(4).setPreferredWidth(128);
        tblScores.getColumnModel().getColumn(5).setPreferredWidth(128);
        tblScores.getColumnModel().getColumn(6).setPreferredWidth(128);
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment( JLabel.CENTER );
        tblScores.getColumnModel().getColumn(0).setCellRenderer(centerRenderer);
        tblScores.getColumnModel().getColumn(1).setCellRenderer(centerRenderer);
        tblScores.getColumnModel().getColumn(2).setCellRenderer(centerRenderer);
        tblScores.getColumnModel().getColumn(3).setCellRenderer(centerRenderer);
        tblScores.getColumnModel().getColumn(4).setCellRenderer(centerRenderer);
        tblScores.getColumnModel().getColumn(5).setCellRenderer(centerRenderer);
        tblScores.getColumnModel().getColumn(6).setCellRenderer(centerRenderer);

        JTextField textField = new JTextField();
        textField.setFont(DEFAULT_FONT);
        textField.setHorizontalAlignment(SwingConstants.CENTER);
        textField.setBorder(null);
        DefaultCellEditor customCellEditor = new DefaultCellEditor(textField);
        for (int i = 0; i < tblScores.getColumnCount(); i++) {
            tblScores.getColumnModel().getColumn(i).setCellEditor(customCellEditor);
        }
    }

    private void updateTable() {
        List<ChiTietMonHocEntity> chiTietMonHocEntityList = SubjectDetailDAO.getSubjectDetails(edtSearch.getText());

        Vector table = new Vector();
        for (int i = 0; i < chiTietMonHocEntityList.size(); i++) {
            Vector record = new Vector();
            record.add(String.valueOf(i+1));
            record.add(chiTietMonHocEntityList.get(i).getMssv());
            record.add(StudentDAO.getStudent(chiTietMonHocEntityList.get(i).getMssv()).getHoVaTen());
            record.add(chiTietMonHocEntityList.get(i).getDiemGk());
            record.add(chiTietMonHocEntityList.get(i).getDiemCk());
            record.add(chiTietMonHocEntityList.get(i).getDiemKhac());
            record.add(chiTietMonHocEntityList.get(i).getDiemTong());

            table.add(record);
        }
        tblScores.setModel(new javax.swing.table.DefaultTableModel(table, adminPermission?TABLE_HEADER:TABLE_HEADER_STUDENT));
        initTable();
    }

    private void initComponents() {
        setBackground(PANEL_BACKGROUND_COLOR);
        setSize(1280,768);
        setVisible(true);

        edtSearch = new FlatTextInput("Nhập mã lớp");
        edtSearch.setFont(DEFAULT_FONT);
        edtSearch.setToolTipText("<html><b>Xem điểm của sinh viên theo lớp học.</b><br/>- Mã lớp theo môn học - vd: 17CTT1-WDS1</html>");

        btnSearch = new FlatButton();
        btnSearch.setText("Tìm kiếm");

        btnImportCSV = new FlatButton();
        btnImportCSV.setText("Nhập từ CSV");

        btnConfirm = new FlatButton();
        btnConfirm.setText("Xác nhận");

        btnCancel = new FlatButton();
        btnCancel.setText("Hủy bỏ");

        btnImportCSV.setVisible(true);
        btnConfirm.setVisible(false);
        btnCancel.setVisible(false);

        if (!adminPermission) {
            btnImportCSV.setVisible(false);
            btnSearch.setVisible(false);
            edtSearch.setVisible(false);
        }

        tblScores = new javax.swing.JTable();
        tblScores.getTableHeader().setDefaultRenderer(new HeaderRenderer());
        tblScores.setFont(DEFAULT_FONT);
        tblScores.setDragEnabled(true);
        tblScores.setFocusable(false);
        tblScores.setRowHeight(40);
        tblScores.setSelectionBackground(new Color(129, 150, 204));
        tblScores.setSelectionForeground(Color.BLACK);
        tblScores.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);

        Vector table = new Vector();
        if (!adminPermission) {
            List<ChiTietMonHocEntity> chiTietMonHocEntityList = SubjectDetailDAO.getSubjectDetailsStudent(username);
            for (int i = 0; i < chiTietMonHocEntityList.size(); i++) {
                Vector record = new Vector();
                record.add(String.valueOf(i+1));
                record.add(chiTietMonHocEntityList.get(i).getMaMon());
                record.add(SubjectDAO.getSubject(chiTietMonHocEntityList.get(i).getMaMon()).getTenMon());
                record.add(chiTietMonHocEntityList.get(i).getDiemGk());
                record.add(chiTietMonHocEntityList.get(i).getDiemCk());
                record.add(chiTietMonHocEntityList.get(i).getDiemKhac());
                record.add(chiTietMonHocEntityList.get(i).getDiemTong());
                table.add(record);
            }
        }

        tblScores.setModel(new javax.swing.table.DefaultTableModel(table, adminPermission?TABLE_HEADER:TABLE_HEADER_STUDENT));
        initTable();

        scrpnlTable = new javax.swing.JScrollPane();
        scrpnlTable.getVerticalScrollBar().setUI(new MyScrollbarUI());
        scrpnlTable.setViewportView(tblScores);

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


        // EVENT LISTENERS

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
                tblScores.setModel(new javax.swing.table.DefaultTableModel(table, adminPermission?TABLE_HEADER:TABLE_HEADER_STUDENT));
                initTable();
            }
        });

        btnImportCSV.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                CSVImporter csvImporter = new CSVImporter();
                csvImporter.importCSV(getParent());
                if (csvImporter.getFileName() == null) return;
                classIDMain = csvImporter.getFileName();

                Vector table = csvImporter.getTable();
                System.out.println(table);
                dataModel.setDataVector(table,adminPermission?TABLE_HEADER:TABLE_HEADER_STUDENT);

                edtSearch.setText(classIDMain);
                btnSearch.setVisible(false);
                btnConfirm.setVisible(true);
                btnCancel.setVisible(true);
                tblScores.setModel(new javax.swing.table.DefaultTableModel(table, adminPermission?TABLE_HEADER:TABLE_HEADER_STUDENT));
                initTable();
            }
        });

        btnConfirm.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                if (tblScores.isEditing())
                    tblScores.getCellEditor().stopCellEditing();

                classIDMain = edtSearch.getText();
                if (SubjectDetailDAO.getSubjectDetails(classIDMain).size() == 0) {
                    edtSearch.setEditable(true);
                    btnSearch.setVisible(true);
                    btnConfirm.setVisible(false);
                    btnCancel.setVisible(false);
                    updateTable();
                    JOptionPane.showMessageDialog(getParent(), "Lớp học không tồn tại.", "Nhập file thất bại", JOptionPane.INFORMATION_MESSAGE);
                    return;
                }

                if (!classIDMain.contains("-")) {
                    edtSearch.setEditable(true);
                    btnSearch.setVisible(true);
                    btnConfirm.setVisible(false);
                    btnCancel.setVisible(false);
                    updateTable();
                    JOptionPane.showMessageDialog(getParent(), "Sai định dạng tên lớp học.", "Nhập file thất bại", JOptionPane.INFORMATION_MESSAGE);
                    edtSearch.setText("");
                    return;
                }

                classIDMain = edtSearch.getText();
                String classID = "", subjectID = "";
                if (classIDMain.contains("-")) {
                    String[] token = classIDMain.split("-");
                    classID = token[0];
                    subjectID = token[1];
                }

                int success = 0;
                int total = dataModel.getRowCount();

                for (int i = 0; i < dataModel.getDataVector().size(); i++) {
                    Vector<String> record = (Vector<String>) dataModel.getDataVector().get(i);

                    ChiTietMonHocEntity chiTietMonHocEntity = new ChiTietMonHocEntity(classID, subjectID, record.get(1), Double.parseDouble(record.get(3)), Double.parseDouble(record.get(4)), Double.parseDouble(record.get(5)), Double.parseDouble(record.get(6)));
                    if (SubjectDetailDAO.updateSubjectDetail(chiTietMonHocEntity)) {
                        success++;
                    }
                }

                edtSearch.setEditable(true);
                btnSearch.setVisible(true);
                btnConfirm.setVisible(false);
                btnCancel.setVisible(false);

                // Update table
                updateTable();

                JOptionPane.showMessageDialog(getParent(), "Nhập thành công: " + success + "/" + total + ".", "Nhập file hoàn tất", JOptionPane.INFORMATION_MESSAGE);
            }
        });
    }
}
