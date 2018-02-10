package program;

import javafx.fxml.FXML;
import program.tickable.Processor;
import program.tickable.TaskGenerator;

import java.util.ArrayList;
import java.util.List;

public class Controller {

    @FXML
    public void initialize(){
        CompSystem system = new CompSystem(100, 0.0001);
        List<Processor> processors = new ArrayList<>(5);

        Processor pr0 = new Processor(0, 2);
        system.addUnit(pr0);
        processors.add(pr0);

//        Processor pr1= new Processor(1, 1);
//        system.addUnit(pr1);
//        processors.add(pr1);
//
//        Processor pr2= new Processor(2, 5);
//        system.addUnit(pr2);
//        processors.add(pr2);


        int minCompl = 10 * minFrequency(processors); //change to gui
        int maxCompl = 200 * maxFrequency(processors); //change to gui
        TaskGenerator taskGenerator = new TaskGenerator(minCompl, maxCompl);
        system.addUnit(taskGenerator);

        system.run();
    }

    private int minFrequency(List<Processor> processors) {
        int min;
        min = processors.get(0).getFrequency();
        for (Processor processor : processors) {
            int frequency = processor.getFrequency();
            if (frequency < min)
                min = frequency;
        }
        return min;
    }

    private int maxFrequency(List<Processor> processors) {
        int max;
        max = processors.get(0).getFrequency();
        for (Processor processor : processors) {
            int frequency = processor.getFrequency();
            if (frequency > max)
                max = frequency;

        }
        return max;
    }


}