package prisonerDilemma;

import mvc.Utilities;

public class RandomlyCooperate extends DecisionStrategy{

    public RandomlyCooperate(Prisoner p) {
        super(p);
    }

    public boolean cooperate() {
        int chance = Utilities.rng.nextInt(2)+1;
        // 50/50 chance of cooperating or cheating.
        if (chance == 1) return false;
        return true;
    }
}
