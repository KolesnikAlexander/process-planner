package program;


import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;
import program.unit.ModelResult;

import java.util.ArrayList;
import java.util.List;

public class Controller {

    @FXML
    public TextField pr1;
    public TextField pr2;
    public TextField pr3;
    public TextField pr4;
    public TextField pr5;
    @FXML
    public TextField taskProbabilty;
    public TextField minCompl;
    public TextField maxCompl;
    public Text resultText;
    public TextField planningTextField;
    public TextField execTextField;

    @FXML
    public void initialize() {
        //Model.execute();
    }

    public void runFifoClicked(MouseEvent mouseEvent) {
        FormData formData = new FormData();
        formData.setMode(0);
        makeFormData(formData);
        ModelResult res = Model.execute(formData);
        showResult(res);
    }

    public void runDedClicked(MouseEvent mouseEvent) {
        FormData formData = new FormData();
        formData.setMode(1);
        makeFormData(formData);
        ModelResult res = Model.execute(formData);
        showResult(res);
    }

    public void runPlannerClicked(MouseEvent mouseEvent) {
        FormData formData = new FormData();
        formData.setMode(2);
        formData.setExecutionTime(20);
        formData.setPlanningTime(4);
        makeFormData(formData);
        ModelResult res = Model.execute(formData);
        showResult(res);
    }

    public void adjPlannerProcClicked(MouseEvent mouseEvent) {
        FormData formData = new FormData();
        formData.setMode(3);
        formData.setExecutionTime(Integer.parseInt(execTextField.getText()));
        formData.setPlanningTime(Integer.parseInt(planningTextField.getText()));
        makeFormData(formData);
        ModelResult res = Model.execute(formData);
        showResult(res);
    }

    private void makeFormData(FormData formData){
        formData.setTaskHappenProbability(Integer.parseInt(taskProbabilty.getText()));
        formData.setMinComplexity(Integer.parseInt(minCompl.getText()));
        formData.setMaxComplexity(Integer.parseInt(maxCompl.getText()));

        ArrayList<Integer> processors = new ArrayList<>(5);
        processors.add(Integer.parseInt(pr1.getText()));
        processors.add(Integer.parseInt(pr2.getText()));
        processors.add(Integer.parseInt(pr3.getText()));
        processors.add(Integer.parseInt(pr4.getText()));
        processors.add(Integer.parseInt(pr5.getText()));
        formData.setPrFrequencies(processors);
    }

    private void showResult(ModelResult result) {
        resultText.setText(result.show());
    }

}