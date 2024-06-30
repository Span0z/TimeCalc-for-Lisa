package com.example.timeprog;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.Background;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class HelloApplication extends Application implements EventHandler{
    @Override
    public void start(Stage stage) throws IOException {
        Button calc;
        TextField BHour,EHour,Bmin,Emin;
        Text result,BE;
        CheckBox Break;


        stage.setResizable(false);
        stage.setMaxWidth(300);



        HBox top=new HBox();
        top.setMaxWidth(300);
        top.setAlignment(Pos.TOP_CENTER);
        Insets I=new Insets(20,20,20,20);
        top.setPadding(I);


        HBox middle=new HBox();
        middle.setMaxWidth(300);
        middle.setAlignment(Pos.CENTER);
        middle.setPadding(I);

        HBox lowermid=new HBox();
        lowermid.setMaxWidth(300);
        lowermid.setAlignment(Pos.CENTER);

        HBox bottom=new HBox();
        bottom.setMaxWidth(300);
        bottom.setAlignment(Pos.CENTER);


        VBox VB=new VBox();
        VB.setMinSize(300,300);
        VB.setSpacing(25);

        Break=new CheckBox("Include break");
        Break.setAlignment(Pos.CENTER);

        result=new Text("");

        Font F=new Font(30);

        result.setFont(F);

        BE=new Text("<-->");

        BHour=new TextField("00");
        BHour.setPrefWidth(30);

        EHour=new TextField("00");
        EHour.setPrefWidth(30);

        Bmin=new TextField("00");
        Bmin.setPrefWidth(30);

        Emin=new TextField("00");
        Emin.setPrefWidth(30);

        calc=new Button("calc");
        calc.setPrefWidth(100);
        calc.setAlignment(Pos.CENTER);

        calc.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent E) {
                String time1 = BHour.getText()+":"+ Bmin.getText();
                String time2 = EHour.getText()+":"+ Emin.getText();

                if (!Break.isSelected()){
                    try{
                        SimpleDateFormat format=new SimpleDateFormat("HH:mm");
                        Date date1 = format.parse(time1);
                        Date date2 = format.parse(time2);

                        long difference = date2.getTime() - date1.getTime();
                        long diffHours = difference / (60 * 60 * 1000) % 24;
                        long diffMins = difference / (60 * 1000) % 60;




                        result.setText(String.format("%02d",diffHours)+":"+String.format("%02d",diffMins));

                    }catch (Exception EE){
                        System.out.println("oopsie");
                    }
                }
                if (Break.isSelected()){
                    try{
                        SimpleDateFormat format=new SimpleDateFormat("HH:mm");
                        Date date1 = format.parse(time1);
                        Date date2 = format.parse(time2);

                        long difference = date2.getTime() - date1.getTime()-(25*60*1000);
                        long diffHours = difference / (60 * 60 * 1000) % 24;
                        long diffMins = difference / (60 * 1000) % 60;




                        result.setText(String.format("%02d",diffHours)+":"+String.format("%02d",diffMins));

                    }catch (Exception EE){
                        System.out.println("oopsie");
                    }
                }
            }
        });



        top.getChildren().addAll(result);
        middle.getChildren().addAll(BHour,Bmin,BE, EHour, Emin);
        lowermid.getChildren().addAll(Break);
        VB.getChildren().addAll(top,middle,lowermid,bottom);
        bottom.getChildren().addAll(calc);

        Scene scene = new Scene(VB);


        stage.setTitle("Time Calculator");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }

    @Override
    public void handle(Event event) {

    }
}