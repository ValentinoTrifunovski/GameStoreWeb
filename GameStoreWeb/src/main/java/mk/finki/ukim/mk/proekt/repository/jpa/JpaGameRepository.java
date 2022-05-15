package mk.finki.ukim.mk.proekt.repository.jpa;

import mk.finki.ukim.mk.proekt.model.Game;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JpaGameRepository extends JpaRepository<Game,String> {

}
