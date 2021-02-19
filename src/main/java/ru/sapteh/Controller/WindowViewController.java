package ru.sapteh.Controller;

import javafx.beans.property.SimpleObjectProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import ru.sapteh.DAO.DAO;
import ru.sapteh.DaoImp.ComputerDaoImp;
import ru.sapteh.Model.Computer;

import java.io.IOException;
import java.util.List;

public class WindowViewController {
    SessionFactory factory = new Configuration().configure().buildSessionFactory();
    ObservableList<Computer> observableList = FXCollections.observableArrayList();

    @FXML
    private Button createButton;

    @FXML
    private Button updateButton;

    @FXML
    private Button deleteButton;

    @FXML
    private TableView<Computer> computerTableView;

    @FXML
    private TableColumn<Computer, Integer> idColumn;

    @FXML
    private TableColumn<Computer, Integer> ramColumn;

    @FXML
    private TableColumn<Computer, Integer> hddColumn;

    @FXML
    private TableColumn<Computer, Integer> powerSuplyColumn;

    @FXML
    private TableColumn<Computer, String> videoCardColumn;

    @FXML
    public void initialize(){

        createButton.setOnAction(event -> {
            createButton.getScene().getWindow().hide();
            try {
                Parent root = FXMLLoader.load(getClass().getResource("/View/CreateView.fxml"));
                Stage stage = new Stage();
                Image image = new Image("/image/img_511276.png");
                stage.getIcons().add(image);
                stage.setTitle("Create Window");
                stage.setScene(new Scene(root));
                stage.show();


            } catch (IOException e) {
                e.printStackTrace();
            }
        });
        updateButton.setOnAction(event -> {
            updateButton.getScene().getWindow().hide();
            try {
                Parent root = FXMLLoader.load(getClass().getResource("/View/UpdateWindow.fxml"));
                Stage stage = new Stage();
                Image image = new Image("/image/update.png");
                stage.getIcons().add(image);
                stage.setTitle("Update Window");
                stage.setScene(new Scene(root));
                stage.show();
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
        deleteButton.setOnAction(event -> {
            deleteButton.getScene().getWindow().hide();
            try {
                Parent root = FXMLLoader.load(getClass().getResource("/View/DeleteWindow.fxml"));
                Stage stage = new Stage();
                Image image = new Image("/image/delete.png");
                stage.getIcons().add(image);
                stage.setTitle("Delete Window");
                stage.setScene(new Scene(root));
                stage.showAndWait();
            } catch (IOException e) {
                e.printStackTrace();
            }
        });

            DAO<Computer, Integer> computerIntegerDAO = new ComputerDaoImp(factory);
            List<Computer> computerList = computerIntegerDAO.readAllBy();
            observableList.addAll(computerList);
            idColumn.setCellValueFactory(p -> new SimpleObjectProperty<>(p.getValue().getId()));
            ramColumn.setCellValueFactory(p -> new SimpleObjectProperty<>(p.getValue().getRam()));
            hddColumn.setCellValueFactory(p -> new SimpleObjectProperty<>(p.getValue().getHdd()));
            powerSuplyColumn.setCellValueFactory(p -> new SimpleObjectProperty<>(p.getValue().getPowerSupple()));
            videoCardColumn.setCellValueFactory(p -> new SimpleObjectProperty<>(p.getValue().getVideoCard()));
            computerTableView.setItems(observableList);

    }
}
