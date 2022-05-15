package mk.finki.ukim.mk.proekt.repository.jpa;

import mk.finki.ukim.mk.proekt.model.GameBundle;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JpaGameBundleRepository extends JpaRepository<GameBundle,String> {
}
