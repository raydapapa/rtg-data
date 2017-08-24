package club.realtg.rtgdata.controller;

import club.realtg.rtgdata.common.util.BaseSearch;
import club.realtg.rtgdata.common.util.PageableUtil;
import club.realtg.rtgdata.common.util.SearchDto;
import club.realtg.rtgdata.common.util.SortDto;
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
        return "player/playerList";
    }

    @RequestMapping(value = "query")
    public void query(HttpServletResponse response, int pageNo, int pageSize, String keyword) {
        Specifications newSpes = Specifications.where(new BaseSearch<Player>(new SearchDto("realName", "like", keyword)));
        Page<Player> players = playerService.findAll(newSpes, PageableUtil.basicPage(pageNo, pageSize, new SortDto(SortDto.ASC, "kitNumber")));
        writeSuccess(response, players);
    }

    @RequestMapping(value = "savePlayer")
    public void savePlayer(@ModelAttribute @Valid Player newPlayer, Errors errors, HttpServletResponse response, Model model) {
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

    @RequestMapping(value = "removePlayers")
    public void removePlayers(HttpServletResponse response, String ids){
        if(ids==null) return;
        String[] idArry = ids.split(",");
        try {
            for(String strId : idArry) {
                playerService.delete(Integer.valueOf(strId.trim()));
            }
            writeSuccess(response);
        } catch (Exception e) {
            e.printStackTrace();
            writeError(response, e.getMessage());
        }
    }
}
