package mk.finki.ukim.mk.proekt.repository.inmemory;

import mk.finki.ukim.mk.proekt.data.DataHolder;
import mk.finki.ukim.mk.proekt.model.Console;
import mk.finki.ukim.mk.proekt.repository.ConsoleRepository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class inMemoryConsoleRepository implements ConsoleRepository {
    @Override
    public Console save(Console console) {
        this.findById(console.getConsoleId()) .ifPresent(DataHolder.CONSOLE_LIST::remove);
        DataHolder.CONSOLE_LIST.add(console);
        return console;
    }

    @Override
    public List<Console> getAllConsoles() {
        return DataHolder.CONSOLE_LIST;
    }

    @Override
    public List<Console> searchConsoles(String brand) {
        return DataHolder.CONSOLE_LIST.stream()
                .filter(console -> console.getConsoleBrand().equals(brand))
                .collect(Collectors.toList());
    }

    @Override
    public Optional<Console> findById(String consoleId) {
        return DataHolder.CONSOLE_LIST.stream()
                .filter(console -> console.getConsoleId().equals(consoleId))
                .findFirst();
    }

    @Override
    public void saveAll(List<Console> consoleList) {
        DataHolder.CONSOLE_LIST.addAll(consoleList);
    }

    @Override
    public void deleteById(String consoleId) {
        this.findById(consoleId).ifPresent(DataHolder.CONSOLE_LIST::remove);
    }
}
