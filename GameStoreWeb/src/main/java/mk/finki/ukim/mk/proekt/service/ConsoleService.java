package mk.finki.ukim.mk.proekt.service;

import mk.finki.ukim.mk.proekt.exceptions.ConsoleNotFoundException;
import mk.finki.ukim.mk.proekt.model.Console;
import mk.finki.ukim.mk.proekt.model.Game;

import java.util.List;
import java.util.Optional;

public interface ConsoleService {


    Console createConsole(String consoleId, String consoleBrand, String consoleModel, int year);

    Console createConsole(Console c);

    List<Console> getAllConsoles();

    Optional<Console> getConsole(String consoleId);

    Console updateConsole(String consoleId, String consoleBrand, String consoleModel, List<Game> gameList);

    Console updateConsole(String consoleId, Console c);

    void deleteConsole(String consoleId);

    List<Console> searchConsolesNewerThan(int year);

    List<Console> searchConsolesOlderThan(int year);

    List<Console> searchConsoles (String brand, String model, int year);


    List<Game>  searchGamesByConsoleBrandModel (String brand, String model) throws ConsoleNotFoundException;

    List<Game> searchGamesByConsole(String consoleBrand, String consoleModel, int year) throws ConsoleNotFoundException;

    List<Game> searchGamesByConsoleBrand(String consoleBrand);

}
