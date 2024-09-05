package utils;

import Views.AlertView;
import Views.NotificationVIew;
import controllers.UserNotificationController;
import javax.swing.*;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableCellEditor;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Map;

public class ButtonRendererEditor extends AbstractCellEditor implements TableCellRenderer, TableCellEditor {

    private final JButton renderButton;
    private final JButton editButton;
    private String currentText;

    public ButtonRendererEditor(JTable table, NotificationVIew notificationView) {
        UserNotificationController userNotification = new UserNotificationController();

        renderButton = new JButton("Acción");
        editButton = new JButton("Acción");

        editButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                java.util.List<Map<String, Object>> notificationData = new ArrayList<>();
                int selectedRow = table.getSelectedRow();
                if (selectedRow >= 0) {
                    String id = (String) table.getValueAt(selectedRow, 0);
                    notificationData = userNotification.getNotification(Integer.valueOf(id));
                    if (notificationData != null) {
                        for (Map<String, Object> notification : notificationData) {
                            String message = (String) notification.get("message");
                            notificationView.printAlert(message);
                            userNotification.updateNotification(Integer.valueOf(id), "leido");
                            notificationView.fillTable();
                        }
                    }
                }
                fireEditingStopped();
            }
        });
    }

    @Override
    public Object getCellEditorValue() {
        return currentText;
    }

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        if (value != null) {
            currentText = value.toString();
        }
        return renderButton;
    }

    @Override
    public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
        if (value != null) {
            currentText = value.toString();
        }
        return editButton;
    }
}
