
import java.util.ArrayList;
import java.util.List;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author LUCAS MEIRELLES
 */
public class ListaProdutos {
    
    private static final List<ProdutosDTO> listagem = new ArrayList<>();
    
    public static List<ProdutosDTO> Listar(){
        return listagem;
    
    }
    
    public static void Adicionar(ProdutosDTO produto){
        listagem.add(produto);
    }
    
    public static void limpar(){
        listagem.clear();
    }
    
}