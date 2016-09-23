package webapp;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.yijiaersan.webapp.model.Article;
import com.yijiaersan.webapp.services.ArticleService;
import com.yijiaersan.webapp.utils.Sequence;

public class TestArticle {
	
	@Autowired
	private ArticleService articleService;
	

	private ApplicationContext ac = null;
	
	@Before
	public void before() {
		ac = new ClassPathXmlApplicationContext("classpath:spring/spring-mybatis.xml");
		articleService = (ArticleService) ac.getBean("articleService");
	}  
	  	
	@Test
	public void testInsertArticle() throws ParseException{
		SimpleDateFormat dfs = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date kindDate = dfs.parse("2019-11-12 12:12:12");
		Long articleId = Sequence.nextId();
		Article article = new Article();
		article.setArticleAuthor("张旭锋");
		article.setArticleContent("你好，这是测试文章");
		article.setArticleCoverUrl("http://localhost:8080/pic/10010/123.jpg");
		article.setArticleId(articleId);
		article.setArticleTitle("测试文章2非vip且不置顶");
		article.setArticleTypeId(1L);
		article.setAuditingFlag("1");// 0-未审核，1-已审核
		//article.setCreatDate(new Date());
		article.setIsDraft("1");// 0-草稿，1-非草稿
		article.setIsVipArticle("0");// 0-非vip，1-vip
		article.setKind("0"); // 0-不置顶，1-置顶
		//article.setKindDate(kindDate);
		article.setUserId(123L);
		articleService.insert(article);
	}
}
