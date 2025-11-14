/**
 * Alumno: Angel Gabriel Guerrero Díaz
 * Actividad 4 – Versión BigInteger + Hashtable (memoización)
 */

import java.math.BigInteger;
import java.util.Hashtable;

public class FibonacciThreadsBigInteger implements Runnable {

    BigInteger fi;
    int num;

    // ✔ Memoria agregada
    static Hashtable<BigInteger, BigInteger> memo = new Hashtable<>();

    public FibonacciThreadsBigInteger(int n, BigInteger f){
        num = n;
        fi = f;
    }

    @Override
    public void run() {
        System.out.println("Hilo #" + num);
        BigInteger res = fibonacci(fi);
        System.out.println("Resultado hilo " + num + " → fibonacci(" + fi + ") = " + res);
    }

    public BigInteger fibonacci(BigInteger f) {

        // ✔ Si ya está calculado → devolverlo
        if (memo.containsKey(f)) return memo.get(f);

        BigInteger res;

        if (f.compareTo(BigInteger.TWO) < 0) {
            res = BigInteger.ONE;
        } else {
            res = fibonacci(f.subtract(BigInteger.ONE))
                    .add(fibonacci(f.subtract(BigInteger.TWO)));
        }

        // ✔ Guardar en memoria
        memo.put(f, res);

        return res;
    }

    static void main(){

        Thread[] threads = new Thread[10];

        for (int i = 0; i < 10; i++) {
            long v = (long)(Math.random()*50) + 1;
            threads[i] = new Thread(
                    new FibonacciThreadsBigInteger(i, BigInteger.valueOf(v)));
        }

        for(int i = 0; i < 10; i++) threads[i].start();
    }
}
