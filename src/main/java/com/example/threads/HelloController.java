package com.example.threads;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Random;

public class HelloController {

    @FXML
    private Label firstLable;

    @FXML
    private Label srcondLable;

    @FXML
    private TextField textField;

    @FXML
    private Label thirdLable;

    @FXML
    private Label mainLable;

    @FXML
    void onHelloButtonClick() {
        if (!textField.getText().equals("")){
            List<Integer> integers = new ArrayList<>();
            MultiThreading multiThreading = new MultiThreading(integers);
            Thread thread = new Thread(multiThreading);

            Random rnd = new Random();
            for (int j = 0; j < Integer.parseInt(textField.getText()); j++) {
                integers.add(rnd.nextInt(10));
            }
            mainLable.setText("Наш массив\n" + integers);

            thread.start();
            while (true){
                if (!thread.isAlive()){
                    fillLiable(firstLable, "Сортировка вставками ", multiThreading.getGetInsertIntegers());
                    fillLiable(srcondLable, "Сортировка пузырьком ", multiThreading.getGetVialIntegers());
                    fillLiable(thirdLable, "Сортировка выбором ", multiThreading.getGetSelectionIntegers());
                    break;
                }
            }
        }else {
            textField.setText("Вы не ввели число число!");
        }

    }

    private  void fillLiable(Label label, String s, Collection<Integer> integers){
        label.setText(s + integers.toString());
    }
    @FXML
    void onTextClick() {
        textField.clear();
    }

    @FXML
    void initialize() {
        assert firstLable != null : "fx:id=\"firstLable\" was not injected: check your FXML file 'hello-view.fxml'.";
        assert srcondLable != null : "fx:id=\"srcondLable\" was not injected: check your FXML file 'hello-view.fxml'.";
        assert textField != null : "fx:id=\"textField\" was not injected: check your FXML file 'hello-view.fxml'.";
        assert thirdLable != null : "fx:id=\"thirdLable\" was not injected: check your FXML file 'hello-view.fxml'.";

    }

}
