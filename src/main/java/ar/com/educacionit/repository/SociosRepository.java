package ar.com.educacionit.repository;

import ar.com.educacionit.domain.Socios;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SociosRepository extends JpaRepository<Socios, Long> {
}
