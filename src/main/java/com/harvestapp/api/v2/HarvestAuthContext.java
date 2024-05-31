package com.harvestapp.api.v2;

import jakarta.ws.rs.HeaderParam;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor
public class HarvestAuthContext {
	String bearerToken;
	Long accountId;

	@HeaderParam("Authorization")
	public String getAuthorizationHeader() {
		return String.format("Bearer %s", this.getBearerToken());
	}

	@HeaderParam("Harvest-Account-Id")
	public Long getHarvestAccountId() {
		return this.getAccountId();
	}

	@HeaderParam("User-Agent")
	public String getUserAgent() {
		return "Test Application";
	}
}
