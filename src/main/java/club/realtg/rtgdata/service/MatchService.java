package club.realtg.rtgdata.service;

import club.realtg.rtgdata.common.util.BaseSearch;
import club.realtg.rtgdata.common.util.PageableUtil;
import club.realtg.rtgdata.common.util.SearchDto;
import club.realtg.rtgdata.common.util.SortDto;
import club.realtg.rtgdata.entity.Match;
import club.realtg.rtgdata.repository.MatchRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.domain.Specifications;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

/**
 * Desc
 *
 * @author Papa Ray
 * Created on 2017-08-28
 */
@Service
public class MatchService {
    private final
    MatchRepository matchRepository;

    @Autowired
    public MatchService(MatchRepository matchRepository) {
        this.matchRepository = matchRepository;
    }

    public Page<Match> getMatchsPage(int pageNo, int pageSize, String keyword, String sortKey, String direction) {
        Specifications newSpes;
        newSpes = Specifications.where(new BaseSearch<Match>(new SearchDto("name", SearchDto.LIKE, keyword)))
                .or(new BaseSearch<>(new SearchDto("location", "like", keyword)));
        return matchRepository.findAll(newSpes, PageableUtil.basicPage(pageNo, pageSize, new SortDto(direction, sortKey)));
    }

    public Match getMatchById(int id) {
        return matchRepository.findOne(id);
    }

    public void saveMatch(Match match) throws Exception {
        matchRepository.save(match);
    }

    public void updateMatch(Match match) throws Exception {
        saveMatch(match);
    }

    public void removeMatches(String ids) {
        if (StringUtils.isEmpty(ids)) return;

        String[] idArry = ids.split(",");
        for (String strId : idArry) {
            matchRepository.delete(Integer.valueOf(strId.trim()));
        }
    }
}
