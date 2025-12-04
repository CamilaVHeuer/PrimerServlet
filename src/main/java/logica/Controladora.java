
package logica;

import java.util.List;
import persistencia.ControladoraPersistencia;

public class Controladora {
    //instancia de controladora de la persistencia
    ControladoraPersistencia controlPersis = new ControladoraPersistencia();
    
    //operacion CREATE
    public void crearUsuario(Usuario usu){
            controlPersis.crearUsuario(usu);}
    
    //para operación READ
    public List<Usuario> traerUsuarios(){
        return controlPersis.traerUsuarios();
}

    public void borrarUsuario(int id_eliminar) {
        controlPersis.borrarUsuario(id_eliminar);
    }

    public Usuario traerUsuario(int id_editar) {
        return controlPersis.traerUsuario(id_editar);}

    public void editarUsuario(Usuario usu) {
        controlPersis.editarUsuario(usu);
    }
    
}
        