package com.yijiaersan.webapp.controller;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.yijiaersan.webapp.model.Article;
import com.yijiaersan.webapp.model.ArticleList;
import com.yijiaersan.webapp.model.ArticleSharesRelation;
import com.yijiaersan.webapp.model.ArticleSharesRelations;
import com.yijiaersan.webapp.model.ArticleType;
import com.yijiaersan.webapp.model.DayReference;
import com.yijiaersan.webapp.model.QueryArticleReqParams;
import com.yijiaersan.webapp.model.QueryArticleRespModel;
import com.yijiaersan.webapp.model.ResponseModel;
import com.yijiaersan.webapp.model.SharesModel;
import com.yijiaersan.webapp.model.TokenInfo;
import com.yijiaersan.webapp.model.UserCollection;
import com.yijiaersan.webapp.model.UserInfo;
import com.yijiaersan.webapp.utils.DateUtil;
import com.yijiaersan.webapp.utils.JSONUtil;
import com.yijiaersan.webapp.utils.result.ResultEntity;
import com.yijiaersan.webapp.weblogic.ArticleWeblogic;
import com.yijiaersan.webapp.weblogic.StockWeblogic;
import com.yijiaersan.webapp.weblogic.TokenWeblogic;
import com.yijiaersan.webapp.weblogic.UserCollectionWeblogic;

@Controller
@RequestMapping({"/article"})
public class ArticleContorller
{

  @Resource
  private ArticleWeblogic articleWeblogic;

  @Resource
  private TokenWeblogic tokenWeblogic;

  @Resource
  private StockWeblogic StockWeblogic;

  @Resource
  private UserCollectionWeblogic userCollectionWeblogic;

  @RequestMapping({"/toArticleInfoPage"})
  public ModelAndView toArticleInfoPage(Long articleid, String token)
  {
    ModelAndView mav = new ModelAndView();

    if ((articleid == null) || (articleid.equals(""))) {
      mav.setViewName("index");
      return mav;
    }

    ResultEntity result = articleWeblogic.queryArticleDetail(articleid);
    ResponseModel rm = (ResponseModel)result.getRetContent();
    if (rm.getArticle() == null) {
      mav.setViewName("index");
      return mav;
    }
    Article article = rm.getArticle();

    SimpleDateFormat dateFormater = new SimpleDateFormat("yyyy-MM-dd HH:mm");
    Date date = DateUtil.fomatDateTime(article.getCreatDate());
    String dateStr = dateFormater.format(date);

    article.setcDate(dateStr);
    List shares = rm.getArticleSharesRelations();

    StockWeblogic sw = new StockWeblogic();

    List sharesModels = new ArrayList();

    if ((shares != null) && (shares.size() > 0))
    {
      for (int i = 0; i < shares.size(); ++i) {
        SharesModel sharesModel = new SharesModel();
        String sharesCode = ((ArticleSharesRelation)shares.get(i)).getSharesId();
        JSONObject jsonObject = sw.getStockInfoByStockId(sharesCode);
        JSONArray stockinfo = jsonObject.getJSONObject("retData").getJSONArray("stockinfo");
        JSONObject info = stockinfo.getJSONObject(0);

        String currentPrice = info.getString("currentPrice");
        String increase = info.getString("increase");
        String name = info.getString("name");
        String share = info.getString("code");

        BigDecimal bd = new BigDecimal(increase);
        bd = bd.setScale(2, 4);

        sharesModel.setCurrentPrice(currentPrice);
        sharesModel.setIncrease(bd.toString());
        sharesModel.setSharesCode(share);
        sharesModel.setSharesName(name);
        sharesModels.add(sharesModel);
      }
    }

    DayReference dr = rm.getDayReference();
    ArticleType articleType = rm.getArticleType();
    String isVip = article.getIsVipArticle();

    if (dr == null)
    {
      if (isVip.equals("1"))
      {
        if ((token == null) || (token.equals("")))
        {
          mav.setViewName("article/default_no");
        }
        else {
          TokenInfo tokenInfo = this.tokenWeblogic.selectTokenInfo(token);

          if (tokenInfo == null)
          {
            mav.setViewName("article/default_no");
          } else {
            String str = tokenInfo.getUserInfo();
            UserInfo userInfo = (UserInfo)JSONUtil.json2Bean(str, UserInfo.class);
            String userType = userInfo.getUserType();
            if (userType.equals("2")) {
              UserCollection userCollection = this.userCollectionWeblogic.selectUserCollection(articleid, userInfo.getUserId());
              if (userCollection != null)
                mav.addObject("isUserCollection", "0");
              else {
                mav.addObject("isUserCollection", "1");
              }
              mav.addObject("article", article);
              mav.addObject("sharesModels", sharesModels);
              mav.addObject("articleType", articleType);
              mav.setViewName("article/default_yes");
            }
            else {
              mav.setViewName("article/default_no");
            }
          }
        }
      }
      else
      {
        mav.addObject("article", article);
        mav.addObject("sharesModels", sharesModels);
        mav.addObject("articleType", articleType);
        mav.setViewName("article/default_yes");
      }

    }
    else if ((token == null) || (token.equals("")))
    {
      mav.setViewName("article/reference_no");
    } else {
      TokenInfo tokenInfo = this.tokenWeblogic.selectTokenInfo(token);
      if (tokenInfo == null)
      {
        mav.setViewName("article/reference_no");
      } else {
        String str = tokenInfo.getUserInfo();
        UserInfo userInfo = (UserInfo)JSONUtil.json2Bean(str, UserInfo.class);
        String userType = userInfo.getUserType();
        if (userType.equals("2")) {
          UserCollection userCollection = this.userCollectionWeblogic.selectUserCollection(articleid, userInfo.getUserId());
          if (userCollection != null)
            mav.addObject("isUserCollection", "0");
          else {
            mav.addObject("isUserCollection", "1");
          }
          mav.addObject("article", article);
          mav.addObject("sharesModels", sharesModels);
          mav.addObject("articleType", articleType);
          mav.addObject("dr", dr);
          mav.setViewName("article/reference_yes");
        }
        else
        {
          mav.setViewName("article/reference_no");
        }

      }

    }

    return mav;
  }

