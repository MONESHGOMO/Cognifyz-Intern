// class MyThread extends Thread {
//     public void run() {
//         System.out.println("Thread is running using Thread class");
//     }
// }

// public class Main {
//     public static void main(String[] args) {
//         MyThread t1 = new MyThread();
//         t1.start(); // start() invokes run() in a separate thread
//     }
// }

// class MyRunnable implements Runnable {
//     public void run() {
//         System.out.println("Thread is running using Runnable interface");
//     }
// }

// public class Main {
//     public static void main(String[] args) {
//         Thread t1 = new Thread(new MyRunnable());
//         t1.start();
//     }
// }




import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class CalculatorApp extends Application {

    private TextField num1Field, num2Field, resultField;

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Simple Calculator");

        // Create UI elements
        Label num1Label = new Label("Number 1:");
        num1Field = new TextField();
        
        Label num2Label = new Label("Number 2:");
        num2Field = new TextField();
        
        Label resultLabel = new Label("Result:");
        resultField = new TextField();
        resultField.setEditable(false);

        Button addButton = new Button("+");
        addButton.setOnAction(e -> calculate('+'));
        
        Button subButton = new Button("-");
        subButton.setOnAction(e -> calculate('-'));

        Button mulButton = new Button("*");
        mulButton.setOnAction(e -> calculate('*'));

        Button divButton = new Button("/");
        divButton.setOnAction(e -> calculate('/'));

        // Layout setup
        GridPane gridPane = new GridPane();
        gridPane.setPadding(new Insets(10));
        gridPane.setVgap(5);
        gridPane.setHgap(5);

        gridPane.add(num1Label, 0, 0);
        gridPane.add(num1Field, 1, 0);
        gridPane.add(num2Label, 0, 1);
        gridPane.add(num2Field, 1, 1);
        gridPane.add(resultLabel, 0, 2);
        gridPane.add(resultField, 1, 2);

        gridPane.add(addButton, 0, 3);
        gridPane.add(subButton, 1, 3);
        gridPane.add(mulButton, 0, 4);
        gridPane.add(divButton, 1, 4);

        // Set scene and show
        Scene scene = new Scene(gridPane, 300, 200);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void calculate(char operator) {
        try {
            double num1 = Double.parseDouble(num1Field.getText());
            double num2 = Double.parseDouble(num2Field.getText());
            double result = 0;

            switch (operator) {
                case '+': result = num1 + num2; break;
                case '-': result = num1 - num2; break;
                case '*': result = num1 * num2; break;
                case '/': result = num2 != 0 ? num1 / num2 : 0; break;
            }

            resultField.setText(String.valueOf(result));
        } catch (NumberFormatException e) {
            resultField.setText("Invalid input");
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}
