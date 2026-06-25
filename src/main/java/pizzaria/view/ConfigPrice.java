package pizzaria.view;

import javax.swing.JOptionPane;
import pizzaria.Pizzaria;
import pizzaria.model.PizzaType;

public class ConfigPrice extends javax.swing.JPanel {

    private Pizzaria sistema;
    private javax.swing.JPanel lastScreen;

    public ConfigPrice(Pizzaria sistema, javax.swing.JPanel lastScreen) {
        this.sistema = sistema;
        this.lastScreen = lastScreen;
        initComponents();
        carregarPrecoAtual();
    }

    private void initComponents() {
        jLabelTitle = new javax.swing.JLabel("Gerenciar Preços por cm²");
        jLabelType = new javax.swing.JLabel("Tipo de Pizza:");
        jComboBoxType = new javax.swing.JComboBox<>(PizzaType.values());
        jLabelPrice = new javax.swing.JLabel("Preço por cm²:");
        jTextFieldPrice = new javax.swing.JTextField(10);
        jButtonSalvar = new javax.swing.JButton("Salvar Alteração");
        jButtonVoltar = new javax.swing.JButton("Voltar");


        jComboBoxType.addActionListener(evt -> carregarPrecoAtual());

        jButtonSalvar.addActionListener(evt -> {
            try {
                PizzaType tipoSelecionado = (PizzaType) jComboBoxType.getSelectedItem();
                double novoPreco = Double.parseDouble(jTextFieldPrice.getText().replace(",", "."));
                
                if (novoPreco < 0) {
                    JOptionPane.showMessageDialog(this, "O preço não pode ser negativo.", "Erro", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                sistema.getPriceTable().updatePrice(tipoSelecionado, novoPreco);
                JOptionPane.showMessageDialog(this, "Preço do tipo " + tipoSelecionado + " atualizado com sucesso!");
                
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(this, "Insira um valor numérico válido.", "Erro", JOptionPane.ERROR_MESSAGE);
            }
        });

        jButtonVoltar.addActionListener(evt -> {
            if (lastScreen != null) {
                javax.swing.JFrame mainScreen = (javax.swing.JFrame) javax.swing.SwingUtilities.getWindowAncestor(this);
                mainScreen.setContentPane(lastScreen);
                mainScreen.revalidate();
                mainScreen.repaint();
            }
        });

        // Layout
        add(jLabelTitle);
        add(jLabelType);
        add(jComboBoxType);
        add(jLabelPrice);
        add(jTextFieldPrice);
        add(jButtonSalvar);
        add(jButtonVoltar);
    }


    private void carregarPrecoAtual() {
        PizzaType tipoSelecionado = (PizzaType) jComboBoxType.getSelectedItem();
        double precoAtual = 0;
        if (tipoSelecionado != null) {
            switch (tipoSelecionado) {
                case Simple -> precoAtual = sistema.getPriceTable().getSimplePriceBase();
                case Special -> precoAtual = sistema.getPriceTable().getSpecialPriceBase();
                case Premium -> precoAtual = sistema.getPriceTable().getPremiumPriceBase();
            }
            jTextFieldPrice.setText(String.format("%.2f", precoAtual));
        }
    }
    private javax.swing.JButton jButtonSalvar;
    private javax.swing.JButton jButtonVoltar;
    private javax.swing.JComboBox<PizzaType> jComboBoxType;
    private javax.swing.JLabel jLabelPrice;
    private javax.swing.JLabel jLabelTitle;
    private javax.swing.JLabel jLabelType;
    private javax.swing.JTextField jTextFieldPrice;
}