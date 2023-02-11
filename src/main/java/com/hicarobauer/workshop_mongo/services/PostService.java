package com.hicarobauer.workshop_mongo.services;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hicarobauer.workshop_mongo.domain.Post;
import com.hicarobauer.workshop_mongo.repository.PostRepository;
import com.hicarobauer.workshop_mongo.services.exceptions.ObjectNotFoundException;

@Service
public class PostService {

	@Autowired
	private PostRepository repo;
	
	public Post findById(String id) {
		Post post = repo.findById(id).orElse(null);
		if(post == null) {
			throw new ObjectNotFoundException("Objeto não encontrado.");
		}
		return post;
	}
	
	public List<Post> findByTitle(String text){
		return repo.findByTitle(text);
	}
	
	public List<Post> fullSearch(String text, Date minDate, Date maxDate) {
		/*para não considerar o horário de 00:01 desse dia, ele tem que pegar até as 23:59 horas.*/
		maxDate = new Date(maxDate.getTime() + 24 * 60 * 60 * 1000);
		return repo.fullSearch(text, minDate, maxDate);
	}
}
