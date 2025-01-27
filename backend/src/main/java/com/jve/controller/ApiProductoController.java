package com.jve.controller;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.jve.entity.Producto;
import com.jve.repository.ProductoRepository;

import java.util.List;

@RestController
@RequestMapping("/api/productos")
public class ApiProductoController {

    private final ProductoRepository repository;

    public ApiProductoController(ProductoRepository repository){
        this.repository = repository;
    }

    //http://localhost:9000/api/productos 

    @GetMapping
    public List<Producto> findAll() {
        return repository.findAll();
    }

    //http://localhost:9000/api/productos/{id}

    @GetMapping("/{id}")
    public ResponseEntity<Producto> findById(@PathVariable Long id) {
        return repository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
}
