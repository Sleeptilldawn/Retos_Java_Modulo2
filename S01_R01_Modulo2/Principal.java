import java.util.ArrayList;
import java.util.List;

public class Principal {
    public static void main(String[] args) {
        List<OrdenMasa> ordenesMasa = new ArrayList<>();
        ordenesMasa.add(new OrdenMasa("M001", 100));
        ordenesMasa.add(new OrdenMasa("M002", 200));

        List<OrdenPersonalizada> ordenesPersonalizadas = new ArrayList<>();
        ordenesPersonalizadas.add(new OrdenPersonalizada("P001", 50, "Cliente A"));
        ordenesPersonalizadas.add(new OrdenPersonalizada("P002", 70, "Cliente B"));

        List<OrdenPrototipo> ordenesPrototipo = new ArrayList<>();
        ordenesPrototipo.add(new OrdenPrototipo("T001", 10, "Fase 1"));
        ordenesPrototipo.add(new OrdenPrototipo("T002", 5, "Fase 2"));

        System.out.println("== Mostrando todas las órdenes ==");
        GestorOrdenes.mostrarOrdenes(ordenesMasa);
        GestorOrdenes.mostrarOrdenes(ordenesPersonalizadas);
        GestorOrdenes.mostrarOrdenes(ordenesPrototipo);

        System.out.println("== Procesando personalizadas ==");
        GestorOrdenes.procesarPersonalizadas(ordenesPersonalizadas, 150);
    }
}