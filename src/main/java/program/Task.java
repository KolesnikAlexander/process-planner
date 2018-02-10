package program;

import java.util.Set;

public class Task {
    private int complexity;
    private Set<Integer> processors;
    private int operDone;

    public Task(int complexity, Set<Integer> processors) {
        this.complexity = complexity;
        this.processors = processors;
    }

    public int getComplexity() {
        return complexity;
    }

    public Set<Integer> getProcessors() {
        return processors;
    }

    public int getOperDone() {
        return operDone;
    }

    public void incOperDone(){
        operDone++;
    }

    public boolean finshed(){
        return operDone >= complexity;
    }

    @Override
    public String toString() {
        return "Task{" +
                "complexity=" + complexity +
                ", processors=" + processors +
                ", operDone=" + operDone +
                '}';
    }


}
