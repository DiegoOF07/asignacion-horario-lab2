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
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Salon {
    private ArrayList<Curso> cursos;
    private ArrayList<Profesor> profesores;
    private Asignacion planHorario[][];
    private Scanner sc = new Scanner(System.in);
    private String dias[] = {"Lunes","Martes", "Miercoles", "Jueves", "Viernes"};
    private String horas[] = {
            "07:00 - 08:00",
            "08:00 - 09:00",
            "09:00 - 10:00",
            "10:00 - 11:00",
            "11:00 - 12:00",
            "12:00 - 13:00",
            "13:00 - 14:00",
            "14:00 - 15:00",
            "15:00 - 16:00",
            "16:00 - 17:00",
            "17:00 - 18:00",
            "18:00 - 19:00",
            "19:00 - 20:00",
            "20:00 - 21:00"
        };

    public Salon(){
        cursos = new ArrayList<Curso>();
        profesores = new ArrayList<Profesor>();
        planHorario = new Asignacion[14][5];
        llenarCupos();
    }

    public void llenarCupos(){
        for(int i = 0; i<planHorario.length; i++){
            for (int j = 0; j < planHorario[i].length; j++) {
                planHorario[i][j]= new Asignacion((int) (Math.random()*15+5));
            }
        }
    }

    
    /** 
     * @param codigo
     * @return Curso
     */
    public Curso buscarCurso(String codigo){
        Curso miCurso = null;
        for (Curso curso : cursos) {
            if(curso.getCodigoCurso().equals(codigo)){
                miCurso = curso;
            }
        }
        return miCurso;
    }

    
    /** 
     * @param nombre
     * @return Profesor
     */
    public Profesor buscarProfesor(String nombre){
        Profesor miProfesor = null;
        for (Profesor profesor : profesores) {
            if(profesor.getNombre().equals(nombre)){
                miProfesor = profesor;
            }
        }
        return miProfesor;
    }

    
    /** 
     * @param nombre
     * @param carne
     * @param telefono
     */
    public void agregarProfesor(String nombre, String carne, String telefono){
        if(!nombre.isEmpty() && !carne.isEmpty() && !telefono.isEmpty()){
            if(buscarProfesor(nombre) == null){
                profesores.add(new Profesor(nombre, carne, telefono));
                System.out.println("Profesor agregado con exito");
            }else{
                System.out.println("Ese profesor ya existe");
            }
        }else{
            System.out.println("No has llenado todos los datos");
        }
    }

    public void mostrarProfesores(){
        for (Profesor profesor : profesores) {
            System.out.println(profesor);
        }
    }

    
    /** 
     * @param nombreCurso
     * @param cantEstudiantes
     */
    public void agregarCurso(String nombreCurso, int cantEstudiantes){
        Curso miCurso = null;
        if(profesores.size()>0){
            if(!nombreCurso.isEmpty() && cantEstudiantes>0){
                System.out.println("Se muestran los profesores disponibles para asignar");
                mostrarProfesores();
                System.out.print("Escribe el nombre del profesor a asignar: ");
                String nombreProf = sc.nextLine();
                if(buscarProfesor(nombreProf) != null){
                    miCurso = new Curso(nombreCurso, cantEstudiantes);
                    miCurso.setProfesor(buscarProfesor(nombreProf));
                    if(buscarCurso(miCurso.getCodigoCurso())==null){
                        cursos.add(miCurso);
                        System.out.println("Curso agregado correctamente");
                    }else{
                        System.out.println("Este curso ya existe");
                    }
                }else{
                    System.out.println("No puedes agregar un profesor que no existe");
                }
                
            }else{
                System.out.println("Has ingresado un dato incorrectamente");
            }
        }else{
            System.out.println("Aun no se han agregado profesores para asignar");
        }
    }

    public void mostrarCursos(){
        for (Curso curso : cursos) {
            System.out.println(curso);
        }
    }

    public void mostrarDias(){
        for (int i = 0; i<dias.length; i++) {
            System.out.println(String.valueOf(i+1)+". "+dias[i]);
        }
    }

    public void mostrarHoras(){
        for(int i = 0; i<horas.length; i++){
            System.out.println(String.valueOf(i+1)+". "+horas[i]);
        }
    }

    
    /** 
     * @param index
     * @return String
     */
    public String identificarDia(int index){
        String dia = null;
        for (int i = 0; i<dias.length; i++) {
            if(i==index-1){
                dia = dias[i]; 
            }
        }
        return dia;
    }

    
    /** 
     * @param index
     * @return String
     */
    public String identificarHora(int index){
        String hora = null;
        for (int i = 0; i<horas.length; i++) {
            if(i==index-1){
                hora = horas[i]; 
            }
        }
        return hora;
    }

    
    /** 
     * @param codigoCurso
     */
    public void asignarCurso(String codigoCurso){
        if(buscarCurso(codigoCurso) != null){
            try {
                System.out.println("Dias para asignar");
                mostrarDias();
                System.out.print("Selecciona el dia que quieras asignar tu curso: ");
                int dia = sc.nextInt();
                sc.nextLine();
                System.out.println("Horas para asignar");
                mostrarHoras();
                System.out.print("Selecciona la hora a la que quieras asignar tu curso: ");
                int hora = sc.nextInt();
                sc.nextLine();
                if (planHorario[hora-1][dia-1].getCurso() == null){
                    if(validarCupo(dia, hora, codigoCurso)==0){
                        planHorario[hora-1][dia-1].setCurso(buscarCurso(codigoCurso));
                        planHorario[hora-1][dia-1].getCurso().setHorarios(identificarDia(dia), identificarHora(hora));
                        planHorario[hora-1][dia-1].getCurso().setCantPeriodos(planHorario[hora-1][dia-1].getCurso().getHorarios().size());
                    }else if(validarCupo(dia, hora, codigoCurso)==1){
                        System.out.println("No pueden haber mas de dos estudiantes por computadora");
                    }else if(validarCupo(dia, hora, codigoCurso)==2){
                        System.out.println("Algunos estudiantes compartiran computadora");
                        planHorario[hora-1][dia-1].setCurso(buscarCurso(codigoCurso));
                        planHorario[hora-1][dia-1].getCurso().setHorarios(identificarDia(dia), identificarHora(hora));
                        planHorario[hora-1][dia-1].getCurso().setCantPeriodos(planHorario[hora-1][dia-1].getCurso().getHorarios().size());
                    }
                    
                }else{
                    System.out.println("No te puedes asignar en ese horario, ya esta en uso");
                }
            } catch (InputMismatchException e) {
                System.out.println("Solo puedes ingresar numeros");
                sc.nextLine();
            } catch(IndexOutOfBoundsException e){
                System.out.println("No puedes seleccionar un dia u hora que no se encuentre en la lista");
            }
        }else{
            System.out.println("El curso ingresado no existe");
        }
    }

    
    /** 
     * @param dia
     * @param hora
     * @param codigo
     * @return int
     */
    public int validarCupo(int dia, int hora, String codigo){
        if(planHorario[hora-1][dia-1].getCuposDisponibles()>=buscarCurso(codigo).getCantEstudiantes()){
            return 0;
        }else if(2*planHorario[hora-1][dia-1].getCuposDisponibles()<buscarCurso(codigo).getCantEstudiantes()){
            return 1;
        }else{
            return 2;
        }
    }

    
    /** 
     * @param dia
     * @param hora
     */
    public void mostrarHorario(int dia, int hora){
        if(planHorario[hora-1][dia-1].getCurso() != null){
            System.out.println(planHorario[hora-1][dia-1]);
        }else{
            System.out.println("Este espacio se encuentra disponible para asignar un curso");
        }
    }

    
    /** 
     * @param dia
     * @param hora
     */
    public void mostrarProfesorAsignacion(int dia, int hora){
        if(planHorario[hora-1][dia-1].getCurso() != null){
            System.out.println(planHorario[hora-1][dia-1].getCurso().getProfesor());
        }else{
            System.out.println("No hay un curso asignado aun");
        }
    }

    
    /** 
     * @param dia
     * @param hora
     */
    public void eliminarAsignacion(int dia, int hora){
        try {
            planHorario[hora-1][dia-1].getCurso().deleteHorario(identificarDia(dia), identificarHora(hora));
            planHorario[hora-1][dia-1].getCurso().setCantPeriodos(planHorario[hora-1][dia-1].getCurso().getHorarios().size());
            planHorario[hora-1][dia-1].setCurso(null);
            System.out.println("Asignacion eliminada con exito");
        } catch (IndexOutOfBoundsException e) {
            System.out.println("No puedes seleccionar un dia u hora que no se encuentre en la lista");
        }
    }

    public void cambiarAsignacion(){
        try {
                System.out.println("Dias para buscar");
                mostrarDias();
                System.out.print("Selecciona el dia que esta asignado el curso que deseas cambiar: ");
                int dia = sc.nextInt();
                sc.nextLine();
                System.out.println("Horas para buscar");
                mostrarHoras();
                System.out.print("Selecciona la hora a la que este asignado el curso que deseas cambiar: ");
                int hora = sc.nextInt();
                sc.nextLine();
                if (planHorario[hora-1][dia-1].getCurso() != null){
                    System.out.println("\nSelecciona el nuevo horario para cambiar tu curso\n");
                    System.out.println("Dias para asignar");
                    mostrarDias();
                    System.out.print("Selecciona el dia que quieras asignar tu curso: ");
                    int diaNuevo = sc.nextInt();
                    sc.nextLine();
                    System.out.println("Horas para asignar");
                    mostrarHoras();
                    System.out.print("Selecciona la hora a la que quieras asignar tu curso: ");
                    int horaNueva = sc.nextInt();
                    sc.nextLine();
                    if(planHorario[horaNueva-1][diaNuevo-1].getCurso()==null){
                        if(validarCupo(diaNuevo, horaNueva, planHorario[hora-1][dia-1].getCurso().getCodigoCurso())==0){
                            planHorario[horaNueva-1][diaNuevo-1].setCurso(planHorario[hora-1][dia-1].getCurso());
                            planHorario[horaNueva-1][diaNuevo-1].getCurso().setHorarios(identificarDia(diaNuevo), identificarHora(horaNueva));
                            planHorario[horaNueva-1][diaNuevo-1].getCurso().setCantPeriodos(planHorario[horaNueva-1][diaNuevo-1].getCurso().getHorarios().size());
                            eliminarAsignacion(dia, hora); 
                        }else if(validarCupo(diaNuevo, horaNueva, planHorario[hora-1][dia-1].getCurso().getCodigoCurso())==1){
                            System.out.println("No pueden haber mas de dos estudiantes por computadora");
                        }else if(validarCupo(diaNuevo, horaNueva, planHorario[hora-1][dia-1].getCurso().getCodigoCurso())==2){
                            System.out.println("Algunos estudiantes compartiran computadora");
                            planHorario[horaNueva-1][diaNuevo-1].setCurso(planHorario[hora-1][dia-1].getCurso());
                            planHorario[horaNueva-1][diaNuevo-1].getCurso().setHorarios(identificarDia(diaNuevo), identificarHora(horaNueva));
                            planHorario[horaNueva-1][diaNuevo-1].getCurso().setCantPeriodos(planHorario[horaNueva-1][diaNuevo-1].getCurso().getHorarios().size());
                            eliminarAsignacion(dia, hora); 
                        } 
                    }else{
                        System.out.println("En donde quieres realizar el cambio ya hay un curso asignado");
                    }
                    
                }else{
                    System.out.println("No hay un curso asignado en este dia y hora para cambiar");
                }
        } catch (InputMismatchException e) {
            System.out.println("Solo puedes ingresar numeros");
            sc.nextLine();
        } catch(IndexOutOfBoundsException e){
            System.out.println("No puedes seleccionar un dia u hora que no se encuentre en la lista");
        }
    }

    
    /** 
     * @param nombre
     */
    public void mostrarHorarioProfesor(String nombre){
        if(buscarProfesor(nombre) != null){
            for(int i = 0; i<planHorario.length; i++){
                for(int j = 0; j<planHorario[i].length; j++){
                    if(planHorario[i][j].getCurso()!=null){
                        if (planHorario[i][j].getCurso().getProfesor().getNombre().equals(nombre)) {
                            System.out.println(planHorario[i][j]);
                        }
                    }
                }
            }
        }else{
            System.out.println("El profesor que buscas no existe");
        }
    }

    public void estadisticas(){
        int veces=0;
        ArrayList<Integer> vecesQueAparecen = new ArrayList<Integer>();
        for (Profesor profesor : profesores) {
            for(int i = 0; i<planHorario.length; i++){
                for(int j = 0; j<planHorario[i].length; j++){
                    if(planHorario[i][j].getCurso()!=null){
                        if (planHorario[i][j].getCurso().getProfesor().getNombre().equals(profesor.getNombre())) {
                            veces++;
                        }
                    }
                }
            }
            vecesQueAparecen.add(veces);
            veces=0;  
        }
        for (Profesor profesor : profesores) {
            int index = profesores.indexOf(profesor);
            double porcResp = ((double)(vecesQueAparecen.get(index)/70.0)*100.0);
            System.out.println("El profesor: " + profesor.getNombre() + " | " + profesor.getEmail()+ " esta al frente "+ vecesQueAparecen.get(index) + " veces");
            System.out.println("El porcentaje de responsabilidad del profesor "+profesor.getNombre() + " | " + profesor.getEmail()+ " es de "+ porcResp +"\n");
        }

    }
}
