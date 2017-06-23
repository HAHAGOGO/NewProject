
package com.dao;

import java.util.List;

public interface IGoodServiceRelaxDao {
	List<Integer> getGoodServiceId(Integer goodId);
	boolean insertRelax(Integer goodId,Integer serviceId);
	boolean deleteRelax(Integer goodId);
	boolean deleteAll(Integer[] delId);
}
