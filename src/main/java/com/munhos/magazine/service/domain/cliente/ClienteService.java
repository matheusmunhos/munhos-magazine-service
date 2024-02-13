package com.munhos.magazine.service.domain.cliente;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClienteService {

    private final ClienteRepository clienteRepository;

    @Autowired
    public ClienteService(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    public Cliente obterClientePorCpf(Long clienteCpf) {
        return clienteRepository.findByCpf(clienteCpf);
    }
}
