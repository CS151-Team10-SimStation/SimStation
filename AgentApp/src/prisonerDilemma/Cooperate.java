package prisonerDilemma;

public class Cooperate extends DecisionStrategy{

    public Cooperate(Prisoner p) {
        super(p);
    }

    public boolean cooperate() {
        return true;
    }
}
