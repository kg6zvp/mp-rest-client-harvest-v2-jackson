package com.harvestapp.api.v2.dto.common;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

/**
 * <a href="https://help.getharvest.com/api-v2/introduction/overview/pagination/">See Pagination Guide</a>
 *
 * This is a base class intended for extension by DTO classes harboring pagination in their responses
 */
@Data
@SuperBuilder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor
public abstract class HarvestPagedApiResponse {
	Integer page;
	@JsonProperty("per_page")
	Integer perPage;
	@JsonProperty("total_pages")
	Integer totalPages;
	@JsonProperty("total_entries")
	Integer totalEntries;
	@JsonProperty("next_page")
	String nextPage;
	@JsonProperty("previous_page")
	String previousPage;

	HarvestPagedApiLinks links;

}
