package prisonerDilemma;

public class TitForTat extends DecisionStrategy{

    public TitForTat(Prisoner p) {
        super(p);
    }

    public boolean cooperate() {
        return myPrisoner.didPartnerCheat();
    }
}
