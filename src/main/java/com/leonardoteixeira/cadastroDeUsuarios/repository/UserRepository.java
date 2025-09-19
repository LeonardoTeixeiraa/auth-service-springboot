package com.leonardoteixeira.cadastroDeUsuarios.repository;

import com.leonardoteixeira.cadastroDeUsuarios.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<User, String> {
    User findByid(long id);
}
