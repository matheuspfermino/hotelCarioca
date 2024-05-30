
package model;

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

public class CadastroFuncTableModel extends AbstractTableModel {
    
   private List<CadastroFunc> dados = new ArrayList<>();
   private String[] colunas = {"Nome","Cpf","Email","Telefone","Endereco","Nascimento","Cargo","Salario"};

   
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
            case 0:
                return dados.get(linha).getNome();
            case 1:
                return dados.get(linha).getCpf();
            case 2:
                return dados.get(linha).getEmail();
            case 3:
                return dados.get(linha).getTelefone();
            case 4:
                return dados.get(linha).getEndereco();
            case 5:
                return dados.get(linha).getNascimento();
            case 6:
                return dados.get(linha).getCargo();
            case 7:
                return dados.get(linha).getSalario();
        }
        
        return null;
    }
    
   @Override
    public void setValueAt(Object valor, int linha, int coluna){
        switch(coluna){
            case 0:
                 dados.get(linha).setNome((String) valor);
                 break;
            case 1:
                 dados.get(linha).setCpf((String) valor);
                 break;
            case 2:
                 dados.get(linha).setEmail((String) valor);
                 break;
            case 3:
                 dados.get(linha).setTelefone((String) valor);
                 break;
            case 4:
                 dados.get(linha).setEndereco((String) valor);
                 break;
            case 5:
                 dados.get(linha).setNascimento((String) valor);
                 break;
            case 6:
                 dados.get(linha).setCargo((String) valor);
                 break;
            case 7:
                 dados.get(linha).setSalario((String) valor);
                 break;
        }
        
        this.fireTableRowsUpdated(linha, linha);
        
    }
    
    public void addRow(CadastroFunc f){
        this.dados.add(f);
        this.fireTableDataChanged();
    }
    
    public void removeRow(int linha){
        this.dados.remove(linha);
        this.fireTableRowsDeleted(linha, linha);
    }
    
}
