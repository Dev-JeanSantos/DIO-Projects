package com.fourtk.labpadroesprojetospring.services.impl;

import com.fourtk.labpadroesprojetospring.entidades.Cliente;
import com.fourtk.labpadroesprojetospring.entidades.Endereco;
import com.fourtk.labpadroesprojetospring.repositories.ClienteRepository;
import com.fourtk.labpadroesprojetospring.repositories.EnderecoRepository;
import com.fourtk.labpadroesprojetospring.services.ClienteService;
import com.fourtk.labpadroesprojetospring.services.ViaCepService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ClienteServiceImpl implements ClienteService {

    @Autowired
    private ClienteRepository repository;
    @Autowired
    private EnderecoRepository enderecoRepository;

    @Autowired
    private ViaCepService viaCepService;
    @Override
    public Iterable<Cliente> buscarTodos() {
        return repository.findAll();
    }

    @Override
    public Cliente buscarPorId(Long id) {
        Optional<Cliente> cliente = repository.findById(id);
        return cliente.get();
    }

    @Override
    public void inserir(Cliente cliente) {
        salvarClienteComCep(cliente);
    }

    @Override
    public void atualizar(Long id, Cliente cliente) {
        Optional<Cliente> possivelCliente = repository.findById(id);
        if (possivelCliente.isPresent()){
            salvarClienteComCep(cliente);
        }
    }

    @Override
    public void deletar(Long id) {
        repository.deleteById(id);

    }
    private void salvarClienteComCep(Cliente cliente) {
        String cep = cliente.getEndereco().getCep();
        Endereco endereco = enderecoRepository.findById(Long.valueOf(cep)).orElseGet(() -> {
            Endereco novoEndereco = viaCepService.consultarCep(cep);
            enderecoRepository.save(novoEndereco);
            return novoEndereco;
        });
        cliente.setEndereco(endereco);
        repository.save(cliente);
    }
}
