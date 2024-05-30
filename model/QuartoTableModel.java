package model;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;
/**
 *
 * @author Matheus
 */
public class QuartoTableModel extends AbstractTableModel {
    
    private List<Quarto> dados = new ArrayList<>();
    private String[] colunas = {"NumPessoas","ID","TipoQuarto"};
    
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
                return dados.get(linha).getNumPessoa();
            } 
            case 1 -> {
                return dados.get(linha).getID();
            } 
            case 2 -> {
                return dados.get(linha).getTipo();
            }
        }
        return null;
    }
    @Override
     public void setValueAt(Object valor,int linha,int coluna){
        switch(coluna){
            
            case 0 -> {
                dados.get(linha).setNumPessoa((String)valor);
                break;
            } 
            case 1 -> {
                dados.get(linha).setID((String)valor);
                break;
            }
            case 2 -> {
                dados.get(linha).setTipo((String)valor);
                break;
            }
        }
        this.fireTableRowsUpdated(linha, linha);
    }
    public void addRow(Quarto q){
        this.dados.add(q);
        this.fireTableDataChanged();
    }
    public void removeRow(int linha){
        this.dados.remove(linha);
        this.fireTableRowsDeleted(linha,linha);
    } 
}
