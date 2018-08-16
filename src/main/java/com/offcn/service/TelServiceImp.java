package com.offcn.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.offcn.dao.TelDao;
import com.offcn.po.Mobile;

@Service
public class TelServiceImp implements TelService {

	@Autowired
	TelDao telDao;
	
	@Override
	public List<Mobile> getAll() {
		// TODO Auto-generated method stub
		return telDao.getAll();
	}

	@Override
	public void save(Mobile mobile) {
		// TODO Auto-generated method stub
           telDao.save(mobile);
	}

}
