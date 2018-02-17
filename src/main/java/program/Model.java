package program;

import java.util.ArrayList;

public class Model {

    public static void execute(){
        //run 5 times, count average
        FormData formData = new FormData();

        formData.setMode(0);
        formData.setMinComplexity(10);
        formData.setMaxComplexity(20);
        ArrayList<Integer> prFrequencies = new ArrayList<>(5);
        prFrequencies.add(16);
        prFrequencies.add(16);
        prFrequencies.add(16);
        prFrequencies.add(16);
        prFrequencies.add(16);
        formData.setTaskHappenProbability(20);
        formData.setPrFrequencies(prFrequencies);

        Launcher.launch(formData);
    }
}
