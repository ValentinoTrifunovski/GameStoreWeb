package mk.finki.ukim.mk.proekt.service;

import mk.finki.ukim.mk.proekt.model.Game;

import java.util.List;
import java.util.Optional;

public interface GameService {
    Game createGame(String name, double size, String description, int price, boolean onStock, String imageUrl);

    Game createGame(Game g);

    List<Game> getAllGames();

    List<Game> searchGames(int price);

    List<Game> searchOnStockGames(boolean onStock);

    Optional<Game> getGame(String name);

    Game updateGame(String name, double size, String description, int price, boolean onStock, String imageUrl);

    Game updateGame(String name, Game k);

    void deleteGame(String name);

    List<Game> searchGameByPrice(int price);

    List<Game> searchGameBySize(Double size);

    List<Game> searchOnStock(boolean onStock);

    List<Game> searchGameByPriceAndSize(int price, Double size);

}
