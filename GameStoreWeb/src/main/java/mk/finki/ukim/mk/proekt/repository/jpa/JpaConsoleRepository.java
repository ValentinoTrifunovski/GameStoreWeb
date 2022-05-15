package mk.finki.ukim.mk.proekt.repository.jpa;

import mk.finki.ukim.mk.proekt.model.Console;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JpaConsoleRepository extends JpaRepository<Console,String> {
}
