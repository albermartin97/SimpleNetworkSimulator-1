package app.Elements;

import java.awt.Graphics;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;

import material.graphs.Vertex;
import objects.Node;

public class HostTable extends AbstractTableModel {

    private JTable table;
    private JScrollPane scrollPane;
    private Object[][] rowData;
    private String[] columnNames;

    public HostTable() {

    }

    public HostTable(Vertex<Node> vh) {
        java.util.ResourceBundle bundle = java.util.ResourceBundle.getBundle("app/Windows/Bundle");
        if (vh != null) {
            rowData = new Object[vh.getElement().getQueuePackages().size()][4];
            String columnNames[] = {bundle.getString("IDPackage"), bundle.getString("Size"), bundle.getString("Time"),
                bundle.getString("Destination")};
            this.columnNames = columnNames;
            int j = 0;
            for (objects.Package p : vh.getElement().getQueuePackages()) {
                rowData[j][0] = "package " + p.getId();
                rowData[j][1] = "" + p.getSize();
                rowData[j][2] = "" + p.getTime();
                rowData[j][3] = ""
                        + p.getDestinationHost().getElement().getName();
                j++;
            }
            table = new JTable(rowData, this.columnNames);
            table.updateUI();
            scrollPane = new JScrollPane(table);
            scrollPane.updateUI();
        } else {
            rowData = new Object[0][4];
            String columnNames[] = {bundle.getString("IDPackage"), bundle.getString("Size"), bundle.getString("Time"),
                bundle.getString("Destination")};
            this.columnNames = columnNames;
            table = new JTable(rowData, this.columnNames);
            scrollPane = new JScrollPane(table);
        }
    }

    public void paint(Graphics g) {
        this.table.paint(g);
        this.scrollPane.paint(g);
    }

    public void setValueAt(Object value, int row, int col) {
        rowData[row][col] = value;
        fireTableCellUpdated(row, col);
    }

    public JTable getTable() {
        return table;
    }

    public void setTable(JTable table) {
        this.table = table;
    }

    public JScrollPane getScrollPane() {
        return scrollPane;
    }

    public void setScrollPane(JScrollPane scrollPane) {
        this.scrollPane = scrollPane;
    }

    @Override
    public int getColumnCount() {
        return columnNames.length;
    }

    @Override
    public int getRowCount() {
        return rowData.length;
    }

    @Override
    public String getColumnName(int col) {
        return columnNames[col];
    }

    @Override
    public Object getValueAt(int row, int col) {
        return rowData[row][col];
    }

}
