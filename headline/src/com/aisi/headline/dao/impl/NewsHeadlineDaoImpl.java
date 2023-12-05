package com.aisi.headline.dao.impl;

import com.aisi.headline.dao.BaseDao;

import com.aisi.headline.dao.NewsHeadLineDao;
import com.aisi.headline.pojo.NewsHeadline;
import com.aisi.headline.pojo.vo.HeadlineDetailVo;
import com.aisi.headline.pojo.vo.HeadlinePageVo;
import com.aisi.headline.pojo.vo.HeadlineQueryVo;

import java.util.ArrayList;
import java.util.List;

public class NewsHeadlineDaoImpl extends BaseDao implements  NewsHeadLineDao{

    /**
     * @param headlineQueryVo
     * @return
     */
    @Override
    public List<HeadlinePageVo> findPageList(HeadlineQueryVo headlineQueryVo) {
        List params=new ArrayList<HeadlinePageVo>();
        String sql= """
                select
                    hid,title,type,page_views pageViews, TIMESTAMPDIFF(HOUR,create_time,now()) pastHours,publisher
                from 
                    news_headline
                where is_deleted=0
                """;
        if(headlineQueryVo.getType()!=0){
            sql=sql.concat(" and type= ?");
            params.add(headlineQueryVo.getType());
        }
        if(headlineQueryVo.getKeyWords()!=null && !headlineQueryVo.getKeyWords().isEmpty()){
            sql= sql.concat(" and title like ? ");
            params.add("%" + headlineQueryVo.getKeyWords() + "%");
        }
        sql=sql.concat(" order by pastHours asc ,page_views desc ");
        sql=sql.concat("limit ? ,? ");
        params.add((headlineQueryVo.getPageNum()-1)*headlineQueryVo.getPageSize());
        params.add(headlineQueryVo.getPageSize());
        return baseQuery(HeadlinePageVo.class,sql,params.toArray());
    }

    /**
     * @param headlineQueryVo
     * @return
     */
    @Override
    public int findPageCount(HeadlineQueryVo headlineQueryVo) {
        List params=new ArrayList<HeadlinePageVo>();
        String sql= """
                select
                    count(1)
                from 
                    news_headline
                where is_deleted=0
                """;
        if(headlineQueryVo.getType()!=0){
            sql=sql.concat(" and type= ?");
            params.add(headlineQueryVo.getType());
        }
        if(headlineQueryVo.getKeyWords()!=null && !headlineQueryVo.getKeyWords().isEmpty()) {
            sql = sql.concat(" and title like ? ");
            params.add("%" + headlineQueryVo.getKeyWords() + "%");
        }
        return baseQueryObject(Long.class,sql,params.toArray()).intValue();
    }

    /**
     * @param hid
     * @return
     */
    @Override
    public int increasePageViews(Integer hid) {
        String sql= """
                update news_headline
                set page_views=page_views+1
                where hid=?
                """;
        return baseUpdate(sql,hid);
    }

    /**
     * @param hid
     * @return
     */
    @Override
    public HeadlineDetailVo findHeadlineDetail(Integer hid) {
        String sql= """
                select   
                    h.hid hid,
                    h.title title,
                    h.article article,
                    h.type type,
                    t.tname typeName,
                    h.page_views pageViews,
                    TIMESTAMPDIFF(HOUR,create_time,now()) pastHours,
                    h.publisher publisher,
                    u.nick_name author 
                from 
                    news_headline h
                left join 
                    news_type t
                on h.type=t.tid
                left join 
                    news_user u
                on h.publisher=u.uid
                where h.hid=?
                                  
                """;
        List<HeadlineDetailVo> headlineDetailVoList = baseQuery(HeadlineDetailVo.class, sql, hid);
        if(!(headlineDetailVoList==null) && !headlineDetailVoList.isEmpty())
            return headlineDetailVoList.get(0);
        else
            return null;
    }

    /**
     * @param headline
     * @return
     */
    @Override
    public int addNewsHeadline(NewsHeadline headline) {
        String sql= """
                insert into
                    news_headline
                values
                    (DEFAULT,?,?,?,?,0,NOW(),NOW(),0)
                  
                """;
        int rows;
        rows = baseUpdate(sql,headline.getTitle(),headline.getArticle(),headline.getType(),headline.getPublisher());
        return rows;
    }

    /**
     * @param hid
     * @return
     */
    @Override
    public NewsHeadline findHeadlineByHid(Integer hid) {
        String sql= """
               select 
                     hid,
                     title,
                     article,
                     type,
                     publisher,
                     page_views pageViews, 
                     create_time createTime,
                     update_time updateTime,
                     is_deleted isDeleted 
               from 
                     news_headline 
               where hid=?                     
                """;
        List<NewsHeadline> headlineList = baseQuery(NewsHeadline.class,sql,hid);
        if(!(headlineList==null) && !headlineList.isEmpty())
            return headlineList.get(0);
        else
            return null;
    }

    /**
     * @param headline
     */
    @Override
    public int update(NewsHeadline headline) {
        String sql= """
                update 
                    news_headline
                set 
                    title=?,
                    article=?,
                    type=?,
                    update_time=now()
                where
                    hid=?

                """;
        return baseUpdate(sql,headline.getTitle(),headline.getArticle(),headline.getType(),headline.getHid());
    }

    /**
     * @param hid
     * @return
     */
    @Override
    public int removeHeadlineByHid(Integer hid) {
        String sql = """
                UPDATE news_headline
                SET is_deleted = 1,update_time=now()
                where hid=?
                """;
        return baseUpdate(sql,hid);
    }
}
