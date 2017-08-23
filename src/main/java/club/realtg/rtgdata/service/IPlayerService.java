package club.realtg.rtgdata.service;

import club.realtg.rtgdata.entity.Player;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * Desc
 *
 * @author Papa Ray
 * Created on 2017-08-21
 */
public interface IPlayerService extends JpaRepository<Player, Integer>, JpaSpecificationExecutor<Player> {

}
