package mk.finki.ukim.mk.proekt.model;

import java.util.ArrayList;
import java.util.List;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Console {

    @Id
    String consoleId;

    @OneToMany(mappedBy = "console",cascade = CascadeType.ALL)
    private List<Game> gameList;

    @Column
    private String consoleBrand;
    @Column
    private String consoleModel;
    @Column
    private int year;

    public Console(){
        gameList = new ArrayList<>();
    }

    public Console(String consoleId, String consoleBrand, String consoleModel, int year){
        this.consoleId = consoleId;
        this.consoleBrand = consoleBrand;
        this.consoleModel = consoleModel;
        this.year = year;

    }

    public void addGame(Game game){
        gameList.add(game);
    }

    public String getConsoleId() {
        return consoleId;
    }

    public void setConsoleId(String consoleId) {
        this.consoleId = consoleId;
    }

    public List<Game> getGameList() {
        return gameList;
    }

    public void setGameList(List<Game> gameList) {
       this.gameList = gameList;
    }

    public String getConsoleBrand() {
        return consoleBrand;
    }

    public void setConsoleBrand(String consoleBrand) {
        this.consoleBrand = consoleBrand;
    }

    public String getConsoleModel() {
        return consoleModel;
    }

    public void setConsoleModel(String consoleModel) {
        this.consoleModel = consoleModel;
    }
    
    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

}
