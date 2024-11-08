/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.mycompany.actividad_2_proyecto_sistema_de_gestion_de_biblioteca;

import java.util.Scanner;
import java.util.Stack;
import java.util.LinkedList;

// Clase para representar los nodos de los libros
class NodoLibro {
    String id, nombre, autor;
    NodoLibro izquierda, derecha;

    public NodoLibro(String id, String nombre, String autor) {
        this.id = id;
        this.nombre = nombre;
        this.autor = autor;
        this.izquierda = null;
        this.derecha = null;
    }
}

// Clase para representar el árbol binario de búsqueda de libros
class ArbolBinarioLibros {
    NodoLibro raiz;

    public ArbolBinarioLibros() {
        raiz = null;
    }

    // Insertar un nuevo libro en el árbol
    public void insertar(String id, String nombre, String autor) {
        raiz = insertarRecursivo(raiz, id, nombre, autor);
    }

    private NodoLibro insertarRecursivo(NodoLibro raiz, String id, String nombre, String autor) {
        if (raiz == null) {
            return new NodoLibro(id, nombre, autor);
        }

        if (id.compareTo(raiz.id) < 0) {
            raiz.izquierda = insertarRecursivo(raiz.izquierda, id, nombre, autor);
        } else if (id.compareTo(raiz.id) > 0) {
            raiz.derecha = insertarRecursivo(raiz.derecha, id, nombre, autor);
        }

        return raiz;
    }

    // Buscar un libro por su ID
    public boolean buscar(String id) {
        return buscarRecursivo(raiz, id);
    }

    private boolean buscarRecursivo(NodoLibro raiz, String id) {
        if (raiz == null) {
            return false;
        }

        if (id.equals(raiz.id)) {
            return true;
        }

        return id.compareTo(raiz.id) < 0
                ? buscarRecursivo(raiz.izquierda, id)
                : buscarRecursivo(raiz.derecha, id);
    }

    // Mostrar todos los libros en el árbol
    public void mostrarLibros() {
        mostrarLibrosRecursivo(raiz);
    }

    private void mostrarLibrosRecursivo(NodoLibro raiz) {
        if (raiz != null) {
            mostrarLibrosRecursivo(raiz.izquierda);
            System.out.println("ID: " + raiz.id + ", Nombre: " + raiz.nombre + ", Autor: " + raiz.autor);
            mostrarLibrosRecursivo(raiz.derecha);
        }
    }

    // Eliminar un libro del árbol
    public void eliminar(String id) {
        raiz = eliminarRecursivo(raiz, id);
    }

    private NodoLibro eliminarRecursivo(NodoLibro raiz, String id) {
        if (raiz == null) {
            return null;
        }

        if (id.equals(raiz.id)) {
            if (raiz.izquierda == null && raiz.derecha == null) {
                return null; // Nodo hoja
            }

            if (raiz.derecha == null) {
                return raiz.izquierda; // Solo tiene hijo izquierdo
            }

            if (raiz.izquierda == null) {
                return raiz.derecha; // Solo tiene hijo derecho
            }

            String idMinimo = obtenerIdMinimo(raiz.derecha);
            raiz.id = idMinimo;
            raiz.derecha = eliminarRecursivo(raiz.derecha, idMinimo);
            return raiz;
        }

        if (id.compareTo(raiz.id) < 0) {
            raiz.izquierda = eliminarRecursivo(raiz.izquierda, id);
        } else {
            raiz.derecha = eliminarRecursivo(raiz.derecha, id);
        }

        return raiz;
    }

    private String obtenerIdMinimo(NodoLibro raiz) {
        return raiz.izquierda == null ? raiz.id : obtenerIdMinimo(raiz.izquierda);
    }
}

// Clase para representar los nodos de los usuarios
class NodoUsuario {
    String id, nombre;
    NodoUsuario izquierda, derecha;

    public NodoUsuario(String id, String nombre) {
        this.id = id;
        this.nombre = nombre;
        this.izquierda = null;
        this.derecha = null;
    }
}

// Clase para representar el árbol binario de búsqueda de usuarios
class ArbolBinarioUsuarios {
    NodoUsuario raiz;

    public ArbolBinarioUsuarios() {
        raiz = null;
    }

    // Insertar un nuevo usuario en el árbol
    public void insertar(String id, String nombre) {
        raiz = insertarRecursivo(raiz, id, nombre);
    }

    private NodoUsuario insertarRecursivo(NodoUsuario raiz, String id, String nombre) {
        if (raiz == null) {
            return new NodoUsuario(id, nombre);
        }

        if (id.compareTo(raiz.id) < 0) {
            raiz.izquierda = insertarRecursivo(raiz.izquierda, id, nombre);
        } else if (id.compareTo(raiz.id) > 0) {
            raiz.derecha = insertarRecursivo(raiz.derecha, id, nombre);
        }

        return raiz;
    }

    // Buscar un usuario por su ID
    public boolean buscar(String id) {
        return buscarRecursivo(raiz, id);
    }

