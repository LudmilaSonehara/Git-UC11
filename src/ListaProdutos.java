
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
    
    private static final List<ProdutosDTO> lista = new ArrayList<>();
    
    public static List<ProdutosDTO> Listar(){
        return lista;
    
    }
    
    public static void Adicionar(ProdutosDTO produto){
        lista.add(produto);
    }
    
    public static void limpar(){
        lista.clear();
    }
    
}