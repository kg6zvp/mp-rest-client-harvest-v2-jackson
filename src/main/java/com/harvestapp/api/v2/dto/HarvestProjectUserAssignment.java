package com.harvestapp.api.v2.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Data
@Builder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor
public class HarvestProjectUserAssignment {
	/**
	 * Unique ID for the user assignment.
	 */
	Long id;
	/**
	 * An object containing the id, name, and code of the associated project.
	 */
	HarvestProject project;
	/**
	 * An object containing the project’s client id and name.
	 */
	HarvestClient client;
	/**
	 * Array of task assignment objects associated with the project.
	 */
	@JsonProperty("task_assignments")
	List<HarvestProjectTaskAssignment> taskAssignments;
	/**
	 * An object containing the id and name of the associated user.
	 */
	HarvestUser user;
	/**
	 * Whether the user assignment is active or archived.
	 */
	@JsonProperty("is_active")
	Boolean isActive;
	/**
	 * Determines if the user has Project Manager permissions for the project.
	 */
	@JsonProperty("is_project_manager")
	Boolean isProjectManager;
	/**
	 * Determines which billable rate(s) will be used on the project for this user when {@link HarvestProject#billBy}
	 * is "People".
	 *
	 * When true, the project will use the user’s default billable rates.
	 * When false, the project will use the custom rate defined on this user assignment.
	 */
	@JsonProperty("use_default_rates")
	Boolean useDefaultRates;
	/**
	 * Custom rate used when the projects {@link HarvestProject#billBy} is "People" and {@link #useDefaultRates} is false.
	 */
	@JsonProperty("hourly_rate")
	Double hourlyRate;
	/**
	 * Budget used when the project's {@link HarvestProject#budgetBy} is "person".
	 */
	Double budget;
	/**
	 * Date and time the project was created.
	 */
	@JsonProperty("created_at")
	LocalDateTime createdAt;
	/**
	 * Date and time the project was last updated.
	 */
	@JsonProperty("updated_at")
	LocalDateTime updatedAt;
}
