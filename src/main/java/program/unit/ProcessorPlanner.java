package program.unit;

public class ProcessorPlanner extends Processor{
    public SimplePlanner planner;

    public boolean isPlannerNow;
    private double timePassed;

    private double plannerTime;
    private double processorTime;

    public ProcessorPlanner(int id, int frequency, double plannerTime, double processorTime) {
        super(id, frequency);
        planner = new SimplePlanner(frequency);
        this.plannerTime = plannerTime;
        this.processorTime = processorTime;
        this.timePassed = 0;
    }

    @Override
    public void tick(double step) {
        timePassed+=getOperationTime();
        if(isPlannerNow){
            planner.tick(step);
            if (timePassed >= plannerTime){
                isPlannerNow = !isPlannerNow;
                timePassed = 0;
            }
        }
        else{
            super.tick(step);
            if (timePassed >= processorTime){
                isPlannerNow = !isPlannerNow;
                timePassed = 0;
            }
        }
    }
}
