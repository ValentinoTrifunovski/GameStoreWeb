package mk.finki.ukim.mk.proekt.repository.jpa;

import mk.finki.ukim.mk.proekt.model.Console;
import mk.finki.ukim.mk.proekt.repository.ConsoleRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class ConsoleRepositoryImpl implements ConsoleRepository {

    private final JpaConsoleRepository consoleRepository;

    public ConsoleRepositoryImpl(JpaConsoleRepository consoleRepository){
        this.consoleRepository = consoleRepository;
    }

    @Override
    public Console save(Console console) {
        return this.consoleRepository.save(console);
    }

    @Override
    public List<Console> getAllConsoles() {
        return this.consoleRepository.findAll();
    }

    @Override
    public List<Console> searchConsoles(String name) {
        return null;
    }

    @Override
    public Optional<Console> findById(String consoleId) {
        return this.consoleRepository.findById(consoleId);
    }

    @Override
    public void saveAll(List<Console> consoleList) {
         this.consoleRepository.saveAll(consoleList);
    }

    @Override
    public void deleteById(String consoleId) {
         this.consoleRepository.deleteById(consoleId);
    }
}
