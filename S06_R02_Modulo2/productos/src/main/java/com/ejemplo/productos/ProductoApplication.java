package com.ejemplo.productos;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class ProductoApplication {

    public static void main(String[] args) {
        SpringApplication.run(ProductoApplication.class, args);
    }

    @Bean
    public CommandLineRunner run(ProductoRepository productoRepository, MarcaRepository marcaRepository) {
        return args -> {
            // Crear marcas
            Marca apple = new Marca("Apple");
            Marca samsung = new Marca("Samsung");
            marcaRepository.saveAll(List.of(apple, samsung));

            // Crear productos asociados a marcas
            productoRepository.save(new Producto("iPhone 15", "Smartphone de Apple", 25000.00, apple));
            productoRepository.save(new Producto("iPad Pro", "Tablet potente", 30000.00, apple));
            productoRepository.save(new Producto("Galaxy S23", "Teléfono Samsung", 22000.00, samsung));
            productoRepository.save(new Producto("Smart TV", "Pantalla Samsung 4K", 15000.00, samsung));

            // Mostrar productos agrupados por marca
            System.out.println("\n Productos por marca:");
            marcaRepository.findAll().forEach(marca -> {
                System.out.println("🏷️ " + marca.getNombre() + ":");
                productoRepository.findAll().stream()
                    .filter(p -> p.getMarca().getId().equals(marca.getId()))
                    .forEach(p -> System.out.println("   - " + p.getNombre()));
            });

            // Consultas adicionales
            System.out.println("\n Productos con precio mayor a 500:");
            productoRepository.findByPrecioGreaterThan(500).forEach(System.out::println);

            System.out.println("\n  Productos que contienen 'lap':");
            productoRepository.findByNombreContainingIgnoreCase("lap").forEach(System.out::println);

            System.out.println("\n Productos con precio entre 400 y 1000:");
            productoRepository.findByPrecioBetween(400, 1000).forEach(System.out::println);

            System.out.println("\n Productos cuyo nombre empieza con 'm':");
            productoRepository.findByNombreStartingWithIgnoreCase("m").forEach(System.out::println);
        };
    }
}
