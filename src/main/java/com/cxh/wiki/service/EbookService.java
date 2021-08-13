package com.cxh.wiki.service;

import com.cxh.wiki.domain.Ebook;
import com.cxh.wiki.domain.EbookExample;
import com.cxh.wiki.mapper.EbookMapper;
import com.cxh.wiki.req.EbookReq;
import com.cxh.wiki.resp.EbookResp;
import com.cxh.wiki.util.CopyUtil;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
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

//        List<EbookResp> respList = new ArrayList<>();//一些敏感字段不希望返回给前端,故创建排除敏感字段的类EbookResq
//        for (Ebook ebook : ebookList) {
//            EbookResp ebookResp = new EbookResp();
//            //元素复制
//            EbookResp copy = CopyUtil.copy(ebook, EbookResp.class);
//            respList.add(copy);
//        }
        //列表复制
        List<EbookResp> respList = CopyUtil.copyList(ebookList, EbookResp.class);
        return respList;
    }
}
