package edu.williamcastellanos.products.data;

import edu.williamcastellanos.products.models.UserEntity;
import org.springframework.data.repository.CrudRepository;

public interface UsersRepository extends CrudRepository<UserEntity, Long> {

    UserEntity findByUsername(String username);
}