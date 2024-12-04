package Service;

import Entity.Classe;
import Entity.Docente;
import Entity.Gita;
import Repository.GitaRepository;

import java.time.LocalDate;
import java.util.ArrayList;

public class GitaService {
    GitaRepository gitaRepository = new GitaRepository();

    public void createGita(String nome, LocalDate data, Docente docente, Classe classe){
        Gita gita=new Gita();
        gita.setNome(nome);
        gita.setData(data);
        gita.setDocente(docente);
        gita.aggiungiClasse(classe);
        gitaRepository.createGita(gita);

    }

    public ArrayList<Gita> readGita(){
        return gitaRepository.readGita();
    }

    public void deleteGita(int id){
        Gita gita=new Gita();
        gita.setId(id);
        gitaRepository.deleteGita(gita);

    }

    public void updateGita(int id, String nome, LocalDate data, Docente docente){
        Gita gita=new Gita();
        gita.setId(id);
        gita.setNome(nome);
        gita.setData(data);
        gita.setDocente(docente);
        gitaRepository.updateGita(gita);
    }
}
