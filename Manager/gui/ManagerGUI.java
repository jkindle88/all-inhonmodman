
package Manager.gui;

import utility.Game;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import Manager.gui.l10n.L10n;
import Manager.manager.Manager;
import business.Mod;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableModel;
import org.apache.log4j.Logger;

/**
 * Main form of the ModManager. This class is the 'view' part of the MVC framework
 *
 * @author Shirkit
 */
public class ManagerGUI extends javax.swing.JFrame implements Observer {
    // Model for this View (part of MVC pattern)
    private Manager model;
    private static Logger logger = Logger.getLogger(ManagerGUI.class.getPackage().getName());
    // Column names of the mod list table
    private String[] columnNames = new String [] {
        "",
        L10n.getString("table.modname"),
        L10n.getString("table.modauthor"),
        L10n.getString("table.modversion"),
        L10n.getString("table.modstatus")
    };
    private Object[][] tableData;

    /** Creates new form NewJFrame */
    public ManagerGUI(Manager model) {
        this.model = model;
        this.model.addObserver(this);
        initComponents();
        // Components on the Mod details panel are not visible by default
        setDetailsVisible(false);
        // This thing here is working along with formComponentShown to solve the fucking bug of not showing the correct size when running the app
        this.setResizable(false);

    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelModList = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableModList = new javax.swing.JTable();
        buttonApplyMods = new javax.swing.JButton();
        buttonAddMod = new javax.swing.JButton();
        panelModDetails = new javax.swing.JPanel();
        labelModIcon = new javax.swing.JLabel();
        labelModName = new javax.swing.JLabel();
        labelModAuthor = new javax.swing.JLabel();
        panelModDescription = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        areaModDesc = new javax.swing.JTextArea();
        labelVisitWebsite = new javax.swing.JLabel();
        labelModStatus = new javax.swing.JLabel();
        buttonEnableMod = new javax.swing.JButton();
        mainMenu = new javax.swing.JMenuBar();
        menuFile = new javax.swing.JMenu();
        itemApplyMods = new javax.swing.JMenuItem();
        itemApplyAndLaunch = new javax.swing.JMenuItem();
        itemUnapplyAllMods = new javax.swing.JMenuItem();
        itemOpenModFolder = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        itemExit = new javax.swing.JMenuItem();
        menuOptions = new javax.swing.JMenu();
        itemChangePath = new javax.swing.JMenuItem();
        itemChangePathManually = new javax.swing.JMenuItem();
        jSeparator3 = new javax.swing.JPopupMenu.Separator();
        menuHelp = new javax.swing.JMenu();
        itemVisitForumThread = new javax.swing.JMenuItem();
        jSeparator4 = new javax.swing.JPopupMenu.Separator();
        itemAbout = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle(L10n.getString("application.title"));
        setMinimumSize(new java.awt.Dimension(700, 350));
        setName("Form"); // NOI18N
        addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                formComponentShown(evt);
            }
        });

        panelModList.setMinimumSize(new java.awt.Dimension(400, 250));
        panelModList.setName("panelModList"); // NOI18N

        jScrollPane1.setName("jScrollPane1"); // NOI18N

        tableModList.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "", "Name", "Author", "Version", "Status"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Boolean.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                true, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tableModList.setName("tableModList"); // NOI18N
        jScrollPane1.setViewportView(tableModList);

        javax.swing.GroupLayout panelModListLayout = new javax.swing.GroupLayout(panelModList);
        panelModList.setLayout(panelModListLayout);
        panelModListLayout.setHorizontalGroup(
            panelModListLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelModListLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 421, Short.MAX_VALUE))
        );
        panelModListLayout.setVerticalGroup(
            panelModListLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelModListLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 424, Short.MAX_VALUE))
        );

        buttonApplyMods.setText(L10n.getString("button.applymods"));
        buttonApplyMods.setName("buttonApplyMods"); // NOI18N

        buttonAddMod.setText(L10n.getString("button.addmod"));
        buttonAddMod.setName("buttonAddMod"); // NOI18N

        panelModDetails.setBorder(javax.swing.BorderFactory.createTitledBorder(" "+L10n.getString("panel.details.label")+" "));
        panelModDetails.setMinimumSize(new java.awt.Dimension(0, 250));
        panelModDetails.setName("panelModDetails"); // NOI18N

        labelModIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Manager/gui/resources/icon.png"))); // NOI18N
        labelModIcon.setName("labelModIcon"); // NOI18N

        labelModName.setFont(new java.awt.Font("Tahoma", 1, 14));
        labelModName.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelModName.setText("mod name");
        labelModName.setName("labelModName"); // NOI18N

        labelModAuthor.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelModAuthor.setText("mod author");
        labelModAuthor.setName("labelModAuthor"); // NOI18N

        panelModDescription.setName("panelModDescription"); // NOI18N

        jScrollPane2.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jScrollPane2.setName("jScrollPane2"); // NOI18N

        areaModDesc.setBackground(new java.awt.Color(212, 208, 200));
        areaModDesc.setColumns(20);
        areaModDesc.setEditable(false);
        areaModDesc.setFont(new java.awt.Font("Tahoma", 0, 11));
        areaModDesc.setLineWrap(true);
        areaModDesc.setRows(5);
        areaModDesc.setText("mod desc");
        areaModDesc.setWrapStyleWord(true);
        areaModDesc.setAutoscrolls(false);
        areaModDesc.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        areaModDesc.setName("areaModDesc"); // NOI18N
        jScrollPane2.setViewportView(areaModDesc);

        javax.swing.GroupLayout panelModDescriptionLayout = new javax.swing.GroupLayout(panelModDescription);
        panelModDescription.setLayout(panelModDescriptionLayout);
        panelModDescriptionLayout.setHorizontalGroup(
            panelModDescriptionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 221, Short.MAX_VALUE)
        );
        panelModDescriptionLayout.setVerticalGroup(
            panelModDescriptionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 269, Short.MAX_VALUE)
        );

        labelVisitWebsite.setFont(new java.awt.Font("Tahoma", 1, 12));
        labelVisitWebsite.setForeground(new java.awt.Color(51, 102, 255));
        labelVisitWebsite.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelVisitWebsite.setText(L10n.getString("label.visitwebsite"));
        labelVisitWebsite.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        labelVisitWebsite.setName("labelVisitWebsite"); // NOI18N

        labelModStatus.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelModStatus.setText("mod status");
        labelModStatus.setName("labelModStatus"); // NOI18N

        buttonEnableMod.setText(L10n.getString("button.enablemod"));
        buttonEnableMod.setName("buttonEnableMod"); // NOI18N

        javax.swing.GroupLayout panelModDetailsLayout = new javax.swing.GroupLayout(panelModDetails);
        panelModDetails.setLayout(panelModDetailsLayout);
        panelModDetailsLayout.setHorizontalGroup(
            panelModDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelModDetailsLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelModDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelModDetailsLayout.createSequentialGroup()
                        .addGroup(panelModDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(labelVisitWebsite, javax.swing.GroupLayout.DEFAULT_SIZE, 221, Short.MAX_VALUE)
                            .addComponent(labelModStatus, javax.swing.GroupLayout.DEFAULT_SIZE, 221, Short.MAX_VALUE)
                            .addComponent(panelModDescription, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(panelModDetailsLayout.createSequentialGroup()
                                .addComponent(labelModIcon)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(panelModDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(labelModAuthor, javax.swing.GroupLayout.DEFAULT_SIZE, 167, Short.MAX_VALUE)
                                    .addComponent(labelModName, javax.swing.GroupLayout.DEFAULT_SIZE, 167, Short.MAX_VALUE))))
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelModDetailsLayout.createSequentialGroup()
                        .addComponent(buttonEnableMod, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(61, 61, 61))))
        );
        panelModDetailsLayout.setVerticalGroup(
            panelModDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelModDetailsLayout.createSequentialGroup()
                .addGroup(panelModDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(labelModIcon)
                    .addGroup(panelModDetailsLayout.createSequentialGroup()
                        .addComponent(labelModName)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(labelModAuthor)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelModDescription, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(labelVisitWebsite)
                .addGap(2, 2, 2)
                .addComponent(labelModStatus)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(buttonEnableMod)
                .addGap(9, 9, 9))
        );

        mainMenu.setName("mainMenu"); // NOI18N

        menuFile.setMnemonic(L10n.getMnemonic("menu.file"));
        menuFile.setText(L10n.getString("menu.file"));
        menuFile.setName("menuFile"); // NOI18N

        itemApplyMods.setMnemonic(L10n.getMnemonic("menu.file.applymods"));
        itemApplyMods.setText(L10n.getString("menu.file.applymods"));
        itemApplyMods.setName("itemApplyMods"); // NOI18N
        itemApplyMods.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemApplyModsActionPerformed(evt);
            }
        });
        menuFile.add(itemApplyMods);

        itemApplyAndLaunch.setMnemonic(L10n.getMnemonic("menu.file.applyandlaunch"));
        itemApplyAndLaunch.setText(L10n.getString("menu.file.applyandlaunch"));
        itemApplyAndLaunch.setName("itemApplyAndLaunch"); // NOI18N
        menuFile.add(itemApplyAndLaunch);

        itemUnapplyAllMods.setMnemonic(L10n.getMnemonic("menu.file.unapplymods"));
        itemUnapplyAllMods.setText(L10n.getString("menu.file.unapplymods"));
        itemUnapplyAllMods.setName("itemUnapplyAllMods"); // NOI18N
        menuFile.add(itemUnapplyAllMods);

        itemOpenModFolder.setMnemonic(L10n.getMnemonic("menu.file.openfolder"));
        itemOpenModFolder.setText(L10n.getString("menu.file.openfolder"));
        itemOpenModFolder.setName("itemOpenModFolder"); // NOI18N
        menuFile.add(itemOpenModFolder);

        jSeparator1.setName("jSeparator1"); // NOI18N
        menuFile.add(jSeparator1);

        itemExit.setMnemonic(L10n.getMnemonic("menu.file.exit"));
        itemExit.setText(L10n.getString("menu.file.exit"));
        itemExit.setName("itemExit"); // NOI18N
        menuFile.add(itemExit);

        mainMenu.add(menuFile);

        menuOptions.setMnemonic(L10n.getMnemonic("menu.options"));
        menuOptions.setText(L10n.getString("menu.options"));
        menuOptions.setName("menuOptions"); // NOI18N

        itemChangePath.setName("itemChangePath"); // NOI18N
        itemChangePath.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemChangePathActionPerformed(evt);
            }
        });
        menuOptions.add(itemChangePath);

        itemChangePathManually.setName("itemChangePathManually"); // NOI18N
        itemChangePathManually.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemChangePathManuallyActionPerformed(evt);
            }
        });
        menuOptions.add(itemChangePathManually);

        jSeparator3.setName("jSeparator3"); // NOI18N
        menuOptions.add(jSeparator3);

        mainMenu.add(menuOptions);

        menuHelp.setMnemonic(L10n.getMnemonic("menu.help"));
        menuHelp.setText(L10n.getString("menu.help"));
        menuHelp.setName("menuHelp"); // NOI18N

        itemVisitForumThread.setMnemonic(L10n.getMnemonic("menu.help.website"));
        itemVisitForumThread.setText(L10n.getString("menu.help.website"));
        itemVisitForumThread.setName("itemVisitForumThread"); // NOI18N
        menuHelp.add(itemVisitForumThread);

        jSeparator4.setName("jSeparator4"); // NOI18N
        menuHelp.add(jSeparator4);

        itemAbout.setMnemonic(L10n.getMnemonic("menu.help.about"));
        itemAbout.setText(L10n.getString("menu.help.about"));
        itemAbout.setName("itemAbout"); // NOI18N
        itemAbout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemAboutActionPerformed(evt);
            }
        });
        menuHelp.add(itemAbout);

        mainMenu.add(menuHelp);

        setJMenuBar(mainMenu);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(panelModList, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(panelModDetails, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(buttonApplyMods)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(buttonAddMod)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(panelModDetails, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(panelModList, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(buttonApplyMods)
                    .addComponent(buttonAddMod))
                .addContainerGap())
        );

        java.awt.Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
        setBounds((screenSize.width-708)/2, (screenSize.height-523)/2, 708, 523);
    }// </editor-fold>//GEN-END:initComponents

    private void itemApplyModsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemApplyModsActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_itemApplyModsActionPerformed

    private void itemChangePathActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemChangePathActionPerformed
        JFileChooser f = new JFileChooser();
        f.setDialogType(JFileChooser.OPEN_DIALOG);
        f.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        f.setDialogTitle("Select the HoN folder");
        f.showOpenDialog(this);
        try {
            Game.getInstance().setPath(f.getSelectedFile());
            System.out.println(Game.getInstance().getVersion());
        } catch (FileNotFoundException ex) {
            if (ex.getMessage().equalsIgnoreCase("Hon folder doesn't exist")) {
                JOptionPane.showMessageDialog(this, "HoN folder doesn't seem to exist.\nPlease, be sure to set a valid folder path.", "HoN folder error", JOptionPane.ERROR_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(this, "HoN launcher couldn't be found.\nPlease, be sure to set a valid folder path.", "HoN launcher error", JOptionPane.ERROR_MESSAGE);
            }
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(this, "For some reason, the HoN launcher couldn't be open.", "Random I/O Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_itemChangePathActionPerformed

    private void itemChangePathManuallyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemChangePathManuallyActionPerformed
        try {
            Game.getInstance().setPath(new File(JOptionPane.showInputDialog(null, "Enter the full path to the game", "Enter", JOptionPane.QUESTION_MESSAGE)));
        } catch (FileNotFoundException ex) {
            if (ex.getMessage().equalsIgnoreCase("Hon folder doesn't exist")) {
                JOptionPane.showMessageDialog(this, "HoN folder doesn't seem to exist.\nPlease, be sure to set a valid folder path.", "HoN folder error", JOptionPane.ERROR_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(this, "HoN launcher couldn't be found.\nPlease, be sure to set a valid folder path.", "HoN launcher error", JOptionPane.ERROR_MESSAGE);
            }
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(this, "For some reason, the HoN launcher couldn't be open.", "Random I/O Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_itemChangePathManuallyActionPerformed

    private void itemAboutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemAboutActionPerformed
        ManagerAboutBox about = new ManagerAboutBox(this);
        about.setLocation(this.getX() + 20, this.getY() + 20);
        about.setVisible(true);
    }//GEN-LAST:event_itemAboutActionPerformed

    private void formComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_formComponentShown
        // TODO add your handling code here:)
        this.setResizable(true);
    }//GEN-LAST:event_formComponentShown

    /**
     * Display specified message to the user using JOptionPane
     * @param message message to be displayed
     * @param title title of the message dialog
     * @param type type of the mesage, see JOptionPane for list of types
     */
    public void showMessage(String message, String title, int type) {
        JOptionPane.showMessageDialog(this, message, title, type);
    }

    /**
     * Custom table model of the mod list table
     */
    private class ModTableModel extends DefaultTableModel {
        Class[] types = new Class [] {
            java.lang.Boolean.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
        };

        boolean[] canEdit = new boolean [] {
                true, false, false, false, false
        };

        public ModTableModel(Object[][] data, Object[] columnNames) {
            super(data, columnNames);
        }

        @Override
        public Class<?> getColumnClass(int columnIndex) {
            if (getRowCount() > 0 && getValueAt(0, columnIndex) != null) {
                return getValueAt(0, columnIndex).getClass();
            }
            return super.getColumnClass(columnIndex);
        }

        @Override
        public boolean isCellEditable(int rowIndex, int columnIndex) {
            return canEdit [columnIndex];
        }
    }

    /**
     * Update table with the list of mods
     *
     * @param mods list of mods to display
     */
    private void updateModTable(ArrayList<Mod> mods) {
        // Save current selected row
        int selectedRow = tableModList.getSelectedRow();
        if (selectedRow == -1) selectedRow = 0;
        this.tableData = new Object[mods.size()][];
        // Display all mods
        for (int i=0;i<mods.size();i++) {
            this.tableData[i] = new Object[5];
            this.tableData[i][0] = (Boolean)mods.get(i).isEnabled();
            this.tableData[i][1] = (String)mods.get(i).getName();
            this.tableData[i][2] = (String)mods.get(i).getAuthor();
            this.tableData[i][3] = (String)mods.get(i).getVersion();
            if (mods.get(i).isEnabled()) {
                this.tableData[i][4] = (String)L10n.getString("table.modstatus.enabled");
            } else {
                this.tableData[i][4] = (String)L10n.getString("table.modstatus.disabled");
            }
        }
        // Update table model
        DefaultTableModel dtm = (DefaultTableModel)tableModList.getModel();
        dtm.setDataVector(this.tableData, this.columnNames);
        // Restore selected row
        tableModList.getSelectionModel().setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        tableModList.getSelectionModel().setSelectionInterval(0, selectedRow);
        // Display details of selected mod
        displayModDetail();
    }

    /**
     * Display details of the selected mod in the right panel
     */
    public void displayModDetail() {
        // Make sure that items in the panel are visible
        setDetailsVisible(true);
        Mod mod = null;
        int selectedRow = tableModList.getSelectedRow();
        try {
            mod = model.getMod(selectedRow);
        } catch (IndexOutOfBoundsException e) {
            logger.error("Cannot display mod at index "+selectedRow);
            //e.printStackTrace();
            return;
        }
        labelModName.setText(mod.getName());
        labelModAuthor.setText(mod.getAuthor());
        areaModDesc.setText(mod.getDescription());
        labelVisitWebsite.setToolTipText(mod.getWebLink());
        labelModIcon.setIcon(mod.getIcon());
        buttonEnableMod.setActionCommand(mod.getName());
        if (mod.isEnabled()) {
            buttonEnableMod.setText(L10n.getString("button.disablemod"));
            labelModStatus.setText(L10n.getString("label.modstatus.enabled"));
        } else {
            buttonEnableMod.setText(L10n.getString("button.enablemod"));
            labelModStatus.setText(L10n.getString("label.modstatus.disabled"));
        }
    }

    /**
     *  Method used for updating the view (called when the model has changed and
     * notifyObservers() was called)
     */
    public void update(Observable obs, Object obj) {
        logger.info("List of mods has changed, updating...");
        updateModTable(model.getMods());
    }

    /**
     * Change visibility of components on the mod details panel
     * @param visible true to make them visible, false to make them invisible
     */
    private void setDetailsVisible(boolean visible) {
        labelModIcon.setVisible(visible);
        labelModName.setVisible(visible);
        labelModAuthor.setVisible(visible);
        areaModDesc.setVisible(visible);
        labelVisitWebsite.setVisible(visible);
        labelModStatus.setVisible(visible);
        buttonEnableMod.setVisible(visible);
    }

    /*
     * The following methods add listeners to the UI components
     */
    public void buttonAddModAddActionListener(ActionListener al) {
        buttonAddMod.addActionListener(al);
    }

    public void buttonEnableModAddActionListener(ActionListener al) {
        buttonEnableMod.addActionListener(al);
    }

    public void labelVisitWebsiteAddMouseListener(MouseListener ml) {
        labelVisitWebsite.addMouseListener(ml);
    }

    public void tableRemoveListSelectionListener(ListSelectionListener sl) {
        tableModList.getSelectionModel().removeListSelectionListener(sl);
        tableModList.getColumnModel().getSelectionModel().removeListSelectionListener(sl);
    }

    public void tableAddListSelectionListener(ListSelectionListener sl) {
        tableModList.getSelectionModel().addListSelectionListener(sl);
        tableModList.getColumnModel().getSelectionModel().addListSelectionListener(sl);
    }

    public void tableAddModelListener(TableModelListener tml) {
        tableModList.getModel().addTableModelListener(tml);
    }

    public void itemApplyModsAddActionListener(ActionListener al) {
        itemApplyMods.addActionListener(al);
        buttonApplyMods.addActionListener(al);
    }

    public void itemApplyAndLaunchAddActionListener(ActionListener al) {
        itemApplyAndLaunch.addActionListener(al);
    }

    public void itemUnapplyAllModsAddActionListener(ActionListener al) {
        itemUnapplyAllMods.addActionListener(al);
    }

    public void itemOpenModFolderAddActionListener(ActionListener al) {
        itemOpenModFolder.addActionListener(al);
    }

    public void itemVisitForumThreadAddActionListener(ActionListener al) {
        itemVisitForumThread.addActionListener(al);
    }

    public void itemExitAddActionListener(ActionListener al) {
        itemExit.addActionListener(al);
    }

    public JTable getModListTable() {
        return this.tableModList;
    }

    public int getSelectedMod() {
        return tableModList.getSelectedRow();
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextArea areaModDesc;
    private javax.swing.JButton buttonAddMod;
    private javax.swing.JButton buttonApplyMods;
    private javax.swing.JButton buttonEnableMod;
    private javax.swing.JMenuItem itemAbout;
    private javax.swing.JMenuItem itemApplyAndLaunch;
    private javax.swing.JMenuItem itemApplyMods;
    private javax.swing.JMenuItem itemChangePath;
    private javax.swing.JMenuItem itemChangePathManually;
    private javax.swing.JMenuItem itemExit;
    private javax.swing.JMenuItem itemOpenModFolder;
    private javax.swing.JMenuItem itemUnapplyAllMods;
    private javax.swing.JMenuItem itemVisitForumThread;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JPopupMenu.Separator jSeparator3;
    private javax.swing.JPopupMenu.Separator jSeparator4;
    private javax.swing.JLabel labelModAuthor;
    private javax.swing.JLabel labelModIcon;
    private javax.swing.JLabel labelModName;
    private javax.swing.JLabel labelModStatus;
    private javax.swing.JLabel labelVisitWebsite;
    private javax.swing.JMenuBar mainMenu;
    private javax.swing.JMenu menuFile;
    private javax.swing.JMenu menuHelp;
    private javax.swing.JMenu menuOptions;
    private javax.swing.JPanel panelModDescription;
    private javax.swing.JPanel panelModDetails;
    private javax.swing.JPanel panelModList;
    private javax.swing.JTable tableModList;
    // End of variables declaration//GEN-END:variables
}