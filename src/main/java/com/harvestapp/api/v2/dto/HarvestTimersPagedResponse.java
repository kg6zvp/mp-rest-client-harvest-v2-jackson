package com.harvestapp.api.v2.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.harvestapp.api.v2.dto.common.HarvestPagedApiResponse;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.util.List;

@Data
@SuperBuilder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class HarvestTimersPagedResponse extends HarvestPagedApiResponse {
	@JsonProperty("time_entries")
	List<HarvestTimeEntry> timeEntries;
}
