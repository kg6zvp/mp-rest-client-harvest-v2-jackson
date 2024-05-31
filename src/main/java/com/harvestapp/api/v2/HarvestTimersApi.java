package com.harvestapp.api.v2;

import com.harvestapp.api.v2.dto.HarvestTimeEntry;
import com.harvestapp.api.v2.dto.HarvestTimersPagedResponse;
import com.harvestapp.api.v2.dto.HarvestTimeEntryCreateBody;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Path("/time_entries")
@RegisterRestClient(
	baseUri = HarvestAPIClient.MP_REST_CLIENT_DEFAULT_BASE_URL,
	configKey = HarvestAPIClient.MP_REST_CLIENT_CONFIG_KEY)
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public interface HarvestTimersApi {
	@GET
    HarvestTimersPagedResponse getTimers(@BeanParam HarvestAuthContext harvestAuthContext, @BeanParam TimerApiFilters filters);

	@GET
	String getTimersString(@BeanParam HarvestAuthContext harvestAuthContext, @BeanParam TimerApiFilters filters);

	@GET
	@Path("/{timer_id}")
    HarvestTimeEntry getTimer(@BeanParam HarvestAuthContext harvestAuthContext, @PathParam("timer_id") Long timerId);

	@POST
	HarvestTimeEntry createTimer(@BeanParam HarvestAuthContext harvestAuthContext, HarvestTimeEntryCreateBody timerBody);

	@DELETE
	@Path("/{timer_id}")
	Response deleteTimer(@BeanParam HarvestAuthContext harvestAuthContext, @PathParam("timer_id") Long timerId);

	@PATCH
	@Path("/{timer_id}/restart")
	Response resumeTimer(@BeanParam HarvestAuthContext harvestAuthContext, @PathParam("timer_id") Long timerId);

	@PATCH
	@Path("/{timer_id}/stop")
	Response stopTimer(@BeanParam HarvestAuthContext harvestAuthContext, @PathParam("timer_id") Long timerId);

	@Data
	@Builder(toBuilder = true)
	@NoArgsConstructor
	@AllArgsConstructor
	class TimerApiFilters {
		/**
		 * Only return time entries belonging to the user with the given ID.
		 */
		@QueryParam("user_id")
		Long userId;
		/**
		 * Only return time entries belonging to the client with the given ID.
		 */
		@QueryParam("client_id")
		Long clientId;
		/**
		 * Only return time entries belonging to the project with the given ID.
		 */
		@QueryParam("project_id")
		Long projectId;
		/**
		 * Only return time entries belonging to the task with the given ID.
		 */
		@QueryParam("task_id")
		Long taskId;
		/**
		 * Only return time entries with the given external_reference ID.
		 */
		@QueryParam("external_reference_id")
		String externalReferenceId;
		/**
		 * Pass true to only return time entries that have been invoiced and false to return time entries that have not
		 * been invoiced.
		 */
		@QueryParam("is_billed")
		Boolean isBilled;
		/**
		 * Pass true to only return running time entries and false to return non-running time entries.
		 */
		@QueryParam("is_running")
		Boolean isRunning;
		/**
		 * Only return time entries that have been updated since the given date and time. Use the ISO 8601 Format.
		 */
		@QueryParam("updated_since")
		LocalDateTime updatedSince;
		/**
		 * Only return time entries with a spent_date on or after the given date.
		 */
		@QueryParam("from")
		LocalDate from;
		/**
		 * Only return time entries with a spent_date on or before the given date.
		 */
		@QueryParam("to")
		LocalDate to;
		/**
		 * The page number to use in pagination. For instance, if you make a list request and receive 2000 records,
		 * your subsequent call can include page=2 to retrieve the next page of the list. (Default: 1)
		 */
		@QueryParam("page")
		Long page;
		/**
		 * The number of records to return per page. Can range between 1 and 2000. (Default: 2000)
		 */
		@QueryParam("per_page")
		Long perPage;
	}
}
