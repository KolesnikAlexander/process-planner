package program;

import program.unit.*;

import java.util.ArrayList;
import java.util.List;

public class Launcher {

    public static void launch(int mode){// 0, 1, 2, 3
        switch (mode){
            case 0:
                mode0();
                break;
            case 1:
                mode1();
                break;
            case 2:
                mode2();
                break;
            default:
                break;
        }
    }



    private static void mode0(){
        CompSystem system = new CompSystem(100, 0.0001);
        List<Processor> processors = new ArrayList<>(5);

        Processor pr0 = new Processor(0, 2);
        system.addUnit(pr0);
        processors.add(pr0);

        Processor pr1= new Processor(1, 1);
        system.addUnit(pr1);
        processors.add(pr1);

        Processor pr2= new Processor(2, 5);
        system.addUnit(pr2);
        processors.add(pr2);

        int minCompl = 10;//10 * minFrequency(processors); //change to gui
        int maxCompl = 20;//200 * maxFrequency(processors); //change to gui
        TaskGenerator taskGenerator = new TaskGenerator(minCompl, maxCompl);
        system.addUnit(taskGenerator);

        FIFOPlanner fifoPlanner = new FIFOPlanner();
        system.addUnit(fifoPlanner);

        system.run();

        System.out.println("Tasks done: "+system.taskCounter);
        System.out.println("Tasks amount: "+system.taskAmount);

        System.out.println("Operations done: "+system.operCounter);
        System.out.println("Operations amount: "+80_000);

    }


    private static void mode1() {
        CompSystem system = new CompSystem(10000, 0.0001);
        List<Processor> processors = new ArrayList<>(5);

        Processor pr0 = new Processor(0, 11);
        system.addUnit(pr0);
        processors.add(pr0);

        Processor pr1= new Processor(1, 12);
        system.addUnit(pr1);
        processors.add(pr1);

        Processor pr2= new Processor(2, 18);
        system.addUnit(pr2);
        processors.add(pr2);

        Processor pr3= new Processor(3, 16);
        system.addUnit(pr3);
        processors.add(pr3);


        int minCompl = 10;//10 * minFrequency(processors); //change to gui
        int maxCompl = 10;//200 * maxFrequency(processors); //change to gui
        TaskGenerator taskGenerator = new TaskGenerator(minCompl, maxCompl);
        system.addUnit(taskGenerator);

        SimplePlanner simplePlanner = new SimplePlanner(1);
        system.addUnit(simplePlanner);

        system.run();

        System.out.println("Tasks done: "+system.taskCounter);
        System.out.println("Tasks amount: "+system.taskAmount);

        System.out.println("Operations done: "+system.operCounter);
        System.out.println("Operations amount: "+80_000);
    }
    private static void mode2() {
        CompSystem system = new CompSystem(10000, 0.0001);
        List<Processor> processors = new ArrayList<>(5);

        Processor pr0 = new Processor(0, 16);
        system.addUnit(pr0);
        processors.add(pr0);

        Processor pr1= new Processor(1, 16);
        system.addUnit(pr1);
        processors.add(pr1);

        Processor pr2= new Processor(2, 16);
        system.addUnit(pr2);
        processors.add(pr2);

        Processor pr3= new ProcessorPlanner(3, 16, 4, 20);
        system.addUnit(pr3);
        System.out.println("PR3 ystem:"+pr3.getSystem());
        processors.add(pr3);

        int minCompl = 10;//10 * minFrequency(processors); //change to gui
        int maxCompl = 10;//200 * maxFrequency(processors); //change to gui
        TaskGenerator taskGenerator = new TaskGenerator(minCompl, maxCompl);
        system.addUnit(taskGenerator);


        system.run();

        System.out.println("Tasks done: "+system.taskCounter);
        System.out.println("Tasks amount: "+system.taskAmount);

        System.out.println("Operations done: "+system.operCounter);
        System.out.println("Operations amount: "+80_000);
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
