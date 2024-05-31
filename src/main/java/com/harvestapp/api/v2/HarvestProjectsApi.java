package com.harvestapp.api.v2;

import com.harvestapp.api.v2.dto.HarvestProject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

import java.time.LocalDateTime;

@Path("/projects")
@RegisterRestClient(
	baseUri = HarvestAPIClient.MP_REST_CLIENT_DEFAULT_BASE_URL,
	configKey = HarvestAPIClient.MP_REST_CLIENT_CONFIG_KEY)
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public interface HarvestProjectsApi {
	@GET
	String getProjects(@BeanParam HarvestAuthContext harvestAuthContext, @BeanParam ProjectsApiFilters filters);

	@GET
	@Path("/{projectId}")
	HarvestProject getProjectById(@BeanParam HarvestAuthContext harvestAuthContext, @PathParam("projectId") Long projectId);

	@Data
	@Builder(toBuilder = true)
	@NoArgsConstructor
	@AllArgsConstructor
	class ProjectsApiFilters {
		/**
		 * Pass true to only return active projects and false to return inactive projects.
		 */
		@QueryParam("is_active")
		Boolean isActive;
		/**
		 * Only return projects belonging to the client with the given ID.
		 */
		@QueryParam("client_id")
		Long clientId;
		/**
		 * Only return projects that have been updated since the given date and time.
		 */
		@QueryParam("updated_since")
		LocalDateTime updatedSince;
		/**
		 * DEPRECATED The page number to use in pagination. For instance, if you make a list request and receive 2000 records, your subsequent call can include page=2 to retrieve the next page of the list. (Default: 1)
		 */
		@Deprecated
		@QueryParam("page")
		Integer page;
		/**
		 * The number of records to return per page. Can range between 1 and 2000. (Default: 2000)
		 */
		@QueryParam("per_page")
		Integer perPage;
	}
}
