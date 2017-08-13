package club.realtg.rtgdata.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;

/**
 * Desc
 *
 * @author Papa Ray
 * Created on 2017-08-13
 */
@Controller
@RequestMapping("player")
public class PlayerController {

    static ArrayList<String> listPlayerNames = new ArrayList<>();

    @RequestMapping(value = "")
    public String gotoPlayerList(Model model) {
        String title = "球员列表";

//        listPlayerNames.add("邵宇驰");
//        listPlayerNames.add("李万郁");
//        listPlayerNames.add("张超");
//        listPlayerNames.add("秦笑");
//        listPlayerNames.add("罗渝力");
//        listPlayerNames.add("吴林青");
//        listPlayerNames.add("曾理");
//        listPlayerNames.add("向军");
//        listPlayerNames.add("李双");
//        listPlayerNames.add("刘浩");

        model.addAttribute("title",title);
        model.addAttribute("playerNames",listPlayerNames);
        return "player/playerList";
    }

    @RequestMapping(value = "add", method = RequestMethod.GET)
    public String addNewPlayer(Model model) {
        String title = "新增球员";
        model.addAttribute("title",title);
        return "player/addPlayer";
    }

    @RequestMapping(value = "add", method = RequestMethod.POST)
    public String processAddPlayerForm(@RequestParam String playerName) {
        listPlayerNames.add(playerName);
        // Redirect to /player
        return "redirect:";
    }

}
