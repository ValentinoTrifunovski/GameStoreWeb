package mk.finki.ukim.mk.proekt.repository;

import mk.finki.ukim.mk.proekt.model.Game;

import java.util.List;
import java.util.Optional;

public interface GameRepository {

    Game save(Game game);

    List<Game> findAll();

    List<Game> findByPrice(int price);

    Optional<Game> findById(String name);

    void deleteById(String name);

}
