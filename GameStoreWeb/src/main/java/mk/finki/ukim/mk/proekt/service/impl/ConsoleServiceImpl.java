package mk.finki.ukim.mk.proekt.service.impl;

import mk.finki.ukim.mk.proekt.exceptions.ConsoleNotFoundException;
import mk.finki.ukim.mk.proekt.model.Console;
import mk.finki.ukim.mk.proekt.model.Game;
import mk.finki.ukim.mk.proekt.repository.ConsoleRepository;
import mk.finki.ukim.mk.proekt.repository.GameRepository;
import mk.finki.ukim.mk.proekt.service.ConsoleService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ConsoleServiceImpl implements ConsoleService {

    ConsoleRepository consoleRepository;
    GameRepository gameRepository;
    ConsoleServiceImpl(ConsoleRepository consoleRepository, GameRepository gameRepository){
        this.consoleRepository = consoleRepository;
        this.gameRepository = gameRepository;
    }

    @Override
    public List<Console> searchConsoles(String consoleBrand, String consoleModel, int year) {
        return this.consoleRepository.getAllConsoles().stream()
                .filter(console -> console.getConsoleBrand().equals(consoleBrand)
                        && console.getConsoleModel().equals(consoleModel)
                        && console.getYear() == year)
                .collect(Collectors.toList());
    }

    @Override
    public List<Game> searchGamesByConsoleBrandModel(String consoleBrand, String consoleModel) throws ConsoleNotFoundException {

        List<Console> consoles =  this.consoleRepository.getAllConsoles().stream()
                .filter(console -> console.getConsoleBrand().equals(consoleBrand)
                        && console.getConsoleModel().equals(consoleModel)).collect(Collectors.toList());

        return consoles.stream()
                .flatMap(console -> console.getGameList().stream())
                .collect(Collectors.toList());
    }

    @Override
    public List<Game> searchGamesByConsole(String consoleBrand, String consoleModel, int year) throws ConsoleNotFoundException {

        Console console1 =  this.consoleRepository.getAllConsoles().stream()
                .filter(console -> console.getConsoleBrand().equals(consoleBrand)
                        && console.getConsoleModel().equals(consoleModel)
                        && console.getYear() == year).findFirst().orElse(this.consoleRepository.getAllConsoles().get(0));
        return console1.getGameList();

    }

    @Override
    public List<Game> searchGamesByConsoleBrand(String consoleBrand) {

        List<Console> filteredConsoles;

        filteredConsoles = this.consoleRepository.getAllConsoles().stream()
                .filter(console -> console.getConsoleBrand().equals(consoleBrand))
                .collect(Collectors.toList());

        return filteredConsoles.stream()
                .flatMap(console -> console.getGameList().stream())
                .collect(Collectors.toList());

    }

    @Override
    public List<Console> searchConsolesNewerThan(int year) {
        return this.consoleRepository.getAllConsoles().stream()
                .filter(console -> console.getYear() > year)
                .collect(Collectors.toList());
    }

    @Override
    public List<Console> searchConsolesOlderThan(int year) {
        return this.consoleRepository.getAllConsoles().stream()
                .filter(console -> console.getYear() < year)
                .collect(Collectors.toList());
    }


    @Override
    public Console createConsole(String consoleId, String brand, String model, int year) {
        Console console = new Console(consoleId, brand, model,year);
        return this.consoleRepository.save(console);
    }

    @Override
    public Console createConsole(Console c) {
        return this.consoleRepository.save(c);
    }

    @Override
    public List<Console> getAllConsoles() {
        return this.consoleRepository.getAllConsoles();
    }

    @Override
    public Optional<Console> getConsole(String consoleId) {
        return this.consoleRepository.findById(consoleId);
    }

    @Override
    public Console updateConsole(String id, String brand, String model, List<Game> gameList) {
        Console console = this.consoleRepository.findById(id).orElse(null);
        if (console != null){
            console.setConsoleId(id);
            console.setConsoleBrand(brand);
            console.setConsoleModel(model);
            console.setGameList(gameList);
        }
        return console;
    }

    @Override
    public Console updateConsole(String carId, Console c) {
        Console console = this.consoleRepository.findById(carId).orElse(null);
        if (console != null){
            console.setConsoleBrand(c.getConsoleBrand());
            console.setConsoleModel(c.getConsoleModel());
            console.setGameList(c.getGameList());
        }
        return console;
    }

    @Override
    public void deleteConsole(String consoleId) {
        this.consoleRepository.deleteById(consoleId);
    }
}
