package mk.finki.ukim.mk.proekt.web.api;

import mk.finki.ukim.mk.proekt.model.Game;
import mk.finki.ukim.mk.proekt.model.GameBundle;
import mk.finki.ukim.mk.proekt.model.Users;
import mk.finki.ukim.mk.proekt.service.UsersService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.CrossOrigin;


import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping(path = "/api/users")
public class UsersApi {

    private final UsersService usersService;
    public UsersApi(UsersService usersService){
        this.usersService = usersService;
    }

    @GetMapping
    public List<Users> getAllUsers(){
        return usersService.getAllUsers();
    }
    @GetMapping("/{id}")
    public Optional<Users> getUser(@PathVariable String id){
        return usersService.getUser(id);
    }

    @PatchMapping("/{id}")
    public Users updateUser(@PathVariable String id,
                            @RequestParam(value = "password", required = false) String password,
                            @RequestParam(value = "gameName", required = false) String gameName,
                            @RequestParam(value = "gameSize", required = false, defaultValue = "1") double gameSize,
                            @RequestParam(value = "gameDescription", required = false) String gameDescription,
                            @RequestParam(value = "gamePrice", required = false, defaultValue = "1") int gamePrice,
                            @RequestParam(value = "gameOnStock", required = false) boolean gameOnStock,
                            @RequestParam(value = "gameImageUrl", required = false) String gameImageUrl,
                            @RequestParam(value = "gamebundleName", required = false) String gamebundleName,
                            @RequestParam(value = "descriptionGamebundle", required = false) String gamebundleDescription,
                            @RequestParam(value = "priceGamebundle", required = false, defaultValue = "1") int gamebundlePrice,
                            @RequestParam(value = "onStockGamebundle", required = false) boolean gamebundleOnStock,
                            @RequestParam(value = "imageUrlGamebundle", required = false) String gamebundleImageUrl){
        return usersService.updateUser(id,id,password,new Game(gameName, gameSize, gameDescription, gamePrice, gameOnStock, gameImageUrl), new GameBundle(gamebundleName,gamebundleDescription,gamebundlePrice,gamebundleOnStock,gamebundleImageUrl));
    }

    @PutMapping("/{id}")
    public Users updateUserGames(@PathVariable String id,
                            @RequestParam(value = "password", required = false) String password,
                            @RequestParam(value = "gameName", required = false) String gameName,
                            @RequestParam(value = "gameSize", required = false, defaultValue = "1") double gameSize,
                            @RequestParam(value = "gameDescription", required = false) String gameDescription,
                            @RequestParam(value = "gamePrice", required = false, defaultValue = "1") int gamePrice,
                            @RequestParam(value = "gameOnStock", required = false) boolean gameOnStock,
                            @RequestParam(value = "gameImageUrl", required = false) String gameImageUrl,
                                @RequestParam(value = "gamebundleName", required = false) String gameBundleName,
                                @RequestParam(value = "gamebundleDescription", required = false) String gamebundleDescription,
                                @RequestParam(value = "gamebundlePrice", required = false, defaultValue = "1") int gamebundlePrice,
                                @RequestParam(value = "gamebundleOnStock", required = false) boolean gamebundleOnStock,
                                @RequestParam(value = "gamebundleImageUrl", required = false) String gamebundleImageUrl){
                                            return usersService.updateUserGames(id,id,password,
                                            new Game(gameName, gameSize, gameDescription, gamePrice, gameOnStock,gameImageUrl),
                                            new GameBundle(gameBundleName, gamebundleDescription, gamebundlePrice, gamebundleOnStock, gamebundleImageUrl));
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Users addUser(@RequestBody Users user){
        return usersService.createUser(user);
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable String id){
        usersService.deleteUser(id);
    }
}
