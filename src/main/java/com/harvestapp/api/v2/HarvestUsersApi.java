package com.harvestapp.api.v2;

import com.harvestapp.api.v2.dto.HarvestUser;
import com.harvestapp.api.v2.dto.HarvestUserProjectAssignmentsPagedResponse;
import com.harvestapp.api.v2.dto.HarvestUsersPagedResponse;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

@Path("/users/")
@RegisterRestClient(
	baseUri = HarvestAPIClient.MP_REST_CLIENT_DEFAULT_BASE_URL,
	configKey = HarvestAPIClient.MP_REST_CLIENT_CONFIG_KEY)
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public interface HarvestUsersApi {
	String CURRENT_USER_KEYWORD = "me";

	@GET
	HarvestUsersPagedResponse getUsers(@BeanParam HarvestAuthContext harvestAuthContext);

	@GET
	@Path("{user}")
    HarvestUser getUserInfo(@BeanParam HarvestAuthContext harvestAuthContext, @PathParam("user") String user);

	@GET
	@Path("{user}/project_assignments")
    HarvestUserProjectAssignmentsPagedResponse getProjectAssignments(@BeanParam HarvestAuthContext harvestAuthContext, @PathParam("user") String user);
}
