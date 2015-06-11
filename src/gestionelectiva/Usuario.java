package gestionelectiva;

/**
 * Escuela Superior de Computo
 * @author Saul
 * Versión 1.0.0
 */
public class Usuario {
    
    public String atributo;
    
    /**
     * Atributo Nombre Completo del Usuario
     */
    public String nombre;
    
    /**
     * Atributo Nombre de usuario
     */
    public String nickname;
    
    /**
     * Atributo Contraseña
     */
    public String password;
    
    /**
     * Clabe interna del politecnico boleta o rfc
     */
    public String clabeinterna;
   
    /**
     * Método para obtener el nombre
     * @return 
     */
    public String getNombre(){
        return this.nombre;
    }
    
    /**
     * Método para asignar el nombre
     * @param nombre
     * @return 
     */
    public void setNombre(String nombre){
        this.nombre = nombre;
    }
    
    /**
     * Método para obtener el nickname
     * @return 
     */
    public String getNickname(){
        return this.nickname;
    }
            
    /**
     * Método para asignar el nickname
     * @param nickname
     * @return 
     */
    public void setNickname(String nickname){
        this.nickname = nickname;
    }
    
    /**
     * Método para obtener la Contraseña
     * @return 
     */
    public String getPassword(){
        return this.password;
    }
    
    /**
     * Método para asignar la Contraseña
     * @param password
     * @return 
     */
    public void setPassword(String password){
        this.password = password;
    }
    
    
}
