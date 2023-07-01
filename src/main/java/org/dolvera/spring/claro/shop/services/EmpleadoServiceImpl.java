package org.dolvera.spring.claro.shop.services;

import org.dolvera.spring.claro.shop.models.entity.Empleado;
import org.dolvera.spring.claro.shop.repository.EmpleadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class EmpleadoServiceImpl implements EmpleadoService{

    @Autowired
    private EmpleadoRepository repository;
    @Override
    @Transactional(readOnly = true)
    public List<Empleado> findAll() {
        return (List<Empleado>) repository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Empleado> byId(Long id) {
        return repository.findById(id);
    }

    @Override
    @Transactional
    public Empleado save(Empleado empleado) {
        return repository.save(empleado);
    }
}
