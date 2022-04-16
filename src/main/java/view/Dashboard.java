package view;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.MatteBorder;
import java.awt.*;
import java.awt.event.ActionListener;

public class Dashboard extends JFrame {

    private JPanel contentPane;
    private JTextField primulPolinom;
    private JTextField alDoileaPolinom;
    private JTextField rezultat;
    private JButton butonAdunare;
    private JButton butonScadere;
    private JButton butonImpartire;
    private JButton butonInmultire;
    private JButton butonDerivare;
    private JButton butonIntegrare;
    private JButton butonExit;
    private JButton butonClear;
    private JButton butonHelp;


    public Dashboard() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 570, 230);
        contentPane = new JPanel();
        contentPane.setBackground(new Color(204, 255, 204));
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

        JPanel panel = new JPanel();
        panel.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
        panel.setBackground(new Color(255, 204, 153));
        panel.setPreferredSize(new Dimension(200, 160));
        panel.setAlignmentX(Component.LEFT_ALIGNMENT);
        contentPane.add(panel);
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        JLabel lblNewLabel = new JLabel("Calculator de polinoame");
        lblNewLabel.setBackground(new Color(255, 204, 153));
        lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
        lblNewLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        lblNewLabel.setMaximumSize(new Dimension(200, 60));
        lblNewLabel.setPreferredSize(new Dimension(200, 55));
        lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
        panel.add(lblNewLabel);

        JLabel lblNewLabel_1 = new JLabel("Primul polinom");
        lblNewLabel_1.setPreferredSize(new Dimension(67, 25));
        lblNewLabel_1.setAlignmentX(Component.CENTER_ALIGNMENT);
        lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
        panel.add(lblNewLabel_1);

        primulPolinom = new JTextField();
        primulPolinom.setFont(new Font("Tahoma", Font.PLAIN, 12));
        primulPolinom.setPreferredSize(new Dimension(7, 25));
        panel.add(primulPolinom);
        primulPolinom.setColumns(10);

        JLabel lblNewLabel_2 = new JLabel("Al doilea polinom");
        lblNewLabel_2.setPreferredSize(new Dimension(77, 25));
        lblNewLabel_2.setAlignmentX(Component.CENTER_ALIGNMENT);
        panel.add(lblNewLabel_2);

        alDoileaPolinom = new JTextField();
        alDoileaPolinom.setFont(new Font("Tahoma", Font.PLAIN, 12));
        alDoileaPolinom.setPreferredSize(new Dimension(7, 25));
        panel.add(alDoileaPolinom);
        alDoileaPolinom.setColumns(10);

        JLabel lblNewLabel_3 = new JLabel("Rezultat:");
        lblNewLabel_3.setPreferredSize(new Dimension(38, 25));
        lblNewLabel_3.setAlignmentX(Component.CENTER_ALIGNMENT);
        panel.add(lblNewLabel_3);

        rezultat = new JTextField();
        rezultat.setBackground(new Color(255, 204, 153));
        rezultat.setFont(new Font("Tahoma", Font.PLAIN, 12));
        rezultat.setPreferredSize(new Dimension(7, 20));
        rezultat.setBorder(null);
        rezultat.setEditable(false);
        panel.add(rezultat);
        rezultat.setColumns(10);

        JPanel panel_1 = new JPanel();
        panel_1.setBorder(new LineBorder(new Color(0, 0, 0)));
        panel_1.setBackground(new Color(255, 255, 204));
        panel_1.setPreferredSize(new Dimension(300, 160));
        contentPane.add(panel_1);
        panel_1.setLayout(new BoxLayout(panel_1, BoxLayout.Y_AXIS));

        JLabel lblNewLabel_4 = new JLabel("Operatii");
        lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 15));
        lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel_4.setAlignmentX(Component.CENTER_ALIGNMENT);
        lblNewLabel_4.setMaximumSize(new Dimension(90, 90));
        lblNewLabel_4.setPreferredSize(new Dimension(90, 30));
        panel_1.add(lblNewLabel_4);

        JPanel panel_2 = new JPanel();
        panel_2.setBorder(null);
        panel_2.setPreferredSize(new Dimension(300, 100));
        panel_1.add(panel_2);
        panel_2.setLayout(new GridLayout(3, 3, 0, 0));

        butonAdunare = new JButton("Adunare");
        butonAdunare.setBackground(new Color(153, 204, 255));
        butonAdunare.setForeground(Color.BLACK);
        panel_2.add(butonAdunare);

        butonScadere = new JButton("Scadere");
        butonScadere.setBackground(new Color(153, 204, 255));
        panel_2.add(butonScadere);

        butonInmultire = new JButton("Inmultire");
        butonInmultire.setBackground(new Color(153, 204, 255));
        panel_2.add(butonInmultire);

        butonImpartire = new JButton("Impartire");
        butonImpartire.setBackground(new Color(0, 153, 255));
        panel_2.add(butonImpartire);

        butonIntegrare = new JButton("Integrare");
        butonIntegrare.setBackground(new Color(0, 153, 255));
        panel_2.add(butonIntegrare);

        butonDerivare = new JButton("Derivare");
        butonDerivare.setBackground(new Color(0, 153, 255));
        panel_2.add(butonDerivare);

        butonHelp = new JButton("Help");
        butonHelp.setBackground(new Color(102, 153, 204));
        panel_2.add(butonHelp);

        butonClear = new JButton("CLR");
        butonClear.setBackground(new Color(102, 153, 204));
        panel_2.add(butonClear);

        butonExit = new JButton("EXIT");
        butonExit.setBackground(new Color(102, 153, 204));
        panel_2.add(butonExit);
    }

    public void adunareListener(ActionListener actionListener){
        this.butonAdunare.addActionListener(actionListener);
    }

    public void scadereListener(ActionListener actionListener){
        this.butonScadere.addActionListener(actionListener);
    }

    public void inmultireListener(ActionListener actionListener){
        this.butonInmultire.addActionListener(actionListener);
    }

    public void impartireListener(ActionListener actionListener){
        this.butonImpartire.addActionListener(actionListener);
    }

    public void derivareListener(ActionListener actionListener){
        this.butonDerivare.addActionListener(actionListener);
    }

    public void integrareListener(ActionListener actionListener){
        this.butonIntegrare.addActionListener(actionListener);
    }

    public void clearListener(ActionListener actionListener){
        this.butonClear.addActionListener(actionListener);
    }

    public void exitListener(ActionListener actionListener){
        this.butonExit.addActionListener(actionListener);
    }

    public void helpListener(ActionListener actionListener){
        this.butonHelp.addActionListener(actionListener);
    }

    public String getPrimulPolinom() {
        return primulPolinom.getText();
    }

    public void setPrimulPolinom(String s) {
        this.primulPolinom.setText(s);
    }

    public void setAlDoileaPolinom(String s) {
        this.alDoileaPolinom.setText(s);
    }

    public String getAlDoileaPolinom() {
        return alDoileaPolinom.getText();
    }

    public void setRezultat(String rezultat) {
        this.rezultat.setText(rezultat);
    }

    public void showError(String errorMessage){
        JOptionPane.showMessageDialog(this, errorMessage);
    }

    public void showInstructions(String message){
        JOptionPane.showMessageDialog(this, message);
    }

    public void closeWindow(){
        super.dispose();
    }
}
