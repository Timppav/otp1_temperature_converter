import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class TemperatureConverterView extends Application {
    private final TemperatureConverter tc = new TemperatureConverter();

    @Override
    public void start(Stage stage) {
        stage.setTitle("Temperature Converter");

        GridPane grid = new GridPane();
        grid.setPadding(new Insets(10, 10, 10, 10));
        grid.setHgap(10);
        grid.setVgap(10);

        addConverterRow(grid, 0, "Celsius to Fahrenheit", "Celsius", tc::celsiusToFahrenheit);
        addConverterRow(grid, 1, "Fahrenheit to Celsius", "Fahrenheit", tc::fahrenheitToCelsius);
        addConverterRow(grid, 2, "Kelvin to Celsius", "Kelvin", tc::kelvinToCelsius);
        addConverterRow(grid, 3, "Celsius to Kelvin", "Celsius", tc::celsiusToKelvin);

        Scene scene = new Scene(grid, 400, 400);
        stage.setScene(scene);
        stage.show();
    }

    @FunctionalInterface
    interface TemperatureConverterFunction {
        double convert(double input);
    }

    private void addConverterRow(GridPane grid, int row, String title, String inputUnit, TemperatureConverterFunction function) {
        Label label = new Label(title);
        TextField textField = new TextField();
        textField.setPromptText(inputUnit);
        Button button = new Button("Convert");
        Label resultLabel = new Label("Result:");

        button.setOnAction(e -> {
           try {
               double input = Double.parseDouble(textField.getText());
               double result = function.convert(input);
               resultLabel.setText(String.valueOf(result));
           } catch (NumberFormatException ex) {
               resultLabel.setText("Invalid input");
           } catch (IllegalArgumentException ex) {
               resultLabel.setText(ex.getMessage());
           }
        });

        grid.add(label, 0, row);
        grid.add(textField, 1, row);
        grid.add(button, 2, row);
        grid.add(resultLabel, 3, row);
    }
}
