package com.soccer.view;

import java.util.Map;
import java.util.Scanner;

import com.soccer.Controller;
import com.soccer.model.entity.Player;

public class viewPlayer {
    public static Controller controlador;
    public void start() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("1. Crear Jugador");
            System.out.println("2. Actualizar Jugador");
            System.out.println("3. Buscar Jugador");
            System.out.println("4. Eliminar Jugador");
            System.out.println("5. Listar todos los Jugadores");
            System.out.println("6. Salir");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline
            System.out.println("Digite su elección: ");

            switch (choice) {
                case 1:
                        Player jugador = new Player();
                        String codigoJugador = null;
                        System.out.println("Ingrese el codigo del jugador: ");
                        codigoJugador = scanner.nextLine();
                        System.out.println("Ingrese el nombre del jugador: ");
                        jugador.setNombre(scanner.nextLine());
                        System.out.println("Ingrese el apellido del jugador: ");
                        jugador.setApellido(scanner.nextLine());
                        System.out.println("Ingrese la edad del jugador: ");
                        jugador.setEdad(scanner.nextInt());
                        System.out.println("Ingrese la dorsal del jugador: ");
                        jugador.setDorsal(scanner.nextInt());
                        System.out.println("Ingrese la posición del jugador :");
                        jugador.setPosicion(scanner.nextLine());
                        
                        controlador.jugadores.put(codigoJugador, jugador);
                    break;

                case 2:

                    System.out.println("Ingrese el código del jugador a actualizar: ");
                    String codigoAct = scanner.nextLine();
                    Player jugadorAct = controlador.jugadores.get(codigoAct);
                    if (jugadorAct != null) {
                        System.out.println("Ingrese el nuevo nombre del jugador: ");
                        jugadorAct.setNombre(scanner.nextLine());
                        System.out.println("Ingrese el nuevo apellido del jugador: ");
                        jugadorAct.setApellido(scanner.nextLine());
                        System.out.println("Ingrese la edad del jugador: ");
                        jugadorAct.setEdad(scanner.nextInt());
                        System.out.println("Ingrese la dorsal del jugador: ");
                        jugadorAct.setDorsal(scanner.nextInt());
                        System.out.println("Ingrese la posición del jugador :");
                        jugadorAct.setPosicion(scanner.nextLine());
                        
                        controlador.jugadores.put(codigoAct, jugadorAct);
                        System.out.println("Jugador actualizado correctamente.");
                    } else {
                        System.out.println("Jugador no encontrado.");
                    }
                    break;

                case 3:
                    Player pl = new Player();
                    System.out.println("Ingrese el código del jugador: ");
                    String codigoP = scanner.nextLine();
                    pl = controlador.jugadores.get(codigoP);
                    System.out.println("Nombre del jugador: " + pl.getNombre());
                    System.out.println("Dorsal del jugador: "+ pl.getDorsal());
                    break;
                case 4:

                    System.out.println("Ingrese el código del equipo a eliminar: ");
                    String codigoElim = scanner.nextLine();
                    Player jugadorElim = controlador.jugadores.remove(codigoElim);
                    if (jugadorElim != null) {
                        System.out.println("Jugador eliminado correctamente.");
                    } else {
                        System.out.println("Jugador no encontrado.");
                    }
                    break;

                case 5:

                    System.out.println("Listando todos los jugadores:");
                    for (Map.Entry<String, Player> entry : controlador.jugadores.entrySet()) {
                        Player jugadorListado = entry.getValue();
                        System.out.println("Código: " + entry.getKey() + ", Nombre: " + jugadorListado.getNombre() + ", Ciudad: " + jugadorListado.getApellido());
                    }
                    break;

                case 6:
                    scanner.close();
                    System.exit(0);
                    break;

                default:
                    System.out.println("Opcion invalida, intentelo de nuevo.");
            }   
        }
    }


}
