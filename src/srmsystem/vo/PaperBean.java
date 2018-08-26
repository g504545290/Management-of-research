package srmsystem.vo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import srmsystem.domain.RoleScore;

//����

public class PaperBean implements Serializable{
	private int paID;//���ı��
	private String paName;//������Ŀ
	private int paLevel;//���ļ���
	private double paScore;//���ķ���
	private String paApplicant;//�걨�˱��
	private int paStatus;//���״̬
	private List<RoleScore> roleScore=new ArrayList<>();//��ʦ��ɫ-����
	// �޲����Ĺ�����
	public PaperBean() {
		super();
	}
	// ��ʼ��ȫ����Ա�����Ĺ�����
	public PaperBean(int paID, String paName, int paLevel, double paScore, String paApplicant, int paStatus) {
		super();
		this.paID = paID;
		this.paName = paName;
		this.paLevel = paLevel;
		this.paScore = paScore;
		this.paApplicant = paApplicant;
		this.paStatus = paStatus;
	}
	
	public PaperBean(int paID, String paName, int paLevel, double paScore, String paApplicant, int paStatus,
			List<RoleScore> roleScore) {
		super();
		this.paID = paID;
		this.paName = paName;
		this.paLevel = paLevel;
		this.paScore = paScore;
		this.paApplicant = paApplicant;
		this.paStatus = paStatus;
		this.roleScore = roleScore;
	}
	//setter��getter����
	public int getPaID() {
		return paID;
	}

	public void setPaID(int paID) {
		this.paID = paID;
	}

	public String getPaName() {
		return paName;
	}

	public void setPaName(String paName) {
		this.paName = paName;
	}

	public int getPaLevel() {
		return paLevel;
	}

	public void setPaLevel(int paLevel) {
		this.paLevel = paLevel;
	}

	public double getPaScore() {
		return paScore;
	}

	public void setPaScore(double paScore) {
		this.paScore = paScore;
	}

	public String getPaApplicant() {
		return paApplicant;
	}

	public void setPaApplicant(String paApplicant) {
		this.paApplicant = paApplicant;
	}

	public int getPaStatus() {
		return paStatus;
	}

	public void setPaStatus(int paStatus) {
		this.paStatus = paStatus;
	}
	public List<RoleScore> getRoleScore() {
		return roleScore;
	}
	public void setRoleScore(List<RoleScore> roleScore) {
		this.roleScore = roleScore;
	}
	
}
