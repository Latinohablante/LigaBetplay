package com.soccer;

import java.util.Scanner;

import com.soccer.view.viewCoach;
import com.soccer.view.viewDoctor;
import com.soccer.view.viewPlayer;
import com.soccer.view.viewTeam;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("1. Menú equipo");
            System.out.println("2. Menú jugador");
            System.out.println("3. Menú doctor");
            System.out.println("4. Menú entrenador");
            System.out.println("5. Sin rol");
            System.out.println("6. Salir");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline
            

            switch (choice) {
                case 1:
                    Controller ctrlTeams = new Controller();
                    viewTeam.controlador = ctrlTeams;
                    viewTeam vt = new viewTeam();
                    vt.start();
                    break;

                case 2:
                    Controller ctrlPlayers = new Controller();
                    viewPlayer.controlador = ctrlPlayers;
                    viewPlayer vp = new viewPlayer();
                    vp.start();
                    break;

                case 3:
                    Controller ctrlDoctors = new Controller();
                    viewDoctor.controlador = ctrlDoctors;
                    viewDoctor vd = new viewDoctor();
                    vd.start();

                case 4:
                    Controller ctrlCoachs = new Controller();
                    viewCoach.controlador = ctrlCoachs;
                    viewCoach vc = new viewCoach();
                    vc.start();

                case 5:
                    // código case 5

                case 6:
                    scanner.close();
                    System.exit(0);
                    break;

                default:
                    System.out.println("Opcion invalida, intentelo de nuevo.");

            }

        
       // System.out.println("Jugador"+ eq.getLstJugadores().get(0).getNombre());
        }
    }
}