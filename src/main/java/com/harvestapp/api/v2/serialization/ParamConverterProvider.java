package com.harvestapp.api.v2.serialization;

import jakarta.ws.rs.ext.ParamConverter;
import jakarta.ws.rs.ext.Provider;

import java.lang.annotation.Annotation;
import java.lang.reflect.Type;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Provider
public class ParamConverterProvider implements jakarta.ws.rs.ext.ParamConverterProvider {
	@Override
	public <T> ParamConverter<T> getConverter(Class<T> rawType, Type genericType, Annotation[] annotations) {
		if (rawType.equals(LocalDateTime.class)) {
			return (ParamConverter<T>) new LocalDateTimeConverter();
		} else if (rawType.equals(LocalDate.class)) {
			return (ParamConverter<T>) new LocalDateConverter();
		}
		return null;
	}

	public static class LocalDateTimeConverter implements ParamConverter<LocalDateTime> {
		@Override
		public LocalDateTime fromString(String value) {
			return LocalDateTime.parse(value, DateTimeFormatter.ISO_DATE_TIME);
		}
		@Override
		public String toString(LocalDateTime value) {
			return DateTimeFormatter.ISO_DATE_TIME.format(value);
		}
	}

	public static class LocalDateConverter implements ParamConverter<LocalDate> {
		@Override
		public LocalDate fromString(String value) {
			return LocalDate.parse(value, DateTimeFormatter.ISO_DATE);
		}
		@Override
		public String toString(LocalDate value) {
			return DateTimeFormatter.ISO_DATE.format(value);
		}
	}
}
