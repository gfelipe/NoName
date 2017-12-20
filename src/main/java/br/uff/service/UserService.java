package br.uff.service;

import br.uff.model.*;
import br.uff.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User createUserFromPerson(AcademicPerson person, String password) {
        User user = new User();

        user.setUsername(person.getEmail());
        user.setPassword(password);
        user.setRoles(Collections.singleton(getRole(person, user)));
        user.setEnabled(false);
        user.encodePassword();

        return save(user);
    }

    private UserRole getRole(AcademicPerson person, User user) {
        UserRole userRole = new UserRole();

        userRole.setUser(user);

        if(person instanceof Student) {
            userRole.setRole("ROLE_STUDENT");
        } else if (person instanceof Professor) {
            userRole.setRole("ROLE_PROFESSOR");
        }

        return userRole;
    }

    public User save(User user) {
        return userRepository.save(user);
    }

    public User findUserByUsername(String username){
        return this.userRepository.findByUsername(username);
    }

    public List<User> findUserByEnabled(boolean b) {
        return this.userRepository.findByEnabled(b);
    }
}