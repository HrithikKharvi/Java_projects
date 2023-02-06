package sample;

import javafx.event.EventType;
import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;
import javafx.scene.control.Spinner;
import javafx.scene.control.TextArea;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;

import java.util.Locale;

public class Controller {

    @FXML
    private HBox titlePane;

    @FXML
    private ListView<HBox> listView;

    @FXML
    private ComboBox<String> selector1;

    @FXML
    private ComboBox<String> selector2;

    @FXML
    private Spinner<Integer> spinner1;

    @FXML
    private TextArea result;

    @FXML
    private  void initialize(){
        titlePane.setStyle("-fx-background-color:black;");
        titlePane.paddingProperty().setValue(new Insets(10, 10, 10, 10));

        String[] strs = new String[]{"History"};

        for(String str : strs){
            HBox hbox = new HBox();
            hbox.getChildren().add(new Text(str));
            hbox.setSpacing(10);
            hbox.setStyle("-fx-background-color:grey;");
            listView.getItems().add(hbox);
        }

        String[] options = new String[]{"Kelvin", "Celsius", "Fahrenheit"};
        selector1.prefHeight(10);
        selector1.prefWidth(100);
        selector1.getItems().addAll(options);

        selector1.getSelectionModel().selectFirst();

        selector2.prefHeight(10);
        selector2.prefWidth(100);
        selector2.getItems().addAll(options);

        selector2.getSelectionModel().selectFirst();
    }

    @FXML
    private void convert(){
        int value1 = spinner1.getValue();
        String type1 = selector1.getSelectionModel().getSelectedItem();
        String type2 = selector2.getSelectionModel().getSelectedItem();
        System.out.println(value1 + "L" + "->" + type1 + "->" +type2);

        if(type1.equals(type2))result.setText(value1 + "");
        if(type1.toLowerCase().equals("celsius") && type2.toLowerCase().equals("kelvin")){
            result.setText(convertCelciusToKelvin(value1) + " K");
        }else if(type1.toLowerCase().equals("celsius") && type2.toLowerCase().equals("fahrenheit")){
            result.setText(convertCelciusToFahrenheit(value1) + " degree F");
        }else if(type1.toLowerCase().equals("fahrenheit") && type2.toLowerCase().equals("celsius")){
            result.setText(convertFahrenheitToCelcius(value1));
        }else if(type1.toLowerCase().equals("fahrenheit") && type2.toLowerCase().equals("kelvin")){
            result.setText(convertFahrenheitToKelvin(value1) );
        }else if(type1.toLowerCase().equals("kelvin") && type2.toLowerCase().equals("celsius")){
            result.setText(convertKelvinToCelsius(value1));
        }else if(type1.toLowerCase().equals("kelvin") && type2.toLowerCase().equals("fahrenheit")){
            result.setText(convertKelvinToFahrenheit(value1));
        }
    }

    private String convertKelvinToFahrenheit(int value1) {
        String returnString = ((value1 - 273.15) * 9/5 + 32) + "deg F";
        String append = value1 + " K ----> " + returnString;
        appendIntoList(append);
        return returnString;
    }

    private String convertKelvinToCelsius(int value1) {
        String returnString = (value1 - 273.15) + " degree C";
        String append = value1 + " K -----> " + returnString;
        appendIntoList(append);
        return returnString;
    }

    private String convertFahrenheitToKelvin(int value1) {
        String returnString = ((value1 - 32) * 5/9 + 273.3) + " k";
        String append = value1 + " F ------> " + returnString;
        appendIntoList(append);
        return returnString;
    }

    private String convertFahrenheitToCelcius(int value1) {
        String returnString = ((value1 - 32)* 5/9)+ " degree C";
        String append = value1 + " F -----> " + returnString;
        appendIntoList(append);
        return returnString;
    }

    public double convertCelciusToKelvin(int value){
        double returnValue = 273.15 + value;
        String append = value + " deg C -----> " + returnValue + " K";
        appendIntoList(append);
        return returnValue;
    }

    public double convertCelciusToFahrenheit(int value){
        double returnValue = (value * (double)9/5) + 32;
        String append = value + " deg C -----> " + returnValue + " F";
        appendIntoList(append);
        return returnValue;
    }

    public void appendIntoList(String str){
        HBox hbox = new HBox();
        hbox.getChildren().add(new Text(str));
        hbox.setSpacing(10);
        listView.getItems().add(hbox);
    }
}
