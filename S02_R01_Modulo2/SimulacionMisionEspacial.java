import java.util.concurrent.*;

public class SimulacionMisionEspacial {
    public static void main(String[] args) throws Exception {
        System.out.println("        #Simulación de misión espacial iniciada...#");

        ExecutorService executor = Executors.newFixedThreadPool(4);

        Future<String> futuroNav = executor.submit(new SistemaNavegacion());
        Future<String> futuroSoporte = executor.submit(new SistemaSoporteVital());
        Future<String> futuroTermico = executor.submit(new SistemaControlTermico());
        Future<String> futuroCom = executor.submit(new SistemaComunicaciones());

        // Mostrar resultados (orden puede variar)
        System.out.println(futuroCom.get());
        System.out.println(futuroSoporte.get());
        System.out.println(futuroTermico.get());
        System.out.println(futuroNav.get());

        executor.shutdown();
        System.out.println("Todos los sistemas reportan estado operativo.");
    }
}
