package web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import web.dao.UserDAO;
import web.model.User;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    private final UserDAO userDAO;

    @Autowired
    public UserServiceImpl(UserDAO userDAO) {
        this.userDAO = userDAO;
    }


    @Transactional
    @Override
    public List<User> index() {
        return userDAO.index();
    }

    @Transactional
    @Override
    public User show(int id) {
        return userDAO.show(id);
    }

    @Transactional
    @Override
    public void save(User user) {
        userDAO.save(user);
    }


    @Transactional
    @Override
    public void update(int id, User updateUser) {
        userDAO.update(id, updateUser);
    }

    @Transactional
    @Override
    public void delete(int id) {
        userDAO.delete(id);
    }
}
