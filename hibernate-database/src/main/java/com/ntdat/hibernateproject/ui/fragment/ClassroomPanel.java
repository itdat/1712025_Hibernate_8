package com.ntdat.hibernateproject.ui.fragment;

import com.ntdat.hibernateproject.dao.AccountDAO;
import com.ntdat.hibernateproject.dao.ClassroomDAO;
import com.ntdat.hibernateproject.dao.StudentDAO;
import com.ntdat.hibernateproject.dao.SubjectDetailDAO;
import com.ntdat.hibernateproject.entities.ChiTietMonHocEntityPK;
import com.ntdat.hibernateproject.entities.SinhVienEntity;
import com.ntdat.hibernateproject.entities.TaiKhoanEntity;
import com.ntdat.hibernateproject.ui.customcomponent.*;
import com.ntdat.hibernateproject.ui.dialog.AddStudentDialog;
import com.ntdat.hibernateproject.utilities.CSVImporter;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.Arrays;
import java.util.List;
import java.util.Vector;

public class ClassroomPanel extends JPanel {
    private static ClassroomPanel instance;
    // DEFINE VALUES
    private static final Font DEFAULT_FONT = new Font("Roboto", 0, 18);
    private static final Color PANEL_BACKGROUND_COLOR = new Color(88, 102, 146);
    private static final Vector<String> TABLE_HEADER = new Vector<String>(Arrays.asList("STT", "MSSV", "Họ và tên", "Giới tính", "CMND"));

    private DefaultTableModel dataModel = new DefaultTableModel();

    private boolean isDelete = false;

    private JTable tblClassroom = new JTable(dataModel);
    private FlatTextInput edtSearch;
    private FlatButton btnSearch;
    private FlatButton btnAddStudent;
    private FlatButton btnConfirm;
    private FlatButton btnCancel;
    
    private String classIDMain = "";

    private ClassroomPanel() {
        initComponents();
    }

    public static ClassroomPanel getInstance() {
        if (instance == null) {
            instance = new ClassroomPanel();
        }
        return instance;
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

        JTextField textField = new JTextField();
        textField.setFont(DEFAULT_FONT);
        textField.setHorizontalAlignment(SwingConstants.CENTER);
        textField.setBorder(null);
        DefaultCellEditor customCellEditor = new DefaultCellEditor(textField);
        for (int i = 0; i < tblClassroom.getColumnCount(); i++) {
            tblClassroom.getColumnModel().getColumn(i).setCellEditor(customCellEditor);
        }
    }

