package Controller;

import Entity.Classe;
import Entity.Docente;
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
    GitaService gitaService=new GitaService();

    public void createClasse(){
        System.out.println("Inserisci nome della classe");
        String nome=scanner.nextLine();
        System.out.println("Ecco la lsta dei docenti");
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
                        if (lista.get(i).getClasse() == null) {
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
                    if(d.getClasse()==null){
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
                                if (lista.get(i).getClasse() == null) {
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


}


