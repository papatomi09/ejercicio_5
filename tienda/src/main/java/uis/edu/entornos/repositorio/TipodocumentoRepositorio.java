package uis.edu.entornos.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import uis.edu.entornos.modelo.TipoDocumento;

public interface TipodocumentoRepositorio extends JpaRepository<TipoDocumento, Long> {
}
