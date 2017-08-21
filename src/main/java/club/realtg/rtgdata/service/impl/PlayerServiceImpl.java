package club.realtg.rtgdata.service.impl;

import club.realtg.rtgdata.dao.PlayerDao;
import club.realtg.rtgdata.entity.Player;
import club.realtg.rtgdata.service.IPlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Desc
 *
 * @author Papa Ray
 * Created on 2017-08-21
 */
@Service
public class PlayerServiceImpl implements IPlayerService{

    @Autowired
    private PlayerDao playerDao;

    @Override
    public Iterable<Player> getPlayerList() {
        Iterable<Player> players = playerDao.findAll();
        return players;
    }

    @Override
    public int savePlayer(Player player) {
        int intResult = 0;
        try {
            playerDao.save(player);
            intResult = 1;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return intResult;
    }
}
