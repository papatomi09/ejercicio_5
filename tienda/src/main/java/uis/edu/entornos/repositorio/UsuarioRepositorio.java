package uis.edu.entornos.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import uis.edu.entornos.modelo.Usuario;

public interface UsuarioRepositorio extends JpaRepository<Usuario, Long> {
}
