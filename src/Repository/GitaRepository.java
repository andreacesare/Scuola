package Repository;

import Config.DbConnection;
import Entity.Docente;
import Entity.Gita;

import java.sql.*;
import java.util.ArrayList;
import java.util.logging.*;

public class GitaRepository {
    Logger logger = Logger.getLogger("GitaRepository");

    public void createGita(Gita gita){
        String sql="insert into gita(nome,data,id_doc) values(?,?,?)";
        try{
            Connection c= DbConnection.openConnection();
            PreparedStatement ps=c.prepareStatement(sql);
            ps.setString(1, gita.getNome());
            ps.setDate(2, Date.valueOf(gita.getData()));
            ps.setInt(3,gita.getDocente().getId());
            int a=ps.executeUpdate();
            if(a>0){
                System.out.println("Gita creata con successo");
            }
        }catch(ClassNotFoundException | SQLException e){
            logger.log(Level.SEVERE,"Errore");
        }


    }

    public ArrayList<Gita> readGita(){
        String sql="select g.id_gita,g.nome,g.data,d.nome as nomedoc,d.cognome,d.id_doc from gita g join docente d on g.id_doc=d.id_doc order by g.id_gita";
        ArrayList<Gita> gite=new ArrayList<>();
        try{
            Connection c=DbConnection.openConnection();
            PreparedStatement ps=c.prepareStatement(sql);
            ResultSet rs=ps.executeQuery();
            while(rs.next()){
                Gita g=new Gita();
                g.setId(rs.getInt("id_gita"));
                g.setNome(rs.getString("nome"));
                Date d=rs.getDate("data");
                g.setData(d.toLocalDate());
                Docente docente=new Docente();
                docente.setId(rs.getInt("id_doc"));
                docente.setNome(rs.getString("nomedoc"));
                docente.setCognome(rs.getString("cognome"));
                g.setDocente(docente);
                gite.add(g);
            }
        }catch(ClassNotFoundException | SQLException e){
            logger.log(Level.SEVERE,"Errore"+e.getMessage(),e);
        }
        return gite;

    }

    public void deleteGita(Gita gita){
        String sql="delete from gita where id_gita=?";
        try{
            Connection c=DbConnection.openConnection();
            PreparedStatement ps=c.prepareStatement(sql);
            ps.setInt(1,gita.getId());
            int d=ps.executeUpdate();
            if(d>0){
                System.out.println("Gita eliminata con successo");
            }

        }catch(ClassNotFoundException | SQLException e){
            logger.log(Level.SEVERE,"Errore"+e.getMessage(),e);
        }
    }

    public void updateGita(Gita gita){
        String sql="update gita set nome=?,data=?,id_doc=? where id_gita=?";
        try{
            Connection c=DbConnection.openConnection();
            PreparedStatement ps=c.prepareStatement(sql);
            ps.setString(1,gita.getNome());
            ps.setDate(2,Date.valueOf(gita.getData()));
            ps.setInt(3,gita.getDocente().getId());
            ps.setInt(4,gita.getId());
            int a=ps.executeUpdate();
            if(a>0){
                System.out.println("Gita modificata con successo");
            }
        }catch(ClassNotFoundException | SQLException e){
            logger.log(Level.SEVERE,"Errore"+e.getMessage(),e);
        }
    }
}
