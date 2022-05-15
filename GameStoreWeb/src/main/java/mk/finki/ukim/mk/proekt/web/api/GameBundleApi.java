package mk.finki.ukim.mk.proekt.web.api;

import mk.finki.ukim.mk.proekt.model.GameBundle;
import mk.finki.ukim.mk.proekt.service.GameBundleService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping(path = "/api/gameBundles")
public class GameBundleApi {

    private final GameBundleService service;
    public GameBundleApi(GameBundleService service)
    {
        this.service = service;
    }

    @GetMapping
    public List<GameBundle> getAllGameBundles(){
        return service.getAllGameBundles();
    }

    @GetMapping("/{id}")
    public Optional<GameBundle> getGameBundle(@PathVariable String id){
        return service.getGameBundle(id);
    }

    @DeleteMapping("/{id}")
    public void deleteGameBundle(@PathVariable String id){
        service.deleteGameBundle(id);
    }

    @GetMapping(params = "price")
    public List<GameBundle> searchByPrice(@RequestParam int price)
    {
        return service.searchGameBundles(price);
    }

    @GetMapping(params = "onStock")
    public List<GameBundle> searchOnStock(@RequestParam boolean onStock)
    {
        return service.searchOnStockGameBundles(onStock);
    }

}

