package srmsystem.action.base;

import com.opensymphony.xwork2.ActionSupport;
import srmsystem.service.AudManager;

/**
 * Description:
 * <br/>��վ: <a href="http://www.crazyit.org">���Java����</a>
 * <br/>Copyright (C), 2001-2016, Yeeku.H.Lee
 * <br/>This program is protected by copyright laws.
 * <br/>Program Name:
 * <br/>Date:
 * @author  Yeeku.H.Lee kongyeeku@163.com
 * @version  1.0
 */
public class AudBaseAction extends ActionSupport
{
	// ������ҵ���߼����
	protected AudManager audManager;
	// ����ע��ҵ���߼�����������setter����

	public AudManager getAudManager() {
		return audManager;
	}

	public void setAudManager(AudManager audManager) {
		this.audManager = audManager;
	}
	
	
}