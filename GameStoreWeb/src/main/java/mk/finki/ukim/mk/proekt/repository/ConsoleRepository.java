package mk.finki.ukim.mk.proekt.repository;

import mk.finki.ukim.mk.proekt.model.Console;

import java.util.List;
import java.util.Optional;

public interface ConsoleRepository {

    Console save(Console console);

    List<Console> getAllConsoles();

    List<Console> searchConsoles(String name);

    Optional<Console> findById(String consoleId);

    void saveAll(List<Console> consoleList);

    void deleteById(String consoleId);

}
