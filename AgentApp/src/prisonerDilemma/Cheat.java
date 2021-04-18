package prisonerDilemma;

public class Cheat extends DecisionStrategy{

    public Cheat(Prisoner p) {
        super(p);
    }

    public boolean cooperate() {
        return false;
    }
}
