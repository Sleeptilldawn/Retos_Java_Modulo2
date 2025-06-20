import java.util.concurrent.*;
import java.util.concurrent.ThreadLocalRandom;

public class AeropuertoControl {

    private CompletableFuture<Boolean> verificarPista() {
        return CompletableFuture.supplyAsync(() -> {
            sleepRandom();
            boolean resultado = Math.random() < 0.8;
            System.out.println("Pista disponible: " + resultado);
            return resultado;
        });
    }

    private CompletableFuture<Boolean> verificarClima() {
        return CompletableFuture.supplyAsync(() -> {
            sleepRandom();
            boolean resultado = Math.random() < 0.85;
            System.out.println("Clima favorable: " + resultado);
            return resultado;
        });
    }

    private CompletableFuture<Boolean> verificarTraficoAereo() {
        return CompletableFuture.supplyAsync(() -> {
            sleepRandom();
            boolean resultado = Math.random() < 0.9;
            System.out.println("Tráfico aéreo despejado: " + resultado);
            return resultado;
        });
    }

    private CompletableFuture<Boolean> verificarPersonalTierra() {
        return CompletableFuture.supplyAsync(() -> {
            sleepRandom();
            boolean resultado = Math.random() < 0.95;
            System.out.println("Personal disponible: " + resultado);
            return resultado;
        });
    }

    private void sleepRandom() {
        try {
            TimeUnit.SECONDS.sleep(ThreadLocalRandom.current().nextInt(2, 4));
        } catch (InterruptedException e) {
            throw new RuntimeException("Error de latencia simulada.");
        }
    }

    public void autorizarAterrizaje() {
        System.out.println("Verificando condiciones para aterrizaje...\n");

        CompletableFuture<Boolean> pista = verificarPista();
        CompletableFuture<Boolean> clima = verificarClima();
        CompletableFuture<Boolean> trafico = verificarTraficoAereo();
        CompletableFuture<Boolean> personal = verificarPersonalTierra();

        CompletableFuture<Void> allChecks = CompletableFuture.allOf(pista, clima, trafico, personal);

        allChecks.thenApplyAsync(v -> {
            try {
                boolean todas = pista.get() && clima.get() && trafico.get() && personal.get();
                return todas;
            } catch (Exception e) {
                throw new RuntimeException("Error al combinar verificaciones");
            }
        }).exceptionally(ex -> {
            System.out.println("Error en el sistema: " + ex.getMessage());
            return false;
        }).thenAccept(autorizado -> {
            if (autorizado) {
                System.out.println("Aterrizaje autorizado: todas las condiciones óptimas.");
            } else {
                System.out.println("Aterrizaje denegado: condiciones no óptimas.");
            }
        });
    }

    public static void main(String[] args) {
        AeropuertoControl control = new AeropuertoControl();
        control.autorizarAterrizaje();

        // Espera para permitir completar la ejecución
        try {
            TimeUnit.SECONDS.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
