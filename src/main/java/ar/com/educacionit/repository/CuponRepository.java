package ar.com.educacionit.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ar.com.educacionit.domain.Cupon;

@Repository
public interface CuponRepository extends JpaRepository<Cupon, Long>{

}
