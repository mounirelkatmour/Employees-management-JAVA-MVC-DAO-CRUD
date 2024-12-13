package View;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import Model.Employee;
import Model.HolidayType;
import java.awt.*;

public class HolidayView extends JFrame {
    private static final HolidayView INSTANCE = new HolidayView();
    private JPanel generalPanel = new JPanel();
    private JLabel nomEmployeLabel = new JLabel("Nom de l'employé");
    private JComboBox<Employee> nomEmployeComboBox = new JComboBox<>();
    private JLabel typeLabel = new JLabel("Type");
    private JComboBox<HolidayType> typeComboBox = new JComboBox<>();
    private JLabel dateDebutLabel = new JLabel("Date de début");
    private JTextField dateDebut = new JTextField(10);
    private JLabel dateFinLabel = new JLabel("Date de fin");
    private JTextField dateFin = new JTextField(10);
    private DefaultTableModel tableModel = new DefaultTableModel(new String[]{"Id","Employé","Date début","Date fin","Type"}, 0){
        @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
    };
    protected JTable holidayTable = new JTable(tableModel);
    private JScrollPane tableScrollPane = new JScrollPane(holidayTable);
    private JButton ajouterButton = new JButton("Ajouter");
    private JButton modifierButton = new JButton("Modifier");
    private JButton supprimerButton = new JButton("Supprimer");
    private JPanel inputPanel = new JPanel();
    private JPanel buttonPanel = new JPanel();

    public HolidayView() {
        setTitle("Gestion des holidays");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(930, 520);
        setLocationRelativeTo(null);
        setVisible(true);
        generalPanel.setLayout(new BorderLayout());
        inputPanel.setLayout(new GridLayout(5, 2, 10, 10));
        inputPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 0, 10));
        inputPanel.add(nomEmployeLabel);
        inputPanel.add(nomEmployeComboBox);
        inputPanel.add(typeLabel);
        inputPanel.add(typeComboBox);
        inputPanel.add(dateDebutLabel);
        inputPanel.add(dateDebut);
        inputPanel.add(dateFinLabel);
        inputPanel.add(dateFin);
        generalPanel.add(inputPanel, BorderLayout.NORTH);
        tableScrollPane.setBorder(BorderFactory.createEmptyBorder(0, 10, 0, 10));
        generalPanel.add(tableScrollPane, BorderLayout.CENTER);
        buttonPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 20, 10));
        buttonPanel.add(ajouterButton);
        buttonPanel.add(modifierButton);
        buttonPanel.add(supprimerButton);
        generalPanel.add(buttonPanel, BorderLayout.SOUTH);
        add(generalPanel);
        holidayTable.setFillsViewportHeight(true);
        holidayTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
    }

    public static HolidayView getInstance() {
        return INSTANCE;
    }

}
