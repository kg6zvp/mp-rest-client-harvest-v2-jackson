package com.harvestapp.api.v2.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

@Data
@Builder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor
public class HarvestTimeEntry {
	/**
	 * Unique ID for the time entry.
	 */
	Long id;
	/**
	 * Date of the time entry.
	 */
	@JsonProperty("spent_date")
	LocalDate spentDate;
	/**
	 * Number of (decimal time) hours tracked in this time entry.
	 */
	Double hours;
	/**
	 * Number of (decimal time) hours already tracked in this time entry, before the timer was last started.
	 */
	@JsonProperty("hours_without_timer")
	Double hoursWithoutTimer;
	/**
	 * Number of (decimal time) hours tracked in this time entry used in summary reports and invoices. This value is
	 * rounded according to the Time Rounding setting in your Preferences.
	 */
	@JsonProperty("rounded_hours")
	Double roundedHours;
	/**
	 * Notes attached to the time entry.
	 */
	String notes; // timer name in Harvest
	/**
	 * Whether or not the time entry has been locked.
	 */
	@JsonProperty("is_locked")
	Boolean isLocked;
	/**
	 * Why the time entry has been locked.
	 */
	@JsonProperty("locked_reason")
	String lockedReason;
	/**
	 * Whether or not the time entry has been approved via Timesheet Approval.
	 */
	@JsonProperty("is_closed")
	Boolean isClosed;
	/**
	 * Whether or not the time entry has been marked as invoiced.
	 */
	@JsonProperty("is_billed")
	Boolean isBilled;
	/**
	 * Date and time the running timer was started (if tracking by duration). Use the ISO 8601 Format.
	 * Returns null for stopped timers.
	 */
	@JsonProperty("timer_started_at")
	LocalDateTime timerStartedAt;
	/**
	 * Time the time entry was started (if tracking by start/end times).
	 */
	@JsonProperty("started_time")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "h:mma", with = {JsonFormat.Feature.ACCEPT_CASE_INSENSITIVE_VALUES})
	LocalTime startedTime;
	/**
	 * Time the time entry was ended (if tracking by start/end times).
	 */
	@JsonProperty("ended_time")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "h:mma", with = {JsonFormat.Feature.ACCEPT_CASE_INSENSITIVE_VALUES})
	LocalTime endedTime;
	/**
	 * Whether or not the time entry is currently running.
	 */
	@JsonProperty("is_running")
	Boolean isRunning;
	/**
	 * Whether or not the time entry is billable.
	 */
	@JsonProperty("billable")
	Boolean billable;
	/**
	 * Whether or not the time entry counts towards the project budget.
	 */
	@JsonProperty("budgeted")
	Boolean budgeted;
	/**
	 * The billable rate for the time entry.
	 */
	@JsonProperty("billable_rate")
	Double billableRate;
	/**
	 * The cost rate for the time entry.
	 */
	@JsonProperty("cost_rate")
	Double costRate;
	/**
	 * Date and time the time entry was created. Use the ISO 8601 Format.
	 */
	@JsonProperty("created_at")
	LocalDateTime createdAt;
	/**
	 * Date and time the time entry was last updated. Use the ISO 8601 Format.
	 */
	@JsonProperty("updated_at")
	LocalDateTime updatedAt;

	/**
	 * An object containing the id and name of the associated user.
	 */
	HarvestUser user;
	/**
	 * An object containing the id and name of the associated client.
	 */
	HarvestClient client;
	/**
	 * An object containing the id and name of the associated project.
	 */
	HarvestProject project;
	/**
	 * An object containing the id and name of the associated task.
	 */
	HarvestTask task;
	/**
	 * A {@link HarvestProjectUserAssignment} {@linkplain <a href="https://help.getharvest.com/api-v2/projects-api/projects/user-assignments/#the-user-assignment-object">object</a>} of the associated user.
	 */
	@JsonProperty("user_assignment")
	HarvestProjectUserAssignment userAssignment;
	/**
	 *
	 */
	@JsonProperty("task_assignment")
	HarvestProjectTaskAssignment taskAssignment;

	/**
	 * Once the time entry has been invoiced, this field will include the associated invoice’s id and number.
	 */
	HarvestInvoice invoice;
	/**
	 * An object containing the id, group_id, account_id, permalink, service, and service_icon_url of the associated
	 * external reference.
	 */
	@JsonProperty("external_reference")
	Object externalReference;
}
