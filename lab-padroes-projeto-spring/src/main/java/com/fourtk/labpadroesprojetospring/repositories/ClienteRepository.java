package com.fourtk.labpadroesprojetospring.repositories;

import com.fourtk.labpadroesprojetospring.entidades.Cliente;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteRepository extends CrudRepository<Cliente, Long> {
}
