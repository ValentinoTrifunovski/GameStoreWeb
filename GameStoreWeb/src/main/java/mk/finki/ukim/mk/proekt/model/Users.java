package mk.finki.ukim.mk.proekt.model;

import lombok.Data;
import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
public class Users {

    @Id
    @Column
    private String username;

    @Column
    private String password;

    @Cascade(org.hibernate.annotations.CascadeType.ALL)
    @ManyToMany
    @Column
    private List<Game> gameList;

    @Cascade(org.hibernate.annotations.CascadeType.ALL)
    @ManyToMany
    @Column
    private List<GameBundle> gameBundleList;

    public Users(String username, String password){
        this.username = username;
        this.password = password;
    }

    public Users(String username, String password, List<Game> gameList, List<GameBundle> gameBundleList){
        this.username = username;
        this.password = password;
        this.gameList = gameList;
        this.gameBundleList = gameBundleList;
    }

    public Users(){}

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Game> getGameList() {
        return gameList;
    }

    public void setGameList(List<Game> gameList) {
        this.gameList = gameList;
    }

    public List<GameBundle> getGameBundleList() {
        return gameBundleList;
    }

    public void setGameBundleList(List<GameBundle> gameBundleList) {
        this.gameBundleList = gameBundleList;
    }

    public void addToList(Game game){
        gameList.add(game);
    }

    public void addGameBundletoList(GameBundle gameBundle){
        gameBundleList.add(gameBundle);}

    public void removeFromList(Game game){
        gameList.remove(game);
    }
}
