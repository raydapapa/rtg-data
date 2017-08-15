package club.realtg.rtgdata;

import club.realtg.rtgdata.dao.PlayerDao;
import club.realtg.rtgdata.entity.Player;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Desc
 *
 * @author Papa Ray
 * Created on 2017-08-15
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@ActiveProfiles("dev")
public class PlayerTest {

    @Autowired
    private PlayerDao playerDao;

    @Test
    public void testEntity() {
        Player player = new Player();
        player.setRealName("秦笑");
        player.setNickName("笑哥");
        player.setIdCardNo("500103198310257013");
        player.setKitNumber(10);

        player = playerDao.save(player);

        player = playerDao.findOne(player.getId());
        System.out.println("player info:" + player);
        System.out.println(player.getRealName());
        System.out.println(player.getNickName());
        System.out.println(player.getIdCardNo());
        System.out.println(player.getKitNumber());

        playerDao.delete(player.getId());
    }
}
