/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package objetoacesso;

import conexao.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import mapbd.Saber;
import mapbd.Alunos;
import com.mycompany.canvasbeeapp.Conquistas;
import java.sql.SQLException;
import javax.swing.JOptionPane;


/**
 *
 * @author lucim
 */
public class SaberDAO {
    private Conexao conexao;
    private Connection conn;
   // public int ident;
    public SaberDAO() {
        this.conexao = new Conexao();
        this.conn = this.conexao.getConexao();
    }
    
    public void inserir(Saber saber) {
        String sql = "INSERT INTO saber(visual,auditivo,cinestesico,predominancia,id_aluno) VALUES"
                +"(?,?,?,?,?)";
        try{
            PreparedStatement stmt = this.conn.prepareStatement(sql);
            stmt.setInt(1, saber.getVisual());
            stmt.setInt(2, saber.getAuditivo());
            stmt.setInt(3, saber.getCinestesico());
            stmt.setString(4, saber.getPredominancia());
            stmt.setInt(5, saber.getId_aluno());
            stmt.execute();            
        }catch (Exception e) {
            System.out.println("Erro ao inserir fase 1(S): " + e.getMessage());
        }
    }
    
    public ResultSet consultar(Saber saber){
    this.conexao = new Conexao();
    this.conn = this.conexao.getConexao();
    String sql = "select * from saber where id_aluno = ?";
    
    try{
        PreparedStatement stmt = this.conn.prepareStatement(sql);
        //stmt.setString(1, aluno.getId_aluno());
        stmt.setInt(1, saber.getId_aluno());
        //stmt.setString(5, saber.getPredominancia());
        ResultSet rs = stmt.executeQuery();
        
        if(rs.next()){
            //Conquitas tela = new Conquitas();
            //tela.setVisible(true);
	    Conquistas.lblPredom.setText(rs.getString("predominancia"));
            
	
            
        }else {
            
                JOptionPane.showMessageDialog(null,"Erro ao executar a consulta");

        }
        return rs;
        
    }catch(SQLException erro){
        JOptionPane.showMessageDialog(null, "predominância: "+ erro);
        return null;
        
    }
    
    }
    
    
}
