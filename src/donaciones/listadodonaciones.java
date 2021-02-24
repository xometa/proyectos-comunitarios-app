/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package donaciones;

import Alertas.AlertadeEliminacion;
import Alertas.ErrordeProcesos;
import Alertas.ProcesoExitoso;
import proyectos.*;
import EstilodelasTablas.EstiloTablaHeader;
import EstilodelasTablas.EstiloTablaRenderer;
import EstilodelasTablas.MyScrollbarUI;
import EstilodelasTablas.MyScrollbarVistas;
import ListasSimples.Nodo;
import donantes.Donantes;
import java.awt.Color;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Sony
 */
public class listadodonaciones extends javax.swing.JInternalFrame {

    DefaultTableModel model;
    dao_donaciones dd = new dao_donaciones();
    Donaciones donaciones = new Donaciones();
    Donaciones donaciones1 = new Donaciones();
    /*Para llena çr la lista correspondiente con los nombre s de los  proyectos*/
    dao_proyectos dp = new dao_proyectos();
    Proyectos proyectos = null;
    DefaultListModel modelolista;
    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/YYYY");
    FechaAcctual fechaactual = new FechaAcctual();

    double montoeditar = 0;

    /**
     * Creates new form NewJInternalFrame
     */
    public listadodonaciones() {
        initComponents();
        this.tablaDonaciones.getTableHeader().setDefaultRenderer(new EstiloTablaHeader());
        this.tablaDonaciones.setDefaultRenderer(Object.class, new EstiloTablaRenderer());
        this.tablaDonaciones.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        jScrollPane1.getViewport().setBackground(new java.awt.Color(255, 255, 255));
        jScrollPane1.getVerticalScrollBar().setUI(new MyScrollbarUI());
        jScrollPane1.getHorizontalScrollBar().setUI(new MyScrollbarUI());
        jScrollPane2.getViewport().setBackground(new java.awt.Color(255, 255, 255));
        jScrollPane2.getVerticalScrollBar().setUI(new MyScrollbarVistas());
        jScrollPane2.getHorizontalScrollBar().setUI(new MyScrollbarVistas());
        ((javax.swing.plaf.basic.BasicInternalFrameUI) this.getUI()).setNorthPane(null);
//        this.fecha.setSelectableDateRange(null,new java.util.Date() );
        this.fecha.setDate(new java.util.Date());
        this.fecha.setEnabled(false);
        ocultar_columnas();
        titulo2.setText("Nuevo registro");
        this.id.setVisible(false);
        this.iddonante.setVisible(false);
        this.ideditar.setVisible(false);
        this.btnadddonante.setEnabled(false);
        this.nombredonante.setEditable(false);
        this.empresa.setEditable(false);
        this.email.setEditable(false);
        this.codigopostal.setEditable(false);
        this.ciudad.setEditable(false);
        this.telefono.setEditable(false);
//        model = (DefaultTableModel) tablaProyectosAlcaldias.getModel();
//        llenarTabla("");
        modelolista = new DefaultListModel();
        listaproyectos.setModel(modelolista);
        llenarlista();
        this.montodonacion.setText("00.00");
        this.totregistros.setText("0");
    }

