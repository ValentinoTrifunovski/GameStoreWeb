package mk.finki.ukim.mk.proekt.web.api;

import mk.finki.ukim.mk.proekt.model.Game;
import mk.finki.ukim.mk.proekt.service.GameService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping(path = "/api/games")
public class GameApi {

    private final GameService gameService;
    public GameApi(GameService gameService){
        this.gameService = gameService;
    }

    @GetMapping
    public List<Game> getAllGames(){
        return gameService.getAllGames();
    }

    @GetMapping("/{id}")
    public Optional<Game> getGame(@PathVariable String id){
        return gameService.getGame(id);
    }

    @PutMapping("/{id}")
    public Game updateGame(@PathVariable String id, @RequestBody Game g){
        return gameService.updateGame(id,g);
    }
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Game addGame(@RequestBody Game g){
        return gameService.createGame(g);
    }

    @DeleteMapping("/{id}")
    public void deleteGame(@PathVariable String id){
         gameService.deleteGame(id);
    }

    @GetMapping(params = "price")
    public List<Game> searchByPrice(@RequestParam int price)
    {
        return gameService.searchGameByPrice(price);
    }

    @GetMapping(params = "size")
    public List<Game> searchBySize(@RequestParam Double size)
    {
        return gameService.searchGameBySize(size);
    }

    @GetMapping(params = "onStock")
    public List<Game> searchOnStock(@RequestParam boolean onStock)
    {
        return gameService.searchOnStock(onStock);
    }

    @GetMapping(params = {"size","price"})
    public List<Game> searchBySizeAndPrice(@RequestParam (required = false) Double size,
                                           @RequestParam int price)
    {
        return gameService.searchGameByPriceAndSize(price,size);
    }


}
