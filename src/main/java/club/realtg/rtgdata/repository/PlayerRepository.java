package club.realtg.rtgdata.repository;

import club.realtg.rtgdata.entity.Player;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * Desc
 *
 * @author Papa Ray
 * Created on 2017-08-26
 */
public interface PlayerRepository extends JpaRepository<Player, Integer>, JpaSpecificationExecutor<Player> {

}