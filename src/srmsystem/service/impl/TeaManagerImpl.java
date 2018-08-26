package srmsystem.service.impl;

import java.util.ArrayList;
import java.util.List;
import srmsystem.dao.*;
import srmsystem.domain.*;
import srmsystem.service.*;
import srmsystem.vo.PaperBean;
import srmsystem.vo.ProjectBean;
import srmsystem.vo.TeacherBean;
//��ʦʵ����
public class TeaManagerImpl implements TeaManager{
	private AuditorDao audDao;
    private PaperDao paDao;
    private ProjectDao prDao;
    private RoleScoreDao rsDao;
    private TeacherDao teaDao;
    private UserDao userDao;
    
    
	public AuditorDao getAudDao() {
		return audDao;
	}

	public void setAudDao(AuditorDao audDao) {
		this.audDao = audDao;
	}

	public PaperDao getPaDao() {
		return paDao;
	}

	public void setPaDao(PaperDao paDao) {
		this.paDao = paDao;
	}

	public ProjectDao getPrDao() {
		return prDao;
	}

	public void setPrDao(ProjectDao prDao) {
		this.prDao = prDao;
	}

	public RoleScoreDao getRsDao() {
		return rsDao;
	}

	public void setRsDao(RoleScoreDao rsDao) {
		this.rsDao = rsDao;
	}

	public TeacherDao getTeaDao() {
		return teaDao;
	}

	public void setTeaDao(TeacherDao teaDao) {
		this.teaDao = teaDao;
	}

	public UserDao getUserDao() {
		return userDao;
	}

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

	@Override
	public int validLogin(User user) {
		
		return 0;
	}

	@Override
	public double markPaper(List<String> mem,int paLevel,String applicant) {
		double mark=0.0;
		int y=0;
		for(String m:mem){
			if(m.equals(applicant))
				y=1;
		}
		if(y==1){
			if((paLevel==1)&&(mem.size()<=1)&&(mem.size()>0)){
				mark=2.0;
			}else if((paLevel==2)&&(mem.size()<=2)&&(mem.size()>0)){
				mark=4.0;
			}else if((paLevel==3)&&(mem.size()<=3)&&(mem.size()>0)){
				mark=6.0;
			}else if((paLevel==4)&&(mem.size()<=4)&&(mem.size()>0)){
				mark=8.0;
			}
		}
		return mark;
	}	


