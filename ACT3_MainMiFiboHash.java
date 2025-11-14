/**
Tema: Clase Hashtable<K, V>

Curso: MCA1 2026-1

Objetivo: Entender el uso básico de la clase Hashtable para simular
          el Diccionario ("memoria") usado previamente en Python,
          específicamente en el programa fibonacci-MemDic1.py.

Acciones realizadas:
    1. Crear una Hashtable para almacenar posiciones y valores de Fibonacci.
    2. Insertar elementos con put(key, value).
    3. Obtener valores usando get(key).
    4. Modificar valores mediante replace(key, nuevoValor).
    5. Recorrer la tabla Hash con dos formas de foreach.
    6. Ver cómo actualizar los valores almacenados.

Mejoras / Aportación personal:
    - Comenté cada parte explicando exactamente qué hace y por qué.
    - Organicé el flujo del código para que sea más fácil de leer,
      entendiendo el paralelismo con "memoria" en Python.
    - Añadí explicaciones breves de cada operación usada en Hashtable.

Referencias:
* https://docs.oracle.com/en/java/javase/25/docs/api/java.base/java/util/Hashtable.html
* https://www.geeksforgeeks.org/java/hashtable-foreach-method-in-java-with-examples/

Software: Java 25
IDE: IntelliJ 2025.2.4

Editor original: Roberto Méndez Méndez
Editor de esta versión: Ángel Gabriel Guerrero Díaz

Created: 1 Nov 2025 (versión base)
Edited: 11 Nov 2025 (versión explicada por Ángel)
*/

import java.util.Hashtable;

public class MainMiFiboHash {

    public static void main(String[] args) {

        System.out.println("Uso de la clase Hashtable<K, V>");

        // ============================================================
        // 1. Creación de la Hashtable
        //    (Simula la memoria que usábamos en Python con diccionarios)
        // ============================================================
        Hashtable<Integer, Integer> fiboSuc = new Hashtable<>();
        fiboSuc.put(0, 0);
        fiboSuc.put(1, 1);
        fiboSuc.put(2, 1);

        // ============================================================
        // 2. Forma 1 de recorrer la Hashtable (foreach sobre keySet)
        // ============================================================
        System.out.println("\n--- Forma 1: foreach sobre keySet() ---");
        for (int key : fiboSuc.keySet()) {

            // get(key) obtiene el valor usando la llave
            int val = fiboSuc.get(key);

            System.out.printf(
                "El valor de fibonacci en la posición %d es %d %n", 
                key, val
            );
        }

        // ============================================================
        // 3. Forma 2 de recorrer con forEach (lambda)
        // ============================================================
        System.out.println("\n--- Forma 2: usando forEach((k, v) -> ...) ---");
        fiboSuc.forEach((key, value) ->
            System.out.println("Key: " + key + ", Value: " + value)
        );

        // ============================================================
        // 4. Modificar valores: replace(k, nuevoValor)
        // ============================================================
        System.out.println("\n--- Modificando valores: Fibonacci + 100 ---");
        fiboSuc.forEach((k, v) -> {

            int nuevoValor = v + 100;  // modificación
            fiboSuc.replace(k, nuevoValor); // guarda el cambio

            System.out.println("Key: " + k + ", Value: " + nuevoValor);
        });
    }
}
