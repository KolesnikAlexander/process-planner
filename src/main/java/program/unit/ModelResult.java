package program.unit;

public class ModelResult {
    private int mode;
    private int taskAmount;
    private int tasksDone;

    private int operTotalAmount;
    private int operRealAmount;
    private int operDone;

    private double efficiency;
    private double realEfficiency;
    private double tasksDonePercentage;

    public int getTaskAmount() {
        return taskAmount;
    }

    public void setTaskAmount(int taskAmount) {
        this.taskAmount = taskAmount;
    }

    public int getTasksDone() {
        return tasksDone;
    }

    public void setTasksDone(int tasksDone) {
        this.tasksDone = tasksDone;
    }

    public int getOperTotalAmount() {
        return operTotalAmount;
    }

    public void setOperTotalAmount(int operTotalAmount) {
        this.operTotalAmount = operTotalAmount;
    }

    public int getOperRealAmount() {
        return operRealAmount;
    }

    public void setOperRealAmount(int operRealAmount) {
        this.operRealAmount = operRealAmount;
    }

    public int getOperDone() {
        return operDone;
    }

    public void setOperDone(int operDone) {
        this.operDone = operDone;
    }

    public double getEfficiency() {
        return efficiency;
    }

    public void setEfficiency(double efficiency) {
        this.efficiency = efficiency;
    }

    public double getTasksDonePercentage() {
        return tasksDonePercentage;
    }

    public void setTasksDonePercentage(double tasksDonePercentage) {
        this.tasksDonePercentage = tasksDonePercentage;
    }

    public double getRealEfficiency() {
        return realEfficiency;
    }

    public void setRealEfficiency(double realEfficiency) {
        this.realEfficiency = realEfficiency;
    }

    public int getMode() {
        return mode;
    }

    public void setMode(int mode) {
        this.mode = mode;
    }

    @Override
    public String toString() {
        return "ModelResult{" +
                "taskAmount=" + taskAmount +
                ", tasksDone=" + tasksDone +
                ", operTotalAmount=" + operTotalAmount +
                ", operRealAmount=" + operRealAmount +
                ", operDone=" + operDone +
                ", efficiency=" + efficiency +
                ", realEfficiency=" + realEfficiency +
                ", tasksDonePercentage=" + tasksDonePercentage +
                '}';
    }
    public String show(){
        String val = "";
        switch (mode){
            case 0:
                val = "FIFO\n==================\n";
                break;
            case 1:
                val = "DEDICATED PLANNER\n==================\n";
                break;
            case 2:
                val = "PLANNER/PROCESSOR\n==================\n";
                break;
            case 3:
                val = "ADJUSTABLE PLANNER/PROCESSOR\n==================\n";
                break;
        }

        return  val+"Tasks done: " + tasksDone +"\n"+
                "Amount of tasks: " + taskAmount +"\n"+
                "\n"+
                "Percentage of the tasks done: " + tasksDonePercentage +"\n"+
                "--------------------------------"+"\n"+
                "Operations done: " + operDone +"\n"+
                "Total amount of operations: " + operTotalAmount +"\n"+
                "Real amount of operations: " + operRealAmount +"\n"+
                "\n"+
                "Total efficiency: " + efficiency +"\n"+
                "Real efficiency: " + realEfficiency +"\n";

    }
}
