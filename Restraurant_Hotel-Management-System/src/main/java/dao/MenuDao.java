package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import dto.Menu;

public class MenuDao {

	EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("tushar");
	EntityManager entityManager = entityManagerFactory.createEntityManager();
	EntityTransaction entityTransaction = entityManager.getTransaction();

	Menu menu = new Menu();

	public Menu addMenu(Menu menu) {
		entityTransaction.begin();
		entityManager.persist(menu);
		entityTransaction.commit();
		return menu;
	}

	public boolean delMenu(int id) {
		Menu c = entityManager.find(Menu.class, id);

		if (c != null) {
			entityTransaction.begin();
			entityManager.remove(c);
			entityTransaction.commit();
			return true;
		} else {
			return false;
		}
	}

	public Menu getMenuById(int id) {
		Menu c = entityManager.find(Menu.class, id);

		if (c != null) {
			return c;
		} else {
			return null;
		}
	}

	@SuppressWarnings("unchecked")
	public List<Menu> getMenus() {
		String sql = "SELECT ch FROM Menu ch";
		Query query = entityManager.createQuery(sql);
		List<Menu> menus = query.getResultList();
		return menus;
	}

	public boolean updateRating(double star, int id) {
		Menu c = entityManager.find(Menu.class, id);
		if (c != null) {
			if (c.getF_rating() < 0.5) {
				c.setF_rating(star);

				entityTransaction.begin();
				entityManager.merge(c);
				entityTransaction.commit();
			} else {
				double prev_rate = c.getF_rating();
				c.setF_rating((star + prev_rate) / 2.0);

				entityTransaction.begin();
				entityManager.merge(c);
				entityTransaction.commit();
			}
			return true;
		}
		return false;
	}

}
