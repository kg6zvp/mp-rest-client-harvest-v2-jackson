package com.harvestapp.api.v2.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.time.LocalDate;

@Data
@Builder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor
public class HarvestTimeEntryCreateBody {
	/**
	 * The ID of the user to associate with the time entry. Defaults to the currently authenticated user’s ID.
	 */
	@JsonProperty("user_id")
	Long userId;
	/**
	 * The ID of the project to associate with the time entry.
	 */
	@NonNull
	@JsonProperty("project_id")
	Long projectId;
	/**
	 * The ID of the task to associate with the time entry.
	 */
	@NonNull
	@JsonProperty("task_id")
	Long taskId;
	/**
	 * The ISO 8601 formatted date the time entry was spent.
	 */
	@NonNull
	@JsonProperty("spent_date")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	LocalDate spentDate;
	/**
	 * The current amount of time tracked. If provided, the time entry will be created with the specified hours and
	 * is_running will be set to false. If not provided, hours will be set to 0.0 and is_running will be set to true.
	 */
	Double hours;
	/**
	 * Any notes to be associated with the time entry.
	 */
	String notes;
	/*
	 * An object containing the id, group_id, account_id, and permalink of the external reference.
	 */
	//external_reference
}
