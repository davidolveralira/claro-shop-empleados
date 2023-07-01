package org.dolvera.spring.claro.shop.consumer.controllers;

import org.dolvera.spring.claro.shop.models.entity.Empleado;
import org.dolvera.spring.claro.shop.services.EmpleadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("api/v1/spring/claroshop/empleados")
public class EmpleadoController {

    @Autowired
    private EmpleadoService service;

    private List<Empleado> empleados = new ArrayList<>();

    @PostMapping("/guardar")
    public ResponseEntity<?> create(@RequestBody Empleado empleado) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.save(empleado));
    }

    @GetMapping("/lista")
    public ResponseEntity<List<Empleado>> lista() {
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping("/salario-total")
    public double calcularSalarioTotal() {
        double salarioTotal = 0;
        for (Empleado empleado : empleados) {
            salarioTotal += empleado.getSalario();
        }
        return salarioTotal;
    }

}
