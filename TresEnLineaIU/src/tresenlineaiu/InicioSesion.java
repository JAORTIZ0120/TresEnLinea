package tresenlineaiu;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

public class InicioSesion extends JFrame{

    public InicioSesion(){
        initComponents();
    }
    
    public void initComponents(){
        setSize(400, 300);
        setLocationRelativeTo(null);
        setTitle("INICIO");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
        
        JPanel principal = new JPanel();
        GridBagLayout capa = new GridBagLayout();
        principal.setLayout(capa);
        principal.setBorder(new EmptyBorder(20, 20, 20, 20));
        
        GridBagConstraints restriccion = new GridBagConstraints();
        
        // Creamos elementos visuales
        JLabel etiqueta_titulo = new JLabel("TRES EN LINEA");
        etiqueta_titulo.setFont( new Font("Arial", Font.BOLD, 35)  );
        restriccion.gridx = 0;
        restriccion.gridy = 0;
        restriccion.gridwidth = 2;
        restriccion.gridheight = 1;
        restriccion.weightx = 1;
        restriccion.weighty = 4;
        restriccion.insets = new Insets(0, 0, 10, 0);
        restriccion.fill = GridBagConstraints.CENTER;
        principal.add(etiqueta_titulo, restriccion);
        
        JLabel etiqueta_usuario_1 = new JLabel("Usuario 01: ");
        restriccion.gridx = 0;
        restriccion.gridy = 1;
        restriccion.gridwidth = 1;
        restriccion.gridheight = 1;
        restriccion.weighty = 1;
        restriccion.fill = GridBagConstraints.EAST;
        principal.add(etiqueta_usuario_1, restriccion);
        
        JTextField campo_usuario_1 = new JTextField("OSCAR LOAIZA");
        campo_usuario_1.setColumns(15);
        campo_usuario_1.setMargin(new Insets(3, 3, 3, 3));
        restriccion.gridx = 1;
        restriccion.gridy = 1;
        restriccion.gridwidth = 1;
        restriccion.gridheight = 1;
        restriccion.fill = GridBagConstraints.WEST;
        principal.add(campo_usuario_1, restriccion);
        
        JLabel etiqueta_usuario_2 = new JLabel("Usuario 02:");
        restriccion.gridx = 0;
        restriccion.gridy = 2;
        restriccion.gridwidth = 1;
        restriccion.gridheight = 1;
        restriccion.fill = GridBagConstraints.EAST;
        principal.add(etiqueta_usuario_2, restriccion);
        
        JTextField campo_usuario_2= new JTextField("DANIEL GARCIA");
        campo_usuario_2.setColumns(15);
        campo_usuario_2.setMargin(new Insets(3, 3, 3, 3));
        restriccion.gridx = 1;
        restriccion.gridy = 2;
        restriccion.gridwidth = 1;
        restriccion.gridheight = 1;
        restriccion.fill = GridBagConstraints.WEST;
        principal.add(campo_usuario_2, restriccion);
        
        JButton btn_iniciar = new JButton("INICIAR");
        restriccion.gridx = 0;
        restriccion.gridy = 3;
        restriccion.gridwidth = 2;
        restriccion.gridheight = 1;
        restriccion.weighty = 4;
        restriccion.fill = GridBagConstraints.CENTER;
        restriccion.insets = new Insets(10, 0, 0, 0);
        principal.add(btn_iniciar, restriccion);
        
        Image icono = Toolkit.getDefaultToolkit().getImage(ClassLoader.getSystemResource("imagenes/icono_inicio_triki.png"));
        setIconImage(icono);
        
        ActionListener evento_iniciar = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String valor_usuario_1 = campo_usuario_1.getText();
                String valor_usuario_2 = campo_usuario_2.getText();
                
                if (!valor_usuario_1.equals("") && !valor_usuario_2.equals("")) {
                    btn_iniciar.setEnabled(false);
                    TableroTriki juego = new TableroTriki(valor_usuario_1, valor_usuario_2, 0 , 0);
                    dispose();
                }else{
                    System.out.println("Los datos son invalidos.");
                }
            }
        };
        btn_iniciar.addActionListener(evento_iniciar);
        
        add(principal);
        pack();
        setVisible(true);
    }
    
}
