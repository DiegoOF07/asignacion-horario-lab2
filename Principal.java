/**
 * @author: Diego Oswaldo Flores Rivas - 23714
 * @version: 12/09/23b
 * 
 * 
 * Este programa tiene como objetivo llevar el control del horario de cursos del salon CIT-411
 * mostrando una variedad de opciones que permitiran al usuario poder asignar cursos en los espacios que esten vacios
 * ademas de eso puede intercambiar cursos de lugar y eliminarlos si los desea
 * 
 * Los profesores pueden ser consultados dependiendo del horario en el que se encuentren y se pueden observar de forma
 * general junto a cuantas veces aparecen en el horario
 */

import java.util.InputMismatchException;
import java.util.Scanner;

public class Principal {
    
    /** 
     * @param args
     */
    public static void main(String[] args) {
        boolean continuar = true;
        Scanner sc = new Scanner(System.in);
        Salon salon = new Salon();
        while (continuar) {
            System.out.println("\nControl de Horario Salon CIT-411\n");
            System.out.println("1. Agregar profesores");
            System.out.println("2. Agregar cursos");
            System.out.println("3. Asignar cursos al horario");
            System.out.println("4. Mostrar una asignacion");
            System.out.println("5. Modificar una asignacion");
            System.out.println("6. Eliminar una asignacion");
            System.out.println("7. Encontrar al profesor de una asignacion");
            System.out.println("8. Mostrar horario por profesor");
            System.out.println("9. Mostrar responsabilidad de los profesores");
            System.out.println("10. Salir");
            System.out.print("Selecciona la opcion que deseas: ");
            String opcion = sc.nextLine();
            switch (opcion) {
                case "1":
                    System.out.println("\nAgregar Profesor\n");
                    System.out.print("Ingresa el nombre del profesor: ");
                    String nombre = sc.nextLine();
                    System.out.print("Ingresa el carné del profesor: ");
                    String carne = sc.nextLine();
                    System.out.print("Ingresa el telefono del profesor: ");
                    String telefono = sc.nextLine();
                    salon.agregarProfesor(nombre, carne, telefono);
                    break;
                case "2":
                    try {
                        System.out.println("\nAgregar Curso\n");
                        System.out.print("Ingresa el nombre del curso: ");
                        String nombreCurso = sc.nextLine();
                        System.out.print("Ingresa la cantidad de estudiantes inscritos: ");
                        int cantEstudiantes = sc.nextInt();
                        sc.nextLine();
                        salon.agregarCurso(nombreCurso, cantEstudiantes);
                    } catch (InputMismatchException e) {
                        System.out.println("La cantidad de estudiantes es un numero");
                        sc.nextLine();
                    }
                    break;
                case "3":
                    System.out.println("\nAsignar Curso\n");
                    salon.mostrarCursos();
                    System.out.print("Ingresa el codigo del curso que desees asignar: ");
                    String codigo = sc.nextLine();
                    salon.asignarCurso(codigo);
                    break;
                case "4":
                    try {
                        System.out.println("\nBuscar una asignacion\n");
                        System.out.println("Dias para buscar");
                        salon.mostrarDias();
                        System.out.print("Selecciona el dia que quieras buscar tu asignacion: ");
                        int dia = sc.nextInt();
                        sc.nextLine();
                        System.out.println("Horas para buscar");
                        salon.mostrarHoras();
                        System.out.print("Selecciona la hora a la que quieras buscar tu asignacion: ");
                        int hora = sc.nextInt();
                        sc.nextLine();
                        salon.mostrarHorario(dia, hora);
                    } catch (InputMismatchException e) {
                        System.out.println("Solo puedes ingresar numeros");
                        sc.nextLine();
                    }
                    break;
                case "5":
                    System.out.println("\nModificar una asignacion\n");
                    salon.cambiarAsignacion();
                    break;
                case "6":
                    try {
                        System.out.println("\nEliminar una asignacion\n");
                        System.out.println("Dias para buscar");
                        salon.mostrarDias();
                        System.out.print("Selecciona el dia que quieras eliminar tu asignacion: ");
                        int dia = sc.nextInt();
                        sc.nextLine();
                        System.out.println("Horas para buscar");
                        salon.mostrarHoras();
                        System.out.print("Selecciona la hora a la que quieras eliminar tu asignacion: ");
                        int hora = sc.nextInt();
                        sc.nextLine();
                        salon.eliminarAsignacion(dia, hora);
                    } catch (InputMismatchException e) {
                        System.out.println("Solo puedes ingresar numeros");
                        sc.nextLine();
                    }
                    break;
                case "7":
                    try {
                        System.out.println("\nBuscar profesor por asignacion\n");
                        System.out.println("Dias para buscar");
                        salon.mostrarDias();
                        System.out.print("Selecciona el dia que quieras buscar tu asignacion: ");
                        int dia = sc.nextInt();
                        sc.nextLine();
                        System.out.println("Horas para buscar");
                        salon.mostrarHoras();
                        System.out.print("Selecciona la hora a la que quieras buscar tu asignacion: ");
                        int hora = sc.nextInt();
                        sc.nextLine();
                        salon.mostrarProfesorAsignacion(dia, hora);
                    } catch (InputMismatchException e) {
                        System.out.println("Solo puedes ingresar numeros");
                        sc.nextLine();
                    }
                    break;
                case "8":
                    System.out.println("\nMostrar horarios por profesor\n");
                    salon.mostrarProfesores();
                    System.out.print("Ingresa el nombre del profesor a buscar: ");
                    String nombreProfesor = sc.nextLine();
                    salon.mostrarHorarioProfesor(nombreProfesor);
                    break;
                case "9":
                    salon.estadisticas();
                    break;
                case "10":
                    continuar = false;
                    break;
                default:
                    System.out.println("Opcion invalida");
                    break;
            }
        }
    }
        
    
}
