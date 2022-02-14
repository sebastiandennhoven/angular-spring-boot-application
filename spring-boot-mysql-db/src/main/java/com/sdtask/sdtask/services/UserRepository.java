package com.sdtask.sdtask.services;
import java.util.List;
import com.sdtask.sdtask.entities.UserEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<UserEntity, Integer> {

    /**
     * @param limit Amount of response items
     * @return All users but never more than limit
     */
    @Query(value = "SELECT * FROM user_entity order by time_added desc limit :limit", nativeQuery = true)
	public List<UserEntity> findTopN(@Param("limit") int limit);

    /**
     * 
     * @param limit Amount of response items
     * @param country
     * @return All users that match country but never more than limit
     */
    @Query(value = "SELECT * FROM user_entity WHERE country=:country order by time_added desc limit :limit", nativeQuery = true)
	public List<UserEntity> findTopNInCountry(@Param("limit") int limit, String country);
    
    /**
     * @return List of all Unique countries in Table
     */
    @Query(value = "SELECT DISTINCT country FROM user_entity", nativeQuery = true)
	public List<String> findAllUniqueCountries();
}
