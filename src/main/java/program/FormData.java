package program;

import java.util.ArrayList;
import java.util.List;

public class FormData {
    private List<Integer> prFrequencies = new ArrayList<>(5);
    private int taskHappenProbability;
    private int mode;
    private int minComplexity;
    private int maxComplexity;

    //For processor-planner
    private int executionTime;
    private int planningTime;

    public FormData() {
    }

    public List<Integer> getPrFrequencies() {
        return prFrequencies;
    }

    public void setPrFrequencies(List<Integer> prFrequencies) {
        this.prFrequencies = prFrequencies;
    }

    public int getTaskHappenProbability() {
        return this.taskHappenProbability;
    }

    public void setTaskHappenProbability(int taskHappenProbability) {
        this.taskHappenProbability = taskHappenProbability;
    }

    public int getMode() {
        return mode;
    }

    public void setMode(int mode) {
        this.mode = mode;
    }

    public int getMinComplexity() {
        return minComplexity;
    }

    public void setMinComplexity(int minComplexity) {
        this.minComplexity = minComplexity;
    }

    public int getMaxComplexity() {
        return maxComplexity;
    }

    public void setMaxComplexity(int maxComplexity) {
        this.maxComplexity = maxComplexity;
    }

    public int getExecutionTime() {
        return executionTime;
    }

    public void setExecutionTime(int executionTime) {
        this.executionTime = executionTime;
    }

    public int getPlanningTime() {
        return planningTime;
    }

    public void setPlanningTime(int planningTime) {
        this.planningTime = planningTime;
    }
}
