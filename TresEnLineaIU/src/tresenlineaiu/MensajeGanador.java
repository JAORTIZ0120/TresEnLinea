
package tresenlineaiu;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;



public class MensajeGanador extends JFrame{
    String nombre_usuario_1 ;
    String nombre_usuario_2 ;
    int puntos_usuario_1 ;
    int puntos_usuario_2 ;
    int turno_user ;
    public MensajeGanador(TableroTriki tablero){
        nombre_usuario_1 = tablero.nombre_user_1;
        nombre_usuario_2 =  tablero.nombre_user_2;
        puntos_usuario_1 = tablero.punto_user_01;
        puntos_usuario_2 = tablero.punto_user_02;
        turno_user = tablero.turno;
        
        
        initComponents();

    }
    
    public void initComponents(){
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
        setSize(400, 250);
        setResizable(false);
        setLocationRelativeTo(null);
        
        JPanel contenedor = new JPanel();
        GridBagLayout content = new GridBagLayout();
        contenedor.setLayout(content);
        
        GridBagConstraints desing = new GridBagConstraints();
        
        JLabel ronda = new JLabel("RONDA TERMINADA ");
        desing.gridx = 0;
        desing.gridy = 0;
        desing.gridwidth = 2;
        desing.gridheight = 1;
        desing.weightx = 2;
        desing.weighty = 0;
        desing.insets = new Insets(10, 0, 0, 0);
        desing.fill = GridBagConstraints.EAST;
        contenedor.add(ronda, desing);
        
        JLabel puntaje_actual = new JLabel("PUNTAJE ACTUAL: "+ puntos_usuario_1+ " - "+puntos_usuario_2);
        desing.gridx = 0;
        desing.gridy = 1;
        desing.gridwidth = 2;
        desing.gridheight = 1;
        desing.weightx = 1;
        desing.weighty = 0;
        desing.insets = new Insets(10, 0, 0, 0);
        desing.fill = GridBagConstraints.EAST;
        contenedor.add(puntaje_actual, desing);
        
        JButton btn_jugar_denuevo = new JButton("JUGAR DE NUEVO ");
        desing.gridx = 0;
        desing.gridy = 2;
        desing.gridwidth = 1;
        desing.gridheight = 1;
        desing.weightx = 1;
        desing.weighty = 0;
        desing.insets = new Insets(10, 10, 10, 10);
        desing.fill = GridBagConstraints.BOTH;
        contenedor.add(btn_jugar_denuevo, desing);
        
        
        JButton btn_salir = new JButton("SALIR");
        desing.gridx = 1;
        desing.gridy = 2;
        desing.gridwidth = 1;
        desing.gridheight = 1;
        desing.weightx = 1;
        desing.weighty = 0;
        desing.insets = new Insets(10, 10, 10, 10);
        desing.fill = GridBagConstraints.BOTH;
        contenedor.add(btn_salir, desing);
        
        
        ActionListener evento_jugar =  new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                TableroTriki play_again = new TableroTriki(nombre_usuario_1, nombre_usuario_2,puntos_usuario_1,puntos_usuario_2);
                
            }
        };
        
        btn_jugar_denuevo.addActionListener(evento_jugar);
        
        ActionListener salir = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        };
        btn_salir.addActionListener(salir);
       
      
 
        add(contenedor);
        revalidate();
        
        
        
    }

    
}
