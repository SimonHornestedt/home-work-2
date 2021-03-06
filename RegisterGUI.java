
import java.io.*;
import java.net.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Simon
 */
public class RegisterGUI extends javax.swing.JFrame {
        /**
         * medlemsvariabler
         */
        private boolean serverStarted;
        public Model lib; 
        private MyTableModel tableModel = new MyTableModel();
        /**
         * skapar GUI
         * @throws IOException 
         */
    public RegisterGUI() throws IOException {
        serverStarted = false;
        lib = new Model();
        tableModel = new MyTableModel();
        initComponents();
        jTable1.getTableHeader().setReorderingAllowed(false);
        jTable1.setAutoCreateRowSorter(true);
        jTable1.setRowSelectionAllowed(true);
        jTable1.setCellSelectionEnabled(false);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenu1 = new javax.swing.JMenu();
        jTabPane = new javax.swing.JTabbedPane();
        pnlLib = new javax.swing.JPanel();
        lblCurrentLib = new javax.swing.JLabel();
        lblAddObject = new javax.swing.JLabel();
        lblTitle = new javax.swing.JLabel();
        lblCreator = new javax.swing.JLabel();
        lblType = new javax.swing.JLabel();
        lblScore = new javax.swing.JLabel();
        btnAddObject = new javax.swing.JButton();
        btnClear = new javax.swing.JButton();
        btnRemove = new javax.swing.JButton();
        txfTitle = new javax.swing.JTextField();
        txfCreator = new javax.swing.JTextField();
        cmbxType = new javax.swing.JComboBox();
        cmbxScore = new javax.swing.JComboBox();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        pnlURL = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        txaResultURL = new javax.swing.JTextArea();
        lblResultURL = new javax.swing.JLabel();
        lblGetURL = new javax.swing.JLabel();
        txfMovieTitleURL = new javax.swing.JTextField();
        btnGetURL = new javax.swing.JButton();
        txfYearOfPub = new javax.swing.JTextField();
        lblYearOfpub = new javax.swing.JLabel();
        pnlChatt = new javax.swing.JPanel();
        btnStartServer = new javax.swing.JButton();
        btnStartClient = new javax.swing.JButton();
        txfIP = new javax.swing.JTextField();
        lblIp = new javax.swing.JLabel();
        menu = new javax.swing.JMenuBar();
        menuArchive = new javax.swing.JMenu();
        menuItemNew = new javax.swing.JMenuItem();
        menuItemOpen = new javax.swing.JMenuItem();
        menuItemSave = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        menuItemImport = new javax.swing.JMenuItem();
        menuItemExport = new javax.swing.JMenuItem();
        jSeparator2 = new javax.swing.JPopupMenu.Separator();
        menuItemFinish = new javax.swing.JMenuItem();
        menuAbout = new javax.swing.JMenu();
        menuItemAbout = new javax.swing.JMenuItem();
        menuItemHelp = new javax.swing.JMenuItem();

        jMenu1.setText("jMenu1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        lblCurrentLib.setText("Current library: default.csv");

        lblAddObject.setText("Add object to library");

        lblTitle.setText("Title:");

        lblCreator.setText("Creator:");

        lblType.setText("Type:");

        lblScore.setText("Score:");

        btnAddObject.setText("Add");
        btnAddObject.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddObjectActionPerformed(evt);
            }
        });

        btnClear.setText("Clear");
        btnClear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClearActionPerformed(evt);
            }
        });

        btnRemove.setText("Remove Object");
        btnRemove.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRemoveActionPerformed(evt);
            }
        });

        cmbxType.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Movie", "Audio" }));

        cmbxScore.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "1", "2", "3", "4", "5" }));

        jTable1.setModel(tableModel);
        jScrollPane1.setViewportView(jTable1);

        javax.swing.GroupLayout pnlLibLayout = new javax.swing.GroupLayout(pnlLib);
        pnlLib.setLayout(pnlLibLayout);
        pnlLibLayout.setHorizontalGroup(
            pnlLibLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlLibLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlLibLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlLibLayout.createSequentialGroup()
                        .addComponent(lblCurrentLib)
                        .addGap(58, 502, Short.MAX_VALUE))
                    .addGroup(pnlLibLayout.createSequentialGroup()
                        .addComponent(btnAddObject, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnClear, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(pnlLibLayout.createSequentialGroup()
                        .addGroup(pnlLibLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 623, Short.MAX_VALUE)
                            .addGroup(pnlLibLayout.createSequentialGroup()
                                .addGroup(pnlLibLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblAddObject)
                                    .addComponent(lblTitle)
                                    .addComponent(txfTitle))
                                .addGap(18, 18, 18)
                                .addGroup(pnlLibLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txfCreator, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lblCreator))
                                .addGap(18, 18, 18)
                                .addGroup(pnlLibLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(pnlLibLayout.createSequentialGroup()
                                        .addComponent(lblType)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(lblScore))
                                    .addGroup(pnlLibLayout.createSequentialGroup()
                                        .addComponent(cmbxType, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(cmbxScore, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                        .addContainerGap())))
            .addGroup(pnlLibLayout.createSequentialGroup()
                .addGap(260, 260, 260)
                .addComponent(btnRemove)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        pnlLibLayout.setVerticalGroup(
            pnlLibLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlLibLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblCurrentLib)
                .addGap(18, 18, 18)
                .addComponent(lblAddObject)
                .addGap(18, 18, 18)
                .addGroup(pnlLibLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblTitle)
                    .addComponent(lblCreator)
                    .addComponent(lblType)
                    .addComponent(lblScore))
                .addGap(18, 18, 18)
                .addGroup(pnlLibLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txfTitle, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txfCreator, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmbxType, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmbxScore, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28)
                .addGroup(pnlLibLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAddObject)
                    .addComponent(btnClear))
                .addGap(28, 28, 28)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 227, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(42, 42, 42)
                .addComponent(btnRemove)
                .addContainerGap(68, Short.MAX_VALUE))
        );

        jTabPane.addTab("Librarys", pnlLib);

        txaResultURL.setColumns(20);
        txaResultURL.setRows(5);
        jScrollPane2.setViewportView(txaResultURL);

        lblResultURL.setText("Result:");

        lblGetURL.setText("What movie do you want me to grab the stats from?");

        btnGetURL.setText("Go get them tiger! ");
        btnGetURL.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGetURLActionPerformed(evt);
            }
        });

        lblYearOfpub.setText("What year was that movie published?");

        javax.swing.GroupLayout pnlURLLayout = new javax.swing.GroupLayout(pnlURL);
        pnlURL.setLayout(pnlURLLayout);
        pnlURLLayout.setHorizontalGroup(
            pnlURLLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlURLLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(pnlURLLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblGetURL)
                    .addComponent(lblResultURL)
                    .addGroup(pnlURLLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(pnlURLLayout.createSequentialGroup()
                            .addGroup(pnlURLLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(txfMovieTitleURL, javax.swing.GroupLayout.PREFERRED_SIZE, 444, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(lblYearOfpub))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnGetURL))
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 602, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(txfYearOfPub, javax.swing.GroupLayout.PREFERRED_SIZE, 444, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(21, Short.MAX_VALUE))
        );
        pnlURLLayout.setVerticalGroup(
            pnlURLLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlURLLayout.createSequentialGroup()
                .addGap(55, 55, 55)
                .addComponent(lblGetURL)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlURLLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txfMovieTitleURL, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnGetURL))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblYearOfpub)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txfYearOfPub, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lblResultURL)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 295, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(72, Short.MAX_VALUE))
        );

        jTabPane.addTab("oMDB", pnlURL);

        btnStartServer.setText("CLICK ME FIRST");
        btnStartServer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnStartServerActionPerformed(evt);
            }
        });

        btnStartClient.setText("THEN CLICK ME!");
        btnStartClient.setEnabled(false);
        btnStartClient.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnStartClientActionPerformed(evt);
            }
        });

        lblIp.setText("Connect to this IPv4 adress");

        javax.swing.GroupLayout pnlChattLayout = new javax.swing.GroupLayout(pnlChatt);
        pnlChatt.setLayout(pnlChattLayout);
        pnlChattLayout.setHorizontalGroup(
            pnlChattLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlChattLayout.createSequentialGroup()
                .addGroup(pnlChattLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlChattLayout.createSequentialGroup()
                        .addGap(169, 169, 169)
                        .addComponent(txfIP, javax.swing.GroupLayout.PREFERRED_SIZE, 269, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnlChattLayout.createSequentialGroup()
                        .addGap(242, 242, 242)
                        .addComponent(lblIp)))
                .addContainerGap(205, Short.MAX_VALUE))
            .addGroup(pnlChattLayout.createSequentialGroup()
                .addGap(105, 105, 105)
                .addComponent(btnStartServer)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnStartClient)
                .addGap(152, 152, 152))
        );
        pnlChattLayout.setVerticalGroup(
            pnlChattLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlChattLayout.createSequentialGroup()
                .addGap(98, 98, 98)
                .addComponent(lblIp)
                .addGap(33, 33, 33)
                .addComponent(txfIP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 157, Short.MAX_VALUE)
                .addGroup(pnlChattLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnStartClient)
                    .addComponent(btnStartServer))
                .addGap(221, 221, 221))
        );

        jTabPane.addTab("Chatt", pnlChatt);

        menuArchive.setText("Archive");

        menuItemNew.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_N, java.awt.event.InputEvent.CTRL_MASK));
        menuItemNew.setText("New collection...");
        menuItemNew.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemNewActionPerformed(evt);
            }
        });
        menuArchive.add(menuItemNew);

        menuItemOpen.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_O, java.awt.event.InputEvent.CTRL_MASK));
        menuItemOpen.setText("Open collection...");
        menuItemOpen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemOpenActionPerformed(evt);
            }
        });
        menuArchive.add(menuItemOpen);

        menuItemSave.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S, java.awt.event.InputEvent.CTRL_MASK));
        menuItemSave.setText("Save collection...");
        menuItemSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemSaveActionPerformed(evt);
            }
        });
        menuArchive.add(menuItemSave);
        menuArchive.add(jSeparator1);

        menuItemImport.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_I, java.awt.event.InputEvent.CTRL_MASK));
        menuItemImport.setText("Import XML");
        menuItemImport.setEnabled(false);
        menuItemImport.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemImportActionPerformed(evt);
            }
        });
        menuArchive.add(menuItemImport);

        menuItemExport.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_E, java.awt.event.InputEvent.CTRL_MASK));
        menuItemExport.setText("Export XML");
        menuItemExport.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemExportActionPerformed(evt);
            }
        });
        menuArchive.add(menuItemExport);
        menuArchive.add(jSeparator2);

        menuItemFinish.setText("Finish");
        menuItemFinish.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemFinishActionPerformed(evt);
            }
        });
        menuArchive.add(menuItemFinish);

        menu.add(menuArchive);

        menuAbout.setText("About");

        menuItemAbout.setText("About");
        menuItemAbout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemAboutActionPerformed(evt);
            }
        });
        menuAbout.add(menuItemAbout);

        menuItemHelp.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_H, java.awt.event.InputEvent.CTRL_MASK));
        menuItemHelp.setText("Help");
        menuItemHelp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemHelpActionPerformed(evt);
            }
        });
        menuAbout.add(menuItemHelp);

        menu.add(menuAbout);

        setJMenuBar(menu);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabPane)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabPane, javax.swing.GroupLayout.PREFERRED_SIZE, 594, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(43, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    /**
     * Stänger av programmet vid klick på finish
     * @param evt knapptryckningen
     */
    private void menuItemFinishActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemFinishActionPerformed
        System.exit(EXIT_ON_CLOSE);
    }//GEN-LAST:event_menuItemFinishActionPerformed
    /**
    * Metoden kör ReadURL
    * @param evt är knapptryckningen
    */
    private void btnGetURLActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGetURLActionPerformed
        try {
            this.readURL(evt);
        } catch (Exception ex) {
            Logger.getLogger(RegisterGUI.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnGetURLActionPerformed
    /**
    * Metoden läser en URL som användaren skriver in i textfältet.
    *
    * @param evt är knapptryckningen
    * @throws Exception alla möjliga fel som kan bli. 
    */
    private void readURL(java.awt.event.ActionEvent evt) throws Exception {                                          
       txaResultURL.setText("");
       String t = txfMovieTitleURL.getText();
       String replaced = t.replace(" ", "+");
       String y = txfYearOfPub.getText();
       URL oracle = new URL("http://www.omdbapi.com/?t="+ replaced + "&y="+y);
       URLConnection yc = oracle.openConnection();
       BufferedReader in = new BufferedReader(new InputStreamReader(
                                   yc.getInputStream()));
       String inputLine;
       while ((inputLine = in.readLine()) != null) {
           replaced = inputLine.replace('"'+":", '"' +": \n");
           String [] stats = replaced.split(",");
           for(String str : stats){
               txaResultURL.append(str + "\n");
           }
       }
       in.close();
   } 
    /**
     * Lägger till ett objekt vid klick på btnAddObject
     * och uppdaterar tabellen
     * @param evt knapptryckningen
     */
    private void btnAddObjectActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddObjectActionPerformed
        int type = cmbxType.getSelectedIndex();
        switch(type){
            case 0:
               Movie m = new Movie(txfTitle.getText(), txfCreator.getText(), cmbxScore.getSelectedIndex()+1);
               lib.addMovie(m);
               System.out.print(m.toString());
            break;
            case 1:
               Audio a = new Audio(txfTitle.getText(), txfCreator.getText(), cmbxScore.getSelectedIndex()+1);
               lib.addAudio(a);
            break;
            default:
               JOptionPane.showMessageDialog(null, "Denna typ av objekt går inte att använda.");
            break;
                
        }
        lib.updateTable(tableModel);
    }//GEN-LAST:event_btnAddObjectActionPerformed
/**
 * låter anvöndaren skriva in ett namn och skapar en ny collection
 * @param evt knapptryckningen
 */
    private void menuItemNewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemNewActionPerformed
        String name = JOptionPane.showInputDialog("Name the new collection:");
        if(name != null){
            try {
                lib.newCollection(name);
            } catch (IOException ex) {
                Logger.getLogger(RegisterGUI.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        tableModel.reset();
        lib.updateTable(tableModel);
        lblCurrentLib.setText("Current library: " +lib.getSelectedCollection());
    }//GEN-LAST:event_menuItemNewActionPerformed
    /**
     * Skapar/sparar fil
     * @param evt knapptryckning
     */
    private void menuItemSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemSaveActionPerformed
            try {
                lib.writeToFile();
            } catch (IOException ex) {
                Logger.getLogger(RegisterGUI.class.getName()).log(Level.SEVERE, null, ex);
            }
    }//GEN-LAST:event_menuItemSaveActionPerformed
  /**
   * Läser in en existerand fil
   * @param evt knapptryckning
   */
    private void menuItemOpenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemOpenActionPerformed
        lib.readFile();
        lblCurrentLib.setText("Current library: " +lib.getSelectedCollection()); 
        tableModel.reset();
        lib.updateTable(tableModel);
    }//GEN-LAST:event_menuItemOpenActionPerformed
    /**
     * Tömmer input fälten
     * @param evt knapptryckningen
     */
    private void btnClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClearActionPerformed
        txfTitle.setText("");
        txfCreator.setText("");
    }//GEN-LAST:event_btnClearActionPerformed
    /**
     * Startar serverna om den inte redan körs
     * @param evt knapptryckning
     */
    private void btnStartServerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnStartServerActionPerformed
        
        btnStartServer.setEnabled(false);
        btnStartClient.setEnabled(true);
        if(serverStarted){
            JOptionPane.showMessageDialog(null, "The server has already been started. "
                    + "Restart the program to be able to reconnect.");
            btnStartClient.setEnabled(false);
        }else{
            lib.startServer();
            serverStarted = true;
        }
        
    }//GEN-LAST:event_btnStartServerActionPerformed
    /**
     * Startar klienten
     * @param evt knapptryckning
     */
    private void btnStartClientActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnStartClientActionPerformed
        btnStartServer.setEnabled(true);
        btnStartClient.setEnabled(false);
        lib.startClient(txfIP.getText());
    }//GEN-LAST:event_btnStartClientActionPerformed
    /**
     * Exporterar fil till XML
     * @param evt knapptryckning
     */
    private void menuItemExportActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemExportActionPerformed
        XMLparser parser = new XMLparser();
        String str =  JOptionPane.showInputDialog("Name the exported file");
        parser.writeXML(str, lib.getCurrentCollection());
    }//GEN-LAST:event_menuItemExportActionPerformed
    /**
     * Importerar XML kan inte köras för tillfället då jag inte får den att fungera.
     * @param evt knapptryckning
     */
    private void menuItemImportActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemImportActionPerformed
        XMLparser parser = new XMLparser();
        String fileName = lib.getImportFileName();
        if("error".equals(fileName)){
           JOptionPane.showMessageDialog(null, "ERROR");
        }else{
           parser.readXML(fileName);
        }
    }//GEN-LAST:event_menuItemImportActionPerformed
    /**
     * Tar bort ett markerat objekt. 
     * @param evt knapptryckning
     */
    private void btnRemoveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRemoveActionPerformed
        int selectedID = Integer.parseInt(jTable1.getValueAt(jTable1.getSelectedRow(), 4).toString());
        lib.removeObject(selectedID);
        tableModel.reset();
        lib.updateTable(tableModel);
    }//GEN-LAST:event_btnRemoveActionPerformed
    /**
     * Skickar upp en dialogruta med info om mig
     * @param evt knapptryckning
     */
    private void menuItemAboutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemAboutActionPerformed
        JOptionPane.showMessageDialog(null, "\u00a9 Simon Hornestedt \n 2015-03-17");
    }//GEN-LAST:event_menuItemAboutActionPerformed
    /**
     * Skickar upp en dialog om programmet
     * @param evt knapptryckningen
     */
    private void menuItemHelpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemHelpActionPerformed
        JOptionPane.showMessageDialog(null, "Version: 1.0.0");
    }//GEN-LAST:event_menuItemHelpActionPerformed
   
   
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
            java.util.logging.Logger.getLogger(RegisterGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(RegisterGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(RegisterGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(RegisterGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new RegisterGUI().setVisible(true);
                } catch (IOException ex) {
                    Logger.getLogger(RegisterGUI.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAddObject;
    private javax.swing.JButton btnClear;
    private javax.swing.JButton btnGetURL;
    private javax.swing.JButton btnRemove;
    private javax.swing.JButton btnStartClient;
    private javax.swing.JButton btnStartServer;
    private javax.swing.JComboBox cmbxScore;
    private javax.swing.JComboBox cmbxType;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JPopupMenu.Separator jSeparator2;
    private javax.swing.JTabbedPane jTabPane;
    private javax.swing.JTable jTable1;
    private javax.swing.JLabel lblAddObject;
    private javax.swing.JLabel lblCreator;
    private javax.swing.JLabel lblCurrentLib;
    private javax.swing.JLabel lblGetURL;
    private javax.swing.JLabel lblIp;
    private javax.swing.JLabel lblResultURL;
    private javax.swing.JLabel lblScore;
    private javax.swing.JLabel lblTitle;
    private javax.swing.JLabel lblType;
    private javax.swing.JLabel lblYearOfpub;
    private javax.swing.JMenuBar menu;
    private javax.swing.JMenu menuAbout;
    private javax.swing.JMenu menuArchive;
    private javax.swing.JMenuItem menuItemAbout;
    private javax.swing.JMenuItem menuItemExport;
    private javax.swing.JMenuItem menuItemFinish;
    private javax.swing.JMenuItem menuItemHelp;
    private javax.swing.JMenuItem menuItemImport;
    private javax.swing.JMenuItem menuItemNew;
    private javax.swing.JMenuItem menuItemOpen;
    private javax.swing.JMenuItem menuItemSave;
    private javax.swing.JPanel pnlChatt;
    private javax.swing.JPanel pnlLib;
    private javax.swing.JPanel pnlURL;
    private javax.swing.JTextArea txaResultURL;
    private javax.swing.JTextField txfCreator;
    private javax.swing.JTextField txfIP;
    private javax.swing.JTextField txfMovieTitleURL;
    private javax.swing.JTextField txfTitle;
    private javax.swing.JTextField txfYearOfPub;
    // End of variables declaration//GEN-END:variables
}
