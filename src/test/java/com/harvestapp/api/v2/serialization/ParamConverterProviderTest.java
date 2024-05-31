package com.harvestapp.api.v2.serialization;

import jakarta.ws.rs.ext.ParamConverter;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ParamConverterProviderTest {
	@Nested
	public class LocalDateCnv {
		ParamConverter<LocalDate> subject = new ParamConverterProvider.LocalDateConverter();

		@Test
		public void shouldSerialize() {
			assertEquals("2024-07-15", subject.toString(LocalDate.of(2024, Month.JULY, 15)));
		}
		@Test
		public void shouldDeserialize() {
			assertEquals(LocalDate.of(2024, Month.FEBRUARY, 29), subject.fromString("2024-02-29"));
		}
	}
	@Nested
	public class LocalDateTimeCnv {
		ParamConverter<LocalDateTime> subject = new ParamConverterProvider.LocalDateTimeConverter();

		@Test
		public void shouldSerialize() {
			assertEquals("2024-07-15T10:00:00", subject.toString(LocalDateTime.of(2024, Month.JULY, 15, 10, 00)));
		}
		@Test
		public void shouldDeserialize() {
			assertEquals(LocalDateTime.of(2024, Month.FEBRUARY, 29, 8, 45), subject.fromString("2024-02-29T08:45:00"));
		}
	}
}