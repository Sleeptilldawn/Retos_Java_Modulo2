package com.ejemplo.producto;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@Validated
public class ProductoApplication implements CommandLineRunner {

    @Autowired
    private ProductoRepository productoRepository;

    public static void main(String[] args) {
        SpringApplication.run(ProductoApplication.class, args);
    }

    @Override
    public void run(String... args) {
        try {
            productoRepository.save(new Producto("Laptop Lenovo", "Potente laptop para oficina", 12500.00));
            productoRepository.save(new Producto("Mouse Logitech", "Mouse inalámbrico", 350.00));
            productoRepository.save(new Producto("Teclado Mecánico", "Teclado retroiluminado", 950.00));
            productoRepository.save(new Producto("Monitor", "Pantalla HD 24 pulgadas", 3200.00));
        } catch (ConstraintViolationException e) {
            System.out.println("Error de validación: " + e.getMessage());
        }

        System.out.println("\nProductos con precio mayor a 500:");
        List<Producto> caros = productoRepository.findByPrecioGreaterThan(500);
        caros.forEach(System.out::println);

        System.out.println("\n Productos que contienen 'lap':");
        productoRepository.findByNombreContainingIgnoreCase("lap").forEach(System.out::println);

        System.out.println("\n Productos con precio entre 400 y 1000:");
        productoRepository.findByPrecioBetween(400, 1000).forEach(System.out::println);

        System.out.println("\n Productos cuyo nombre empieza con 'm':");
        productoRepository.findByNombreStartingWithIgnoreCase("m").forEach(System.out::println);
    }
}

