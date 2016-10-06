package com.yijiaersan.webapp.controller;

import java.util.Date;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;
import com.yijiaersan.webapp.model.SmsCode;
import com.yijiaersan.webapp.services.SmsCodeService;
import com.yijiaersan.webapp.utils.Code;
import com.yijiaersan.webapp.utils.SendSms;
import com.yijiaersan.webapp.utils.Sequence;
import com.yijiaersan.webapp.utils.result.ResultEntity;

@Controller
@RequestMapping("/commonSendSms")
public class CommonContorller {

	@Resource
	private SmsCodeService smsCodeService;

	@RequestMapping(value = "/sendSms", produces = "application/json;charset=UTF-8")
	@ResponseBody
	public ResultEntity<String> sendSms(String telphonenum) {
		ResultEntity<String> result = new ResultEntity<String>();
		try {
			SendSms sendSms = new SendSms();
			String resultSms = "";
			String code = Code.getRandNum(6); // 生成6位验证码
			resultSms = sendSms.sendSmsUtil(code, telphonenum);
			// resultSms = "{\"alibaba_aliqin_fc_sms_num_send_response\":
			// {\"result\": {\"err_code\": \"0\",\"model\":
			// \"101637153751^1102180248323\",\"success\": true},\"request_id\":
			// \"z2anxc5liyfl\"}}";
			if (!resultSms.equals("")) {
				Map aliResultMap = (Map) JSONObject.parseObject(resultSms)
						.get("alibaba_aliqin_fc_sms_num_send_response");
				if (aliResultMap != null) {
					Map resultMap = (Map) aliResultMap.get("result");
					if (resultMap != null) {
						String errCode = (String) resultMap.get("err_code");
						if (errCode.equals("0")) {
							SmsCode smsCode = new SmsCode();
							result.setRetCode("1");
							result.setRetMessage("发送成功");
							// result.setRetContent("");
						} else {
							result.setRetCode("0");
							result.setRetMessage("内部错误，发送失败");
							// result.setRetContent("");
							return result;
						}
					} else {
						result.setRetCode("0");
						result.setRetMessage("内部错误，发送失败");
						// result.setRetContent("");
						return result;
					}
				} else {
					result.setRetCode("0");
					result.setRetMessage("内部错误，发送失败");
					// result.setRetContent("");
					return result;
				}

			} else {
				result.setRetCode("0");
				result.setRetMessage("内部错误，发送失败");
				// result.setRetContent("");
				return result;
			}

			/*
			 * SmsCode sms = new SmsCode(); sms.setTelphone(telphonenum); sms =
			 * smsCodeService.selectSmsCode(sms);
			 */

			Long mainId = Sequence.nextId();

			SmsCode smsCode = new SmsCode();
			smsCode.setMainId(mainId);
			smsCode.setCode(code);
			smsCode.setTelphone(telphonenum);
			smsCode.setSendtime(new Date());
			// if(sms == null){

			smsCodeService.insert(smsCode);
			timerUtil(mainId);
			/*
			 * }else{ smsCodeService.updateSmsCode(smsCode);
			 * 
			 * }
			 */

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			result.setRetCode("0");
			result.setRetMessage("内部错误，发送失败");
			// result.setRetContent("");
		}
		return result;
	}

	public void timerUtil(Long mainId) {
		final Long id = mainId;
		Timer timer = new Timer();
		timer.schedule(new TimerTask() { // 要做的事情，在规则里面进行声明
			@Override
			public void run() {
				System.out.println(id);
				smsCodeService.deleteSmsCodeByMainId(id);
			}
		}, 60000);
	}

}
