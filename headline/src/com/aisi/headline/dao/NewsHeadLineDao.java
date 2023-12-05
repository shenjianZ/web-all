package com.aisi.headline.dao;

import com.aisi.headline.pojo.NewsHeadline;
import com.aisi.headline.pojo.vo.HeadlineDetailVo;
import com.aisi.headline.pojo.vo.HeadlinePageVo;
import com.aisi.headline.pojo.vo.HeadlineQueryVo;

import java.util.List;

public interface NewsHeadLineDao {

    /**
     *
     * @param headlineQueryVo
     * @return
     */
    List<HeadlinePageVo> findPageList(HeadlineQueryVo headlineQueryVo);

    /**
     *
     * @param headlineQueryVo
     * @return
     */
    int findPageCount(HeadlineQueryVo headlineQueryVo);

    /**
     * @param hid
     * @return
     */
    int increasePageViews(Integer hid);

    /**
     *
     * @param hid
     * @return
     */
    HeadlineDetailVo findHeadlineDetail(Integer hid);

    /**
     *
     * @param headline
     * @return
     */
    int addNewsHeadline(NewsHeadline headline);

    /**
     *
     * @param hid
     * @return
     */
    NewsHeadline findHeadlineByHid(Integer hid);

    /**
     *
     * @param headline
     */
    int update(NewsHeadline headline);

    /**
     *
     * @param hid
     * @return
     */
    int removeHeadlineByHid(Integer hid);
}
