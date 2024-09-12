package alumnos;

import javax.swing.*;
import java.io.FileWriter;
import java.io.IOError;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Path;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                frmAlumnos pantalla = new frmAlumnos();
                pantalla.setVisible(true);

                pantalla.setBotonGuardarListener(new BotonGuardarListener() {
                    @Override
                    public void guardando(alumno persona) {
                        System.out.println("Nombre: "+persona.getNombre());
                        System.out.println("A. Paterno: "+persona.getAPaterno());
                        System.out.println("A. Materno: "+persona.getAMaterno());
                        System.out.println("Sexo: "+persona.getSexo());
                        System.out.println("CURP: "+ persona.getCURP());
                        System.out.println("Correo: "+persona.getCorreo());
                        System.out.println("Telefono: "+persona.getTelefono());
                        System.out.println("Discapacidad: "+persona.getDiscapacidad());

                        Path path= Path.of("C:\\Users\\elgra\\Desktop\\Alejandro.txt");
                        String contenido=persona.getNombre();

                        try(FileWriter archivo= new FileWriter(path.toFile(),true)){
                            PrintWriter pw= new PrintWriter(archivo);
                            pw.println(contenido);
                            archivo.write(contenido);
                        }
                        catch(IOError e){e.getMessage();}catch (IOException e) {
                            throw new RuntimeException(e);
                        }

                    }
                });

            }
        });
    }
}
