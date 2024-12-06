package View;

public class LimitedView extends EmployeeView{
    private static final LimitedView LIMITED_INSTANCE = new LimitedView();
    public LimitedView(){
        super();
        Ajouter.setVisible(false);
        Modifier.setVisible(false);
        Supprimer.setVisible(false);
        CreerCompte.setVisible(false);
        super.CacherColumn(3);
        super.CacherColumn(4);
        super.CacherColumn(5);
        super.CacherColumn(6);
        super.CacherColumn(7);
    }
    public static LimitedView getLimitedInstance() {
        return LIMITED_INSTANCE;
    }
}
