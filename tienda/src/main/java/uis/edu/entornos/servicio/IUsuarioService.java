package uis.edu.entornos.servicio;

import java.util.List;
import uis.edu.entornos.modelo.Usuario;

public interface IUsuarioService {

    List<Usuario> getUsuarios();

    Usuario nuevoUsuario(Usuario usuario);

    Usuario buscarUsuario(Long id);

    int borrarUsuario(Long id);
}
