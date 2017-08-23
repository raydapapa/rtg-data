package club.realtg.rtgdata.controller;

import club.realtg.rtgdata.common.util.*;
import club.realtg.rtgdata.entity.Player;
import club.realtg.rtgdata.service.IPlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.domain.Specifications;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
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

    private final
    IPlayerService playerService;

    @Autowired
    public PlayerController(IPlayerService playerService) {
        this.playerService = playerService;
    }

    @RequestMapping(value = "list")
    public String gotoPlayerList(Model model) {
        String title = "球员列表";
        model.addAttribute("title",title);
//        model.addAttribute("players",playerService.getPlayerList());
        return "player/playerList";
    }

    @RequestMapping(value = "query")
    public void query(Model model, HttpServletRequest request, HttpServletResponse response,
                        int pageNo, int pageSize, String keyword) {
        pageNo--;//页面的pageNo以1为起始，后端是以0为起始
        Specifications newSpes = Specifications.where(new BaseSearch<Player>(new SearchDto("realName", "like", keyword)));
        Page<Player> players = playerService.findAll(newSpes, PageableUtil.basicPage(pageNo, pageSize, new SortDto("desc", "id")));
        writeSuccess(response, players);
    }

    @RequestMapping(value = "saveAddPlayer")
    public void saveAddPlayer(@ModelAttribute @Valid Player newPlayer, Errors errors, HttpServletResponse response, Model model) {
        if(errors.hasErrors()) {
            model.addAttribute("errors", errors.getAllErrors());
            return;
        }
        try {
            playerService.save(newPlayer);
            writeSuccess(response, newPlayer);
        } catch (Exception e) {
            e.printStackTrace();
            writeError(response, e.getMessage());
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
