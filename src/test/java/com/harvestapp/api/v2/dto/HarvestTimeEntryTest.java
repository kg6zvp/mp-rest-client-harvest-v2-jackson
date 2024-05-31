package com.harvestapp.api.v2.dto;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import lombok.SneakyThrows;
import org.junit.jupiter.api.Test;

import java.nio.file.Files;
import java.nio.file.Paths;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

public class HarvestTimeEntryTest {
	ObjectMapper om = new ObjectMapper().registerModule(new JavaTimeModule());

	@Test
	@SneakyThrows
	public void shouldDeserializeWithRunningTimer() {
		String json = Files.readString(Paths.get(
			HarvestTimeEntry.class.getClassLoader().getResource("harvest_time_entry.json").toURI()));
		HarvestTimeEntry output = this.om.readValue(json, HarvestTimeEntry.class);
		System.out.println(output.getStartedTime().toString());
	}
}
