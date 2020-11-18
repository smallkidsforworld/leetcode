import java.sql.Date;

public class RiskFactory {
    private int houre;
    private int workerNum;
    private int immediateTeam;
    private int budget;

    public RiskFactory(int time, int workerNum, int budget, int immediateTeam) {
        this.houre = time;
        this.workerNum = workerNum;
        this.budget = budget;
        this.immediateTeam = immediateTeam;
    }

    

    public RiskFactory() {
    }

    public int calculateTheNum(int num) {
        return (int) (0.2 * num);
    }

    public int calculateRisk() {
        return calculateTime(houre) + calculateImmediateTeam(immediateTeam) + calculateBudge(budget)
                + calculateTheNum(workerNum);
    }

    public int calculateTime(int houre) {
        return (int) (20 * (houre / 8726));
    }

    public int calculateImmediateTeam(int immediateTeam) {
        return (int) (immediateTeam * 0.1);
    }

    public int calculateBudge(int budget) {
        return budget / 25000;
    }

}