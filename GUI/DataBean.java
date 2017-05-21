/*
 * @author Yucheng Sun 3508357
 */

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


public class DataBean {
    private String id;
    private String rank;
    private String atheletid;
    private String name;
    private String type;
    private String time;
    private int age;
    private String state;
    private int score;

    public DataBean(String name) {
        this.name = name;
    }

    public DataBean(String id, String name, int age, String state, int score) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.state = state;
        this.score = score;
    }

    public DataBean(String rank, String atheletid, String name, String type, String time) {
        this.rank = rank;
        this.atheletid = atheletid;
        this.name = name;
        this.type = type;
        this.time = time;
    }

    public String getRank() {
        return rank;
    }

    public void setRank(String rank) {
        this.rank = rank;
    }

    public String getAtheletid() {
        return atheletid;
    }

    public void setAtheletid(String atheletid) {
        this.atheletid = atheletid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getTime() {
        
        return String.format("%.1f", Float.valueOf(time));
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }
    
}
