package mk.finki.ukim.mk.proekt.service.impl;

import mk.finki.ukim.mk.proekt.model.Game;
import mk.finki.ukim.mk.proekt.model.GameBundle;
import mk.finki.ukim.mk.proekt.model.Users;
import mk.finki.ukim.mk.proekt.repository.UsersRepository;
import mk.finki.ukim.mk.proekt.service.UsersService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsersServiceImpl implements UsersService {

    UsersRepository usersRepository;
    UsersServiceImpl(UsersRepository usersRepository){
        this.usersRepository = usersRepository;
    }

    @Override
    public Users createUser(Users user) {
        return this.usersRepository.save(user);
    }

    @Override
    public Users createUser(String username, String password) {
        Users user = new Users(username,password);
        return this.usersRepository.save(user);
    }

    @Override
    public List<Users> getAllUsers() {
        return this.usersRepository.getAllUsers();
    }

    @Override
    public Optional<Users> getUser(String username) {
        return this.usersRepository.findById(username);
    }

    @Override
    public Users updateUserGames(String id, String username, String password, Game game, GameBundle gameBundle) {
        Users u = usersRepository.findById(id).orElse(null);
        Users user = null;
        List<Game> gameList;
        List<GameBundle> gameBundleList;
        if(u != null) {

            gameList = u.getGameList();
            gameBundleList = u.getGameBundleList();

            gameList.removeIf(game1 -> game1.getName().equals(game.getName()));
            gameBundleList.removeIf(gameBundle1 -> gameBundle1.getName().equals(gameBundle.getName()));

            user = new Users(u.getUsername(),password, gameList, gameBundleList);
        }
        return this.usersRepository.save(user);
    }

    @Override
    public Users updateUser(String id, String username, String password, Game game, GameBundle gameBundle) {
        Users u = usersRepository.findById(username).orElse(null);

        if(u != null) {

            u.setPassword(password);

            if (!game.getName().equals(""))
                u.addToList(game);

            if (!gameBundle.getName().equals(""))
                u.addGameBundletoList(gameBundle);
        }
        return this.usersRepository.save(u);
    }

    @Override
    public Users updateUser(String username, Users user) {
        Users u = usersRepository.findById(username).orElse(null);
        if(u != null) {
            u.setUsername(user.getUsername());
            u.setPassword(user.getPassword());
        }
        return u;
    }

    @Override
    public void deleteUser(String username) {
         this.usersRepository.deleteById(username);
    }
}
