package program;

import javafx.fxml.FXML;
import program.tickable.Processor;
import program.tickable.Unit;

import java.util.LinkedList;

public class Controller {

    @FXML
    public void initialize(){
        LinkedList<Unit> units = new LinkedList<>();
//        units.add(new Processor(0,  2));
//        units.add(new Processor(1,  2 ));
//        units.add(new Processor(2,  4));
//        units.add(new Processor(3, 4));
//        units.add(new Processor(4, 70));
        Processor processor = new Processor(4, 23);
        units.add(processor);

        CompSystem system = new CompSystem(60, 0.0001, units);
        system.run();

        System.out.println("Oper. time: "+processor.getOperationTime());
    }
}