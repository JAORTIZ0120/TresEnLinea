package tresenlineaiu;

import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

public class TableroTriki extends JFrame{
    
    String nombre_user_1;
    String nombre_user_2;
    
    JButton array_botones [][];
    JLabel etiqueta_turno_actual;
    JLabel etiqueta_puntos_01;
    JLabel etiqueta_puntos_02;
    int turno;
    int cantidad_jugadas;
    int punto_user_01;
    int punto_user_02;
            
    public TableroTriki(String nombre_user_1, String nombre_user_2, int puntos_usuario_1,  int puntos_usuario_2){
        this.nombre_user_1 = nombre_user_1;
        this.nombre_user_2 = nombre_user_2;
        
        turno = 1;
        cantidad_jugadas = 0;
        punto_user_01 = puntos_usuario_1;
        punto_user_02 = puntos_usuario_2;
        
        initComponents();
    }
    
    public void initComponents(){
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(400, 500);
        setTitle("TRES EN LINEA");
        setResizable(false);
        setLocationRelativeTo(null);
        
        JPanel principal = new JPanel();
        GridBagLayout capa = new GridBagLayout();
        principal.setLayout(capa);
        principal.setBorder(new EmptyBorder(10, 10, 10, 10));
        
        GridBagConstraints restricciones = new GridBagConstraints();
        
        JLabel etiqueta_turno = new JLabel("TURNO", SwingConstants.CENTER);
        etiqueta_turno.setFont(new Font("Arial", Font.BOLD, 45));
        restricciones.gridx = 0;
        restricciones.gridy = 0;
        restricciones.gridwidth = 3;
        restricciones.gridheight = 1;
        restricciones.weightx = 1;
        restricciones.weighty = 0;
        restricciones.insets = new Insets(10, 0, 0, 0);
        restricciones.fill = GridBagConstraints.BOTH;
        principal.add(etiqueta_turno, restricciones);
        
        etiqueta_turno_actual = new JLabel(nombre_user_1+" - X", SwingConstants.CENTER);
        etiqueta_turno_actual.setFont(new Font("Arial", Font.BOLD, 18));
        restricciones.gridx = 0;
        restricciones.gridy = 1;
        restricciones.gridwidth = 3;
        restricciones.gridheight = 1;
        restricciones.weightx = 1;
        restricciones.weighty = 0;
        restricciones.fill = GridBagConstraints.BOTH;
        restricciones.insets = new Insets(10, 0, 10, 0);
        principal.add(etiqueta_turno_actual, restricciones);
        restricciones.insets = new Insets(0, 0, 0, 0);
        
        JLabel etiqueta_usuario_01 = new JLabel(" 01 → "+nombre_user_1, SwingConstants.LEFT);
        restricciones.gridx = 0;
        restricciones.gridy = 2;
        restricciones.gridwidth = 2;
        restricciones.gridheight = 1;
        restricciones.weightx = 1;
        restricciones.weighty = 0;
        restricciones.fill = GridBagConstraints.BOTH;
        principal.add(etiqueta_usuario_01, restricciones);
        
        etiqueta_puntos_01 = new JLabel("Puntos: "+punto_user_01, SwingConstants.CENTER);
        restricciones.gridx = 2;
        restricciones.gridy = 2;
        restricciones.gridwidth = 1;
        restricciones.gridheight = 1;
        restricciones.weightx = 1;
        restricciones.weighty = 0;
        restricciones.fill = GridBagConstraints.BOTH;
        principal.add(etiqueta_puntos_01, restricciones);
        
        JLabel etiqueta_usuario_02 = new JLabel(" 02 → "+nombre_user_2, SwingConstants.LEFT);
        restricciones.gridx = 0;
        restricciones.gridy = 3;
        restricciones.gridwidth = 2;
        restricciones.gridheight = 1;
        restricciones.weightx = 1;
        restricciones.weighty = 0;
        restricciones.fill = GridBagConstraints.BOTH;
        restricciones.insets = new Insets(0, 0, 20, 0);
        principal.add(etiqueta_usuario_02, restricciones);
        
        etiqueta_puntos_02 = new JLabel("Puntos: "+punto_user_02, SwingConstants.CENTER);
        restricciones.gridx = 2;
        restricciones.gridy = 3;
        restricciones.gridwidth = 1;
        restricciones.gridheight = 1;
        restricciones.weightx = 1;
        restricciones.weighty = 0;
        restricciones.insets = new Insets(0, 0, 20, 0);
        restricciones.fill = GridBagConstraints.BOTH;
        principal.add(etiqueta_puntos_02, restricciones);
        restricciones.insets = new Insets(0, 0, 0, 0);
        
        ActionListener evento_botones = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Obtener el boton al que se dio Click
                JButton btn_presionado = (JButton) e.getSource();
                
                // Marcar Jugada
                marcarJugada( btn_presionado );
                
                // Validar Ganador
                if (validarGanador()) {
                    // Mostramos mensaje del ganador y reiniciamos
                    if (turno ==1 ) {
                        punto_user_01= punto_user_01+1; 
                    }else{
                        punto_user_02 = punto_user_02+1;
                    }
                    MensajeGanador mensaje =  new MensajeGanador(TableroTriki.this);
                    setEnabled(false);
                    dispose();
                   
                }else{
                    // Validar seguir jugando para cambiar turno o hubo empate
                    if (cantidad_jugadas==9) {
                        System.out.println("Se presento un Empate");
                        setEnabled(false);
                        MensajeGanador mensaje = new MensajeGanador(TableroTriki.this);
                    }else{
                        turno = (turno%2)+1;
                        etiqueta_turno_actual.setText( ( turno==1 )? nombre_user_1+" - X" : nombre_user_2+" - O" );
                    }
                }
            }
        };
        
        array_botones = new JButton[3][3];
        for (int i=0; i<array_botones.length; i++) {
            for (int j=0; j<array_botones[i].length; j++) {
                array_botones[i][j] = new JButton(  );
                array_botones[i][j].setFont(new Font("Arial", Font.BOLD, 30));
                array_botones[i][j].addActionListener(evento_botones);
                restricciones.gridx = j;
                restricciones.gridy = i+4;
                restricciones.gridwidth = 1;
                restricciones.gridheight = 1;
                restricciones.weightx = 1;
                restricciones.weighty = 1;
                restricciones.fill = GridBagConstraints.BOTH;
                principal.add(array_botones[i][j], restricciones);
            }
        }
        
        Image icono = Toolkit.getDefaultToolkit().getImage(ClassLoader.getSystemResource("imagenes/icono_03_tres_en_linea.png"));
        setIconImage(icono);
        
        add(principal);
        revalidate();
        setVisible(true);
    }
    
    
    public void marcarJugada(JButton btn){
        if (turno==1) {
            btn.setText("X");
        }else{
            btn.setText("O");
        }
        btn.setEnabled(false);
        cantidad_jugadas = cantidad_jugadas + 1;
    }
    
    public boolean validarGanador(){
        boolean resultado = false;
        
        char pos_1 = (!array_botones[0][0].getText().equals(""))? array_botones[0][0].getText().charAt(0) : '-';
        char pos_2 = (!array_botones[0][1].getText().equals(""))? array_botones[0][1].getText().charAt(0) : '-';
        char pos_3 = (!array_botones[0][2].getText().equals(""))? array_botones[0][2].getText().charAt(0) : '-';
        char pos_4 = (!array_botones[1][0].getText().equals(""))? array_botones[1][0].getText().charAt(0) : '-';
        char pos_5 = (!array_botones[1][1].getText().equals(""))? array_botones[1][1].getText().charAt(0) : '-';
        char pos_6 = (!array_botones[1][2].getText().equals(""))? array_botones[1][2].getText().charAt(0) : '-';
        char pos_7 = (!array_botones[2][0].getText().equals(""))? array_botones[2][0].getText().charAt(0) : '-';
        char pos_8 = (!array_botones[2][1].getText().equals(""))? array_botones[2][1].getText().charAt(0) : '-';
        char pos_9 = (!array_botones[2][2].getText().equals(""))? array_botones[2][2].getText().charAt(0) : '-';
        
        // Verticales
        if ( (pos_1==pos_4 && pos_4==pos_7 && pos_1!='-') || 
             (pos_2==pos_5 && pos_5==pos_8 && pos_2!='-') ||
             (pos_3==pos_6 && pos_6==pos_9 && pos_3!='-')    
            ) {
            resultado = true;
        }
        
        // Horizontales
        if ( (pos_1==pos_2 && pos_2==pos_3 && pos_1!='-') || 
             (pos_4==pos_5 && pos_5==pos_6 && pos_4!='-') ||
             (pos_7==pos_8 && pos_8==pos_9 && pos_7!='-')    
            ) {
            resultado = true;
        }
        
        // Diagonales
        if ( (pos_1==pos_5 && pos_5==pos_9 && pos_1!='-') || 
             (pos_7==pos_5 && pos_5==pos_3 && pos_7!='-')    
            ) {
            resultado = true;
        }
        
        return resultado;
    }
    
}
