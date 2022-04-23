package edu.store.repository;

import edu.store.entity.UserAccount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface UserRepository extends JpaRepository<UserAccount, Long> {
    @Query("SELECT u FROM UserAccount u where u.email = :email")
    UserAccount findByEmail(@Param("email") String email);

    @Query("SELECT u FROM UserAccount u where u.phone = :phone")
    List<UserAccount> findByPhone(@Param("phone") String phone);

    @Query("SELECT u FROM UserAccount u where u.name = :name")
    List<UserAccount> findByName(@Param("name") String name);

    @Query("SELECT CASE WHEN COUNT(u) > 0 THEN true ELSE false " +
            "END FROM UserAccount u WHERE u.email = :email")
    boolean existsByEmail(@Param("email") String email);
}
