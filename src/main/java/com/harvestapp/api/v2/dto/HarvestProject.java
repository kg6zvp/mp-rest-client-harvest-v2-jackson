package com.harvestapp.api.v2.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@Builder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor
public class HarvestProject {
	/**
	 * Unique ID for the project.
	 */
	Long id;
	/**
	 * An object containing the project’s client id, name, and currency.
	 */
	HarvestClient client;
	/**
	 * Unique name for the project.
	 */
	String name;
	/**
	 * The code associated with the project.
	 */
	String code;
	/**
	 * Whether the project is active or archived.
	 */
	@JsonProperty("is_active")
	Boolean isActive;
	/**
	 * Whether the project is billable or not.
	 */
	@JsonProperty("is_billable")
	Boolean isBillable;
	/**
	 * Whether the project is a fixed-fee project or not.
	 */
	@JsonProperty("is_fixed_fee")
	Boolean isFixedFee;
	/**
	 * The method by which the project is invoiced.
	 */
	@JsonProperty("bill_by")
	String billBy;
	/**
	 * Rate for projects billed by Project Hourly Rate.*
	 */
	@JsonProperty("hourly_rate")
	Double hourlyRate;
	/**
	 * The budget in hours for the project when budgeting by time.
	 */
	Double budget;
	/**
	 * The method by which the project is budgeted.
	 */
	@JsonProperty("budget_by")
	Double budgetBy;
	/**
	 * Option to have the budget reset every month.
	 */
	@JsonProperty("budget_is_monthly")
	Boolean budgetIsMonthly;
	/**
	 * Whether Project Managers should be notified when the project goes over budget.
	 */
	@JsonProperty("notify_when_over_budget")
	Boolean notifyWhenOverBudget;
	/**
	 * Percentage value used to trigger over budget email alerts.
	 */
	@JsonProperty("over_budget_notification_percentage")
	Double overBudgetNotificationPercentage;
	/**
	 * Date of last over budget notification. If none have been sent, this will be null.
	 */
	@JsonProperty("over_budget_notification_date")
	LocalDate overBudgetNotificationDate;
	/**
	 * Option to show project budget to all employees. Does not apply to Total Project Fee projects.
	 */
	@JsonProperty("show_budget_to_all")
	Boolean showBudgetToAll;
	/**
	 * The monetary budget for the project when budgeting by money.
	 */
	@JsonProperty("cost_budget")
	Double costBudget;
	/**
	 * Option for budget of Total Project Fees projects to include tracked expenses.
	 */
	@JsonProperty("cost_budget_include_expenses")
	Boolean costBudgetIncludeExpenses;
	/**
	 * The amount you plan to invoice for the project.
	 * Only used by fixed-fee projects.
	 */
	Double fee;
	/**
	 * Project notes.
	 */
	String notes;
	/**
	 * Date the project was started.
	 */
	@JsonProperty("starts_on")
	LocalDate startsOn;
	/**
	 * Date the project will end.
	 */
	@JsonProperty("ends_on")
	LocalDate endsOn;
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
