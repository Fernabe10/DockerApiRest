package com.jve.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.jve.entity.Producto;

@Repository
public interface ProductoRepository extends JpaRepository<Producto, Long>{
    
}
