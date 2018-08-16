package com.offcn.service;

import java.util.List;

import com.offcn.po.Mobile;

public interface TelService {

   public List<Mobile> getAll();
	
	public void save(Mobile mobile);
}
