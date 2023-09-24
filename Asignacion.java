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

public class Asignacion {
    private int cuposDisponibles;
    private Curso curso;

    public Asignacion(int cuposDisponibles){
        this.cuposDisponibles = cuposDisponibles;
    }

    
    /** 
     * @return int
     */
    public int getCuposDisponibles() {
        return cuposDisponibles;
    }

    
    /** 
     * @param cuposDisponibles
     */
    public void setCuposDisponibles(int cuposDisponibles) {
        this.cuposDisponibles = cuposDisponibles;
    }

    
    /** 
     * @return Curso
     */
    public Curso getCurso() {
        return curso;
    }

    
    /** 
     * @param curso
     */
    public void setCurso(Curso curso) {
        this.curso = curso;
    }

    
    /** 
     * @return String
     */
    @Override
    public String toString() {
        if(this.curso == null){
            return "Asignacion con cupos disponibles: " + cuposDisponibles + " sin curso todavia";
        }else{
            return "Asignacion con cupos disponibles: " + cuposDisponibles + " para el " + curso;
        }
        
    }

    
}
