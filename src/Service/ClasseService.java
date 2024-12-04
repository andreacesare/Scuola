package Service;

import Entity.Classe;
import Entity.Docente;
import Entity.Gita;
import Repository.ClasseRepository;
import Repository.DocenteRepository;

import java.util.ArrayList;

public class ClasseService {
    ClasseRepository classeRepository = new ClasseRepository();

    public void createClasse(String nome, Docente docente){
        Classe classe=new Classe();
        classe.setNome(nome);
        classe.setDocente(docente);
        docente.setClasse(classe);
        classeRepository.createClasse(classe);

    }

    public ArrayList<Classe> readClasse(){
        return classeRepository.readClasse();
    }

    public void deleteClasse(int id){
        Classe classe=new Classe();
        classe.setId(id);
        classeRepository.deleteClasse(classe);

    }

    public void updateClasse(int id, String nome, Docente docente){
        Classe classe=new Classe();
        classe.setId(id);
        classe.setNome(nome);
        classe.setDocente(docente);
        classeRepository.updateClasse(classe);
    }






}
