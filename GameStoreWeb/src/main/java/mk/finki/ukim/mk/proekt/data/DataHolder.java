package mk.finki.ukim.mk.proekt.data;

import lombok.Getter;
import mk.finki.ukim.mk.proekt.model.Console;
import mk.finki.ukim.mk.proekt.model.Game;
import mk.finki.ukim.mk.proekt.model.GameBundle;
import mk.finki.ukim.mk.proekt.model.Users;
import mk.finki.ukim.mk.proekt.repository.jpa.JpaConsoleRepository;
import mk.finki.ukim.mk.proekt.repository.jpa.JpaGameBundleRepository;
import mk.finki.ukim.mk.proekt.repository.jpa.JpaGameRepository;
import mk.finki.ukim.mk.proekt.repository.jpa.JpaUsersRepository;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.*;

@Component
@Getter
public class DataHolder {

    public static final List<Console> CONSOLE_LIST = new ArrayList<>();
    public static final List<Game> GAME_LIST = new ArrayList<>();
    public static final List<GameBundle> GAME_BUNDLE_LIST = new ArrayList<>();
    public static final List<Users> usersList = new ArrayList<>();
    public static final Map<String, Console> consoleMap = new HashMap<>();

    public final JpaConsoleRepository consoleRepository;
    public final JpaGameRepository gameRepository;
    public final JpaGameBundleRepository gameBundleRepository;
    public final JpaUsersRepository usersRepository;


    DataHolder(JpaConsoleRepository consoleRepository, JpaGameRepository gameRepository, JpaGameBundleRepository gameBundleRepository, JpaUsersRepository usersRepository){
        this.consoleRepository = consoleRepository;
        this.gameRepository = gameRepository;
        this.gameBundleRepository = gameBundleRepository;
        this.usersRepository = usersRepository;

    }

    @PostConstruct
    public void init(){

    }

}

