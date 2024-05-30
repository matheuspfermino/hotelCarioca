
package model;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

public class CheckoutTableModel extends AbstractTableModel{

    private List<Checkout> dados = new ArrayList<>();
    private String[] colunas = {"Forma Pagamento","CPF","Data","Valor"};
    
    @Override
    public String getColumnName(int column){
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
                return dados.get(linha).getFormaPag();
            } 
            case 1 -> {
                return dados.get(linha).getCPF();
            }
            case 2 -> {
                return dados.get(linha).getData();
            }
            case 3 -> {
                return dados.get(linha).getValor();
            }  
        }
        return null;
    }
    @Override
     public void setValueAt(Object valor,int linha,int coluna){
        switch(coluna){
            case 0 -> {
                dados.get(linha).setFormaPag((String)valor);
                break;
            } 
            case 1 -> {
                dados.get(linha).setCPF((String)valor);
                break;
            }
            case 2 -> {
                dados.get(linha).setData((String)valor);
                break;
            }
            case 3 -> {
                dados.get(linha).setValor((String)valor);
                break;
            }
        }
        this.fireTableRowsUpdated(linha, linha);
    }
    public void addRow(Checkout check){
        this.dados.add(check);
        this.fireTableDataChanged();
    }
    public void removeRow(int linha){
        this.dados.remove(linha);
        this.fireTableRowsDeleted(linha,linha);
    } 

}
