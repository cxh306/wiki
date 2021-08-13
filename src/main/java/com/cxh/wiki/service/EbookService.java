package com.cxh.wiki.service;

import com.cxh.wiki.domain.Ebook;
import com.cxh.wiki.domain.EbookExample;
import com.cxh.wiki.mapper.EbookMapper;
import com.cxh.wiki.req.EbookReq;
import com.cxh.wiki.resp.EbookResp;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Service
public class EbookService {

    @Resource
    private EbookMapper ebookMapper;

    public List<EbookResp> list(EbookReq req){
        EbookExample ebookExample = new EbookExample();
        EbookExample.Criteria criteria = ebookExample.createCriteria();
        criteria.andNameLike("%"+req.getName()+"%");
        List<Ebook> ebookList = ebookMapper.selectByExample(ebookExample);//数据库字段对象Ebook

        List<EbookResp> respList = new ArrayList<>();//一些敏感字段不希望返回给前端,故创建排除敏感字段的类EbookResq
        for (Ebook ebook : ebookList) {
            EbookResp ebookResp = new EbookResp();
            BeanUtils.copyProperties(ebook,ebookResp);//解放set properties地狱
            respList.add(ebookResp);
        }
        return respList;
    }
}
