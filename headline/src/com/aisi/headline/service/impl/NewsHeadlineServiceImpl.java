package com.aisi.headline.service.impl;

import com.aisi.headline.dao.NewsHeadLineDao;
import com.aisi.headline.dao.impl.NewsHeadlineDaoImpl;
import com.aisi.headline.pojo.NewsHeadline;
import com.aisi.headline.pojo.vo.HeadlineDetailVo;
import com.aisi.headline.pojo.vo.HeadlinePageVo;
import com.aisi.headline.pojo.vo.HeadlineQueryVo;
import com.aisi.headline.service.NewsHeadlineService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class NewsHeadlineServiceImpl implements NewsHeadlineService {
    private NewsHeadLineDao headLineDao = new NewsHeadlineDaoImpl();

    /**
     *
     * Pageinfo:{
     *     pageData:[
     *     {
     *         hId:1,
     *         title:"标题",
     *         type:"1",
     *         pageViews:"40",
     *         pageHours:"3",
     *         publisher:"1",
     *      },
     *     ],
     *     pageNum:1,
     *     pageSize:1,
     *     totalPage:1,
     *     totalSize:1
     * }
     * @param headlineQueryVo
     * @return
     */
    @Override
    public Map fingPage(HeadlineQueryVo headlineQueryVo) {
        int pageNum=headlineQueryVo.getPageNum();
        int pageSize=headlineQueryVo.getPageSize();
        List<HeadlinePageVo> pageData = headLineDao.findPageList(headlineQueryVo);
        int totalSize = headLineDao.findPageCount(headlineQueryVo);
        int totalPage = totalSize%pageSize==0?totalSize/pageSize:totalSize/pageSize+1;
        Map pageInfo = new HashMap<>();
        pageInfo.put("pageData",pageData);
        pageInfo.put("pageNum",pageNum);
        pageInfo.put("pageSize",pageSize);
        pageInfo.put("totalPage",totalPage);
        pageInfo.put("totalSize",totalSize);
        return pageInfo;
    }

    /**
     * @param hid
     * @return
     */
    @Override
    public HeadlineDetailVo findHeadlineDetail(Integer hid) {
        headLineDao.increasePageViews(hid);
        return headLineDao.findHeadlineDetail(hid);
    }

    /**
     * @param headline
     */
    @Override
    public int addNewsHeadline(NewsHeadline headline) {
        return headLineDao.addNewsHeadline(headline);
    }

    /**
     * @param hid
     * @return
     */
    @Override
    public NewsHeadline findHeadlineByHid(Integer hid) {
        return headLineDao.findHeadlineByHid(hid);
    }

    /**
     * @param headline
     */
    @Override
    public int update(NewsHeadline headline) {
        return headLineDao.update(headline);
    }

    /**
     * @param hid
     * @return
     */
    @Override
    public int removeHeadlineByHid(Integer hid) {
        return headLineDao.removeHeadlineByHid(hid);
    }
}
