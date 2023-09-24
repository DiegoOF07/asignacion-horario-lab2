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
import java.util.Calendar;
import java.util.GregorianCalendar;

public class Curso {
    private Calendar fecha;
    private String codigoCurso, nombreCurso;
    private int cantEstudiantes, cantPeriodos;
    private Profesor profesor;
    private ArrayList<Horario> horarios;

    public Curso(String nombreCurso, int cantEstudiantes){
        this.nombreCurso = nombreCurso;
        this.cantEstudiantes = cantEstudiantes;
        this.horarios = new ArrayList<Horario>();
        this.cantPeriodos = horarios.size();
        this.fecha = new GregorianCalendar();
        genCodigo();
    }

    public void genCodigo(){
        this.codigoCurso = nombreCurso.toUpperCase().substring(0, 3)+String.valueOf(fecha.get(Calendar.YEAR));
    }

    
    /** 
     * @return String
     */
    public String getCodigoCurso() {
        return codigoCurso;
    }

    
    /** 
     * @param codigoCurso
     */
    public void setCodigoCurso(String codigoCurso) {
        this.codigoCurso = codigoCurso;
    }

    
    /** 
     * @return String
     */
    public String getNombreCurso() {
        return nombreCurso;
    }

    
    /** 
     * @param nombreCurso
     */
    public void setNombreCurso(String nombreCurso) {
        this.nombreCurso = nombreCurso;
    }

    
    /** 
     * @return int
     */
    public int getCantEstudiantes() {
        return cantEstudiantes;
    }

    
    /** 
     * @param cantEstudiantes
     */
    public void setCantEstudiantes(int cantEstudiantes) {
        this.cantEstudiantes = cantEstudiantes;
    }

    
    /** 
     * @return int
     */
    public int getCantPeriodos() {
        return cantPeriodos;
    }

    
    /** 
     * @param cantPeriodos
     */
    public void setCantPeriodos(int cantPeriodos) {
        this.cantPeriodos = cantPeriodos;
    }

    
    /** 
     * @return Profesor
     */
    public Profesor getProfesor() {
        return profesor;
    }

    
    /** 
     * @param profesor
     */
    public void setProfesor(Profesor profesor) {
        this.profesor = profesor;
    }

    
    /** 
     * @return ArrayList<Horario>
     */
    public ArrayList<Horario> getHorarios() {
        return horarios;
    }

    
    /** 
     * @param dia
     * @param hora
     */
    public void setHorarios(String dia, String hora) {
        this.horarios.add(new Horario(dia, hora));
    }

    
    /** 
     * @param dia
     * @param hora
     */
    public void deleteHorario(String dia, String hora){
        this.horarios.remove(new Horario(dia, hora));
    }

    
    /** 
     * @return String
     */
    @Override
    public String toString() {
        return "Curso: " + codigoCurso + " " + nombreCurso + " | cantidad de estudiantes inscritos: "
                + cantEstudiantes + " | cantidad de periodos a la semana: " + cantPeriodos + " | profesor a cargo: " + profesor.getNombre();
    }

    
}
