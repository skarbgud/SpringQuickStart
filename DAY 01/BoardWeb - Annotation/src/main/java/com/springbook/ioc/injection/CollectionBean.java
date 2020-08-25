package com.springbook.ioc.injection;

import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

public class CollectionBean {
	private List<String> addressList;
	
	public void setAddressList(List<String> addressList) {
		this.addressList = addressList;
	}
	
	public List<String> getAddressList() {
		return addressList;
	}
	
	private Set<String> addressListSet;
	
	public void setAddressListSet(Set<String> addressListSet) {
		this.addressListSet = addressListSet;
	}
	
	public Set<String> getAddressListSet() {
		return addressListSet;
	}
	
	private Map<String, String> addressListMap;

	public Map<String, String> getAddressListMap() {
		return addressListMap;
	}

	public void setAddressListMap(Map<String, String> addressListMap) {
		this.addressListMap = addressListMap;
	}
	
	private Properties addressListProperties;

	public Properties getAddressListProperties() {
		return addressListProperties;
	}

	public void setAddressListProperties(Properties addressListProperties) {
		this.addressListProperties = addressListProperties;
	}
	
}
