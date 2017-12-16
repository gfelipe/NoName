package br.uff.repository;

import br.uff.model.User;
import br.uff.model.UserRole;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRoleRepository extends PagingAndSortingRepository<UserRole, Long> {

    UserRole findByRole(String role);
}
