package program;

import program.unit.ModelResult;

import java.util.ArrayList;
import java.util.Collections;

public class Model {

    public static ModelResult execute(FormData formData){
        Collections.sort(formData.getPrFrequencies());
        ModelResult res = Launcher.launch(formData);
        res.setEfficiency(res.getOperDone()/(double)res.getOperTotalAmount());
        res.setRealEfficiency(res.getOperDone()/(double)res.getOperRealAmount());
        res.setTasksDonePercentage(res.getTasksDone()/(double)res.getTaskAmount());
        System.out.println(res);
        return res;
    }
}
