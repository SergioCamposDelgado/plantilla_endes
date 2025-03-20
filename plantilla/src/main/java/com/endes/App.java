package com.endes;

import com.endes.entidad.Comercial;
import com.endes.entidad.Empleado;
import com.endes.entidad.Plantilla;
import com.endes.entidad.Tecnico;

/**
 * Clase principal de la aplicación.
 * 
 * Inicializa una plantilla de empleados y muestra los empleados cuyo nombre o apellido 
 * contengan un filtro de búsqueda específico.
 */
public class App {
    /**
     * Método principal que ejecuta la aplicación.
     *
     * @param args Argumentos de la línea de comandos (no utilizados).
     */
    public static void main(String[] args) {
        // Crear una nueva plantilla de empleados
        Plantilla plantilla = new Plantilla();

        // Agregar empleados a la plantilla
        plantilla.contratarEmpleado(new Tecnico("11111111H", "Alejandro", "Fernández", 1000.0, 1)); // Técnico de categoría 1
        plantilla.contratarEmpleado(new Tecnico("22222222J", "Jerónima", "Jiménez", 1000.0, 2)); // Técnico de categoría 2

        // Comercial con 2000€ en ventas
        Comercial comercial = new Comercial("33333333P", "Desiderio", "Durán", 800.0, 2000.0);
        plantilla.contratarEmpleado(comercial);

        // Buscar empleados cuyo nombre o apellido contengan "er"
        System.out.println("Empleados encontrados con filtro 'er':");
        for (Empleado e : plantilla.getEmpleadosPorNombre("er")) {
            System.out.println(e.getNombre() + " " + e.getApellidos() + ": " + e.getSueldo() + "€");
        }
    }
}