/*
 * @author Yucheng Sun 3508357
 */

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.net.URL;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 * FXML Controller class
 *
 */
public class PointController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @FXML
    TableView tableView;

    @FXML
    TableColumn id;
    @FXML
    TableColumn name;
    @FXML
    TableColumn age;
    @FXML
    TableColumn state;
    @FXML
    TableColumn score;
    private ObservableList<DataBean> datas = FXCollections.observableArrayList();

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        id.setCellValueFactory(new PropertyValueFactory("id"));
        name.setCellValueFactory(new PropertyValueFactory("name"));
        age.setCellValueFactory(new PropertyValueFactory("age"));
        state.setCellValueFactory(new PropertyValueFactory("state"));
        score.setCellValueFactory(new PropertyValueFactory("score"));
        tableView.setItems(datas);
        for (int i = 0; i < 6; i++) {
            Game game = MainController.games.get(i);
            if (i == MainController.index) {
                for (Athlete athlete : game.getAthletesOfGame()) {
                    datas.add(new DataBean(athlete.getID(), athlete.getName(), athlete.getAge(), athlete.getState(), athlete.getScores()));
                    System.out.println(athlete + "\t" + Integer.toString(athlete.getScores()));
                }
            }
        }
    }
}
