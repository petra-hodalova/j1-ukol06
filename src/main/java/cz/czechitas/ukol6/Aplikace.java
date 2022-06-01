package cz.czechitas.ukol6;


import com.formdev.flatlaf.FlatLightLaf;
import net.miginfocom.swing.MigLayout;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class Aplikace extends JFrame {
    private JLabel husyLabel;
    private JLabel kraliciLabel;
    private JLabel pocetHlavLabel;
    private JLabel pocetNohouLabel;

    private JSpinner husySpinner;
    private JSpinner kraliciSpinner;

    private SpinnerNumberModel husySpinnerModel;
    private SpinnerNumberModel kraliciSpinnerModel;

    private JTextField pocetHlavField;
    private JTextField pocetNohouField;

    private JButton vypocitatButton;


    public static void main(String[] args) {
        FlatLightLaf.setup();
        new Aplikace().start();
    }

    public Aplikace() throws HeadlessException {
        super("Farmářka 1.0");
        this.init();
    }

    public void start() {
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void init() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setIconImage(new ImageIcon(Aplikace.class.getResource("czechitas-icon.png")).getImage());
        setLayout(new MigLayout("wrap 2", "[right]rel[50:120:150,grow,fill]"));
        setMinimumSize(new Dimension(250, 200));

        husySpinnerModel = new SpinnerNumberModel(0,0,null,1);
        husySpinner=new JSpinner(husySpinnerModel);
        husyLabel=new JLabel("Husy");
        husyLabel.setDisplayedMnemonic('H');
        husyLabel.setLabelFor(husySpinner);
        add(husyLabel);
        add(husySpinner);

        kraliciSpinnerModel = new SpinnerNumberModel(0,0,null,1);
        kraliciSpinner=new JSpinner(kraliciSpinnerModel);
        kraliciLabel=new JLabel("Králíci");
        kraliciLabel.setDisplayedMnemonic('K');
        kraliciLabel.setLabelFor(kraliciSpinner);
        add(kraliciLabel);
        add(kraliciSpinner);

        vypocitatButton=new JButton("Vypočítat");
        vypocitatButton.setMnemonic('V');
        add(vypocitatButton,"center, span");

        pocetHlavField=new JTextField();
        pocetHlavField.setHorizontalAlignment(JTextField.TRAILING);
        pocetHlavField.setEnabled(false);
        pocetHlavLabel=new JLabel("Počet hlav");
        pocetHlavLabel.setLabelFor(pocetHlavField);
        add(pocetHlavLabel);
        add(pocetHlavField);

        pocetNohouField=new JTextField();
        pocetNohouField.setHorizontalAlignment(JTextField.TRAILING);
        pocetNohouField.setEnabled(false);
        pocetNohouLabel=new JLabel("Počet nohou");
        pocetNohouLabel.setLabelFor(pocetNohouField);
        add(pocetNohouLabel);
        add(pocetNohouField);

        vypocitatButton.addActionListener(this::handleVypocitat);

        pack();
    }

    private void handleVypocitat(ActionEvent actionEvent) {
        int husy=(Integer) husySpinner.getValue();
        int kralici=(Integer) kraliciSpinner.getValue();

        pocetHlavField.setText(Integer.toString(husy+kralici));
        pocetNohouField.setText(Integer.toString(2*husy+4*kralici));
    }

}
