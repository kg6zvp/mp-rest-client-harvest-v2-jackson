package com.harvestapp.api.v2;


import com.harvestapp.api.v2.dto.HarvestClientsPagedResponse;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

@Path("/clients")
@RegisterRestClient(
	baseUri = HarvestAPIClient.MP_REST_CLIENT_DEFAULT_BASE_URL,
	configKey = HarvestAPIClient.MP_REST_CLIENT_CONFIG_KEY)
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public interface HarvestClientsApi {
	@GET
    HarvestClientsPagedResponse getClients(@BeanParam HarvestAuthContext harvestAuthContext /* TODO: add filtering */);
}
