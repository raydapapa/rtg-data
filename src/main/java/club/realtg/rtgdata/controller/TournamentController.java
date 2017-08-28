package club.realtg.rtgdata.controller;

import club.realtg.rtgdata.entity.Tournament;
import club.realtg.rtgdata.service.TournamentService;
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
 * Controller for Tournament
 *
 * @author Papa Ray
 * Created on 2017-08-28
 */
@Controller
public class TournamentController extends BaseController {

    @Resource
    private TournamentService tournamentService;

    @RequestMapping(value = "tournamentList")
    public String gotoTournamentList(Model model) {
        String title = "赛事列表";
        model.addAttribute("title",title);
        return "biz/tournamentList";
    }

    @RequestMapping(value = "queryTournament")
    public void query(HttpServletResponse response, int pageNo, int pageSize, String keyword, String sortKey, String direction) {
        try {
            Page<Tournament> tournaments = tournamentService.getTournamentsPage(pageNo, pageSize, keyword, sortKey, direction);
            writeSuccess(response, tournaments);
        } catch (Exception e) {
            e.printStackTrace();
            writeError(response, e.getMessage());
        }
    }

    @RequestMapping(value = "saveTournament")
    public void saveAddTournament(@ModelAttribute @Valid Tournament tournament, Errors errors, HttpServletResponse response, Model model) {
        if(errors.hasErrors()) {
            model.addAttribute("errors", errors.getAllErrors());
            return;
        }
        try {
            tournamentService.saveTournament(tournament);
            writeSuccess(response, tournament);
        } catch (Exception e) {
            e.printStackTrace();
            writeError(response, e.getMessage());
        }
    }

    @RequestMapping(value = "updateTournament")
    public void saveUpdateTournament(@ModelAttribute @Valid Tournament tournament, Errors errors, HttpServletResponse response, Model model) {
        if(errors.hasErrors()) {
            model.addAttribute("errors", errors.getAllErrors());
            return;
        }
        try {
            tournamentService.updateTournament(tournament);
            writeSuccess(response, tournament);
        } catch (Exception e) {
            e.printStackTrace();
            writeError(response, e.getMessage());
        }
    }

    @RequestMapping(value = "removeTournaments")
    public void removeTournaments(HttpServletResponse response, String ids){
        try {
            tournamentService.removeTournaments(ids);
            writeSuccess(response);
        } catch (Exception e) {
            e.printStackTrace();
            writeError(response, e.getMessage());
        }
    }
}
