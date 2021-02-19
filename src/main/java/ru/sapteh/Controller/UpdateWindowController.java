package ru.sapteh.Controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import ru.sapteh.DAO.DAO;
import ru.sapteh.DaoImp.ComputerDaoImp;
import ru.sapteh.Model.Computer;

import java.io.IOException;

public class UpdateWindowController {
    SessionFactory factory = new Configuration().configure().buildSessionFactory();
    DAO<Computer,Integer> computerIntegerDAO = new ComputerDaoImp(factory);

    @FXML
    private Button updateButton;

    @FXML
    private Button exitButton;

    @FXML
    private TextField ramTextField;

    @FXML
    private TextField hddTextField;

    @FXML
    private TextField powerSupplyTextField;

    @FXML
    private TextField videoCardTextField;

    @FXML
    private TextField idTextField;

    @FXML
    public void initialize(){
        updateButton.setOnAction(event -> {
            updateButton.getScene().getWindow().hide();
            computerIntegerDAO.update(new Computer(Integer.parseInt(idTextField.getText()),Integer.parseInt(ramTextField.getText()),Integer.parseInt(hddTextField.getText()),Integer.parseInt(powerSupplyTextField.getText()),videoCardTextField.getText()));
            try {
                Parent root = FXMLLoader.load(getClass().getResource("/View/WindowView.fxml"));
                Stage stage = new Stage();
                Image image = new Image("/image/window.jpg");
                stage.getIcons().add(image);
                stage.setTitle("Create Window");
                stage.setScene(new Scene(root));
                stage.show();


            } catch (IOException e) {
                e.printStackTrace();
            }
        });
        exitButton.setOnAction(event -> {
            exitButton.getScene().getWindow().hide();
            try {
                Parent root = FXMLLoader.load(getClass().getResource("/View/WindowView.fxml"));
                Stage stage = new Stage();
                Image image = new Image("/image/window.jpg");
                stage.getIcons().add(image);
                stage.setTitle("Create Window");
                stage.setScene(new Scene(root));
                stage.show();


            } catch (IOException e) {
                e.printStackTrace();
            }
        });

    }



}