    void ocultar_columnas() {
        this.tablaDonaciones.getColumnModel().getColumn(0).setMaxWidth(0);
        this.tablaDonaciones.getColumnModel().getColumn(0).setMinWidth(0);
        this.tablaDonaciones.getColumnModel().getColumn(0).setPreferredWidth(0);

        this.tablaDonaciones.getColumnModel().getColumn(5).setMaxWidth(0);
        this.tablaDonaciones.getColumnModel().getColumn(5).setMinWidth(0);
        this.tablaDonaciones.getColumnModel().getColumn(5).setPreferredWidth(0);

        this.tablaDonaciones.getColumnModel().getColumn(6).setMaxWidth(0);
        this.tablaDonaciones.getColumnModel().getColumn(6).setMinWidth(0);
        this.tablaDonaciones.getColumnModel().getColumn(6).setPreferredWidth(0);

        this.tablaDonaciones.getColumnModel().getColumn(7).setMaxWidth(0);
        this.tablaDonaciones.getColumnModel().getColumn(7).setMinWidth(0);
        this.tablaDonaciones.getColumnModel().getColumn(7).setPreferredWidth(0);

        this.tablaDonaciones.getColumnModel().getColumn(8).setMaxWidth(0);
        this.tablaDonaciones.getColumnModel().getColumn(8).setMinWidth(0);
        this.tablaDonaciones.getColumnModel().getColumn(8).setPreferredWidth(0);

        this.tablaDonaciones.getColumnModel().getColumn(9).setMaxWidth(0);
        this.tablaDonaciones.getColumnModel().getColumn(9).setMinWidth(0);
        this.tablaDonaciones.getColumnModel().getColumn(9).setPreferredWidth(0);

        this.tablaDonaciones.getColumnModel().getColumn(10).setMaxWidth(0);
        this.tablaDonaciones.getColumnModel().getColumn(10).setMinWidth(0);
        this.tablaDonaciones.getColumnModel().getColumn(10).setPreferredWidth(0);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        materialButtonCircle1 = new principal.MaterialButtonCircle();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jPanel7 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaDonaciones = new javax.swing.JTable();
        buscar = new app.bolivia.swing.JCTextField();
        jLabel2 = new javax.swing.JLabel();
        totregistros = new javax.swing.JLabel();
        btnbuscar = new rsbuttom.RSButtonMetro();
        jPanel4 = new javax.swing.JPanel();
        panel2 = new org.edisoncor.gui.panel.Panel();
        jPanel5 = new javax.swing.JPanel();
        titulo1 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        id = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        listaproyectos = new javax.swing.JList<>();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        titulo2 = new javax.swing.JLabel();
        titulo3 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jPanel9 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        nombredonante = new app.bolivia.swing.JCTextField();
        monto = new app.bolivia.swing.JCTextField();
        jLabel8 = new javax.swing.JLabel();
        iddonante = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        fecha = new com.toedter.calendar.JDateChooser();
        btnadddonante = new javax.swing.JButton();
        btnGuardar = new principal.MaterialButton();
        btnCancelar = new principal.MaterialButton();
        ideditar = new javax.swing.JLabel();
        jPanel8 = new javax.swing.JPanel();
        jPanel10 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        empresa = new app.bolivia.swing.JCTextField();
        email = new app.bolivia.swing.JCTextField();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        ciudad = new app.bolivia.swing.JCTextField();
        codigopostal = new app.bolivia.swing.JCTextField();
        jLabel18 = new javax.swing.JLabel();
        telefono = new app.bolivia.swing.JCTextField();
        jLabel19 = new javax.swing.JLabel();
        montodonacion = new javax.swing.JLabel();
        btneliminar = new principal.MaterialButton();
        jLabel1 = new javax.swing.JLabel();
        btncerrar = new principal.MaterialButton();

        materialButtonCircle1.setText("materialButtonCircle1");

        setBackground(new java.awt.Color(255, 255, 255));
        org.jdesktop.swingx.border.DropShadowBorder dropShadowBorder1 = new org.jdesktop.swingx.border.DropShadowBorder();
        dropShadowBorder1.setShowLeftShadow(true);
        dropShadowBorder1.setShowTopShadow(true);
        setBorder(dropShadowBorder1);

        jPanel1.setBackground(new java.awt.Color(248, 248, 248));

        jPanel7.setBackground(new java.awt.Color(255, 255, 255));

        jScrollPane1.setBackground(new java.awt.Color(255, 255, 255));
        jScrollPane1.setBorder(null);

        tablaDonaciones.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        tablaDonaciones.setForeground(new java.awt.Color(255, 255, 255));
        tablaDonaciones.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID ", "NOMBRE DEL DONANTE", "EMPRESA", "MONTO", "FECHA DE LA DONACIÓN", "IDDONANTES", "EMAIL", "CÓDIGO POSTAL", "CIUDAD", "TELÉFONO", "IDPROYECTO"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, true, true, true, false, true, true, true, true, true, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tablaDonaciones.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        tablaDonaciones.setDoubleBuffered(true);
        tablaDonaciones.setRowHeight(20);
        tablaDonaciones.setSelectionBackground(new java.awt.Color(0, 153, 255));
        tablaDonaciones.getTableHeader().setReorderingAllowed(false);
        tablaDonaciones.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablaDonacionesMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tablaDonaciones);
        if (tablaDonaciones.getColumnModel().getColumnCount() > 0) {
            tablaDonaciones.getColumnModel().getColumn(0).setMinWidth(70);
            tablaDonaciones.getColumnModel().getColumn(0).setMaxWidth(70);
        }

