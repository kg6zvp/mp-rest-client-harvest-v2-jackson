package com.harvestapp.api.v2.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

/**
 *
 */
@Data
@Builder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor
public class HarvestProjectTaskAssignment {
	/**
	 * Unique ID for the task assignment.
	 */
	Long id;
	/**
	 * An object containing the id, name, and code of the associated project.
	 */
	HarvestProject project;
	/**
	 * An object containing the id and name of the associated task.
	 */
	HarvestTask task;
	/**
	 * Whether the task assignment is active or archived.
	 */
	@JsonProperty("is_active")
	Boolean isActive;
	/**
	 * Whether the task assignment is billable or not.
	 * For example: if set to true, all time tracked on this project for the associated task will be marked as billable.
	 */
	Boolean billable;
	/**
	 * Rate used when the project's {@link HarvestProject#billBy} is "Tasks"
	 */
	@JsonProperty("hourly_rate")
	Double hourlyRate;
	/**
	 * Budget used when the project's {@link HarvestProject#budgetBy} is "task" or "task_fees".
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
