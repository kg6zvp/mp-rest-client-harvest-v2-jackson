package com.harvestapp.api.v2.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor
public class HarvestClient {
	/**
	 * Unique ID for the client.
	 */
	Long id;
	/**
	 * A textual description of the client.
	 */
	String name;
	/**
	 * Whether the client is active or archived.
	 */
	@JsonProperty("is_active")
	Boolean isActive;
	/**
	 * The physical address for the client.
	 */
	String address;
	/**
	 * Used to build a URL to your client’s invoice dashboard:
	 * https://{ACCOUNT_SUBDOMAIN}.harvestapp.com/client/statements/{STATEMENT_KEY}
	 */
	@JsonProperty("statement_key")
	String statementKey;
	/**
	 * The currency code associated with this client.
	 */
	HarvestCurrency currency;
	/**
	 * Date and time the client was created.
	 */
	@JsonProperty("created_at")
	LocalDateTime createdAt;
	/**
	 * Date and time the client was last updated.
	 */
	@JsonProperty("updated_at")
	LocalDateTime updatedAt;
}
