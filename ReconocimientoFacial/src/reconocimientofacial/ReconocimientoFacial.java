/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reconocimientofacial;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.util.ArrayList;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author Rubén González V
 */
public class ReconocimientoFacial extends javax.swing.JFrame {

    public int[][] imagenMeta;
    public double[] distanciaMeta;
    public double[] distancia;
    public int actualClick;
    public int[][][] imagenes;
    public double[][] distancias;
    public ArrayList<String> nombres = new ArrayList<>();

    /**
     * Creates new form ReconocimientoFacial
     *
     */
    public ReconocimientoFacial() {
        initComponents();

        imagenMeta = new int[11][2];
        distanciaMeta = new double[55];
        distancia = new double[6];
        distancias = new double[6][55];
        nombres.add("Tom Cruise");
        nombres.add("Brad Pitt");
        nombres.add("Keanu Reeves");
        nombres.add("Keira Knightley");
        nombres.add("Felicity Jones");
        nombres.add("Adele");
        base();
        this.setLocationRelativeTo(null);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnEscogerImagen1 = new javax.swing.JButton();
        label = new javax.swing.JLabel();
        labelImagen = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Reconocimiento Facial");

        btnEscogerImagen1.setBackground(java.awt.SystemColor.textHighlight);
        btnEscogerImagen1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        btnEscogerImagen1.setForeground(javax.swing.UIManager.getDefaults().getColor("CheckBoxMenuItem.selectionBackground"));
        btnEscogerImagen1.setText("Comenzar");
        btnEscogerImagen1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEscogerImagen1ActionPerformed(evt);
            }
        });

        label.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        labelImagen.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                labelImagenMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(163, 163, 163)
                .addComponent(btnEscogerImagen1, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addComponent(label, javax.swing.GroupLayout.PREFERRED_SIZE, 491, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGroup(layout.createSequentialGroup()
                .addGap(74, 74, 74)
                .addComponent(labelImagen, javax.swing.GroupLayout.PREFERRED_SIZE, 362, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnEscogerImagen1, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(label, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(labelImagen, javax.swing.GroupLayout.PREFERRED_SIZE, 372, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnEscogerImagen1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEscogerImagen1ActionPerformed
        // TODO add your handling code here:
        imagenMeta = new int[11][2];
        distanciaMeta = new double[55];
        distancia = new double[6];
        actualClick = 0;
        abrirImagen();
    }//GEN-LAST:event_btnEscogerImagen1ActionPerformed

    private void labelImagenMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_labelImagenMouseClicked
        // TODO add your handling code here:
        Graphics g = labelImagen.getGraphics();
        g.setColor(Color.red);
        g.fillOval(evt.getX(), evt.getY(), 5, 5);
        if (actualClick == 10) {
            calcularDistanciasMeta();
            normalizar();
            calcularDistancias();
            resultado();
        } else {
            int x = evt.getX();
            int y = evt.getY();
            imagenMeta[actualClick][0] = x;
            imagenMeta[actualClick][1] = y;
            switch (++actualClick) {
                case 1:
                    label.setText("Haga Click en el extremo externo del ojo ubicado en la parte izquierda de la imagen");
                    break;
                case 2:
                    label.setText("Haga Click en el extremo interno del ojo ubicado en la parte izquierda de la imagen");
                    break;
                case 3:
                    label.setText("Haga Click en el extremo interno del ojo ubicado en la parte derecha de la imagen");
                    break;
                case 4:
                    label.setText("Haga Click en el extremo externo del ojo ubicado en la parte derecha de la imagen");
                    break;
                case 5:
                    label.setText("Haga Click en el punto central de la base de la nariz");
                    break;
                case 6:
                    label.setText("Haga Click en el extremo de la boca ubicado en la parte izquierda de la imagen");
                    break;
                case 7:
                    label.setText("Haga Click en el extremo de la boca ubicado en la parte derecha de la imagen");
                    break;
                case 8:
                    label.setText("Haga Click en el punto medio de la parte alta del labio superior");
                    break;
                case 9:
                    label.setText("Haga Click en el punto medio de la parte baja del labio inferior");
                    break;
                case 10:
                    label.setText("Haga Click en el punto medio de la base de la barbilla");
                    break;
            }
        }
    }//GEN-LAST:event_labelImagenMouseClicked

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
            java.util.logging.Logger.getLogger(ReconocimientoFacial.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ReconocimientoFacial.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ReconocimientoFacial.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ReconocimientoFacial.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new ReconocimientoFacial().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEscogerImagen1;
    private javax.swing.JLabel label;
    private javax.swing.JLabel labelImagen;
    // End of variables declaration//GEN-END:variables

    /**
     * Base de Datos con 6 vectores con 55 distancias
     */
    public void base() {
        distancias[0][0] = 0.7081305240188089;
        distancias[0][1] = 0.6175167291451252;
        distancias[0][2] = 0.6263809866252925;
        distancias[0][3] = 0.7061348492454771;
        distancias[0][4] = 1.0;
        distancias[0][5] = 1.1938514566595988;
        distancias[0][6] = 1.1880214749849438;
        distancias[0][7] = 1.1533526807537162;
        distancias[0][8] = 1.2516800886982298;
        distancias[0][9] = 0.9061853376544762;
        distancias[0][10] = 0.23311128740153902;
        distancias[0][11] = 0.5276033149712147;
        distancias[0][12] = 0.7731670114775172;
        distancias[0][13] = 0.5553000160758476;
        distancias[0][14] = 0.6232188710125571;
        distancias[0][15] = 0.8068218528750614;
        distancias[0][16] = 0.6739308697078822;
        distancias[0][17] = 0.7627785930575591;
        distancias[0][18] = 1.0262794643788589;
        distancias[0][19] = 0.29452025722176195;
        distancias[0][20] = 0.5401502708801512;
        distancias[0][21] = 0.42721901614774926;
        distancias[0][22] = 0.5829073517246888;
        distancias[0][23] = 0.6628107609591609;
        distancias[0][24] = 0.5730102940171641;
        distancias[0][25] = 0.6710209162975153;
        distancias[0][26] = 1.1535484352199084;
        distancias[0][27] = 0.24660415202787708;
        distancias[0][28] = 0.41719161853228753;
        distancias[0][29] = 0.6531450275204954;
        distancias[0][30] = 0.5660059842833235;
        distancias[0][31] = 0.5639077466331074;
        distancias[0][32] = 0.656879449191654;
        distancias[0][33] = 1.3592745457997595;
        distancias[0][34] = 0.5686592555194798;
        distancias[0][35] = 0.8162353634780718;
        distancias[0][36] = 0.6227356150546388;
        distancias[0][37] = 0.6890884454377361;
        distancias[0][38] = 0.7662488628610966;
        distancias[0][39] = 1.5353558473502809;
        distancias[0][40] = 0.24759407540760445;
        distancias[0][41] = 0.25173914325012736;
        distancias[0][42] = 0.1533626890799599;
        distancias[0][43] = 0.2518138765583642;
        distancias[0][44] = 1.5670034918760471;
        distancias[0][45] = 0.34988211077258347;
        distancias[0][46] = 0.16844781391984728;
        distancias[0][47] = 0.19026865240313934;
        distancias[0][48] = 1.6465754241238058;
        distancias[0][49] = 0.1849531140209078;
        distancias[0][50] = 0.1893765308582883;
        distancias[0][51] = 1.8127651496196244;
        distancias[0][52] = 0.09891596226678463;
        distancias[0][53] = 1.6969981754147099;
        distancias[0][54] = 1.788132666287167;

        distancias[1][0] = 0.7242517859027601;
        distancias[1][1] = 0.6456596749114003;
        distancias[1][2] = 0.6332609105420439;
        distancias[1][3] = 0.708839943103049;
        distancias[1][4] = 1.0;
        distancias[1][5] = 1.1712213180208764;
        distancias[1][6] = 1.1469270821150315;
        distancias[1][7] = 1.1194963539844358;
        distancias[1][8] = 1.2542402282712608;
        distancias[1][9] = 1.1568420000319863;
        distancias[1][10] = 0.23004283955210839;
        distancias[1][11] = 0.4841432267231234;
        distancias[1][12] = 0.7225555926328464;
        distancias[1][13] = 0.5273778149276146;
        distancias[1][14] = 0.5518657004393547;
        distancias[1][15] = 0.7730435142055543;
        distancias[1][16] = 0.6256635038383156;
        distancias[1][17] = 0.7349462466068248;
        distancias[1][18] = 1.3251806291878967;
        distancias[1][19] = 0.25433567344121705;
        distancias[1][20] = 0.4928382129594183;
        distancias[1][21] = 0.3947968920282904;
        distancias[1][22] = 0.5264821825548296;
        distancias[1][23] = 0.6108549092139208;
        distancias[1][24] = 0.5117546054894058;
        distancias[1][25] = 0.6407682432875706;
        distancias[1][26] = 1.4595174857519542;
        distancias[1][27] = 0.23850359908340213;
        distancias[1][28] = 0.39447799303277153;
        distancias[1][29] = 0.6218299925563155;
        distancias[1][30] = 0.5137181795341598;
        distancias[1][31] = 0.5073087765996181;
        distancias[1][32] = 0.6405718091188568;
        distancias[1][33] = 1.6218252497416985;
        distancias[1][34] = 0.5231249401387948;
        distancias[1][35] = 0.7796896386028717;
        distancias[1][36] = 0.52916453201068;
        distancias[1][37] = 0.6096175246025513;
        distancias[1][38] = 0.7272430519310088;
        distancias[1][39] = 1.792905587449371;
        distancias[1][40] = 0.26020573091538196;
        distancias[1][41] = 0.2519743333886108;
        distancias[1][42] = 0.1200406844364015;
        distancias[1][43] = 0.25433567344121705;
        distancias[1][44] = 1.8406162309782965;
        distancias[1][45] = 0.4301879429356062;
        distancias[1][46] = 0.22562383802453861;
        distancias[1][47] = 0.2416488373320708;
        distancias[1][48] = 1.866484775336191;
        distancias[1][49] = 0.2062453044260282;
        distancias[1][50] = 0.24641910647970916;
        distancias[1][51] = 2.070142399568886;
        distancias[1][52] = 0.13485269904778766;
        distancias[1][53] = 1.9471529165018424;
        distancias[1][54] = 2.0600719162265113;

        distancias[2][0] = 0.718038863157206;
        distancias[2][1] = 0.6564612227476582;
        distancias[2][2] = 0.646113366946385;
        distancias[2][3] = 0.7043036676089135;
        distancias[2][4] = 1.0;
        distancias[2][5] = 1.2022035248422984;
        distancias[2][6] = 1.1784791457052644;
        distancias[2][7] = 1.1711166998608815;
        distancias[2][8] = 1.2515747243319633;
        distancias[2][9] = 1.2761641022319092;
        distancias[2][10] = 0.21876498194651103;
        distancias[2][11] = 0.49938570722829234;
        distancias[2][12] = 0.7196330730941007;
        distancias[2][13] = 0.5504803805641801;
        distancias[2][14] = 0.6074121520929853;
        distancias[2][15] = 0.7956909873435163;
        distancias[2][16] = 0.6780519403656041;
        distancias[2][17] = 0.7532376683313033;
        distancias[2][18] = 1.2765061456854465;
        distancias[2][19] = 0.28158584238254325;
        distancias[2][20] = 0.5028160806040831;
        distancias[2][21] = 0.40204117671733813;
        distancias[2][22] = 0.551619221336499;
        distancias[2][23] = 0.6349957836815258;
        distancias[2][24] = 0.5592823310139946;
        distancias[2][25] = 0.6403443821057592;
        distancias[2][26] = 1.4480546295273178;
        distancias[2][27] = 0.22161505654593533;
        distancias[2][28] = 0.38135251512382706;
        distancias[2][29] = 0.6331023249745107;
        distancias[2][30] = 0.5326962998608141;
        distancias[2][31] = 0.5490907776754588;
        distancias[2][32] = 0.6252966553809154;
        distancias[2][33] = 1.6658024134824583;
        distancias[2][34] = 0.5067080713557663;
        distancias[2][35] = 0.779162456550067;
        distancias[2][36] = 0.5654924570347204;
        distancias[2][37] = 0.6501128037284172;
        distancias[2][38] = 0.7133496107249367;
        distancias[2][39] = 1.8395384675329363;
        distancias[2][40] = 0.27342504478551666;
        distancias[2][41] = 0.24556086094010995;
        distancias[2][42] = 0.1713440966426839;
        distancias[2][43] = 0.25159789482849065;
        distancias[2][44] = 1.8264242046059649;
        distancias[2][45] = 0.384203788580511;
        distancias[2][46] = 0.1920663823398106;
        distancias[2][47] = 0.21537112231546165;
        distancias[2][48] = 1.8490512297404413;
        distancias[2][49] = 0.19220839077498944;
        distancias[2][50] = 0.19890560054038234;
        distancias[2][51] = 2.07085933616394;
        distancias[2][52] = 0.08159394354647416;
        distancias[2][53] = 1.9506181900435529;
        distancias[2][54] = 2.02226353261921;

        distancias[3][0] = 0.7249445448739664;
        distancias[3][1] = 0.6254821330769378;
        distancias[3][2] = 0.6374708255548822;
        distancias[3][3] = 0.6979295074310667;
        distancias[3][4] = 1.0;
        distancias[3][5] = 1.160908820636231;
        distancias[3][6] = 1.1334902886411002;
        distancias[3][7] = 1.1043087882360283;
        distancias[3][8] = 1.2512960946862746;
        distancias[3][9] = 1.4127622714095314;
        distancias[3][10] = 0.25867766621896143;
        distancias[3][11] = 0.5732468037564598;
        distancias[3][12] = 0.8041906942125141;
        distancias[3][13] = 0.5937547396252015;
        distancias[3][14] = 0.567982639344941;
        distancias[3][15] = 0.8098796517432126;
        distancias[3][16] = 0.6550052999419445;
        distancias[3][17] = 0.7811456533812531;
        distancias[3][18] = 1.5081427256081976;
        distancias[3][19] = 0.31457077408086054;
        distancias[3][20] = 0.5462402687288901;
        distancias[3][21] = 0.431494333193382;
        distancias[3][22] = 0.5366785211911705;
        distancias[3][23] = 0.6248180354433268;
        distancias[3][24] = 0.5215863869864483;
        distancias[3][25] = 0.6662798851951401;
        distancias[3][26] = 1.673244160109816;
        distancias[3][27] = 0.23440933982094567;
        distancias[3][28] = 0.40666999220897887;
        distancias[3][29] = 0.6541472058818087;
        distancias[3][30] = 0.49934019178998246;
        distancias[3][31] = 0.5128037307864373;
        distancias[3][32] = 0.6511537239534327;
        distancias[3][33] = 1.9013473164210228;
        distancias[3][34] = 0.5601898253467289;
        distancias[3][35] = 0.8410327779777077;
        distancias[3][36] = 0.5657855728521116;
        distancias[3][37] = 0.6556388215589849;
        distancias[3][38] = 0.7725003963507204;
        distancias[3][39] = 2.054795423798244;
        distancias[3][40] = 0.29394262414449496;
        distancias[3][41] = 0.2193394579010397;
        distancias[3][42] = 0.10690710747102201;
        distancias[3][43] = 0.25169155189652836;
        distancias[3][44] = 2.090204714556571;
        distancias[3][45] = 0.44815186027738313;
        distancias[3][46] = 0.24017267728965222;
        distancias[3][47] = 0.2753242779784393;
        distancias[3][48] = 2.0605397282912934;
        distancias[3][49] = 0.20977853396031776;
        distancias[3][50] = 0.24047752955193177;
        distancias[3][51] = 2.2961482032441007;
        distancias[3][52] = 0.14742755260324308;
        distancias[3][53] = 2.161136029537585;
        distancias[3][54] = 2.289245874481425;

        distancias[4][0] = 0.7277489244992579;
        distancias[4][1] = 0.6607405199335674;
        distancias[4][2] = 0.7526446627986585;
        distancias[4][3] = 0.;
        distancias[4][4] = 1.0;
        distancias[4][5] = 1.2073953239134614;
        distancias[4][6] = 1.2176923119055933;
        distancias[4][7] = 1.1290181933542327;
        distancias[4][8] = 1.252419623486792;
        distancias[4][9] = 0.9614295714243705;
        distancias[4][10] = 0.1908908231382051;
        distancias[4][11] = 0.4830060017099801;
        distancias[4][12] = 0.7223916603772907;
        distancias[4][13] = 0.46171332095949447;
        distancias[4][14] = 0.57226858159414;
        distancias[4][15] = 0.7405668817590897;
        distancias[4][16] = 0.5582797690925534;
        distancias[4][17] = 0.679918390206531;
        distancias[4][18] = 1.1391914788276492;
        distancias[4][19] = 0.29240877239475976;
        distancias[4][20] = 0.5315045717833382;
        distancias[4][21] = 0.3700960662664438;
        distancias[4][22] = 0.550858499712224;
        distancias[4][23] = 0.6344265992426465;
        distancias[4][24] = 0.4915000044102341;
        distancias[4][25] = 0.6185195825424118;
        distancias[4][26] = 1.243600961965355;
        distancias[4][27] = 0.24042351841717252;
        distancias[4][28] = 0.3832927012058642;
        distancias[4][29] = 0.6204603921813995;
        distancias[4][30] = 0.5450778170037701;
        distancias[4][31] = 0.5054615014813382;
        distancias[4][32] = 0.6136783816213214;
        distancias[4][33] = 1.4523331836395457;
        distancias[4][34] = 0.5531622178948581;
        distancias[4][35] = 0.7849745034701865;
        distancias[4][36] = 0.6129621059678985;
        distancias[4][37] = 0.6531382666600715;
        distancias[4][38] = 0.7347367898023192;
        distancias[4][39] = 1.6220019030230528;
        distancias[4][40] = 0.23790997471599243;
        distancias[4][41] = 0.2788912813639201;
        distancias[4][42] = 0.12938270515437364;
        distancias[4][43] = 0.25307359161826126;
        distancias[4][44] = 1.5953980060435897;
        distancias[4][45] = 0.3196819228419204;
        distancias[4][46] = 0.13769363664401613;
        distancias[4][47] = 0.15699490069403732;
        distancias[4][48] = 1.7014376783797884;
        distancias[4][49] = 0.21504133222818816;
        distancias[4][50] = 0.17849725957644444;
        distancias[4][51] = 1.8715762575597266;
        distancias[4][52] = 0.12703829471344233;
        distancias[4][53] = 1.6974377154075084;
        distancias[4][54] = 1.8186573209010686;

        distancias[5][0] = 0.7727103068253404;
        distancias[5][1] = 0.7003443677952569;
        distancias[5][2] = 0.7009984016852369;
        distancias[5][3] = 0.759620567556847;
        distancias[5][4] = 1.0;
        distancias[5][5] = 1.1511691254242138;
        distancias[5][6] = 1.1539829014950933;
        distancias[5][7] = 1.1118528967773544;
        distancias[5][8] = 1.2363752672495683;
        distancias[5][9] = 1.0513634957642415;
        distancias[5][10] = 0.24936467495768375;
        distancias[5][11] = 0.469080655139933;
        distancias[5][12] = 0.6950645849226976;
        distancias[5][13] = 0.509428863039249;
        distancias[5][14] = 0.47959638275880473;
        distancias[5][15] = 0.7056346021599064;
        distancias[5][16] = 0.5753012403971346;
        distancias[5][17] = 0.670935991241282;
        distancias[5][18] = 1.1809764187944012;
        distancias[5][19] = 0.21975862264735457;
        distancias[5][20] = 0.4459269198230793;
        distancias[5][21] = 0.3426160924446347;
        distancias[5][22] = 0.45095780751910325;
        distancias[5][23] = 0.5335936864527374;
        distancias[5][24] = 0.4413181429849595;
        distancias[5][25] = 0.5603082102451588;
        distancias[5][26] = 1.3395713846756543;
        distancias[5][27] = 0.22631766203978917;
        distancias[5][28] = 0.31439428688430954;
        distancias[5][29] = 0.5368866928179408;
        distancias[5][30] = 0.45298564600644214;
        distancias[5][31] = 0.4275235288709812;
        distancias[5][32] = 0.5508543331352648;
        distancias[5][33] = 1.496058461205892;
        distancias[5][34] = 0.433419554093117;
        distancias[5][35] = 0.6977221014498994;
        distancias[5][36] = 0.4845323246224765;
        distancias[5][37] = 0.5302469920069618;
        distancias[5][38] = 0.6373912656238033;
        distancias[5][39] = 1.6649949314719885;
        distancias[5][40] = 0.27188475462400297;
        distancias[5][41] = 0.19736347348366828;
        distancias[5][42] = 0.1134310815653603;
        distancias[5][43] = 0.23778684402701802;
        distancias[5][44] = 1.671787817423665;
        distancias[5][45] = 0.3740941305336372;
        distancias[5][46] = 0.22167515854629646;
        distancias[5][47] = 0.23933836700351607;
        distancias[5][48] = 1.6515814773115292;
        distancias[5][49] = 0.15618477205900916;
        distancias[5][50] = 0.18443753002485552;
        distancias[5][51] = 1.8682832316066367;
        distancias[5][52] = 0.12468233747884187;
        distancias[5][53] = 1.7517415393704008;
        distancias[5][54] = 1.8517856963178603;
    }

    /**
     * *
     * Abre imagenes en formato JPG
     */
    public void abrirImagen() {
        JFileChooser fc = new JFileChooser();
        FileNameExtensionFilter filtro = new FileNameExtensionFilter("*.JPG", "jpg");
        fc.setFileFilter(filtro);
        if (fc.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
            ImageIcon image = new ImageIcon(fc.getSelectedFile().getAbsolutePath());
            Icon i = new ImageIcon(image.getImage());
            Icon icon = new ImageIcon(image.getImage().getScaledInstance((i.getIconWidth() * labelImagen.getHeight()) / i.getIconHeight(), labelImagen.getHeight(), Image.SCALE_DEFAULT));
            labelImagen.setIcon(icon);
        }
        label.setText("Haga Click en el punto central de la línea de cabello");
    }

    /**
     * Calcula las distancias de la imagen obtenida
     */
    private void calcularDistanciasMeta() {
        int cont = 0;
        for (int x = 0; x < 11; x++) {
            for (int y = 0; y < 11; y++) {
                if (x < y) {
                    distanciaMeta[cont] = Math.hypot((imagenMeta[x][0] - imagenMeta[y][0]), (imagenMeta[x][1] - imagenMeta[y][1]));
                    cont++;
                }
            }
        }
    }

    /**
     * Usamos el patrón de medida es el punto de la frente y el punto de la
     * nariz
     */
    private void normalizar() {
        double distanciaUnidad = distanciaMeta[4]; //Distancia entre punto de Nariz y Frente
        for (int x = 0; x < 55; x++) {
            distanciaMeta[x] = distanciaMeta[x] / distanciaUnidad;
        }
    }

    /**
     * Calculamos distancias entre imagen y 6 vectores con minimos cuadrados
     */
    private void calcularDistancias() {
        for (int i = 0; i < 6; i++) {
            double distance = 0;
            for (int x = 0; x < 55; x++) {
                distance += (distancias[i][x] - distanciaMeta[x]) * (distancias[i][x] - distanciaMeta[x]);
            }
            distancia[i] = distance;
        }
    }

    /**
     * Resultado Final
     */
    private void resultado() {
        double result = distancia[0];
        int person = 0;
        String s = "";
        for (int x = 0; x < distancia.length; x++) {
            if (result > distancia[x]) {
                result = distancia[x];
                person = x;
            }
        }
        for (int x = 0; x < distancia.length; x++) {
            int num = (int) (100 - (distancia[x] * 100));
            if (num <= 0) {
                s += nombres.get(x) + ": " + "0%" + "\n";
            } else {
                s += nombres.get(x) + ": " + num + "%" + "\n";
            }
        }
        JOptionPane.showMessageDialog(this, "La fotografía inducida corresponde al rostro de: " + nombres.get(person) + "\n\nSimilitudes:\n\n"+ s);
    }
}
