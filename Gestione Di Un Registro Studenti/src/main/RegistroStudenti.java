package main;

import java.util.Scanner;
import java.util.ArrayList;

public class RegistroStudenti {
	
    private static ArrayList<Studente> registro = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean esci = false;
        
        //ciclo while per gestire il menu principale

        while (!esci) {
            System.out.println("\n Menu Registro Studenti ");
            System.out.println("1. Aggiungi studente");
            System.out.println("2. Visualizza tutti gli studenti");
            System.out.println("3. Cerca studente per matricola");
            System.out.println("4. Esci"); 
            
            //Scelta dell'utente
            int scelta = scanner.nextInt();
            scanner.nextLine(); 

            if (scelta == 1) {
                aggiungiStudente(scanner);//metodo per aggiungere un nuovo studente
            } else if (scelta == 2) {
                visualizzaStudenti();//metodo per visuallizare i studenti gia aggiunti
            } else if (scelta == 3) {
                cercaStudente(scanner);//metodo per cercare i studenti trimite il numero matricola
            } else if (scelta == 4) {
                System.out.println("Uscito");
                esci = true;
            } else {
                System.out.println("Opzione non valida. Selezionare tra 1 e 5.");
            }
        }

        scanner.close();
    }

    private static void aggiungiStudente(Scanner scanner) {
        System.out.print("Inserisci il nome: ");
        String nome = scanner.nextLine();
        System.out.print("Inserisci il cognome: ");
        String cognome = scanner.nextLine();
        System.out.print("Inserisci la matricola: ");
        String matricola = scanner.nextLine();

        // Controlla che la matricola sia unica
        for (Studente studente : registro) {
            if (studente.getMatricola().equals(matricola)) {
                System.out.println("Errore: Matricola già esistente.");
                return;
            }
        }

        registro.add(new Studente(nome, cognome, matricola));
        System.out.println("Studente aggiunto con successo.");
    }

    private static void visualizzaStudenti() {
        if (registro.isEmpty()) {//Controlla se il registro degli studenti è vuoto prima di visualizzarlo.
            System.out.println("Nessuno studente registrato.");
        } else {
            System.out.println("\n Elenco Studenti ");
            for (Studente studente : registro) {
                System.out.println(studente);
            }
        }
    }

    private static void cercaStudente(Scanner scanner) {
        System.out.print("Inserisci la matricola da cercare: ");
        String matricola = scanner.nextLine();

        for (Studente studente : registro) {
            if (studente.getMatricola().equals(matricola)) {
                System.out.println("Studente trovato: " + studente);
                return;
            }
        }

        System.out.println("Studente non trovato.");
    }
}

class Studente {
    private String nome;
    private String cognome;
    private String matricola;

    public Studente(String nome, String cognome, String matricola) {
        this.nome = nome;
        this.cognome = cognome;
        this.matricola = matricola;
    }

    public String getMatricola() {
        return matricola;
    }

    public String toString() {
        return "Matricola: " + matricola + ", Nome: " + nome + ", Cognome: " + cognome;
    }
}