  @ResponseBody
  @RequestMapping({"/queryArticleDetail"})
  public ResultEntity queryArticleDetail(String token, Long articleid)
  {
    ResultEntity result = new ResultEntity();
    boolean tmp = false;

    if (articleid == null) {
      result.setRetCode("0");

      result.setRetMessage("文章id不能为空");
    }

    if (token != null) {
      TokenInfo tokenInfo = this.tokenWeblogic.selectTokenInfo(token);
      if (tokenInfo == null) {
        result.setRetCode("3");

        result.setRetMessage("用户登录信息失效");
        return result;
      }

      String str = tokenInfo.getUserInfo();
      UserInfo userInfo = (UserInfo)JSONUtil.json2Bean(str, UserInfo.class);

      UserCollection userCollection = this.userCollectionWeblogic.selectUserCollection(articleid, userInfo.getUserId());
      if (userCollection != null) {
        tmp = true;
      }
    }

    result = this.articleWeblogic.queryArticleDetail(articleid);
    result.setRetCode("1");
    result.setRetMessage("查询信息成功！");
    return result;
  }

  @RequestMapping({"/queryArticleList"})
  @ResponseBody
  public ResultEntity<List<ArticleList>> queryArticleList(String token)
  {
    ResultEntity result = new ResultEntity();

    result = this.articleWeblogic.queryArticleList();
    if (token != null) {
      TokenInfo tokenInfo = this.tokenWeblogic.selectTokenInfo(token);
      if (tokenInfo == null) {
        result.setRetCode("3");

        result.setRetMessage("用户登录信息失效");
        return result;
      }

      String str = tokenInfo.getUserInfo();
      UserInfo userInfo = (UserInfo)JSONUtil.json2Bean(str, UserInfo.class);
      List articleLists = (List)result.getRetContent();
      List articles = new ArrayList();

      for (int i = 0; i < articleLists.size(); ++i) {
        ArticleList articleList = (ArticleList)articleLists.get(i);
        UserCollection userCollection = this.userCollectionWeblogic.selectUserCollection(articleList.getArticleId(), userInfo.getUserId());
        if (userCollection != null)
          articleList.setIsCollection("1");
        else {
          articleList.setIsCollection("0");
        }

        if ((articleList.getIsVipArticle() != null) && (!articleList.getIsVipArticle().equals("")) && (articleList.getIsVipArticle().equals("1")))
        {
          List articleSharesRelationsList = new ArrayList();

          List ArticleSharesRelationss = articleList.getArticleSharesRelations();
          for (int j = 0; j < ArticleSharesRelationss.size(); ++j) {
            ArticleSharesRelations articleSharesRelations = (ArticleSharesRelations)ArticleSharesRelationss.get(j);
            if ((articleSharesRelations != null) && (articleSharesRelations.getSharesName() != null) && (!articleSharesRelations.getSharesName().equals(""))) {
              int length = articleSharesRelations.getSharesName().length() - 1;
              String s = "";
              for (int m = 0; m < length; ++m) {
                s = s + "*";
              }
              articleSharesRelations.setSharesName(articleSharesRelations.getSharesName().substring(0, 1) + s);
            }

            articleSharesRelationsList.add(articleSharesRelations);
          }

          articleList.setArticleSharesRelations(articleSharesRelationsList);
        }

        articles.add(articleList);
      }
      result.setRetContent(articles);
    }

    return result;
  }

  @RequestMapping({"/addArticle"})
  @ResponseBody
  public ResultEntity<String> addArticle(String token, String jsondata)
  {
    ResultEntity result = new ResultEntity();

    if (token == null) {
      result.setRetCode("3");

      result.setRetMessage("用户登录信息失效");
      return result;
    }
    TokenInfo tokenInfo = this.tokenWeblogic.selectTokenInfo(token);
    if (tokenInfo == null) {
      result.setRetCode("3");

      result.setRetMessage("用户登录信息失效");
      return result;
    }

    String str = tokenInfo.getUserInfo();
    UserInfo userInfo = (UserInfo)JSONUtil.json2Bean(str, UserInfo.class);
    result = this.articleWeblogic.insertArticleInfo(userInfo.getUserId(), jsondata);
    result.setRetCode("0");
    result.setRetContent(token);
    result.setRetMessage("ok");

    return result;
  }

  public List<QueryArticleRespModel> adminQueryArticleList(QueryArticleReqParams queryArticleReqParams)
  {
    return null;
  }
}