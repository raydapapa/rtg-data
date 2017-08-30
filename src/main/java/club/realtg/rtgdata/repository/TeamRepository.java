package club.realtg.rtgdata.repository;

import club.realtg.rtgdata.entity.Team;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * Desc
 *
 * @author Papa Ray
 * Created on 2017-08-28
 */
public interface TeamRepository extends JpaRepository<Team, Integer>, JpaSpecificationExecutor<Team> {

    Team findByName(String name);
}