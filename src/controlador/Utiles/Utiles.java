
package controlador.Utiles;


public class Utiles {
    public static int generarNumero(int min_val, int max_val) {
        // Verifica que min_val sea menor o igual que max_val
        if (min_val > max_val) {
            throw new IllegalArgumentException("min_val debe ser menor o igual que max_val");
        }

        // Calcula la diferencia entre max_val y min_val
        int rango = max_val - min_val + 1;

        // Genera un número aleatorio dentro del rango y lo ajusta sumando min_val
        int numeroAleatorio = (int) (Math.random() * rango) + min_val;

        return numeroAleatorio;
    }

}
