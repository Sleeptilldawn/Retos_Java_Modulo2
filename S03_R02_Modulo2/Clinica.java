import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class Clinica {
    public static void main(String[] args) {
        // Encuestas para cada sucursal
        Sucursal centro = new Sucursal("Centro", Arrays.asList(
            new Encuesta("Laura", "El tiempo de espera fue largo", 2),
            new Encuesta("Jorge", null, 5),
            new Encuesta("Ana", null, 3)
        ));

        Sucursal norte = new Sucursal("Norte", Arrays.asList(
            new Encuesta("Carlos", "La atención fue buena, pero la limpieza puede mejorar", 3),
            new Encuesta("María", "La atención muy buena", 2),
            new Encuesta("Pedro", "Muy ruidoso", 1)
        ));

        List<Sucursal> sucursales = Arrays.asList(centro, norte);

      sucursales.stream()
    .flatMap(sucursal ->
        sucursal.getEncuestas().stream()
            .filter(e -> e.getCalificacion() <= 3) // Filtra encuestas críticas
            .map(e -> e.getComentario()
                .map(comentario -> "Sucursal " + sucursal.getNombre()
                    + ": Seguimiento a paciente con comentario: \"" + comentario + "\"")
            ) // Mapea a Optional<String>
    )
    .filter(Optional::isPresent)   // Filtra comentarios no vacíos
    .map(Optional::get)            // Extrae el comentario
    .forEach(System.out::println); // Imprime

}
}


