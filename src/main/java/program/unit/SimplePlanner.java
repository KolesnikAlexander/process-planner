package program.unit;

import program.Task;

import java.util.List;

public class SimplePlanner extends Unit {

    public SimplePlanner(int frequency) {
        super(frequency);
    }

    @Override
    protected void tick(double step) {
        List<Task> tasks = this.getSystem().getTasks();
        if ((tasks == null)||(tasks.isEmpty()))
            return;

        List<Processor> processors = this.getSystem().getProcessors();
        for (Processor processor : processors) {
            if(processor.isFree()){
                for (Task task : tasks) {
                    if (task.getProcessors().contains(processor.getId())){
                        processor.setTask(task);
                        tasks.remove(task);
                        break;
                    }
                }

            }

        }
    }
}
