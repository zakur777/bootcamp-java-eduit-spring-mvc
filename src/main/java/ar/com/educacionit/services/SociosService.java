package ar.com.educacionit.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.com.educacionit.domain.Socios;
import ar.com.educacionit.repository.SociosRepository;

@Service
public class SociosService {

	//D.I
    @Autowired
    private SociosRepository repository;

	public List<Socios> buscarTodos() {
		return this.repository.findAll();
    }
}
