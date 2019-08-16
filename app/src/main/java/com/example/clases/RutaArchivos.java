package com.example.clases;

import org.jetbrains.annotations.Contract;

public class RutaArchivos {

    private static final String RUTADONACIONES = "src/main/java/com/example/clases/donaciones.bin";
    private static final String RUTADONACIONESINFO = "src/main/java/com/example/clases/info.bin";
    private static final String RUTACLASIFICACION = "src/main/java/com/example/clases/clasificacion.bin";
    private static final String RUTAUBICACION = "src/main/java/com/example/clases/ubicacion.bin";

    private RutaArchivos(){}

    @Contract(pure = true)
    public static String getRUTADONACIONES() {
        return RUTADONACIONES;
    }

    @Contract(pure = true)
    public static String getRUTADONACIONESINFO() {
        return RUTADONACIONESINFO;
    }

    @Contract(pure = true)
    public static String getRUTACLASIFICACION() {
        return RUTACLASIFICACION;
    }

    @Contract(pure = true)
    public static String getRUTAUBICACION() {
        return RUTAUBICACION;
    }
}
