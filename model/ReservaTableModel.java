
package model;

import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;
import java.util.List;
/**
 *
 * @author fujim
 */
public class ReservaTableModel extends AbstractTableModel{

    private List<Reserva> dados = new ArrayList<>();
    private String[] colunas = {"Número da Reserva","ID","Número de Pessoas","Check-In","Check-Out"};
    
    
    @Override
    public String getColumnName(int column) {
        return colunas[column];
    }
    
    @Override
    public int getRowCount() {
        return dados.size();
    }

    @Override
    public int getColumnCount() {
        return colunas.length;
    }

    @Override
    public Object getValueAt(int linha, int coluna) {
        
        switch(coluna){
            
            case 0 -> {
                return dados.get(linha).getNumreserva();
            }
            case 1 -> {
                return dados.get(linha).getID();
            }
            case 2 -> {
                return dados.get(linha).getNumpessoas();
            }
            case 3 -> {
                return dados.get(linha).getDatain();
            }
            case 4 -> {
                return dados.get(linha).getDataout();
            }
        }
        
        return null;
        
    }
    
    @Override
    public void setValueAt(Object valor, int linha, int coluna){
       
        switch(coluna){
            
            case 0 -> {
                 dados.get(linha).setNumreserva((String)valor);
                 break;
            }
            case 1 -> {
                 dados.get(linha).setID((String)valor);
                 break;
            }
            case 2 -> {
                 dados.get(linha).setNumpessoas((String)valor);
                 break;
            }
            case 3 -> {
                 dados.get(linha).setDatain((String)valor);
                 break;
            }
            case 4 -> {
                 dados.get(linha).setDataout((String)valor);
                 break;
            }
        
        }
        
        this.fireTableRowsUpdated(linha, linha);
    }
    
    public void addRow(Reserva r){
        this.dados.add(r);
        this.fireTableDataChanged();
    }
    
    public void removeRow(int linha){
        this.dados.remove(linha);
        this.fireTableRowsDeleted(linha, linha);
    }
    
}
