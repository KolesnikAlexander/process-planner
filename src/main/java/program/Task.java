package program;

import java.util.ArrayList;

public class Task {
    private int complexity;
    private ArrayList<Integer> processors;

    public Task(int complexity, ArrayList<Integer> processors) {
        this.complexity = complexity;
        this.processors = processors;
    }
}
