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
public class Horario {
    private String dia, hora;

    public Horario(String dia, String hora) {
        this.dia = dia;
        this.hora = hora;
    }

    
    /** 
     * @return String
     */
    public String getDia() {
        return dia;
    }

    
    /** 
     * @param dia
     */
    public void setDia(String dia) {
        this.dia = dia;
    }

    
    /** 
     * @return String
     */
    public String getHora() {
        return hora;
    }

    
    /** 
     * @param hora
     */
    public void setHora(String hora) {
        this.hora = hora;
    }

    
    /** 
     * @return String
     */
    @Override
    public String toString() {
        return "Dia " + dia + " con hora en "+ hora;
    }
    
}
