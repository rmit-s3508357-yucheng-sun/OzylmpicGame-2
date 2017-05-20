/*
 * @author YI YANG s3520987
 */

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.Reader;
import java.util.ArrayList;

public class ReadFileUtils {

    ArrayList<Game> games = new ArrayList<Game>();

    public ReadFileUtils() {
    }

    public ArrayList<Game> readFile() throws Exception {
        Game game = null;
        Official official = null;
        File f = new File("d:\\participants.txt");
        Reader input = new FileReader(f);
        BufferedReader bf = new BufferedReader(input);
        char[] c = new char[1024];
        String str = "";
        int i = 1;
        while ((str = bf.readLine()) != null) {
            Athlete athlete = null;
            String[] users = str.split(",");
            String type = users[1].trim();
            switch (type) {
                case "swimmer":
                    if (game == null) {
                        game = new SwimGame(i);
                    }
                    athlete = new Swimmer(users[0], users[2], Integer.parseInt(users[3].trim()), users[4]);
                    break;
                case "sprinter":
                    if (game == null) {
                        game = new RunGame(i);
                    }
                    athlete = new Sprinter(users[0], users[2], Integer.parseInt(users[3].trim()), users[4]);
                    break;
                case "clcly":
                    if (game == null) {
                        game = new ClclyGame(i);
                    }
                    athlete = new Cyclist(users[0], users[2], Integer.parseInt(users[3].trim()), users[4]);
                    break;
                case "super":
                    athlete = new SuperAthlete(users[0], users[2], Integer.parseInt(users[3].trim()), users[4]);
                case "officer":
                    official = new Official(users[0], users[2], Integer.parseInt(users[3].trim()), users[4]);
            }
            if (game == null) {
                continue;
            }
            game.setType(type);
            if (i++ < 6) {
                game.getAthletesOfGame().add(athlete);
            } else {
                game.setReferee(official);
                games.add(game);
                game = null;
                i = 0;
            }
        }
        input.close();

        if (games.size() < 1) {
            games.add(game);
        }

        return games;
    }

}
