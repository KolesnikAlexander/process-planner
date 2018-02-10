package program;

import program.tickable.Unit;

import java.util.LinkedList;
import java.util.List;

public class CompSystem {
    private double time;
    private double step;
    private List<Unit> units;

    public List<Task> tasks;
    public int operCounter;

    void run(){
        double i = 0;
        while(i < time){
            for (Unit unit : units) {
                unit.timerTick(step);
            }
            i+=step;
        }
    }

    public CompSystem(double time, double step, List<Unit> units) {
        this.time = time;
        this.step = step;
        this.units = units;
        tasks = new LinkedList<>();
        operCounter = 0;
    }

}
