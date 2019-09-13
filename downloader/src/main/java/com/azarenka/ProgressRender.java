package com.azarenka;

import java.awt.Component;

import javax.swing.JProgressBar;
import javax.swing.JTable;
import javax.swing.table.TableCellRenderer;

public class ProgressRender extends JProgressBar implements TableCellRenderer {

    public ProgressRender(int min, int max) {
        super(min, max);
    }

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus,
                                                   int row, int column) {
        setValue((int) ((Float) value).floatValue());
        return this;
    }
}
