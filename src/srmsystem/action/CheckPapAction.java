package srmsystem.action;

import java.util.List;
import com.opensymphony.xwork2.ActionContext;
import srmsystem.action.base.AudBaseAction;
import srmsystem.vo.PaperBean;
import srmsystem.vo.ProjectBean;
import static srmsystem.service.AudManager.*;


public class CheckPapAction extends AudBaseAction{
	private int paID;
	private String result;
	
	public String getResult() {
		return result;
	}
	public void setResult(String result) {
		this.result = result;
	}
	public int getPaID() {
		return paID;
	}
	public void setPaID(int paID) {
		this.paID = paID;
	}
	public String check() throws Exception
	{	
		// ����ActionContextʵ��
		ActionContext ctx = ActionContext.getContext();
			
		// ��ȡHttpSession�е�user����
		if (result.equals("pass"))
		{
			audManager.checkPaper(paID, true);
		}
		// �ܾ�����
		else if (result.equals("deny"))
		{
			audManager.checkPaper(paID, false);
		}
		else
		{
			throw new Exception("������ʧ");
		}	
	    return SUCCESS;
	}





}
	
	
	
	
	

