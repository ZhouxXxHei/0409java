package com.offcn.dao;

import java.util.List;

import com.offcn.po.Mobile;

public interface TelDao {

	public List<Mobile> getAll();
	
	public void save(Mobile mobile);
}
