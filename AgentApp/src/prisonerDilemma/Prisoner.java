package prisonerDilemma;

import simstation.Agent;

public class Prisoner extends Agent {
    private int fitness = 0;
    private boolean partnerCheated = false;
    protected DecisionStrategy strategy;
    public boolean cooperate() { return strategy.cooperate(); }

    public void setStrategy(DecisionStrategy strategy) {
        this.strategy = strategy;
    }

    public void update() {
        heading = heading.random();
        Prisoner opponent = (Prisoner) world.getNeighbor(this, 10.0);
        if (opponent != null){
            // If both cooperate
            if (this.cooperate() && opponent.cooperate()){
                this.updateFitness(3);
                opponent.updateFitness(3);
                this.partnerCheated = false;
                opponent.partnerCheated = false;
            }
            // If this cooperates and opponent cheats:
             if (this.cooperate() && !opponent.cooperate()){
                 // this.fitness gets 0.
                opponent.updateFitness(5);
                 this.partnerCheated = true;
                 opponent.partnerCheated = false;
             }
            // If this cheats and opponent cooperates:
            if (!this.cooperate() && opponent.cooperate()){
                this.updateFitness(5);
                // opponent.fitness gets 0.
                this.partnerCheated = false;
                opponent.partnerCheated = true;
            }
            // If both cheat:
            if (!this.cooperate() && !opponent.cooperate()){
                this.updateFitness(1);
                opponent.updateFitness(1);
                this.partnerCheated = true;
                opponent.partnerCheated = true;
            }
        }
        move(5); //Randomly?
    }

    public int getSpeed() {
        return 0;
    }

    public int getFitness() {
        return fitness;
    }

    public boolean didPartnerCheat(){
        return partnerCheated;
    }

    public void updateFitness (int amt){
        fitness += amt;
    }
}
