package web.dao;

import org.springframework.stereotype.Repository;
import web.model.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;


@Repository
public class UserDAOImpl implements UserDAO {
    @PersistenceContext
    private EntityManager em;

    @Override
    public List<User> index() {
        List<User> users = em.createQuery("SELECT a FROM User a", User.class).getResultList();
        return users;
    }

    @Override
    public User show(int id) {
        User user = em.find(User.class, new Integer(id));
        em.detach(user);

        return user;
    }

    @Override
    public void save(User user) {
        em.persist(user);
    }

    @Override
    public void update(int id, User updateUser) {
        em.merge(updateUser);
    }

    @Override
    public void delete(int id) {
        Query query = em.createQuery("delete from User where id = :id");
        query.setParameter("id", id);
        query.executeUpdate();
    }


}
