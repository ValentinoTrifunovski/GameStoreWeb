package mk.finki.ukim.mk.proekt.repository.jpa;

import mk.finki.ukim.mk.proekt.model.GameBundle;
import mk.finki.ukim.mk.proekt.repository.GameBundleRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
public class GameBundleRepositoryImpl implements GameBundleRepository {

    private final JpaGameBundleRepository repository;

    public GameBundleRepositoryImpl(JpaGameBundleRepository repository){
        this.repository = repository;
    }

    @Override
    public GameBundle save(GameBundle gameBundle) {
        return this.repository.save(gameBundle);
    }

    @Override
    public List<GameBundle> findAll() {
        return (List<GameBundle>) this.repository.findAll();
    }

    @Override
    public List<GameBundle> findByPrice(int price) {

        return this.repository.findAll().stream()
                .filter(game -> game.getPrice() == price)
                .collect(Collectors.toList());

    }

    @Override
    public Optional<GameBundle> findById(String name) {
        return this.repository.findById(name);
    }

    @Override
    public void deleteById(String name) {
        this.repository.deleteById(name);
    }
}

