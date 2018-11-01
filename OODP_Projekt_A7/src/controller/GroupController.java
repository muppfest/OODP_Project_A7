package controller;

import java.util.List;

import dao.GroupDao;
import model.Group;

public class GroupController {
	private GroupDao groupDao;
	
	 public List<Group> listGroups() {
		 List<Group> glist = groupDao.getAll();
		 return glist;
	 }
}
