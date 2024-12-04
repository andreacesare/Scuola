import Controller.ClasseController;
import Controller.DocenteController;
import Controller.GitaController;

import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        int choice1;
        int choice2;
        Scanner scanner = new Scanner(System.in);
        do {
            System.out.println("1)Docente \n 2)Classe \n 3) Gita \n 4)Exit");
            System.out.println("Inserisci la tua scelta");
            choice1 = scanner.nextInt();
            scanner.nextLine();
            if (choice1 == 1) {
                System.out.println("Classe Docente");
                System.out.println("****MENU****");
                System.out.println("1. Crea un nuovo docente");
                System.out.println("2. Aggiorna un docente");
                System.out.println("3. Visualizza la lista dei docenti");
                System.out.println("4. Elimina un docente");
                System.out.println("9. Exit");
                System.out.print("inserisci la tua scelta: ");
                choice2 = scanner.nextInt();
                scanner.nextLine();
                DocenteController docenteController = new DocenteController();
                switch (choice2) {
                    case 1:
                        docenteController.createDocente();
                        break;
                    case 2:
                        docenteController.updateDocente();
                        break;
                    case 3:
                        docenteController.readDocente();
                        break;
                    case 4:
                        docenteController.deleteDocente();
                        break;
                    case 5:

                        break;
                    case 6:

                        break;
                    case 7:

                        break;
                    case 9:
                        System.out.println("Exiting");
                        break;
                    default:
                        System.out.println("Insersci un numero valido");
                }
            }
            else if (choice1 == 2) {
                System.out.println("Classe Classe");
                System.out.println("****MENU****");
                System.out.println("1. Crea una nuova classe");
                System.out.println("2. Aggiorna una classe");
                System.out.println("3. Visualizza la lista delle classi ");
                System.out.println("4. Elimina una classe");
                System.out.println("5. Iscrivi una classe ad una gita");
                System.out.println("9. Exit");
                System.out.print("inserisci la tua scelta: ");
                choice2 = scanner.nextInt();
                scanner.nextLine();
                ClasseController classeController = new ClasseController();
                switch (choice2) {
                    case 1:
                        classeController.createClasse();
                        break;
                    case 2:
                        classeController.updateClasse();
                        break;
                    case 3:
                        classeController.readClasse();
                        break;
                    case 4:
                        classeController.deleteClasse();
                        break;
                    case 5:
                        classeController.classeInGita();
                        break;
                    case 6:

                        break;
                    case 9:
                        System.out.println("Exiting");
                        break;
                    default:
                        System.out.println("Insersci un numero valido");
                }
            }
            else if (choice1 == 3) {
                System.out.println("Classe Gita");
                System.out.println("****MENU****");
                System.out.println("1. Crea una nuova gita");
                System.out.println("2. Aggiorna una gita");
                System.out.println("3. Visualizza la lista delle gite");
                System.out.println("4. Elimina una gita");
                System.out.println("9. Exit");
                System.out.print("inserisci la tua scelta: ");
                choice2 = scanner.nextInt();
                scanner.nextLine();
                GitaController gitaController = new GitaController();
                switch (choice2) {
                    case 1:
                        gitaController.createGita();
                        break;
                    case 2:
                        gitaController.updateGita();
                        break;
                    case 3:
                        gitaController.readGita();
                        break;
                    case 4:
                        gitaController.deleteGita();
                        break;
                    case 5:

                        break;
                    case 6:

                        break;
                    case 7:

                        break;
                    case 9:
                        System.out.println("Exiting");
                        break;
                    default:
                        System.out.println("Insersci un numero valido");
                }
            }
        }while (choice1 != 4);
            }
    }




