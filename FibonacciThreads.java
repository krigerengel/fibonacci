/**
 * Alumno: Angel Gabriel Guerrero Díaz
 * Actividad 4 – Versión con long + Hashtable (memoización)
 * 
 * Mejora: Se agrega una Hashtable para guardar los valores ya calculados
 *         y evitar recalcular fibonacci(n) muchas veces.
 */

import java.util.Hashtable;

public class FibonacciThreads implements Runnable {

    long fi;
    int num;

    // ✔ Memoria agregada
    static Hashtable<Long, Long> memo = new Hashtable<>();

    public FibonacciThreads(int n, long f){
        num = n;
        fi = f;
    }

    @Override
    public void run() {
        System.out.println("Hilo #" + num);
        long res = fibonacci(fi);
        System.out.println("Resultado hilo " + num + " → fibonacci(" + fi + ") = " + res);
    }

    long fibonacci(long f) {

        // ✔ Caso: valor ya en memoria
        if (memo.containsKey(f)) return memo.get(f);

        long res;

        if (f < 2)
            res = 1;
        else
            res = fibonacci(f - 1) + fibonacci(f - 2);

        // ✔ Guardar en tabla hash (memo)
        memo.put(f, res);

        return res;
    }

    static void main(){
        Thread[] threads = new Thread[10];

        for (int i = 0; i < 10; i++) {
            long valor = (long) (Math.random()*50) + 1;
            threads[i] = new Thread(new FibonacciThreads(i, valor));
        }

        for (int i = 0; i < 10; i++) threads[i].start();
    }
}
