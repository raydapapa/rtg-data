package club.realtg.rtgdata;

import club.realtg.rtgdata.entity.Player;
import club.realtg.rtgdata.service.PlayerService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

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

    @Resource
    PlayerService playerService;

    @Test
    public void testEntity() {
        Player player = new Player();
        player.setRealName("测试者");
        player.setNickName("小测测");
        player.setIdCardNo("500103200210257096");
        player.setKitNumber(10);

        playerService.savePlayer(player);

        player = playerService.getPlayerById(player.getId());
        System.out.println("player info:" + player);
        System.out.println(player.getRealName());
        System.out.println(player.getNickName());
        System.out.println(player.getIdCardNo());
        System.out.println(player.getKitNumber());

        player.setDesc("测试简介内容");
        playerService.updatePlayer(player);

        playerService.removePlayers(""+player.getId());
    }
}
