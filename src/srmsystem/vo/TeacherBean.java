package srmsystem.vo;

import java.io.Serializable;

//��ʦ

public class TeacherBean implements Serializable{
	private String TID;//��ʦ���
	private String TName;//����
	private double TScore;//����
	// �޲����Ĺ�����
	public TeacherBean() {
			super();
	}
	// ��ʼ��ȫ����Ա�����Ĺ�����
	public TeacherBean(String tID, String tName, double tScore) {
		super();
		TID = tID;
		TName = tName;
		TScore = tScore;
	}
   
	//setter��getter����
	public String getTID() {
		return TID;
	}

	public void setTID(String tID) {
		TID = tID;
	}

	public String getTName() {
		return TName;
	}

	public void setTName(String tName) {
		TName = tName;
	}

	public double getTScore() {
		return TScore;
	}

	public void setTScore(double tScore) {
		TScore = tScore;
	}
	
	
}
