package com.soccer.view;

import java.util.Map;
import java.util.Scanner;

import com.soccer.Controller;
import com.soccer.model.entity.Coach;

public class viewCoach {
    public static Controller controlador;
    public void start() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("1. Crear Entrenador");
            System.out.println("2. Actualizar Entrenador");
            System.out.println("3. Buscar Entrenador");
            System.out.println("4. Eliminar Entrenador");
            System.out.println("5. Listar todos los Entrenadores");
            System.out.println("6. Salir");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline
            System.out.println("Digite su elección: ");

            switch (choice) {
                case 1:
                        Coach entrenador = new Coach();
                        String codigoEntrenador = null;
                        System.out.println("Ingrese el código del entrenador: ");
                        codigoEntrenador = scanner.nextLine();
                        System.out.println("Ingrese el nombre del entrenador: ");
                        entrenador.setNombre(scanner.nextLine());
                        System.out.println("Ingrese el apellido del entrenador: ");
                        entrenador.setApellido(scanner.nextLine());
                        System.out.println("Ingrese la edad del entrenador: ");
                        entrenador.setEdad(scanner.nextInt());
                        scanner.nextLine(); // Consume newline
                        System.out.println("Ingrese el ID de la federación del entrenador: ");
                        entrenador.setIdFederacion(scanner.nextInt());
                        scanner.nextLine(); // Consume newline

                        controlador.entrenadores.put(codigoEntrenador, entrenador);
                    break;

                case 2:

                    System.out.println("Ingrese el código del entrenador a actualizar: ");
                    String codigoAct = scanner.nextLine();
                    Coach entrenadorAct = controlador.entrenadores.get(codigoAct);
                    if (entrenadorAct != null) {
                        System.out.println("Ingrese el nuevo nombre del entrenador: ");
                        entrenadorAct.setNombre(scanner.nextLine());
                        System.out.println("Ingrese el nuevo apellido del entrenador: ");
                        entrenadorAct.setApellido(scanner.nextLine());
                        System.out.println("Ingrese la edad del entrenador: ");
                        entrenadorAct.setEdad(scanner.nextInt());
                        scanner.nextLine(); // Consume newline
                        System.out.println("Ingrese el ID de la federación del entrenador: ");
                        entrenadorAct.setIdFederacion(scanner.nextInt());
                        scanner.nextLine(); // Consume newline

                        controlador.entrenadores.put(codigoAct, entrenadorAct);
                        System.out.println("Entrenador actualizado correctamente.");
                    } else {
                        System.out.println("Entrenador no encontrado.");
                    }
                    break;

                case 3:
                    Coach ent = new Coach();
                    System.out.println("Ingrese el código del entrenador: ");
                    String codigoE = scanner.nextLine();
                    ent = controlador.entrenadores.get(codigoE);
                    System.out.println("Nombre del entrenador: " + ent.getNombre());
                    System.out.println("Federación del entrenador: "+ ent.getIdFederacion());
                    break;
                case 4:

                    System.out.println("Ingrese el código del entrenador a eliminar: ");
                    String codigoElim = scanner.nextLine();
                    Coach entrenadorElim = controlador.entrenadores.remove(codigoElim);
                    if (entrenadorElim != null) {
                        System.out.println("Entrenador eliminado correctamente.");
                    } else {
                        System.out.println("Entrenador no encontrado.");
                    }
                    break;

                case 5:

                    System.out.println("Listando todos los entrenadores:");
                    for (Map.Entry<String, Coach> entry : controlador.entrenadores.entrySet()) {
                        Coach entrenadorListado = entry.getValue();
                        System.out.println("Código: " + entry.getKey() + ", Nombre: " + entrenadorListado.getNombre() + ", Apellido: " + entrenadorListado.getApellido());
                    }
                    break;

                case 6:
                    scanner.close();
                    System.exit(0);
                    break;

                default:
                    System.out.println("Opción inválida, inténtelo de nuevo.");
            }   
        }
    }
}
