package com.freecrm.accountcreation.testcases;

public enum LoginType implements RolesTypesAssocication {
	
	STANDARD("Standard User", 101),
	AUDITOR("Adutor", 103),
	ADMIN("Administrator Global", 102);
	
	private String roleName;
	private int roleId;
	
	LoginType(String roleName, int roleId){
		this.roleName= roleName;
		this.roleId = roleId;
	}

	@Override
	public String getName() {
		return roleName;
	}

	@Override
	public int getId() {
		return roleId;
	}
}
