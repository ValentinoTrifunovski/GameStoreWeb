package mk.finki.ukim.mk.proekt.repository.jpa;

import mk.finki.ukim.mk.proekt.model.Game;
import mk.finki.ukim.mk.proekt.repository.GameRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
public class GameRepositoryImpl implements GameRepository {

    private final JpaGameRepository repository;

    public GameRepositoryImpl(JpaGameRepository repository){
        this.repository = repository;
    }

    @Override
    public Game save(Game game) {
        return this.repository.save(game);
    }

    @Override
    public List<Game> findAll() {
        return (List<Game>) this.repository.findAll();
    }

    @Override
    public List<Game> findByPrice(int price) {

        return this.repository.findAll().stream()
                .filter(game -> game.getPrice() == price)
                .collect(Collectors.toList());

    }

    @Override
    public Optional<Game> findById(String name) {
        return this.repository.findById(name);
    }

    @Override
    public void deleteById(String name) {
        this.repository.deleteById(name);
    }
}
