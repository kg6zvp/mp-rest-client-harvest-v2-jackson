package com.harvestapp.api.v2.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.harvestapp.api.v2.HarvestAuthContext;
import lombok.*;

import java.beans.Transient;
import java.net.URL;
import java.time.Instant;
import java.util.List;

@Data
@Builder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor
public class HarvestUser {
	/**
	 * Unique ID for the user.
	 */
	Long id;
	/**
	 * Fallback field, if user endpoint cannot be accessed.
	 * Field does not exist in value returned from {@link com.harvestapp.api.v2.HarvestUsersApi#getUserInfo(HarvestAuthContext, String)}
	 * Field is known to exist in:
	 * 	{@link HarvestTimeEntry#user},
	 * 	{@link HarvestProjectUserAssignment#user}
	 */
	String name;

	@Transient
	@JsonIgnore
	public String getFirstNameFromAnywhere() {
		if (this.firstName != null) return this.getFirstName();
		if (this.name != null) return name.split(" ")[0];
		return null;
	}

	@Transient
	@JsonIgnore
	public String getLastNameFromAnywhere() {
		if (this.lastName != null) return this.getLastName();
		if (this.name != null) return name.split(" ")[1];
		return null;
	}

	/**
	 * The first name of the user.
	 */
	@JsonProperty("first_name")
	String firstName;
	/**
	 * The last name of the user.
	 */
	@JsonProperty("last_name")
	String lastName;
	/**
	 * The email address of the user.
	 */
	String email;
	/**
	 * The user’s telephone number.
	 */
	String telephone;
	/**
	 * The user’s timezone.
	 */
	String timezone;
	/**
	 * Whether the user should be automatically added to future projects.
	 */
	@JsonProperty("has_access_to_all_future_projects")
	Boolean hasAccessToAllFutureProjects;
	/**
	 * Whether the user is a contractor or an employee.
	 */
	@JsonProperty("is_contractor")
	Boolean isContractor;
	/**
	 * Whether the user is active or archived.
	 */
	@JsonProperty("is_active")
	Boolean isActive;
	/**
	 * The number of hours per week this person is available to work in seconds, in half hour increments. For example,
	 * if a person’s capacity is 35 hours, the API will return 126000 seconds.
	 */
	@JsonProperty("weekly_capacity")
	Integer weeklyCapacityInSeconds;
	/**
	 * The billable rate to use for this user when they are added to a project.
	 */
	@JsonProperty("default_hourly_rate")
	Double defaultHourlyRate;
	/**
	 * The cost rate to use for this user when calculating a project’s costs vs billable amount.
	 */
	@JsonProperty("cost_rate")
	Double costRate;
	/**
	 * Descriptive names of the business roles assigned to this person. They can be used for filtering reports, and
	 * have no effect in their permissions in Harvest.
	 */
	List<String> roles;
	/**
	 * <pre>
	 * <a href="https://help.getharvest.com/api-v2/users-api/users/users/#access-roles">Access role(s)</a> that
	 * determine the user’s permissions in Harvest.
	 * Possible values:
	 * 	{@code "administrator"},
	 * 	{@code "manager"} or
	 * 	{@code "member"}.
	 * Users with the {@code "manager"} role can additionally be granted one or more of these roles:
	 * 	{@code "project_creator"},
	 * 	{@code "billable_rates_manager"},
	 * 	{@code "managed_projects_invoice_drafter"},
	 * 	{@code "managed_projects_invoice_manager"},
	 * 	{@code "client_and_task_manager"},
	 * 	{@code "time_and_expenses_manager"},
	 * 	{@code "estimates_manager"}.
	 * 	</pre>
	 */
	@JsonProperty("access_roles")
	List<String> accessRoles;
	/**
	 * The URL to the user’s avatar image.
	 */
	@JsonProperty("avatar_url")
	URL avatarUrl;
	/**
	 * Date and time the user was created.
	 */
	@JsonProperty("created_at")
	Instant createdAt;
	/**
	 * Date and time the user was last updated.
	 */
	@JsonProperty("updated_at")
	Instant updatedAt;
}
