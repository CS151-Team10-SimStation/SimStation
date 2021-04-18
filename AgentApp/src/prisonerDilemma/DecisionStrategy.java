package prisonerDilemma;

public abstract class DecisionStrategy {
    protected Prisoner myPrisoner;

    public DecisionStrategy(Prisoner p){
        myPrisoner = p;
    }
    public abstract boolean cooperate();
}
