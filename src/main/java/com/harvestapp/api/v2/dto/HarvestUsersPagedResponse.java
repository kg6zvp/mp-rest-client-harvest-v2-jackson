package com.harvestapp.api.v2.dto;

import com.harvestapp.api.v2.dto.common.HarvestPagedApiResponse;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.util.List;

@Data
@SuperBuilder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor
public class HarvestUsersPagedResponse extends HarvestPagedApiResponse {
	List<HarvestUser> users;
}
