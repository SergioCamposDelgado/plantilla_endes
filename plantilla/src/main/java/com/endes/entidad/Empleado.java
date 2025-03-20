package com.endes.entidad;

/**
 * Clase abstracta que representa a un empleado en la empresa.
 * Proporciona atributos comunes y un método base para el cálculo del sueldo.
 */
public abstract class Empleado {
    private String dni;
    private String nombre;
    private String apellidos;
    private Double sueldoBase;

    /**
     * Constructor para la clase Empleado.
     *
     * @param dni        Número de identificación del empleado.
     * @param nombre     Nombre del empleado.
     * @param apellidos  Apellidos del empleado.
     * @param sueldoBase Sueldo base del empleado (debe ser mayor o igual a 0).
     * @throws IllegalArgumentException Si algún parámetro es inválido.
     */
    public Empleado(String dni, String nombre, String apellidos, Double sueldoBase) {
        if (dni == null || dni.isEmpty()) {
            throw new IllegalArgumentException("El DNI no puede estar vacío");
        }
        if (nombre == null || nombre.isEmpty()) {
            throw new IllegalArgumentException("El nombre no puede estar vacío");
        }
        if (apellidos == null || apellidos.isEmpty()) {
            throw new IllegalArgumentException("Los apellidos no pueden estar vacíos");
        }
        if (sueldoBase == null || sueldoBase < 0) {
            throw new IllegalArgumentException("El sueldo base no puede ser negativo");
        }

        this.dni = dni;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.sueldoBase = sueldoBase;
    }

    /**
     * Obtiene el sueldo base del empleado.
     *
     * @return Sueldo base.
     */
    public Double getSueldoBase() {
        return sueldoBase;
    }

    /**
     * Establece un nuevo sueldo base para el empleado.
     *
     * @param sueldoBase Nuevo sueldo base (debe ser mayor o igual a 0).
     * @throws IllegalArgumentException Si el sueldo base es negativo.
     */
    public void setSueldoBase(Double sueldoBase) {
        if (sueldoBase == null || sueldoBase < 0) {
            throw new IllegalArgumentException("El sueldo base no puede ser negativo");
        }
        this.sueldoBase = sueldoBase;
    }

    /**
     * Obtiene el DNI del empleado.
     *
     * @return DNI del empleado.
     */
    public String getDni() {
        return dni;
    }

    /**
     * Obtiene el nombre del empleado.
     *
     * @return Nombre del empleado.
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Obtiene los apellidos del empleado.
     *
     * @return Apellidos del empleado.
     */
    public String getApellidos() {
        return apellidos;
    }

    /**
     * Calcula el sueldo total del empleado.
     *
     * @return Sueldo total, sumando el sueldo base y los extras.
     */
    public Double getSueldo() {
        return sueldoBase + calcularExtra();
    }

    /**
     * Método protegido que permite a las subclases definir sus bonificaciones específicas.
     *
     * @return Valor adicional al sueldo base.
     */
    protected abstract Double calcularExtra();
}