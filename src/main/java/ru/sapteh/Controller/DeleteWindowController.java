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

public class DeleteWindowController {
    SessionFactory factory = new Configuration().configure().buildSessionFactory();
    DAO<Computer,Integer> computerIntegerDAO = new ComputerDaoImp(factory);
    Computer computer = new Computer();

    @FXML
    private Button deleteButton;

    @FXML
    private Button exitButton;

    @FXML
    private TextField deleteTextField;

    @FXML
    public void initialize(){
        deleteButton.setOnAction(event -> {
            deleteButton.getScene().getWindow().hide();
            computerIntegerDAO.delete(new Computer(Integer.parseInt(deleteTextField.getText())));
            try {
                Parent root = FXMLLoader.load(getClass().getResource("/View/WindowView.fxml"));
                Stage stage = new Stage();
                Image image = new Image("/image/window.jpg");
                stage.getIcons().add(image);
                stage.setTitle("Window");
                stage.setScene(new Scene(root));
                stage.show();

            } catch (IOException e) {
                e.printStackTrace();
            }
        });
        exitButton.setOnAction(event ->{
            exitButton.getScene().getWindow().hide();
            try{
                Parent root = FXMLLoader.load(getClass().getResource("/View/WindowView.fxml"));
                Stage stage = new Stage();
                Image image = new Image("/image/window.jpg");
                stage.getIcons().add(image);
                stage.setTitle("Window");
                stage.setScene(new Scene(root));
                stage.show();
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
    }

}
