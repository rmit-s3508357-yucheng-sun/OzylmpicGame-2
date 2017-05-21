/*
 * @author Yucheng Sun 3508357
 */

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 */
public class MainController implements Initializable {

    /**
     * Initializes the controller class.
     */
    public static ArrayList<Game> games = new Generate().generateGames();

    @FXML
    ComboBox<String> gameType;
    @FXML
    TextField gameID;
    @FXML
    TextField offkial;

    @FXML
    TableView tableView;

    @FXML
    TableColumn rank;
    @FXML
    TableColumn atheletid;
    @FXML
    TableColumn name;
    @FXML
    TableColumn type;
    @FXML
    TableColumn time;

    public static int index = 0;
    private ObservableList<String> types = FXCollections.observableArrayList();
    private ObservableList<DataBean> datas = FXCollections.observableArrayList();

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        int i = 1;
        for (Game g : games) {
            types.add(i++ + " ) " + g.getID() + "\t" + g.getType());
        }

        rank.setCellValueFactory(new PropertyValueFactory("rank"));
        atheletid.setCellValueFactory(new PropertyValueFactory("atheletid"));
        name.setCellValueFactory(new PropertyValueFactory("name"));
        type.setCellValueFactory(new PropertyValueFactory("type"));
        time.setCellValueFactory(new PropertyValueFactory("time"));

        gameType.setItems(types);
        tableView.setItems(datas);
        gameType.getSelectionModel().select(0);
        gameType.valueProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                gameID.setText(games.get(gameType.getSelectionModel().getSelectedIndex()).getID());
                offkial.setText(games.get(gameType.getSelectionModel().getSelectedIndex()).getReferee().getID());
            }
        });
        gameID.setText(games.get(gameType.getSelectionModel().getSelectedIndex()).getID());
        offkial.setText(games.get(gameType.getSelectionModel().getSelectedIndex()).getReferee().getID());
    }

    private void play() {
        games = new Generate().generateGames();
        datas.clear();
        int m = 1;
        for (int k = 0; k < games.size(); k++) {
            Game game = games.get(k);
            game.start();
            if (k == gameType.getSelectionModel().getSelectedIndex()) {
                ArrayList<Athlete> athletesOfGame = game.getAthletesOfGame();
                ArrayList<Double> timeOfAthletes = game.getTimeOfAthletes();
                for (int j = 0; j < athletesOfGame.size(); j++) {
                    Athlete athlete = athletesOfGame.get(j);
                    Double get = timeOfAthletes.get(j);
                    datas.add(new DataBean("" + (m++), athlete.getID(), athlete.getName(), athlete.getState(), "" + get));
                }
            }
        }

        int[][] top = new int[6][3];
        for (Game game : MainController.games) {
            top[MainController.games.indexOf(game)] = game.getReferee().summarise(game.getTimeOfAthletes());
        }
        int selectedGame = 0;
        int selectedAthlete = 0;
        try {
            if (top[selectedGame - 1][0] == (selectedAthlete - 1)) {
                System.out.println("Congratulations!You get the right answer!");
            } else {
                System.out.println("You are wrong!");
            }
        } catch (Exception e) {
        }

        for (int i = 0; i < 6; i++) {
            if (i == gameType.getSelectionModel().getSelectedIndex()) {
                SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                Game g = games.get(i);
                System.out.println(g.getID() + "\t" + g.getType() + "\t");
                System.out.println("First :" + g.getAthletesOfGame().get(top[i][0]) + " " + g.getAthletesOfGame().get(top[i][0]).getScores());
                g.getAthletesOfGame().get(top[i][0]).addScores(5);
                System.out.println("Second :" + g.getAthletesOfGame().get(top[i][1]));
                g.getAthletesOfGame().get(top[i][1]).addScores(3);
                System.out.println("Thrid :" + g.getAthletesOfGame().get(top[i][2]));
                g.getAthletesOfGame().get(top[i][2]).addScores(1);
            }
        }
        StringBuilder sb = new StringBuilder();
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SS");
        for (int i = 0; i < 6; i++) {
            if (i == gameType.getSelectionModel().getSelectedIndex()) {
                Game g = games.get(i);
                ArrayList<Double> timeOfAthletes = g.getTimeOfAthletes();

                sb.append(g.getID() + "," + offkial.getText() + "," + df.format(new Date()) + "\n");
                for (int j = 0; j < 6; j++) {
                    Athlete athlete = g.getAthletesOfGame().get(top[i][j]);
                    sb.append(athlete.getID() + "," + String.format("%.1f", timeOfAthletes.get(j)) + "," + athlete.getScores() + "\n");
                }
            }
        }
        System.out.println(sb.toString());
        sb.append("\n");
        try {
            WriteFileUtils.writeFile(new File("gameresults.txt"), sb.toString());
        } catch (Exception ex) {
            Logger.getLogger(MainController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void start() throws IOException {
        if ("".equals(offkial.getText().trim()) || "".equals(gameID.getText().trim())) {
            Alert alert = new Alert(AlertType.INFORMATION);
            alert.setTitle("Information Dialog");
            alert.setContentText("Please input game id and official!");
            alert.showAndWait();
        } else {
            play();
        }
    }

    @FXML
    private void result() throws IOException {
        index = gameType.getSelectionModel().getSelectedIndex();

        Stage primaryStage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("Result.fxml"));
        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    @FXML
    private void point() throws IOException {
        index = gameType.getSelectionModel().getSelectedIndex();

        Stage primaryStage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("Point.fxml"));
        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.show();

    }

    @FXML
    private void exit() {
        System.exit(0);
    }
}
