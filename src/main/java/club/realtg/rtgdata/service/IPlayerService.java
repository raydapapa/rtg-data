package club.realtg.rtgdata.service;

import club.realtg.rtgdata.entity.Player;

/**
 * Desc
 *
 * @author Papa Ray
 * Created on 2017-08-21
 */
public interface IPlayerService {

    Iterable<Player> getPlayerList();

    /**
     * 保存成功返回1，失败返回0
     */
    int savePlayer(Player player);
}