	@Override
	/**
	 * ������Ŀ����
	 * @param prLevel��Ŀ����
	 * @param prFunding��Ŀ�ʽ�
	 * @return ��Ŀ�ܷ�
	 */
	public double markProject(List<String> mem,int prLevel, double prFunding,String applicant) {
		double mark=0.0;
		int y=0;
		for(String m:mem){
			if(m.equals(applicant))
				y=1;
		}
		if(y==1){
			if(prFunding<=100000.0){
				if(prLevel==3){
					mark=20.0;
				}else if(prLevel==2){
					mark=10.0;
				}else if(prLevel==1){
					mark=5.0;
				}
			}else if(prFunding<=500000.0){
				if(prLevel==3){
					mark=25.0;
				}else if(prLevel==2){
					mark=15.0;
				}else if(prLevel==1){
					mark=10.0;
				}
			}else if(prFunding<=1000000.0){
				if(prLevel==3){
					mark=30.0;
				}else if(prLevel==2){
					mark=20.0;
				}else if(prLevel==1){
					mark=15.0;
				}
			}else {
				if(prLevel==3){
					mark=35.0;
				}else if(prLevel==2){
					mark=25.0;
				}else if(prLevel==1){
					mark=20.0;
				}
			}
		}
		return mark;
	}
	@Override
	/**
	 * �жϽ�ʦ��������Ƿ���Ϲ���
	 * @param roleScoreÿ����Ա��Ӧ��������һ����Ӧһ�������������Ӧ��������
	 * @return ���Ϲ��򷵻�true������ false
	 */
	public boolean judgeAssignPaper(List<RoleScore> roleScore,double paperScore) {
		double sum=0;
		for(RoleScore rs:roleScore){
			sum=sum+rs.getScore();
		}
		if(sum!=paperScore){
			return false;
		}		
		for(int i=1;i<(roleScore.size());i++){
			if(roleScore.get(0).getScore()<=roleScore.get(i).getScore()){
				return false;
			}
		}
		return true;
	}	
	@Override
	/**
	 * �жϽ�ʦ��������Ƿ���Ϲ���
	 * @param roleScoreÿ����Ա��Ӧ����,��һ����Ӧ�����˷����������Ӧ�����߷���
	 * @param Score��Ŀ�ܷ�
	 * @return ���Ϲ��򷵻�true������ false
	 */
	public boolean judgeAssignProject(List<RoleScore> roleScore,double Score) {
		double sum=0;
		for(RoleScore rs:roleScore){
			sum=sum+rs.getScore();
		}
		if(sum!=Score){
			return false;
		}
		if((roleScore.get(0).getScore()<=Score*0.5)
				||(roleScore.get(0).getScore()>=Score*0.7)){	
			return false;
		}
		return true;
	}	
	@Override
	/**
	 * @param paName ��������
	 * @param paLevel ���ļ���
	 * @param paperScore ���ķ���
	 * @param paApplicant �걨�˱��
	 * @param paStatus ����״̬
	 * @param roleScore ��ɫ-������
	 * @return 1��ӳɹ���0���ʧ��
	 */
	public int savePaper(String paName,int paLevel,double paperScore,
			String paApplicant,int paStatus,List<RoleScore> roleScore) {
		if(judgeAssignPaper(roleScore,paperScore)==false){			
			return 0;
		}else{
		Paper p=new Paper();
		p.setPaName(paName);
		p.setPaLevel(paLevel);
		p.setPaScore(paperScore);
		p.setPaApplicant(paApplicant);
		p.setPaStatus(paStatus);
		for(RoleScore rs:roleScore){
			Teacher t=teaDao.findByName(rs.getTeacher().getTName());
			if(t!=null){
				rs.setTeacher(t);
				List<RoleScore> r=rsDao.find(t, rs.getTRole(), rs.getScore());
				
				if(r.size()>0){
					p.getRoleScore().add(r.get(0));	
				}else{
					rsDao.save(rs);
					p.getRoleScore().add(rs);
				}
			}
		}
		paDao.update(p);
		return 1;
		}
	}
	@Override
	/**
	 * @param prName ��Ŀ����
	 * @param prLevel ��Ŀ����
	 * @param prFunding ��Ŀ�ʽ�
	 * @param projectScore ��Ŀ����
	 * @param prApplicant �걨�˱��
	 * @param prStatus ��Ŀ״̬
	 * @param roleScore ��Ŀ��ɫ-������
	 * @return 1��ӳɹ���0���ʧ��
	 */
	public int saveProject(String prName,int prLevel,double prFunding,
			double projectScore,String prApplicant,int prStatus,List<RoleScore> roleScore) {
		if(judgeAssignProject(roleScore, projectScore)==false){
			return 0;
		}else{
			Project pr=new Project();
			pr.setPrName(prName);
			pr.setPrLevel(prLevel);
			pr.setPrFunding(prFunding);
			pr.setPrScore(projectScore);
			pr.setPrApplicant(prApplicant);
			pr.setPrStatus(prStatus);
			for(RoleScore rs:roleScore){
				Teacher t=teaDao.findByName(rs.getTeacher().getTName());
				if(t!=null){
					rs.setTeacher(t);
					List<RoleScore> r=rsDao.find(t, rs.getTRole(), rs.getScore());
					if(r.size()>0){
						pr.getRoleScore().add(r.get(0));	
					}else{
						rsDao.save(rs);
						pr.getRoleScore().add(rs);
					}
				}
			}
			prDao.save(pr);
			return 1;
		}
	}
	@Override
	/** 
	 * @param paName ��������
	 * @param paLevel ���ļ���
	 * @param paperScore ���ķ���
	 * @param paApplicant �걨�˱��
	 * @param paStatus ����״̬
	 * @param roleScore ��ɫ-������
	 * @return 1�ύ�ɹ���0�ύʧ��
	 */
	public int applyPaper(String paName,int paLevel,double paperScore,String paApplicant,
			int paStatus,List<RoleScore> roleScore) {
		Paper p=new Paper();
		if((judgeAssignPaper(roleScore,paperScore)==true)){			
			p.setPaName(paName);
			p.setPaLevel(paLevel);
			p.setPaScore(paperScore);
			p.setPaApplicant(paApplicant);
			p.setPaStatus(paStatus);			
			for(RoleScore rs:roleScore){
				Teacher t=teaDao.findByName(rs.getTeacher().getTName());
				if(t!=null){
					rs.setTeacher(t);
					List<RoleScore> r=rsDao.find(t, rs.getTRole(), rs.getScore());
					if(r.size()>0){
						p.getRoleScore().add(r.get(0));	
					}else{
						rsDao.save(rs);
						p.getRoleScore().add(rs);
					}
				}
			}
			paDao.save(p);
			return 1;
		}else{
			return 0;
		}
	}
	@Override
	/**
	 * @param prName ��Ŀ����
	 * @param prLevel ��Ŀ����
	 * @param prFunding ��Ŀ�ʽ�
	 * @param projectScore ��Ŀ����
	 * @param prApplicant �걨�˱��
	 * @param prStatus ��Ŀ״̬
	 * @param roleScore ��Ŀ��ɫ-������
	 * @return 1�ύ�ɹ���0�ύʧ��
	 */
	public int applyProject(String prName,int prLevel,double prFunding,double projectScore,
			String prApplicant,int prStatus,List<RoleScore> roleScore) {
		Project pr=new Project();
		if((judgeAssignProject(roleScore, projectScore)==true)){			
			pr.setPrName(prName);
			pr.setPrLevel(prLevel);
			pr.setPrFunding(prFunding);
			pr.setPrScore(projectScore);
			pr.setPrApplicant(prApplicant);
			pr.setPrStatus(1);
			for(RoleScore rs:roleScore){
				Teacher t=teaDao.findByName(rs.getTeacher().getTName());
				if(t!=null){
					rs.setTeacher(t);
					List<RoleScore> r=rsDao.find(t, rs.getTRole(), rs.getScore());
					if(r.size()>0){
						pr.getRoleScore().add(r.get(0));	
					}else{
						rsDao.save(rs);
						pr.getRoleScore().add(rs);
					}
				}
			}
			prDao.save(pr);
			return 1;
		}else{
			return 0;
		}	   
	}
	@Override
	/**
	 * 
	 * @param TID��ʦ���
	 * @return ��ʦ��Ϣ
	 */
	public List<TeacherBean> GetTeaScore(String TID) {
		List<Teacher> tea=teaDao.findByTIDList(TID);
		List<TeacherBean> result=new ArrayList<TeacherBean>();
		for(Teacher t: tea){
			result.add(new TeacherBean(t.getTID(), t.getTName(), t.getTScore()));	
		}
		return result;
	}
	
