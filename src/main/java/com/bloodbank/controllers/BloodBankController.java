package com.bloodbank.controllers;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bloodbank.exceptions.BloodNotFoundException;
import com.bloodbank.model.BloodBankDTO;
import com.bloodbank.service.IBloodBankService;

@RestController
@RequestMapping("bloodbank-api/v1")
public class BloodBankController {
	@Autowired
	private IBloodBankService bloodBankService;

	//http://localhost:8080/bloodbank-api/v1/admin/bloodbanks
	@CrossOrigin("http://localhost:4200/")
	@PostMapping("/admin/bloodbanks")
	ResponseEntity<Void> addBloodBank(@RequestBody BloodBankDTO bloodBankDTO)
	{
		//System.out.println(bloodBankDTO.getA_Post());
		bloodBankService.addBloodBank(bloodBankDTO);
		return ResponseEntity.status(HttpStatus.CREATED).build();
	}
	
	//http://localhost:8080/bloodbank-api/v1/admin/updatebloodbank
	@CrossOrigin("http://localhost:4200/")
	@PutMapping("/admin/updatebloodbank")
	ResponseEntity<BloodBankDTO> updateBloodBank(@RequestBody BloodBankDTO bloodBankDTO)
	{
		BloodBankDTO bloodBankDto= bloodBankService.updateBloodBank(bloodBankDTO);
		HttpHeaders headers=new HttpHeaders();
		headers.add("desc","Getting the list of blood bank");
		return ResponseEntity.accepted().headers(headers).body(bloodBankDto);
	}
	
	//http://localhost:8080/bloodbank-api/v1/admin/bloodbankid/10
	@CrossOrigin("http://localhost:4200/")
	@DeleteMapping("/admin/bloodbankid/{bloodbankId}")
	ResponseEntity<Void> deleteBloodBank(@PathVariable("bloodbankId") int bloodbankId)
	{
		bloodBankService.deleteBloodBank(bloodbankId);
		return ResponseEntity.status(HttpStatus.ACCEPTED).build();
	}
	
	
	//http://localhost:8080/bloodbank-api/v1/bloodbank
	@CrossOrigin("http://localhost:4200/")
	@GetMapping("/bloodbank")
	ResponseEntity<List<BloodBankDTO>> getAll() throws BloodNotFoundException {
		List<BloodBankDTO> bloodBankDTO= bloodBankService.getAll();
		HttpHeaders headers=new HttpHeaders();
		headers.add("desc","Getting the list of blood bank");
		headers.add("time retrieved", LocalDateTime.now().toString());
		ResponseEntity<List<BloodBankDTO>> responseEntity=new ResponseEntity<List<BloodBankDTO>>(bloodBankDTO,headers,HttpStatus.OK);
		return responseEntity;
		
	}
	
	//http://localhost:8080/bloodbank-api/v1/bloodbank/bloodbankid/11
	@CrossOrigin("http://localhost:4200/")
	@GetMapping("/bloodbank/bloodbankid/{bloodbankId}")
	ResponseEntity<BloodBankDTO> getById(@PathVariable("bloodbankId") int bloodbankId) throws BloodNotFoundException
	{
		BloodBankDTO bloodBankDTO=bloodBankService.findById(bloodbankId);
		return ResponseEntity.ok().body(bloodBankDTO);
	}
	
	//http://localhost:8080/bloodbank-api/v1/bloodbank/A_Post/1
	@CrossOrigin("http://localhost:4200/")
	@GetMapping("/bloodbank/A_Post/{bloodUnits}")
	ResponseEntity<List<BloodBankDTO>> findAPostGreaterThan(@PathVariable("bloodUnits") int bloodUnits) throws BloodNotFoundException
	{
		List<BloodBankDTO> bloodBankDTO=bloodBankService.findAPostGreaterThan(bloodUnits);
		return ResponseEntity.ok().body(bloodBankDTO);
	}
	
