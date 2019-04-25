package Chapter4.login;

import java.io.File;
import java.io.IOException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Scanner;
import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javax.swing.JOptionPane;

public class login extends Application {

    @FXML
    private TextField LoginName;
    @FXML
    private PasswordField Password;

    @FXML
    public void OK() throws IOException {
        File accounts = new File("C:\\Users\\hp\\Documents\\NetBeansProjects\\Programming3\\src\\Chapter4\\login\\Accounts.txt");
        Scanner scanner = new Scanner(accounts);
        while (scanner.hasNext()) {
            if (LoginName.getText().equals(scanner.next())) {
                if (getMd5(Password.getText()).equals(scanner.next())) {
                    ShowOptionsPage();
                    break;
                } else {
                    JOptionPane.showMessageDialog(null, "Invalid username OR password!", "Error!", JOptionPane.ERROR_MESSAGE);
                    break;
                }
            }
        }
    }

    @FXML
    public void Exit() {
        System.exit(0);
    }
    private Parent parent;
    private Stage stage;

    @Override
    public void start(Stage primaryStage) throws Exception {
        stage = primaryStage;
        ShowLoginPage();

        stage.setResizable(false);
        stage.show();
    }

    public static String getMd5(String input) {
        try {

            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] messageDigest = md.digest(input.getBytes());

            BigInteger no = new BigInteger(1, messageDigest);

            String hashtext = no.toString(16);
            while (hashtext.length() < 32) {
                hashtext = "0" + hashtext;
            }
            return hashtext;
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }

    public void ShowLoginPage() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("LoginFrame.fxml"));
        loader.setController(this);
        parent = loader.load();
        stage.setScene(new Scene(parent));
        stage.setTitle("Login Page");
    }

    public void ShowOptionsPage() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("OptionsFrame.fxml"));
        loader.setController(this);
        parent = loader.load();
        stage.setScene(new Scene(parent));
        stage.setTitle("Options Page");
    }

    public static void main(String[] args) {
        launch(args);
    }
}
