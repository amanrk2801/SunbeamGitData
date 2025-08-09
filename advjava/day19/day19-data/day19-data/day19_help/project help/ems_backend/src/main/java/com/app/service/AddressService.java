package com.app.service;

import java.util.Map;

import com.app.dto.AddressDTO;
import com.app.dto.ApiResponse;

import jakarta.validation.Valid;

public interface AddressService {	
	// assign emp address
		ApiResponse assignEmpAddress( Long empId, @Valid AddressDTO address);		
//get address details
	AddressDTO getAddressDetails(Long addressId);
	//update emp address : complete update
	ApiResponse updateEmpAddress( Long empId, @Valid AddressDTO address);
	//update emp address : partial update
	AddressDTO patchEmpAddress( Long empId, Map<String, Object> map);
}
