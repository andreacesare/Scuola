package Repository;

import Config.DbConnection;
import Entity.Classe;
import Entity.Docente;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;
import java.util.logging.*;


public class ClasseRepository {
    private static final Logger logger = Logger.getLogger(ClasseRepository.class.getName());

    public void createClasse(Classe classe) {
        String sql = "INSERT INTO classe(nome,id_doc) VALUES(?,?)";
        try {
            Connection c = DbConnection.openConnection();
            PreparedStatement ps = c.prepareStatement(sql);
            ps.setString(1, classe.getNome());
            ps.setInt(2, classe.getDocente().getId());
            int riga = ps.executeUpdate();
            if (riga > 0) {
                System.out.println("Classe " + classe.getNome() + " created");
            }
        } catch (ClassNotFoundException | SQLException e) {
            logger.log(Level.SEVERE, "Errore" + e.getMessage(), e);
        }

    }

    public ArrayList<Classe> readClasse() {
        ArrayList<Classe> classi = new ArrayList<>();
        String sql = "SELECT d.id_doc,d.nome as nomedoc,d.cognome,c.nome,c.id_classe FROM classe c JOIN docente d ON c.id_doc=d.id_doc";
        try {
            Connection c = DbConnection.openConnection();
            PreparedStatement ps = c.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Classe classe = new Classe();
                classe.setId(rs.getInt("id_classe"));
                classe.setNome(rs.getString("nome"));
                Docente docente = new Docente();
                docente.setId(rs.getInt("id_doc"));
                docente.setNome(rs.getString("nome"));
                docente.setCognome(rs.getString("cognome"));
                classe.setDocente(docente);
                classi.add(classe);
            }

        } catch (ClassNotFoundException | SQLException e) {
            logger.log(Level.SEVERE, "Errore" + e.getMessage(), e);
        }
        return classi;
    }

}
