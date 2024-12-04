package Repository;

import Config.DbConnection;
import Entity.Classe;
import Entity.Docente;

import java.sql.*;
import java.util.ArrayList;
import java.util.logging.*;


public class DocenteRepository {
    private static final Logger logger=Logger.getLogger(DocenteRepository.class.getName());


    public void createDocente(Docente docente){
        String sql = "insert into docente(nome,cognome) values(?,?)";
        try{
            Connection c= DbConnection.openConnection();
            PreparedStatement stm=c.prepareStatement(sql);
            stm.setString(1,docente.getNome());
            stm.setString(2,docente.getCognome());
            int rigainserita = stm.executeUpdate();
            if (rigainserita > 0) {
                System.out.println("Docente inserito con successo");
            }
        }catch(ClassNotFoundException | SQLException e){
            logger.log(Level.SEVERE,"Errore impossibile connettersi al db" +e.getMessage(),e);
        }

    }

    public ArrayList<Docente> readDocente(){
        ArrayList<Docente> lista=new ArrayList<>();
        String sql = "select d.id_doc,d.nome,d.cognome,c.id_classe,c.nome as nomec from docente d full join classe c on d.id_doc=c.id_doc order by d.id_doc";
        try{
            Connection c=DbConnection.openConnection();
            PreparedStatement ps= c.prepareStatement(sql);
            ResultSet rs=ps.executeQuery();
            while(rs.next()){
                Docente docente=new Docente();
                Classe classe=new Classe();
                docente.setId(rs.getInt("id_doc"));
                docente.setNome(rs.getString("nome"));
                docente.setCognome(rs.getString("cognome"));
                classe.setId(rs.getInt("id_classe"));
                classe.setNome(rs.getString("nomec"));
                classe.setDocente(docente);
                docente.setClasse(classe);
                lista.add(docente);
            }
        }catch(ClassNotFoundException | SQLException e){
            logger.log(Level.SEVERE,"Errore impossibile connettersi al db"+e.getMessage(),e);
        }
        return lista;
    }

    public void deleteDocente(Docente docente){
        String sql = "delete from docente where id_doc=?";
        try{
            Connection c=DbConnection.openConnection();
            PreparedStatement ps=c.prepareStatement(sql);
            ps.setInt(1,docente.getId());
            int d=ps.executeUpdate();
            if(d>0){
                System.out.println("Docente eliminato con successo");
            }

        }catch(ClassNotFoundException | SQLException e){
            logger.log(Level.SEVERE,"Errore impossibile connettersi al db"+e.getMessage(),e);
        }
    }

    public void updateDocente(Docente docente){
        String sql = "update docente set nome=?,cognome=? where id_doc=?";
        try{
            Connection c=DbConnection.openConnection();
            PreparedStatement ps=c.prepareStatement(sql);
            ps.setString(1,docente.getNome());
            ps.setString(2,docente.getCognome());
            ps.setInt(3,docente.getId());
            int u=ps.executeUpdate();
            if(u>0){
                System.out.println("Docente modificato con successo");
            }


        }catch(ClassNotFoundException | SQLException e){
            logger.log(Level.SEVERE,"Errore impossibile connettersi al db"+e.getMessage(),e);
        }
    }
}
