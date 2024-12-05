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
    private DefaultTableModel tableModel = new DefaultTableModel(new String[]{"Id","Nom", "Prenom", "Email", "Salaire", "Phone", "Role", "Poste"}, 0){
        @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
    };
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
        this.CacherColumn(5);
        this.CacherColumn(6);
        this.CacherColumn(7);
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
    public static void AfficherFail(String message){
        JOptionPane.showMessageDialog(null, message);
    }
    public static void SupprimerSuccess(){
        JOptionPane.showMessageDialog(null, "L'employé a bien éte supprimé.");
    }
    public static void SupprimerFail(String message){
        JOptionPane.showMessageDialog(null, message);
    }
    public static void ModifierSuccess(){
        JOptionPane.showMessageDialog(null, "L'employé a bien été modifié.");
    }
    public static void ModifierFail(String message){
        JOptionPane.showMessageDialog(null, message);
    }
    private void CacherColumn(int index){
        Tableau.getColumnModel().getColumn(index).setMinWidth(0);
        Tableau.getColumnModel().getColumn(index).setMaxWidth(0);
        Tableau.getColumnModel().getColumn(index).setWidth(0);
    }
    public static boolean SupprimerConfirmation(){
        int choice = JOptionPane.showOptionDialog(null, "Êtes-vous sûr de supprimer cet employé?", "Confirmation", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, new String[]{"Oui", "Non"}, "Non");
        return choice == JOptionPane.YES_OPTION;
    }

    public static EmployeeView getInstance() {
        return INSTANCE;
    }
}
