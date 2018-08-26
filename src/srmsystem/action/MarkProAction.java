package srmsystem.action;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.opensymphony.xwork2.ActionContext;

import srmsystem.action.base.TeaBaseAction;

public class MarkProAction extends TeaBaseAction{
	
	// ��װ��������count��Ա����
	private String prName;
	private int prLevel;
	private double prFunding;
	private String member;
	
	public String getPrName() {
		return prName;
	}
	public void setPrName(String prName) {
		this.prName = prName;
	}
	public String getMember() {
		return member;
	}
	public int getPrLevel() {
		return prLevel;
	}
	public void setPrLevel(int prLevel) {
		this.prLevel = prLevel;
	}
	public double getPrFunding() {
		return prFunding;
	}
	public void setPrFunding(double prFunding) {
		this.prFunding = prFunding;
	}
	public void setMember(String member) {
		this.member = member;
	}
	
	
	
	public String execute() throws Exception{
		// ����ActionContextʵ��
		ActionContext ctx = ActionContext.getContext();
				
		List<String> mem=new ArrayList<>();
		if(member!=null){
			String[] m=member.split("��");
			mem=Arrays.asList(m);
		}
		
		String applicant=(String) ctx.getSession().get("user");
		// ����ҵ���߼����������û�����
		double result =teaManager.markProject(mem,prLevel, prFunding,applicant);
		if(result >0){
			ctx.getSession().put("prMember",mem);
			ctx.getSession().put("prScore",result);
			ctx.getSession().put("prName",prName);
			ctx.getSession().put("prLevel",prLevel);
			ctx.getSession().put("prFunding",prFunding);
			return SUCCESS;	
		}else{
			return ERROR;
		}
	}
}