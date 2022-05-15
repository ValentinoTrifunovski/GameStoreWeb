package mk.finki.ukim.mk.proekt.web.api;

import mk.finki.ukim.mk.proekt.exceptions.ConsoleNotFoundException;
import mk.finki.ukim.mk.proekt.model.Console;
import mk.finki.ukim.mk.proekt.model.Game;
import mk.finki.ukim.mk.proekt.service.ConsoleService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping(path = "/api/consoles")
public class ConsolesApi {

    private final ConsoleService consoleService;
    public ConsolesApi(ConsoleService consoleService){
        this.consoleService = consoleService;
    }

    @GetMapping
    public List<Console> getAllConsoles(){
        return consoleService.getAllConsoles();
    }

    @GetMapping("/{id}")
    public Optional<Console> getConsole(@PathVariable String id){
        return consoleService.getConsole(id);
    }

    @PutMapping("/{id}")
    public Console updateConsole(@PathVariable String id, @RequestBody Console c){
        return consoleService.updateConsole(id,c);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Console addConsole(@RequestBody Console c){
        return consoleService.createConsole(c);
    }

    @DeleteMapping("/{id}")
    public void deleteConsole(@PathVariable String id){
        consoleService.deleteConsole(id);
    }

    @GetMapping(params = "yearNewer")
    public List<Console> searchNewerThan(@RequestParam int yearNewer)
    {
        return consoleService.searchConsolesNewerThan(yearNewer);
    }
    @GetMapping(params = "yearOlder")
    public List<Console> searchOlderThan(@RequestParam int yearOlder)
    {
        return consoleService.searchConsolesOlderThan(yearOlder);
    }
   @GetMapping(params = {"consoleBrand","consoleModel","year"})
   public List<Game> searchGames(@RequestParam String consoleBrand,
                                @RequestParam String consoleModel,
                                @RequestParam int year) throws ConsoleNotFoundException
   {
       return consoleService.searchGamesByConsole(consoleBrand,consoleModel,year);
   }
   @GetMapping(params = {"consoleBrand","consoleModel"})
   public List<Game> searchConsoleBrandModel(@RequestParam String consoleBrand,
                                          @RequestParam String consoleModel) throws ConsoleNotFoundException
   {
       return consoleService.searchGamesByConsoleBrandModel(consoleBrand,consoleModel);
   }

    @GetMapping(params = {"consoleBrand"})
    public List<Game> searchConsoles(@RequestParam String consoleBrand)
    {
        return consoleService.searchGamesByConsoleBrand(consoleBrand);
    }


}
