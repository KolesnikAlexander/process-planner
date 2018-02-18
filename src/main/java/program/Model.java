package program;

import program.unit.ModelResult;

import java.util.ArrayList;
import java.util.Collections;

public class Model {

    public static ModelResult execute(FormData formData){
        //run 5 times, count average
//        FormData formData = new FormData();
//
//        formData.setMode(0);
//        formData.setMinComplexity(10);
//        formData.setMaxComplexity(20);
//        ArrayList<Integer> prFrequencies = new ArrayList<>(5);
//        prFrequencies.add(16);
//        prFrequencies.add(16);
//        prFrequencies.add(16);
//        prFrequencies.add(16);
//        prFrequencies.add(16);
//        formData.setTaskHappenProbability(20);
//        formData.setPrFrequencies(prFrequencies);

        Collections.sort(formData.getPrFrequencies());
        ModelResult res = Launcher.launch(formData);
        res.setEfficiency(res.getOperDone()/(double)res.getOperTotalAmount());
        res.setRealEfficiency(res.getOperDone()/(double)res.getOperRealAmount());
        res.setTasksDonePercentage(res.getTasksDone()/(double)res.getTaskAmount());
        System.out.println(res);
        return res;
    }
}
