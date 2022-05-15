package mk.finki.ukim.mk.proekt.repository;

import mk.finki.ukim.mk.proekt.model.GameBundle;

import java.util.List;
import java.util.Optional;

public interface GameBundleRepository {

    GameBundle save(GameBundle gameBundle);

    List<GameBundle> findAll();

    List<GameBundle> findByPrice(int price);

    Optional<GameBundle> findById(String name);

    void deleteById(String name);


}
