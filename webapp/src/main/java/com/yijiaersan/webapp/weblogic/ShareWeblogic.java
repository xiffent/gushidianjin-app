package com.yijiaersan.webapp.weblogic;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import com.yijiaersan.webapp.model.Share;
import com.yijiaersan.webapp.model.ShareModel;
import com.yijiaersan.webapp.services.ShareService;

public class ShareWeblogic {

	@Resource
	private ShareService shareService;
	
	public List<ShareModel> selectShareList(){
		List<ShareModel> shareModels = new ArrayList<ShareModel>();
		List<Share> shares = new ArrayList<Share>();
		shares = shareService.selectShareList();
		
		for(int i=0;i<shares.size();i++){
			ShareModel sm = new ShareModel();
			Share share = shares.get(i);
			sm.setSharesCode(share.getSharesCode());
			sm.setSharesName(share.getSharesName());
			sm.setSharesPy(share.getSharesPy());
			shareModels.add(sm);
		}
		
		
		return shareModels;
		
	}
	/**
	 * 查询版本号
	 * @return
	 */
	public int selectVersion(){
		return shareService.selectVersion();
	}
	
}
