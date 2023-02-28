package com.turtlemint.TurtleClone;

import com.turtlemint.TurtleClone.model.*;
import com.turtlemint.TurtleClone.repository.CheckoutRepository;
import com.turtlemint.TurtleClone.repository.FWVehicleRepository;
import com.turtlemint.TurtleClone.repository.ProfileRepository;
import com.turtlemint.TurtleClone.repository.QuotationRepository;
import com.turtlemint.TurtleClone.services.CheckoutService;
import com.turtlemint.TurtleClone.services.ProfileService;
import com.turtlemint.TurtleClone.services.QuotationService;

import org.junit.jupiter.api.Test;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.ImportAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.fail;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class TurtleCloneApplicationTests {

	@Autowired
	private QuotationService quotationService;

	@Autowired
	private ProfileService profileService;

	@Autowired
	private CheckoutService checkoutService;

	@MockBean
	private QuotationRepository quotationRepository;

	@MockBean
	private CheckoutRepository checkoutRepository;

	@MockBean
	private ProfileRepository profileRepository;

	@MockBean
	private FWVehicleRepository fwVehicleRepository;

	String reqIdTW1, getReqIdTW2;

	@Test
	void contextLoads() {
	}

	@Test
	public void getAllTWVehiclesTest(){
		Profile profile1 = new Profile("TW", "bajaj", "pulsar");
		Profile profile2 = new Profile("TW", "suzuki", "gixer");
		profileService.addProfile(profile1);
		profileService.addProfile(profile2);
		when(profileRepository.findAll()).thenReturn(Stream.of(profile1, profile2).collect(Collectors.toList()));
		assertEquals(2, profileService.getAllProfiles().size());
	}

	@Test
	public void getAllFWVehiclesTest(){
		FWVehicle fwVehicle1 = new FWVehicle("FW", "suzuki", "baleno");
		FWVehicle fwVehicle2 = new FWVehicle("FW", "hundai", "creta");
		profileService.addFWVehicle(fwVehicle1);
		profileService.addFWVehicle(fwVehicle2);
		when(fwVehicleRepository.findAll()).thenReturn(Stream.of(fwVehicle1, fwVehicle2).collect(Collectors.toList()));
		assertEquals(2, profileService.getAllFWVehicles().size());
	}

	@Test
	public void getTWVehicleByRequestIdTest() {
		Profile profile = new Profile( "TW", "suzuki", "gixer");
		String requestId = profileService.addProfile(profile);
		when(profileRepository.findByRequestId(requestId)).thenReturn(profile);
		assertEquals(profile, profileService.getProfileByRequestId(requestId));
	}

	@Test
	public void getFWVehicleByRequestIdTest() {
		FWVehicle fwVehicle = new FWVehicle("FW", "hundai", "i10");
		String requestId = profileService.addFWVehicle(fwVehicle);
		when(fwVehicleRepository.findByRequestId(requestId)).thenReturn(fwVehicle);
		assertEquals(fwVehicle, profileService.getFWVehicleByByRequestId(requestId));
	}

	@Test
	public void getAllQuotationsTest() {
		Insurer digitTW = new Insurer("digit", "1000");
		Insurer cholTW = new Insurer("chol", "900");
		Insurer hdfcTW = new Insurer("hdfc", "950");

		Insurer digitFW = new Insurer("digit", "7000");
		Insurer cholFW = new Insurer("chol", "7500");
		Insurer hdfcFW = new Insurer("hdfc", "8500");

		Quotation quote1 = new Quotation("TW", "hero", "splendor", new ArrayList<Insurer>(Arrays.asList(digitTW, cholTW, hdfcTW)));
		Quotation quote2 = new Quotation( "FW", "suzuki", "swift", new ArrayList<Insurer>(Arrays.asList(digitFW, cholFW, hdfcFW)));
		quotationService.addQuotation(quote2);
		quotationService.addQuotation(quote1);
		when(quotationRepository.findAll()).thenReturn(Stream.of(quote1, quote2).collect(Collectors.toList()));
		assertEquals(2, quotationService.getAllQuotations().size());
	}

	@Test
	public void getQuotationByRequestIdTest() {
		Insurer digit = new Insurer("digit", "1200");
		Quotation quote = new Quotation( "TW", "bajaj", "ertiga", new ArrayList<Insurer>(Arrays.asList(digit)));
		quotationService.addQuotation(quote);
		String reqId = profileService.addProfile(new Profile("TW", "bajaj", "ertiga"));
		System.out.println(reqId + " new profile created");
		Profile profile = profileRepository.findByRequestId(reqId);
		if(Objects.nonNull(profile)){
			when(quotationRepository.findByVehicleMakeAndVehicleModel(profile.getVehicleMake(), profile.getVehicleModel())).thenReturn(Stream.of(quote).collect(Collectors.toList()));
			assertEquals(1, quotationService.searchByRequestId(reqId).size());

		}
		else {
			fail("Did not create profile");
		}
	}

	@Test
	public void getAllCheckoutsTest() {
		Customer customer1 = new Customer("Shalaka", "826353671536", "vcjvdhjvh@gmail.com");
		Checkout checkout1 = new Checkout( customer1, "542c0348-2625-4c0f-b94f-7a49dc06769d", "digit", "9000");
		//Checkout checkout2 = new Checkout("132123123123455155", "123445155512", "Suraj", "something1@email.com", "8888888888", "chol");
		checkoutService.addCheckout(checkout1);
		when(checkoutRepository.findAll()).thenReturn(Stream.of(checkout1).collect(Collectors.toList()));
		assertEquals(1, checkoutService.getAllCheckouts().size());
	}

	@Test
	public void deleteProfileTest() {
		Profile profile = new Profile("TW", "suzuki", "gixer");
		String requestId = profileService.addProfile(profile);
		profileService.deleteProfile(requestId);
		verify(profileRepository, times(1)).deleteByRequestId(requestId);
	}

	@Test
	public void checkoutByRequestIdTest(){
		Quotation quote = new Quotation( "TW", "bajaj", "ertiga", new ArrayList<Insurer>(Arrays.asList(digit)));
		quotationService.addQuotation(quote);

	}

}
