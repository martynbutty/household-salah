package com.martynbutty.householdsalah;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.martynbutty.householdsalah.controllers.MasjidAlController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class HouseholdSalahApplication {

	private static final Logger log = LoggerFactory.getLogger(HouseholdSalahApplication.class);

	public static void main(String[] args) throws JsonProcessingException {
		SpringApplication.run(HouseholdSalahApplication.class, args);

//		HouseholdSalahApplication app = new HouseholdSalahApplication();
//		try{
//			app.run("test");
//		} catch (Exception e) {
//			log.info(e.toString());
//		}

		MasjidAlController app = new MasjidAlController();

	}
}
