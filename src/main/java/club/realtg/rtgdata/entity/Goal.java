package club.realtg.rtgdata.entity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;

/**
 * 进球实体类
 *
 * @author Papa Ray
 * Created on 2017-08-28
 */
@Entity
@Table(name = "t_goal")
public class Goal {

    /**
     * ID
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    /**
     * 记录创建时间
     */
    @Temporal(TemporalType.TIMESTAMP)
    @Column(updatable = false)
    @org.hibernate.annotations.CreationTimestamp
    private Date ctime;

    /**
     * 记录更新时间
     */
    @Temporal(TemporalType.TIMESTAMP)
    @org.hibernate.annotations.UpdateTimestamp
    private Date mtime;

    /** 所属比赛ID */
    @NotNull
    private int matchId;

    /** 进球球队ID（为空表示我方进球） */
    private int teamId;

    /** 进球球员ID */
    private int scorerId;

    /** 助攻球员ID */
    private int assisterId;

    /** 进球时间（第几分钟） */
    private int goalMinute;

    /** 进球时间分类（1：上半时进球，2：下半时进球，3：加时赛进球，4：点球大战进球） */
    private int goalTimeType;

    /** 进球方式分类（1：运动战进球，2：角球进球，3：任意球进球，4：点球进球） */
    private int goalManner;

    /** 备注 */
    private String goalNote;

    public Goal() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Date getCtime() {
        return ctime;
    }

    public void setCtime(Date ctime) {
        this.ctime = ctime;
    }

    public Date getMtime() {
        return mtime;
    }

    public void setMtime(Date mtime) {
        this.mtime = mtime;
    }

    public int getMatchId() {
        return matchId;
    }

    public void setMatchId(int matchId) {
        this.matchId = matchId;
    }

    public int getTeamId() {
        return teamId;
    }

    public void setTeamId(int teamId) {
        this.teamId = teamId;
    }

    public int getScorerId() {
        return scorerId;
    }

    public void setScorerId(int scorerId) {
        this.scorerId = scorerId;
    }

    public int getAssisterId() {
        return assisterId;
    }

    public void setAssisterId(int assisterId) {
        this.assisterId = assisterId;
    }

    public int getGoalMinute() {
        return goalMinute;
    }

    public void setGoalMinute(int goalMinute) {
        this.goalMinute = goalMinute;
    }

    public int getGoalTimeType() {
        return goalTimeType;
    }

    public void setGoalTimeType(int goalTimeType) {
        this.goalTimeType = goalTimeType;
    }

    public int getGoalManner() {
        return goalManner;
    }

    public void setGoalManner(int goalManner) {
        this.goalManner = goalManner;
    }

    public String getGoalNote() {
        return goalNote;
    }

    public void setGoalNote(String goalNote) {
        this.goalNote = goalNote;
    }
}
