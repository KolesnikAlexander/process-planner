package program.tickable;

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
        System.out.println("Processor "+id+" ticked: "+(++num));
    }

    public int getId() {
        return id;
    }

    public boolean equals(Processor processor) {
        return this.id == processor.id;
    }
    public boolean equals(int id){
        return this.id == id;
    }
}
