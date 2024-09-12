package alumnos;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;

public class alumno {
    private String nombre;
    private String apaterno;
    private String amaterno;
    private String CURP;
    private String telefono;
    private String correo;
    private boolean discapacidad;
    private String sexo;
    private int edad;

    public alumno(String nombre,String apaterno,String amaterno,String CURP,String telefono,String correo,boolean discapacidad,String sexo)
    {
        this.nombre=nombre;
        this.apaterno=apaterno;
        this.amaterno=amaterno;
        this.CURP=CURP;
        this.telefono=telefono;
        this.correo=correo;
        this.discapacidad=discapacidad;
        this.sexo=sexo;
    }
    public String getNombre() {
        return nombre;
    }
    public String getAPaterno() {
        return apaterno;
    }
    public String getAMaterno() {
        return amaterno;
    }
    public String getCURP() {return CURP;}
    public String getTelefono() {
        return telefono;
    }
    public String getCorreo() {
        return correo;
    }
    public boolean isDiscapacidad() {
        return discapacidad;
    }
    public String getSexo() {
        return sexo;
    }
    public String getDiscapacidad(){
        if(discapacidad==true)
            return "Si";
        else
            return "No";
    }

    public Integer Edad(String curp){
        String fechaNacimiento = CURP.substring(4, 10);
        DateTimeFormatter FORMATO= DateTimeFormatter.ofPattern("yyMMdd");
        LocalDate FechaNac = LocalDate.parse(fechaNacimiento, FORMATO);

        if (FechaNac.isAfter(LocalDate.now())) {
            FechaNac = FechaNac.minusYears(100);
        }

        Period edad = Period.between(FechaNac, LocalDate.now());
        return edad.getYears();
    }
}
