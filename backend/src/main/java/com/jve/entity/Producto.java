package com.jve.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "productos")
public class Producto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private Double precio;
    private Integer cantidad;

    public Producto(){
    }

    public Producto(Long id, String nombre, Double precio, Integer cantidad){
        this.id = id;
        this.nombre = nombre;
        this.precio = precio;
        this.cantidad = cantidad;
    }

    public Long getId(){
        return id;
    }

    public void setId(Long id){
        this.id = id;
    }

    public String getNombre(){
        return nombre;
    }

    public void setNombre(String nombre){
        this.nombre = nombre;
    }

    public double getPrecio(){
        return precio;
    }

    public void setPrecio(Double precio){
        this.precio = precio;
    }

    public int getCantidad(){
        return cantidad;
    }

    public void setCantidad(Integer cantidad){
        this.cantidad = cantidad;
    }

    @Override
    public String toString() {
        return "ID: " + id + " Nombre: " + nombre + " Precio: " + precio + " Cantidad: " + cantidad;
    }

}
