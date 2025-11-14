"""
Fibonacci hacia adelante - VERSIÓN MEJORADA

Calcula el n-ésimo número de Fibonacci usando un método iterativo
optimizado y con validación de entrada.

Tema: Cálculo iterativo O(n) y actualización en espacio constante (O(1))

La idea general es evitar la recursión —que es lenta y consume memoria—
y calcular siempre “hacia adelante”, actualizando solo dos valores:
F(i-1) y F(i). Así se reduce mucho el costo y se simplifica el código.

Referencia: Classic Computer Science Problems with Python
            pag 12   fib9.py

Editor Original: Roberto Méndez Méndez
Editor: Angel Gabriel Guerrero Díaz

Created on Fri Jun 14 2024
Edited: Apr 29 2025 (Versión Original)
Edited: Nov 11 2025 (Versión Mejorada por Ángel)
"""

def fibAdel(n: int) -> int:
    
    # ====================================================================
    # <<< MEJORA APLICADA >>>
    #
    # Cambio Aplicado:
    #   - Se reemplazó completamente la estructura inicial por una versión
    #     más robusta:
    #       * Validación explícita de entrada (evita errores silenciosos).
    #       * Manejo claro de los casos base (F(0) y F(1)).
    #       * Bucle que calcula únicamente lo necesario (desde 2 hasta n).
    #
    # Función del Cambio:
    #   - Mejorar la claridad y prevenir errores.
    #   - Mantener un cálculo iterativo eficiente en tiempo O(n).
    #   - Usar espacio constante O(1) guardando solo dos valores.
    #
    # Ventaja:
    #   - Código más limpio, seguro y fácil de mantener.
    #   - Evita recursión costosa.
    #   - Optimiza el proceso sin perder legibilidad.
    # ====================================================================
    
    # 1. Validación
    if n < 0:
        raise ValueError("n debe ser no negativo")
    
    # 2. Casos base
    if n == 0 or n == 1:
        return n
    
    # 3. Cálculo iterativo hacia adelante
    penultimo, ultimo = 0, 1
    for _ in range(2, n + 1):
        penultimo, ultimo = ultimo, penultimo + ultimo
    
    return ultimo


if __name__ == "__main__":
    n = int(input("¿Fibonacci hasta la posición?: "))
    print(f"F({n}) =", fibAdel(n))
