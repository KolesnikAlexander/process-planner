package program.tickable;

import program.CompSystem;

public abstract class Unit {
    private int frequency;
    private double operationTime;
    private double timePassed;
    private CompSystem system;

    public Unit(int frequency) {
        this.frequency = frequency;
        this.operationTime = 1/(double)frequency;
        this.timePassed = 0;
    }

    public int getFrequency() {
        return frequency;
    }

    public void setSystem(CompSystem system) {
        this.system = system;
    }

    public CompSystem getSystem() {
        return system;
    }

    public void timerTick(double step){
        timePassed +=step;
        if (timePassed < operationTime)
            return;

        tick(step);
        timePassed = 0;
    }
    protected abstract void tick(double step);

}
