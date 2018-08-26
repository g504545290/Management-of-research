package srmsystem.action;

import com.opensymphony.xwork2.ActionContext;
import srmsystem.action.base.AudBaseAction;
import srmsystem.domain.User;
import srmsystem.service.AudManager;
import static srmsystem.service.AudManager.*;

public class LoginAction extends AudBaseAction{
	// ����һ��������Ϊ���Ա��¼�ɹ���Result��
	private final String AUD_RESULT = "aud";
	// ����һ��������Ϊ��ʦ��¼�ɹ���Result��
	private final String TEA_RESULT = "tea";
	// ��װ�������
	private User user;
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	// �����û�����
	public String execute()
		throws Exception
	{
		// ����ActionContextʵ��
		ActionContext ctx = ActionContext.getContext();
		// ����ҵ���߼������������¼����			
		int result = audManager.validLogin(getUser());
		//int result = LOGIN_TEA;
		// ��¼���Ϊ���Ա
		if (result == LOGIN_AUD)
		{
			ctx.getSession().put(WebConstant.USER
				, audManager.findAName(user.getUID()));
			ctx.getSession().put(WebConstant.LEVEL
				, WebConstant.AUD_LEVEL);
			addActionMessage("���Ѿ��ɹ���¼ϵͳ");
			return AUD_RESULT;
		}
		// ��¼���Ϊ��ʦ
		else if (result == LOGIN_TEA)
		{
			ctx.getSession().put(WebConstant.USER
				, audManager.findTName(user.getUID()));
			ctx.getSession().put(WebConstant.LEVEL
				, WebConstant.TEA_LEVEL);
			addActionMessage("���Ѿ��ɹ���¼ϵͳ");
			return TEA_RESULT;
		}
		// �û��������벻ƥ��
		else
		{
			addActionMessage("�û���/���벻ƥ��");
			return ERROR;
		}
	}

}
