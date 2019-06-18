package app.Elements;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;

import material.graphs.Vertex;
import simulator.Simulator;
import objects.Node;

public class HostTable extends AbstractTableModel {

    private JTable table;
    private JScrollPane scrollPane;
    private Object[][] rowData;
    private String[] columnNames;

    public HostTable() {

    }

    public HostTable(Simulator simulator, Vertex<Node> vh) {
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
            //table.setBackground(Color.GREEN);
            table.updateUI();
            scrollPane = new JScrollPane(table);
            //scrollPane.setBackground(Color.orange);
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

    /*
	 * public void updateUI(){ super.updateUI(); if (vh != null) { Object
	 * rowData[][] = new Object[vh.getElement().getQueuePackages().size()][4];
	 * Object columnNames[] = { "Paquete ID", "Tama�o", "Tiempo", "Destino" };
	 * int j = 0; for (objects.Package p : vh.getElement().getQueuePackages()) {
	 * rowData[j][0] = "package " + p.getId(); rowData[j][1] = "" + p.getSize();
	 * rowData[j][2] = "" + p.getTime(); rowData[j][3] = "" +
	 * p.getDestinationHost().getElement().getName(); j++; } table = new
	 * JTable(rowData, columnNames); table.setBackground(Color.GREEN);
	 * scrollPane = new JScrollPane(table);
	 * scrollPane.setBackground(Color.orange); } else { Object rowData[][] = new
	 * Object[0][4]; Object columnNames[] = { "Paquete ID", "Tama�o", "Tiempo",
	 * "Destino" }; table = new JTable(rowData, columnNames); scrollPane = new
	 * JScrollPane(table); }
	 * 
	 * }
     */
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

    public int getColumnCount() {
        return columnNames.length;
    }

    public int getRowCount() {
        return rowData.length;
    }

    public String getColumnName(int col) {
        return columnNames[col];
    }

    public Object getValueAt(int row, int col) {
        return rowData[row][col];
    }

}
