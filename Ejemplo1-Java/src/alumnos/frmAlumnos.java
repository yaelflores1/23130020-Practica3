package alumnos;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;

public class frmAlumnos extends JFrame {
    private JTextField txtNombre;
    private JTextField txtAPaterno;
    private JTextField txtAMaterno;
    private JTextField txtCorreo;
    private JTextField txtTelefono;
    private JComboBox cmbSexo;
    private JCheckBox chkDiscapacidad;
    private JButton aceptarButton;
    private JButton cancelarButton;
    private JTextField txtCURP;
    private JPanel pnlPrincipal;
    private JButton BotonEdad;
    private BotonGuardarListener botonGuardarListener;


    public frmAlumnos() {

        setTitle("Alumnos");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setContentPane(pnlPrincipal);
        pack();
        poblarComboBox();
        setLocationRelativeTo(null);
        aceptarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                enviarDatos();
            }
        });
        cancelarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Borrar();
            }
        });
        BotonEdad.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            Edad();
            }
        });
    }
    public void setBotonGuardarListener(BotonGuardarListener listener) {
        this.botonGuardarListener = listener;
    }
    private void enviarDatos() {
        String nombre = txtNombre.getText();
        String apaterno = txtAPaterno.getText();
        String amaterno = txtAMaterno.getText();
        String CURP = txtCURP.getText();
        String correo = txtCorreo.getText();
        String telefono = txtTelefono.getText();
        String sexo = cmbSexo.getSelectedItem().toString();
        Boolean discapacidad = chkDiscapacidad.isSelected();

        alumno dato= new alumno(nombre,apaterno,amaterno,CURP,telefono,correo,discapacidad,sexo);

        if(botonGuardarListener != null) {
            botonGuardarListener.guardando(dato);
        }
        Borrar();
    }
    private void Borrar()
    {
        txtNombre.setText("");
        txtAPaterno.setText("");
        txtAMaterno.setText("");
        txtCURP.setText("");
        txtCorreo.setText("");
        txtTelefono.setText("");
        cmbSexo.setSelectedIndex(0);
        chkDiscapacidad.setSelected(false);
    }
    private void poblarComboBox()
    {
        DefaultComboBoxModel <Genero>comboBoxModel =  (DefaultComboBoxModel<Genero>) cmbSexo.getModel();

        for(Genero genero : Genero.values()){
            comboBoxModel.addElement(genero);
        }
    }
    private void Edad(){
        String nombre = txtNombre.getText();
        String apaterno = txtAPaterno.getText();
        String amaterno = txtAMaterno.getText();
        String CURP = txtCURP.getText();
        String correo = txtCorreo.getText();
        String telefono = txtTelefono.getText();
        String sexo = cmbSexo.getSelectedItem().toString();
        Boolean discapacidad = chkDiscapacidad.isSelected();

        alumno AlumnoNuevo = new alumno(nombre, apaterno, amaterno, CURP, correo, telefono,discapacidad,sexo);
        String edadActual = AlumnoNuevo.getCURP();

        //Ventana emergente
        JOptionPane.showMessageDialog(null,"Edad: " + AlumnoNuevo.Edad(edadActual));
    }


}
