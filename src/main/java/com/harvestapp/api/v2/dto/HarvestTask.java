package com.harvestapp.api.v2.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

/**
 * Describes a task a user can be assigned in Harvest. This takes the form of the "Task" selection in the "Add Task",
 * which is the third option. The dropdowns are as follows: "Client", "Project", "Task"
 */
@Data
@Builder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor
public class HarvestTask {
	/**
	 * Unique ID for the task.
	 */
	Long id;
	/**
	 * The name of the task.
	 */
	String name;
	/**
	 * Used in determining whether default tasks should be marked billable when creating a new project.
	 */
	@JsonProperty("billable_by_default")
	Boolean billableByDefault;
	/**
	 * The hourly rate to use for this task when it is added to a project.
	 */
	@JsonProperty("default_hourly_rate")
	Double defaultHourlyRate;
	/**
	 * Whether this task should be automatically added to future projects.
	 */
	@JsonProperty("is_default")
	Boolean isDefault;
	/**
	 * Whether this task is active or archived.
	 */
	@JsonProperty("is_active")
	Boolean isActive;
	/**
	 * Date and time the task was created.
	 */
	@JsonProperty("created_at")
	LocalDateTime createdAt;
	/**
	 * Date and time the task was last updated.
	 */
	@JsonProperty("updated_at")
	LocalDateTime updatedAt;
}