    private boolean buscarRecursivo(NodoUsuario raiz, String id) {
        if (raiz == null) {
            return false;
        }

        if (id.equals(raiz.id)) {
            return true;
        }

        return id.compareTo(raiz.id) < 0
                ? buscarRecursivo(raiz.izquierda, id)
                : buscarRecursivo(raiz.derecha, id);
    }

    // Mostrar todos los usuarios
    public void mostrarUsuarios() {
        mostrarUsuariosRecursivo(raiz);
    }

    private void mostrarUsuariosRecursivo(NodoUsuario raiz) {
        if (raiz != null) {
            mostrarUsuariosRecursivo(raiz.izquierda);
            System.out.println("ID: " + raiz.id + ", Nombre: " + raiz.nombre);
            mostrarUsuariosRecursivo(raiz.derecha);
        }
    }
}

// Clase principal
public class Actividad_2_Proyecto_sistema_de_gestion_de_biblioteca {
    public static void main(String[] args) {
        ArbolBinarioLibros libros = new ArbolBinarioLibros();
        ArbolBinarioUsuarios usuarios = new ArbolBinarioUsuarios();
        Stack<String[]> librosPrestados = new Stack<>();

        Scanner entrada = new Scanner(System.in);
        int opcionInicial;
        int opcion;
        do {
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
            while (!entrada.hasNextInt()) {
                System.out.println("Error: Por favor ingrese un numero");
                entrada.next();
                System.out.println("     ¿Desea iniciar?        ");
            }

            opcionInicial = entrada.nextInt();
            entrada.nextLine();
            switch (opcionInicial) {
                case 1:
                    Scanner nombre = new Scanner(System.in);
                    System.out.println("Ingrese su nombre");
                    String empleado = nombre.next();
                    do {
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
                        while (!entrada.hasNextInt()) {
                            System.out.println("Error: Por favor ingrese un numero");
                            entrada.next();
                            System.out.println("Seleccione una opcion: ");
                        }

                        opcion = entrada.nextInt();
                        entrada.nextLine();
                        switch (opcion) {
                            case 1:
                                System.out.println("Ingrese el id del libro (unico)");
                                String idLibro = entrada.nextLine();
                                if (libros.buscar(idLibro)) {
                                    System.out.println("Error: ID duplicado, el libro ya existe");
                                } else {
                                    System.out.println("Ingrese el nombre del libro");
                                    String nombreLibro = entrada.nextLine();
                                    System.out.println("Ingrese el autor del libro");
                                    String autorLibro = entrada.nextLine();
                                    libros.insertar(idLibro, nombreLibro, autorLibro);
                                    System.out.println("Libro agregado correctamente");
                                }
                                break;
                            case 2: // Registro de usuario
                                System.out.println("Ingrese el id del usuario");
                                String idUsuario = entrada.nextLine();
                                if (usuarios.buscar(idUsuario)) {
                                    System.out.println("Error: El usuario ya está registrado");
                                } else {
                                    System.out.println("Ingrese el nombre del usuario");
                                    String nombreUsuario = entrada.nextLine();
                                    usuarios.insertar(idUsuario, nombreUsuario);
                                    System.out.println("Usuario registrado correctamente");
                                }
                                break;
                            case 3: // Prestar un libro
                                System.out.println("Ingrese el id del libro a prestar");
                                String idLibroPrestado = entrada.nextLine();
                                if (libros.buscar(idLibroPrestado)) {
                                    System.out.println("Ingrese el id del usuario");
                                    String idUsuarioPrestado = entrada.nextLine();
                                    if (usuarios.buscar(idUsuarioPrestado)) {
                                        librosPrestados.push(new String[]{idLibroPrestado, idUsuarioPrestado});
                                        System.out.println("Libro prestado correctamente");
                                    } else {
                                        System.out.println("Error: El usuario no está registrado");
                                    }
                                } else {
                                    System.out.println("Error: El libro no está disponible");
                                }
                                break;
                            case 4: // Devolver libro
                                System.out.println("Ingrese el id del libro a devolver");
                                String idLibroDevuelto = entrada.nextLine();
                                boolean encontrado = false;
                                for (int i = 0; i < librosPrestados.size(); i++) {
                                    String[] prestado = librosPrestados.get(i);
                                    if (prestado[0].equals(idLibroDevuelto)) {
                                        librosPrestados.remove(i);
                                        encontrado = true;
                                        break;
                                    }
                                }
                                if (encontrado) {
                                    System.out.println("Libro devuelto correctamente");
                                } else {
                                    System.out.println("Error: El libro no estaba prestado");
                                }
                                break;
                            case 5: // Mostrar libros
                                System.out.println("Libros disponibles:");
                                libros.mostrarLibros();
                                break;
                            case 6: // Mostrar usuarios
                                System.out.println("Usuarios registrados:");
                                usuarios.mostrarUsuarios();
                                break;
                            case 7:
                                System.out.println("¡Hasta pronto!");
                                break;
                            default:
                                System.out.println("Opción no válida");
                        }
                    } while (opcion != 7);
                    break;
                case 2:
                    System.out.println("¡Hasta pronto!");
                    break;
                default:
                    System.out.println("Opción no válida");
            }
        } while (opcionInicial != 2);
    }
}
