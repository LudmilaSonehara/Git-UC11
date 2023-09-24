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
import java.sql.SQLException;
import java.sql.ResultSet;
import java.util.ArrayList;


public class ProdutosDAO {
    
    Connection conn;
    PreparedStatement st;
    ResultSet rs;
    ArrayList<ProdutosDTO> listagem = new ArrayList<>();
    
    public int cadastrarProduto (ProdutosDTO produto){

        int status;
        try{
            st = conn.prepareStatement("insert into filmes (nome, lancamento, categoria) values(?,?,?)");
            st.setString(1, produto.getNome());
            st.setString(2, produto.getData());
            st.setString(3, produto.getCategoria());
            status = st.executeUpdate();
            return status;
        }catch(SQLException ex){
            return ex.getErrorCode();
        }
        
    }
    
    public ArrayList<ProdutosDTO> listarProdutos(){
        
        return listagem;
    }
    
    
    
        
}

