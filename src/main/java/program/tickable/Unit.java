package program.tickable;

public abstract class Unit {
    private int frequency;
    private double operationTime;
    private double timePassed;

    public Unit(int frequency) {
        this.frequency = frequency;
        this.operationTime = 1/(double)frequency;
        this.timePassed = 0;
    }

    public void timerTick(double step){
        timePassed +=step;
        if (timePassed < operationTime)
            return;

        tick(step);
        timePassed = 0;
    }
    protected abstract void tick(double step);

    public double getOperationTime() {
        return operationTime;
    }
}
