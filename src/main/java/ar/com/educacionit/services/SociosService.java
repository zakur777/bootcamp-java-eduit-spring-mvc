package ar.com.educacionit.services;

import ar.com.educacionit.domain.Socios;
import ar.com.educacionit.repository.SociosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SociosService {

    @Autowired
    private SociosRepository repository;

    public List<Socios> findALL() {
        return repository.findAll();
    }

}
