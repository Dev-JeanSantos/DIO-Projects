package com.fourtk.labpadroesprojetospring.repositories;

import com.fourtk.labpadroesprojetospring.entidades.Endereco;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EnderecoRepository extends CrudRepository<Endereco, Long> {
}
