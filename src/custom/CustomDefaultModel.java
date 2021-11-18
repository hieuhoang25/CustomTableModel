/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package custom;

import custom.Book;
import java.util.ArrayList;
import java.util.Vector;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author HieuHoang
 */
public class CustomDefaultModel extends DefaultTableModel {

    private ArrayList<Book> list;
    private Object[] columnNames;
    private boolean isEdit;

    public CustomDefaultModel(ArrayList<Book> list, Object[] columnNames) {
        this.list = list;
        this.columnNames = columnNames;
    }

    public boolean isIsEdit() {
        return isEdit;
    }

    public void setIsEdit(boolean isEdit) {
        this.isEdit = isEdit;
    }

    public CustomDefaultModel() {
    }

    public ArrayList<Book> getList() {
        return list;
    }

    public void setList(ArrayList<Book> list) {
        this.list = list;
        setRowCount(0);
        for (Book book : list) {
            Vector<Object> vc = new Vector<>();
            vc.add(book.getId());
            vc.add(book.getName());
            addRow(vc);
        }
    }

    public Object[] getColumnNames() {
        return columnNames;
    }

    public void setColumnNames(Object[] columnNames) {
        this.columnNames = columnNames;
        for (Object columnName : columnNames) {
            addColumn(columnName);
        }
    }

    @Override
    public void addColumn(Object columnName) {
        super.addColumn(columnName); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void addRow(Vector<?> rowData) {
        super.addRow(rowData); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean isCellEditable(int row, int column) {
        //To change body of generated methods, choose Tools | Templates.

        if (isEdit == false) {
            return false;
        } else {
            if (column == 0) {
                return false;
            }
            return true;
        }
    }

    @Override
    public void setValueAt(Object aValue, int row, int column) {
        Book book = list.get(row);
        switch (column) {
            case 0: {
                book.setId((int) aValue);
                break;
            }
            case 1: {
                book.setName((String) aValue);
                break;
            }
        }

    }

    @Override
    public Object getValueAt(int row, int column) {
        Book book = list.get(row);
        switch (column) {
            case 0:
                return book.getId();
            case 1:
                return book.getName();
        }
        return null;
    }

    @Override
    public void removeRow(int row) {
        list.remove(row);
        super.removeRow(row); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void addRow(Object[] rowData) {
        list.add(new Book((int) rowData[0], rowData[1] + ""));
        super.addRow(rowData); //To change body of generated methods, choose Tools | Templates.
    }

}
