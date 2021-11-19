package ucf.assignments.ex4pt2;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import org.controlsfx.control.PropertySheet;

import java.io.IOException;
import java.text.ParseException;
import java.time.ZoneId;
import java.util.Date;
import java.time.Instant;

public class HelloController {

    @FXML
    private Button addItemButton;
    @FXML
    private Button changeTitle;
    @FXML
    private Button clearListButton;
    @FXML
    private Button helpButton;
    @FXML
    private DatePicker picker;
    @FXML
    private TextField descriptionInput;
    @FXML
    private Label listTitl;
    @FXML
    private Button addSubmit;
    @FXML
    private Button startButton;
    @FXML
    private TableView<item> table;
    @FXML
    private TableColumn<item, String> Items;
    @FXML
    private TableColumn<item, Date> Dates;
    @FXML
    private TableColumn<item, Boolean> Status;
    @FXML
    private Button changeSubmit;
    @FXML
    private TextField changeInput;


    todolist list = new todolist("New List");


    @FXML // Working
    protected void onAddItemClick(){
        picker.setVisible(true);
        descriptionInput.setVisible(true);
        addSubmit.setVisible(true);
    }

    @FXML // Working
    protected void onAddSubmitCLick(){
        Date dateDue = Date.from(picker.getValue().atStartOfDay(ZoneId.systemDefault()).toInstant());
        String description = descriptionInput.getText();

        item newItem = list.addItem(description, dateDue);

        Items.setCellValueFactory(new PropertyValueFactory<item, String>("Description"));
        Dates.setCellValueFactory(new PropertyValueFactory<item, Date>("Date"));
        Status.setCellValueFactory(new PropertyValueFactory<item, Boolean>("Complete"));

        table.setItems(FXCollections.observableList(list.getToDoList()));

        picker.setVisible(false);
        descriptionInput.setVisible(false);
        addSubmit.setVisible(false);
        picker.setValue(null);
        descriptionInput.clear();
    }

    @FXML
    protected void onClearListButtonClick(){
        list.clear();
        table.refresh();
    }

    @FXML
    protected void onChangeTitleButtonClick(){
        changeInput.setVisible(true);
        changeSubmit.setVisible(true);
    }

    @FXML
    protected void onChangeSubmitCLick(){
        String newTitle = changeInput.getText();
        list.setTitle(newTitle);
        listTitl.setText(list.getTitle());

        changeInput.setVisible(false);
        changeSubmit.setVisible(false);
        changeInput.clear();
    }

    @FXML
    protected void onHelpButtonClick() throws IOException {
        FXMLLoader loader =new FXMLLoader(HelloController.class.getResource("help.fxml"));
        Parent p = loader.load();
        Stage stage = new Stage();
        stage.setTitle("Help");
        Scene scene = new Scene(p);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    protected void start(){
        addItemButton.setVisible(true);
        clearListButton.setVisible(true);
        helpButton.setVisible(true);
        startButton.setVisible(false);
        table.setVisible(true);
        changeTitle.setVisible(true);
        listTitl.setVisible(true);
        listTitl.setText(list.getTitle());
    }

}