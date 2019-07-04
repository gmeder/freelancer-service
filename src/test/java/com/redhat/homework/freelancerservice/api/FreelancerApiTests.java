package com.redhat.homework.freelancerservice.api;

import static org.mockito.BDDMockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.redhat.homework.freelancerservice.data.Freelancer;
import com.redhat.homework.freelancerservice.data.FreelancerRepository;


@RunWith(SpringRunner.class)
@WebMvcTest(FreelancerApi.class)
public class FreelancerApiTests {
	
	@Autowired
	private MockMvc mvc;
	
	@MockBean
	private FreelancerRepository freelancerRepository;
	
	@Autowired
	ObjectMapper objectMapper;
	
	@Test
	public void testGetFreelancers() throws Exception {
		List<Freelancer> freelancers = new ArrayList<>();
		Freelancer f = new Freelancer();
		f.setFreelancerId(123L);
		f.setFirstName("John");
		f.setLastName("Doe");
		
		Freelancer f2 = new Freelancer();
		f.setFreelancerId(234L);
		f.setFirstName("Jane");
		f.setLastName("Doe");
		
		
		freelancers.add(f);
		freelancers.add(f2);
		
		given(this.freelancerRepository.findAll()).willReturn(freelancers);
		
		mvc.
			perform(get("/freelancers"))
			.andExpect(status().isOk())
			.andExpect(content().contentType("application/json;charset=UTF8"))
			.andExpect(content().json(objectMapper.writeValueAsString(freelancers)));
	}
	
	@Test
	public void testGetFreelancersByIdFound() throws Exception {
		List<Freelancer> freelancers = new ArrayList<>();
		Freelancer f = new Freelancer();
		f.setFreelancerId(123L);
		f.setFirstName("John");
		f.setLastName("Doe");
		
		freelancers.add(f);
		
		long freelancerId = 123L;
		
		given(this.freelancerRepository.findById(freelancerId)).willReturn(Optional.of(f));
		
		mvc.
			perform(get("/freelancers/{freelancerId}",freelancerId))
			.andExpect(status().isOk())
			.andExpect(content().contentType("application/json;charset=UTF8"))
			.andExpect(content().json(objectMapper.writeValueAsString(f)));
	}
	
	@Test
	public void testGetFreelancersByIdNotFound() throws Exception {
		List<Freelancer> freelancers = new ArrayList<>();
		Freelancer f = new Freelancer();
		f.setFreelancerId(123L);
		f.setFirstName("John");
		f.setLastName("Doe");
		
		freelancers.add(f);
		
		long freelancerId = 123L;
		
		given(this.freelancerRepository.findById(freelancerId)).willReturn(Optional.of(f));
		
		mvc.
			perform(get("/freelancers/{freelancerId}",234L))
			.andExpect(status().isNotFound())
			.andExpect(content().string(""));
	}


}
