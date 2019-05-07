/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.ups.vista;


import java.awt.Color;
import java.awt.Image;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JOptionPane;

/**
 *
 * @author Darwin
 */
public class Juego extends javax.swing.JFrame {
    
    int turno,contp,contimp;
    boolean gano=false;//indica si hay tres en raya
    public JButton[][] cuadros;//matriz para guardar los jbuttons
    
    public Color colorX=Color.BLACK;//indica el color de la letra X
    public Color colorO=Color.GREEN;//indica el color de la letra O
    
    String nom;

    /**
     * Creates new form Juego
     */
    public Juego() {
        initComponents();
        this.setTitle("Juego  Tres en Raya");
        this.setLocationRelativeTo(null);
        this.setSize(625, 648);
        
        turno=contp=contimp=1;
        cuadros=new JButton[][]{{btn1,btn2,btn3},{btn4,btn5,btn6},{btn7,btn8,btn9}};//Este arreglo almacena los jbuttons
    }
    
     public void Dato(JButton boton) {
         
        if (!gano)//verifica si no se gano el juego 
        {
            if(boton.getText().equals(""))//comprueba que el label no tenga letras
            {
                if (turno%2==1)//verifica el valor del turno para saber que letra asigna 
                {
                    boton.setText("X");
                    boton.setForeground(colorX);//asigna el color a la letra x
                    if (contimp>=3)//comprueba que ya esten almenos 3 x en el tablero 
                    {
                        verificar("X");//verifica si la x ya esta en triky
                    }
                    contimp++;//cuenta las x
                } 
                else
                {
                    boton.setText("O");
                    boton.setForeground(colorO);//asigna el color a la letra x
                    if (contp>=3) //comprueba que ya esten almenos 3 0 en el tablero 
                    {
                        verificar("O");//verifica si la o ya esta en triky
                    }
                    contp++;
                }
                turno++;//cuenta las o
            }
        }        
     
    }
     
