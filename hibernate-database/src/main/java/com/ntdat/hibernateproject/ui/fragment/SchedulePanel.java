package com.ntdat.hibernateproject.ui.fragment;

import com.ntdat.hibernateproject.dao.*;
import com.ntdat.hibernateproject.entities.ChiTietMonHocEntity;
import com.ntdat.hibernateproject.entities.SinhVienEntity;
import com.ntdat.hibernateproject.entities.TaiKhoanEntity;
import com.ntdat.hibernateproject.entities.compound.ClassSubject;
import com.ntdat.hibernateproject.ui.customcomponent.FlatButton;
import com.ntdat.hibernateproject.ui.customcomponent.FlatTextInput;
import com.ntdat.hibernateproject.ui.customcomponent.HeaderRenderer;
import com.ntdat.hibernateproject.ui.customcomponent.MyScrollbarUI;
import com.ntdat.hibernateproject.utilities.CSVImporter;

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
    private static SchedulePanel instance;
    // DEFINE VALUES
    private static final Font DEFAULT_FONT = new Font("Roboto", 0, 18);
    private static final Color PANEL_BACKGROUND_COLOR = new Color(88, 102, 146);
    private static final Vector<String> TABLE_HEADER = new Vector<String>(Arrays.asList("STT", "Mã môn", "Tên môn", "Phòng học"));

    private DefaultTableModel dataModel = new DefaultTableModel();
    private JTable tblSchedule = new JTable(dataModel);
    private FlatTextInput edtSearch;
    private FlatButton btnSearch;
    private FlatButton btnConfirm;
    private FlatButton btnCancel;
    private String classIDMain = "";

    private List<ClassSubject> subjectList = new ArrayList<>();

    private SchedulePanel() {
        initComponents();
    }

    public static SchedulePanel getInstance() {
        if (instance == null) {
            instance = new SchedulePanel();
        }
        return instance;
    }

    private void initTable() {
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

        JTextField textField = new JTextField();
        textField.setFont(DEFAULT_FONT);
        textField.setHorizontalAlignment(SwingConstants.CENTER);
        textField.setBorder(null);
        DefaultCellEditor customCellEditor = new DefaultCellEditor(textField);
        for (int i = 0; i < tblSchedule.getColumnCount(); i++) {
            tblSchedule.getColumnModel().getColumn(i).setCellEditor(customCellEditor);
        }
    }

    private void updateTable() {
        List<ClassSubject> classSubjectList = SubjectDAO.getClassSubjects(edtSearch.getText());

        Vector table = new Vector();
        for (int i = 0; i < classSubjectList.size(); i++) {
            Vector record = new Vector();
            record.add(String.valueOf(i+1));
            record.add(classSubjectList.get(i).getId());
            record.add(classSubjectList.get(i).getName());
            record.add(classSubjectList.get(i).getRoom());
            table.add(record);
        }
        tblSchedule.setModel(new javax.swing.table.DefaultTableModel(table, TABLE_HEADER));
        initTable();
    }
    
    private void initComponents() {
        setBackground(PANEL_BACKGROUND_COLOR);
        setSize(1280,768);
        setVisible(true);

        edtSearch = new FlatTextInput("Nhập mã lớp");
        edtSearch.setFont(DEFAULT_FONT);
        edtSearch.setToolTipText("<html><b>Xem thời khóa biểu theo lớp.</b><br/>- Mã lớp mặc định - vd: 17CTT1</html>");

        btnSearch = new FlatButton();
        btnSearch.setText("Tìm kiếm");

        FlatButton btnImportCSV = new FlatButton();
        btnImportCSV.setText("Nhập từ CSV");

        btnConfirm = new FlatButton();
        btnConfirm.setText("Xác nhận");

        btnCancel = new FlatButton();
        btnCancel.setText("Hủy bỏ");

        // HIDE BUTTONS
        btnConfirm.setVisible(false);
        btnCancel.setVisible(false);

        tblSchedule = new javax.swing.JTable();
        tblSchedule.getTableHeader().setDefaultRenderer(new HeaderRenderer());
        tblSchedule.setFont(DEFAULT_FONT);
        tblSchedule.setDragEnabled(true);
        tblSchedule.setFocusable(false);
        tblSchedule.setRowHeight(40);
        tblSchedule.setSelectionBackground(new Color(129, 150, 204));
        tblSchedule.setSelectionForeground(new Color(0, 0, 0));
        tblSchedule.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        tblSchedule.setModel(new javax.swing.table.DefaultTableModel(new Vector(), TABLE_HEADER));
        initTable();

        JScrollPane scrpnlTable = new JScrollPane();
        scrpnlTable.getVerticalScrollBar().setUI(new MyScrollbarUI());
        scrpnlTable.setViewportView(tblSchedule);

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
        
        btnImportCSV.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                CSVImporter csvImporter = new CSVImporter();
                csvImporter.importCSV(getParent());
                if (csvImporter.getFileName() == null) return;
                classIDMain = csvImporter.getFileName();

                Vector table = csvImporter.getTable();
                System.out.println(table);
                dataModel.setDataVector(table,TABLE_HEADER);

                edtSearch.setText(classIDMain);
                btnSearch.setVisible(false);
                btnConfirm.setVisible(true);
                btnCancel.setVisible(true);
                tblSchedule.setModel(new javax.swing.table.DefaultTableModel(table, TABLE_HEADER));
                initTable();
            }
        });

        btnSearch.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                String classID = edtSearch.getText();
                List<ClassSubject> classSubjectList = SubjectDAO.getClassSubjects(classID);
                Vector table = new Vector();
                for (int i = 0; i < classSubjectList.size(); i++) {
                    Vector record = new Vector();
                    record.add(String.valueOf(i+1));
                    record.add(classSubjectList.get(i).getId());
                    record.add(classSubjectList.get(i).getName());
                    record.add(classSubjectList.get(i).getRoom());
                    table.add(record);
                }

                if (classSubjectList.size() == 0) {
                    JOptionPane.showMessageDialog(getParent(), "Thời khóa biểu lớp học không tồn tại. Vui lòng nhập từ file csv.", "Không tìm thấy thời khóa biểu", JOptionPane.INFORMATION_MESSAGE);
                    edtSearch.setText("");
                }

                tblSchedule.setModel(new javax.swing.table.DefaultTableModel(table, TABLE_HEADER));
                initTable();
            }
        });

        btnConfirm.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                if (tblSchedule.isEditing())
                    tblSchedule.getCellEditor().stopCellEditing();

                classIDMain = edtSearch.getText();
                if (SubjectDAO.getClassSubjects(classIDMain).size() != 0) {
                    edtSearch.setEditable(true);
                    btnSearch.setVisible(true);
                    btnConfirm.setVisible(false);
                    btnCancel.setVisible(false);
                    updateTable();
                    JOptionPane.showMessageDialog(getParent(), "Thời khóa biểu đã tồn tại", "Nhập file thất bại", JOptionPane.INFORMATION_MESSAGE);
                    return;
                }

                if (ClassroomDAO.getClassroom(classIDMain) == null) {
                    edtSearch.setEditable(true);
                    btnSearch.setVisible(true);
                    btnConfirm.setVisible(false);
                    btnCancel.setVisible(false);
                    updateTable();
                    JOptionPane.showMessageDialog(getParent(), "Lớp học không tồn tại", "Nhập file thất bại", JOptionPane.INFORMATION_MESSAGE);
                    return;
                }

                int total = dataModel.getRowCount();

                for (int i = 0; i < dataModel.getDataVector().size(); i++) {
                    Vector<String> record = (Vector<String>) dataModel.getDataVector().get(i);
                    record.remove(0);
                    record.add(classIDMain);
                    System.out.println(record);

                    ClassSubject classSubject = new ClassSubject(record);
                    SubjectDAO.addClassSubject(classSubject);
                    List<SinhVienEntity> sinhVienEntityList = StudentDAO.getStudents(classIDMain);
                    for (SinhVienEntity sv : sinhVienEntityList) {
                        SubjectDetailDAO.addSubjectDetail(new ChiTietMonHocEntity(classIDMain, classSubject.getId(), sv.getMssv(), null, null, null, null));
                    }
                }

                edtSearch.setEditable(true);
                btnSearch.setVisible(true);
                btnConfirm.setVisible(false);
                btnCancel.setVisible(false);

                // Update table
                updateTable();

                JOptionPane.showMessageDialog(getParent(), "Nhập thành công thời khóa biểu lớp " + classIDMain + ".", "Nhập file hoàn tất", JOptionPane.INFORMATION_MESSAGE);
            }
        });

        btnCancel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblSchedule.setModel(new javax.swing.table.DefaultTableModel(new Vector(), TABLE_HEADER));
                edtSearch.setText("");
                edtSearch.setEditable(true);
                btnSearch.setVisible(true);
                btnConfirm.setVisible(false);
                btnCancel.setVisible(false);
            }
        });
    }
}
