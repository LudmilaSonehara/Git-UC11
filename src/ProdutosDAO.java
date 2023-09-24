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
            st = conn.prepareStatement("insert into produtos (nome, valor, status) values(?,?,?)");
            st.setString(1,produto.getNome());
            st.setInt(2,produto.getValor());
            st.setString(3, produto.getStatus());
            status = st.executeUpdate();
            ListaProdutos.Adicionar(produto);
            return status;
        }catch(SQLException ex){
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
    
        
}