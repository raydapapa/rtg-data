package club.realtg.rtgdata.dao;

import club.realtg.rtgdata.entity.Player;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

/**
 * Desc
 *
 * @author Papa Ray
 * Created on 2017-08-14
 */
@Repository
@Transactional
public interface PlayerDao extends CrudRepository<Player, Integer>{
}
