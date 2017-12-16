package br.uff.repository;

import br.uff.model.Usuario;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends PagingAndSortingRepository<Usuario,Long> {
}