    private void updateTable() {
        tblClassroom.getSelectionModel().clearSelection();
        List<SinhVienEntity> sinhVienEntityList = StudentDAO.getStudents(edtSearch.getText());

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
        tblClassroom.setModel(new javax.swing.table.DefaultTableModel(table, TABLE_HEADER));
        initTable();
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

        tblClassroom.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                classIDMain = edtSearch.getText();
                if (classIDMain.contains("-")) {
                    isDelete = true;
                    btnConfirm.setText("Xóa sinh viên");
                    btnConfirm.setVisible(true);
                }
            }
        });

        btnSearch.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnConfirm.setVisible(false);
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

                if (sinhVienEntityList.size() == 0) {
                    JOptionPane.showMessageDialog(getParent(), "Lớp học không tồn tại. Vui lòng nhập từ file csv.", "Không tìm thấy lớp", JOptionPane.INFORMATION_MESSAGE);
                    btnAddStudent.setVisible(false);
                    edtSearch.setText("");
                } else {
                    btnAddStudent.setVisible(true);
                }

                tblClassroom.setModel(new javax.swing.table.DefaultTableModel(table, TABLE_HEADER));
                initTable();
            }
        });

        btnImportCSV.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnAddStudent.setVisible(false);
                CSVImporter csvImporter = new CSVImporter();
                csvImporter.importCSV(getParent());
                if (csvImporter.getFileName() == null) return;
                classIDMain = csvImporter.getFileName();

                Vector table = csvImporter.getTable();
                dataModel.setDataVector(table,TABLE_HEADER);

                edtSearch.setText(classIDMain);
                btnSearch.setVisible(false);
                btnConfirm.setText("Xác nhận");
                btnConfirm.setVisible(true);
                isDelete = false;
                btnCancel.setVisible(true);
                tblClassroom.setModel(new javax.swing.table.DefaultTableModel(table, TABLE_HEADER));
                initTable();
            }
        });

        btnAddStudent.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Image image = new BufferedImage(1, 1, BufferedImage.TYPE_INT_ARGB);
                JOptionPane.showOptionDialog(null, new AddStudentDialog(10, edtSearch.getText()), "Thêm sinh viên", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, new ImageIcon(image), new Object[]{}, null);
                updateTable();
            }
        });

        btnConfirm.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                if (isDelete) {
                    classIDMain = edtSearch.getText();
                    String classID = "", subjectID = "";
                    if (classIDMain.contains("-")) {
                        String[] token = classIDMain.split("-");
                        classID = token[0];
                        subjectID = token[1];
                    }


                    int input = JOptionPane.showConfirmDialog(getParent(), "Bạn có chắc muốn xóa sinh viên " + tblClassroom.getValueAt(tblClassroom.getSelectedRow(), 2) + " khỏi lớp?", "Xác nhận xóa sinh viên", JOptionPane.OK_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE, null);
                    if (input == 0) {
                        if (SubjectDetailDAO.deleteSubjectDetail(SubjectDetailDAO.getSubjectDetail(new ChiTietMonHocEntityPK(classID, subjectID, tblClassroom.getValueAt(tblClassroom.getSelectedRow(), 1).toString())))) {
                            JOptionPane.showMessageDialog(getParent(), "Đã xóa sinh viên khỏi lớp.", "Xóa thành công", JOptionPane.INFORMATION_MESSAGE);
                            updateTable();

                            btnConfirm.setText("Xác nhận");
                            btnConfirm.setVisible(false);
                            isDelete = false;
                        } else {
                            JOptionPane.showMessageDialog(getParent(), "Không thể xóa sinh viên khỏi lớp.", "Xóa không thành công", JOptionPane.INFORMATION_MESSAGE);
                        }
                    }
                    return;
                }

                if (tblClassroom.isEditing())
                    tblClassroom.getCellEditor().stopCellEditing();

                classIDMain = edtSearch.getText();
                if (ClassroomDAO.getClassroom(classIDMain) != null) {
                    btnAddStudent.setVisible(true);
                    edtSearch.setEditable(true);
                    btnSearch.setVisible(true);
                    btnConfirm.setVisible(false);
                    btnCancel.setVisible(false);
                    updateTable();
                    JOptionPane.showMessageDialog(getParent(), "Lớp học đã tồn tại", "Nhập file thất bại", JOptionPane.INFORMATION_MESSAGE);
                    return;
                }

                int total = dataModel.getRowCount();
                int success = 0;

                for (int i = 0; i < dataModel.getDataVector().size(); i++) {
                    Vector<String> record = (Vector<String>) dataModel.getDataVector().get(i);
                    record.remove(0);
                    record.add(classIDMain);
                    System.out.println(record);
                    SinhVienEntity sv = new SinhVienEntity(record);
                    if (StudentDAO.addStudent(sv)){
                        success++;
                    }
                    AccountDAO.addAccount(new TaiKhoanEntity(sv.getMssv(), sv.getCmnd()));
                }

                btnAddStudent.setVisible(true);
                edtSearch.setEditable(true);
                btnSearch.setVisible(true);
                btnConfirm.setVisible(false);
                btnCancel.setVisible(false);

                // Update table
                updateTable();

                if (success == total) {
                    JOptionPane.showMessageDialog(getParent(), "Hoàn tất: " + success + "/" + total, "Nhập file thành công", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(getParent(), "Hoàn tất: " + success + "/" + total + "\nSinh viên trong danh sách đã tồn tại ở lớp khác.", "Nhập file chưa hoàn tất", JOptionPane.INFORMATION_MESSAGE);
                }
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
