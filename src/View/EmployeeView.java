package View;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import Model.Poste;
import Model.Role;

import java.awt.*;
public class EmployeeView extends JFrame {
    private JPanel General = new JPanel();
    private JPanel GeneralUp = new JPanel();
    private JPanel GeneralDown = new JPanel();
    private JPanel ListContainer = new JPanel();
    private JPanel ButtonsContainer = new JPanel();
    private DefaultTableModel tableModel = new DefaultTableModel(new String[]{"Id","Nom", "Prenom", "Email", "Salaire"}, 0);
    private JTable Tableau = new JTable(tableModel);
    public EmployeeView() {
        setTitle("Gestion des employés");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(530, 320);
        setLocationRelativeTo(null);
        add(General);
        General.setLayout(new BorderLayout());
        General.add(GeneralUp, BorderLayout.NORTH);
        General.add(GeneralDown, BorderLayout.CENTER);
        GeneralUp.setLayout(new GridLayout(7,2));
        GeneralUp.add(new JLabel("Nom"));
        GeneralUp.add(new JTextField());
        GeneralUp.add(new JLabel("Prénom"));
        GeneralUp.add(new JTextField());
        GeneralUp.add(new JLabel("Email"));
        GeneralUp.add(new JTextField());
        GeneralUp.add(new JLabel("Téléphone"));
        GeneralUp.add(new JTextField());
        GeneralUp.add(new JLabel("Salaire"));
        GeneralUp.add(new JTextField());
        GeneralUp.add(new JLabel("Role"));
        JComboBox<Role> RoleComboBox = new JComboBox<>(Role.values());
        GeneralUp.add(RoleComboBox);
        GeneralUp.add(new JLabel("Poste"));
        JComboBox<Poste> PosteComboBox = new JComboBox<>(Poste.values());
        GeneralUp.add(PosteComboBox);
        GeneralDown.setLayout(new BorderLayout());
        GeneralDown.add(ListContainer, BorderLayout.CENTER);
        ListContainer.setLayout(new FlowLayout());
        Tableau.setFillsViewportHeight(true);
        Dimension preferredSize = new Dimension(500, 150);
        Tableau.setPreferredScrollableViewportSize(preferredSize);
        ListContainer.add(new JScrollPane(Tableau));
        GeneralDown.add(ButtonsContainer, BorderLayout.SOUTH);
        ButtonsContainer.setLayout(new FlowLayout());
        ButtonsContainer.add(new JButton("Ajouter"));
        ButtonsContainer.add(new JButton("Modifier"));
        ButtonsContainer.add(new JButton("Supprimer"));
        ButtonsContainer.add(new JButton("Afficher"));
        setVisible(true);
    }
}
