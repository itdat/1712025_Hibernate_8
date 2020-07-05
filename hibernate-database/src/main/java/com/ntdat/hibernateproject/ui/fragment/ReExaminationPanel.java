package com.ntdat.hibernateproject.ui.fragment;

import com.ntdat.hibernateproject.dao.ReExaminationDAO;
import com.ntdat.hibernateproject.dao.StudentDAO;
import com.ntdat.hibernateproject.dao.SubjectDAO;
import com.ntdat.hibernateproject.dao.SubjectDetailDAO;
import com.ntdat.hibernateproject.entities.MonHocEntity;
import com.ntdat.hibernateproject.entities.PhucKhaoEntity;
import com.ntdat.hibernateproject.entities.SinhVienEntity;
import com.ntdat.hibernateproject.entities.compound.ClassSubject;
import com.ntdat.hibernateproject.ui.customcomponent.*;
import com.ntdat.hibernateproject.utilities.CSVImporter;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Vector;

public class ReExaminationPanel extends JPanel {
    private static ReExaminationPanel instance;
    // DEFINE VALUES
    private static final Font DEFAULT_FONT = new Font("Roboto", 0, 18);
    private static final Color PANEL_BACKGROUND_COLOR = new Color(88, 102, 146);
    private static final Vector<String> TABLE_HEADER = new Vector<String>(Arrays.asList("STT", "MSSV", "Họ và tên", "Môn phúc khảo", "Tình trạng"));
    private static final Vector<String> TABLE_HEADER_STUDENT = new Vector<String>(Arrays.asList("STT", "Mã môn", "Tên môn", "Lớp"));


    private DefaultTableModel dataModel = new DefaultTableModel();
    private JTable tblRequests = new JTable(dataModel);
    private FlatButton btnUpdate;
    private FlatButton btnSearch;
    private FlatButton btnConfirm;
    private FlatButton btnCancel;
    private JLabel txtTime;
    private FlatTextInput edtStartTime;
    private JLabel txtTo;
    private FlatTextInput edtEndTime;
    private RoundedPanel pnlDetails;
    private JLabel txtDetails;
    private JLabel txtStudentId;
    private FlatTextInput edtStudentId;
    private JLabel txtFullName;
    private FlatTextInput edtFullName;
    private JLabel txtSubject;
    private FlatTextInput edtSubject;
    private JLabel txtColumn;
    private FlatTextInput edtColumn;
    private JLabel txtCurrentScore;
    private FlatTextInput edtCurrentScore;
    private JLabel txtWishScore;
    private FlatTextInput edtWishScore;
    private JLabel txtReason;
    private JScrollPane scrpnlTextArea;
    private FlatTextArea txaReason;
    private FlatTextInput edtSearch;

    private boolean adminPermission = true;
    private String username;

    private ReExaminationPanel(String username) {
        this.username = username;
        if (username.equals("giaovu")) {
            this.adminPermission = true;
        } else {
            this.adminPermission = false;
        }
        initComponents();
    }

    public static ReExaminationPanel getInstance(String username) {
        if (instance == null) {
            instance = new ReExaminationPanel(username);
        }
        return instance;
    }

    public static void releaseInstance() {
        instance = null;
    }


    private void initTable() {
        tblRequests.getColumnModel().getColumn(0).setPreferredWidth(85);
        tblRequests.getColumnModel().getColumn(1).setPreferredWidth(130);
        tblRequests.getColumnModel().getColumn(2).setPreferredWidth(200);
        tblRequests.getColumnModel().getColumn(3).setPreferredWidth(210);
        tblRequests.getColumnModel().getColumn(4).setPreferredWidth(180);
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment( JLabel.CENTER );
        tblRequests.getColumnModel().getColumn(0).setCellRenderer(centerRenderer);
        tblRequests.getColumnModel().getColumn(1).setCellRenderer(centerRenderer);
        tblRequests.getColumnModel().getColumn(2).setCellRenderer(centerRenderer);
        tblRequests.getColumnModel().getColumn(3).setCellRenderer(centerRenderer);
        tblRequests.getColumnModel().getColumn(4).setCellRenderer(centerRenderer);

        JTextField textField = new JTextField();
        textField.setFont(DEFAULT_FONT);
        textField.setHorizontalAlignment(SwingConstants.CENTER);
        textField.setBorder(null);
        DefaultCellEditor customCellEditor = new DefaultCellEditor(textField);
        for (int i = 0; i < tblRequests.getColumnCount(); i++) {
            tblRequests.getColumnModel().getColumn(i).setCellEditor(customCellEditor);
        }
    }

