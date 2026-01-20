
package ec.edu.espoch.stackfx.controller;

import ec.edu.espoch.stackfx.view.StackCanvas;
import ec.edu.espoch.stackfx.model.Stack;
import java.util.NoSuchElementException;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.layout.StackPane;





public class StackController  {

  @FXML
   private TextField textValue;
   
  @FXML
   private StackPane canvasHolder;
   private StackCanvas canvas;
   private final Stack stack = new Stack();
   
   
   @FXML
    private void initialize() {
        canvas = new StackCanvas();
        canvasHolder.getChildren().add(canvas);

        canvas.clearHighlight();
        refreshView();
    }

    @FXML
    private void push() {
        System.out.println("Hola Pedro");
        Integer v = readInt();
        if (v == null) {
            //lblStatus.setText("Entrada inválida.");
            return;
        }

        stack.push(v);
        canvas.clearHighlight();
        canvas.render();
        //lblStatus.setText("Insertado al inicio: " + v);
        textValue.selectAll();
        textValue.requestFocus();
        refreshView();
    }

    @FXML
    private void pop() {
        try {
            int removed = (int) stack.pop();              // 1) operación del modelo
            //lblStatus.setText("Pop → " + removed);  // 2) feedback al usuario
            refreshView();                          // 3) actualizar la vista
        } catch (NoSuchElementException ex) {
            //lblStatus.setText(ex.getMessage());
        }
    }
    
    private Integer readInt() {
        try {
            String s = (textValue.getText() == null) ? "" : textValue.getText().trim();
            if (s.isEmpty()) {
                return null;
            }
            return Integer.valueOf(s);
        } catch (NumberFormatException ex) {
            return null;
        }
    }

     private void refreshView() {
        canvas.setValues(stack.toList());
        canvas.render();
    }
}
