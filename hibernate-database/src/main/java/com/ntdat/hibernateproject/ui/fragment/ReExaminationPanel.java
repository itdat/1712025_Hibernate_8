package com.ntdat.hibernateproject.ui.fragment;

import com.ntdat.hibernateproject.ui.customcomponent.*;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableCellRenderer;
import java.awt.*;

public class ReExaminationPanel extends JPanel {
    private JScrollPane scrpnlTable;
    private JTable tblRequests;
    private FlatButton btnSearch;
    private FlatButton btnImportCSV;
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

    public ReExaminationPanel() {
        initComponents();
    }

    private void initComponents() {
        setBackground(new Color(88, 102, 146));
        setSize(1280,768);
        setVisible(true);
        scrpnlTable = new javax.swing.JScrollPane();
        tblRequests = new javax.swing.JTable();
        btnSearch = new FlatButton(new Color(58,66,129), new Color(30,34,82), new Color(36,55,114));
        btnImportCSV = new FlatButton(new Color(58,66,129), new Color(30,34,82), new Color(36,55,114));
        btnConfirm = new FlatButton(new Color(58,66,129), new Color(30,34,82), new Color(36,55,114));
        btnCancel = new FlatButton(new Color(58,66,129), new Color(30,34,82), new Color(71,83,114));
        txtTime = new JLabel();
        edtStartTime = new FlatTextInput();
        txtTo = new JLabel();
        edtEndTime = new FlatTextInput();

        pnlDetails = new RoundedPanel(10);

        txtDetails = new JLabel();
        txtStudentId = new JLabel();
        edtStudentId = new FlatTextInput();
        txtFullName = new JLabel();
        edtFullName = new FlatTextInput();
        txtSubject = new JLabel();
        edtSubject = new FlatTextInput();
        txtColumn = new JLabel();
        edtColumn = new FlatTextInput();
        txtCurrentScore = new JLabel();
        edtCurrentScore = new FlatTextInput();
        txtWishScore = new JLabel();
        edtWishScore = new FlatTextInput();

        txtReason = new JLabel();
        scrpnlTextArea = new javax.swing.JScrollPane();
        txaReason = new FlatTextArea();
        edtSearch = new FlatTextInput();

        scrpnlTable.getVerticalScrollBar().setUI(new MyScrollbarUI());
        tblRequests.getTableHeader().setDefaultRenderer(new HeaderRenderer());
        tblRequests.setFont(new Font("Roboto", 0, 18)); // NOI18N
        tblRequests.setModel(new javax.swing.table.DefaultTableModel(
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
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment( JLabel.CENTER );
        //tblRequests.setDefaultRenderer(String.class, centerRenderer);
        tblRequests.getColumnModel().getColumn(0).setCellRenderer(centerRenderer);
        tblRequests.getColumnModel().getColumn(1).setCellRenderer(centerRenderer);
        tblRequests.getColumnModel().getColumn(2).setCellRenderer(centerRenderer);
        tblRequests.getColumnModel().getColumn(3).setCellRenderer(centerRenderer);
        tblRequests.getColumnModel().getColumn(4).setCellRenderer(centerRenderer);
        tblRequests.getColumnModel().getColumn(5).setCellRenderer(centerRenderer);
        tblRequests.getColumnModel().getColumn(6).setCellRenderer(centerRenderer);
        tblRequests.setDragEnabled(true);
        tblRequests.setFocusable(false);
        tblRequests.setRowHeight(40);
        tblRequests.setSelectionBackground(new Color(129, 150, 204));
        tblRequests.setSelectionForeground(new Color(0, 0, 0));
        tblRequests.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        scrpnlTable.setViewportView(tblRequests);
        if (tblRequests.getColumnModel().getColumnCount() > 0) {
            tblRequests.getColumnModel().getColumn(0).setPreferredWidth(85);
            tblRequests.getColumnModel().getColumn(1).setPreferredWidth(170);
            tblRequests.getColumnModel().getColumn(2).setPreferredWidth(290);
            tblRequests.getColumnModel().getColumn(3).setPreferredWidth(128);
            tblRequests.getColumnModel().getColumn(4).setPreferredWidth(128);
            tblRequests.getColumnModel().getColumn(5).setPreferredWidth(128);
            tblRequests.getColumnModel().getColumn(6).setPreferredWidth(128);
        }

        btnSearch.setFont(new Font("Roboto", 0, 18)); // NOI18N
        btnSearch.setText("Tìm kiếm");

        btnImportCSV.setFont(new Font("Roboto", 0, 18)); // NOI18N
        btnImportCSV.setText("Cập nhật");

        btnConfirm.setFont(new Font("Roboto", 0, 18)); // NOI18N
        btnConfirm.setText("Xác nhận");

        btnCancel.setFont(new Font("Roboto", 0, 18)); // NOI18N
        btnCancel.setText("Hủy bỏ");

        txtTime.setFont(new Font("Roboto", 0, 18)); // NOI18N
        txtTime.setForeground(new Color(255, 255, 255));
        txtTime.setText("Thời gian phúc khảo:");

        edtStartTime.setFont(new Font("Roboto", 0, 18)); // NOI18N
        edtStartTime.setToolTipText("");

        txtTo.setFont(new Font("Roboto", 0, 18)); // NOI18N
        txtTo.setForeground(new Color(255, 255, 255));
        txtTo.setText("-");

        edtEndTime.setFont(new Font("Roboto", 0, 18)); // NOI18N
        edtEndTime.setToolTipText("");

        pnlDetails.setBackground(new Color(239, 239, 239));

        txtDetails.setFont(new Font("Roboto", 1, 24)); // NOI18N
        txtDetails.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtDetails.setText("Thông tin chi tiết");

        edtStudentId.setFont(new Font("Roboto", 0, 18)); // NOI18N
        edtStudentId.setToolTipText("");

        txtStudentId.setFont(new Font("Roboto", 0, 18)); // NOI18N
        txtStudentId.setText("MSSV");

        txtFullName.setFont(new Font("Roboto", 0, 18)); // NOI18N
        txtFullName.setText("Họ và tên");

        edtFullName.setFont(new Font("Roboto", 0, 18)); // NOI18N
        edtFullName.setToolTipText("");

        txtSubject.setFont(new Font("Roboto", 0, 18)); // NOI18N
        txtSubject.setText("Môn phúc khảo");

        edtSubject.setFont(new Font("Roboto", 0, 18)); // NOI18N
        edtSubject.setToolTipText("");

        edtColumn.setFont(new Font("Roboto", 0, 18)); // NOI18N
        edtColumn.setToolTipText("");

        txtColumn.setFont(new Font("Roboto", 0, 18)); // NOI18N
        txtColumn.setText("Cột điểm phúc khảo");

        txtCurrentScore.setFont(new Font("Roboto", 0, 18)); // NOI18N
        txtCurrentScore.setText("Điểm hiện tại");

        edtCurrentScore.setFont(new Font("Roboto", 0, 18)); // NOI18N
        edtCurrentScore.setToolTipText("");

        edtWishScore.setFont(new Font("Roboto", 0, 18)); // NOI18N
        edtWishScore.setToolTipText("");

        txtWishScore.setFont(new Font("Roboto", 0, 18)); // NOI18N
        txtWishScore.setText("Điểm mong muốn");

        txtReason.setFont(new Font("Roboto", 0, 18)); // NOI18N
        txtReason.setText("Lí do");

        scrpnlTextArea.getVerticalScrollBar().setUI(new MyScrollbarUI());
        scrpnlTextArea.getHorizontalScrollBar().setUI(new MyScrollbarUI());
        scrpnlTextArea.setBorder(null);
        scrpnlTextArea.setOpaque(false);

        //txaReason.setBorder(BorderFactory.createCompoundBorder(txaReason.getBorder(), BorderFactory.createEmptyBorder(5, 5, 5, 5)));
        Border border = BorderFactory.createLineBorder(new Color(23,55,212));
        txaReason.setBorder(BorderFactory.createCompoundBorder(border,
                BorderFactory.createEmptyBorder(10, 10, 10, 10)));
        txaReason.setColumns(20);
        txaReason.setFont(new Font("Roboto", 0, 18)); // NOI18N
        txaReason.setLineWrap(true);
        txaReason.setRows(5);
        txaReason.setToolTipText("");
        scrpnlTextArea.setViewportView(txaReason);

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

        edtSearch.setFont(new Font("Roboto", 0, 18)); // NOI18N
        edtSearch.setToolTipText("");

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
                                                .addComponent(btnImportCSV)
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
                                        .addComponent(btnImportCSV, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(txtTime)
                                        .addComponent(edtStartTime, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(txtTo)
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
