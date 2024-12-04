package Controller;

import Entity.Classe;
import Entity.Docente;
import Entity.Gita;
import Service.ClasseService;
import Service.DocenteService;
import Service.GitaService;

import java.util.ArrayList;
import java.util.*;

public class ClasseController {
    Scanner scanner=new Scanner(System.in);
    DocenteController docenteController=new DocenteController();
    ClasseService classeService=new ClasseService();
    DocenteService docenteService=new DocenteService();
    GitaController gitaController=new GitaController();
    GitaService gitaService=new GitaService();


    public void createClasse(){
        System.out.println("Inserisci nome della classe");
        String nome=scanner.nextLine();
        docenteController.readDocente();
        ArrayList<Docente> lista=docenteService.readDocente();
        boolean flag=false;
        for(Docente d:lista){
            if(d.getClasse()==null){
                flag=true;
            }
        }
        do {
            System.out.println("Inserisci id del docente da affidare a questa classe");
            int id = scanner.nextInt();
            scanner.nextLine();


            if(flag) {
                for (int i = 0; i < lista.size(); i++) {
                    if (lista.get(i).getId() == id) {
                        if (lista.get(i).getClasse()==null) {
                            Docente docente = lista.get(i);
                            classeService.createClasse(nome, docente);
                            flag = false;
                        } else {
                            System.out.println("Docente impegnato");

                        }
                    }
                }
            }else{
                System.out.println("Tutti i docenti sono impegnati");
            }
        }while(flag);



    }

    public void readClasse(){
        System.out.println("Ecco la lista delle classi");
        ArrayList<Classe> lista=classeService.readClasse();
        for(Classe c:lista){
            System.out.println(c.getId()+" "+c.getNome());
        }
    }

    public void deleteClasse(){
        readClasse();
        System.out.println("Inserisci l'id della classe da eliminare");
        int id = scanner.nextInt();
        scanner.nextLine();
        classeService.deleteClasse(id);

    }

    public void updateClasse(){
        readClasse();
        System.out.println("Inserisci l'id della classe da modificare");
        int id = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Inserisci nuovo nome della classe");
        String nome=scanner.nextLine();
        docenteController.readDocente();
        ArrayList<Docente> lista=docenteService.readDocente();
                boolean flag=false;
                for(Docente d:lista){
                    if(d.getClasse().getId()==0){
                        flag=true;
                    }
                }
                do {
                    System.out.println("Inserisci id del docente da affidare a questa classe");
                    int idd = scanner.nextInt();
                    scanner.nextLine();


                    if(flag) {
                        for (int i = 0; i < lista.size(); i++) {
                            if (lista.get(i).getId() == idd) {
                                if (lista.get(i).getClasse().getId() == 0) {
                                    Docente docente = lista.get(i);
                                    classeService.updateClasse(id,nome, docente);
                                    flag = false;
                                } else {
                                    System.out.println("Docente impegnato");

                                }
                            }
                        }
                    }else{
                        System.out.println("Tutti i docenti sono impegnati");
                    }
                }while(flag);


            }

    public void classeInGita() {
        readClasse();
        System.out.println("Inserisci id della classe da mandare in gita");
        int idc = scanner.nextInt();
        scanner.nextLine();
        gitaController.readGita();
        System.out.println("Inserisci id della gita a cui iscriverla");
        int idg = scanner.nextInt();
        scanner.nextLine();
        ArrayList<Gita> gite=gitaService.readGita();
        ArrayList<Classe> classi=classeService.readClasse();
        Gita gita=new Gita();
        Classe classe=new Classe();
        for(int i=0;i<gite.size();i++){
            if(gite.get(i).getId()==idg){
                gita=gite.get(i);
            }
        }
        for(int i=0;i<classi.size();i++){
            if(classi.get(i).getId()==idc){
                classe=classi.get(i);
            }
        }
        classeService.classeInGita(classe,gita);
    }



}