        buscar.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(26, 187, 156)));
        buscar.setForeground(new java.awt.Color(26, 187, 156));
        buscar.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        buscar.setPlaceholder("BUSCAR DONACIÓN");
        buscar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                buscarKeyReleased(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(42, 63, 84));
        jLabel2.setText("Total de Registros");

        totregistros.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        totregistros.setForeground(new java.awt.Color(42, 63, 84));
        totregistros.setText("0000");

        btnbuscar.setBackground(new java.awt.Color(255, 255, 255));
        btnbuscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ImagenesDonantes/icons8_Search_30px.png"))); // NOI18N
        btnbuscar.setColorHover(new java.awt.Color(229, 226, 229));
        btnbuscar.setColorNormal(new java.awt.Color(255, 255, 255));
        btnbuscar.setColorPressed(new java.awt.Color(248, 246, 246));
        btnbuscar.setColorTextHover(new java.awt.Color(248, 246, 246));
        btnbuscar.setDefaultCapable(false);
        btnbuscar.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnbuscar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnbuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnbuscarActionPerformed(evt);
            }
        });

        jPanel4.setBackground(new java.awt.Color(26, 187, 156));

        panel2.setBackground(new java.awt.Color(255, 255, 255));
        panel2.setForeground(new java.awt.Color(255, 255, 255));
        panel2.setColorPrimario(new java.awt.Color(255, 255, 255));
        panel2.setColorSecundario(new java.awt.Color(255, 255, 255));
        panel2.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                panel2MouseDragged(evt);
            }
        });
        panel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                panel2MousePressed(evt);
            }
        });

        jPanel5.setBackground(new java.awt.Color(26, 187, 156));

        titulo1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        titulo1.setForeground(new java.awt.Color(255, 255, 255));
        titulo1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        titulo1.setText("<html> Proyectos registrados");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(titulo1, javax.swing.GroupLayout.PREFERRED_SIZE, 322, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(157, 157, 157))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(titulo1, javax.swing.GroupLayout.DEFAULT_SIZE, 48, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel6.setBackground(new java.awt.Color(255, 255, 255));
        org.jdesktop.swingx.border.DropShadowBorder dropShadowBorder2 = new org.jdesktop.swingx.border.DropShadowBorder();
        dropShadowBorder2.setShowLeftShadow(true);
        dropShadowBorder2.setShowTopShadow(true);
        jPanel6.setBorder(dropShadowBorder2);

        id.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        id.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        id.setText("id");

        listaproyectos.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                listaproyectosValueChanged(evt);
            }
        });
        jScrollPane3.setViewportView(listaproyectos);

        jLabel20.setBackground(new java.awt.Color(0, 0, 0));
        jLabel20.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel20.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel20.setText("Monto a abonar:");

        jLabel21.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel21.setText("00.00");

        jLabel22.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(42, 63, 84));
        jLabel22.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel22.setText("<html>\nMonto a donar por parte de la Alcaldía<br>\n<center>encargada del proyecto<center>");

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(id, javax.swing.GroupLayout.DEFAULT_SIZE, 312, Short.MAX_VALUE)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel22)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(jLabel20, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
            .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                    .addContainerGap(7, Short.MAX_VALUE)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 297, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(8, Short.MAX_VALUE)))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addComponent(id)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 454, Short.MAX_VALUE)
                .addComponent(jLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel20)
                    .addComponent(jLabel21))
                .addContainerGap())
            .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                    .addContainerGap(43, Short.MAX_VALUE)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 429, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(79, Short.MAX_VALUE)))
        );

        javax.swing.GroupLayout panel2Layout = new javax.swing.GroupLayout(panel2);
        panel2.setLayout(panel2Layout);
        panel2Layout.setHorizontalGroup(
            panel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addComponent(jPanel5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 347, Short.MAX_VALUE)
        );
        panel2Layout.setVerticalGroup(
            panel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel2Layout.createSequentialGroup()
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel2.setBackground(new java.awt.Color(26, 187, 156));

        titulo2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        titulo2.setForeground(new java.awt.Color(255, 255, 255));
        titulo2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        titulo2.setText("Nuevas donaciones");
        titulo2.setMinimumSize(new java.awt.Dimension(195, 22));

        titulo3.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        titulo3.setForeground(new java.awt.Color(255, 255, 255));
        titulo3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        titulo3.setText("Datos del donante");
        titulo3.setMinimumSize(new java.awt.Dimension(195, 22));

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

        jPanel9.setBackground(new java.awt.Color(255, 255, 255));
        org.jdesktop.swingx.border.DropShadowBorder dropShadowBorder3 = new org.jdesktop.swingx.border.DropShadowBorder();
        dropShadowBorder3.setShowLeftShadow(true);
        dropShadowBorder3.setShowTopShadow(true);
        jPanel9.setBorder(dropShadowBorder3);

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(26, 187, 156));
        jLabel11.setText("Donante");

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(26, 187, 156));
        jLabel8.setText("$ Monto:");

        iddonante.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        iddonante.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        iddonante.setText("id");

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(26, 187, 156));
        jLabel9.setText("Fecha:");

        btnadddonante.setText("Donante");
        btnadddonante.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnadddonanteActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addGap(55, 55, 55)
                        .addComponent(jLabel5))
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addGap(113, 113, 113)
                        .addComponent(jLabel6))
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addGap(55, 55, 55)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(iddonante, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel9Layout.createSequentialGroup()
                                .addGap(73, 73, 73)
                                .addComponent(jLabel4))
                            .addGroup(jPanel9Layout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 95, Short.MAX_VALUE)
                                    .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(monto, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(nombredonante, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(fecha, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnadddonante)))
                .addContainerGap(30, Short.MAX_VALUE))
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addComponent(jLabel3))
                    .addComponent(iddonante))
                .addGap(28, 28, 28)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel11)
                    .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(nombredonante, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnadddonante, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(monto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addComponent(jLabel9)
                        .addGap(7, 7, 7)
                        .addComponent(jLabel4)
                        .addGap(91, 91, 91)
                        .addComponent(jLabel6))
                    .addComponent(fecha, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        btnGuardar.setBackground(new java.awt.Color(26, 187, 156));
        btnGuardar.setForeground(new java.awt.Color(255, 255, 255));
        btnGuardar.setText("GUARDAR");
        btnGuardar.setToolTipText("");
        btnGuardar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnGuardar.setFont(new java.awt.Font("Roboto Medium", 1, 14)); // NOI18N
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });

        btnCancelar.setBackground(new java.awt.Color(243, 156, 17));
        btnCancelar.setForeground(new java.awt.Color(255, 255, 255));
        btnCancelar.setText("Cancelar");
        btnCancelar.setToolTipText("");
        btnCancelar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnCancelar.setFont(new java.awt.Font("Roboto Medium", 1, 14)); // NOI18N
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        ideditar.setText("idtabla");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addComponent(btnGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 49, Short.MAX_VALUE)
                .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(ideditar, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(115, 115, 115))
            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel3Layout.createSequentialGroup()
                    .addGap(23, 23, 23)
                    .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(23, Short.MAX_VALUE)))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addComponent(ideditar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 188, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel3Layout.createSequentialGroup()
                    .addGap(27, 27, 27)
                    .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(71, Short.MAX_VALUE)))
        );

        jPanel8.setBackground(new java.awt.Color(255, 255, 255));

        jPanel10.setBackground(new java.awt.Color(255, 255, 255));
        org.jdesktop.swingx.border.DropShadowBorder dropShadowBorder4 = new org.jdesktop.swingx.border.DropShadowBorder();
        dropShadowBorder4.setShowLeftShadow(true);
        dropShadowBorder4.setShowTopShadow(true);
        jPanel10.setBorder(dropShadowBorder4);

        jLabel14.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(26, 187, 156));
        jLabel14.setText("Empresa:");

        jLabel15.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(26, 187, 156));
        jLabel15.setText("E-mail:");

        jLabel16.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(26, 187, 156));
        jLabel16.setText("Código p.");

        jLabel17.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(26, 187, 156));
        jLabel17.setText("Ciudad:");

        jLabel18.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(26, 187, 156));
        jLabel18.setText("Teléfono:");

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel10Layout.createSequentialGroup()
                                .addGap(113, 113, 113)
                                .addComponent(jLabel13))
                            .addGroup(jPanel10Layout.createSequentialGroup()
                                .addGap(73, 73, 73)
                                .addComponent(jLabel10)))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel10Layout.createSequentialGroup()
                                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(jPanel10Layout.createSequentialGroup()
                                        .addComponent(jLabel14, javax.swing.GroupLayout.DEFAULT_SIZE, 101, Short.MAX_VALUE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel7)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                                    .addGroup(jPanel10Layout.createSequentialGroup()
                                        .addComponent(jLabel15, javax.swing.GroupLayout.DEFAULT_SIZE, 101, Short.MAX_VALUE)
                                        .addGap(12, 12, 12)))
                                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(email, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(empresa, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addGroup(jPanel10Layout.createSequentialGroup()
                                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel17, javax.swing.GroupLayout.DEFAULT_SIZE, 101, Short.MAX_VALUE)
                                    .addComponent(jLabel18, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 95, Short.MAX_VALUE)
                                    .addComponent(jLabel12)
                                    .addComponent(jLabel16, javax.swing.GroupLayout.DEFAULT_SIZE, 101, Short.MAX_VALUE))
                                .addGap(12, 12, 12)
                                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(ciudad, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
                                    .addComponent(codigopostal, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
                                    .addComponent(telefono, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE))))))
                .addContainerGap())
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(telefono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel18)))
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7)
                            .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel14)
                                .addComponent(empresa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(email, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel15))
                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel10Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel12)
                                .addGap(77, 77, 77))
                            .addGroup(jPanel10Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel16)
                                    .addComponent(codigopostal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(ciudad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel17))
                                .addGap(38, 38, 38)))
                        .addComponent(jLabel10)))
                .addGap(91, 91, 91)
                .addComponent(jLabel13)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
            .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel8Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
            .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel8Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, 280, Short.MAX_VALUE)
                    .addContainerGap()))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(titulo2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(12, 12, 12)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(titulo3, javax.swing.GroupLayout.DEFAULT_SIZE, 363, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(titulo2, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(titulo3, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel19.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(42, 63, 84));
        jLabel19.setText("Monto Total del Proyecto:");

        montodonacion.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        montodonacion.setForeground(new java.awt.Color(42, 63, 84));
        montodonacion.setText("0000000.00");

        btneliminar.setBackground(new java.awt.Color(255, 0, 0));
        btneliminar.setForeground(new java.awt.Color(255, 255, 255));
        btneliminar.setText("ELIMINAR");
        btneliminar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btneliminar.setFont(new java.awt.Font("Roboto Medium", 1, 14)); // NOI18N
        btneliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btneliminarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel19)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(montodonacion)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(totregistros))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                        .addComponent(btneliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(buscar, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnbuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(buscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnbuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btneliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 217, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(totregistros)
                    .addComponent(montodonacion)
                    .addComponent(jLabel19))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jScrollPane2.setViewportView(jPanel7);

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(42, 63, 84));
        jLabel1.setText("Proyectos con sus respectivos Donantes");

        btncerrar.setBackground(new java.awt.Color(42, 63, 84));
        btncerrar.setForeground(new java.awt.Color(255, 255, 255));
        btncerrar.setText("X");
        btncerrar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btncerrar.setFont(new java.awt.Font("Calibri Light", 0, 20)); // NOI18N
        btncerrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btncerrarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 667, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 467, Short.MAX_VALUE)
                .addComponent(btncerrar, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 1194, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btncerrar, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(551, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                    .addGap(0, 82, Short.MAX_VALUE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 527, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void buscarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_buscarKeyReleased

    }//GEN-LAST:event_buscarKeyReleased

    private void btncerrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btncerrarActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_btncerrarActionPerformed

    private void btnbuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnbuscarActionPerformed
        // TODO add your handling code here:
        if (proyectos != null) {
            String nombre = this.buscar.getText();
            Nodo dato = dd.ld.buscar(new Donaciones(new Donantes(nombre)));
            if (dato != null) {
                JOptionPane.showMessageDialog(null, "\t\tDATOS DE LA DONACIÓN\n\n"
                        + "Nombre de la Empresa:" + ((Donaciones) dato.getA()).getDonantes().getEmpresa()
                        + "\nNombre del donante: " + ((Donaciones) dato.getA()).getDonantes().getNombre()
                        + "\nMonto: " + ((Donaciones) dato.getA()).getMontodonar()
                        + "\nFecha de la donación:" + sdf.format(((Donaciones) dato.getA()).getFecha()), "Busqueda exitosa", JOptionPane.INFORMATION_MESSAGE);
                this.buscar.setText("");
            } else {
                this.buscar.setText("");
                ErrordeProcesos er = new ErrordeProcesos(new JFrame(), true);
                er.titulo.setText("ERROR DE BÚSQUEDA");
                er.msj.setText("EL REGSITRO NO EXISTE");
                er.msj1.setText("");
                er.setVisible(true);
            }
        } else {
            this.buscar.setText("");
            ErrordeProcesos er = new ErrordeProcesos(new JFrame(), true);
            er.titulo.setText("ERROR");
            er.msj.setText("SELECCIONE UN PROYECTO");
            er.msj1.setText("");
        }
    }//GEN-LAST:event_btnbuscarActionPerformed

    private void panel2MouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panel2MouseDragged

    }//GEN-LAST:event_panel2MouseDragged

    private void panel2MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panel2MousePressed

    }//GEN-LAST:event_panel2MousePressed

    private void listaproyectosValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_listaproyectosValueChanged
        // TODO add your handling code here:
        proyectos = new Proyectos();
        String dato = listaproyectos.getSelectedValue();
        proyectos = buscaridproyecto(dato);
        String idproyecto = "";
        if (proyectos != null) {
            limpiar();
            this.btnadddonante.setEnabled(true);
            idproyecto = String.valueOf(proyectos.getIdproyecto());
            model = (DefaultTableModel) tablaDonaciones.getModel();
            this.id.setText(idproyecto);
            titulo2.setText("Nuevo registro");
            btnGuardar.setBackground(new Color(26, 187, 156));
            btnGuardar.setText("GUARDAR");
            llenarTabla(idproyecto);

            /**/
        } else {
            this.montodonacion.setText("00.00");
            this.totregistros.setText("0");
            ErrordeProcesos er = new ErrordeProcesos(new JFrame(), true);
            er.titulo.setText("OOPS...");
            er.msj.setText("PROYECTO NO ENCONTRADO");
            er.msj1.setText("");
            er.setVisible(true);
        }
    }//GEN-LAST:event_listaproyectosValueChanged

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        // TODO add your handling code here:
        boolean accion = true;
        if (proyectos != null) {
            if (!this.id.getText().isEmpty() && !this.iddonante.getText().isEmpty() && !this.nombredonante.getText().isEmpty()
                    && !this.monto.getText().isEmpty() && this.fecha.getDate() != null && !this.empresa.getText().isEmpty()
                    && !this.email.getText().isEmpty() && !this.codigopostal.getText().isEmpty() && !this.ciudad.getText().isEmpty()
                    && !this.telefono.getText().isEmpty()) {
                int iddonante = Integer.parseInt(this.iddonante.getText());
                int idproyecto = Integer.parseInt(this.id.getText());
                double montodonacion = Double.parseDouble(this.monto.getText());
                Calendar cal;
                int d, m, a;
                cal = this.fecha.getCalendar();
                d = cal.get(Calendar.DAY_OF_MONTH);
                m = cal.get(Calendar.MONTH);
                a = cal.get(Calendar.YEAR) - 1900;

                donaciones.setIddonantes(iddonante);
                donaciones.setIdproyecto(idproyecto);
                donaciones.setMontodonar(montodonacion);
                donaciones.setFecha(new Date(a, m, d));

                donaciones1 = buscardonante(this.nombredonante.getText());
                //&& fecha.getDate().getYear() <= fechaactual.fechaactual().getYear() && fecha.getDate().getMonth() <= fechaactual.fechaactual().getMonth() && fecha.getDate().getDay() <= fechaactual.fechaactual().getDay()
                if (montodonacion > 0) {/*VALIDACIONES PARA LA INGRESACION DE LOS DATOS*/

                    if ((dd.montodonado(id.getText()) + montodonacion) <= proyectos.getMonto()) {
                        accion = true;
                    } else {
                        accion = false;
                    }

                    if (this.btnGuardar.getText().equals("GUARDAR")) {
                        if (accion) {
                            if (dd.ld.toArray().size() < 3) {
                                if (donaciones1 == null) {
                                    dd.insertar(donaciones);
                                    ProcesoExitoso er = new ProcesoExitoso(new JFrame(), true);
                                    er.titulo.setText("REGSITRO GUARDADO");
                                    er.msj.setText("REGSITRO INGRESADO");
                                    er.msj1.setText("SATISFACTORIAMENTE");
                                    er.setVisible(true);
                                    llenarTabla(id.getText());
                                    limpiar();
                                } else {
                                    ErrordeProcesos er = new ErrordeProcesos(new JFrame(), true);
                                    er.titulo.setText("ERROR");
                                    er.msj.setText("EL DONANTE YA HA SIDO INGRESADO");
                                    er.msj1.setText("");
                                    er.setVisible(true);
                                }

                            } else {
                                ErrordeProcesos er = new ErrordeProcesos(new JFrame(), true);
                                er.titulo.setText("ERROR");
                                er.msj.setText("SE HA ALCANZADO EL LIMITE DE REGISTROS DE");
                                er.msj1.setText("DONANTES PARA ESTE PROYECTO");
                                er.setVisible(true);

                            }
                        } else {
                            if (dd.ld.toArray().size() < 1) {
                                ErrordeProcesos er = new ErrordeProcesos(new JFrame(), true);
                                er.titulo.setText("ERROR");
                                er.msj.setText("EL MONTO INGRESADO SUPERA AL");
                                er.msj1.setText("MONTO TOTAL DEL PROYECTO");
                                er.setVisible(true);
                            } else {
                                ErrordeProcesos er = new ErrordeProcesos(new JFrame(), true);
                                er.titulo.setText("ERROR");
                                er.msj.setText("EL MONTO INGRESADO CON LOS ANTERIORES SUPERA");
                                er.msj1.setText("AL MONTO TOTAL DEL PROYECTO");
                                er.setVisible(true);
                            }
                        }
                    } else if (this.btnGuardar.getText().equals("ACTUALIZAR")) {
                        if (((dd.montodonado(id.getText()) - montoeditar) + montodonacion) <= proyectos.getMonto()) {
                            donaciones.setIddonaciones(Integer.parseInt(this.ideditar.getText()));
                            dd.editar(donaciones);
                            ProcesoExitoso er = new ProcesoExitoso(new JFrame(), true);
                            er.titulo.setText("REGSITRO MODIFICADO");
                            er.msj.setText("REGSITRO ACTUALIZADO");
                            er.msj1.setText("SATISFACTORIAMENTE");
                            er.setVisible(true);
                            titulo2.setText("Nuevo registro");
                            btnGuardar.setBackground(new Color(26, 187, 156));
                            btnGuardar.setText("GUARDAR");
                            llenarTabla(id.getText());
                            limpiar();
                        } else {
                            if (dd.ld.toArray().size() < 1) {
                                ErrordeProcesos er = new ErrordeProcesos(new JFrame(), true);
                                er.titulo.setText("ERROR");
                                er.msj.setText("EL MONTO INGRESADO SUPERA AL");
                                er.msj1.setText("MONTO TOTAL DEL PROYECTO");
                                er.setVisible(true);
                            } else {
                                ErrordeProcesos er = new ErrordeProcesos(new JFrame(), true);
                                er.titulo.setText("ERROR");
                                er.msj.setText("EL MONTO INGRESADO CON LOS ANTERIORES SUPERA");
                                er.msj1.setText("AL MONTO TOTAL DEL PROYECTO");
                                er.setVisible(true);
                            }
                        }
                    }
                } else {
                    ErrordeProcesos er = new ErrordeProcesos(new JFrame(), true);
                    er.titulo.setText("MONTO INVALIDO");
                    er.msj.setText("EL MONTO INGRESADO ES INVALIDO");
                    er.msj1.setText("");
                    er.setVisible(true);
                }
            } else {
                ErrordeProcesos er = new ErrordeProcesos(new JFrame(), true);
                er.titulo.setText("CAMPOS VACÍOS");
                er.msj.setText("POR FAVOR LLENE LOS CAMPOS");
                er.msj1.setText("SOLICITADOS");
                er.setVisible(true);
            }
        } else {
            ErrordeProcesos er = new ErrordeProcesos(new JFrame(), true);
            er.titulo.setText("ERROR");
            er.msj.setText("SELECCIONE UN PROYECTO");
            er.msj1.setText("");
            er.setVisible(true);
        }
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed

        limpiar();
        titulo2.setText("Nuevo registro");
        btnGuardar.setBackground(new Color(26, 187, 156));
        btnGuardar.setText("GUARDAR");
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnadddonanteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnadddonanteActionPerformed
        // TODO add your handling code here:
        vistadonantes vd = new vistadonantes();
        vd.setVisible(true);
    }//GEN-LAST:event_btnadddonanteActionPerformed

    private void tablaDonacionesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaDonacionesMouseClicked
        // TODO add your handling code here:
        int fila = this.tablaDonaciones.getSelectedRow();
        ideditar.setText(this.tablaDonaciones.getValueAt(fila, 0).toString());
        nombredonante.setText(this.tablaDonaciones.getValueAt(fila, 1).toString());
        empresa.setText(this.tablaDonaciones.getValueAt(fila, 2).toString());
        monto.setText(this.tablaDonaciones.getValueAt(fila, 3).toString());
        montoeditar = Double.parseDouble(this.tablaDonaciones.getValueAt(fila, 3).toString());
        fecha.setDate(Date.valueOf(this.tablaDonaciones.getValueAt(fila, 4).toString()));
        iddonante.setText(this.tablaDonaciones.getValueAt(fila, 5).toString());
        email.setText(this.tablaDonaciones.getValueAt(fila, 6).toString());
        codigopostal.setText(this.tablaDonaciones.getValueAt(fila, 7).toString());
        ciudad.setText(this.tablaDonaciones.getValueAt(fila, 8).toString());
        telefono.setText(this.tablaDonaciones.getValueAt(fila, 9).toString());
        titulo2.setText("Editar registro");
        btnGuardar.setBackground(new Color(51, 85, 193));
        btnGuardar.setText("ACTUALIZAR");
    }//GEN-LAST:event_tablaDonacionesMouseClicked

    private void btneliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btneliminarActionPerformed
        if (this.tablaDonaciones.getRowCount() < 1) {
            ErrordeProcesos er = new ErrordeProcesos(new JFrame(), true);
            er.titulo.setText("OOPS...");
            er.msj.setText("NO HAY REGISTROS");
            er.msj1.setText("");
            er.setVisible(true);
        } else {
            if (this.tablaDonaciones.getSelectedRowCount() < 1) {
                ErrordeProcesos er = new ErrordeProcesos(new JFrame(), true);
                er.titulo.setText("OOPS...");
                er.msj.setText("SELECCIONA UN");
                er.msj1.setText("REGISTRO");
                er.setVisible(true);
            } else {
                int fila = this.tablaDonaciones.getSelectedRow();
                AlertadeEliminacion wa = new AlertadeEliminacion(new JFrame(), true);
                wa.titulo.setText("¿ESTAS SEGURO?");
                wa.msj.setText("SE BORRARA PERMANENTEMENTE");
                wa.msj1.setText("EL REGISTRO SELECCIONADO");
                wa.setVisible(true);
                if (AlertadeEliminacion.salir == true) {
                    wa.nombre.setText(this.tablaDonaciones.getValueAt(fila, 1).toString());
                    donaciones = new Donaciones(new Donantes(wa.nombre.getText()));
                    Nodo eliminar = dd.ld.eliminar(donaciones);
                    if (eliminar != null) {
                        dd.eliminar((Donaciones) eliminar.getA());
                        ProcesoExitoso er = new ProcesoExitoso(new JFrame(), true);
                        er.titulo.setText("");
                        er.msj.setText("REGSITRO ELIMINADO");
                        er.msj1.setText("SATISFACTORIAMENTE");
                        er.setVisible(true);
                    } else {
                        ErrordeProcesos er = new ErrordeProcesos(new JFrame(), true);
                        er.titulo.setText("OOPS...");
                        er.msj.setText("EL REGISTRO NO SE");
                        er.msj1.setText("PUDO ELIMINAR");
                        er.setVisible(true);
                    }
                }
                llenarTabla(this.id.getText());
                limpiar();
                titulo2.setText("Nuevo registro");
                btnGuardar.setBackground(new Color(26, 187, 156));
                btnGuardar.setText("GUARDAR");
            }
        }
    }//GEN-LAST:event_btneliminarActionPerformed

    /*Metodo para llenar la tabla con los datos correspondientes de los respectivos donantes por proyectos*/
    public void llenarTabla(String dato) {
        dd = new dao_donaciones();
        dd.llenarpila(dd.mostrardonaciones(this.id.getText()));/*llenando la lista para realizar las respectivas validaciones*/
        eliminarFilas();
        ocultar_columnas();
        int registros = 0;
        String[] m = new String[11];
        for (Donaciones d : dd.llenarlistadonaciones(dd.mostrardonaciones(dato))) {
            m[0] = String.valueOf(d.getIddonaciones());
            m[1] = d.getDonantes().getNombre();
            m[2] = d.getDonantes().getEmpresa();
            m[3] = String.valueOf(d.getMontodonar());
            m[4] = String.valueOf(d.getFecha());
            /*ocultos de la tabla*/
            m[5] = String.valueOf(d.getDonantes().getIddonantes());
            m[6] = d.getDonantes().getEmail();
            m[7] = d.getDonantes().getCodigopostal();
            m[8] = d.getDonantes().getCiudad();
            m[9] = d.getDonantes().getTelefono();
            m[10] = String.valueOf(d.getProyectos().getIdproyecto());
            model.addRow(m);
            registros += 1;
        }
        this.totregistros.setText(String.valueOf(registros));
        this.montodonacion.setText(String.valueOf(dd.montodonado(dato)));
        saldoalcaldia();
    }

    /*Metodo de eliminacion de las filas para que no se dupliquen los datos al mostrarlos al registrar uno nuevo*/
    public void eliminarFilas() {
        try {
            int filas = model.getRowCount();
            for (int i = 0; filas > i; i++) {
                model.removeRow(0);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "No se puede limpiar la tabla", "", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    /*busqueda del id del proyecto*/
    public Proyectos buscaridproyecto(String dato) {
        for (Proyectos p : dp.mostrarproyectos("")) {
            if (p.getDescripción().equals(dato)) {
                return p;
            }
        }
        return null;
    }

    /*Metodo para la lista*/
    public void llenarlista() {
        dp = new dao_proyectos();
        for (Proyectos p : dp.mostrarproyectosnocancelados()) {
            modelolista.addElement(p.getDescripción());
        }
    }

    /*Metodo para buscar el id del donante para que no se vuelva a agregar*/
    public Donaciones buscardonante(String nombre) {
        Nodo dato = dd.ld.buscar(new Donaciones(new Donantes(nombre)));
        if (dato != null) {
            return (Donaciones) dato.getA();
        }
        return null;
    }

    /*Metodo solo para mostrar el saldo que le toca abonar la alcaldia en caso de que el saldo 
    acumulado de los donantes sea menor al monto total del proyecto*/
    public void saldoalcaldia() {
        double montoalcaldia = 0;
        while (!dd.piladonaciones.isEmpty()) {
            montoalcaldia += ((Donaciones) dd.piladonaciones.pop()).getMontodonar();
        }
        jLabel21.setText(String.valueOf(proyectos.getMonto() - montoalcaldia));
    }

    public void limpiar() {
        this.iddonante.setText("");
        this.ideditar.setText("");
        this.nombredonante.setText("");
        this.empresa.setText("");
        this.email.setText("");
        this.codigopostal.setText("");
        this.ciudad.setText("");
        this.telefono.setText("");
        this.monto.setText("");
        this.fecha.setDate(new java.util.Date());
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private principal.MaterialButton btnCancelar;
    public principal.MaterialButton btnGuardar;
    private javax.swing.JButton btnadddonante;
    private rsbuttom.RSButtonMetro btnbuscar;
    private principal.MaterialButton btncerrar;
    private principal.MaterialButton btneliminar;
    public static app.bolivia.swing.JCTextField buscar;
    public static app.bolivia.swing.JCTextField ciudad;
    public static app.bolivia.swing.JCTextField codigopostal;
    public static app.bolivia.swing.JCTextField email;
    public static app.bolivia.swing.JCTextField empresa;
    private com.toedter.calendar.JDateChooser fecha;
    public javax.swing.JLabel id;
    public static javax.swing.JLabel iddonante;
    private javax.swing.JLabel ideditar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JList<String> listaproyectos;
    private principal.MaterialButtonCircle materialButtonCircle1;
    public app.bolivia.swing.JCTextField monto;
    private javax.swing.JLabel montodonacion;
    public static app.bolivia.swing.JCTextField nombredonante;
    private org.edisoncor.gui.panel.Panel panel2;
    public static javax.swing.JTable tablaDonaciones;
    public static app.bolivia.swing.JCTextField telefono;
    public javax.swing.JLabel titulo1;
    public javax.swing.JLabel titulo2;
    public javax.swing.JLabel titulo3;
    public static javax.swing.JLabel totregistros;
    // End of variables declaration//GEN-END:variables
}
