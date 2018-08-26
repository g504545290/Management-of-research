package srmsystem.action;

import java.util.ArrayList;
import java.util.List;
import com.opensymphony.xwork2.ActionContext;
import srmsystem.action.base.AudBaseAction;
import srmsystem.vo.*;

public class ViewAudAction extends AudBaseAction{
	private String TID;
	private String paName;
	private String prName;
	private List <PaperBean> papers=new ArrayList<>();
	private List <ProjectBean> projects=new ArrayList<>();
	private List <TeacherBean> teachers=new ArrayList<>();
	
	public List<TeacherBean> getTeachers() {
		return teachers;
	}
	public void setTeachers(List<TeacherBean> teachers) {
		this.teachers = teachers;
	}
	public String getTID() {
		return TID;
	}
	public void setTID(String tID) {
		TID = tID;
	}
	
	public String getPaName() {
		return paName;
	}
	public void setPaName(String paName) {
		this.paName = paName;
	}
	public String getPrName() {
		return prName;
	}
	public void setPrName(String prName) {
		this.prName = prName;
	}
	//papers��set��get����
	public List<PaperBean> getPapers() {
		return papers;
	}
	public void setPapers(List<PaperBean> papers) {
		this.papers = papers;
	}

	
	
	
	//projects��set��get����
	public List<ProjectBean> getProjects() {
		return projects;
	}
	public void setProjects(List<ProjectBean> projects) {
		this.projects = projects;
	}
	
	
	public String viewbypaStatus() throws Exception{
		// ����ActionContextʵ��
		ActionContext ctx = ActionContext.getContext();
		// ����ҵ���߼����������û�����
		List<PaperBean> papers=audManager.findbypaStatus(1);
		setPapers(papers);
		return SUCCESS;
	}
	
	public String viewbyprStatus() throws Exception{
		// ����ActionContextʵ��
		ActionContext ctx = ActionContext.getContext();
		
		// ����ҵ���߼����������û�����
		List<ProjectBean> projects=audManager.findbyprStatus(1); 
		setProjects(projects);
		return SUCCESS;
	}
	public String viewbytea() throws Exception
	{
		// ����ActionContextʵ��
		ActionContext ctx = ActionContext.getContext();
		
		// ��ȡHttpSession�е�user����
		List<PaperBean> papers=audManager.findPaperbytea(TID);
		
		List<ProjectBean> projects=audManager.findProjectbytea(TID); 
		
		// ��ȡ��Ҫ����ǰ�������ȫ������
	    setPapers(papers);
	    setProjects(projects);
	    
	    return SUCCESS;
	
	}
	
	
	public String viewbypaname() throws Exception{
		// ����ActionContextʵ��
		ActionContext ctx = ActionContext.getContext();
			
		// ��ȡHttpSession�е�user����
		List<PaperBean> papers=audManager.findPaper(paName);
		setPapers(papers);
		
		return SUCCESS;
	}
	
	
	public String viewbyprname() throws Exception{
		// ����ActionContextʵ��
		ActionContext ctx = ActionContext.getContext();
		// ��ȡHttpSession�е�user����
		List<ProjectBean> projects=audManager.findProject(prName); 
		setProjects(projects);	
		return SUCCESS;
	}
	
	public String viewScore() throws Exception{
		// ����ActionContextʵ��
		ActionContext ctx = ActionContext.getContext();
		// ��ȡHttpSession�е�user����
		List<TeacherBean> teachers=audManager.sumTScore(); 
		
		setTeachers(teachers);	
		return SUCCESS;
	}
}