	@Override
	public List<PaperBean> findPaper(String paApplicant) {
		// TODO Auto-generated method stub
		List<Paper> paper=paDao.findBypaApplicant(paApplicant);
		List<PaperBean> result=new ArrayList<PaperBean>();
		for(Paper p:paper){
			result.add(new PaperBean(p.getPaID(),p.getPaName(),p.getPaLevel(),
					p.getPaScore(),p.getPaApplicant(),p.getPaStatus()));
		}
		return result;
	}

	@Override
	public List<ProjectBean> findProject(String prApplicant) {
		// TODO Auto-generated method stub
		List<Project> project=prDao.findByprApplicant(prApplicant);
		List<ProjectBean> result=new ArrayList<ProjectBean>();
		for(Project p:project){
			result.add(new ProjectBean(p.getPrID(),p.getPrName(),p.getPrLevel(),p.getPrFunding(),
					p.getPrScore(),p.getPrApplicant(),p.getPrStatus()));
		}
		return result;
	}

	@Override
	public List<PaperBean> findPaperScore(String TID) {
		// TODO Auto-generated method stub
		Teacher t=teaDao.findByTID(TID);
		List<RoleScore> roleScore=rsDao.findByTeacher(t);
		List<PaperBean> result=new ArrayList<PaperBean>();
		for(RoleScore rs:roleScore){
			List<Paper> paper=new ArrayList<>();
			paper.addAll(rs.getPaper());
			for(Paper p:paper){
				PaperBean pb=new PaperBean(p.getPaID(),p.getPaName(),p.getPaLevel(),
						p.getPaScore(),p.getPaApplicant(),p.getPaStatus());
				pb.getRoleScore().add(rs);
				result.add(pb);
			}
		}
		return result;
	}

	@Override
	public String findTID(String TName) {
		// TODO Auto-generated method stub
		String TID=teaDao.findByName(TName).getTID();
		return TID;
	}

	@Override
	public List<ProjectBean> findProjectScore(String TID) {
		// TODO Auto-generated method stub
		Teacher t=teaDao.findByTID(TID);
		List<RoleScore> roleScore=rsDao.findByTeacher(t);
		List<ProjectBean> result=new ArrayList<ProjectBean>();
		for(RoleScore rs:roleScore){
			List<Project> project=new ArrayList<>();
			project.addAll(rs.getProject());
			for(Project p:project){
				ProjectBean pb=new ProjectBean(p.getPrID(),p.getPrName(),p.getPrLevel(),p.getPrFunding(),
						p.getPrScore(),p.getPrApplicant(),p.getPrStatus());
				pb.getRoleScore().add(rs);
				result.add(pb);
			}
		}
		return result;
	}
}
