package webapp;

import java.io.File;
import java.io.FileInputStream;
import java.nio.charset.Charset;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.csvreader.CsvReader;
import com.yijiaersan.webapp.model.Share;
import com.yijiaersan.webapp.services.ShareService;
import com.yijiaersan.webapp.utils.Sequence;

public class Csvfile {

	
	@Autowired
	private ShareService shareService;
	

	private ApplicationContext ac = null;
	
	@Before
	public void before() {
		ac = new ClassPathXmlApplicationContext("classpath:spring/spring-mybatis.xml");
		shareService = (ShareService) ac.getBean("shareService");
	}
	
	@Test
	public void testSharesList(){
		List<Share> shares = shareService.selectShareList();
		System.out.println(shares.size());
	}
	
	@Test
	public void testSelectVersion(){
		int t = shareService.selectVersion();
		System.out.println(t);
	}
	
	@Test
	public void testUpdateVersion(){
		shareService.updateVersion();
	}
	
	@Test
	public void readCsvToMysql(){
		try {
			readCsv("E:/股票代码大小写.csv","GB2312");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
     * 读取CVS文件
     * @param filePath   文件全路径
     * @param encode     文件编码
     * @throws Exception 
     */
    public  void readCsv(String filePath, String encode) throws Exception {

        File f = new File(filePath);
        
        FileInputStream fi = new FileInputStream(f);

        CsvReader cr = new CsvReader(fi, Charset.forName(encode));

        while (cr.readRecord()) {

            String[] rs = cr.getValues();
            
            Share record = new Share();
            Long id = Sequence.nextId();
            record.setSharesId(id);
            record.setSharesCode(rs[0]);
            record.setSharesName(rs[1]);
            record.setSharesPy(rs[2]);
            record.setVersion(1);
            record.setStockId(id);
            for (String s : rs) {
            	
                System.out.print("[" + s + "]");
            }
            
            int in = shareService.insert(record);
            int tmp =0;
            tmp =tmp +in;
            System.out.println(tmp);
            System.out.print("\n");
        }
        
        cr.close();
        fi.close();
    }
    
    public static void main(String[] args) {
    	try {
			//readCsv("E:/所有股票列表.csv","GB2312");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
