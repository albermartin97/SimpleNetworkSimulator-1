package app.Elements;

import java.util.List;

import javax.swing.DefaultCellEditor;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableColumn;

import material.graphs.Edge;
import material.graphs.Vertex;
import simulator.Simulator;
import objects.Node;

public class NodeTable extends AbstractTableModel {

    private JTable table;
    private Object[][] rowData;
    private String[] columnNames;

    public NodeTable() {

    }

    public NodeTable(Simulator simulator) {
        java.util.ResourceBundle bundle = java.util.ResourceBundle.getBundle("app/Windows/Bundle");
        if (simulator != null) {
            List<Vertex<Node>> vhListComputers = simulator.getRed()
                    .getAllHosts();
            List<Vertex<Node>> vhListRouters = simulator.getRed()
                    .getAllRouters();
            String[] linkers = new String[simulator.getRed().getRed().edges()
                    .size()];
            int i = 0;
            for (Edge<objects.Linker> eL : simulator.getRed().getRed().edges()) {
                linkers[i] = eL.getElement().getIp();
                i++;
            }
            rowData = new Object[vhListComputers.size()][vhListRouters.size() + 1];
            columnNames = new String[vhListRouters.size() + 1];
            columnNames[0] = "Hosts";
            i = 0;
            int j = 1;

            for (Vertex<Node> vHC : vhListComputers) {
                rowData[i][0] = vHC.getElement().getName();
                for (Vertex<Node> vHR : vhListRouters) {
                    columnNames[j] = vHR.getElement().getName();
                    j++;
                }
                j = 1;
                i++;
            }
            table = new JTable(rowData, columnNames);
            JComboBox<String> comboBox = new JComboBox<>(linkers);
            TableColumn column = table.getColumnModel().getColumn(1);
            column.setCellEditor(new DefaultCellEditor(comboBox));
            DefaultTableCellRenderer renderer = new DefaultTableCellRenderer();
            renderer.setToolTipText(bundle.getString("ChooseLinker"));
            column.setCellRenderer(renderer);
        }

    }

    public void setUpSportColumn(TableColumn sportColumn, String[] linkers) {
        java.util.ResourceBundle bundle = java.util.ResourceBundle.getBundle("app/Windows/Bundle");
        JComboBox comboBox = new JComboBox(linkers);
        sportColumn.setCellEditor(new DefaultCellEditor(comboBox));
        DefaultTableCellRenderer renderer = new DefaultTableCellRenderer();
        renderer.setToolTipText(bundle.getString("ChooseLinker"));
        sportColumn.setCellRenderer(renderer);
    }

    public JTable getTable() {
        return table;
    }

    public void setTable(JTable table) {
        this.table = table;
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
