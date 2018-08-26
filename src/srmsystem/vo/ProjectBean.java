package srmsystem.vo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import srmsystem.domain.RoleScore;

//��Ŀ

public class ProjectBean implements Serializable{
	private int prID;//��Ŀ���
	private String prName;//��Ŀ��Ŀ
	private int prLevel;//��Ŀ����
	private double prFunding;//��Ŀ����
	private double prScore;//��Ŀ����
	private String prApplicant;//�걨�˱��
	private int prStatus;//���״̬
	private List<RoleScore> roleScore=new ArrayList<>();//��ʦ��ɫ-����
	// �޲����Ĺ�����
	public void projectBean(){
		
	}
	// ��ʼ��ȫ����Ա�����Ĺ�����
	public ProjectBean(int prID, String prName, int prLevel, double prFunding, double prScore, String prApplicant,
			int prStatus) {
		super();
		this.prID = prID;
		this.prName = prName;
		this.prLevel = prLevel;
		this.prFunding = prFunding;
		this.prScore = prScore;
		this.prApplicant = prApplicant;
		this.prStatus = prStatus;
	}
	
	public ProjectBean(int prID, String prName, int prLevel, double prFunding, double prScore, String prApplicant,
			int prStatus, List<RoleScore> roleScore) {
		super();
		this.prID = prID;
		this.prName = prName;
		this.prLevel = prLevel;
		this.prFunding = prFunding;
		this.prScore = prScore;
		this.prApplicant = prApplicant;
		this.prStatus = prStatus;
		this.roleScore = roleScore;
	}
	//setter��getter����
	public int getPrID() {
		return prID;
	}

	public void setPrID(int prID) {
		this.prID = prID;
	}

	public String getPrName() {
		return prName;
	}

	public void setPrName(String prName) {
		this.prName = prName;
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

	public double getPrScore() {
		return prScore;
	}

	public void setPrScore(double prScore) {
		this.prScore = prScore;
	}

	public String getPrApplicant() {
		return prApplicant;
	}

	public void setPrApplicant(String prApplicant) {
		this.prApplicant = prApplicant;
	}

	public int getPrStatus() {
		return prStatus;
	}

	public void setPrStatus(int prStatus) {
		this.prStatus = prStatus;
	}
	public List<RoleScore> getRoleScore() {
		return roleScore;
	}
	public void setRoleScore(List<RoleScore> roleScore) {
		this.roleScore = roleScore;
	}
	
}
