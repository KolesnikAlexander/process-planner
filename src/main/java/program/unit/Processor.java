package program.unit;

import program.Task;


public class Processor extends Unit{
    private int id;
    private Task task;

    int num;

    public Processor(int id, int frequency) {
        super(frequency);
        this.id = id;
    }

    public Task getTask() {
        return task;
    }

    public void setTask(Task task) {
        this.task = task;
    }

    public int getId() {
        return id;
    }

    public boolean isFree(){
        return task == null;
    }

    @Override
    public void tick(double step) {
        if (task == null){
            return;
        }

        executeTask();
    }
    private void executeTask() {
        getSystem().operCounter++;
        task.incOperDone();
        if (task.finshed()){
            task = null;
            this.getSystem().taskCounter++;
        }
    }

    @Override
    public String toString() {
        return "Processor{" +
                "id=" + id +
                '}';
    }
}
