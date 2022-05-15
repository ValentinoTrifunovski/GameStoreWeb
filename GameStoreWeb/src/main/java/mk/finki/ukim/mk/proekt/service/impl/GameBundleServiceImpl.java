package mk.finki.ukim.mk.proekt.service.impl;

import mk.finki.ukim.mk.proekt.model.GameBundle;
import mk.finki.ukim.mk.proekt.repository.GameBundleRepository;
import mk.finki.ukim.mk.proekt.service.GameBundleService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class GameBundleServiceImpl implements GameBundleService {

    GameBundleRepository gameBundleRepository;
    GameBundleServiceImpl(GameBundleRepository gameBundleRepository){
        this.gameBundleRepository = gameBundleRepository;
    }

    @Override
    public GameBundle createGameBundle(String name, String description, int price, boolean onStock, String imageUrl) {
        GameBundle gameBundle = new GameBundle(name,description,price,onStock,imageUrl);
        return this.gameBundleRepository.save(gameBundle);
    }

    @Override
    public GameBundle createGameBundle(GameBundle k) {
        return this.gameBundleRepository.save(k);
    }

    @Override
    public List<GameBundle> getAllGameBundles() {
        return gameBundleRepository.findAll();
    }

    @Override
    public List<GameBundle> searchGameBundles(int price) {
        return gameBundleRepository.findByPrice(price);
    }

    @Override
    public List<GameBundle> searchOnStockGameBundles(boolean onStock) {
        return gameBundleRepository.findAll().stream()
                .filter(GameBundle -> GameBundle.isOnStock() == onStock)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<GameBundle> getGameBundle(String name) {
        return gameBundleRepository.findById(name);
    }

    @Override
    public void deleteGameBundle(String name) {
        gameBundleRepository.deleteById(name);
    }

}
