package club.realtg.rtgdata.controller;

import club.realtg.rtgdata.entity.Player;
import club.realtg.rtgdata.service.IPlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.annotation.Resource;
import javax.validation.Valid;

/**
 * Controller for Player
 *
 * @author Papa Ray
 * Created on 2017-08-13
 */
@Controller
public class PlayerController {

    @Autowired
    IPlayerService playerService;

    @RequestMapping(value = "list")
    public String gotoPlayerList(Model model) {
        String title = "球员列表";
        model.addAttribute("title",title);
        model.addAttribute("players",playerService.getPlayerList());
        return "player/playerList";
    }

    @RequestMapping(value = "add", method = RequestMethod.GET)
    public String displayAddPlayerForm(Model model) {
        String title = "新增球员";
        model.addAttribute("title",title);
        return "player/addPlayer";
    }

    @RequestMapping(value = "add", method = RequestMethod.POST)
    public String processAddPlayerForm(@ModelAttribute @Valid Player newPlayer, Errors errors, Model model) {
        if(errors.hasErrors()) {
            model.addAttribute("title", "新增球员");
            return "player/addPlayer";
        }
        int saveResult = playerService.savePlayer(newPlayer);
        if(saveResult == 1) {
            return "redirect:/list";
        } else {
            return "redirect:/error";
        }
    }

    /*
    @RequestMapping(value = "remove", method = RequestMethod.GET)
    public String displayRemovePlayerForm(Model model) {
        String title = "删除球员";
        model.addAttribute("title",title);
        model.addAttribute("players",playerDao.findAll());
        return "player/remove";
    }

    @RequestMapping(value = "remove", method = RequestMethod.POST)
    public String processRemovePlayerForm(@RequestParam int[] playerIds) {
        for (int playerId : playerIds) {
            playerDao.delete(playerId);
        }
        return "redirect:/list";
    }
    */
}
