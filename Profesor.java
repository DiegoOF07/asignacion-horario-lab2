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
public class Profesor {

    private String nombre, carne, email, telefono;

    public Profesor(String nombre,  String carne, String telefono){
        this.nombre = nombre;
        this.carne = carne;
        this.telefono = telefono;
        genEmail();
    }

    public void genEmail(){
        try {
            this.email = nombre.substring(0, 3)+"@uvg.edu.gt";
        } catch (Exception e) {
            System.out.println("Ingresa un nombre de al menos 3 caracteres");
        }
    }

    
    /** 
     * @return String
     */
    public String getNombre() {
        return nombre;
    }

    
    /** 
     * @param nombre
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    
    /** 
     * @return String
     */
    public String getCarne() {
        return carne;
    }

    
    /** 
     * @param carne
     */
    public void setCarne(String carne) {
        this.carne = carne;
    }

    
    /** 
     * @return String
     */
    public String getEmail() {
        return email;
    }

    
    /** 
     * @param email
     */
    public void setEmail(String email) {
        this.email = email;
    }

    
    /** 
     * @return String
     */
    public String getTelefono() {
        return telefono;
    }

    
    /** 
     * @param telefono
     */
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    
    /** 
     * @return String
     */
    @Override
    public String toString() {
        return "Profesor: " + nombre + " | carné: " + carne + " | email: " + email + " | telefono: " + telefono;
    }

    
    
}