package mk.finki.ukim.mk.proekt.service.impl;

import mk.finki.ukim.mk.proekt.model.Game;
import mk.finki.ukim.mk.proekt.repository.GameRepository;
import mk.finki.ukim.mk.proekt.service.GameService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class GameServiceImpl implements GameService {

    GameRepository gameRepository;
    GameServiceImpl(GameRepository gameRepository){
        this.gameRepository = gameRepository;
    }

    @Override
    public Game createGame(String name, double size, String description, int price, boolean onStock, String imageUrl) {
        Game game = new Game(name,size,description,price,onStock,imageUrl);
        return this.gameRepository.save(game);
    }

    @Override
    public Game createGame(Game g) {
        return this.gameRepository.save(g);
    }

    @Override
    public List<Game> getAllGames() {
        return gameRepository.findAll();
    }

    @Override
    public List<Game> searchGames(int price) {
        return gameRepository.findByPrice(price);
    }

    @Override
    public List<Game> searchOnStockGames(boolean onStock) {
        return gameRepository.findAll().stream()
                .filter(game -> game.isOnStock() == onStock)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<Game> getGame(String name) {
        return gameRepository.findById(name);
    }

    @Override
    public List<Game> searchGameBySize(Double size) {
        return gameRepository.findAll().stream()
                .filter(game -> game.getSize() == size)
                .collect(Collectors.toList());
    }

    @Override
    public List<Game> searchGameByPrice(int price) {
        return gameRepository.findAll().stream()
                .filter(game -> game.getPrice() == price)
                .collect(Collectors.toList());
    }

    @Override
    public List<Game> searchOnStock(boolean onStock) {
        return gameRepository.findAll().stream()
                .filter(game -> game.isOnStock() == onStock)
                .collect(Collectors.toList());
    }

    @Override
    public List<Game> searchGameByPriceAndSize(int price, Double size) {
        return gameRepository.findAll().stream()
                .filter(game -> game.getPrice()==price && game.getSize()==size)
                .collect(Collectors.toList());
    }

    @Override
    public Game updateGame(String name, double size, String description, int price, boolean onStock, String imageUrl) {
        Game game = gameRepository.findById(name).orElse(null);
        if(game != null) {
            game.setSize(size);
            game.setDescription(description);
            game.setPrice(price);
            game.setOnStock(onStock);
            game.setImageUrl(imageUrl);
        }
        return game;
    }

    @Override
    public Game updateGame(String name, Game g) {
        Game game = gameRepository.findById(name).orElse(null);
        if(game != null) {
            game.setSize(g.getSize());
            game.setDescription(g.getDescription());
            game.setPrice(g.getPrice());
            game.setOnStock(g.isOnStock());
        }
        return game;
    }

    @Override
    public void deleteGame(String name) {
        gameRepository.deleteById(name);
    }
}
