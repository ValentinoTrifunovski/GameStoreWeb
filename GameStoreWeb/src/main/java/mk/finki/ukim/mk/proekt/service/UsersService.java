package mk.finki.ukim.mk.proekt.service;

import mk.finki.ukim.mk.proekt.model.Game;
import mk.finki.ukim.mk.proekt.model.GameBundle;
import mk.finki.ukim.mk.proekt.model.Users;

import java.util.List;
import java.util.Optional;

public interface UsersService {

    List<Users> getAllUsers();

    Users createUser(Users user);

    Users createUser(String username, String password);

    Optional<Users> getUser(String username);

    Users updateUser(String username, Users user);

    Users updateUserGames(String id, String username, String password, Game game, GameBundle gameBundle);

    Users updateUser(String id, String username, String password, Game game, GameBundle gameBundle);

    void deleteUser(String username);

}
