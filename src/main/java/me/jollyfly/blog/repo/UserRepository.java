package me.jollyfly.blog.repo;

import me.jollyfly.blog.model.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User,Long> {

    Optional<User> findByNicAndPassword(String nic,String password);

}