	//http://localhost:8080/bloodbank-api/v1/bloodbank/A_Neg/1
	@CrossOrigin("http://localhost:4200/")
	@GetMapping("/bloodbank/A_Neg/{bloodUnits}")
	ResponseEntity<List<BloodBankDTO>> findANegGreaterThan(@PathVariable("bloodUnits") int bloodUnits) throws BloodNotFoundException
	{
		List<BloodBankDTO> bloodBankDTO=bloodBankService.findANegGreaterThan(bloodUnits);
		return ResponseEntity.ok().body(bloodBankDTO);
	}
	
	//http://localhost:8080/bloodbank-api/v1/bloodbank/B_Post/1
	@CrossOrigin("http://localhost:4200/")
	@GetMapping("/bloodbank/B_Post/{bloodUnits}")
	ResponseEntity<List<BloodBankDTO>> findBPostGreaterThan(@PathVariable("bloodUnits") int bloodUnits) throws BloodNotFoundException
	{
		List<BloodBankDTO> bloodBankDTO=bloodBankService.findBPostGreaterThan(bloodUnits);
		return ResponseEntity.ok().body(bloodBankDTO);
	}
	
	//http://localhost:8080/bloodbank-api/v1/bloodbank/B_Neg/5
	@CrossOrigin("http://localhost:4200/")
	@GetMapping("/bloodbank/B_Neg/{bloodUnits}")
	ResponseEntity<List<BloodBankDTO>> findBNegGreaterThan(@PathVariable("bloodUnits") int bloodUnits) throws BloodNotFoundException
	{
		List<BloodBankDTO> bloodBankDTO=bloodBankService.findBNegGreaterThan(bloodUnits);
		return ResponseEntity.ok().body(bloodBankDTO);
	}
	
	//http://localhost:8080/bloodbank-api/v1/bloodbank/O_Post/5
	@CrossOrigin("http://localhost:4200/")
	@GetMapping("/bloodbank/O_Post/{bloodUnits}")
	ResponseEntity<List<BloodBankDTO>> findOPostGreaterThan(@PathVariable("bloodUnits") int bloodUnits) throws BloodNotFoundException
	{
		List<BloodBankDTO> bloodBankDTO=bloodBankService.findOPostGreaterThan(bloodUnits);
		return ResponseEntity.ok().body(bloodBankDTO);
	}
	
	//http://localhost:8080/bloodbank-api/v1/bloodbank/O_Neg/3
	@CrossOrigin("http://localhost:4200/")
	@GetMapping("/bloodbank/O_Neg/{bloodUnits}")
	ResponseEntity<List<BloodBankDTO>> findONegGreaterThan(@PathVariable("bloodUnits") int bloodUnits) throws BloodNotFoundException
	{
		List<BloodBankDTO> bloodBankDTO=bloodBankService.findONegGreaterThan(bloodUnits);
		return ResponseEntity.ok().body(bloodBankDTO);
	}
	
	//http://localhost:8080/bloodbank-api/v1/bloodbank/AB_Post/1
	@CrossOrigin("http://localhost:4200/")
	@GetMapping("/bloodbank/AB_Post/{bloodUnits}")
	ResponseEntity<List<BloodBankDTO>> findABPostGreaterThan(@PathVariable("bloodUnits") int bloodUnits) throws BloodNotFoundException
	{
		List<BloodBankDTO> bloodBankDTO=bloodBankService.findABPostGreaterThan(bloodUnits);
		return ResponseEntity.ok().body(bloodBankDTO);
	}
	
	//http://localhost:8080/bloodbank-api/v1/bloodbank/AB_Neg/4
	@CrossOrigin("http://localhost:4200/")
	@GetMapping("/bloodbank/AB_Neg/{bloodUnits}")
	ResponseEntity<List<BloodBankDTO>> findABNegGreaterThan(@PathVariable("bloodUnits") int bloodUnits) throws BloodNotFoundException
	{
		List<BloodBankDTO> bloodBankDTO=bloodBankService.findABNegGreaterThan(bloodUnits);
		return ResponseEntity.ok().body(bloodBankDTO);
	}
}
