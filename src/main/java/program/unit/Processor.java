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
            System.out.println("Processor "+id+" waiting ||"+(++num));
            return;
        }

        executeTask();
        System.out.println("Processor "+id+" executed task  ||"+(++num));
    }

    private void executeTask() {
        getSystem().operCounter++;
        task.incOperDone();
        if (task.finshed()){
            System.out.println("Task "+task+" finished");
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
