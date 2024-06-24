package com.soccer.view;

import java.util.Map;
import java.util.Scanner;

import com.soccer.Controller;
import com.soccer.model.entity.Doctor;

public class viewDoctor {
    public static Controller controlador;
    public void start() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("1. Crear Masajista");
            System.out.println("2. Actualizar Masajista");
            System.out.println("3. Buscar Masajista");
            System.out.println("4. Eliminar Masajista");
            System.out.println("5. Listar todos los Masajistas");
            System.out.println("6. Salir");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline
            System.out.println("Digite su elección: ");

            switch (choice) {
                case 1:
                        Doctor masajista = new Doctor();
                        String codigoMasajista = null;
                        System.out.println("Ingrese el codigo del masajista: ");
                        codigoMasajista = scanner.nextLine();
                        System.out.println("Ingrese el nombre del masajista: ");
                        masajista.setNombre(scanner.nextLine());
                        System.out.println("Ingrese el apellido del masajista: ");
                        masajista.setApellido(scanner.nextLine());
                        System.out.println("Ingrese la edad del masajista: ");
                        masajista.setEdad(scanner.nextInt());
                        scanner.nextLine(); // Consume newline
                        System.out.println("Ingrese la titulación del masajista: ");
                        masajista.setTitulo(scanner.nextLine());
                        System.out.println("Ingrese los años de experiencia del masajista:");
                        masajista.setExpYear(scanner.nextInt());
                        
                        controlador.masajistas.put(codigoMasajista, masajista);
                    break;

                case 2:

                    System.out.println("Ingrese el código del masajista a actualizar: ");
                    String codigoAct = scanner.nextLine();
                    Doctor masajistaAct = controlador.masajistas.get(codigoAct);
                    if (masajistaAct != null) {
                        System.out.println("Ingrese el nuevo nombre del masajista: ");
                        masajistaAct.setNombre(scanner.nextLine());
                        System.out.println("Ingrese el nuevo apellido del masajista: ");
                        masajistaAct.setApellido(scanner.nextLine());
                        System.out.println("Ingrese la edad del masajista: ");
                        masajistaAct.setEdad(scanner.nextInt());
                        System.out.println("Ingrese la titulación del masajista: ");
                        masajistaAct.setTitulo(scanner.nextLine());
                        System.out.println("Ingrese los años de experiencia del masajista:");
                        masajistaAct.setExpYear(scanner.nextInt());
                        
                        controlador.masajistas.put(codigoAct, masajistaAct);
                        System.out.println("Masajista actualizado correctamente.");
                    } else {
                        System.out.println("Masajista no encontrado.");
                    }
                    break;

                case 3:
                    Doctor doc = new Doctor();
                    System.out.println("Ingrese el código del masajista: ");
                    String codigoD = scanner.nextLine();
                    doc = controlador.masajistas.get(codigoD);
                    System.out.println("Nombre del masajista: " + doc.getNombre());
                    System.out.println("Título del masajista: "+ doc.getTitulo());
                    break;
                case 4:

                    System.out.println("Ingrese el código del masajista a eliminar: ");
                    String codigoElim = scanner.nextLine();
                    Doctor masajistaElim = controlador.masajistas.remove(codigoElim);
                    if (masajistaElim != null) {
                        System.out.println("Masajista eliminado correctamente.");
                    } else {
                        System.out.println("Masajista no encontrado.");
                    }
                    break;

                case 5:

                    System.out.println("Listando todos los masajistas:");
                    for (Map.Entry<String, Doctor> entry : controlador.masajistas.entrySet()) {
                        Doctor masajistaListado = entry.getValue();
                        System.out.println("Código: " + entry.getKey() + ", Nombre: " + masajistaListado.getNombre() + ", Apellido: " + masajistaListado.getApellido());
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
