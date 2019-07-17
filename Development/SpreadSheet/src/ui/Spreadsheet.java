package ui;

import SpreadSheet.Cell;
import SpreadSheet.DataTypeFactory;
import SpreadSheet.Sheet;

import javax.swing.*;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableCellEditor;
import javax.swing.table.TableCellRenderer;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Spreadsheet extends JPanel {
    private boolean DEBUG = false;
    private JTextField textFieldFx;
    JTable grid;

    public Spreadsheet() {
        super(new BorderLayout());
        this.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);

        // initial spreadsheet
        Sheet sheet = new Sheet();
        sheet.dummyData();

        // initial JTable display
        grid = new JTable(new Worksheets(sheet));
        grid.setPreferredScrollableViewportSize(new Dimension(1024, 600));
        grid.setFillsViewportHeight(true);
        grid.setCellSelectionEnabled(true);
        grid.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        //Set up renderer and editor for the Favorite Color column.
        grid.setDefaultRenderer(Object.class, new CellRenderer(sheet));
        grid.setDefaultEditor(Object.class, new CellEditor(sheet));
        
        double colPercentage[] = new double[sheet.getMaxCol()];
        colPercentage[0] = 10.0;
        for (int i = 1; i < sheet.getMaxCol(); i++) {
			colPercentage[i] = 100 / sheet.getMaxCol();
		}
        
        JTableExtensions.setJTableColumnsWidth(grid, 1024, colPercentage);

        // using scroll panel
        JScrollPane scroll = new JScrollPane(grid);
        scroll.setRowHeaderView(JTableExtensions.buildRowHeader(grid));
        grid.setRowHeight(30);

        // add controls to main panel
        add(scroll, BorderLayout.CENTER);

        // design top panel with text box and label
        JPanel panelFunctions = new JPanel(new FlowLayout());
        panelFunctions.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);

        // add label
        panelFunctions.add(new JLabel("(fx): "), ComponentOrientation.LEFT_TO_RIGHT);
        textFieldFx = new JTextField();
        textFieldFx.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
        textFieldFx.setColumns(20);
        panelFunctions.add(textFieldFx);

        add(panelFunctions, BorderLayout.NORTH);

        // add button examine
        JPanel panelBottom = new JPanel(new FlowLayout());
        panelBottom.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);

        JButton btExamine = new JButton("Examine Spreadsheet");
        btExamine.addActionListener((event)->{
            sheet.examine();
        });
        panelBottom.add(btExamine);
        add(panelBottom, BorderLayout.SOUTH);
    }

    class CellEditor extends DefaultCellEditor implements TableCellEditor, ActionListener {
        private Sheet sheet;

        public CellEditor(Sheet sheet) {
            super(new JTextField());
            this.sheet = sheet;
            if(textFieldFx != null)
                textFieldFx.setText("");
        }

        @Override
        public void actionPerformed(ActionEvent e) {
        }

        @Override
        public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
            JTextField editor = (JTextField) super.getTableCellEditorComponent(table, value, isSelected, row, column);;
            editor.setBorder(BorderFactory.createEmptyBorder(0,5,0,5));
            editor.setBackground(Color.decode("#ffeb8e"));
            editor.setMargin(new Insets(0, 10, 0, 0));
            Cell cell = sheet.getCellAt(row + 1, column + 1);
            if (cell != null && cell.getContent() != "") {
                editor.setText(cell.getContent());
                textFieldFx.setText(cell.getContent());
            }
            return editor;
        }
    }

    class CellRenderer extends DefaultTableCellRenderer implements TableCellRenderer {

        private Sheet sheet;

        public CellRenderer(Sheet sheet) {
            this.sheet = sheet;
        }

        @Override
        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
            Cell cell = sheet.getCellAt(row + 1, column + 1);
            if (cell != null && cell.getValue() != null) {
                setValue(cell.getValue());
            }
            return super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
        }
    }

    class Worksheets extends AbstractTableModel {

        private Sheet sheet;

        public Worksheets(Sheet sheet) {
            this.sheet = sheet;
        }

        @Override
        public int getRowCount() {
            return sheet.getMaxRow();
        }

        @Override
        public int getColumnCount() {
            return sheet.getMaxCol();
        }

        @Override
        public String getColumnName(int column) {
            return String.valueOf(column + 1);
        }

        @Override
        public Object getValueAt(int rowIndex, int columnIndex) {
            Cell cell = sheet.getCellAt(rowIndex + 1, columnIndex + 1);
            return cell != null ? cell.getValue() : "";
        }

        @Override
        public boolean isCellEditable(int rowIndex, int columnIndex) {
            Cell cell = sheet.getCellAt(rowIndex + 1, columnIndex +1);
            if(cell != null && cell.getContent() != ""){
                textFieldFx.setText(cell.getValue().toString());
            }else{
                textFieldFx.setText("");
            }
            return true;
        }

        @Override
        public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
            sheet.modifyCell(rowIndex + 1, columnIndex + 1, aValue);
            
            fireTableDataChanged();
        }
        
        @Override
        public void fireTableDataChanged() {
        	super.fireTableDataChanged();
        	//TODO: Refactor - apply observer to enhance performance
        	for (int i = 0; i<= sheet.getMaxRow();i++) {
				for (int j = 0; j <= sheet.getMaxCol(); j++) {
					sheet.reloadCell(i, j);	
				}
			}
        }
    }
}
