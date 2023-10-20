package service;

import java.util.List;

import dao.MenuDao;
import dto.Menu;

public class MenuService {

	MenuDao menuDao = new MenuDao();
	Menu menu = new Menu();

	public Menu addMenu(Menu menu) {
		return menuDao.addMenu(menu);
	}

	public boolean delMenu(int id) {
		return menuDao.delMenu(id);
	}

	public List<Menu> getMenus() {
		return menuDao.getMenus();
	}

	public Menu getMenuById(int f) {
		return menuDao.getMenuById(f);
	}

	public boolean updateRating(double star, int id) {
		return menuDao.updateRating(star, id);
	}
}