     public void verificar(String parametro) {
        int contador=0;
        int a,b;  
        boolean reinicio=false;//inidica si ya se reinicio el juego
        for (int x = 0; x < 2; x++) {
            for (int i = 0; i < cuadros.length; i++) {  
                for (int j = 0; j < cuadros.length; j++) {
                    if (x==0) {
                      a=i;//posicion de la fila
                      b=j;//posicion de la columna 
                    }else
                    {
                        a=j;//posicion de la fila
                        b=i;//posicion de la columna 
                    }
                    if (cuadros[a][b].getText().equals(parametro)) {
                        contador++;//cuenta las de una misma letra
                    }
                }
                if (!gano&&contador==3) 
                    
                {
                    JOptionPane.showMessageDialog(null, "Tres en Raya Ha ganado "+nom);
                    if(JOptionPane.showConfirmDialog(null, "Desea iniciar un nuevo juego? ")==0)
                    {
                        nuevo();//reinicia el juego
                        reinicio=true;//inidica q el juego se reinicio
                    }
                    else
                    {
                        gano=false;                        
                    }
                    break;
                }
                contador=0;
            } 
        }
        if (!reinicio) {
            int pos;
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < cuadros.length; j++) {
                   if (i==0) {
                        pos=j;
                    } else {
                        pos=2-j;
                    }
                    if (cuadros[j][pos].getText().equals(parametro)) {
                        contador++;
                    }
                }
                if (contador==3) {
                    JOptionPane.showMessageDialog(null, "Tres en Raya Ha perdido "+nom);
                    if(JOptionPane.showConfirmDialog(null, "Desea iniciar un nuevo juego? ")==0)
                    {
                        nuevo();
                        break;
                    }
                    else
                    {
                        gano=false;
                        break;
                    }
                }
                contador=0;
            }
        }
    }

     
     
      
    //Esta funcion reinicia el juego
    public void nuevo() {
        gano=false;
        turno=contp=contimp=2;
        Color colorx=Color.red;
        Color coloro=Color.YELLOW;
        for (int i = 0; i < cuadros.length; i++) {
            for (int j = 0; j < cuadros.length; j++) {
                cuadros[i][j].setText("");
            }
        }
    }
     
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        lblIcono = new javax.swing.JLabel();
        lblJugador = new javax.swing.JLabel();
        txtJug = new javax.swing.JTextField();
        btnJugar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        btn1 = new javax.swing.JButton();
        btn2 = new javax.swing.JButton();
        btn3 = new javax.swing.JButton();
        btn4 = new javax.swing.JButton();
        btn5 = new javax.swing.JButton();
        btn6 = new javax.swing.JButton();
        btn7 = new javax.swing.JButton();
        btn8 = new javax.swing.JButton();
        btn9 = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        menuNuevo = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 204, 102));

        lblIcono.setText("X");

        lblJugador.setText("Jugador :");

        btnJugar.setText("JUGAR");
        btnJugar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnJugarMouseClicked(evt);
            }
        });

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ec/edu/ups/modelo/icono.png"))); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(19, 19, 19)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(lblIcono)
                        .addGap(18, 18, 18)
                        .addComponent(lblJugador))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(txtJug, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(28, 28, 28)
                        .addComponent(btnJugar, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblJugador, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblIcono))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtJug, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnJugar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(0, 26, Short.MAX_VALUE))
        );

        jPanel2.setLayout(new java.awt.GridLayout(3, 3));

        btn1.setFont(new java.awt.Font("OCR A Extended", 1, 95)); // NOI18N
        btn1.setToolTipText("");
        btn1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 204, 51), 2));
        btn1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn1MouseClicked(evt);
            }
        });
        jPanel2.add(btn1);

        btn2.setFont(new java.awt.Font("OCR A Extended", 1, 95)); // NOI18N
        btn2.setToolTipText("");
        btn2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 204, 51), 2));
        btn2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn2MouseClicked(evt);
            }
        });
        jPanel2.add(btn2);

        btn3.setFont(new java.awt.Font("OCR A Extended", 1, 95)); // NOI18N
        btn3.setToolTipText("");
        btn3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 204, 51), 2));
        btn3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn3MouseClicked(evt);
            }
        });
        jPanel2.add(btn3);

        btn4.setFont(new java.awt.Font("OCR A Extended", 1, 95)); // NOI18N
        btn4.setToolTipText("");
        btn4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 204, 51), 2));
        btn4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn4MouseClicked(evt);
            }
        });
        jPanel2.add(btn4);

        btn5.setFont(new java.awt.Font("OCR A Extended", 1, 95)); // NOI18N
        btn5.setToolTipText("");
        btn5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 204, 51), 2));
        btn5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn5MouseClicked(evt);
            }
        });
        jPanel2.add(btn5);

        btn6.setFont(new java.awt.Font("OCR A Extended", 1, 95)); // NOI18N
        btn6.setToolTipText("");
        btn6.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 204, 51), 2));
        btn6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn6MouseClicked(evt);
            }
        });
        jPanel2.add(btn6);

        btn7.setFont(new java.awt.Font("OCR A Extended", 1, 95)); // NOI18N
        btn7.setToolTipText("");
        btn7.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 204, 51), 2));
        btn7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn7MouseClicked(evt);
            }
        });
        jPanel2.add(btn7);

        btn8.setFont(new java.awt.Font("OCR A Extended", 1, 95)); // NOI18N
        btn8.setToolTipText("");
        btn8.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 204, 51), 2));
        btn8.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn8MouseClicked(evt);
            }
        });
        jPanel2.add(btn8);

        btn9.setFont(new java.awt.Font("OCR A Extended", 1, 95)); // NOI18N
        btn9.setToolTipText("");
        btn9.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 204, 51), 2));
        btn9.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn9MouseClicked(evt);
            }
        });
        jPanel2.add(btn9);

        menuNuevo.setText("Nuevo ");
        menuNuevo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                menuNuevoMouseClicked(evt);
            }
        });
        jMenuBar1.add(menuNuevo);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 515, Short.MAX_VALUE)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 440, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void menuNuevoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menuNuevoMouseClicked
        nuevo();
        txtJug.setText("");
        
    }//GEN-LAST:event_menuNuevoMouseClicked

    private void btnJugarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnJugarMouseClicked
        nom = this.txtJug.getText();
        //
        txtJug.setText("");
        System.out.println("boton jugar");
       
    }//GEN-LAST:event_btnJugarMouseClicked

    private void btn1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn1MouseClicked
        Dato(btn1);
    }//GEN-LAST:event_btn1MouseClicked

    private void btn2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn2MouseClicked
        Dato(btn2);
    }//GEN-LAST:event_btn2MouseClicked

    private void btn3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn3MouseClicked
        Dato(btn3);
    }//GEN-LAST:event_btn3MouseClicked

    private void btn4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn4MouseClicked
        Dato(btn4);
    }//GEN-LAST:event_btn4MouseClicked

    private void btn6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn6MouseClicked
       Dato(btn6);
    }//GEN-LAST:event_btn6MouseClicked

    private void btn5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn5MouseClicked
       Dato(btn5);
    }//GEN-LAST:event_btn5MouseClicked

    private void btn7MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn7MouseClicked
       Dato(btn7);
    }//GEN-LAST:event_btn7MouseClicked

    private void btn8MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn8MouseClicked
        Dato(btn8);
    }//GEN-LAST:event_btn8MouseClicked

    private void btn9MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn9MouseClicked
        Dato(btn9);
    }//GEN-LAST:event_btn9MouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Juego.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Juego.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Juego.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Juego.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Juego().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn1;
    private javax.swing.JButton btn2;
    private javax.swing.JButton btn3;
    private javax.swing.JButton btn4;
    private javax.swing.JButton btn5;
    private javax.swing.JButton btn6;
    private javax.swing.JButton btn7;
    private javax.swing.JButton btn8;
    private javax.swing.JButton btn9;
    private javax.swing.JButton btnJugar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel lblIcono;
    private javax.swing.JLabel lblJugador;
    private javax.swing.JMenu menuNuevo;
    private javax.swing.JTextField txtJug;
    // End of variables declaration//GEN-END:variables
}
