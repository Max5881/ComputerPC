package ru.sapteh;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
//import ru.sapteh.DaoImp.ComputerDaoImp;


public class Program extends Application {
    public static void main(String[] args) {
       launch(args);
//       SessionFactory factory = new Configuration().configure().buildSessionFactory();
//       DAO<Computer,Integer> computerIntegerDAO = new ComputerDaoImp(factory);
//       Computer computer = new Computer();
//       computer.setHdd(1);
//       computer.setRam(1);
//
//
//       computerIntegerDAO.update(computer);
    }

    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("/view/WindowView.fxml"));
        Image image = new Image("/image/window.jpg");
        stage.getIcons().add(image);
        stage.setTitle("Window");
        stage.setScene(new Scene(root));
        stage.show();
    }
}
