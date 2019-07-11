package app;

import avltree.Node;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import words.Dictionary;
import words.Word;

public class DictionaryApplication extends javax.swing.JFrame implements Runnable {

    private CardLayout cardLayout;
    private Thread lookUpThread;
    private Dictionary dictionary;
    private boolean running = false;
    private DefaultListModel model;
    private DefaultListModel listModel;

    public DictionaryApplication() {

        initComponents();
        initUI();
        initListeners();
        initData();

        cardLayout.show(cardPanel, "welcomeCard");
    }

    private void initUI() {
        setResizable(false);
        setTitle("CatMeow Dictionary");
        setLocationRelativeTo(null);
        cardLayout = (CardLayout) cardPanel.getLayout();

        model = new DefaultListModel();
        txtResult.setModel(model);
        txtResult.updateUI();
    }

    private void initListeners() {
        lookUpBtn.addMouseListener(new HoverListener(lookUpBtn, new Color(33, 34, 40), new Color(59, 59, 91)));
        removeBtn.addMouseListener(new HoverListener(removeBtn, new Color(33, 34, 40), new Color(59, 59, 91)));
        addNewBtn.addMouseListener(new HoverListener(addNewBtn, new Color(33, 34, 40), new Color(59, 59, 91)));
    }

    private void initData() {
        dictionary = new Dictionary("dictionary.txt");
        listModel = new DefaultListModel();
        for (int i = 0; i < dictionary.getNodeList().size(); i++) {
            Node<Word> node = dictionary.getNodeList().get(i);
            String w = node.getObj().getData();
            listModel.addElement(w);
        }
        wordList.setModel(listModel);

        cancelBtn.setEnabled(false);
        removeWordBtn.setEnabled(false);

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        lookUpBtn = new javax.swing.JButton();
        addNewBtn = new javax.swing.JButton();
        removeBtn = new javax.swing.JButton();
        cardPanel = new javax.swing.JPanel();
        lookUpPanel = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        txtLookUp = new javax.swing.JTextField();
        searchBtn = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        jScrollPane3 = new javax.swing.JScrollPane();
        txtResult = new javax.swing.JList<>();
        resultLabel = new javax.swing.JLabel();
        addPanel = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtWord = new javax.swing.JTextField();
        txtMeaning = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtExample = new javax.swing.JTextArea();
        addBtn = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        wordDetailsPanel = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        jLabel10 = new javax.swing.JLabel();
        jSeparator3 = new javax.swing.JSeparator();
        jLabel11 = new javax.swing.JLabel();
        jSeparator4 = new javax.swing.JSeparator();
        txtWordDetail = new javax.swing.JLabel();
        txtMeaningDetail = new javax.swing.JLabel();
        txtExampleDetail = new javax.swing.JLabel();
        goBackBtn = new javax.swing.JButton();
        welcomePanel = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        removeWordPanel = new javax.swing.JPanel();
        jLabel14 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        wordList = new javax.swing.JList<>();
        removeWordBtn = new javax.swing.JButton();
        cancelBtn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jPanel2.setBackground(new java.awt.Color(38, 38, 66));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8_dictionary_100px_1.png"))); // NOI18N
        jLabel1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel1MouseClicked(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Segoe UI Light", 1, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("CatMeow Dictionary");

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8_cat_100px.png"))); // NOI18N

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jPanel3.setBackground(new java.awt.Color(38, 38, 66));
        jPanel3.setLayout(new java.awt.GridLayout(7, 1));

        lookUpBtn.setBackground(new java.awt.Color(59, 59, 91));
        lookUpBtn.setFont(new java.awt.Font("Segoe UI Light", 0, 18)); // NOI18N
        lookUpBtn.setForeground(new java.awt.Color(255, 255, 255));
        lookUpBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8_search_filled_25px.png"))); // NOI18N
        lookUpBtn.setText("Look Up");
        lookUpBtn.setBorder(null);
        lookUpBtn.setBorderPainted(false);
        lookUpBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lookUpBtn.setFocusPainted(false);
        lookUpBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lookUpBtnActionPerformed(evt);
            }
        });
        jPanel3.add(lookUpBtn);

        addNewBtn.setBackground(new java.awt.Color(59, 59, 91));
        addNewBtn.setFont(new java.awt.Font("Segoe UI Light", 0, 18)); // NOI18N
        addNewBtn.setForeground(new java.awt.Color(255, 255, 255));
        addNewBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8_add_25px_1.png"))); // NOI18N
        addNewBtn.setText("Add New Word");
        addNewBtn.setBorder(null);
        addNewBtn.setBorderPainted(false);
        addNewBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        addNewBtn.setFocusPainted(false);
        addNewBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addNewBtnActionPerformed(evt);
            }
        });
        jPanel3.add(addNewBtn);

        removeBtn.setBackground(new java.awt.Color(59, 59, 91));
        removeBtn.setFont(new java.awt.Font("Segoe UI Light", 0, 18)); // NOI18N
        removeBtn.setForeground(new java.awt.Color(255, 255, 255));
        removeBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8_minus_25px.png"))); // NOI18N
        removeBtn.setText("Remove a Word");
        removeBtn.setBorder(null);
        removeBtn.setBorderPainted(false);
        removeBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        removeBtn.setFocusPainted(false);
        removeBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removeBtnActionPerformed(evt);
            }
        });
        jPanel3.add(removeBtn);

        cardPanel.setBackground(new java.awt.Color(49, 49, 51));
        cardPanel.setLayout(new java.awt.CardLayout());

        lookUpPanel.setBackground(new java.awt.Color(49, 49, 51));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("LOOK UP");

        txtLookUp.setFont(new java.awt.Font("Segoe UI Light", 0, 18)); // NOI18N
        txtLookUp.setBorder(null);
        txtLookUp.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtLookUpKeyPressed(evt);
            }
        });

        searchBtn.setBackground(new java.awt.Color(214, 62, 62));
        searchBtn.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        searchBtn.setForeground(new java.awt.Color(255, 255, 255));
        searchBtn.setText("Search");
        searchBtn.setBorder(null);
        searchBtn.setBorderPainted(false);
        searchBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        searchBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchBtnActionPerformed(evt);
            }
        });

        jSeparator1.setForeground(new java.awt.Color(255, 255, 255));

        jScrollPane3.setBorder(null);

        txtResult.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        txtResult.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        txtResult.setToolTipText("Click to show details");
        txtResult.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        txtResult.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtResultMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(txtResult);

        resultLabel.setFont(new java.awt.Font("Segoe UI Light", 0, 18)); // NOI18N
        resultLabel.setForeground(new java.awt.Color(255, 255, 255));
        resultLabel.setText("Possible results: ");

        javax.swing.GroupLayout lookUpPanelLayout = new javax.swing.GroupLayout(lookUpPanel);
        lookUpPanel.setLayout(lookUpPanelLayout);
        lookUpPanelLayout.setHorizontalGroup(
            lookUpPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(lookUpPanelLayout.createSequentialGroup()
                .addGroup(lookUpPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(lookUpPanelLayout.createSequentialGroup()
                        .addGap(38, 38, 38)
                        .addGroup(lookUpPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(lookUpPanelLayout.createSequentialGroup()
                                .addComponent(txtLookUp, javax.swing.GroupLayout.PREFERRED_SIZE, 370, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(searchBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel4))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(lookUpPanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jSeparator1))
                    .addGroup(lookUpPanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(lookUpPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(resultLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 684, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 712, Short.MAX_VALUE))))
                .addContainerGap())
        );
        lookUpPanelLayout.setVerticalGroup(
            lookUpPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(lookUpPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(lookUpPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(searchBtn, javax.swing.GroupLayout.DEFAULT_SIZE, 32, Short.MAX_VALUE)
                    .addComponent(txtLookUp))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 12, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(resultLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 338, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        cardPanel.add(lookUpPanel, "lookUpCard");

        addPanel.setBackground(new java.awt.Color(49, 49, 51));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Word");

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Meaning");

        jLabel7.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Example");

        txtWord.setFont(new java.awt.Font("Segoe UI Light", 0, 18)); // NOI18N
        txtWord.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtWord.setBorder(null);
        txtWord.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtWordFocusLost(evt);
            }
        });

        txtMeaning.setFont(new java.awt.Font("Segoe UI Light", 0, 18)); // NOI18N
        txtMeaning.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtMeaning.setBorder(null);
        txtMeaning.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtMeaningFocusLost(evt);
            }
        });

        txtExample.setColumns(20);
        txtExample.setFont(new java.awt.Font("Segoe UI Light", 0, 18)); // NOI18N
        txtExample.setRows(5);
        txtExample.setBorder(null);
        txtExample.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtExampleFocusLost(evt);
            }
        });
        jScrollPane1.setViewportView(txtExample);

        addBtn.setBackground(new java.awt.Color(232, 74, 74));
        addBtn.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        addBtn.setForeground(new java.awt.Color(255, 255, 255));
        addBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8_plus_math_40px_1.png"))); // NOI18N
        addBtn.setText("Add");
        addBtn.setBorder(null);
        addBtn.setBorderPainted(false);
        addBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        addBtn.setFocusPainted(false);
        addBtn.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);
        addBtn.setIconTextGap(10);
        addBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addBtnActionPerformed(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setText("Adding new Word");

        javax.swing.GroupLayout addPanelLayout = new javax.swing.GroupLayout(addPanel);
        addPanel.setLayout(addPanelLayout);
        addPanelLayout.setHorizontalGroup(
            addPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, addPanelLayout.createSequentialGroup()
                .addContainerGap(243, Short.MAX_VALUE)
                .addGroup(addPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtWord)
                    .addComponent(txtMeaning)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 348, Short.MAX_VALUE)
                    .addComponent(addBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(141, 141, 141))
        );
        addPanelLayout.setVerticalGroup(
            addPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, addPanelLayout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 43, Short.MAX_VALUE)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtWord, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtMeaning, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(addBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        cardPanel.add(addPanel, "addCard");

        wordDetailsPanel.setBackground(new java.awt.Color(255, 255, 255));

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel9.setText("Word");

        jSeparator2.setBackground(new java.awt.Color(221, 64, 64));
        jSeparator2.setForeground(new java.awt.Color(221, 64, 64));

        jLabel10.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel10.setText("Meaning");

        jSeparator3.setBackground(new java.awt.Color(221, 64, 64));
        jSeparator3.setForeground(new java.awt.Color(221, 64, 64));

        jLabel11.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel11.setText("Example");

        jSeparator4.setBackground(new java.awt.Color(221, 64, 64));
        jSeparator4.setForeground(new java.awt.Color(221, 64, 64));

        txtWordDetail.setFont(new java.awt.Font("Segoe UI", 1, 22)); // NOI18N
        txtWordDetail.setForeground(new java.awt.Color(255, 51, 51));
        txtWordDetail.setText("Word text");

        txtMeaningDetail.setFont(new java.awt.Font("Segoe UI", 2, 18)); // NOI18N
        txtMeaningDetail.setText("Meaning text");

        txtExampleDetail.setFont(new java.awt.Font("Segoe UI", 2, 18)); // NOI18N
        txtExampleDetail.setText("Example text");

        goBackBtn.setBackground(new java.awt.Color(211, 212, 237));
        goBackBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8_arrow_pointing_left_40px.png"))); // NOI18N
        goBackBtn.setBorder(null);
        goBackBtn.setBorderPainted(false);
        goBackBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        goBackBtn.setFocusPainted(false);
        goBackBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                goBackBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout wordDetailsPanelLayout = new javax.swing.GroupLayout(wordDetailsPanel);
        wordDetailsPanel.setLayout(wordDetailsPanelLayout);
        wordDetailsPanelLayout.setHorizontalGroup(
            wordDetailsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(wordDetailsPanelLayout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addGroup(wordDetailsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jSeparator2)
                    .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, 564, Short.MAX_VALUE)
                    .addComponent(jSeparator3)
                    .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, 564, Short.MAX_VALUE)
                    .addComponent(jSeparator4)
                    .addComponent(txtWordDetail, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtMeaningDetail, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtExampleDetail, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(127, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, wordDetailsPanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(goBackBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        wordDetailsPanelLayout.setVerticalGroup(
            wordDetailsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(wordDetailsPanelLayout.createSequentialGroup()
                .addComponent(goBackBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(50, 50, 50)
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 3, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtWordDetail, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(23, 23, 23)
                .addComponent(jLabel10)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtMeaningDetail, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addComponent(jLabel11)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtExampleDetail, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(102, Short.MAX_VALUE))
        );

        cardPanel.add(wordDetailsPanel, "wordDetailsCard");

        welcomePanel.setBackground(new java.awt.Color(214, 214, 214));

        jLabel12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8_lol_100px.png"))); // NOI18N

        jLabel13.setFont(new java.awt.Font("Tahoma", 0, 48)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(145, 145, 154));
        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel13.setText("WELCOME !");

        javax.swing.GroupLayout welcomePanelLayout = new javax.swing.GroupLayout(welcomePanel);
        welcomePanel.setLayout(welcomePanelLayout);
        welcomePanelLayout.setHorizontalGroup(
            welcomePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, welcomePanelLayout.createSequentialGroup()
                .addContainerGap(206, Short.MAX_VALUE)
                .addComponent(jLabel13)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(168, 168, 168))
        );
        welcomePanelLayout.setVerticalGroup(
            welcomePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(welcomePanelLayout.createSequentialGroup()
                .addGap(192, 192, 192)
                .addGroup(welcomePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(219, Short.MAX_VALUE))
        );

        cardPanel.add(welcomePanel, "welcomeCard");

        removeWordPanel.setBackground(new java.awt.Color(49, 49, 51));

        jLabel14.setFont(new java.awt.Font("Segoe UI Light", 0, 24)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setText("Word List");

        jScrollPane2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(196, 78, 78)));

        wordList.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        wordList.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                wordListMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(wordList);

        removeWordBtn.setBackground(new java.awt.Color(196, 78, 78));
        removeWordBtn.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        removeWordBtn.setForeground(new java.awt.Color(255, 255, 255));
        removeWordBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8_minus_math_25px.png"))); // NOI18N
        removeWordBtn.setText("Remove");
        removeWordBtn.setBorder(null);
        removeWordBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        removeWordBtn.setFocusPainted(false);
        removeWordBtn.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);
        removeWordBtn.setIconTextGap(5);
        removeWordBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removeWordBtnActionPerformed(evt);
            }
        });

        cancelBtn.setBackground(new java.awt.Color(196, 78, 78));
        cancelBtn.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        cancelBtn.setForeground(new java.awt.Color(255, 255, 255));
        cancelBtn.setText("Cancel");
        cancelBtn.setBorder(null);
        cancelBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        cancelBtn.setFocusPainted(false);
        cancelBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout removeWordPanelLayout = new javax.swing.GroupLayout(removeWordPanel);
        removeWordPanel.setLayout(removeWordPanelLayout);
        removeWordPanelLayout.setHorizontalGroup(
            removeWordPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(removeWordPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(removeWordPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2)
                    .addGroup(removeWordPanelLayout.createSequentialGroup()
                        .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(removeWordPanelLayout.createSequentialGroup()
                        .addComponent(removeWordBtn, javax.swing.GroupLayout.DEFAULT_SIZE, 434, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cancelBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 268, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        removeWordPanelLayout.setVerticalGroup(
            removeWordPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(removeWordPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 371, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(removeWordPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cancelBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(removeWordBtn, javax.swing.GroupLayout.DEFAULT_SIZE, 47, Short.MAX_VALUE))
                .addContainerGap())
        );

        cardPanel.add(removeWordPanel, "removeWordCard");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cardPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(cardPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void lookUpBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lookUpBtnActionPerformed

        running = true;
        lookUpThread = new Thread(this);
        lookUpThread.start();
        cardLayout.show(cardPanel, "lookUpCard");

        txtLookUp.setText("");
    }//GEN-LAST:event_lookUpBtnActionPerformed

    private void addNewBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addNewBtnActionPerformed
        cardLayout.show(cardPanel, "addCard");
        running = false;
    }//GEN-LAST:event_addNewBtnActionPerformed

    private void removeBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_removeBtnActionPerformed
        cardLayout.show(cardPanel, "removeWordCard");
        running = false;
    }//GEN-LAST:event_removeBtnActionPerformed

    private void txtResultMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtResultMouseClicked
        if (model.isEmpty()) {
            return;
        }

        String word = txtResult.getSelectedValue();
        Word w = dictionary.searchWord(new Word(word));
        showWordDetails(w);

    }//GEN-LAST:event_txtResultMouseClicked

    private void showWordDetails(Word w) {
        txtWordDetail.setText(w.getData());
        txtMeaningDetail.setText(w.getMeaning());
        txtExampleDetail.setText(w.getExample());
        running = false;
        cardLayout.show(cardPanel, "wordDetailsCard");
    }

    private void goBackBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_goBackBtnActionPerformed
        running = true;
        lookUpThread = new Thread(this);
        lookUpThread.start();

        cardLayout.show(cardPanel, "lookUpCard");
        txtLookUp.requestFocus();


    }//GEN-LAST:event_goBackBtnActionPerformed

    private void addBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addBtnActionPerformed
        String w = txtWord.getText();
        if (!dictionary.isDuplicated(new Word(w))) {
            String m = txtMeaning.getText();
            String ex = txtExample.getText();
            Word word = new Word(w, m, ex);
            dictionary.addWord(word);
            dictionary.getNodeList().add(new Node<>(word));
            dictionary.saveToFile();
            dictionary = new Dictionary("dictionary.txt");
            listModel.addElement(w);
            JOptionPane.showMessageDialog(this, "Word added successfully!");

            txtWord.setText("");
            txtMeaning.setText("");
            txtExample.setText("");
        }
        else{
            JOptionPane.showMessageDialog(this, "This word has already existed!");
        }
    }//GEN-LAST:event_addBtnActionPerformed

    private void txtWordFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtWordFocusLost
        String txtW = txtWord.getText().trim();
        if (txtW.isEmpty()) {
            return;
        }
        txtWord.setText(capitalize(txtW));
    }//GEN-LAST:event_txtWordFocusLost

    private void txtMeaningFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtMeaningFocusLost
        String txtM = txtMeaning.getText().trim();
        if (txtM.isEmpty()) {
            return;
        }
        txtMeaning.setText(capitalize(txtM));
    }//GEN-LAST:event_txtMeaningFocusLost

    private void txtExampleFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtExampleFocusLost
        String txtEx = txtExample.getText().trim();
        if (txtEx.isEmpty()) {
            return;
        }
        txtExample.setText(capitalize(txtEx));
    }//GEN-LAST:event_txtExampleFocusLost

    private void wordListMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_wordListMouseClicked
        removeWordBtn.setEnabled(true);
        cancelBtn.setEnabled(true);
    }//GEN-LAST:event_wordListMouseClicked

    private void cancelBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelBtnActionPerformed
        cancelBtn.setEnabled(false);
        removeWordBtn.setEnabled(false);
        wordList.clearSelection();
    }//GEN-LAST:event_cancelBtnActionPerformed

    private void removeWordBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_removeWordBtnActionPerformed
        int index = wordList.getSelectedIndex();
        if (index >= 0) {
            if (JOptionPane.showConfirmDialog(this, "Are you sure you want to delete this word?") == JOptionPane.OK_OPTION) {
                dictionary.getNodeList().remove(index);
                dictionary.saveToFile();
                dictionary = new Dictionary("dictionary.txt");
                JOptionPane.showMessageDialog(this, "Word has been removed...");
                listModel.remove(index);
            }

        }
    }//GEN-LAST:event_removeWordBtnActionPerformed

    private void jLabel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseClicked
        cardLayout.show(cardPanel, "welcomeCard");
    }//GEN-LAST:event_jLabel1MouseClicked

    private void searchBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchBtnActionPerformed
        String searchTxt = txtLookUp.getText();

        if (searchTxt.isEmpty()) {
            return;
        }
        Word w = dictionary.searchWord(new Word(searchTxt));
        if (w != null) {
            showWordDetails(w);
        }
    }//GEN-LAST:event_searchBtnActionPerformed

    private void txtLookUpKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtLookUpKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {

            if (model.size() == 1) {
                showWordDetails(dictionary.searchWord(new Word(model.get(0).toString())));
                return;
            }

            String searchTxt = txtLookUp.getText();

            if (searchTxt.isEmpty()) {
                return;
            }
            Word w = dictionary.searchWord(new Word(searchTxt));
            if (w != null) {
                showWordDetails(w);
            }
        }
    }//GEN-LAST:event_txtLookUpKeyPressed

    private String capitalize(String s) {
        String first = s.charAt(0) + "";
        return first.toUpperCase() + s.substring(1, s.length());
    }

    public static void main(String args[]) {

        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DictionaryApplication.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        java.awt.EventQueue.invokeLater(() -> {
            new DictionaryApplication().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addBtn;
    private javax.swing.JButton addNewBtn;
    private javax.swing.JPanel addPanel;
    private javax.swing.JButton cancelBtn;
    private javax.swing.JPanel cardPanel;
    private javax.swing.JButton goBackBtn;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JButton lookUpBtn;
    private javax.swing.JPanel lookUpPanel;
    private javax.swing.JButton removeBtn;
    private javax.swing.JButton removeWordBtn;
    private javax.swing.JPanel removeWordPanel;
    private javax.swing.JLabel resultLabel;
    private javax.swing.JButton searchBtn;
    private javax.swing.JTextArea txtExample;
    private javax.swing.JLabel txtExampleDetail;
    private javax.swing.JTextField txtLookUp;
    private javax.swing.JTextField txtMeaning;
    private javax.swing.JLabel txtMeaningDetail;
    private javax.swing.JList<String> txtResult;
    private javax.swing.JTextField txtWord;
    private javax.swing.JLabel txtWordDetail;
    private javax.swing.JPanel welcomePanel;
    private javax.swing.JPanel wordDetailsPanel;
    private javax.swing.JList<String> wordList;
    // End of variables declaration//GEN-END:variables

    @Override
    public void run() {

        while (running) {
            String searchTxt = this.txtLookUp.getText();
            if (!searchTxt.isEmpty()) {
                ArrayList<String> words = new ArrayList<>();
                words = dictionary.searchWords(this.txtLookUp.getText());

                String temp = searchTxt;
                String temp2 = searchTxt;
                if (words.isEmpty()) {

                    this.resultLabel.setText("Possible results: 0\n");
                    while (temp.equalsIgnoreCase(temp2) && running) {
                        temp2 = this.txtLookUp.getText();
                    }

                    model.clear();
                } else {

                    int count = words.size();

                    this.resultLabel.setText("Possible results: " + count + "\n");

                    for (int i = 0; i < words.size(); i++) {
                        model.addElement(words.get(i));

                    }

                    while (temp.equalsIgnoreCase(temp2) && running) {
                        temp2 = this.txtLookUp.getText();
                    }

                    model.clear();

                }
            } else {
                this.resultLabel.setText("Possible results: 0\n");
                model.clear();
            }
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
            }
        }
        model.clear();

    }
}
