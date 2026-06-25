package pizzaria.view;

import pizzaria.model.Flavour;
import pizzaria.model.PizzaType;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import pizzaria.Pizzaria;

/**
 * @author eduardo
 * @author Vinicius Dias
 */
public class SignupFlavour extends javax.swing.JPanel {

    private ArrayList<Flavour> flavourList;
    private int flavourIndex;
    private javax.swing.JPanel lastScreen;
    private Pizzaria sistema;

    public SignupFlavour(ArrayList<Flavour> flavourList, int flavourIndex, javax.swing.JPanel lastScreen, Pizzaria sistema) {
        initComponents();
        this.flavourList = flavourList;
        this.flavourIndex = flavourIndex;
        this.lastScreen = lastScreen;
        this.sistema = sistema;

        // Preenche o ComboBox com os tipos disponíveis
        jComboBox1.removeAllItems();
        for (PizzaType type : PizzaType.values()) {
            jComboBox1.addItem(type.name());
        }

        // Se for edição, preenche os campos
        if (this.flavourIndex != -1) {
            Flavour f = this.flavourList.get(flavourIndex);
            jTextField1.setText(f.getName());
            jComboBox1.setSelectedItem(f.getType().name());
            jLabel4.setText("Edição de Sabor");
            jButton3.setText("Atualizar");
        }
    }

    @SuppressWarnings("unchecked")
    private void initComponents() {

        jTextField1 = new javax.swing.JTextField();
        jLabel1     = new javax.swing.JLabel();
        jLabel2     = new javax.swing.JLabel();
        jComboBox1  = new javax.swing.JComboBox<>();
        jButton1    = new javax.swing.JButton();
        jButton3    = new javax.swing.JButton();
        jLabel4     = new javax.swing.JLabel();
        jButton2    = new javax.swing.JButton();

        setPreferredSize(new java.awt.Dimension(715, 380));

        jTextField1.setToolTipText("Ex: Calabresa, Frango, Quatro Queijos...");

        jLabel1.setText("Nome do Sabor");
        jLabel2.setText("Tipo da Pizza");

        jComboBox1.setToolTipText("Selecione o tipo da pizza");

        jButton1.setBackground(new java.awt.Color(204, 204, 204));
        jButton1.setText("Cancelar");
        jButton1.addActionListener(this::jButton1ActionPerformed);

        jButton3.setBackground(new java.awt.Color(51, 255, 51));
        jButton3.setText("Salvar");
        jButton3.addActionListener(this::jButton3ActionPerformed);

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 18));
        jLabel4.setText("Cadastro de Sabor");

        jButton2.setText("Ver Sabores");
        jButton2.addActionListener(this::jButton2ActionPerformed);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(276, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jLabel1)
                        .addComponent(jTextField1, javax.swing.GroupLayout.DEFAULT_SIZE, 180, Short.MAX_VALUE)
                        .addComponent(jLabel2)
                        .addComponent(jComboBox1, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton1)
                        .addGap(18, 18, 18)
                        .addComponent(jButton3)))
                .addGap(273, 273, 273))
            .addGroup(layout.createSequentialGroup()
                .addGap(51, 51, 51)
                .addComponent(jButton2)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jButton2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4)
                .addGap(18, 18, 18)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton3)
                    .addComponent(jButton1))
                .addContainerGap(89, Short.MAX_VALUE))
        );
    }

    // Cancelar: volta para tela anterior ou limpa os campos
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {
        if (this.lastScreen != null) {
            javax.swing.JFrame mainScreen = (javax.swing.JFrame) javax.swing.SwingUtilities.getWindowAncestor(this);
            mainScreen.setContentPane(this.lastScreen);
            mainScreen.revalidate();
           mainScreen.repaint();
        } else {
            jTextField1.setText("");
            jComboBox1.setSelectedIndex(0);
        }
    }

    // Salvar / Atualizar sabor
    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {
        String name = jTextField1.getText().trim();

        if (name.isEmpty()) {
            JOptionPane.showMessageDialog(this,
                "Por favor, informe o nome do sabor.", "Erro", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Verifica nome duplicado (ignora o próprio em caso de edição)
        for (int i = 0; i < flavourList.size(); i++) {
            if (i != flavourIndex && flavourList.get(i).getName().equalsIgnoreCase(name)) {
                JOptionPane.showMessageDialog(this,
                    "Já existe um sabor com esse nome. Escolha outro nome.", "Erro", JOptionPane.ERROR_MESSAGE);
                return;
            }
        }

        PizzaType selectedType = PizzaType.valueOf((String) jComboBox1.getSelectedItem());

        if (this.flavourIndex == -1) {
            // Novo cadastro
            this.flavourList.add(new Flavour(selectedType, name));
            JOptionPane.showMessageDialog(this, "Sabor \"" + name + "\" cadastrado com sucesso!");
            jTextField1.setText("");
            jComboBox1.setSelectedIndex(0);
        } else {
            // Edição
            Flavour f = this.flavourList.get(flavourIndex);
            f.setName(name);
            f.setType(selectedType);
            JOptionPane.showMessageDialog(this, "Sabor \"" + name + "\" atualizado com sucesso!");
            flavourListScreen();
        }

        System.out.println("Total de sabores: " + flavourList.size());
    }
    
    // Ver Sabores: navega para a listagem
    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {
        flavourListScreen();
    }

    private void flavourListScreen() {
        ListFlavours tela = new ListFlavours(this.sistema, this);
        javax.swing.JFrame mainScreen = (javax.swing.JFrame) javax.swing.SwingUtilities.getWindowAncestor(this);
        mainScreen.setContentPane(tela);
        mainScreen.revalidate();
        mainScreen.repaint();
    }

    // Variables declaration
    private javax.swing.JButton jButton1, jButton2, jButton3;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1, jLabel2, jLabel4;
    private javax.swing.JTextField jTextField1;
}