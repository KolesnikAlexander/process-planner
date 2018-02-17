package program;

import program.unit.*;

import java.util.List;

public class Launcher {

    public static void launch(FormData data){// 0, 1, 2, 3
        CompSystem system = new CompSystem(10000, 0.0001);

        int minCompl = data.getMinComplexity();//10 * minFrequency(processors); //change to gui
        int maxCompl = data.getMaxComplexity();//200 * maxFrequency(processors); //change to gui
        int probability = data.getTaskHappenProbability();
        TaskGenerator taskGenerator = new TaskGenerator(minCompl, maxCompl, probability);
        system.addUnit(taskGenerator);

        switch (data.getMode()){
            case 0:
                mode0(system, data);
                break;
            case 1:
                mode1(system, data);
                break;
            case 2:
                mode2(system, data);
                break;
            default:
                break;
        }

        system.run();

        System.out.println("Tasks done: "+system.taskCounter);
        System.out.println("Tasks amount: "+system.taskAmount);

        System.out.println("Operations done: "+system.operCounter);
        int operAmount = (data.getPrFrequencies().get(0)
                +data.getPrFrequencies().get(1)
                +data.getPrFrequencies().get(2)
                +data.getPrFrequencies().get(3)
                +data.getPrFrequencies().get(4))
                    *10000;
        System.out.println("Operations amount: "+operAmount);
    }

    private static void mode0(CompSystem system, FormData data){
        Processor pr0 = new Processor(0, data.getPrFrequencies().get(0));
        system.addUnit(pr0);

        Processor pr1 = new Processor(1, data.getPrFrequencies().get(1));
        system.addUnit(pr1);

        Processor pr2 = new Processor(2, data.getPrFrequencies().get(2));
        system.addUnit(pr2);

        Processor pr3 = new Processor(3, data.getPrFrequencies().get(3));
        system.addUnit(pr3);

        Processor pr4 = new Processor(4, data.getPrFrequencies().get(4));
        system.addUnit(pr4);

        FIFOPlanner fifoPlanner = new FIFOPlanner();
        system.addUnit(fifoPlanner);
    }

    private static void mode1(CompSystem system, FormData data) {

        Processor pr0 = new Processor(0, 11);
        system.addUnit(pr0);

        Processor pr1= new Processor(1, 12);
        system.addUnit(pr1);

        Processor pr2= new Processor(2, 18);
        system.addUnit(pr2);

        Processor pr3= new Processor(3, 16);
        system.addUnit(pr3);

        SimplePlanner simplePlanner = new SimplePlanner(1);
        system.addUnit(simplePlanner);
    }
    private static void mode2(CompSystem system, FormData data) {

        Processor pr0 = new Processor(0, 16);
        system.addUnit(pr0);

        Processor pr1= new Processor(1, 16);
        system.addUnit(pr1);

        Processor pr2= new Processor(2, 16);
        system.addUnit(pr2);

        Processor pr3= new ProcessorPlanner(3, 16, 4, 20);
        system.addUnit(pr3);
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
