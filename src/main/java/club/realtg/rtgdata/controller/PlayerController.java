package club.realtg.rtgdata.controller;

import club.realtg.rtgdata.entity.Player;
import club.realtg.rtgdata.service.PlayerService;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

/**
 * Controller for Player
 *
 * @author Papa Ray
 * Created on 2017-08-13
 */
@Controller
public class PlayerController extends BaseController {

    @Resource
    PlayerService playerService;

    @RequestMapping(value = "list")
    public String gotoPlayerList(Model model) {
        String title = "球员列表";
        model.addAttribute("title",title);
        return "player/playerList";
    }

    @RequestMapping(value = "query")
    public void query(HttpServletResponse response, int pageNo, int pageSize, String keyword, String sortKey, String direction) {
        try {
            Page<Player> players = playerService.getPlayersPage(pageNo, pageSize, keyword, sortKey, direction);
            writeSuccess(response, players);
        } catch (Exception e) {
            e.printStackTrace();
            writeError(response, e.getMessage());
        }
    }

    @RequestMapping(value = "savePlayer")
    public void saveAddPlayer(@ModelAttribute @Valid Player player, Errors errors, HttpServletResponse response, Model model) {
        if(errors.hasErrors()) {
            model.addAttribute("errors", errors.getAllErrors());
            return;
        }
        try {
            playerService.savePlayer(player);
            writeSuccess(response, player);
        } catch (Exception e) {
            e.printStackTrace();
            writeError(response, e.getMessage());
        }
    }

    @RequestMapping(value = "updatePlayer")
    public void saveUpdatePlayer(@ModelAttribute @Valid Player player, Errors errors, HttpServletResponse response, Model model) {
        if(errors.hasErrors()) {
            model.addAttribute("errors", errors.getAllErrors());
            return;
        }
        try {
            playerService.updatePlayer(player);
            writeSuccess(response, player);
        } catch (Exception e) {
            e.printStackTrace();
            writeError(response, e.getMessage());
        }
    }

    @RequestMapping(value = "removePlayers")
    public void removePlayers(HttpServletResponse response, String ids){
        try {
            playerService.removePlayers(ids);
            writeSuccess(response);
        } catch (Exception e) {
            e.printStackTrace();
            writeError(response, e.getMessage());
        }
    }
}
