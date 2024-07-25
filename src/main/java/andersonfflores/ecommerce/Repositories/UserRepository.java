package andersonfflores.ecommerce.Repositories;

import andersonfflores.ecommerce.Models.User.User;
import org.springframework.data.jdbc.repository.query.Modifying;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface UserRepository extends CrudRepository<User, UUID> {

    @Query("SELECT tb_user.id, tb_user.name, tb_user.email, tb_user.address, tb_user.role, tb_user.password FROM tb_user WHERE tb_user.name = :name")
    Optional<User> findByName(@Param("name")String name);

}
