package com.yijiaersan.webapp.utils;

import com.taobao.api.ApiException;
import com.taobao.api.DefaultTaobaoClient;
import com.taobao.api.TaobaoClient;
import com.taobao.api.request.AlibabaAliqinFcSmsNumSendRequest;
import com.taobao.api.response.AlibabaAliqinFcSmsNumSendResponse;

public class SendSms {
	
	String  url = "http://gw.api.taobao.com/router/rest";
	String appkey = "23347732";
	String secret = "70a73c1fdef6a2f84ab7635f31a493df";

	public String sendSmsUtil(String code,String telphoneNum) throws ApiException{
		
		TaobaoClient client = new DefaultTaobaoClient(url, appkey, secret);
		AlibabaAliqinFcSmsNumSendRequest req = new AlibabaAliqinFcSmsNumSendRequest();
		req.setSmsType( "normal" );
		req.setSmsFreeSignName( "股市点金" );
		req.setSmsParamString( "{\"code\":\""+code+"\",\"product\":\"股市点金\"}" );
		req.setRecNum( telphoneNum );
		req.setSmsTemplateCode( "SMS_7025071" );
		AlibabaAliqinFcSmsNumSendResponse rsp = client.execute(req);
		System.out.println(rsp.getBody());
		return rsp.getBody();
	}
}
