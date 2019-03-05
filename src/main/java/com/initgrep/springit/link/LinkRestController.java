package com.initgrep.springit.link;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/link")
public class LinkRestController {

//	private LinkRepository repository;
//
//	@Autowired
//	public LinkRestController(LinkRepository repository) {
//		super();
//		this.repository = repository;
//	}
//	
//	
//	@GetMapping
//	public List<Link> list(){
//		return repository.findAll();
//	}
//	
//	@PostMapping
//	public Link create(@RequestBody Link link){
//		return repository.save(link);
//	}
//	
//	@GetMapping("/{id}")
//	public Optional<Link> read(@PathVariable Long id) {
//		return repository.findById(id);
//	}
//	
//	@PutMapping
//	public Link update(@RequestBody Link link) {
//		return repository.save(link);
//		
//	}
//	
//	@DeleteMapping("/{id}")
//	public void delete(@PathVariable Long id) {
//		repository.deleteById(id);
//	}
	
}
