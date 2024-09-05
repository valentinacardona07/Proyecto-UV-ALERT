package Views;

import utils.Constants;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.swing.table.DefaultTableModel;
import controllers.UserNotificationController;
import java.awt.Dialog;
import utils.ButtonRendererEditor;

public class NotificationVIew extends javax.swing.JPanel {

    AlertView alert = new AlertView();
    private DefaultTableModel tableModel;
    private int user_id;

    public NotificationVIew(int user_id) {
        this.user_id = user_id;

        String[] columnNames = {"Id", "Fecha", "Mensaje", "Estado", "Acciones"};

        tableModel = new DefaultTableModel(columnNames, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return column == 4;
            }
        };
        initComponents();
        fillTable();
    }

    public void fillTable() {
        List<Map<String, Object>> notificationData = new ArrayList<>();
        UserNotificationController userNotification = new UserNotificationController();
        notificationData = userNotification.getAllNotification(user_id);
        tableModel.setRowCount(0);
        if (notificationData != null) {
            for (Map<String, Object> notification : notificationData) {
                String id = notification.get("id").toString();
                String date = notification.get("date").toString();
                String message = (String) notification.get("message");
                String state = (String) notification.get("state");
                Object[] row = {id, date, message, state};
                tableModel.addRow(row);
            }

            table.getColumnModel().getColumn(4).setCellRenderer(new ButtonRendererEditor(table, this));
            table.getColumnModel().getColumn(4).setCellEditor(new ButtonRendererEditor(table, this));
        }
    }

    public void deleteSelectedRow() {
        UserNotificationController userNotification = new UserNotificationController();
        String message = "";
        int selectedRow = table.getSelectedRow();
        if (selectedRow >= 0) {
            String id = (String) table.getValueAt(selectedRow, 0);
            String key = userNotification.deleteNotification(Integer.valueOf(id));
            String notification = Constants.get_message(key);
            printAlert(notification);
            fillTable();
        } else {
            printAlert("<html>Por favor, seleccione una fila para eliminar.</html>");
        }
    }

    public void printAlert(String message) {
        alert.dispose();
        alert.setMessage(message);
        alert.setModalExclusionType(Dialog.ModalExclusionType.APPLICATION_EXCLUDE); // Evita que la alerta sea modal respecto a la ventana modal
        alert.setAlwaysOnTop(true); // Asegura que la alerta esté siempre en primer plano
        alert.setVisible(true);
        alert.setLocationRelativeTo(this);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane2 = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();
        refresh = new javax.swing.JButton();
        delete = new javax.swing.JButton();
        deleteAll = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 255, 255));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        table.setBackground(new java.awt.Color(255, 255, 255));
        table.setFont(new java.awt.Font("Gadugi", 0, 12)); // NOI18N
        table.setForeground(new java.awt.Color(1, 46, 67));
        table.setModel(tableModel);
        table.setToolTipText("");
        table.setFillsViewportHeight(true);
        jScrollPane2.setViewportView(table);

        add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 20, -1, 300));

        refresh.setBackground(new java.awt.Color(141, 251, 211));
        refresh.setFont(new java.awt.Font("Gadugi", 1, 12)); // NOI18N
        refresh.setForeground(new java.awt.Color(51, 51, 51));
        refresh.setText("REFRESCAR");
        refresh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                refreshActionPerformed(evt);
            }
        });
        add(refresh, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 330, -1, -1));

        delete.setBackground(new java.awt.Color(141, 251, 211));
        delete.setFont(new java.awt.Font("Gadugi", 1, 12)); // NOI18N
        delete.setForeground(new java.awt.Color(51, 51, 51));
        delete.setText("ELIMINAR");
        delete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteActionPerformed(evt);
            }
        });
        add(delete, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 330, -1, -1));

        deleteAll.setBackground(new java.awt.Color(141, 251, 211));
        deleteAll.setFont(new java.awt.Font("Gadugi", 1, 12)); // NOI18N
        deleteAll.setForeground(new java.awt.Color(51, 51, 51));
        deleteAll.setText("ELIMINAR TODO");
        deleteAll.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteAllActionPerformed(evt);
            }
        });
        add(deleteAll, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 330, -1, -1));
    }// </editor-fold>//GEN-END:initComponents

    private void deleteAllActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteAllActionPerformed
        UserNotificationController userNotification = new UserNotificationController();
        String key = userNotification.deleteAllNotification();
        String notification = Constants.get_message(key);
        printAlert(notification);
        fillTable();
    }//GEN-LAST:event_deleteAllActionPerformed

    private void refreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_refreshActionPerformed
        fillTable();
    }//GEN-LAST:event_refreshActionPerformed

    private void deleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteActionPerformed
        deleteSelectedRow();
    }//GEN-LAST:event_deleteActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton delete;
    private javax.swing.JButton deleteAll;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JButton refresh;
    private javax.swing.JTable table;
    // End of variables declaration//GEN-END:variables

}
