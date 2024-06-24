package com.soccer.view;

import java.util.Map;
import java.util.Scanner;

import com.soccer.Controller;
import com.soccer.model.entity.Team;

public class viewTeam {
    public static Controller controlador;
    public void start() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("1. Crear Equipo");
            System.out.println("2. Actualizar Equipo");
            System.out.println("3. Buscar Equipo");
            System.out.println("4. Eliminar Equipo");
            System.out.println("5. Listar todos Equipos");
            System.out.println("6. Salir");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                        Team equipo = new Team();
                        String codigoEquipo = null;
                        System.out.println("Ingrese el codigo del equipo :");
                        codigoEquipo = scanner.nextLine();
                        System.out.println("Ingrese Nombre del equipo :");
                        equipo.setNombre(scanner.nextLine());
                        System.out.println("Ingrese la ciudad :");
                        equipo.setCiudad(scanner.nextLine());
                        controlador.equipos.put(codigoEquipo, equipo);
                    break;

                case 2:

                    System.out.println("Ingrese el código del equipo a actualizar: ");
                    String codigoAct = scanner.nextLine();
                    Team equipoAct = controlador.equipos.get(codigoAct);
                    if (equipoAct != null) {
                        System.out.println("Ingrese el nuevo nombre del equipo: ");
                        equipoAct.setNombre(scanner.nextLine());
                        System.out.println("Ingrese la nueva ciudad del equipo: ");
                        equipoAct.setCiudad(scanner.nextLine());
                        controlador.equipos.put(codigoAct, equipoAct);
                        System.out.println("Equipo actualizado correctamente.");
                    } else {
                        System.out.println("Equipo no encontrado.");
                    }
                    break;

                case 3:
                    Team eq = new Team();
                    System.out.println("Ingrese el código del equipo: ");
                    String codigoE = scanner.nextLine();
                    eq = controlador.equipos.get(codigoE);
                    System.out.println("Mi equipo: " + eq.getNombre());
                    break;
                case 4:

                    System.out.println("Ingrese el código del equipo a eliminar: ");
                    String codigoElim = scanner.nextLine();
                    Team equipoElim = controlador.equipos.remove(codigoElim);
                    if (equipoElim != null) {
                        System.out.println("Equipo eliminado correctamente.");
                    } else {
                        System.out.println("Equipo no encontrado.");
                    }
                    break;

                case 5:

                    System.out.println("Listando todos los equipos:");
                    for (Map.Entry<String, Team> entry : controlador.equipos.entrySet()) {
                        Team equipoListado = entry.getValue();
                        System.out.println("Código: " + entry.getKey() + ", Nombre: " + equipoListado.getNombre() + ", Ciudad: " + equipoListado.getCiudad());
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
