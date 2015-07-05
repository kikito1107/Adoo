package modelo;

/**
 * Escuela Superior de Computo
 * @author Saul
 * Versión 1.0.0
 */
abstract class Usuario {
    
    protected String nombre;
    protected String nickname;
    protected String password;
    protected String rol;
    
    public Usuario(String nombre, String nickname, String password, String rol){
        this.nombre = nombre;
        this.nickname = nickname;
        this.password = password;
        this.rol = rol;
    }
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }
}
