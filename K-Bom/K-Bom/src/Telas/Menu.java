package Telas;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.HashMap;
import javax.swing.ImageIcon;
import javax.swing.ToolTipManager;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.SwingUtilities;
import javax.swing.Timer;

public class Menu extends javax.swing.JFrame {
    private int originalX = -81;  // Posição original do secondMenu1
    private int originalY = 0;  // Posição original do secondMenu1
    private int targetX = 0;   // Nova posição do secondMenu1 (mude para o que quiser)
    private int targetY = 0;   // Nova posição do secondMenu1 (mude para o que quiser)
    private boolean isMoved = false; // Indica se o secondMenu1 foi movido
    private volatile boolean isAnimating = false;
    
    private Color startColor = new Color(0,96,177);  // Cor inicial do painel
    private Color hoverColor = new Color(217,217,217);  // Cor quando o mouse está sobre o ícone
    private HashMap<JPanel, Timer> timers;
    
    public Menu() {
        initComponents();
        
        jTabbedPane1.setSelectedIndex(0);
        simpleTitleBar2.init(this);
        ToolTipManager.sharedInstance().setEnabled(false);
        
        ImageIcon icon = new ImageIcon(getClass().getResource("/Imagens/IconeK-Bom.png"));
        setIconImage(icon.getImage());
        
        timers = new HashMap<>();
        
        sVGImage1.setSvgImage("Imagens/other_houses.svg", 40, 40); //Home
        sVGImage1.setCursor(new Cursor(Cursor.HAND_CURSOR));
        sVGImage2.setSvgImage("Imagens/account_circle.svg", 40, 40); //Meu Perfil
        sVGImage2.setCursor(new Cursor(Cursor.HAND_CURSOR));
        sVGImage3.setSvgImage("Imagens/shopping_cart.svg", 40, 40); //Carrinhos
        sVGImage3.setCursor(new Cursor(Cursor.HAND_CURSOR));
        sVGImage4.setSvgImage("Imagens/local_mall.svg", 40, 40); //Meus pedidos
        sVGImage4.setCursor(new Cursor(Cursor.HAND_CURSOR));
        sVGImage5.setSvgImage("Imagens/groups.svg", 40, 40); //Sobre nós
        sVGImage5.setCursor(new Cursor(Cursor.HAND_CURSOR));
        sVGImage8.setSvgImage("Imagens/power_settings_circle.svg", 40, 40); //Sair
        sVGImage8.setCursor(new Cursor(Cursor.HAND_CURSOR));
        
        sVGImage6.setSvgImage("Imagens/Close.svg", 25, 25);
        sVGImage6.setCursor(new Cursor(Cursor.HAND_CURSOR));
        sVGImage7.setSvgImage("Imagens/cancel.svg", 24, 24);
        
        setupHoverEffect(sVGImage1, roundedPanel1, startColor, hoverColor);
        setupHoverEffect(sVGImage2, roundedPanel2, startColor, hoverColor);
        setupHoverEffect(sVGImage3, roundedPanel3, startColor, hoverColor);
        setupHoverEffect(sVGImage4, roundedPanel4, startColor, hoverColor);
        setupHoverEffect(sVGImage5, roundedPanel5, startColor, hoverColor);
        setupHoverEffect(sVGImage8, roundedPanel6, startColor, hoverColor);
        
        header1.addMenuEvent(e -> {
            // Interrompe a animação se já estiver em andamento
            if (isAnimating) {
                return; // Ignora o clique se já está se movendo
            }

            // Verifica a posição atual do segundo menu
            if (secondMenu1.getX() == targetX) {
                // Se o menu está na nova posição, move para a posição original
                moveSecondMenu(originalX, originalY); // Volta à posição original
            } else {
                // Se o menu não está na nova posição, move para a nova posição
                moveSecondMenu(targetX, targetY); // Move para a nova posição
            }
        });
        
        sVGImage1.addMouseListener(new MouseAdapter() { 
            @Override
            public void mouseClicked(MouseEvent e) {
                jTabbedPane1.setSelectedIndex(0);
            }
        });
        
        sVGImage2.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                jTabbedPane1.setSelectedIndex(1);
            }
        });
        sVGImage3.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                jTabbedPane1.setSelectedIndex(2);
            }
        });
        sVGImage4.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                jTabbedPane1.setSelectedIndex(3);
            }
        });
        
        sVGImage5.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                jTabbedPane1.setSelectedIndex(4);
            }
        });
        
        jDialog1.setLocationRelativeTo(null);
        
        bSair.setFocusable(false);
        bCancel.setFocusable(false);
        
        jDialog1.addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowOpened(java.awt.event.WindowEvent e) {
                jDialog1.requestFocusInWindow(); // Foco no JDialog, sem selecionar os botões
                SwingUtilities.invokeLater(() -> {
                    bSair.setFocusable(true);
                    bCancel.setFocusable(true);
                });
            }
        });
        
        sVGImage8.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                jDialog1.setVisible(true);
            }
        });
        
        sVGImage6.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                jDialog1.setVisible(false);
            }
        });
    }
    
    private void setupHoverEffect(javaswingdev.SVGImage sVGImage, JPanel roundedPanel, Color startColor, Color hoverColor) {
        sVGImage.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                animateColorChange(roundedPanel, startColor, hoverColor);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                animateColorChange(roundedPanel, hoverColor, startColor);
            }
        });
    }

    private void animateColorChange(JPanel panel, Color startColor, Color endColor) {
        // Cancelar qualquer transição de cor em andamento para esse painel
        Timer currentTimer = timers.get(panel);
        if (currentTimer != null && currentTimer.isRunning()) {
            currentTimer.stop();
        }

        // Ajuste os parâmetros da animação para maior suavidade
        final int duration = 400;  // Duração (em milissegundos)
        final int steps = 15;  // Número de passos na animação
        final int delay = duration / steps;  // Tempo entre cada passo da animação

        // Arrays de cor para armazenar os valores de RGB
        final float[] startRGB = startColor.getRGBComponents(null);
        final float[] endRGB = endColor.getRGBComponents(null);
        final float[] diff = new float[3];

        for (int i = 0; i < 3; i++) {
            diff[i] = endRGB[i] - startRGB[i];
        }

        final int[] stepCounter = {0};  // Contador para acompanhar o progresso

        // Iniciar o timer para fazer a animação
        Timer colorTransitionTimer = new Timer(delay, null);
        timers.put(panel, colorTransitionTimer);  // Armazenar o Timer no HashMap

        colorTransitionTimer.addActionListener(e -> {
            // Verifica se todos os passos foram completados
            if (stepCounter[0] >= steps) {
                colorTransitionTimer.stop();
                return;
            }

            // Interpolação da cor
            float progress = (float) stepCounter[0] / steps;
            float[] currentRGB = new float[3];
            for (int i = 0; i < 3; i++) {
                currentRGB[i] = startRGB[i] + progress * diff[i];
            }

            // Definir a nova cor interpolada
            panel.setBackground(new Color(currentRGB[0], currentRGB[1], currentRGB[2]));
            panel.repaint();

            stepCounter[0]++;  // Incrementar o contador de passos
        });

        colorTransitionTimer.start();  // Iniciar o timer
    }
    
    // Modifique o método moveSecondMenu
    private void moveSecondMenu(int x, int y) {
        isAnimating = true; // Define que a animação começou

        new Thread(() -> {
            int startX = secondMenu1.getX();
            int startY = secondMenu1.getY();
            int distanceX = x - startX;
            int distanceY = y - startY;
            int steps = 30; // Número de passos da animação

            for (int i = 0; i <= steps; i++) {
                // Interpolação linear para a posição
                int newX = startX + (int) (distanceX * (i / (double) steps));
                int newY = startY + (int) (distanceY * (i / (double) steps));
                secondMenu1.setLocation(newX, newY);
                try {
                    Thread.sleep(5); // Aumente o tempo de espera para suavidade
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            // Garante que o secondMenu1 termine na posição correta
            secondMenu1.setLocation(x, y);
            isAnimating = false; // Define que a animação terminou
        }).start();
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jDialog1 = new javax.swing.JDialog();
        jPanel10 = new javax.swing.JPanel();
        sVGImage6 = new javaswingdev.SVGImage();
        jPanel13 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        bSair = new javax.swing.JButton();
        bCancel = new javax.swing.JButton();
        sVGImage7 = new javaswingdev.SVGImage();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        simpleTitleBar2 = new javaswingdev.SimpleTitleBar();
        jPanel3 = new javax.swing.JPanel();
        toolBar1 = new javaswingdev.ToolBar();
        header = new javaswingdev.Header();
        header1 = new javaswingdev.Header();
        jPanel4 = new javax.swing.JPanel();
        secondMenu1 = new javax.swing.JPanel();
        jPanel9 = new javax.swing.JPanel();
        sVGImage1 = new javaswingdev.SVGImage();
        roundedPanel1 = new javaswingdev.RoundedPanel();
        sVGImage2 = new javaswingdev.SVGImage();
        roundedPanel2 = new javaswingdev.RoundedPanel();
        sVGImage3 = new javaswingdev.SVGImage();
        roundedPanel3 = new javaswingdev.RoundedPanel();
        sVGImage4 = new javaswingdev.SVGImage();
        roundedPanel4 = new javaswingdev.RoundedPanel();
        sVGImage5 = new javaswingdev.SVGImage();
        roundedPanel5 = new javaswingdev.RoundedPanel();
        sVGImage8 = new javaswingdev.SVGImage();
        roundedPanel6 = new javaswingdev.RoundedPanel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel5 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        myProfile1 = new Telas.MyProfile();
        jPanel7 = new javax.swing.JPanel();
        jPanel11 = new javax.swing.JPanel();
        jPanel12 = new javax.swing.JPanel();
        sobreNos1 = new Telas.SobreNos();

        jDialog1.setBounds(new java.awt.Rectangle(0, 0, 0, 0));
        jDialog1.setMinimumSize(new java.awt.Dimension(444, 180));
        jDialog1.setModal(true);
        jDialog1.setUndecorated(true);
        jDialog1.setResizable(false);
        jDialog1.getContentPane().setLayout(null);

        jPanel10.setBackground(new java.awt.Color(255, 255, 255));
        jPanel10.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(217, 217, 217), 1, true));
        jPanel10.setAlignmentX(0.0F);
        jPanel10.setAlignmentY(0.0F);
        jPanel10.setMaximumSize(new java.awt.Dimension(444, 200));
        jPanel10.setMinimumSize(new java.awt.Dimension(444, 200));
        jPanel10.setName(""); // NOI18N
        jPanel10.setPreferredSize(new java.awt.Dimension(444, 200));
        jPanel10.setLayout(null);

        sVGImage6.setMaximumSize(new java.awt.Dimension(25, 25));
        sVGImage6.setMinimumSize(new java.awt.Dimension(25, 25));
        sVGImage6.setPreferredSize(new java.awt.Dimension(25, 25));
        jPanel10.add(sVGImage6);
        sVGImage6.setBounds(413, 6, 25, 25);

        jPanel13.setBackground(new java.awt.Color(255, 101, 0));
        jPanel13.setMaximumSize(new java.awt.Dimension(444, 32));
        jPanel13.setMinimumSize(new java.awt.Dimension(444, 32));

        javax.swing.GroupLayout jPanel13Layout = new javax.swing.GroupLayout(jPanel13);
        jPanel13.setLayout(jPanel13Layout);
        jPanel13Layout.setHorizontalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 444, Short.MAX_VALUE)
        );
        jPanel13Layout.setVerticalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 32, Short.MAX_VALUE)
        );

        jPanel10.add(jPanel13);
        jPanel13.setBounds(0, 150, 444, 32);

        jLabel1.setBackground(new java.awt.Color(0, 0, 0));
        jLabel1.setFont(new java.awt.Font("SansSerif", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Deseja fechar o aplicativo?");
        jLabel1.setToolTipText("");
        jLabel1.setMaximumSize(new java.awt.Dimension(310, 41));
        jLabel1.setMinimumSize(new java.awt.Dimension(310, 41));
        jLabel1.setPreferredSize(new java.awt.Dimension(310, 41));
        jPanel10.add(jLabel1);
        jLabel1.setBounds(80, 30, 310, 41);

        bSair.setBackground(new java.awt.Color(51, 102, 255));
        bSair.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        bSair.setForeground(new java.awt.Color(255, 255, 255));
        bSair.setText("Sim");
        bSair.setActionCommand("Sair");
        bSair.setBorder(null);
        bSair.setBorderPainted(false);
        bSair.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        bSair.setMaximumSize(new java.awt.Dimension(100, 40));
        bSair.setMinimumSize(new java.awt.Dimension(100, 40));
        bSair.setPreferredSize(new java.awt.Dimension(100, 40));
        bSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bSairActionPerformed(evt);
            }
        });
        jPanel10.add(bSair);
        bSair.setBounds(100, 80, 100, 40);

        bCancel.setBackground(new java.awt.Color(51, 102, 255));
        bCancel.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        bCancel.setForeground(new java.awt.Color(255, 255, 255));
        bCancel.setText("Não");
        bCancel.setActionCommand("Cancel");
        bCancel.setBorder(null);
        bCancel.setBorderPainted(false);
        bCancel.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        bCancel.setMaximumSize(new java.awt.Dimension(100, 40));
        bCancel.setMinimumSize(new java.awt.Dimension(100, 40));
        bCancel.setPreferredSize(new java.awt.Dimension(100, 40));
        bCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bCancelActionPerformed(evt);
            }
        });
        jPanel10.add(bCancel);
        bCancel.setBounds(250, 80, 100, 40);

        sVGImage7.setBackground(new java.awt.Color(255, 255, 255));
        sVGImage7.setMaximumSize(new java.awt.Dimension(24, 24));
        sVGImage7.setMinimumSize(new java.awt.Dimension(24, 24));
        sVGImage7.setPreferredSize(new java.awt.Dimension(24, 24));
        jPanel10.add(sVGImage7);
        sVGImage7.setBounds(50, 40, 24, 24);

        jDialog1.getContentPane().add(jPanel10);
        jPanel10.setBounds(0, 0, 444, 180);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setAutoRequestFocus(false);
        setBackground(new java.awt.Color(255, 0, 0));
        setUndecorated(true);
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setForeground(new java.awt.Color(0, 0, 0));
        jPanel1.setToolTipText("");
        jPanel1.setDoubleBuffered(false);
        jPanel1.setFocusable(false);
        jPanel1.setMaximumSize(new java.awt.Dimension(1303, 804));
        jPanel1.setMinimumSize(new java.awt.Dimension(1303, 804));
        jPanel1.setPreferredSize(new java.awt.Dimension(1303, 804));
        jPanel1.setRequestFocusEnabled(false);
        jPanel1.setVerifyInputWhenFocusTarget(false);

        jPanel2.setBackground(new java.awt.Color(0, 96, 177));
        jPanel2.setMaximumSize(new java.awt.Dimension(1303, 155));
        jPanel2.setMinimumSize(new java.awt.Dimension(1303, 155));
        jPanel2.setPreferredSize(new java.awt.Dimension(1303, 155));

        simpleTitleBar2.setBackground(new java.awt.Color(0, 96, 177));
        simpleTitleBar2.setPreferredSize(new java.awt.Dimension(1303, 34));

        jPanel3.setBackground(new java.awt.Color(255, 101, 0));
        jPanel3.setMaximumSize(new java.awt.Dimension(1303, 40));
        jPanel3.setMinimumSize(new java.awt.Dimension(1303, 40));
        jPanel3.setPreferredSize(new java.awt.Dimension(1303, 40));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(toolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(toolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout headerLayout = new javax.swing.GroupLayout(header);
        header.setLayout(headerLayout);
        headerLayout.setHorizontalGroup(
            headerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(headerLayout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(header1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        headerLayout.setVerticalGroup(
            headerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, headerLayout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(header1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(simpleTitleBar2, javax.swing.GroupLayout.PREFERRED_SIZE, 1303, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel2Layout.createSequentialGroup()
                    .addComponent(header, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(simpleTitleBar2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 81, Short.MAX_VALUE)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel2Layout.createSequentialGroup()
                    .addGap(37, 37, 37)
                    .addComponent(header, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(37, Short.MAX_VALUE)))
        );

        jPanel4.setBackground(new java.awt.Color(0, 0, 0));
        jPanel4.setMaximumSize(new java.awt.Dimension(1303, 650));
        jPanel4.setMinimumSize(new java.awt.Dimension(1303, 650));
        jPanel4.setOpaque(false);
        jPanel4.setPreferredSize(new java.awt.Dimension(1303, 650));
        jPanel4.setLayout(null);

        secondMenu1.setBackground(new java.awt.Color(0, 96, 177));
        secondMenu1.setAlignmentX(0.0F);
        secondMenu1.setAlignmentY(0.0F);
        secondMenu1.setMaximumSize(new java.awt.Dimension(81, 650));
        secondMenu1.setMinimumSize(new java.awt.Dimension(81, 650));
        secondMenu1.setLayout(null);

        jPanel9.setBackground(new java.awt.Color(255, 101, 0));
        jPanel9.setMaximumSize(new java.awt.Dimension(10, 650));
        jPanel9.setMinimumSize(new java.awt.Dimension(10, 650));

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 10, Short.MAX_VALUE)
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 650, Short.MAX_VALUE)
        );

        secondMenu1.add(jPanel9);
        jPanel9.setBounds(71, 0, 10, 650);

        sVGImage1.setMaximumSize(new java.awt.Dimension(40, 40));
        sVGImage1.setMinimumSize(new java.awt.Dimension(40, 40));
        sVGImage1.setPreferredSize(new java.awt.Dimension(40, 40));
        secondMenu1.add(sVGImage1);
        sVGImage1.setBounds(20, 11, 40, 40);

        roundedPanel1.setBackground(new java.awt.Color(0, 96, 177));
        roundedPanel1.setMaximumSize(new java.awt.Dimension(50, 50));
        roundedPanel1.setMinimumSize(new java.awt.Dimension(50, 50));

        javax.swing.GroupLayout roundedPanel1Layout = new javax.swing.GroupLayout(roundedPanel1);
        roundedPanel1.setLayout(roundedPanel1Layout);
        roundedPanel1Layout.setHorizontalGroup(
            roundedPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 50, Short.MAX_VALUE)
        );
        roundedPanel1Layout.setVerticalGroup(
            roundedPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 50, Short.MAX_VALUE)
        );

        secondMenu1.add(roundedPanel1);
        roundedPanel1.setBounds(15, 6, 50, 50);

        sVGImage2.setMaximumSize(new java.awt.Dimension(40, 40));
        sVGImage2.setMinimumSize(new java.awt.Dimension(40, 40));
        sVGImage2.setPreferredSize(new java.awt.Dimension(40, 40));
        secondMenu1.add(sVGImage2);
        sVGImage2.setBounds(20, 71, 40, 40);

        roundedPanel2.setBackground(new java.awt.Color(0, 96, 177));
        roundedPanel2.setMaximumSize(new java.awt.Dimension(50, 50));
        roundedPanel2.setMinimumSize(new java.awt.Dimension(50, 50));

        javax.swing.GroupLayout roundedPanel2Layout = new javax.swing.GroupLayout(roundedPanel2);
        roundedPanel2.setLayout(roundedPanel2Layout);
        roundedPanel2Layout.setHorizontalGroup(
            roundedPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 50, Short.MAX_VALUE)
        );
        roundedPanel2Layout.setVerticalGroup(
            roundedPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 50, Short.MAX_VALUE)
        );

        secondMenu1.add(roundedPanel2);
        roundedPanel2.setBounds(15, 65, 50, 50);

        sVGImage3.setMaximumSize(new java.awt.Dimension(40, 40));
        sVGImage3.setMinimumSize(new java.awt.Dimension(40, 40));
        sVGImage3.setPreferredSize(new java.awt.Dimension(40, 40));
        secondMenu1.add(sVGImage3);
        sVGImage3.setBounds(20, 131, 40, 40);

        roundedPanel3.setBackground(new java.awt.Color(0, 96, 177));
        roundedPanel3.setMaximumSize(new java.awt.Dimension(50, 50));
        roundedPanel3.setMinimumSize(new java.awt.Dimension(50, 50));

        javax.swing.GroupLayout roundedPanel3Layout = new javax.swing.GroupLayout(roundedPanel3);
        roundedPanel3.setLayout(roundedPanel3Layout);
        roundedPanel3Layout.setHorizontalGroup(
            roundedPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 50, Short.MAX_VALUE)
        );
        roundedPanel3Layout.setVerticalGroup(
            roundedPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 50, Short.MAX_VALUE)
        );

        secondMenu1.add(roundedPanel3);
        roundedPanel3.setBounds(15, 126, 50, 50);

        sVGImage4.setMaximumSize(new java.awt.Dimension(40, 40));
        sVGImage4.setMinimumSize(new java.awt.Dimension(40, 40));
        sVGImage4.setPreferredSize(new java.awt.Dimension(40, 40));
        secondMenu1.add(sVGImage4);
        sVGImage4.setBounds(20, 191, 40, 40);

        roundedPanel4.setBackground(new java.awt.Color(0, 96, 177));
        roundedPanel4.setMaximumSize(new java.awt.Dimension(50, 50));
        roundedPanel4.setMinimumSize(new java.awt.Dimension(50, 50));

        javax.swing.GroupLayout roundedPanel4Layout = new javax.swing.GroupLayout(roundedPanel4);
        roundedPanel4.setLayout(roundedPanel4Layout);
        roundedPanel4Layout.setHorizontalGroup(
            roundedPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 50, Short.MAX_VALUE)
        );
        roundedPanel4Layout.setVerticalGroup(
            roundedPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 50, Short.MAX_VALUE)
        );

        secondMenu1.add(roundedPanel4);
        roundedPanel4.setBounds(15, 186, 50, 50);

        sVGImage5.setMaximumSize(new java.awt.Dimension(40, 40));
        sVGImage5.setMinimumSize(new java.awt.Dimension(40, 40));
        sVGImage5.setPreferredSize(new java.awt.Dimension(40, 40));
        secondMenu1.add(sVGImage5);
        sVGImage5.setBounds(20, 251, 40, 40);

        roundedPanel5.setBackground(new java.awt.Color(0, 96, 177));
        roundedPanel5.setMaximumSize(new java.awt.Dimension(50, 50));
        roundedPanel5.setMinimumSize(new java.awt.Dimension(50, 50));

        javax.swing.GroupLayout roundedPanel5Layout = new javax.swing.GroupLayout(roundedPanel5);
        roundedPanel5.setLayout(roundedPanel5Layout);
        roundedPanel5Layout.setHorizontalGroup(
            roundedPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 50, Short.MAX_VALUE)
        );
        roundedPanel5Layout.setVerticalGroup(
            roundedPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 50, Short.MAX_VALUE)
        );

        secondMenu1.add(roundedPanel5);
        roundedPanel5.setBounds(15, 246, 50, 50);

        sVGImage8.setMaximumSize(new java.awt.Dimension(40, 40));
        sVGImage8.setMinimumSize(new java.awt.Dimension(40, 40));
        sVGImage8.setPreferredSize(new java.awt.Dimension(40, 40));
        secondMenu1.add(sVGImage8);
        sVGImage8.setBounds(20, 311, 40, 40);

        roundedPanel6.setBackground(new java.awt.Color(0, 96, 177));
        roundedPanel6.setMaximumSize(new java.awt.Dimension(50, 50));
        roundedPanel6.setMinimumSize(new java.awt.Dimension(50, 50));

        javax.swing.GroupLayout roundedPanel6Layout = new javax.swing.GroupLayout(roundedPanel6);
        roundedPanel6.setLayout(roundedPanel6Layout);
        roundedPanel6Layout.setHorizontalGroup(
            roundedPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 50, Short.MAX_VALUE)
        );
        roundedPanel6Layout.setVerticalGroup(
            roundedPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 50, Short.MAX_VALUE)
        );

        secondMenu1.add(roundedPanel6);
        roundedPanel6.setBounds(15, 306, 50, 50);

        jPanel4.add(secondMenu1);
        secondMenu1.setBounds(-81, 0, 81, 650);

        jTabbedPane1.setBackground(new java.awt.Color(255, 255, 255));
        jTabbedPane1.setAlignmentX(0.0F);
        jTabbedPane1.setAlignmentY(0.0F);
        jTabbedPane1.setFocusable(false);
        jTabbedPane1.setMaximumSize(new java.awt.Dimension(1307, 690));
        jTabbedPane1.setMinimumSize(new java.awt.Dimension(1307, 690));
        jTabbedPane1.setPreferredSize(new java.awt.Dimension(1307, 690));
        jTabbedPane1.setRequestFocusEnabled(false);

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));
        jPanel5.setAlignmentX(0.0F);
        jPanel5.setAlignmentY(0.0F);
        jPanel5.setMaximumSize(new java.awt.Dimension(1303, 655));
        jPanel5.setMinimumSize(new java.awt.Dimension(1303, 655));

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1307, Short.MAX_VALUE)
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 655, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("tab1", jPanel5);

        jPanel6.setBackground(new java.awt.Color(255, 255, 255));
        jPanel6.setAlignmentX(0.0F);
        jPanel6.setAlignmentY(0.0F);
        jPanel6.setMaximumSize(new java.awt.Dimension(1303, 655));
        jPanel6.setMinimumSize(new java.awt.Dimension(1303, 655));
        jPanel6.setLayout(null);
        jPanel6.add(myProfile1);
        myProfile1.setBounds(0, 0, 1303, 655);

        jTabbedPane1.addTab("tab2", jPanel6);

        jPanel7.setBackground(new java.awt.Color(255, 255, 255));
        jPanel7.setAlignmentX(0.0F);
        jPanel7.setAlignmentY(0.0F);
        jPanel7.setMaximumSize(new java.awt.Dimension(1303, 655));
        jPanel7.setMinimumSize(new java.awt.Dimension(1303, 655));

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1307, Short.MAX_VALUE)
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 655, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("tab3", jPanel7);

        jPanel11.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1307, Short.MAX_VALUE)
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 655, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("tab4", jPanel11);

        jPanel12.setBackground(new java.awt.Color(255, 255, 255));
        jPanel12.setMaximumSize(new java.awt.Dimension(1303, 655));
        jPanel12.setMinimumSize(new java.awt.Dimension(1303, 655));

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel12Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(sobreNos1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addComponent(sobreNos1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("tab5", jPanel12);

        jPanel4.add(jTabbedPane1);
        jTabbedPane1.setBounds(-2, -30, 1307, 690);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void bSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bSairActionPerformed
        System.exit(0);
    }//GEN-LAST:event_bSairActionPerformed

    private void bCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bCancelActionPerformed
        jDialog1.setVisible(false);
    }//GEN-LAST:event_bCancelActionPerformed

    
    public static void main(String args[]) {
        
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Menu().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bCancel;
    private javax.swing.JButton bSair;
    private javaswingdev.Header header;
    private javaswingdev.Header header1;
    private javax.swing.JDialog jDialog1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel9;
    public javax.swing.JTabbedPane jTabbedPane1;
    private Telas.MyProfile myProfile1;
    private javaswingdev.RoundedPanel roundedPanel1;
    private javaswingdev.RoundedPanel roundedPanel2;
    private javaswingdev.RoundedPanel roundedPanel3;
    private javaswingdev.RoundedPanel roundedPanel4;
    private javaswingdev.RoundedPanel roundedPanel5;
    private javaswingdev.RoundedPanel roundedPanel6;
    public javaswingdev.SVGImage sVGImage1;
    public javaswingdev.SVGImage sVGImage2;
    public javaswingdev.SVGImage sVGImage3;
    public javaswingdev.SVGImage sVGImage4;
    public javaswingdev.SVGImage sVGImage5;
    private javaswingdev.SVGImage sVGImage6;
    private javaswingdev.SVGImage sVGImage7;
    public javaswingdev.SVGImage sVGImage8;
    private javax.swing.JPanel secondMenu1;
    private javaswingdev.SimpleTitleBar simpleTitleBar2;
    private Telas.SobreNos sobreNos1;
    private javaswingdev.ToolBar toolBar1;
    // End of variables declaration//GEN-END:variables
}