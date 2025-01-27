package com.jve.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.jve.entity.Producto;
import com.jve.repository.ProductoRepository;



@RequestMapping("/producto")
@Controller
public class ProductoController {

    private final ProductoRepository repository;

    public ProductoController(ProductoRepository repository){
        this.repository = repository;
    }

    //http://localhost:9000/producto

    @GetMapping
    public String listarProductos(Model model) {
        List<Producto> productos = repository.findAll(); 
        model.addAttribute("productos", productos); 
        return "listado-productos"; 
    }

    //http://localhost:9000/producto/ver/{id}

    @GetMapping("/ver/{id}")
    public String VerProducto(Model model,@PathVariable Long id) {
        Optional<Producto> producto = repository.findById(id); 
        model.addAttribute("producto", producto.get()); 
        return "ver-producto"; 
    }

    //http://localhost:9000/producto/new

    //Vista de el formulario
    @GetMapping("/new")
    public String AgregarProductoFormulario(Model model){
        model.addAttribute("producto", new Producto());
        return "agregar-producto";
    }

    //Envío del formulario de agregar
    @PostMapping("/new")
    public String AgregarProducto(@RequestParam String nombre, @RequestParam Double precio, @RequestParam Integer cantidad){
        Producto producto = new Producto();
            producto.setNombre(nombre);
            producto.setPrecio(precio);
            producto.setCantidad(cantidad);
            repository.save(producto);
            return "redirect:/producto";
    }

    //http://localhost:9000/producto/editar/{id}

    //Vista de el formulario
    @GetMapping("/editar/{id}")
    public String EditarProductoFormulario(Model model, @PathVariable Long id){
        Optional<Producto> producto = repository.findById(id);
        model.addAttribute("producto", producto.get()); 
        return "editar-producto";
    }

    //Envío del formulario de editar
    @PostMapping("/editar")
    public String EditarProducto(@ModelAttribute Producto producto){
        repository.save(producto);
        return "redirect:/producto";
    }

    //http://localhost:9000/producto/borrar/{id}
    @GetMapping("/borrar/{id}")
    public String BorrarProducto(@ModelAttribute Producto producto){
        repository.delete(producto);
        return "redirect:/producto";
    }

}
