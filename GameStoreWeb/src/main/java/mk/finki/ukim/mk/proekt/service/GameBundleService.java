package mk.finki.ukim.mk.proekt.service;

import mk.finki.ukim.mk.proekt.model.GameBundle;

import java.util.List;
import java.util.Optional;

public interface GameBundleService {
    GameBundle createGameBundle(String name, String description, int price, boolean onStock, String imageUrl);

    GameBundle createGameBundle(GameBundle g);

    List<GameBundle> getAllGameBundles();

    List<GameBundle> searchGameBundles(int price);

    List<GameBundle> searchOnStockGameBundles (boolean onStock);

    Optional<GameBundle> getGameBundle(String name);

    void deleteGameBundle(String name);
}
