package clases;

/**
 * Escuela Superior de Computo
 * @author Saul
 * Versión 1.0.0
 */
public class Usuario {
    /**
     * Atributo de nombre
     */
    public String nombre;
    
    /**
     * Nombre para inicio de sesión
     */
    public String nickname;
    
    /**
     * Contraseña del usuario
     */
    public String password;
    
    /**
     * Rol del usuario 
     */
    public String roll;
    
    /**
     * Devuelve el nombre
     * @return 
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Asigna el nombre al objeto Usuario
     * @param nombre 
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Devuelve el nickname
     * @return 
     */
    public String getNickname() {
        return nickname;
    }

    /**
     * Asigna el nickname al objeto Usuario
     * @param nickname 
     */
    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    /**
     * Devuelve la contraseña
     * @return 
     */
    public String getPassword() {
        return password;
    }

    /**
     * Asigna la contraseña al objeto Usuario
     * @param password 
     */
    public void setPassword(String password) {
        this.password = password;
    }
}
