package program.tickable;

import program.CompSystem;
import program.Task;


public class Processor extends Unit{
    int id;
    Task task;

    int num;

    public Processor(int id, int frequency) {
        super(frequency);
        this.id = id;
    }

    @Override
    public void tick(double step) {
//        if (task == null)
//            return;
//
//        executeTask();
        System.out.println("Processor "+id+" ticked: "+(++num));
    }

    private void executeTask() {
        this.getSystem().operCounter++;
    }

}
