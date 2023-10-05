/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Adm
 */

import java.sql.PreparedStatement;
import java.sql.Connection;
import javax.swing.JOptionPane;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


public class ProdutosDAO {
    conectaDAO conect = new conectaDAO();
    Connection conn = conect.connectDB();
    PreparedStatement st;
    ResultSet rs;
    
    
    public int cadastrarProduto (ProdutosDTO produto){
        
        int status;
        
        try{
            st = conn.prepareStatement("insert into produtos (id, nome, valor, status) values(?,?,?,?)");
            
            st.setInt(1,produto.getId());
            st.setString(2,produto.getNome());
            st.setInt(3, produto.getValor());
            st.setString(4, produto.getStatus());
            status = st.executeUpdate();
            ListaProdutos.Adicionar(produto);
            JOptionPane.showMessageDialog(null, "O produto foi cadastrado com sucesso");
            return status;
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Houve um erro no cadastro do produto:\n"+ex.getErrorCode());
            return ex.getErrorCode();
        }
        
    }
    
    
    
    public void listaProdutos(){
        ProdutosDTO produto = new ProdutosDTO();
        
        try{
            if(ListaProdutos.Listar().isEmpty()){
                st = conn.prepareStatement("select id, nome, valor, status from produtos");
                rs = st.executeQuery();
                while(rs.next()){
                    produto = new ProdutosDTO();
                    produto.setId(rs.getInt("id"));
                    produto.setNome(rs.getString("nome"));
                    produto.setValor(rs.getInt("valor"));
                    produto.setStatus(rs.getString("status"));
                    ListaProdutos.Adicionar(produto);
                    
                }
                
            }
            
            }catch(SQLException ex){
                JOptionPane.showMessageDialog(null, "Deu algo errado em listar, meu chapa: "+ex.getMessage());
                
            }
    
    }
    
    public void vendeID(int ID){
        try{    
            st = conn.prepareStatement("select id from produtos where id = ?");
            st.setInt(1, ID);
            rs = st.executeQuery();
            int contagem = 0;
            for(ProdutosDTO p : ListaProdutos.Listar()){
                
                if(p.getId() == ID){
                  contagem++;
                  if(p.getStatus().equals("Vendido")){
                      JOptionPane.showMessageDialog(null, "O produto já foi vendido!");
                  }
                  
                  else{
                      p.setStatus("Vendido");
                      JOptionPane.showMessageDialog(null, "Produto vendido com sucesso!");
                  }
                
                }
                
            }
            if(contagem == 0){
                JOptionPane.showMessageDialog(null, "Produto não registrado");
            }
        }catch(SQLException ex){
                JOptionPane.showMessageDialog(null, "Deu algo errado em listar, meu chapa: "+ex.getMessage());
               
        }
        
    }
    
        
}