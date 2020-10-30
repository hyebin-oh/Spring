package com.mycom.model;

import java.util.HashMap;
import java.util.List;

import com.mycom.vo.GuestVO;

public interface GuestDAO {
	public void dao_insert(GuestVO guest);
	public List<GuestVO> dao_list(HashMap<String, Object> hm);
	public int dao_count(HashMap<String, Object> hm);
	public GuestVO dao_findById(int num);
	public void dao_update(GuestVO guest);
	public void dao_delete(int num);
}
