package mk.finki.ukim.mk.proekt.repository.inmemory;

import mk.finki.ukim.mk.proekt.data.DataHolder;
import mk.finki.ukim.mk.proekt.model.Game;
import mk.finki.ukim.mk.proekt.repository.GameRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


public class inMemoryGameRepository implements GameRepository {
    @Override
    public Game save(Game game) {
        this.findById(game.getName()) .ifPresent(DataHolder.GAME_LIST::remove);
        DataHolder.GAME_LIST.add(game);
        return game;
    }

    @Override
    public List<Game> findAll() {
        return new ArrayList<>(DataHolder.GAME_LIST);
    }

    @Override
    public List<Game> findByPrice(int price) {
        return DataHolder.GAME_LIST.stream()
                .filter(game -> game.getPrice() == price)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<Game> findById(String name) {
        return DataHolder.GAME_LIST.stream()
                .filter(game -> game.getName().equals(name))
                .findFirst();
    }

    @Override
    public void deleteById(String name) {
        this.findById(name).ifPresent(DataHolder.GAME_LIST::remove);
    }
}
