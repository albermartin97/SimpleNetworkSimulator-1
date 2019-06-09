package app.Elements;

import java.awt.Color;
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
    //private JScrollPane scrollPane;
    private Object[][] rowData;
    private String[] columnNames;

    public NodeTable() {

    }

    public NodeTable(Simulator simulator) {
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
                    //
                    //setUpSportColumn(table, table.getColumnModel().getColumn(j));
                    //rowData[i][j] = comboBox;
                    j++;
                }
                j = 1;
                i++;
            }
            table = new JTable(rowData, columnNames);
            //table.setBackground(Color.GREEN);
            JComboBox<String> comboBox = new JComboBox<>(linkers);
            TableColumn column = table.getColumnModel().getColumn(1);
            column.setCellEditor(new DefaultCellEditor(comboBox));
            DefaultTableCellRenderer renderer = new DefaultTableCellRenderer();
            renderer.setToolTipText("Click for combo box");
            column.setCellRenderer(renderer);
            /*scrollPane = new JScrollPane(table);
            scrollPane.setBackground(Color.orange);
            scrollPane.updateUI();*/
            // frame.add(scrollPane, BorderLayout.CENTER);
        }

    }

    public void setUpSportColumn(JTable table, TableColumn sportColumn, String[] linkers) {
        // Set up the editor for the sport cells.
        JComboBox comboBox = new JComboBox(linkers);
        sportColumn.setCellEditor(new DefaultCellEditor(comboBox));
        // Set up tool tips for the sport cells.
        DefaultTableCellRenderer renderer = new DefaultTableCellRenderer();
        renderer.setToolTipText("Click for combo box");
        sportColumn.setCellRenderer(renderer);
    }
    
    public JTable getTable() {
        return table;
    }

    public void setTable(JTable table) {
        this.table = table;
    }

    /* public JScrollPane getScrollPane() {
        return scrollPane;
    }

    public void setScrollPane(JScrollPane scrollPane) {
        this.scrollPane = scrollPane;
    }*/
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
