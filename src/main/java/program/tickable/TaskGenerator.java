package program.tickable;

import program.CompSystem;
import program.Task;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Set;

public class TaskGenerator extends Unit{
    private int num;
    private int minCompl;
    private int maxCompl;
//    public static final double procProbability ;

    public TaskGenerator(int minCompl, int maxCompl) {
        super(1);
        this.minCompl = minCompl;
        this.maxCompl = maxCompl;

        System.out.println("TASK GENERATOR{ MIN = "+minCompl+", MAX = "+maxCompl+" }");
    }

    @Override
    protected void tick(double step) {
        int complexity = generateComplexity();
        Set<Integer> procesors = generateProcessors();
        Task task = new Task(complexity, procesors);
        this.getSystem().tasks.add(task);
        System.out.println("Task generated, complexity:"+complexity+" ------------ "+(++num));
    }

    private Set<Integer> generateProcessors() {
        return null;
    }

    private int generateComplexity() {
        return  minCompl + new Random().nextInt(maxCompl+1); // [low..upp];
    }

}
