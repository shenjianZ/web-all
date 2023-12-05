package com.aisi.headline.service;

import com.aisi.headline.pojo.NewsHeadline;
import com.aisi.headline.pojo.vo.HeadlineDetailVo;
import com.aisi.headline.pojo.vo.HeadlineQueryVo;

import java.util.Map;

public interface NewsHeadlineService {

    /**
     *
     * @param headlineQueryVo
     * @return
     */
    Map fingPage(HeadlineQueryVo headlineQueryVo);

    /**
     *
     * @param hid
     * @return
     */
    HeadlineDetailVo findHeadlineDetail(Integer hid);

    /**
     *
     * @param headline
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
     * @return
     */
    int update(NewsHeadline headline);

    /**
     *
     * @param hid
     * @return
     */
    int removeHeadlineByHid(Integer hid);
}
