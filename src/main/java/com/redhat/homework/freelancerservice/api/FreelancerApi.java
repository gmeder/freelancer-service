package com.redhat.homework.freelancerservice.api;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.redhat.homework.freelancerservice.data.Freelancer;
import com.redhat.homework.freelancerservice.data.FreelancerRepository;

@RestController
public class FreelancerApi {

	private FreelancerRepository freelancerRepository;

	@Autowired
	public FreelancerApi(FreelancerRepository freelancerRepository) {
		this.freelancerRepository = freelancerRepository;
	}

	@GetMapping("/freelancers")
	public List<Freelancer> getFreelancers() {
		List<Freelancer> freelancers = new ArrayList<>();
		Iterator<Freelancer> iterator = freelancerRepository.findAll().iterator();
		while (iterator.hasNext()) {
			freelancers.add(iterator.next());
		}
		return freelancers;
	}

	@GetMapping("/freelancers/{freelancerId}")
	public ResponseEntity<Freelancer> getFreelancersById(@PathVariable("freelancerId") Long freelancerId) {
		Optional<Freelancer> optional = freelancerRepository.findById(freelancerId);
		if (optional.isPresent()) {
			return new ResponseEntity<Freelancer>(optional.get(),HttpStatus.OK);
		} else {
			return new ResponseEntity<Freelancer>(HttpStatus.NOT_FOUND);
		}

	}

}
