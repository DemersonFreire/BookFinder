package bookfinder;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class Busca {

    
    
    Busca(){
    Connection con = ConnectionBD.getConnection();
    String livro = JOptionPane.showInputDialog(null, "Informe o nome do livro:","Busca", 3);
    String sql = "SELECT livro.ID_Livro, livro.Nome_Livro, livro.Genero_livro, localização.Seção, localização.Corredor, localização.Estante, localização.Prateleira FROM livro, localização WHERE livro.Nome_Livro = '" + livro + "' AND livro.ID_Livro = localização.ID_Livro;";
   
    
        try {
            PreparedStatement stmt = con.prepareStatement(sql);
            
            ResultSet result = stmt.executeQuery();
            
            if(!result.isBeforeFirst()){
                JOptionPane.showMessageDialog(null, "Livro não cadastrado!", "Aviso", 0);
            }
            
            while (result.next()){
                
                Integer ID = result.getInt("ID_Livro");
                String Nome = result.getString("Nome_Livro");
                String Genero = result.getString("Genero_Livro");
                String Seção = result.getString("Seção");
                String Corredor = result.getString("Corredor");
                String Estante = result.getString("Estante");
                String Prateleira = result.getString("Prateleira");
                
            
                String resultado = ("ID: "+ID+"\n"
                +"Nome do Livro: "+Nome+"\n"
                +"Gênero: "+Genero+"\n"
                +"Seção: "+Seção+"\n"
                +"Corredor: "+Corredor+"\n"
                +"Estante: "+Estante+"\n"
                +"Prateleira: "+Prateleira);
                
                  
                    
                     JOptionPane.showMessageDialog(null, resultado, "Localização", 1);
            
        }    
            
        
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
    }
    
    
    
}