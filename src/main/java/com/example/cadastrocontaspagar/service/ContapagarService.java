package com.example.cadastrocontaspagar.service;

import com.example.cadastrocontaspagar.model.Contaspagar;
import com.example.cadastrocontaspagar.repository.ContapagarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ContapagarService {

    @Autowired
    private ContapagarRepository contapagarRepository;

    // salvar conta a pagar
    public Contaspagar save(Contaspagar contaspagar) {
        return contapagarRepository.save(contaspagar);
    }

    //busca contas a pagar
    public List<Contaspagar> findAll() {
        return contapagarRepository.findAll();
    }

    //busca ID
    public Optional<Contaspagar> findById(Long id) {
        return contapagarRepository.findById(id);
    }

    //atualizar contas a pagar
    public Contaspagar update(Long id, Contaspagar contaspagar) {
        if (contaspagar.getId() == null) {
            throw new IllegalArgumentException("ID da conta a pagar não pode ser nulo");
        }
        return contapagarRepository.save(contaspagar);
    }

    public void deleteById(Long id) {
        contapagarRepository.deleteById(id);
    }

}
