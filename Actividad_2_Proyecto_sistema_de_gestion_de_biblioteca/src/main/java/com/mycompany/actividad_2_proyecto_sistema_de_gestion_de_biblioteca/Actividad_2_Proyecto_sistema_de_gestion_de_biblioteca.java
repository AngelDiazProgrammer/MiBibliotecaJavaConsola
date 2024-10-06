/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.actividad_2_proyecto_sistema_de_gestion_de_biblioteca;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.Scanner;

/**
 *
 * @author Angel
 */
public class Actividad_2_Proyecto_sistema_de_gestion_de_biblioteca {

    public static void main(String[] args) {
        ArrayList<String[]>libros = new ArrayList<>();
        LinkedList<String[]> usuarios = new LinkedList<>();
        Stack<String[]> librosPrestados = new Stack<>();
        Queue<String[]> colaEspera =new LinkedList<>();
        
        
        Scanner entrada = new Scanner(System.in);
        int opcionInicial;
        int opcion;
        do{
        System.out.println("============================");
            System.out.println("   Mi biblioteca virtual    ");
            System.out.println("============================");
            System.out.println("  Bienvenido a su sistema  ");
            System.out.println("  de gestion bibliotecaria ");
            System.out.println("============================");
            System.out.println("     ¿Desea iniciar?        ");
            System.out.println("============================");
            System.out.println("1. Si");
            System.out.println("2. No");
            while (!entrada.hasNextInt()){
                System.out.println("Error: Por favor ingrese un numero");
                entrada.next();
                System.out.println("     ¿Desea iniciar?        ");
            }
            
            opcionInicial = entrada.nextInt();
            entrada.nextLine();
            switch(opcionInicial){
                case 1:
            Scanner nombre = new Scanner(System.in);
            System.out.println("Ingrese su nombre");
            String empleado = nombre.next();
                    do{
            System.out.println("============================");
            System.out.println("   Mi biblioteca virtual    ");
            System.out.println("============================");
            System.out.println("  Bienvenido a su sistema  ");
            System.out.println("  de gestion bibliotecaria ");
            System.out.println("============================");
            System.out.println("¿Que deseas hacer " + empleado + " ?");
            System.out.println("1. Agregar libro");
            System.out.println("2. Registrar usuario");
            System.out.println("3. Prestar un libro");
            System.out.println("4. Devolver un libro");
            System.out.println("5. Mostrar libros disponibles");
            System.out.println("6. Mostrar usuarios registrados");
            System.out.println("7. Salir");
            System.out.println("Seleccione una opcion: ");
            while (!entrada.hasNextInt()){
                System.out.println("Error: Por favor ingrese un numero");
                entrada.next();
                System.out.println("Seleccione una opcion: ");
            }
            
            opcion = entrada.nextInt();
            entrada.nextLine();
            switch(opcion){
                case 1:
                    System.out.println("Ingrese el id del libro (unico)");
                    String idLibro = entrada.nextLine();
                    boolean idDuplicado=false;
                    for(String[]libro : libros){
                        if(libro[0].equals(idLibro)){
                            idDuplicado= true;
                                    break;
                        }
                    }
                    if(idDuplicado){
                        System.out.println("Error:ID duplicado, el libro ya existe");
                    }else{
                    System.out.println("Ingrese el nombre del libro");
                    String nombreLibro = entrada.nextLine();
                    System.out.println("Ingrese el autor del libro");
                    String autorLibro = entrada.nextLine();
                    libros.add(new String[]{idLibro,nombreLibro, autorLibro});
                        System.out.println("Libro agregado correctamente");
                    } 
                    
                    
                    break;
                case 2: // Registrar usuario
                                System.out.println("Ingrese el id del usuario (único)");
                                String idUsuario = entrada.nextLine();
                                boolean usuarioDuplicado = false;

                                for (String[] usuario : usuarios) {
                                    if (usuario[0].equals(idUsuario)) {
                                        usuarioDuplicado = true;
                                        break;
                                    }
                                }

                                if (usuarioDuplicado) {
                                    System.out.println("Error: ID duplicado, el usuario ya existe");
                                } else {
                                    System.out.println("Ingrese el nombre del usuario");
                                    String nombreUsuario = entrada.nextLine();
                                    usuarios.add(new String[]{idUsuario, nombreUsuario});
                                    System.out.println("Usuario registrado correctamente");
                                }
                                break;

                            case 3: // Prestar un libro
                                System.out.println("Ingrese el id del libro a prestar");
                                String idLibroPrestar = entrada.nextLine();
                                boolean libroEncontrado = false;

                                for (String[] libro : libros) {
                                    if (libro[0].equals(idLibroPrestar)) {
                                        librosPrestados.push(libro);
                                        libros.remove(libro);
                                        libroEncontrado = true;
                                        System.out.println("Libro prestado correctamente");
                                        break;
                                    }
                                }

                                if (!libroEncontrado) {
                                    System.out.println("Error: Libro no encontrado o ya prestado");
                                }
                                break;

                            case 4: // Devolver un libro
                                if (!librosPrestados.isEmpty()) {
                                    String[] libroDevuelto = librosPrestados.pop();
                                    libros.add(libroDevuelto);
                                    System.out.println("Libro devuelto correctamente");
                                } else {
                                    System.out.println("No hay libros prestados para devolver");
                                }
                                break;

                            case 5: // Mostrar libros disponibles
                                System.out.println("Libros disponibles:");
                                for (String[] libro : libros) {
                                    System.out.println("ID: " + libro[0] + ", Nombre: " + libro[1] + ", Autor: " + libro[2]);
                                }
                                break;

                            case 6: // Mostrar usuarios registrados
                                System.out.println("Usuarios registrados:");
                                for (String[] usuario : usuarios) {
                                    System.out.println("ID: " + usuario[0] + ", Nombre: " + usuario[1]);
                                }
                                break;

                            case 7:
                                System.out.println("Gracias por usar el sistema, hasta pronto.");
                                break;

                            default:
                                System.out.println("Opción no válida, seleccione una de las opciones indicadas");
                        }
                    } while (opcion != 7);
                    break;

                case 2:
                    System.out.println("Saliendo del sistema. ¡Hasta luego!");
                    break;

                default:
                    System.out.println("Opción no válida. Por favor seleccione 1 o 2.");
            }
        } while (opcionInicial != 2);
    }
        
        
    }


