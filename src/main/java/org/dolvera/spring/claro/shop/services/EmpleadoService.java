package org.dolvera.spring.claro.shop.services;

import org.dolvera.spring.claro.shop.models.entity.Empleado;

import java.util.List;
import java.util.Optional;

public interface EmpleadoService {

    List<Empleado> findAll();
    Optional<Empleado> byId(Long id);
    Empleado save(Empleado empleado);

}
