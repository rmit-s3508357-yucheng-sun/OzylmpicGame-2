/*
 * @author Yucheng Sun 3508357
 */

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.net.URL;
import java.text.SimpleDateFormat;
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
public class ResultController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @FXML
    TableView<DataBean> tableView;
    @FXML
    TableColumn data;
    ObservableList<DataBean> datas = FXCollections.observableArrayList();

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        data.setCellValueFactory(new PropertyValueFactory("name"));
        tableView.setItems(datas);
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
            Game game = MainController.games.get(i);
            if (i == MainController.index) {
                SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                Game g = MainController.games.get(i);
                System.out.println(g.getID() + "\t" + g.getType() + "\t");
                System.out.println("First :" + g.getAthletesOfGame().get(top[i][0]));
                System.out.println("Second :" + g.getAthletesOfGame().get(top[i][1]));
                System.out.println("Thrid :" + g.getAthletesOfGame().get(top[i][2]));

                datas.add(new DataBean(g.getID() + "\t" + g.getType() + "\t"));
                datas.add(new DataBean("First :\t\t" + g.getAthletesOfGame().get(top[i][0])));
                datas.add(new DataBean("Second :\t\t" + g.getAthletesOfGame().get(top[i][1])));
                datas.add(new DataBean("Thrid :\t\t" + g.getAthletesOfGame().get(top[i][2])));
            }
        }
    }

}
