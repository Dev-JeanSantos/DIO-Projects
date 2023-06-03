package com.fourtk.labpadroesprojetospring.services;

import com.fourtk.labpadroesprojetospring.entidades.Cliente;

public interface ClienteService {

    Iterable<Cliente> buscarTodos();

    Cliente buscarPorId(Long id);

    void atualizar(Long id, Cliente cliente);

    void deletar(Long id);

    void inserir(Cliente cliente);


}
