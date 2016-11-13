package pl.wat.pz.application.dao.repository;

import pl.wat.pz.application.dao.domain.User;

/**
 * Created by DELL on 2016-11-13.
 */
public interface UserRepository {
    public void addUser(User user);
    public void downloadAllUsers();
}
