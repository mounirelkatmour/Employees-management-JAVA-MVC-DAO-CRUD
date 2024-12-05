package View;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import Model.Employee;
import Model.Poste;
import Model.Role;
import java.awt.*;
public class EmployeeView extends JFrame {
    private static final EmployeeView INSTANCE = new EmployeeView();
    private JPanel General = new JPanel();
    private JPanel GeneralUp = new JPanel();
    private JPanel GeneralDown = new JPanel();
    private JPanel ListContainer = new JPanel();
    private JPanel ButtonsContainer = new JPanel();
    private DefaultTableModel tableModel = new DefaultTableModel(new String[]{"Id","Nom", "Prenom", "Email", "Salaire"}, 0);
    public JTable Tableau = new JTable(tableModel);
    public JButton Ajouter = new JButton("Ajouter");
    public JButton Modifier = new JButton("Modifier");
    public JButton Supprimer = new JButton("Supprimer");
    public JButton Afficher = new JButton("Afficher");
    public JLabel NomLabel;
    public JTextField Nom;
    public JLabel PrenomLabel;
    public JTextField Prenom;
    public JLabel EmailLabel;
    public JTextField Email;
    public JLabel TelephoneLabel;
    public JTextField Telephone;
    public JLabel SalaireLabel;
    public JTextField Salaire;
    public JLabel RoleLabel;
    public JComboBox<Role> RoleComboBox;
    public JLabel PosteLabel;
    public JComboBox<Poste> PosteComboBox;

    private EmployeeView() {
        setTitle("Gestion des employés");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(930, 520);
        setLocationRelativeTo(null);
        add(General);
        General.setLayout(new BorderLayout());
        General.add(GeneralUp, BorderLayout.NORTH);
        General.add(GeneralDown, BorderLayout.CENTER);
        GeneralUp.setLayout(new GridLayout(7,2));
        GeneralUp.setBorder(BorderFactory.createEmptyBorder(10, 18, 10, 18));
        NomLabel = new JLabel("Nom");
        Nom = new JTextField();
        GeneralUp.add(NomLabel);
        GeneralUp.add(Nom);
        PrenomLabel = new JLabel("Prénom");
        Prenom = new JTextField();
        GeneralUp.add(PrenomLabel);
        GeneralUp.add(Prenom);
        EmailLabel = new JLabel("Email");
        Email = new JTextField();
        GeneralUp.add(EmailLabel);
        GeneralUp.add(Email);
        TelephoneLabel = new JLabel("Téléphone");
        Telephone = new JTextField();
        GeneralUp.add(TelephoneLabel);
        GeneralUp.add(Telephone);
        SalaireLabel = new JLabel("Salaire");
        Salaire = new JTextField();
        GeneralUp.add(SalaireLabel);
        GeneralUp.add(Salaire);
        RoleLabel = new JLabel("Role");
        RoleComboBox = new JComboBox<>(Role.values());
        GeneralUp.add(RoleLabel);
        GeneralUp.add(RoleComboBox);
        PosteLabel = new JLabel("Poste");
        PosteComboBox = new JComboBox<>(Poste.values());
        GeneralUp.add(PosteLabel);
        GeneralUp.add(PosteComboBox);
        GeneralDown.setLayout(new BorderLayout());
        GeneralDown.add(ListContainer, BorderLayout.CENTER);
        ListContainer.setLayout(new FlowLayout());
        Dimension preferredSize = new Dimension(EmployeeView.this.getWidth() - 50,500);
        Tableau.setPreferredScrollableViewportSize(preferredSize);
        Tableau.setFillsViewportHeight(true);
        ListContainer.add(new JScrollPane(Tableau));
        GeneralDown.add(ButtonsContainer, BorderLayout.SOUTH);
        ButtonsContainer.setLayout(new FlowLayout());
        ButtonsContainer.add(Ajouter);
        ButtonsContainer.add(Modifier);
        ButtonsContainer.add(Supprimer);
        ButtonsContainer.add(Afficher);
        setVisible(true);
    }
    public static void AjouterSuccess(Employee employee){
        JOptionPane.showMessageDialog(null, "L'employé " + employee.getNom() + " " + employee.getPrenom() + " a été ajouté avec succès");
    }
    public static void AjouterFail(String message){
        JOptionPane.showMessageDialog(null, "L'employé n'a pas été ajouté. " + message);
    }

    public static EmployeeView getInstance() {
        return INSTANCE;
    }
}