    private void initTableStudent() {
        tblRequests.getColumnModel().getColumn(0).setPreferredWidth(85);
        tblRequests.getColumnModel().getColumn(1).setPreferredWidth(210);
        tblRequests.getColumnModel().getColumn(2).setPreferredWidth(210);
        tblRequests.getColumnModel().getColumn(3).setPreferredWidth(180);
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment( JLabel.CENTER );
        tblRequests.getColumnModel().getColumn(0).setCellRenderer(centerRenderer);
        tblRequests.getColumnModel().getColumn(1).setCellRenderer(centerRenderer);
        tblRequests.getColumnModel().getColumn(2).setCellRenderer(centerRenderer);
        tblRequests.getColumnModel().getColumn(3).setCellRenderer(centerRenderer);

        JTextField textField = new JTextField();
        textField.setFont(DEFAULT_FONT);
        textField.setHorizontalAlignment(SwingConstants.CENTER);
        textField.setBorder(null);
        DefaultCellEditor customCellEditor = new DefaultCellEditor(textField);
        for (int i = 0; i < tblRequests.getColumnCount(); i++) {
            tblRequests.getColumnModel().getColumn(i).setCellEditor(customCellEditor);
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
        tblRequests.setModel(new javax.swing.table.DefaultTableModel(table, adminPermission?TABLE_HEADER:TABLE_HEADER_STUDENT));
        if (adminPermission) {
            initTable();
        } else {
            initTableStudent();
        }

    }

    private void initComponents() {
        setBackground(PANEL_BACKGROUND_COLOR);
        setSize(1280,768);
        setVisible(true);

        edtSearch = new FlatTextInput();

        btnSearch = new FlatButton();
        btnSearch.setText("Tìm kiếm");

        btnConfirm = new FlatButton();
        btnConfirm.setText("Xác nhận");

        btnCancel = new FlatButton();
        btnCancel.setText("Hủy bỏ");

        btnUpdate = new FlatButton();
        btnUpdate.setText("Cập nhật");

        txtTime = new JLabel();
        txtTime.setFont(DEFAULT_FONT);
        txtTime.setForeground(Color.WHITE);
        txtTime.setText("Thời gian phúc khảo:");

        edtStartTime = new FlatTextInput();
        edtStartTime.setFont(DEFAULT_FONT);
        edtStartTime.setToolTipText("");

        txtTo = new JLabel();
        txtTo.setFont(DEFAULT_FONT);
        txtTo.setForeground(Color.WHITE);
        txtTo.setText("-");

        edtEndTime = new FlatTextInput();
        edtEndTime.setFont(DEFAULT_FONT);
        edtEndTime.setToolTipText("");

        txtDetails = new JLabel();
        txtDetails.setFont(new Font("Roboto", 1, 24));
        txtDetails.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtDetails.setText("Thông tin chi tiết");

        edtStudentId = new FlatTextInput();
        edtStudentId.setFont(DEFAULT_FONT);
        edtStudentId.setToolTipText("");

        txtStudentId = new JLabel();
        txtStudentId.setFont(DEFAULT_FONT);
        txtStudentId.setText("MSSV");

        txtFullName = new JLabel();
        txtFullName.setFont(DEFAULT_FONT);
        txtFullName.setText("Họ và tên");

        edtFullName = new FlatTextInput();
        edtFullName.setFont(DEFAULT_FONT);
        edtFullName.setToolTipText("");

        txtSubject = new JLabel();
        txtSubject.setFont(DEFAULT_FONT);
        txtSubject.setText("Môn phúc khảo");

        edtSubject = new FlatTextInput();
        edtSubject.setFont(DEFAULT_FONT);
        edtSubject.setToolTipText("");

        edtColumn = new FlatTextInput("Chọn vào đây");
        edtColumn.setFont(DEFAULT_FONT);

        txtColumn = new JLabel();
        txtColumn.setFont(DEFAULT_FONT);
        txtColumn.setText("Cột điểm phúc khảo");

        txtCurrentScore = new JLabel();
        txtCurrentScore.setFont(DEFAULT_FONT);
        txtCurrentScore.setText("Điểm hiện tại");

        edtCurrentScore = new FlatTextInput();
        edtCurrentScore.setFont(DEFAULT_FONT);
        edtCurrentScore.setToolTipText("");

        edtWishScore = new FlatTextInput();
        edtWishScore.setFont(DEFAULT_FONT);
        edtWishScore.setToolTipText("");

        txtWishScore = new JLabel();
        txtWishScore.setFont(DEFAULT_FONT);
        txtWishScore.setText("Điểm mong muốn");

        txtReason = new JLabel();
        txtReason.setFont(DEFAULT_FONT);
        txtReason.setText("Lí do");

        JScrollPane scrpnlTable = new JScrollPane();
        scrpnlTable.getVerticalScrollBar().setUI(new MyScrollbarUI());

        tblRequests = new javax.swing.JTable();
        tblRequests.getTableHeader().setDefaultRenderer(new HeaderRenderer());
        tblRequests.setFont(DEFAULT_FONT);

        scrpnlTextArea = new javax.swing.JScrollPane();
        scrpnlTextArea.getVerticalScrollBar().setUI(new MyScrollbarUI());
        scrpnlTextArea.getHorizontalScrollBar().setUI(new MyScrollbarUI());
        scrpnlTextArea.setBorder(null);
        scrpnlTextArea.setOpaque(false);

        Border border = BorderFactory.createLineBorder(new Color(23,55,212));
        txaReason = new FlatTextArea();
        txaReason.setBorder(BorderFactory.createCompoundBorder(border,
                BorderFactory.createEmptyBorder(10, 10, 10, 10)));
        txaReason.setColumns(20);
        txaReason.setFont(DEFAULT_FONT);
        txaReason.setLineWrap(true);
        txaReason.setRows(5);
        txaReason.setToolTipText("");
        scrpnlTextArea.setViewportView(txaReason);

        edtSearch = new FlatTextInput();
        edtSearch.setFont(DEFAULT_FONT);
        edtSearch.setToolTipText("");

        final List<PhucKhaoEntity> phucKhaoEntityList = ReExaminationDAO.getReExaminations();
        Vector table = new Vector();
        if (adminPermission) {
            for (int i = 0; i < phucKhaoEntityList.size(); i++) {
                Vector record = new Vector();
                record.add(String.valueOf(i+1));
                record.add(phucKhaoEntityList.get(i).getMssv());
                SinhVienEntity s = StudentDAO.getStudent(phucKhaoEntityList.get(i).getMssv());
                record.add(s.getHoVaTen());
                MonHocEntity m = SubjectDAO.getSubject(phucKhaoEntityList.get(i).getMaMon());
                record.add(m.getTenMon());
                record.add(phucKhaoEntityList.get(i).getTinhTrang());
                table.add(record);
            }
        } else {
            List<ClassSubject> classSubjectList = SubjectDAO.getClassSubjectsStudent(username);
            for (int i = 0; i < classSubjectList.size(); i++) {
                Vector record = new Vector();
                record.add(String.valueOf(i+1));
                record.add(classSubjectList.get(i).getId());
                record.add(classSubjectList.get(i).getName());
                record.add(classSubjectList.get(i).getClassID());
                table.add(record);
            }
        }


        tblRequests.setModel(new javax.swing.table.DefaultTableModel(table, adminPermission?TABLE_HEADER:TABLE_HEADER_STUDENT));
        tblRequests.setDragEnabled(true);
        tblRequests.setFocusable(false);
        tblRequests.setRowHeight(40);
        tblRequests.setSelectionBackground(new Color(129, 150, 204));
        tblRequests.setSelectionForeground(new Color(0, 0, 0));
        tblRequests.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        scrpnlTable.setViewportView(tblRequests);
        if (adminPermission) {
            initTable();
        } else {
            initTableStudent();
        }


        if (!adminPermission) {
            edtFullName.setText(StudentDAO.getStudent(username).getHoVaTen());
            edtFullName.setEnabled(false);
            edtStudentId.setText(username);
            edtStudentId.setEnabled(false);
            edtColumn.setEnabled(false);

            txtTime.setVisible(false);
            txtTo.setVisible(false);
            edtStartTime.setVisible(false);
            edtEndTime.setVisible(false);
            btnUpdate.setVisible(false);
            btnSearch.setVisible(false);
            edtSearch.setVisible(false);
        }

        tblRequests.getSelectionModel().addListSelectionListener(new ListSelectionListener(){
            public void valueChanged(ListSelectionEvent event) {
                if (adminPermission) {
                    PhucKhaoEntity pk = phucKhaoEntityList.get(Integer.valueOf(tblRequests.getValueAt(tblRequests.getSelectedRow(), 0).toString()) -1);
                    edtStudentId.setText(tblRequests.getValueAt(tblRequests.getSelectedRow(), 1).toString());
                    edtFullName.setText(tblRequests.getValueAt(tblRequests.getSelectedRow(), 2).toString());
                    edtSubject.setText(tblRequests.getValueAt(tblRequests.getSelectedRow(), 3).toString());
                    edtColumn.setText(pk.getCotDiem());
                    edtWishScore.setText(Float.toString((float) pk.getDiemMongMuon()));
                    txaReason.setText(pk.getLiDo());
                    edtStudentId.setEnabled(false);
                    edtFullName.setEnabled(false);
                    edtSubject.setEnabled(false);
                    edtColumn.setEnabled(false);
                    edtWishScore.setEnabled(false);
                    txaReason.setEnabled(false);
                } else {
                    edtSubject.setText(tblRequests.getValueAt(tblRequests.getSelectedRow(), 2).toString());
                    String subjectID = tblRequests.getValueAt(tblRequests.getSelectedRow(), 1).toString();
                    String classID = tblRequests.getValueAt(tblRequests.getSelectedRow(), 3).toString();
                    edtCurrentScore.setText(SubjectDetailDAO.getSubjectDetailStudent(username, subjectID, classID).getDiemTong().toString());
                    edtSubject.setEnabled(false);
                    edtCurrentScore.setEnabled(false);
                }
            }
        });

        edtColumn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                if (!adminPermission) {
                    String options[] = {"Giữa kỳ", "Cuối kỳ", "Điểm khác"};
                    int input = JOptionPane.showOptionDialog(null, "Chọn cột điểm muốn phúc khảo:", "Chọn cột điểm", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);
                    switch (input) {
                        case 0:
                            edtColumn.setText("GK");
                            break;
                        case 1:
                            edtColumn.setText("CK");
                            break;
                        case 2:
                            edtColumn.setText("Khac");
                            break;
                    }
                }
            }
        });

        btnConfirm.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                if (!adminPermission) {
                    String subjectID = tblRequests.getValueAt(tblRequests.getSelectedRow(), 1).toString();
                    System.out.printf(edtWishScore.getText());
                    if (ReExaminationDAO.addReExamination(new PhucKhaoEntity(edtStudentId.getText(), subjectID, edtColumn.getText(), Float.parseFloat(edtWishScore.getText()), txaReason.getText(), "chua xem"))) {
                        JOptionPane.showMessageDialog(getParent(), "Đơn phúc khảo đã được gửi đi. Vui lòng đợi cập nhật.", "Gửi phúc khảo thành công", JOptionPane.INFORMATION_MESSAGE);
                    } else {
                        JOptionPane.showMessageDialog(getParent(), "Có lỗi xảy ra. Vui lòng thử lại sau", "Gửi thất bại", JOptionPane.INFORMATION_MESSAGE);

                    }
                }
            }
        });

        pnlDetails = new RoundedPanel(10);
        pnlDetails.setBackground(new Color(239, 239, 239));
        javax.swing.GroupLayout pnlDetailsLayout = new javax.swing.GroupLayout(pnlDetails);
        pnlDetails.setLayout(pnlDetailsLayout);
        pnlDetailsLayout.setHorizontalGroup(
                pnlDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(pnlDetailsLayout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(pnlDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(txtDetails, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(edtFullName)
                                        .addComponent(edtColumn)
                                        .addComponent(edtWishScore)
                                        .addComponent(scrpnlTextArea, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                                        .addComponent(edtCurrentScore)
                                        .addComponent(edtSubject)
                                        .addComponent(edtStudentId)
                                        .addGroup(pnlDetailsLayout.createSequentialGroup()
                                                .addGroup(pnlDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(txtStudentId)
                                                        .addComponent(txtFullName)
                                                        .addComponent(txtSubject)
                                                        .addComponent(txtColumn)
                                                        .addComponent(txtCurrentScore)
                                                        .addComponent(txtWishScore)
                                                        .addComponent(txtReason))
                                                .addGap(0, 0, Short.MAX_VALUE)))
                                .addContainerGap())
        );
        pnlDetailsLayout.setVerticalGroup(
                pnlDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(pnlDetailsLayout.createSequentialGroup()
                                .addGap(5, 5, 5)
                                .addComponent(txtDetails)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtStudentId)
                                .addGap(4, 4, 4)
                                .addComponent(edtStudentId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtFullName)
                                .addGap(4, 4, 4)
                                .addComponent(edtFullName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtSubject)
                                .addGap(4, 4, 4)
                                .addComponent(edtSubject, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtColumn)
                                .addGap(4, 4, 4)
                                .addComponent(edtColumn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtCurrentScore)
                                .addGap(4, 4, 4)
                                .addComponent(edtCurrentScore, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtWishScore)
                                .addGap(4, 4, 4)
                                .addComponent(edtWishScore, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtReason)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(scrpnlTextArea, javax.swing.GroupLayout.DEFAULT_SIZE, 113, Short.MAX_VALUE)
                                .addContainerGap())
        );

        javax.swing.GroupLayout mainPanelLayout = new javax.swing.GroupLayout(this);
        this.setLayout(mainPanelLayout);
        mainPanelLayout.setHorizontalGroup(
                mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(mainPanelLayout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(mainPanelLayout.createSequentialGroup()
                                                .addGap(6, 6, 6)
                                                .addComponent(txtTime)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(edtStartTime, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(txtTo)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(edtEndTime, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(btnUpdate)
                                                .addGap(63, 63, 63)
                                                .addComponent(edtSearch)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(btnSearch)
                                                .addGap(9, 9, 9))
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, mainPanelLayout.createSequentialGroup()
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 868, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(btnCancel)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(btnConfirm)
                                                .addGap(10, 10, 10))
                                        .addGroup(mainPanelLayout.createSequentialGroup()
                                                .addComponent(scrpnlTable, javax.swing.GroupLayout.PREFERRED_SIZE, 826, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(pnlDetails, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                .addContainerGap())
        );
        mainPanelLayout.setVerticalGroup(
                mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(mainPanelLayout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(btnSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(txtTime)
                                        .addComponent(edtStartTime, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(txtTo)
                                        .addComponent(btnUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(edtEndTime, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(edtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(12, 12, 12)
                                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(scrpnlTable)
                                        .addComponent(pnlDetails, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(9, 9, 9)
                                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(btnConfirm)
                                        .addComponent(btnCancel))
                                .addContainerGap())
        );
    }
}
