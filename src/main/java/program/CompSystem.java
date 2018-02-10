package program;

import program.tickable.Processor;
import program.tickable.Unit;

import java.util.LinkedList;
import java.util.List;

public class CompSystem {
    private double time;
    private double step;
    private List<Unit> units;
    private List<Processor> processors;

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

    public CompSystem(double time, double step) {
        this.time = time;
        this.step = step;
        this.units = new LinkedList<>();
        this.tasks = new LinkedList<>();
        this.processors = new LinkedList<>();
        this.operCounter = 0;
    }

    public void addUnit(Unit unit){
        unit.setSystem(this);
        units.add(unit);
        if (unit instanceof Processor){
            processors.add((Processor) unit);
        }
    }

}
