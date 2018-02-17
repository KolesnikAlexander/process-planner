package program.unit;

import program.Task;

import java.util.List;

public class FIFOPlanner extends Unit {
    int num;
    public FIFOPlanner() {
        super(100);
    }

    @Override
    protected void tick(double step) {
        List<Task> tasks = this.getSystem().getTasks();
        if ((tasks == null)||(tasks.isEmpty()))
            return;

        List<Processor> processors = this.getSystem().getProcessors();
        Task task = tasks.get(0);
        for (Processor processor : processors) {
            if(processor.isFree() && task.getProcessors().contains(processor.getId())){
                processor.setTask(task);
                tasks.remove(task);
                System.out.println("PROCESSOR: "+processor);
                break;
            }

        }

        System.out.println("FIFO PLANNED TASK >>>>>>>>>>>"+(++num));
    }
}
