import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class Pizzeria {
    public static void main(String[] args) {
        List<Pedido> pedidos = Arrays.asList(
            new Pedido("Ana", "domicilio", "555-1234"),
            new Pedido("Luis", "local", null),
            new Pedido("Carlos", "domicilio", null),
            new Pedido("Marta", "domicilio", "555-5678"),
            new Pedido("Raúl", "local", "555-9999")
        );

        pedidos.stream()
            .filter(p -> p.getTipoEntrega().equalsIgnoreCase("domicilio"))
            .map(Pedido::getTelefono)
            .filter(Optional::isPresent)
            .map(Optional::get)
            .map(telefono -> "📞 Confirmación enviada al número: " + telefono)
            .forEach(System.out::println);
    }
}
