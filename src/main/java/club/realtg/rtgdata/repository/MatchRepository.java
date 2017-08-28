package club.realtg.rtgdata.repository;

import club.realtg.rtgdata.entity.Match;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * Desc
 *
 * @author Papa Ray
 * Created on 2017-08-28
 */
public interface MatchRepository extends JpaRepository<Match, Integer>, JpaSpecificationExecutor<Match> {

}